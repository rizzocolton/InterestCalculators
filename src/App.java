import java.time.LocalDate;

public class App {
    public static void main(String[] args) throws Exception {
        InterestCalculator calculator = new InterestCalculator(0.0375);
        LocalDate today = LocalDate.now();
        LocalDate endDate = LocalDate.of(2026,5,2);
        double initialPrincipal = 4484;
        System.out.println(calculator.MonthlyCompoundInterest(today, endDate, initialPrincipal, -600, true));
        System.out.println(InterestCalculator.MonthlyInvestment(today, endDate, 10616.91, 0.1976, 40, true));
    }
}