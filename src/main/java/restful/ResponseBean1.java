package restful;

public class ResponseBean1 {
    public ResponseBean1() {
        
    }
    //in the clear
    private String title;
    private String firstname;
    private String surname;
    //encrypted
    private String address;
    private String homeTel;
    private String workTel;
    private String mobile;
    private String personalEmail;
    private String workEmail;
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getHomeTel() {
        return homeTel;
    }
    public void setHomeTel(String homeTel) {
        this.homeTel = homeTel;
    }
    public String getWorkTel() {
        return workTel;
    }
    public void setWorkTel(String workTel) {
        this.workTel = workTel;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getPersonalEmail() {
        return personalEmail;
    }
    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = personalEmail;
    }
    public String getWorkEmail() {
        return workEmail;
    }
    public void setWorkEmail(String workEmail) {
        this.workEmail = workEmail;
    }

}
