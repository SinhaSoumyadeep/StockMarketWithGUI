package controller;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import model.DollarCostAverageStrategy;
import model.InvestModelInterfaceNew;
import model.InvestmentModelNew;
import model.InvestmentStrategyInterface;
import properties.PropertiesLoader;
import transferable.PortfolioTransferable;
import utility.DateUtility;
import utility.Options;
import view.GraphPlotter;
import view.InvestmentGUIInterface;
import view.InvestmentViewInterface;

public class Controller extends AbstractController implements Features{

  protected InvestmentGUIInterface view;

  public Controller(InvestModelInterfaceNew model, InvestmentViewInterface v)
  {
    try{
      this.model = retrieveData();
    }
    catch (Exception e){
      System.out.println("in catch: loading a new model!");
      this.model = model;
    }

    view = (InvestmentGUIInterface) v;

  }

  /**
   * Start the stock market where the user of the application can buy stocks, create portfolio, view
   * the composition of the portfolio. the user can quit the application at any point.
   *
   * @throws ParseException if the date comparision fails.
   */
  @Override
  public void startStockMarket() throws ParseException {

    view.updatePortfolioOption(model.getPortfolioNames());
    view.setFeatures(this);

  }


  @Override
  public void createPortfolio(String portfolioName) {

    model.createNewPortfolio(portfolioName);
    view.updatePortfolioOption(model.getPortfolioNames());
    view.displayMessage("Success", "you successfully created portfolio: "+portfolioName);


  }

  @Override
  public void buyStocks(String ticker, String timeStamp, String numberOfShares, String commission,
                        String portfolioName){
    try {
      model.buyStocks(ticker.trim(),timeStamp.trim(),Double.parseDouble(numberOfShares.trim()),portfolioName.trim(),commission.trim());
      view.displayMessage("Success", "Thank you for buying : "+ticker);
    }
    catch (Exception e)
    {
      view.displayMessage("Error", e.getMessage());
    }

  }

  @Override
  public PortfolioTransferable viewDetailedStocks(String portfolioName, String timeStamp) {

    PortfolioTransferable p = null;
    try {
      p = model.evaluatePortfolio(portfolioName,timeStamp);
    } catch (Exception e) {
      view.displayMessage("Error", e.getMessage());
    }

    return p;
  }

  @Override
  public void investStocks(String portfolioName, String fixedAmount, String timeStamp, String commission) {

    try {
      model.investStocks(portfolioName,Double.parseDouble(fixedAmount),timeStamp,commission);
    } catch (ParseException e) {
      view.displayMessage("Error", e.getMessage());
    }

  }

  @Override
  public void investStocks(String portfolioName, String fixedAmount, String weights, String timeStamp, String commission) {

    try {
      model.investStocks(portfolioName,Double.parseDouble(fixedAmount),weightsToWeightsHashMapConverter(weights),timeStamp,commission);
    } catch (ParseException e) {
      view.displayMessage("Error", e.getMessage());
    }
  }

  @Override
  public List<String> getStocksInPortfolio(String portfolioName){

    List<String> display = new ArrayList<>();
    try {
      display = model.getStocksInPortfolio(portfolioName);
    } catch (Exception e) {

      view.displayMessage("Error", e.getMessage());
    }
    return display;

  }

  @Override
  public void saveModel() {
    try {
      saveData();
      terminate();
    } catch (IOException e) {
      view.displayMessage("Error", e.getMessage());
    }
  }

  @Override
  public void terminate() {
    System.exit(0);
  }



  @Override
  public void implementStrategy(String portfolioName, String fixedAmount, String startDate, String endDate, String frequency, String commission, String weights) {

      InvestmentStrategyInterface da = new DollarCostAverageStrategy(Double.parseDouble(fixedAmount),
              startDate, endDate, Integer.parseInt(frequency), commission);
      model.registerStrategy(da, portfolioName,weightsToWeightsHashMapConverter(weights));

  }

  @Override
  public void plotGraph(String portfolioName, String startDate, String endDate, String frequency )  {
    frequency = frequency.trim();
    GraphPlotter chart = new GraphPlotter("Total Valueation of "+portfolioName );
    chart.plotGraph(createDataset(portfolioName,startDate,endDate,Integer.parseInt(frequency)), portfolioName);
    chart.pack();
    RefineryUtilities.centerFrameOnScreen( chart );
    chart.setVisible( true );
  }

  private DefaultCategoryDataset createDataset(String portfolioName, String startDate, String endDate, Integer frequency ) {
    DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
    DateUtility du = new DateUtility();
    LocalDate sDate = du.stringToDateConverter(startDate);
    LocalDate eDate = du.stringToDateConverter(endDate);
    LocalDate next = sDate;

    while(next.isEqual(eDate) || next.isBefore(eDate)){
      dataset.addValue( model.evaluatePortfolio(portfolioName,next.toString()).getTotalValue() , "stockValue" , next.toString() );
      next = next.plusDays(frequency);
    }

    return dataset;
  }

  private HashMap<String, Double> weightsToWeightsHashMapConverter(String weights){
    HashMap<String,Double> weightsMap = new HashMap<String,Double>();
    StringTokenizer token = new StringTokenizer(weights, ",");

    while (token.hasMoreTokens())
    {
      StringTokenizer token2 = new StringTokenizer(token.nextToken().toString().trim()," ");
      weightsMap.put(token2.nextToken(),Double.parseDouble(token2.nextToken()));
    }

    return weightsMap;

  }





}
