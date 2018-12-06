
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


import javax.swing.*;

import controller.Controller;
import controller.ControllerFactory;
import controller.IStockMarketController;
import controller.StockMarketController;
import model.InvestModelInterfaceNew;
import model.InvestmentModelNew;
import test.Address;
import test.person;
import view.IntroJFrame;
import view.InvestmentView;
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


    InvestModelInterfaceNew im = new InvestmentModelNew();
    InvestmentViewInterface iv = ViewFactory.generateViewFactory("GUI");
    IStockMarketController controller = ControllerFactory.generateControllerFactory("GUI",iv,im);
    try {
      controller.startStockMarket();
    } catch (ParseException e) {
      e.printStackTrace();
    }




  }


}

