import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Employee {
    private String employeeId;
    private PersonalInfo personalInfo;
    private EmploymentDetails employmentDetails;



    public Employee(String employeeId,PersonalInfo personalInfo, EmploymentDetails employmentDetails) {
        this.employeeId = employeeId;
        this.personalInfo = personalInfo;
        this.employmentDetails = employmentDetails;
    }

    public int getAnnualIncomeTax() {
        return TaxFunction.calculateTax(employmentDetails.getIncome().getMonthlySalary(), employmentDetails.getIncome().getOtherMonthlyIncome(), employmentDetails.getMonthWorkingInYear(), employmentDetails.getIncome().getAnnualDeductible(), spouse.getId().equals(""), children.size());
    }
}
