package controller;


import java.io.InputStreamReader;

import model.InvestModelInterfaceNew;
import view.InvestmentViewInterface;

public class ControllerFactory {
  public static IStockMarketController generateControllerFactory(String type, InvestmentViewInterface iv, InvestModelInterfaceNew im) {
    if (type.equals("GUI")) {
      return new Controller(im,iv);
    }
    else if(type.equals("CONSOLE")){
      return new StockMarketController(new InputStreamReader(System.in), iv, im);
    }
    else {
      return new StockMarketController(new InputStreamReader(System.in), iv, im);
    }
  }
}
