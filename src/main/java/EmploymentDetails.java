import java.time.LocalDate;

public class EmploymentDetails {
    private LocalDate dateJoined;
    private int grade;
    private boolean isForeigner;

    public EmploymentDetails(LocalDate dateJoined, int grade, boolean isForeigner) {
        this.dateJoined = dateJoined;
        this.isForeigner = isForeigner;
    }

    public LocalDate getDateJoined() {
        return dateJoined;
    }

    public boolean isForeigner() {
        return isForeigner;
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
