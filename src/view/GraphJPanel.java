
package view;


import java.util.List;

import javax.swing.*;


import controller.Features;
import validation.Validator;

public class GraphJPanel extends JPanel {


  private JLabel enterEndDateInPlotGraphJLabel1;
  private JTextField enterEndDateInPlotGraphJTextField1;
  private JLabel enterFrequencyInPlotGraphJLabel1;
  private JTextField enterFrequencyInPlotGraphJTextField1;
  private JLabel enterPortfolioNameGraphJLabel;
  private JLabel enterStartDateInPlotGraphJLabel;
  private JTextField enterStartDateInPlotGraphJTextField;
  private JButton plotGraphBtn;
  private JLabel plotGraphHomeJLabel;
  private JComboBox<String> portfolioNameInPlotGraphJCombo;
  private List<String> portfollioList;


  /**
   * Creates new form GraphJPanel
   */
  public GraphJPanel(List<String> portfollioList) {
    this.portfollioList = portfollioList;
    initComponents();
  }


  private void initComponents() {

    portfolioNameInPlotGraphJCombo = new JComboBox<>();
    enterPortfolioNameGraphJLabel = new JLabel();
    enterStartDateInPlotGraphJLabel = new JLabel();
    enterStartDateInPlotGraphJTextField = new JTextField();
    enterEndDateInPlotGraphJLabel1 = new JLabel();
    enterEndDateInPlotGraphJTextField1 = new JTextField();
    enterFrequencyInPlotGraphJLabel1 = new JLabel();
    enterFrequencyInPlotGraphJTextField1 = new JTextField();
    plotGraphHomeJLabel = new JLabel();
    plotGraphBtn = new JButton();

    portfolioNameInPlotGraphJCombo.setModel(new DefaultComboBoxModel<>(portfollioList.toArray(new String[0])));

    enterPortfolioNameGraphJLabel.setText("Enter Portfolio to Invest Fixed Amount:-");

    enterStartDateInPlotGraphJLabel.setText("Enter Start Date (Format: YYYY-MM-DD):-");

    enterEndDateInPlotGraphJLabel1.setText("Enter End Date (Format: YYYY-MM-DD):-");

    enterFrequencyInPlotGraphJLabel1.setText("Enter Frequency (in days):-");

    plotGraphHomeJLabel.setText("Plot Graph");

    plotGraphBtn.setText("Plot Graph");


    GroupLayout layout = new GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(enterStartDateInPlotGraphJLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(enterStartDateInPlotGraphJTextField))
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(enterEndDateInPlotGraphJLabel1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(enterEndDateInPlotGraphJTextField1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(enterFrequencyInPlotGraphJLabel1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(enterFrequencyInPlotGraphJTextField1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(enterPortfolioNameGraphJLabel, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(portfolioNameInPlotGraphJCombo, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(plotGraphHomeJLabel)
                                    .addComponent(plotGraphBtn))
                            .addContainerGap(347, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(plotGraphHomeJLabel)
                            .addGap(31, 31, 31)
                            .addComponent(enterPortfolioNameGraphJLabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(portfolioNameInPlotGraphJCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(enterStartDateInPlotGraphJLabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(enterStartDateInPlotGraphJTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(enterEndDateInPlotGraphJLabel1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(enterEndDateInPlotGraphJTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(enterFrequencyInPlotGraphJLabel1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(enterFrequencyInPlotGraphJTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(plotGraphBtn)
                            .addContainerGap(127, Short.MAX_VALUE))
    );
  }

  public void delegateActions(Features f) {
    plotGraphBtn.addActionListener(l -> {
      Validator v = new Validator();
      if (v.checkStartDateEndDateValidity(enterStartDateInPlotGraphJTextField.getText(),
              enterEndDateInPlotGraphJTextField1.getText())) {
        return;
      } else if (v.checkFrequencyValidity(enterFrequencyInPlotGraphJTextField1.getText())) {
        return;
      }
      f.plotGraph(portfolioNameInPlotGraphJCombo.getSelectedItem().toString(), enterStartDateInPlotGraphJTextField.getText(), enterEndDateInPlotGraphJTextField1.getText(), enterFrequencyInPlotGraphJTextField1.getText());
    });

  }


}