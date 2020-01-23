package de.hska.iwi.vslab.OAuthServer;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

<<<<<<< Updated upstream
public class User implements UserDetails {
=======
public class User implements UserDetails{
>>>>>>> Stashed changes

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private long id;

    private String username;

    private String firstName;

    private String lastName;

    private String password;

<<<<<<< Updated upstream
    private Role role;
=======
    private int role;
>>>>>>> Stashed changes


    public User() {

    }

<<<<<<< Updated upstream
    public User(String username, String firstname, String lastname, String password, Role role) {
=======
    public User(String username, String firstname, String lastname, String password, int role) {
>>>>>>> Stashed changes
        this.username = username;
        this.firstName = firstname;
        this.lastName = lastname;
        this.password = password;
        this.role = role;
    }

    public long getId() {
        return this.id;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstname) {
        this.firstName = firstname;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

<<<<<<< Updated upstream
    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
=======
    public int getRole() {
        return this.role;
    }

    public void setRole(int role) {
>>>>>>> Stashed changes
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
<<<<<<< Updated upstream
        if (role.getType().equals("admin")) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else {
=======
        if(role==0) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }else {
>>>>>>> Stashed changes
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
<<<<<<< Updated upstream
}
=======


}
>>>>>>> Stashed changes
