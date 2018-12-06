
import java.io.IOException;
import java.text.ParseException;
import controller.ControllerFactory;
import controller.IStockMarketController;
import model.InvestModelInterfaceNew;
import model.InvestmentModelNew;
import view.InvestmentViewInterface;
import view.ViewFactory;

/**
 * This is the driver class for the stock market program.
 */
public class Main {

  /**
   * Main.
   *
   * @param args the args
   * @throws ParseException invalid date.
   */
  public static void main(String[] args) throws ParseException, IOException {

    String option = args[0].toUpperCase();

    InvestModelInterfaceNew im = new InvestmentModelNew();
    InvestmentViewInterface iv = ViewFactory.generateViewFactory(option);
    IStockMarketController controller = ControllerFactory.generateControllerFactory(option,iv,im);
    try {
      controller.startStockMarket();
    } catch (ParseException e) {
      e.printStackTrace();
    }




  }


}

