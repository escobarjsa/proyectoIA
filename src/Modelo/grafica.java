package Modelo;

import java.util.ArrayList;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class grafica {

    JFreeChart chart;
    ChartFrame frame;
    private ArrayList<Double> puntos = new ArrayList<Double>();

    public void setPuntos(ArrayList<Double> puntos) {
        this.puntos = puntos;
    }

    public void graficar() {
        XYSeries series = new XYSeries("Grafica");
        XYSeriesCollection SC = new XYSeriesCollection();//Objeto para crear mas de una linea dentro de la grafica
        XYDataset DS = SC;
        int i = 0;
        for (i = 0; i < puntos.size(); i = i + 100) {
            if (i <= puntos.size()) {
                series.add((i + 1), puntos.get(i));
            }
        }
        //series.add(i + 1,puntos.size() -1);//Grafica la ultima iteracion
        SC.addSeries(series);
        chart = ChartFactory.createXYLineChart("Grafica", "Ciclo", "Costo", DS, PlotOrientation.VERTICAL, true, true, true);
        XYPlot plot = (XYPlot) chart.getPlot();
        XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer) plot.getRenderer();
        //xylineandshaperenderer.setBaseShapesVisible(true);//Muestra el punto de la serie
        frame = new ChartFrame("Grafica", chart);
        frame.pack();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }

}
