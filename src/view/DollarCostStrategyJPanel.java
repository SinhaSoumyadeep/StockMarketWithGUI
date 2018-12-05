/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;

/**
 *
 * @author Sumeet Parekh
 */
public class DollarCostStrategyJPanel extends javax.swing.JPanel {

    private javax.swing.JLabel StrategyHomeJLabel;
    private javax.swing.JButton assignIndividualWeightsBtn;
    private javax.swing.JLabel enterCommissionInStrategyJLabel;
    private javax.swing.JTextField enterCommissionInStrategyJTextField;
    private javax.swing.JLabel enterEndDateInStrategyJLabel1;
    private javax.swing.JTextField enterEndDateInStrategyJTextField1;
    private javax.swing.JLabel enterFixedAmountJLabel;
    private javax.swing.JTextField enterFixedAmountJTextField;
    private javax.swing.JLabel enterFrequencyJLabel1;
    private javax.swing.JTextField enterFrequencyJTextField1;
    private javax.swing.JLabel enterPortfolioNameStrategyJLabel;
    private javax.swing.JLabel enterStartDateInStrategyJLabel;
    private javax.swing.JTextField enterStartDateInStrategyJTextField;
    private javax.swing.JLabel enterWeightsFormatJLabel;
    private javax.swing.JLabel enterWeightsJLabel;
    private javax.swing.JTextField enterWeightsJTextField;
    private javax.swing.JComboBox<String> portfolioNameInStrategyJCombo;
    private List<String> portfollioList;


    /**
     * Creates new form DollarCostStrategyJPanel
     */
    public DollarCostStrategyJPanel(List<String> portfollioList) {
        this.portfollioList = portfollioList;
        initComponents();
    }


    private void initComponents() {

        enterStartDateInStrategyJLabel = new javax.swing.JLabel();
        enterStartDateInStrategyJTextField = new javax.swing.JTextField();
        portfolioNameInStrategyJCombo = new javax.swing.JComboBox<>();
        enterCommissionInStrategyJLabel = new javax.swing.JLabel();
        enterCommissionInStrategyJTextField = new javax.swing.JTextField();
        StrategyHomeJLabel = new javax.swing.JLabel();
        assignIndividualWeightsBtn = new javax.swing.JButton();
        enterPortfolioNameStrategyJLabel = new javax.swing.JLabel();
        enterWeightsJLabel = new javax.swing.JLabel();
        enterFixedAmountJLabel = new javax.swing.JLabel();
        enterWeightsFormatJLabel = new javax.swing.JLabel();
        enterWeightsJTextField = new javax.swing.JTextField();
        enterFixedAmountJTextField = new javax.swing.JTextField();
        enterEndDateInStrategyJLabel1 = new javax.swing.JLabel();
        enterEndDateInStrategyJTextField1 = new javax.swing.JTextField();
        enterFrequencyJLabel1 = new javax.swing.JLabel();
        enterFrequencyJTextField1 = new javax.swing.JTextField();

        enterStartDateInStrategyJLabel.setText("Enter Start Date (Format: YYYY-MM-DD):-");

        enterStartDateInStrategyJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterStartDateInStrategyJTextFieldActionPerformed(evt);
            }
        });

        portfolioNameInStrategyJCombo.setModel(new javax.swing.DefaultComboBoxModel<>(portfollioList.toArray(new String[0])));

        enterCommissionInStrategyJLabel.setText("Enter Commission:-");

        StrategyHomeJLabel.setText("Dollar Cost Averaging Strategy");

        assignIndividualWeightsBtn.setText("Invest using Individual Weights");
        assignIndividualWeightsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignIndividualWeightsBtnActionPerformed(evt);
            }
        });

        enterPortfolioNameStrategyJLabel.setText("Enter Portfolio to Invest Fixed Amount:-");

        enterWeightsJLabel.setText("Enter Individual Weights");

        enterFixedAmountJLabel.setText("Enter Fixed Amount:-");

        enterWeightsFormatJLabel.setText("Format: Stock1 Weight1,Stock2 Weight2... (Example: GOOG 50,TCS 40...)");

        enterEndDateInStrategyJLabel1.setText("Enter End Date (Format: YYYY-MM-DD):-");

        enterEndDateInStrategyJTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterEndDateInStrategyJTextField1ActionPerformed(evt);
            }
        });

        enterFrequencyJLabel1.setText("Enter Frequency (in days):-");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(enterWeightsJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(enterWeightsFormatJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(enterWeightsJTextField)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(StrategyHomeJLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(enterPortfolioNameStrategyJLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(enterFixedAmountJLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(enterFixedAmountJTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(enterStartDateInStrategyJLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(enterStartDateInStrategyJTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(enterCommissionInStrategyJLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(enterCommissionInStrategyJTextField, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addComponent(assignIndividualWeightsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(portfolioNameInStrategyJCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(enterEndDateInStrategyJLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(enterEndDateInStrategyJTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(enterFrequencyJLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                        .addComponent(enterFrequencyJTextField1, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(317, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(StrategyHomeJLabel)
                .addGap(18, 18, 18)
                .addComponent(enterPortfolioNameStrategyJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(portfolioNameInStrategyJCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(enterFixedAmountJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(enterFixedAmountJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(enterStartDateInStrategyJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(enterStartDateInStrategyJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(enterEndDateInStrategyJLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(enterEndDateInStrategyJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(enterFrequencyJLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(enterFrequencyJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(enterCommissionInStrategyJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(enterCommissionInStrategyJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(enterWeightsJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(enterWeightsFormatJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(enterWeightsJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(assignIndividualWeightsBtn)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void enterStartDateInStrategyJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterStartDateInStrategyJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enterStartDateInStrategyJTextFieldActionPerformed

    private void assignIndividualWeightsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignIndividualWeightsBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_assignIndividualWeightsBtnActionPerformed

    private void enterEndDateInStrategyJTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterEndDateInStrategyJTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enterEndDateInStrategyJTextField1ActionPerformed



}
