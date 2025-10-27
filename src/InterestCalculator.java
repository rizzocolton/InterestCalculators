import java.time.LocalDate;

public class InterestCalculator {
    final double APY;
    final double APR;

    public InterestCalculator(double APY){
        this.APY=APY;
        this.APR=(Math.pow((1+APY),1.0/12.0)-1)*12;
    }

    /**
     * Calculates the total interest accrued or final principal amount using monthly compounding interest.
     * Parameters:
     * @param currentDate The starting date for the calculation.
     * @param endDate The ending date for the calculation.
     * @param principal The initial principal amount.
     * @param monthlyAmount The amount added to the principal at the end of each month.
     * @param interestOrPrincipal If true, returns total interest accrued; if false, returns final principal amount.
     */
    public double MonthlyCompoundInterest
    (LocalDate currentDate,LocalDate endDate, double principal, double monthlyAmount, boolean interestOrPrincipal){
        double dailyAcrual=(principal*APR)/365;
        double totalInterestAccrued=0;

        while(!currentDate.equals(endDate)){
            LocalDate nextDate=currentDate.plusDays(1);
            if(currentDate.getMonthValue()!=nextDate.getMonthValue()){
                double interestAccrued=dailyAcrual*currentDate.lengthOfMonth();
                totalInterestAccrued+=interestAccrued;
                principal+=interestAccrued;
                principal+=monthlyAmount;
                dailyAcrual=(principal*APR)/365;
            }
            currentDate=nextDate;
        }

        if(interestOrPrincipal){
            return totalInterestAccrued;
        }
        return principal;
    }

    public static double MonthlyInvestment
    (LocalDate currentDate,LocalDate endDate, double principal, double yearReturn, double monthlyAmount, boolean interestOrPrincipal){
        double totalInterestAccrued=0;
        //converting apy to apr
        yearReturn=(Math.pow((1+yearReturn),1.0/12.0)-1)*12;
        
        while(!currentDate.equals(endDate)){
            double interestAccured=principal*(yearReturn/365);
            totalInterestAccrued+=interestAccured;
            principal+=interestAccured;
            if(currentDate.getMonthValue()!=currentDate.plusDays(1).getMonthValue()){
                principal+=monthlyAmount;
            } 
            currentDate=currentDate.plusDays(1);
        }

        if(interestOrPrincipal){
            return totalInterestAccrued;
        }
        return principal;
    }
}
