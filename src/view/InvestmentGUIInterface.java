package view;

import java.util.List;

import controller.Features;

public interface InvestmentGUIInterface extends InvestmentViewInterface {

  void setFeatures(Features f);
  void updatePortfolioOption(List<String> listOfportfolio);
  void displayMessage(String title,String message);
}
