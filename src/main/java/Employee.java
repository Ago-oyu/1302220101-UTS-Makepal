import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Employee {
    private String employeeId;
    private PersonalInfo personalInfo;
    private EmploymentDetails employmentDetails;

    private Spouse spouse;
    private List<Child> children;

    public Employee(String employeeId,PersonalInfo personalInfo, EmploymentDetails employmentDetails) {
        this.employeeId = employeeId;
        this.personalInfo = personalInfo;
        this.employmentDetails = employmentDetails;
        this.children = new LinkedList<Child>();
    }

    public void setSpouse(Spouse spouse) {
        this.spouse = spouse;
    }

    public void addChild(Child child) {
        this.children.add(child);
    }

    public int getAnnualIncomeTax() {
        return TaxFunction.calculateTax(employmentDetails.getIncome().getMonthlySalary(), employmentDetails.getIncome().getOtherMonthlyIncome(), employmentDetails.getMonthWorkingInYear(), employmentDetails.getIncome().getAnnualDeductible(), spouse.getId().equals(""), children.size());
    }
}
