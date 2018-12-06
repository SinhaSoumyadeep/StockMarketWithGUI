package controller;

import java.util.List;

import transferable.PortfolioTransferable;

public interface Features {

  void createPortfolio(String portfolioName);
  void buyStocks(String ticker, String timeStamp, String numberOfShares, String commission,
                        String portfolioName);
  PortfolioTransferable viewDetailedStocks(String portfolioName, String timeStamp);
  void investStocks(String portfolioName, String fixedAmount, String timeStamp,
                           String commission);
  void investStocks(String portfolioName, String fixedAmount,
                           String weights, String timeStamp, String commission);
  List<String> getStocksInPortfolio(String portfolioName);
  void saveModel();
  void terminate();
  void implementStrategy(String portfolioName, String fixedAmount, String startDate, String endDate, String frequency, String commission, String weights);
  void plotGraph(String portfolioName, String startDate, String endDate, String frequency );

}
