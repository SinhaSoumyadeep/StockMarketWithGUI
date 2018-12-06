
package view;

import java.util.List;

import javax.swing.*;

import controller.Features;
import transferable.PortfolioTransferable;
import transferable.StockTransferable;


/**
 * This JPannel is the view for viewing the composition and evaluate a portfolio User Interface.
 */
public class ViewPortfolioCompositionJPanel extends JPanel {

  private JComboBox<String> PortfolioNameInViewJCombo;
  private JLabel enterPortfolioForCompositionJLabel;
  private JLabel enterTimestampJLabel;
  private JTextField enterTimestampJTextField;
  private JProgressBar jProgressBar1;
  private JScrollPane jScrollPane1;
  private JButton viewPortfolioCompositionBtn;
  private JLabel viewPortfolioCompositionHomeJLabel;
  private JTextArea viewPortfolioJTextArea;
  private JButton viewPortfolioValuationBtn;
  private List<String> portfollioList;

  /**
   * Creates new form ViewPortfolioCompositionJPanel
   */
  public ViewPortfolioCompositionJPanel(List<String> portfollioList) {
    this.portfollioList = portfollioList;
    initComponents();
    viewPortfolioJTextArea.setEditable(false);
  }

  /**
   * This method is the composition of the view of the composition and evaluate a portfolio view or
   * how it would show in the GUI.
   */
  private void initComponents() {

    jProgressBar1 = new JProgressBar();
    viewPortfolioCompositionHomeJLabel = new JLabel();
    enterTimestampJLabel = new JLabel();
    enterTimestampJTextField = new JTextField();
    enterPortfolioForCompositionJLabel = new JLabel();
    viewPortfolioCompositionBtn = new JButton();
    viewPortfolioValuationBtn = new JButton();
    jScrollPane1 = new JScrollPane();
    viewPortfolioJTextArea = new JTextArea();
    PortfolioNameInViewJCombo = new JComboBox<>();

    viewPortfolioCompositionHomeJLabel.setText("View Portfolio Composition or Valuation");

    enterTimestampJLabel.setText("Enter Timestamp (Format: YYYY-MM-DD)");

    enterPortfolioForCompositionJLabel.setText("Enter Portfolio name:-");

    viewPortfolioCompositionBtn.setText("View Portfolio Composition");

    viewPortfolioValuationBtn.setText("View Portfolio Valuation");

    viewPortfolioJTextArea.setColumns(20);
    viewPortfolioJTextArea.setRows(5);
    jScrollPane1.setViewportView(viewPortfolioJTextArea);

    PortfolioNameInViewJCombo.setModel(new DefaultComboBoxModel<>(portfollioList.toArray(new String[0])));

    GroupLayout layout = new GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1)
                                    .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(PortfolioNameInViewJCombo, GroupLayout.Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(viewPortfolioCompositionHomeJLabel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(enterTimestampJLabel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(enterTimestampJTextField, GroupLayout.Alignment.LEADING)
                                                    .addComponent(enterPortfolioForCompositionJLabel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(viewPortfolioCompositionBtn, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGap(32, 32, 32)
                                            .addComponent(viewPortfolioValuationBtn, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 194, Short.MAX_VALUE)))
                            .addContainerGap())
    );
    layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(viewPortfolioCompositionHomeJLabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(enterPortfolioForCompositionJLabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(PortfolioNameInViewJCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(16, 16, 16)
                            .addComponent(enterTimestampJLabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(enterTimestampJTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(16, 16, 16)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(viewPortfolioCompositionBtn)
                                    .addComponent(viewPortfolioValuationBtn))
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                            .addContainerGap())
    );
  }


  /**
   * This method is used to Delegate actions to the controller.
   *
   * @param f the object of the feature interface or controller.
   */
  public void delegateActions(Features f) {
    viewPortfolioCompositionBtn.addActionListener(l -> {

      PortfolioTransferable pt = f.viewDetailedStocks(PortfolioNameInViewJCombo.getSelectedItem().toString(), enterTimestampJTextField.getText());
      StringBuffer statement = new StringBuffer();

      for (StockTransferable st : pt.getStocks()) {
        statement.append("Ticker:\t\t\t\t" + st.getTicker() + "\n");
        statement.append("Total Number of Shares for " + st.getTicker() + ":\t\t" + st.getTotalNumberOfShares() + "\n");
        statement.append("Current Price for a Stock " + st.getTicker() + " on " + pt.getTimeStamp() + ":\t$" + st.getCurrentPrice() + "\n");
        statement.append("Total Valuation for " + st.getTicker() + ":\t\t\t$" + st.getTotalValue() + "\n");
        statement.append("Total Investment for " + st.getTicker() + ":\t\t\t$" + st.getTotalInvestment() + "\n");
        statement.append("Total Return for " + st.getTicker() + ":\t\t\t$" + st.getTotalReturn() + "\n\n");
      }

      statement.append("Total Investment:\t\t\t$" + pt.getTotalInvestment() + "\n");
      statement.append("Total Portfolio Valuation on " + pt.getTimeStamp() + ":\t\t$" + pt.getTotalValue() + "\n");


      viewPortfolioJTextArea.setText(statement.toString());


      reset();
      repaint();
    });


    viewPortfolioValuationBtn.addActionListener(l -> {

      PortfolioTransferable pt = f.viewDetailedStocks(PortfolioNameInViewJCombo.getSelectedItem().toString(), enterTimestampJTextField.getText());
      StringBuffer statement = new StringBuffer();
      statement.append("Total Investment:\t\t\t$" + pt.getTotalInvestment() + "\n");
      statement.append("Total Portfolio Valuation on " + pt.getTimeStamp() + ":\t\t$" + pt.getTotalValue() + "\n");


      viewPortfolioJTextArea.setText(statement.toString());


      reset();
      repaint();
    });


  }

  /**
   * This method is used to reset everything back to its original state.
   */
  private void reset() {
    enterTimestampJTextField.setText("");
  }


}
