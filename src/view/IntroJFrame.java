
package view;


import org.jfree.ui.RefineryUtilities;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import controller.Features;
import transferable.PortfolioTransferable;
import transferable.StockTransferable;
import utility.Options;

public class IntroJFrame extends JFrame implements InvestmentGUIInterface {


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
      GraphJPanel g = new GraphJPanel(this.portfollioList);
      jSplitPane1.setRightComponent(g);
      g.delegateActions(f);

    });
    strategyBtn.addActionListener(l -> {
      DollarCostStrategyJPanel dc = new DollarCostStrategyJPanel(this.portfollioList);
      JScrollPane pane = new JScrollPane(dc);
      jSplitPane1.setRightComponent(pane);
      dc.delegateActions(f);

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

  @Override
  public void exitGracefully() {
    if (isDisplayable()) {
      dispose();
    }
  }

  @Override
  public String guiInUse() {
    return "GUI";
  }
}
