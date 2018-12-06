
package view;

import java.util.List;

import javax.swing.*;

import controller.Features;
import validation.Validator;


public class BuyStocksJPanel extends JPanel {


  private JLabel buyStocksHomePanel;
  private JButton buyStocksJPanelBtn;
  private JLabel enterCommissionJLabel;
  private JTextField enterCommissionJTextField;
  private JLabel enterDateJLabel;
  private JTextField enterDateJTextField;
  private JLabel enterPortfolioNameJLabel;
  private JLabel enterStocksJLabel;
  private JTextField enterStocksJTextField;
  private JLabel enterTickerJLabel;
  private JTextField enterTickerJTextField;
  private JComboBox<String> portfolioDropDownInBuyStocksJCombo;
  private List<String> portfollioList;

  /**
   * Creates new form BuyStocksJPanel
   */
  public BuyStocksJPanel(List<String> portfollioList) {
    this.portfollioList = portfollioList;
    initComponents();
  }


  private void initComponents() {

    enterTickerJLabel = new JLabel();
    enterTickerJTextField = new JTextField();
    enterDateJLabel = new JLabel();
    enterDateJTextField = new JTextField();
    enterStocksJLabel = new JLabel();
    enterStocksJTextField = new JTextField();
    enterPortfolioNameJLabel = new JLabel();
    buyStocksJPanelBtn = new JButton();
    buyStocksHomePanel = new JLabel();
    enterCommissionJLabel = new JLabel();
    enterCommissionJTextField = new JTextField();
    portfolioDropDownInBuyStocksJCombo = new JComboBox<>();

    enterTickerJLabel.setText("Enter Ticker:-");

    enterDateJLabel.setText("Enter Date (Format: YYYY-MM-DD):-");

    enterStocksJLabel.setText("Enter number of stocks to buy:-");

    enterPortfolioNameJLabel.setText("Enter portfolio to add stocks:-");

    buyStocksJPanelBtn.setText("Buy Stocks");

    buyStocksHomePanel.setText("Buy Stocks Panel");

    enterCommissionJLabel.setText("Enter Commission:-");

    portfolioDropDownInBuyStocksJCombo.setModel(new DefaultComboBoxModel<>(portfollioList.toArray(new String[0])));


    GroupLayout layout = new GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(enterTickerJLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(enterTickerJTextField)
                                    .addComponent(enterDateJLabel, GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                                    .addComponent(enterDateJTextField)
                                    .addComponent(enterStocksJLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(enterStocksJTextField)
                                    .addComponent(enterPortfolioNameJLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(buyStocksJPanelBtn)
                                    .addComponent(buyStocksHomePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(enterCommissionJLabel)
                                    .addComponent(enterCommissionJTextField)
                                    .addComponent(portfolioDropDownInBuyStocksJCombo, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addContainerGap(382, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(buyStocksHomePanel)
                            .addGap(18, 18, 18)
                            .addComponent(enterTickerJLabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(enterTickerJTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(35, 35, 35)
                            .addComponent(enterDateJLabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(enterDateJTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(32, 32, 32)
                            .addComponent(enterStocksJLabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(enterStocksJTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 26, 26)
                            .addComponent(enterCommissionJLabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(enterCommissionJTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                            .addComponent(enterPortfolioNameJLabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(portfolioDropDownInBuyStocksJCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(35, 35, 35)
                            .addComponent(buyStocksJPanelBtn)
                            .addGap(43, 43, 43))
    );
  }

  public void delegateActions(Features f) {
    buyStocksJPanelBtn.addActionListener(l -> {
      Validator v = new Validator();
      if (v.checkDateValidity(enterDateJTextField.getText())) {
        return;
      } else if (v.checkNumberOfStocksValidity(enterStocksJTextField.getText())) {
        return;
      } else if (v.checkCommissionValidity(enterCommissionJTextField.getText())) {
        return;
      }
      f.buyStocks(enterTickerJTextField.getText(), enterDateJTextField.getText(), enterStocksJTextField.getText(), enterCommissionJTextField.getText(), portfolioDropDownInBuyStocksJCombo.getSelectedItem().toString());
      reset();
      repaint();
    });
  }

  private void reset() {
    enterTickerJTextField.setText("");
    enterDateJTextField.setText("");
    enterStocksJTextField.setText("");
    enterCommissionJTextField.setText("");
  }


}
