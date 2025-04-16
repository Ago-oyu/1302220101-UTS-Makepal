public class PersonalInfo {
    private String firstName;
    private String lastName;
    private String idNumber;
    private String address;
    private boolean gender; //true = Laki-laki, false = Perempuan

    public PersonalInfo(String firstName, String lastName, String idNumber, String address, boolean gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.address = address;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getAddress() {
        return address;
    }

    public boolean isGender() {
        return gender;
    }
}
