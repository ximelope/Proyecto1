package interfaz_grafica;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import modeloGaleria.Galeria;
import Tarjetalol.PaymentInfo;

public class DiagramaVentas {
    public static void showChart(Galeria galeria) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Diagrama mensual de ventas");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(1000, 600);

            ChartPanel chartPanel = new ChartPanel(galeria.getVentasGrafico());
            chartPanel.setPreferredSize(new Dimension(800, 500));

            frame.add(chartPanel);
            frame.pack();
            frame.setVisible(true);
        });
    }

    private static class ChartPanel extends JPanel {
        private final Map<String, Integer> salesCount = new HashMap<>();
        private static final int PADDING = 50;
        private static final int BAR_WIDTH = 40;
        private static final int BAR_GAP = 10;
        private static final Color BAR_COLOR = new Color(79, 129, 189);

        public ChartPanel(Map<String, List<PaymentInfo>> ventasGrafico) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

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
                salesCount.putIfAbsent(monthYear, 0);
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

            int width = getWidth();
            int height = getHeight();
            int chartWidth = width - 2 * PADDING;
            int chartHeight = height - 2 * PADDING;

            // Dibujar el fondo del gráfico
            g2d.setColor(Color.WHITE);
            g2d.fillRect(PADDING, PADDING, chartWidth, chartHeight);
            g2d.setColor(Color.LIGHT_GRAY);
            g2d.drawRect(PADDING, PADDING, chartWidth, chartHeight);

            // Calcular el máximo de ventas para la escala
            int maxSales = salesCount.values().stream().max(Integer::compare).orElse(0);

            // Dibujar las barras
            int x = PADDING;
            for (Month month : Month.values()) {
                String monthYear = month.getDisplayName(TextStyle.SHORT, Locale.getDefault()) + "-" + LocalDate.now().getYear();
                int sales = salesCount.getOrDefault(monthYear, 0);

                int barHeight = (int) ((sales / (double) maxSales) * chartHeight);
                g2d.setColor(BAR_COLOR);
                g2d.fillRect(x, height - PADDING - barHeight, BAR_WIDTH, barHeight);
                g2d.setColor(Color.BLACK);
                g2d.drawRect(x, height - PADDING - barHeight, BAR_WIDTH, barHeight);

                // Dibujar la etiqueta del mes
                g2d.drawString(month.getDisplayName(TextStyle.SHORT, Locale.getDefault()), x, height - PADDING + 20);

                x += BAR_WIDTH + BAR_GAP;
            }

            // Dibujar las cantidades de ventas a la izquierda
            int numYLabels = 10;
            for (int i = 0; i <= numYLabels; i++) {
                int y = PADDING + i * chartHeight / numYLabels;
                int sales = maxSales * (numYLabels - i) / numYLabels;
                String label = String.valueOf(sales);
                int labelWidth = g2d.getFontMetrics().stringWidth(label);
                g2d.drawString(label, PADDING - labelWidth - 5, y);
                g2d.drawLine(PADDING - 5, y, PADDING, y);
            }
        }
    }
}
