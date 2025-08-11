package m;
import javax.swing.JOptionPane;

public class SalaryQualifier {

    public static void main(String[] args) {
        // Ask for annual salary
        String salaryStr = JOptionPane.showInputDialog(
            null,
            "Enter your annual salary:",
            "Salary Input",
            JOptionPane.QUESTION_MESSAGE
        );
        double salary = Double.parseDouble(salaryStr);

        // Ask for credit rating
        String ratingStr = JOptionPane.showInputDialog(
            null,
            "Enter your credit rating (1–10):",
            "Credit Rating Input",
            JOptionPane.QUESTION_MESSAGE
        );
        int rating = Integer.parseInt(ratingStr);

        // Decision
        if (salary >= 20000 && rating >= 7) {
            qualify();
        } else {
            noQualify();
        }
    }

    public static void qualify() {
        JOptionPane.showMessageDialog(
            null,
            "You qualify for the credit card.",
            "Result",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void noQualify() {
        JOptionPane.showMessageDialog(
            null,
            "You do not qualify.",
            "Result",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}
