public class Income {
    private int monthlySalary;
    private int otherMonthlyIncome;
    private int annualDeductible;

    public Income(EmploymentDetails employmentDetails,int otherMonthlyIncome, int annualDeductible) {
        setMonthlySalary(employmentDetails);
        this.otherMonthlyIncome = otherMonthlyIncome;
        this.annualDeductible = annualDeductible;
    }

    public int getMonthlySalary() {
        return monthlySalary;
    }

    public int getOtherMonthlyIncome() {
        return otherMonthlyIncome;
    }

    public int getAnnualDeductible() {
        return annualDeductible;
    }

    /**
     * Fungsi untuk menentukan gaji bulanan pegawai berdasarkan grade kepegawaiannya (grade 1: 3.000.000 per bulan, grade 2: 5.000.000 per bulan, grade 3: 7.000.000 per bulan)
     * Jika pegawai adalah warga negara asing gaji bulanan diperbesar sebanyak 50%
     */
    public void setMonthlySalary(EmploymentDetails employmentDetails) {
        int baseSalary = 0;

        if (employmentDetails.getGrade() == 1) {
            baseSalary = 3000000;
        }else if (employmentDetails.getGrade() == 2) {
            baseSalary = 5000000;
        }else if (employmentDetails.getGrade() == 3) {
            baseSalary = 7000000;
        }

        if (employmentDetails.isForeigner()) {
            monthlySalary = (int) (baseSalary * 1.5);
        }
    }


}
