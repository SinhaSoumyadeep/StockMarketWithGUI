package controller;


import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;


import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import model.DollarCostAverageStrategy;
import model.InvestModelInterfaceNew;
import model.InvestmentStrategyInterface;
import transferable.PortfolioTransferable;
import utility.DateUtility;
import view.GraphPlotter;
import view.InvestmentGUIInterface;
import view.InvestmentViewInterface;

/**
 * This class is a concrete implementation of the AbstractController. This Class acts as a
 * controller for the GUI based User interface.This method provides a method where a user can start
 * the application and buy stocks, view composition of portfolios, create portfolios, invest fixed
 * amount in stocks with weights distributed equally or set individually depending on the need of
 * the user.This controller acts as a mediatr between the model and the view. A channel through
 * which the model and the view interact with each other.This controller also allows the user to
 * persist the transactions including high term strategies, portfolios and stock bought in a
 * diskfile which is configurable in the configuration file of the application.
 */
public class Controller extends AbstractController implements Features {

  protected InvestmentGUIInterface view;

  public Controller(InvestModelInterfaceNew model, InvestmentViewInterface v) {
    try {
      this.model = retrieveData();
    } catch (Exception e) {
      this.model = model;
    }

    view = (InvestmentGUIInterface) v;

  }

  /**
   * Start the stock market where the user of the application can buy stocks, create portfolio, view
   * the composition of the portfolio, The user can also choose to invest in various portfolio for a
   * single time or register the portfolio for a high level strategy. the user can quit the
   * application at any point.
   *
   * @throws ParseException if the date comparision fails.
   */
  @Override
  public void startStockMarket() throws ParseException {

    view.updatePortfolioOption(model.getPortfolioNames());
    view.setFeatures(this);

  }

  /**
   * This method helps to create a new portfolio for the user. this method takes in a portfolio name
   * an creates a new portfolio for the user.
   *
   * @param portfolioName the portfolio name.
   */
  @Override
  public void createPortfolio(String portfolioName) {

    model.createNewPortfolio(portfolioName);
    view.updatePortfolioOption(model.getPortfolioNames());
    view.displayMessage("Success", "you successfully created portfolio: " + portfolioName);


  }

  /**
   * This method takes in a ticker sybol, timestamp, number of shares, commission fee and portfolio
   * name to buy the stock specified by the user.
   *
   * @param ticker         the ticker symbol.
   * @param timeStamp      timestamp.
   * @param numberOfShares number of shares.
   * @param commission     commission fee.
   * @param portfolioName  portfolio name.
   */
  @Override
  public void buyStocks(String ticker, String timeStamp, String numberOfShares, String commission,
                        String portfolioName) {
    try {
      model.buyStocks(ticker.trim(), timeStamp.trim(), Double.parseDouble(numberOfShares.trim()), portfolioName.trim(), commission.trim());
      view.displayMessage("Success", "Thank you for buying : " + ticker);
    } catch (Exception e) {
      view.displayMessage("Error", e.getMessage());
    }

  }

  /**
   * This method takes in the portfolio ane and a timestamp and evaluates the stock on that date.
   *
   * @param portfolioName portfolio name.
   * @param timeStamp     timestamp.
   * @return PortfolioTransferable object that contains all the information for a portfolio.
   */
  @Override
  public PortfolioTransferable viewDetailedStocks(String portfolioName, String timeStamp) {

    PortfolioTransferable p = null;
    try {
      p = model.evaluatePortfolio(portfolioName, timeStamp);
    } catch (Exception e) {
      view.displayMessage("Error", e.getMessage());
    }

    return p;
  }


  /**
   * This method invests a fixed amount in a particular portfolio which is specified by the user
   * using fixed weights assigned to each stocks in the portfolio.
   *
   * @param portfolioName the portfolio name.
   * @param fixedAmount   the fixed amount.
   * @param timeStamp     timestamp.
   * @param commission    commission fees.
   */
  @Override
  public void investStocks(String portfolioName, String fixedAmount, String timeStamp, String commission) {

    try {
      model.investStocks(portfolioName, Double.parseDouble(fixedAmount), timeStamp, commission);
    } catch (ParseException e) {
      view.displayMessage("Error", e.getMessage());
    }

  }

  /**
   * This method invests a fixed amount in a particular portfolio which is specified by the user
   * using custom weights assigned to each stocks by the user in the portfolio.
   *
   * @param portfolioName the portfolio name.
   * @param fixedAmount   the fixed amount.
   * @param weights       custom weights for each stocks.
   * @param timeStamp     timestamp.
   * @param commission    commission fees.
   */
  @Override
  public void investStocks(String portfolioName, String fixedAmount, String weights, String timeStamp, String commission) {

    try {
      model.investStocks(portfolioName, Double.parseDouble(fixedAmount), weightsToWeightsHashMapConverter(weights), timeStamp, commission);
    } catch (ParseException e) {
      view.displayMessage("Error", e.getMessage());
    }
  }

  /**
   * This is a method that gets the name of the stocks present in that portfolio.
   *
   * @param portfolioName the portfolio name.
   * @return list of the stock names.
   */
  @Override
  public List<String> getStocksInPortfolio(String portfolioName) {

    List<String> display = new ArrayList<>();
    try {
      display = model.getStocksInPortfolio(portfolioName);
    } catch (Exception e) {

      view.displayMessage("Error", e.getMessage());
    }
    return display;

  }

  /**
   * This method is used to save the data to the disk and terminate.
   */
  @Override
  public void saveModel() {
    try {
      saveData();
      terminate();
    } catch (IOException e) {
      view.displayMessage("Error", e.getMessage());
    }
  }

  /**
   * This method is to terminate the program gracefully.
   */
  @Override
  public void terminate() {
    view.exitGracefully();
  }


  /**
   * This method is to implement the Dollar cost averging strategy on a portfolio. The method takes
   * in teh portfolio name on which th estartegy is to be applied, the start date of the strategy ,
   * end date of the strategy, the frequency of the strategy, commission fee and weights.
   *
   * @param portfolioName the portfolio name.
   * @param fixedAmount   fixed amount to be invested.
   * @param startDate     start date.
   * @param endDate       end date.
   * @param frequency     frequency of the strategy.
   * @param commission    commission fee for each transaction.
   * @param weights       the weights of each stocks.
   */
  @Override
  public void implementStrategy(String portfolioName, String fixedAmount, String startDate, String endDate, String frequency, String commission, String weights) {

    InvestmentStrategyInterface da = new DollarCostAverageStrategy(Double.parseDouble(fixedAmount),
            startDate, endDate, Integer.parseInt(frequency), commission);
    model.registerStrategy(da, portfolioName, weightsToWeightsHashMapConverter(weights));

  }

  /**
   * This method is used to plot a graph of the total Valuation of the portfolio passed by the
   * user.
   *
   * @param portfolioName the portfolio name for which the user wishes to plot the graph.
   * @param startDate     the start date.
   * @param endDate       the end date.
   * @param frequency     the frequency.
   */
  @Override
  public void plotGraph(String portfolioName, String startDate, String endDate, String frequency) {
    frequency = frequency.trim();
    GraphPlotter chart = new GraphPlotter("Total Valuation of " + portfolioName);
    chart.plotGraph(createDataset(portfolioName, startDate, endDate, Integer.parseInt(frequency)), portfolioName);
    chart.pack();
    RefineryUtilities.centerFrameOnScreen(chart);
    chart.setVisible(true);
  }

  /**
   * This method is to generate the data set for the graph plotting.
   */
  private DefaultCategoryDataset createDataset(String portfolioName, String startDate, String endDate, Integer frequency) {
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    DateUtility du = new DateUtility();
    LocalDate sDate = du.stringToDateConverter(startDate);
    LocalDate eDate = du.stringToDateConverter(endDate);
    LocalDate next = sDate;

    while (next.isEqual(eDate) || next.isBefore(eDate)) {
      dataset.addValue(model.evaluatePortfolio(portfolioName, next.toString()).getTotalValue(), "stockValue", next.toString());
      next = next.plusDays(frequency);
    }

    return dataset;
  }

  /**
   * This method takes in the weights for the stocks in the portfolio as a string and returns a hash
   * map which can be used by the program.
   *
   * @param weights the weights as a string
   * @return the weights as a hash map.
   */
  private HashMap<String, Double> weightsToWeightsHashMapConverter(String weights) {
    HashMap<String, Double> weightsMap = new HashMap<String, Double>();
    StringTokenizer token = new StringTokenizer(weights, ",");

    while (token.hasMoreTokens()) {
      StringTokenizer token2 = new StringTokenizer(token.nextToken().toString().trim(), " ");
      weightsMap.put(token2.nextToken(), Double.parseDouble(token2.nextToken()));
    }

    return weightsMap;

  }


}
