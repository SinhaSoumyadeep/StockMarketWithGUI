package view;

/**
 * This is a View factory pattern which will make our application flexible to use multiple views
 * based on the argument passed by the user at runtime.
 */
public class ViewFactory {

  /**
   * This is the static method which will generate the View object based on the Option provided by
   * the user in the command line. The factory will generate a GUI based View object if the command
   * line option sen t by the user is "GUI". if the argument passed is "CONSOLE" then the method
   * generates a console based view.
   *
   * @param type the type of the View required.
   * @return appropriate View object based on the option.
   */
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
