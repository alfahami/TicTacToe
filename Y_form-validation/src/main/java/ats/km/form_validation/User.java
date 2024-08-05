package ats.km.form_validation;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import ats.km.form_validation.validation.Age;
import ats.km.form_validation.validation.Username;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class User {

    @NotBlank(message = "First name cannot be blank") 
    @Size(min = 2, message = "First name is too short")
    private String firstName;
    @NotBlank(message = "Last name cannot be blank") 
    @Size(min = 2, message = "Last name is too short")
    private String lastName;
    @Username(message = "Cannot contain special characters or uppercase characters")
    private String userName;
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "Birth date must be in the past")
    @Age(message = "Must at least be 18")
    private Date dateOfBirth;

    public User() {
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

}
