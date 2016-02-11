package Main;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


public class Histogram {

    private static final int BINS = 256;
    private JPanel panel;
    
    public Histogram(JPanel panel){
    	this.panel = panel;
    }
    
    private ChartPanel createChartPanel(double[] k) {
        // dataset
    	XYSeries series = new XYSeries("");
    	for(int i=0;i<k.length;i++){
    		series.add(i,k[i]);
    	}
    	XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
       
        // chart
        JFreeChart chart = ChartFactory.createScatterPlot(null, null,
            null, dataset, PlotOrientation.VERTICAL, true, true, false);

        ChartPanel panel = new ChartPanel(chart);
        panel.setMouseWheelEnabled(true);
        return panel;
    }

    public void display(double[]k) {
    	panel.removeAll();
        panel.add(createChartPanel(k));
        panel.repaint();
        panel.validate();

    }

   
}
