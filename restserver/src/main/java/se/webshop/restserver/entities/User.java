package se.webshop.restserver.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;

@Entity
public class User {
    // Should be set from the Authentication API, OAuth2 id should be used
    @Id
    @NotNull
    @JsonIgnore
    private String hashId;
    
    //Information that the user should see --> 
    private String firstName;
    private String lastName;
    private String email;
    private String billingAddress;
    private String city;
    private Integer zipCode;
    //<--
    
    @NotNull
    @JsonIgnore
    private LocalDateTime dateJoined;

    //TODO make this work!!!!
    @NotNull
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_role")
    private Role role;
    
    public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public LocalDateTime getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(LocalDateTime dateJoined) {
        this.dateJoined = dateJoined;
    }

    public String toString() {
    	return "first name: " + firstName + "\n"+
    			"last name: " + lastName + "\n"+
    			"email: " + email + "\n"+
    			"billingAddress: " + billingAddress + "\n"+
    			"city: " + city + "\n"+
    			"zipcode: " + zipCode + "\n";
    	
    	
    }
}
