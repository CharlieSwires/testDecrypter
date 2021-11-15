package restful;

public class ResponseBean2 {
    public ResponseBean2() {
        
    }
    //in the clear
    private String id;
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
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
        result = prime * result + ((homeTel == null) ? 0 : homeTel.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
        result = prime * result + ((personalEmail == null) ? 0 : personalEmail.hashCode());
        result = prime * result + ((surname == null) ? 0 : surname.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((workEmail == null) ? 0 : workEmail.hashCode());
        result = prime * result + ((workTel == null) ? 0 : workTel.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ResponseBean2 other = (ResponseBean2) obj;
        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
            return false;
        if (firstname == null) {
            if (other.firstname != null)
                return false;
        } else if (!firstname.equals(other.firstname))
            return false;
        if (homeTel == null) {
            if (other.homeTel != null)
                return false;
        } else if (!homeTel.equals(other.homeTel))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (mobile == null) {
            if (other.mobile != null)
                return false;
        } else if (!mobile.equals(other.mobile))
            return false;
        if (personalEmail == null) {
            if (other.personalEmail != null)
                return false;
        } else if (!personalEmail.equals(other.personalEmail))
            return false;
        if (surname == null) {
            if (other.surname != null)
                return false;
        } else if (!surname.equals(other.surname))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (workEmail == null) {
            if (other.workEmail != null)
                return false;
        } else if (!workEmail.equals(other.workEmail))
            return false;
        if (workTel == null) {
            if (other.workTel != null)
                return false;
        } else if (!workTel.equals(other.workTel))
            return false;
        return true;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

}
