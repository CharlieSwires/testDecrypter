package primary;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import restful.Encryption;
/**
 * Copyright 2021 Charles Swires All Rights Reserved
 * @author charl
 *
 */
@Document(collection="Entries")
public class PrimaryMongoBean {
    final static String publicKey;
    final static String privateKey;
    static {
        publicKey=System.getenv("ADDRESSBOOK_PUBLIC_KEY");
        privateKey=System.getenv("ADDRESSBOOK_PRIVATE_KEY");
    }
	public PrimaryMongoBean() {
	}

	
    @Id
    private String id;
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
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
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
        return (address != null && !address.isEmpty()? Encryption.decrypt(privateKey, address):null);
    }
    public void setAddress(String address) {
        this.address = (address != null && !address.isEmpty()? Encryption.encrypt(publicKey, address):null);
    }
    public String getHomeTel() {
        return (homeTel != null && !homeTel.isEmpty()? Encryption.decrypt(privateKey, homeTel):null);
    }
    public void setHomeTel(String homeTel) {
        this.homeTel = (homeTel != null && !homeTel.isEmpty()? Encryption.encrypt(publicKey,homeTel):null);
    }
    public String getWorkTel() {
        return (workTel != null && !workTel.isEmpty()? Encryption.decrypt(privateKey, workTel):null);
    }
    public void setWorkTel(String workTel) {
        this.workTel = (workTel != null && !workTel.isEmpty()? Encryption.encrypt(publicKey,workTel):null);
    }
    public String getMobile() {
        return (mobile != null && !mobile.isEmpty()? Encryption.decrypt(privateKey, mobile): null);
    }
    public void setMobile(String mobile) {
        this.mobile = (mobile != null && !mobile.isEmpty()? Encryption.encrypt(publicKey,mobile):null);
    }
    public String getPersonalEmail() {
        return (personalEmail != null && !personalEmail.isEmpty()? Encryption.decrypt(privateKey, personalEmail): null);
    }
    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = (personalEmail != null && !personalEmail.isEmpty()? Encryption.encrypt(publicKey, personalEmail): null);
    }
    public String getWorkEmail() {
        return (workEmail != null && !workEmail.isEmpty()? Encryption.decrypt(privateKey, workEmail): null);
    }
    public void setWorkEmail(String workEmail) {
        this.workEmail = (workEmail != null && !workEmail.isEmpty()? Encryption.encrypt(publicKey, workEmail): null);
    }

}
