package view;

import java.util.List;

import controller.Features;

/**
 * The interface Investment gui interface.
 */
public interface InvestmentGUIInterface extends InvestmentViewInterface {

  /**
   * This is the Sets of features defined in the controller class that is used to perform the
   * actions.
   *
   * @param f the f
   */
  void setFeatures(Features f);

  /**
   * This method is used to Update the portfolio option when the application is loaded or when  a
   * new portfolio is added. This is used to populate the various drop downs that requires the
   * portfolio names.
   *
   * @param listOfportfolio the list of portfolio names.
   */
  void updatePortfolioOption(List<String> listOfportfolio);

  /**
   * This method is used to Display message in a dialogue box format.
   *
   * @param title   the title.
   * @param message the message.
   */
  void displayMessage(String title, String message);

  /**
   * This methos is used to Exit the program gracefully.
   */
  void exitGracefully();
}
