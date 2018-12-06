
package view;

import controller.Features;


/**
 * This JPannel is the view for exiting the application with or without saving the current state of
 * the application User Interface.
 */
public class ExitJPanel extends javax.swing.JPanel {

  private javax.swing.JLabel exitJLabel;
  private javax.swing.JButton noButtonInExitBtn;
  private javax.swing.JButton yesButtonInExitBtn;

  /**
   * Creates new form ExitJFrame
   */
  public ExitJPanel() {
    initComponents();
  }


  /**
   * This method is the composition of the exit view or how it would show in the GUI.
   */
  private void initComponents() {

    exitJLabel = new javax.swing.JLabel();
    noButtonInExitBtn = new javax.swing.JButton();
    yesButtonInExitBtn = new javax.swing.JButton();

    exitJLabel.setText("Do you want to save all transactions and portfolios before quitting?");

    noButtonInExitBtn.setText("No");

    yesButtonInExitBtn.setText("Yes");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(exitJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                            .addComponent(yesButtonInExitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(30, 30, 30)
                                            .addComponent(noButtonInExitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(130, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGap(38, 38, 38)
                            .addComponent(exitJLabel)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(noButtonInExitBtn)
                                    .addComponent(yesButtonInExitBtn))
                            .addContainerGap(356, Short.MAX_VALUE))
    );
  }

  /**
   * This method is used to Delegate actions to the controller.
   *
   * @param f the object of the feature interface or controller.
   */
  public void delegateActions(Features f) {
    yesButtonInExitBtn.addActionListener(l -> {
      f.saveModel();
    });

    noButtonInExitBtn.addActionListener(l -> {
      f.terminate();
    });
  }


}
