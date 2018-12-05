package service;

/**
 * This interface provides method to get the company listings.
 */
public interface StockMarketDAO {

  /**
   * This method takes in a ticker and gets the company listing till the current date.
   *
   * @param ticker the ticker symbol of the company.
   * @return string of company listing.
   */
  public String getCompanyListing(String ticker);

}

