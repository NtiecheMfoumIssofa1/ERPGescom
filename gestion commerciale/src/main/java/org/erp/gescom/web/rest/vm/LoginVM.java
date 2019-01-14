package org.erp.gescom.web.rest.vm;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.index.Indexed;

/**
 * View Model object for storing a user's credentials.
 */
public class LoginVM {

  /*  @NotNull
    @Size(min = 1, max = 50)
    private String username;*/

    @NotNull
    @Size(min = ManagedUserVM.PASSWORD_MIN_LENGTH, max = ManagedUserVM.PASSWORD_MAX_LENGTH)
    private String password;

    @NotNull
    @Email
    @Size(min = 5, max = 254)
    private String email;
    
    private Boolean rememberMe;

    /*public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }*/

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(Boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "LoginVM [password=" + password + ", email=" + email + "]";
	}

   
}
