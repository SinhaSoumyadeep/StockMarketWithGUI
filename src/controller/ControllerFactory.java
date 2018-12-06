package controller;


import java.io.InputStreamReader;

import model.InvestModelInterfaceNew;
import view.InvestmentViewInterface;


/**
 * This is a Controller factory pattern which will make our application flexible to use multiple
 * controller based on the argument passed by the user at runtime.
 */
public class ControllerFactory {

  /**
   * This is the static method which will generate the Controller object based on the Option
   * provided by the user in the command line. The factory will generate a GUI based Controller
   * object if the command line option sen t by the user is "GUI". if the argument passed is
   * "CONSOLE" then the method generates a console based controller.
   *
   * @param type the type of the Controller required.
   * @param iv   the view interface.
   * @param im   the model interface
   * @return appropriate controller object based on the option.
   */
  public static IStockMarketController generateControllerFactory(String type, InvestmentViewInterface iv, InvestModelInterfaceNew im) {
    if (type.equals("GUI")) {
      return new Controller(im, iv);
    } else if (type.equals("CONSOLE")) {
      return new StockMarketController(new InputStreamReader(System.in), iv, im);
    } else {
      return new StockMarketController(new InputStreamReader(System.in), iv, im);
    }
  }
}
