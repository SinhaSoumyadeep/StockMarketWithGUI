package validation;

import javax.swing.JOptionPane;

import utility.DateUtility;

public class Validator {

  /**
   * This method performs a check on the format of the date entered by the user and displays a
   * message based on it.
   *
   * @param date Date entered by the user in the text field
   * @return true if format entered is incorrect and false otherwise
   */
  public boolean checkDateValidity(String date) {
    DateUtility du = new DateUtility();
    if (!du.checkDateValidity(date)) {
      displayMessage("Error in Date field.", "Date format is Invalid!!!\nPlease" +
              " enter date as per the mentioned format.");
      return true;
    } else {
      return false;
    }
  }

  /**
   * This method validates the number of stocks entered by the user and displays a message based on
   * it.
   *
   * @param numberOfStocks stocks entered by the user in the text field
   * @return true if format is incorrect and false otherwise
   */

  public boolean checkNumberOfStocksValidity(String numberOfStocks) {
    try {
      Double noOfShares = Double.parseDouble(numberOfStocks);
      if (noOfShares < 0) {
        displayMessage("Error in Number of Stocks",
                "Number of Stocks entered cannot be negative.");
        return true;
      }
    } catch (NumberFormatException e) {
      displayMessage("Error in Number of Stocks", "Number of Stocks neeeds to be a" +
              " positive number.");
      return true;
    }
    return false;
  }

  /**
   * This method checks for the commission entered by the user and displays a message based on it.
   *
   * @param commission commission value entered by the user in the text field
   * @return true if format is incorrect and false otherwise
   */

  public boolean checkCommissionValidity(String commission) {
    try {
      Double parsedCommission = Double.parseDouble(commission);
      if (parsedCommission < 0) {
        displayMessage("Error in Commission Field",
                "Commission cannot be negative.");
        return true;
      }
    } catch (NumberFormatException e) {
      displayMessage("Error in Commission Field", "Commission needs to be a positive" +
              " number.");
      return true;
    }
    return false;
  }

  /**
   * This method checks for the fixed amount entered by the user and displays a message based on
   * it.
   *
   * @param fixedAmount fixed amount value entered by the user in the text field
   * @return true if format is incorrect and false otherwise
   */

  public boolean checkFixedAmountValidity(String fixedAmount) {
    try {
      Double parsedFixedAmount = Double.parseDouble(fixedAmount);
      if (parsedFixedAmount < 0) {
        displayMessage("Error in Fixed Amount Field",
                "Fixed Amount cannot be negative.");
        return true;
      }
    } catch (NumberFormatException e) {
      displayMessage("Error in Fixed Amount Field", "Fixed Amount needs to be a " +
              "positive number.");
      return true;
    }
    return false;
  }

  /**
   * This method checks for the frequency entered by the user and displays a message based on it.
   *
   * @param frequency fixed amount value entered by the user in the text field
   * @return true if format is incorrect and false otherwise
   */

  public boolean checkFrequencyValidity(String frequency) {
    try {
      Double parsedFrequency = Double.parseDouble(frequency);
      if (parsedFrequency < 0) {
        displayMessage("Error in Frequency Field",
                "Frequency cannot be negative.");
        return true;
      }
    } catch (NumberFormatException e) {
      displayMessage("Error in Frequency Field", "Frequency needs to be a " +
              "positive number.");
      return true;
    }
    return false;
  }

  /**
   * This method performs a check on the format of the start date and end entered by the user and
   * displays a message based on it.
   *
   * @param startDate start date entered by the user in the text field
   * @param endDate   end date entered by the user in the text field
   * @return true if format is incorrect and false otherwise
   */

  public boolean checkStartDateEndDateValidity(String startDate, String endDate) {
    DateUtility du = new DateUtility();
    if (!du.checkDateValidity(startDate)) {
      displayMessage("Error in Start Date field.", "Start Date format is Invalid!!!" +
              "\nPlease enter date as per the mentioned format.");
      return true;
    } else if (!du.checkDateValidity(endDate)) {
      displayMessage("Error in End Date field.", "End Date format is Invalid!!!" +
              "\nPlease enter date as per the mentioned format.");
      return true;
    } else {
      return false;
    }
  }

  /**
   * This method helps display a message for every incorrect validation.
   *
   * @param title   the title of the message dialog box
   * @param message the message notifying the user about the incorrect validation
   */

  private void displayMessage(String title, String message) {
    JOptionPane.showMessageDialog(null, message, "InfoBox: " + title,
            JOptionPane.INFORMATION_MESSAGE);
  }

}
