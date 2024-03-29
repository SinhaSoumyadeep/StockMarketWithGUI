
package view;


import javax.swing.*;

import controller.Features;

/**
 * This JPannel is the view for the Creation of the Portfolio User Interface.
 */
public class CreatePortfolioJPanel extends JPanel {


  private JLabel createPortfolioHomePanel;
  private JButton createPortfolioInJPanelBtn;
  private JLabel enterPortfolioJLabel;
  private JTextField portfolioNameJTextField;


  /**
   * Instantiates a new Create portfolio j panel.
   */
  public CreatePortfolioJPanel() {
    initComponents();
  }

  /**
   * This method is the composition of the Create Portfolio view or how it would show in the GUI.
   */
  private void initComponents() {

    enterPortfolioJLabel = new JLabel();
    portfolioNameJTextField = new JTextField();
    createPortfolioInJPanelBtn = new JButton();
    createPortfolioHomePanel = new JLabel();

    enterPortfolioJLabel.setText("Please enter the name of portfolio");

    createPortfolioInJPanelBtn.setText("Create Portfolio");

    createPortfolioHomePanel.setText("Create Portfolio Panel");

    GroupLayout layout = new GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(enterPortfolioJLabel, GroupLayout.PREFERRED_SIZE, 412, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(createPortfolioInJPanelBtn, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                            .addComponent(portfolioNameJTextField, GroupLayout.Alignment.LEADING))
                                    .addComponent(createPortfolioHomePanel))
                            .addContainerGap(278, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(createPortfolioHomePanel)
                            .addGap(24, 24, 24)
                            .addComponent(enterPortfolioJLabel)
                            .addGap(18, 18, 18)
                            .addComponent(portfolioNameJTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 26, 26)
                            .addComponent(createPortfolioInJPanelBtn)
                            .addContainerGap(416, Short.MAX_VALUE))
    );
  }

  /**
   * This method is used to Delegate actions to the controller.
   *
   * @param f the object of the feature interface or controller.
   */
  public void delegateActions(Features f) {
    createPortfolioInJPanelBtn.addActionListener(l -> {
      try {
        if (portfolioNameJTextField.getText().equals("")) {
          displayMessage("Error", "Portfolio name cannot be empty!!");
        } else {
          f.createPortfolio(portfolioNameJTextField.getText());
          portfolioNameJTextField.setText("");
          portfolioNameJTextField.repaint();
        }
      } catch (Exception e) {
        displayMessage("Error", "Portfolio already exists!");
      }
    });
  }

  /**
   * This method is used to Display message in a dialogue box format.
   *
   * @param title   the title.
   * @param message the message.
   */
  private void displayMessage(String title, String message) {
    JOptionPane.showMessageDialog(null, message, "InfoBox: " + title,
            JOptionPane.INFORMATION_MESSAGE);
  }


}
