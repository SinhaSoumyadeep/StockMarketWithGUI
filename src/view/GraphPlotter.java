package view;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;

/**
 * This class is used to actually plot graphs.
 */
public class GraphPlotter extends JFrame {

  /**
   * Instantiates a new Graph plotter.
   *
   * @param applicationTitle the application title
   */
  public GraphPlotter(String applicationTitle) {
    super(applicationTitle);

  }

  /**
   * This method is used to Plot graphs.
   *
   * @param dataset    the dataset
   * @param chartTitle the chart title
   */
  public void plotGraph(DefaultCategoryDataset dataset, String chartTitle) {
    JFreeChart lineChart = ChartFactory.createLineChart(
            chartTitle,
            "Days", "Total Value of Portfolio: " + chartTitle,
            dataset,
            PlotOrientation.VERTICAL,
            true, true, false);

    ChartPanel chartPanel = new ChartPanel(lineChart);
    chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
    setContentPane(chartPanel);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  }


}
