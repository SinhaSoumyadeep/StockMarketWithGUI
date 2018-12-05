
package view;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import controller.Features;
import transferable.PortfolioTransferable;
import transferable.StockTransferable;
import utility.Options;

public class IntroJFrame extends JFrame implements InvestmentViewInterface {


  private JButton createPortfolioBtn;
  private JButton createPortfolioBtn1;
  private JButton exitBtn;
  private JPanel jPanel1;
  private JPanel jPanel2;
  private JSplitPane jSplitPane1;
  private JButton oneTimeInvestmentBtn;
  private JButton plotGraphBtn;
  private JButton strategyBtn;
  private JButton viewPortfolioIntroBtn;
  private List<String> portfollioList;

  /**
   * Creates new form IntroFrame
   */
  public IntroJFrame() {
    initComponents();
    portfollioList = new ArrayList<String>();
  }


  private void initComponents() {

    jSplitPane1 = new JSplitPane();
    jPanel1 = new JPanel();
    createPortfolioBtn = new JButton();
    createPortfolioBtn1 = new JButton();
    viewPortfolioIntroBtn = new JButton();
    oneTimeInvestmentBtn = new JButton();
    strategyBtn = new JButton();
    plotGraphBtn = new JButton();
    exitBtn = new JButton();
    jPanel2 = new JPanel();

    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    createPortfolioBtn.setText("Create");

    createPortfolioBtn1.setText("Buy Stocks");

    viewPortfolioIntroBtn.setText("View");

    oneTimeInvestmentBtn.setText("One Time Investment");

    strategyBtn.setText("Strategy");

    plotGraphBtn.setText("Graph");

    exitBtn.setText("Exit");

    GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(createPortfolioBtn1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(viewPortfolioIntroBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(oneTimeInvestmentBtn, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(createPortfolioBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(plotGraphBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(strategyBtn, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                    .addComponent(exitBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(0, 0, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(createPortfolioBtn, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(createPortfolioBtn1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(viewPortfolioIntroBtn, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(oneTimeInvestmentBtn, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(strategyBtn, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(plotGraphBtn, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                            .addComponent(exitBtn, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
    );

    jSplitPane1.setLeftComponent(jPanel1);

    GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGap(0, 611, Short.MAX_VALUE)
    );
    jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGap(0, 510, Short.MAX_VALUE)
    );



    jSplitPane1.setRightComponent(jPanel2);

    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jSplitPane1, GroupLayout.PREFERRED_SIZE, 735, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jSplitPane1, GroupLayout.PREFERRED_SIZE, 512, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
    );

    setVisible(true);

    pack();
  }


  /**
   * Display portfolio.
   *
   * @param pt      the pt
   * @param options the options
   * @throws IOException the io exception
   */
  @Override
  public void displayPortfolio(PortfolioTransferable pt, Options options) throws IOException {

  }

  /**
   * Display all portfolio names.
   *
   * @param portfolioNames the portfolio names
   * @throws IOException the io exception
   */
  @Override
  public void displayAllPortfolioNames(List<String> portfolioNames) throws IOException {

  }

  /**
   * View intro message.
   *
   * @throws IOException the io exception
   */
  @Override
  public void viewIntroMessage() throws IOException {

  }

  /**
   * View welcome message.
   *
   * @throws IOException the io exception
   */
  @Override
  public void viewWelcomeMessage() throws IOException {

  }

  /**
   * View enter portfolio name.
   *
   * @throws IOException the io exception
   */
  @Override
  public void viewEnterPortfolioName() throws IOException {

  }

  /**
   * View enter ticker.
   *
   * @throws IOException the io exception
   */
  @Override
  public void viewEnterTicker() throws IOException {

  }

  /**
   * View enter number of shares.
   *
   * @throws IOException the io exception
   */
  @Override
  public void viewEnterNumberOfShares() throws IOException {

  }

  /**
   * View buy stock acknowledgement.
   *
   * @throws IOException the io exception
   */
  @Override
  public void viewBuyStockAcknowledgement() throws IOException {

  }

  /**
   * View enter date.
   *
   * @throws IOException the io exception
   */
  @Override
  public void viewEnterDate() throws IOException {

  }

  /**
   * View error invalid date.
   *
   * @throws IOException the io exception
   */
  @Override
  public void viewErrorInvalidDate() throws IOException {

  }

  /**
   * View error shares in fraction.
   *
   * @throws IOException the io exception
   */
  @Override
  public void viewErrorSharesInFraction() throws IOException {

  }

  /**
   * Enter fixed amount.
   *
   * @throws IOException the io exception
   */
  @Override
  public void enterFixedAmount() throws IOException {

  }

  /**
   * Choose portfolio to invest.
   *
   * @throws IOException the io exception
   */
  @Override
  public void choosePortfolioToInvest() throws IOException {

  }

  /**
   * View enter start date.
   *
   * @throws IOException the io exception
   */
  @Override
  public void viewEnterStartDate() throws IOException {

  }

  /**
   * View enter end date.
   *
   * @throws IOException the io exception
   */
  @Override
  public void viewEnterEndDate() throws IOException {

  }

  /**
   * View enter frequency.
   *
   * @throws IOException the io exception
   */
  @Override
  public void viewEnterFrequency() throws IOException {

  }

  /**
   * Choose portfolio for strategy.
   *
   * @throws IOException the io exception
   */
  @Override
  public void choosePortfolioForStrategy() throws IOException {

  }

  /**
   * View enter weight.
   *
   * @param stock the stock
   * @throws IOException the io exception
   */
  @Override
  public void viewEnterWeight(String stock) throws IOException {

  }

  /**
   * Choose weight option.
   *
   * @throws IOException the io exception
   */
  @Override
  public void chooseWeightOption() throws IOException {

  }

  /**
   * Choose end date option.
   *
   * @throws IOException the io exception
   */
  @Override
  public void chooseEndDateOption() throws IOException {

  }

  /**
   * Ongoing end date.
   *
   * @throws IOException the io exception
   */
  @Override
  public void ongoingEndDate() throws IOException {

  }

  /**
   * Print exceptions.
   *
   * @param e the e
   * @throws IOException the io exception
   */
  @Override
  public void printExceptions(String e) throws IOException {

  }

  /**
   * Enter options.
   *
   * @throws IOException the io exception
   */
  @Override
  public void enterOptions() throws IOException {

  }

  /**
   * View Choose portfolio.
   *
   * @throws IOException the io exception
   */
  @Override
  public void choosePortfolio() throws IOException {

  }

  /**
   * View Create new portfolio.
   *
   * @throws IOException the io exception
   */
  @Override
  public void createNewPortfolio() throws IOException {

  }

  /**
   * View Enter portfolio.
   *
   * @throws IOException the io exception
   */
  @Override
  public void enterPortfolio() throws IOException {

  }

  /**
   * View Invalid option.
   *
   * @throws IOException the io exception
   */
  @Override
  public void invalidOption() throws IOException {

  }

  /**
   * No portfolio.
   *
   * @throws IOException the io exception
   */
  @Override
  public void noPortfolio() throws IOException {

  }

  /**
   * Enter commission.
   *
   * @throws IOException the io exception
   */
  @Override
  public void enterCommission() throws IOException {

  }

  @Override
  public void setFeatures(Features f) {

    createPortfolioBtn.addActionListener(l -> {
      CreatePortfolioJPanel cp = new CreatePortfolioJPanel();
      jSplitPane1.setRightComponent(cp);
      cp.delegateActions(f);

    });
    createPortfolioBtn1.addActionListener(l -> {
      BuyStocksJPanel bs = new BuyStocksJPanel(this.portfollioList);
      jSplitPane1.setRightComponent(bs);
      bs.delegateActions(f);

    });
    exitBtn.addActionListener(l -> {
      ExitJPanel exit = new ExitJPanel();
      jSplitPane1.setRightComponent(exit);
      exit.delegateActions(f);

    });
    oneTimeInvestmentBtn.addActionListener(l -> {
      InvestFixedAmount invest = new InvestFixedAmount(this.portfollioList);
      JScrollPane pane = new JScrollPane(invest);
      jSplitPane1.setRightComponent(pane);
      invest.delegateActions(f);

    });
    plotGraphBtn.addActionListener(l -> {
      GraphJPanel g = new GraphJPanel();
      jSplitPane1.setRightComponent(g);

    });
    strategyBtn.addActionListener(l -> {
      DollarCostStrategyJPanel dc = new DollarCostStrategyJPanel(this.portfollioList);
      JScrollPane pane = new JScrollPane(dc);
      jSplitPane1.setRightComponent(pane);

    });
    viewPortfolioIntroBtn.addActionListener(l -> {
      ViewPortfolioCompositionJPanel vp = new ViewPortfolioCompositionJPanel(this.portfollioList);
      jSplitPane1.setRightComponent(vp);
      vp.delegateActions(f);

    });

  }

  @Override
  public void updatePortfolioOption(List<String> listOfportfolio) {
    portfollioList = listOfportfolio;
  }

  @Override
  public void displayMessage(String title,String message)
  {
    JOptionPane.showMessageDialog(null, message, "InfoBox: " + title, JOptionPane.INFORMATION_MESSAGE);
  }

}
