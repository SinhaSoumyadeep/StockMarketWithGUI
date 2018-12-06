package controller;

import java.util.List;

import transferable.PortfolioTransferable;

/**
 * This is an Interface called Features which provides various features to the controller. This
 * interface is used to isolate the actions performed by the View and make them take care by the
 * controller instead.
 */
public interface Features {

  /**
   * This method helps to create a new portfolio for the user. this method takes in a portfolio name
   * an creates a new portfolio for the user.
   *
   * @param portfolioName the portfolio name.
   */
  void createPortfolio(String portfolioName);

  /**
   * This method takes in a ticker symbol, timestamp, number of shares, commission fee and portfolio
   * name to buy the stock specified by the user.
   *
   * @param ticker         the ticker symbol.
   * @param timeStamp      timestamp.
   * @param numberOfShares number of shares.
   * @param commission     commission fee.
   * @param portfolioName  portfolio name.
   */
  void buyStocks(String ticker, String timeStamp, String numberOfShares, String commission,
                 String portfolioName);

  /**
   * This method takes in the portfolio name and a timestamp and evaluates the stock on that date.
   *
   * @param portfolioName portfolio name.
   * @param timeStamp     timestamp.
   * @return PortfolioTransferable object that contains all the information for a portfolio.
   */
  PortfolioTransferable viewDetailedStocks(String portfolioName, String timeStamp);

  /**
   * This method invests a fixed amount in a particular portfolio which is specified by the user
   * using fixed weights assigned to each stocks in the portfolio.
   *
   * @param portfolioName the portfolio name.
   * @param fixedAmount   the fixed amount.
   * @param timeStamp     timestamp.
   * @param commission    commission fees.
   */
  void investStocks(String portfolioName, String fixedAmount, String timeStamp,
                    String commission);

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
  void investStocks(String portfolioName, String fixedAmount,
                    String weights, String timeStamp, String commission);

  /**
   * This is a method that gets the name of the stocks present in that portfolio.
   *
   * @param portfolioName the portfolio name.
   * @return list of the stock names.
   */
  List<String> getStocksInPortfolio(String portfolioName);

  /**
   * This method is used to save the data to the disk and terminate.
   */
  void saveModel();

  /**
   * This method is to terminate the program gracefully.
   */
  void terminate();

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
  void implementStrategy(String portfolioName, String fixedAmount, String startDate, String endDate, String frequency, String commission, String weights);

  /**
   * This method is used to plot a graph of the total Valuation of the portfolio passed by the
   * user.
   *
   * @param portfolioName the portfolio name for which the user wishes to plot the graph.
   * @param startDate     the start date.
   * @param endDate       the end date.
   * @param frequency     the frequency.
   */
  void plotGraph(String portfolioName, String startDate, String endDate, String frequency);

}
