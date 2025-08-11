package m;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SalesReport {

    public static void main(String[] args) throws IOException {
        String filename = getFileName();
        double total = getTotalSales(filename);
        double average = total / 30.0;
        displayResults(total, average);
    }

    // 1) ask for filename (returns String)
    public static String getFileName() {
        return JOptionPane.showInputDialog(
            null,
            "Enter the name of the file\ncontaining 30 days of sales amounts.",
            "Input",
            JOptionPane.QUESTION_MESSAGE
        );
    }

    // 2) read 30 doubles from file and return total
    public static double getTotalSales(String filename) throws IOException {
        File file = new File(filename);
        if (!file.exists()) {
            JOptionPane.showMessageDialog(null,
                "File not found:\n" + file.getAbsolutePath(),
                "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        double total = 0.0;
        try (Scanner in = new Scanner(file)) {
            while (in.hasNextDouble()) {
                total += in.nextDouble();
            }
        }
        return total;
    }

    // 3) show total and average
    public static void displayResults(double total, double average) {
        String msg = String.format(
            "The total sales for the period is $%,.2f%nThe average daily sales were $%,.2f",
            total, average
        );
        JOptionPane.showMessageDialog(null, msg, "Message", JOptionPane.INFORMATION_MESSAGE);
    }
}