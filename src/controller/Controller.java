package controller;


import java.io.IOException;

import model.InvestModelInterfaceNew;
import transferable.PortfolioTransferable;
import utility.Options;
import view.InvestmentViewInterface;

public class Controller implements Features {
  private InvestmentViewInterface view;
  private InvestModelInterfaceNew model;


  public Controller(InvestModelInterfaceNew model) {
    this.model = model;
  }

  public void setView(InvestmentViewInterface v) {
    view = v;
    view.setFeatures(this);
  }


  @Override
  public void createPortfolio(String portfolioName) {

    model.createNewPortfolio(portfolioName);
    view.updatePortfolioOption(model.getPortfolioNames());
    view.displayMessage("Success", "you successfully created portfolio: "+portfolioName);


  }

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
}
