package view;

public class ViewFactory {

  public static InvestmentViewInterface generateViewFactory(String type) {
    if (type.equals("GUI")) {
      return new IntroJFrame();
    } else if (type.equals("CONSOLE")) {
      return new InvestmentView(System.out);
    } else {
      return new InvestmentView(System.out);
    }
  }
}
