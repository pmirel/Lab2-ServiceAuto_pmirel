package Domain;

public class ClientCard {
    private int id;
    private String firstName;
    private String secondName;
    private String CNP;
    private String birthDate;
    private String registrationDate;

    public ClientCard(int id, String firstName, String secondName, String CNP, String birthDate, String registrationDate) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.CNP = CNP;
        this.birthDate = birthDate;
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", CNP=" + CNP +
                ", birthDate=" + birthDate +
                ", registrationDate=" + registrationDate +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }
}
