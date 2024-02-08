/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.Classes;

/**
 *
 * @author Erika Hernández
 */
import MainPackage.App;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.BasicStroke;
import java.awt.Color;
import javax.swing.Timer;


public class ChartManager {
    private final App app = App.getInstance();
    private XYSeries seriesNickelodeon;
    private XYSeries seriesCartoonNetwork;
    private XYSeriesCollection dataset;
    private JFreeChart xyLineChart;
    private Timer updateTimer;

    public ChartManager() {
        initializeSeries();
        initializeChart();
        startDataUpdateTimer();
    }

    private void initializeSeries() {
        seriesNickelodeon = new XYSeries("Nickelodeon");
        seriesCartoonNetwork = new XYSeries("Cartoon Network");
        dataset = new XYSeriesCollection();
        dataset.addSeries(seriesNickelodeon);
        dataset.addSeries(seriesCartoonNetwork);
    }

    private void initializeChart() {
        xyLineChart = ChartFactory.createXYLineChart(
                "Tiempo vs Utilidad", // Título del gráfico
                "Tiempo",             // Etiqueta eje X
                "Utilidad",           // Etiqueta eje Y
                dataset,              // Dataset
                PlotOrientation.VERTICAL,
                true,                 // Mostrar leyenda
                true,                 // Generar tooltips
                false                 // URLs
        );

        customizeChart();
    }

    private void customizeChart() {
        XYPlot plot = xyLineChart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.BLUE);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));
        plot.setRenderer(renderer);
    }

    private void startDataUpdateTimer() {
        int delay = app.getDayDuration(); 
        updateTimer = new Timer(delay, e -> updateChartData());
        updateTimer.start();
    }

    public void updateChartData() {
        // Se obtienen las nuevas ganancias
        double nickelodeonProfit = app.getNickelodeon().getProfit(); 
        double cartoonNetworkProfit = app.getCartoonNetwork().getProfit(); 
        int newTimePoint = seriesNickelodeon.getItemCount() + 1;

        seriesNickelodeon.addOrUpdate(newTimePoint, nickelodeonProfit);
        seriesCartoonNetwork.addOrUpdate(newTimePoint, cartoonNetworkProfit);
    }

    public ChartPanel getChartPanel() {
        return new ChartPanel(xyLineChart);
    }

    public void stopUpdateTimer() {
        if (updateTimer != null) {
            updateTimer.stop();
        }
    }
}
