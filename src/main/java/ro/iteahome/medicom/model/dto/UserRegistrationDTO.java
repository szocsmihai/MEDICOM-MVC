package ro.iteahome.medicom.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class UserRegistrationDTO {

// FIELDS: -------------------------------------------------------------------------------------------------------------

    //NO ID.

    @NotBlank(message = "CNP CANNOT BE EMPTY.")
    @Pattern(regexp = "[1-8]\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12]\\d|3[01])(0[1-9]|[1-4]\\d|5[0-2]|99)\\d{4}", message = "INVALID CNP")
    private String cnp;

    @NotBlank(message = "EMAIL CANNOT BE NULL.")
    @Email(regexp = ".+@.+\\..+", message = "INVALID EMAIL ADDRESS")
    private String email;

    @NotBlank(message = "PASSWORD CANNOT BE NULL.")
    @Pattern(regexp = "((?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*]).{8,100})", message = "INVALID PASSWORD")
    private String password;

    @NotBlank(message = "PASSWORD CANNOT BE NULL.")
    @Pattern(regexp = "((?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*]).{8,100})", message = "INVALID PASSWORD")
    private String retypedPassword;

    @NotBlank(message = "FIRST NAME CANNOT BE EMPTY.")
    private String firstName;

    @NotBlank(message = "LAST NAME CANNOT BE EMPTY.")
    private String lastName;

    // NO STATUS.

    // NO ROLE.

// METHODS: ------------------------------------------------------------------------------------------------------------

    public UserRegistrationDTO() {
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRetypedPassword() {
        return retypedPassword;
    }

    public void setRetypedPassword(String retypedPassword) {
        this.retypedPassword = retypedPassword;
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
}
