/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;

import javax.swing.*;

/**
 *
 * @author Sumeet Parekh
 */
public class InvestFixedAmount extends JPanel {


    private JButton assignEqualWeightsBtn;
    private JButton assignIndividualWeightsBtn;
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
    private JComboBox<String> portfolioNameInInvestFixedJCombo;
    private List<String> portfollioList;

    /**
     * Creates new form InvestFixedAmount
     */
    public InvestFixedAmount(List<String> portfollioList) {
        this.portfollioList = portfollioList;
        initComponents();
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

        investFixedAmountHomeJLabel.setText("Invest Fixed Amount");

        enterPortfolioNameFixedAmountJLabel.setText("Enter Portfolio to Invest Fixed Amount:-");

        enterFixedAmountJLabel.setText("Enter Fixed Amount:-");

        enterDateInInvestFixedJLabel.setText("Enter Date (Format: YYYY-MM-DD):-");

        enterDateInInvestFixedJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterDateInInvestFixedJTextFieldActionPerformed(evt);
            }
        });

        enterCommissionInInvestFixedJLabel.setText("Enter Commission:-");

        assignEqualWeightsBtn.setText("Invest using Equal Weights");

        assignIndividualWeightsBtn.setText("Invest using Individual Weights");
        assignIndividualWeightsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignIndividualWeightsBtnActionPerformed(evt);
            }
        });

        enterWeightsJLabel.setText("Enter Individual Weights");

        enterWeightsFormatJLabel.setText("Format: Stock1 Weight1,Stock2 Weight2... (Example: GOOG 50,TCS 40...)");

        portfolioNameInInvestFixedJCombo.setModel(new DefaultComboBoxModel<>(portfollioList.toArray(new String[0])));

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(enterWeightsJLabel, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                        .addComponent(enterWeightsFormatJLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(enterWeightsJTextField)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(assignEqualWeightsBtn, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(investFixedAmountHomeJLabel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(enterPortfolioNameFixedAmountJLabel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                            .addComponent(enterFixedAmountJLabel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(enterFixedAmountJTextField, GroupLayout.Alignment.LEADING)
                            .addComponent(enterDateInInvestFixedJLabel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(enterDateInInvestFixedJTextField, GroupLayout.Alignment.LEADING)
                            .addComponent(enterCommissionInInvestFixedJLabel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(enterCommissionInInvestFixedJTextField, GroupLayout.Alignment.LEADING)))
                    .addComponent(assignIndividualWeightsBtn, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE)
                    .addComponent(portfolioNameInInvestFixedJCombo, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(267, Short.MAX_VALUE))
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
                .addGap(29, 29, 29)
                .addComponent(assignEqualWeightsBtn)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(enterWeightsJLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(enterWeightsFormatJLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(enterWeightsJTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(assignIndividualWeightsBtn)
                .addContainerGap(72, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void enterDateInInvestFixedJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterDateInInvestFixedJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enterDateInInvestFixedJTextFieldActionPerformed

    private void assignIndividualWeightsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignIndividualWeightsBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_assignIndividualWeightsBtnActionPerformed


}
