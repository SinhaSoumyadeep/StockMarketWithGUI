package controller;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import model.InvestModelInterfaceNew;
import model.InvestmentModelNew;
import transferable.PortfolioTransferable;
import utility.Options;
import view.InvestmentViewInterface;

public class Controller implements Features {
  private InvestmentViewInterface view;
  private InvestModelInterfaceNew model;


  public Controller(InvestModelInterfaceNew model)
  {
    try{
      this.model = retrieveData();
    }
    catch (Exception e){
      System.out.println("in catch: loading a new model!");
      this.model = model;
    }

  }

  public void setView(InvestmentViewInterface v) {
    view = v;
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


  private void saveData() throws IOException {
    System.out.println("SAVING MODEL!!");
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    objectMapper.writeValue(new File("savedFile/Eve.json"), model);
  }

  private InvestModelInterfaceNew retrieveData() throws IOException {
    System.out.println("RETRIEVING MODEL!!");
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    InvestModelInterfaceNew obj = objectMapper.readValue(new File("savedFile/Eve.json"),
            InvestmentModelNew.class);
    return obj;
  }


}
