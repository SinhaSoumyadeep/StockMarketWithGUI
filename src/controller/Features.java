package controller;

import transferable.PortfolioTransferable;

public interface Features {

  void createPortfolio(String portfolioName);
  public void buyStocks(String ticker, String timeStamp, String numberOfShares, String commission,
                        String portfolioName);
  PortfolioTransferable viewDetailedStocks(String portfolioName, String timeStamp);
}
