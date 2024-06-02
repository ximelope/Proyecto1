package interfaz_grafica;

import java.awt.Color;
import java.awt.Dimension;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import modeloGaleria.Galeria;
import Tarjetalol.PaymentInfo;

public class DiagramaVentas {
    public static void showChart(Galeria galeria) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Diagrama mensual de ventas");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(1000, 600);

            JFreeChart chart = createChart(galeria.getVentasGrafico());
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(800, 500));

            frame.add(chartPanel);
            frame.pack();
            frame.setVisible(true);
        });
    }

    private static JFreeChart createChart(Map<String, List<PaymentInfo>> ventasGrafico) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Map<String, Integer> salesCount = new HashMap<>();

        // Contar las ventas por mes
        for (Map.Entry<String, List<PaymentInfo>> entry : ventasGrafico.entrySet()) {
            String date = entry.getKey();
            List<PaymentInfo> payments = entry.getValue();

            LocalDate localDate = LocalDate.parse(date, formatter);
            String monthYear = localDate.getMonth().getDisplayName(TextStyle.SHORT, Locale.getDefault()) + "-" + localDate.getYear();
            
            salesCount.put(monthYear, salesCount.getOrDefault(monthYear, 0) + payments.size());
        }

        int currentYear = LocalDate.now().getYear();
        
        // Asegurarse de que todos los meses estén presentes en el dataset, incluso si no tienen datos
        for (Month month : Month.values()) {
            String monthYear = month.getDisplayName(TextStyle.SHORT, Locale.getDefault()) + "-" + currentYear;
            int sales = salesCount.getOrDefault(monthYear, 0);
            dataset.addValue(sales, "Ventas", monthYear);
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Diagrama mensual de ventas", // chart title
                "Mes",                        // x-axis label
                "Ventas",                     // y-axis label
                dataset,                      // data
                org.jfree.chart.plot.PlotOrientation.VERTICAL,
                false,                        // include legend
                true,                         // tooltips
                false                         // URLs
        );

        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setDomainGridlinePaint(Color.LIGHT_GRAY);
        plot.setRangeGridlinePaint(Color.LIGHT_GRAY);

        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(
            org.jfree.chart.axis.CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0)
        );

        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, new Color(79, 129, 189));

        return chart;
    }
}
