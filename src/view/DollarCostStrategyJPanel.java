
package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import controller.Features;
import validation.Validator;


public class DollarCostStrategyJPanel extends JPanel {


  private JLabel StrategyHomeJLabel;
  private JButton assignIndividualWeightsBtn;
  private JLabel currentStocksJLabel;
  private JTextArea currentStocksJTextArea;
  private JLabel enterCommissionInStrategyJLabel;
  private JTextField enterCommissionInStrategyJTextField;
  private JLabel enterEndDateInStrategyJLabel1;
  private JTextField enterEndDateInStrategyJTextField1;
  private JLabel enterFixedAmountJLabel;
  private JTextField enterFixedAmountJTextField;
  private JLabel enterFrequencyJLabel1;
  private JTextField enterFrequencyJTextField1;
  private JLabel enterPortfolioNameStrategyJLabel;
  private JLabel enterStartDateInStrategyJLabel;
  private JTextField enterStartDateInStrategyJTextField;
  private JLabel enterWeightsFormatJLabel;
  private JLabel enterWeightsJLabel;
  private JTextField enterWeightsJTextField;
  private JScrollPane jScrollPane1;
  private JComboBox<String> portfolioNameInStrategyJCombo;
  private List<String> portfollioList;


  /**
   * Creates new form DollarCostStrategyJPanel
   */
  public DollarCostStrategyJPanel(List<String> portfollioList) {
    ArrayList<String> options = new ArrayList<>();
    options.add("SELECT BELOW");
    options.addAll(portfollioList);
    this.portfollioList = options;
    initComponents();
    currentStocksJTextArea.setEditable(false);
  }


  private void initComponents() {

    enterStartDateInStrategyJLabel = new JLabel();
    enterStartDateInStrategyJTextField = new JTextField();
    portfolioNameInStrategyJCombo = new JComboBox<>();
    enterCommissionInStrategyJLabel = new JLabel();
    enterCommissionInStrategyJTextField = new JTextField();
    StrategyHomeJLabel = new JLabel();
    assignIndividualWeightsBtn = new JButton();
    enterPortfolioNameStrategyJLabel = new JLabel();
    enterWeightsJLabel = new JLabel();
    enterFixedAmountJLabel = new JLabel();
    enterWeightsFormatJLabel = new JLabel();
    enterWeightsJTextField = new JTextField();
    enterFixedAmountJTextField = new JTextField();
    enterEndDateInStrategyJLabel1 = new JLabel();
    enterEndDateInStrategyJTextField1 = new JTextField();
    enterFrequencyJLabel1 = new JLabel();
    enterFrequencyJTextField1 = new JTextField();
    currentStocksJLabel = new JLabel();
    jScrollPane1 = new JScrollPane();
    currentStocksJTextArea = new JTextArea();

    enterStartDateInStrategyJLabel.setText("Enter Start Date (Format: YYYY-MM-DD):-");

    /*enterStartDateInStrategyJTextField.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        enterStartDateInStrategyJTextFieldActionPerformed(evt);
      }
    });*/

    portfolioNameInStrategyJCombo.setModel(new DefaultComboBoxModel<>(portfollioList.toArray(new String[0])));

    enterCommissionInStrategyJLabel.setText("Enter Commission:-");

    StrategyHomeJLabel.setText("Dollar Cost Averaging Strategy");

    assignIndividualWeightsBtn.setText("Invest using Individual Weights");
    /*assignIndividualWeightsBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        assignIndividualWeightsBtnActionPerformed(evt);
      }
    });*/

    enterPortfolioNameStrategyJLabel.setText("Enter Portfolio to Invest Fixed Amount:-");

    enterWeightsJLabel.setText("Enter Individual Weights");

    enterFixedAmountJLabel.setText("Enter Fixed Amount:-");

    enterWeightsFormatJLabel.setText("Format: Stock1 Weight1,Stock2 Weight2... (Example: GOOG 50,TCS 40...)");

    enterEndDateInStrategyJLabel1.setText("Enter End Date (Format: YYYY-MM-DD):-");

    /*enterEndDateInStrategyJTextField1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        enterEndDateInStrategyJTextField1ActionPerformed(evt);
      }
    });*/

    enterFrequencyJLabel1.setText("Enter Frequency (in days):-");

    currentStocksJLabel.setText("Stocks present in Portfolio:-");

    currentStocksJTextArea.setColumns(20);
    currentStocksJTextArea.setRows(5);
    jScrollPane1.setViewportView(currentStocksJTextArea);

    GroupLayout layout = new GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                                                    .addGap(204, 204, 204))
                                            .addComponent(enterWeightsFormatJLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(enterWeightsJTextField)
                                            .addComponent(StrategyHomeJLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(enterPortfolioNameStrategyJLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(enterFixedAmountJLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(enterFixedAmountJTextField)
                                            .addComponent(enterStartDateInStrategyJLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(enterStartDateInStrategyJTextField)
                                            .addComponent(enterCommissionInStrategyJLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(enterCommissionInStrategyJTextField))
                                    .addComponent(assignIndividualWeightsBtn, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(portfolioNameInStrategyJCombo, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(enterEndDateInStrategyJLabel1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(enterEndDateInStrategyJTextField1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(enterFrequencyJLabel1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                            .addComponent(enterFrequencyJTextField1, GroupLayout.Alignment.LEADING))
                                    .addComponent(currentStocksJLabel)
                                    .addComponent(enterWeightsJLabel, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(141, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(StrategyHomeJLabel)
                            .addGap(18, 18, 18)
                            .addComponent(enterPortfolioNameStrategyJLabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(portfolioNameInStrategyJCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(16, 16, 16)
                            .addComponent(enterFixedAmountJLabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(enterFixedAmountJTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(enterStartDateInStrategyJLabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(enterStartDateInStrategyJTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(enterEndDateInStrategyJLabel1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(enterEndDateInStrategyJTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(enterFrequencyJLabel1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(enterFrequencyJTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(enterCommissionInStrategyJLabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(enterCommissionInStrategyJTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(currentStocksJLabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
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

    portfolioNameInStrategyJCombo.addActionListener(l -> {

      StringBuffer display = new StringBuffer();
      int count = 1;
      for (String stock : f.getStocksInPortfolio(portfolioNameInStrategyJCombo.getSelectedItem().toString())) {
        display = display.append(count + ". " + stock + "\n");
        count++;
      }

      currentStocksJTextArea.setText(display.toString().trim());


    });

    assignIndividualWeightsBtn.addActionListener(l -> {

      Validator v = new Validator();
      if (v.checkStartDateEndDateValidity(enterStartDateInStrategyJTextField.getText(),
              enterEndDateInStrategyJTextField1.getText())) {
        return;
      } else if (v.checkFixedAmountValidity(enterFixedAmountJTextField.getText())) {
        return;
      } else if (v.checkCommissionValidity(enterCommissionInStrategyJTextField.getText())) {
        return;
      } else if (v.checkFrequencyValidity(enterFrequencyJTextField1.getText())) {
        return;
      }

      try {
        f.implementStrategy(portfolioNameInStrategyJCombo.getSelectedItem().toString(), enterFixedAmountJTextField.getText(), enterStartDateInStrategyJTextField.getText(), enterEndDateInStrategyJTextField1.getText(), enterFrequencyJTextField1.getText(), enterCommissionInStrategyJTextField.getText(), enterWeightsJTextField.getText());
        displayMessage("Thank You!", "Thank you for investing: $" + enterFixedAmountJTextField.getText() + " on portfolio: " + portfolioNameInStrategyJCombo.getSelectedItem().toString());
        reset();
      } catch (NumberFormatException n) {
        displayMessage("ERROR", "Please enter weights according to the specified format.");
        enterWeightsJTextField.setText("");
      } catch (Exception e) {

        displayMessage("ERROR", e.getMessage());
      }

    });

  }

  private void reset() {
    enterFixedAmountJTextField.setText("");
    enterCommissionInStrategyJTextField.setText("");
    enterStartDateInStrategyJTextField.setText("");
    enterEndDateInStrategyJTextField1.setText("");
    currentStocksJTextArea.setText("");
    enterWeightsJTextField.setText("");
    enterFrequencyJTextField1.setText("");
  }

  private void displayMessage(String title, String message) {
    JOptionPane.showMessageDialog(null, message, "InfoBox: " + title, JOptionPane.INFORMATION_MESSAGE);
  }

}
