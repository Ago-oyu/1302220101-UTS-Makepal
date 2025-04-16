import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Employee {
    private String employeeId;
    private PersonalInfo personalInfo;

    private EmploymentDetails employmentDetails;

    private int monthlySalary;
    private int otherMonthlyIncome;
    private int annualDeductible;

    private Spouse spouse;

    private List<Child> children;

    public Employee(String employeeId,PersonalInfo personalInfo, EmploymentDetails employmentDetails) {
        this.employeeId = employeeId;
       this.personalInfo = personalInfo;
        this.employmentDetails = employmentDetails;

        this.children = new LinkedList<Child>();
    }

    /**
     * Fungsi untuk menentukan gaji bulanan pegawai berdasarkan grade kepegawaiannya (grade 1: 3.000.000 per bulan, grade 2: 5.000.000 per bulan, grade 3: 7.000.000 per bulan)
     * Jika pegawai adalah warga negara asing gaji bulanan diperbesar sebanyak 50%
     */

    public void setMonthlySalary(int grade) {
        int baseSalary = 0;

        if (grade == 1) {
            baseSalary = 3000000;
        }else if (grade == 2) {
            baseSalary = 5000000;
        }else if (grade == 3) {
            baseSalary = 7000000;
        }

        if (employmentDetails.isForeigner()) {
            monthlySalary = (int) (baseSalary * 1.5);
        }
    }

    public void setAnnualDeductible(int deductible) {
        this.annualDeductible = deductible;
    }

    public void setAdditionalIncome(int income) {
        this.otherMonthlyIncome = income;
    }

    public void setSpouse(Spouse spouse) {
        this.spouse = spouse;
    }

    public void addChild(Child child) {
        this.children.add(child);
    }

    public int getAnnualIncomeTax() {
        return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome, employmentDetails.getMonthWorkingInYear(), annualDeductible, spouse.getId().equals(""), children.size());
    }
}
