
import java.io.IOException;
import java.text.ParseException;
import controller.ControllerFactory;
import controller.IStockMarketController;
import model.InvestModelInterfaceNew;
import model.InvestmentModelNew;
import utility.TypeOfUserInterface;
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

    String option = "";
    if(args.length!= 0) {
      option = args[0].toUpperCase();
    }else {
      throw new IllegalArgumentException("Type of User Interface Not Specified");
    }

    if(option.equals(TypeOfUserInterface.GUI.name()) || option.equals(TypeOfUserInterface.CONSOLE.name())){
      InvestModelInterfaceNew im = new InvestmentModelNew();
      InvestmentViewInterface iv = ViewFactory.generateViewFactory(option);
      IStockMarketController controller = ControllerFactory.generateControllerFactory(option,iv,im);
      try {
        controller.startStockMarket();
      } catch (ParseException e) {
        e.printStackTrace();
      }
    }
    else {
      throw new IllegalArgumentException("Invalid Type of User Interface");
    }

  }


}

