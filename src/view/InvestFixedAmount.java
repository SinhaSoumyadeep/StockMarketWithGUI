
package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import controller.Features;


public class InvestFixedAmount extends JPanel {


  private JButton assignEqualWeightsBtn;
  private JButton assignIndividualWeightsBtn;
  private JLabel currentStocksJLabel;
  private JTextArea currentStocksJTextArea;
  private JLabel enterCommissionInInvestFixedJLabel;
  private JTextField enterCommissionInInvestFixedJTextField;
  private JLabel enterDateInInvestFixedJLabel;
  private JTextField enterDateInInvestFixedJTextField;
  private JLabel enterFixedAmountJLabel;
  private JTextField enterFixedAmountJTextField;
  private JLabel enterPortfolioNameFixedAmountJLabel;
  private JLabel enterWeightsFormatJLabel;
  private JLabel enterWeightsJLabel;
  private JTextField enterWeightsJTextField;
  private JLabel investFixedAmountHomeJLabel;
  private JScrollPane jScrollPane1;
  private JComboBox<String> portfolioNameInInvestFixedJCombo;
  private List<String> portfollioList;


  /**
   * Creates new form InvestFixedAmount
   */
  public InvestFixedAmount(List<String> portfollioList) {

    ArrayList<String> options = new ArrayList<>();
    options.add("SELECT BELOW");
    options.addAll(portfollioList);
    this.portfollioList = options;
    initComponents();
    currentStocksJTextArea.setEditable(false);
  }


  private void initComponents() {

    investFixedAmountHomeJLabel = new JLabel();
    enterPortfolioNameFixedAmountJLabel = new JLabel();
    enterFixedAmountJLabel = new JLabel();
    enterFixedAmountJTextField = new JTextField();
    enterDateInInvestFixedJLabel = new JLabel();
    enterDateInInvestFixedJTextField = new JTextField();
    enterCommissionInInvestFixedJLabel = new JLabel();
    enterCommissionInInvestFixedJTextField = new JTextField();
    assignEqualWeightsBtn = new JButton();
    assignIndividualWeightsBtn = new JButton();
    enterWeightsJLabel = new JLabel();
    enterWeightsFormatJLabel = new JLabel();
    enterWeightsJTextField = new JTextField();
    portfolioNameInInvestFixedJCombo = new JComboBox<>();
    jScrollPane1 = new JScrollPane();
    currentStocksJTextArea = new JTextArea();
    currentStocksJLabel = new JLabel();

    investFixedAmountHomeJLabel.setText("Invest Fixed Amount");

    enterPortfolioNameFixedAmountJLabel.setText("Enter Portfolio to Invest Fixed Amount:-");

    enterFixedAmountJLabel.setText("Enter Fixed Amount:-");

    enterDateInInvestFixedJLabel.setText("Enter Date (Format: YYYY-MM-DD):-");

       /* enterDateInInvestFixedJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterDateInInvestFixedJTextFieldActionPerformed(evt);
            }
        });*/

    enterCommissionInInvestFixedJLabel.setText("Enter Commission:-");

    assignEqualWeightsBtn.setText("Invest using Equal Weights");

    assignIndividualWeightsBtn.setText("Invest using Individual Weights");
       /* assignIndividualWeightsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignIndividualWeightsBtnActionPerformed(evt);
            }
        });*/

    enterWeightsJLabel.setText("Enter Individual Weights");

    enterWeightsFormatJLabel.setText("Format: Stock1 Weight1,Stock2 Weight2... (Example: GOOG 50,TCS 40...)");

    portfolioNameInInvestFixedJCombo.setModel(new DefaultComboBoxModel<>(portfollioList.toArray(new String[0])));

    currentStocksJTextArea.setColumns(20);
    currentStocksJTextArea.setRows(5);
    jScrollPane1.setViewportView(currentStocksJTextArea);

    currentStocksJLabel.setText("Stocks present in Portfolio:-");

    GroupLayout layout = new GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jScrollPane1)
                                            .addComponent(enterWeightsJLabel, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(enterWeightsFormatJLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(enterWeightsJTextField)
                                            .addComponent(assignEqualWeightsBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(investFixedAmountHomeJLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(enterPortfolioNameFixedAmountJLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(enterFixedAmountJLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(enterFixedAmountJTextField)
                                            .addComponent(enterDateInInvestFixedJLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(enterDateInInvestFixedJTextField)
                                            .addComponent(enterCommissionInInvestFixedJLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(enterCommissionInInvestFixedJTextField)
                                            .addComponent(portfolioNameInInvestFixedJCombo, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(assignIndividualWeightsBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(currentStocksJLabel))
                            .addContainerGap(351, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(investFixedAmountHomeJLabel)
                            .addGap(18, 18, 18)
                            .addComponent(enterPortfolioNameFixedAmountJLabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(portfolioNameInInvestFixedJCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(16, 16, 16)
                            .addComponent(enterFixedAmountJLabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(enterFixedAmountJTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(enterDateInInvestFixedJLabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(enterDateInInvestFixedJTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(enterCommissionInInvestFixedJLabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(enterCommissionInInvestFixedJTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(currentStocksJLabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(assignEqualWeightsBtn)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(enterWeightsJLabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(enterWeightsFormatJLabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(enterWeightsJTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(assignIndividualWeightsBtn)
                            .addContainerGap())
    );
  }


  public void delegateActions(Features f) {

    portfolioNameInInvestFixedJCombo.addActionListener(l -> {

      String display = "";
      int count = 1;
      for (String stock : f.getStocksInPortfolio(portfolioNameInInvestFixedJCombo.getSelectedItem().toString())) {
        display = display + count + ". " + stock + "\n";
        count++;
      }

      display = display.trim();
      currentStocksJTextArea.setText(display);


    });

    assignEqualWeightsBtn.addActionListener(l -> {
      try {
        f.investStocks(portfolioNameInInvestFixedJCombo.getSelectedItem().toString(), enterFixedAmountJTextField.getText(), enterDateInInvestFixedJTextField.getText(), enterCommissionInInvestFixedJTextField.getText());
        displayMessage("Thank You!", "Thank you for investing: $" + enterFixedAmountJTextField.getText() + " on portfolio: " + portfolioNameInInvestFixedJCombo.getSelectedItem().toString());
      }
      catch (Exception e){
        displayMessage("ERROR",e.getMessage());
        displayMessage("ERROR","sorry you have to start again!");
      }
      reset();
    });

  }


  private void reset() {
    enterFixedAmountJTextField.setText("");
    enterDateInInvestFixedJTextField.setText("");
    enterCommissionInInvestFixedJTextField.setText("");
    currentStocksJTextArea.setText("");
  }

  private void displayMessage(String title, String message) {
    JOptionPane.showMessageDialog(null, message, "InfoBox: " + title, JOptionPane.INFORMATION_MESSAGE);
  }


}
