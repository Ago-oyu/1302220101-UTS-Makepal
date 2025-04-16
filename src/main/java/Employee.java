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
        return TaxFunction.calculateTax(this);
    }

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public EmploymentDetails getEmploymentDetails() {
        return employmentDetails;
    }
}
