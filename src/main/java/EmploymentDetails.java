import java.time.LocalDate;

public class EmploymentDetails {
    private LocalDate dateJoined;
    private int grade;
    private boolean isForeigner;
    private Income income;

    public EmploymentDetails(LocalDate dateJoined, int grade, boolean isForeigner, int otherMonthlyIncome, int annualDeductible) {
        this.dateJoined = dateJoined;
        this.isForeigner = isForeigner;
        this.income = new Income(this, otherMonthlyIncome, annualDeductible);
    }

    public LocalDate getDateJoined() {
        return dateJoined;
    }

    public boolean isForeigner() {
        return isForeigner;
    }

    public int getGrade() {
        return grade;
    }

    public Income getIncome() {
        return income;
    }

    public int getMonthWorkingInYear() {
        LocalDate date = LocalDate.now();

        if (date.getYear() == dateJoined.getYear()) {
            return date.getMonthValue() - dateJoined.getMonthValue();
        }else {
            return 12;
        }
    }
}
