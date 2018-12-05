package controller;

import java.util.List;

import transferable.PortfolioTransferable;

public interface Features {

  void createPortfolio(String portfolioName);
  public void buyStocks(String ticker, String timeStamp, String numberOfShares, String commission,
                        String portfolioName);
  PortfolioTransferable viewDetailedStocks(String portfolioName, String timeStamp);
  void investStocks(String portfolioName, String fixedAmount, String timeStamp,
                           String commission);
  List<String> getStocksInPortfolio(String portfolioName);
  void saveModel();
  void terminate();
}
