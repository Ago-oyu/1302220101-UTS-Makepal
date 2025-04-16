public class TaxFunction {
    /**
     * Fungsi untuk menghitung jumlah pajak penghasilan pegawai yang harus dibayarkan setahun.
     *
     * Pajak dihitung sebagai 5% dari penghasilan bersih tahunan (gaji dan pemasukan bulanan lainnya dikalikan jumlah bulan bekerja dikurangi pemotongan) dikurangi penghasilan tidak kena pajak.
     *
     * Jika pegawai belum menikah dan belum punya anak maka penghasilan tidak kena pajaknya adalah Rp 54.000.000.
     * Jika pegawai sudah menikah maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000.
     * Jika pegawai sudah memiliki anak maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000 per anak sampai anak ketiga.
     *
     */


    public static int calculateTax(Employee employee) {
        validateMonthWorkingInYear(employee);

        int totalIncome = calculteTotalIncome(employee);
        return calculateFinalTax(totalIncome);
    }

    private static void validateMonthWorkingInYear(Employee employee) {
        if (employee.getEmploymentDetails().getMonthWorkingInYear() > 12) {
            System.err.println("More than 12 month working per year");
        }
    }

    private  static int limitNumberOfChildren(int numberOfChildren) {
        if (numberOfChildren > 3) {
            return 3;
        }
        return numberOfChildren;
    }

    private static int calculteTotalIncome(Employee employee) {
        int numberOfChildren = limitNumberOfChildren(employee.getPersonalInfo().getChildren().size());

        if (employee.getPersonalInfo().hasSpouse()) {
            return (((employee.getEmploymentDetails().getIncome().getMonthlySalary() + employee.getEmploymentDetails().getIncome().getOtherMonthlyIncome()) * employee.getEmploymentDetails().getMonthWorkingInYear()) - employee.getEmploymentDetails().getIncome().getAnnualDeductible() - (54000000 + 4500000 + (numberOfChildren * 1500000)));
        } else {
           return  (((employee.getEmploymentDetails().getIncome().getMonthlySalary() + employee.getEmploymentDetails().getIncome().getOtherMonthlyIncome()) * employee.getEmploymentDetails().getMonthWorkingInYear()) - employee.getEmploymentDetails().getIncome().getAnnualDeductible() - 54000000);
        }

    }

    private static int calculateFinalTax(int totalIncome) {
        int tax = (int) Math.round(0.5 * totalIncome);
        if (tax < 0) {
            return 0;
        }
        return tax;
    }
}
