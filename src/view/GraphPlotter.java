package view;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;

public class GraphPlotter extends JFrame {

  public GraphPlotter( String applicationTitle) {
    super(applicationTitle);

  }

  public void plotGraph(DefaultCategoryDataset dataset, String chartTitle )
  {
    JFreeChart lineChart = ChartFactory.createLineChart(
            chartTitle,
            "Days","Total Value of Portfolio: "+chartTitle,
            dataset,
            PlotOrientation.VERTICAL,
            true,true,false);

    ChartPanel chartPanel = new ChartPanel( lineChart );
    chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
    setContentPane( chartPanel );
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  }




}
