/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projectmanager.entities;

import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author fgotl
 */
@Entity
@Table(name = "curentUser")
@NamedQueries({
        @NamedQuery(name = "Curentuser.findAll", query = "SELECT c FROM CurentUser c"),
        //@NamedQuery(name = "Curentuser.insert", query = "INSERT INTO CurentUser( username,first_name,last_name,email,password,admin_role)"+"SELECT username, first_name, last_name, email, password, admin_role FROM CurentUser "),
        @NamedQuery(name = "curentuser.findByUsernameAndPassword", query = "SELECT u FROM User u WHERE u.username = :username and u.password=:password"),
        @NamedQuery(name = "curentuser.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
        @NamedQuery(name = "curentuser.findByFirstName", query = "SELECT u FROM User u WHERE u.firstName = :firstName"),
        @NamedQuery(name = "curentuser.findByLastName", query = "SELECT u FROM User u WHERE u.lastName = :lastName"),
        @NamedQuery(name = "curentuser.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
        @NamedQuery(name = "curentuser.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
        @NamedQuery(name = "curentuser.findByAdminRole", query = "SELECT u FROM User u WHERE u.adminRole = :adminRole")})
public class CurentUser extends AbstractEntity implements EntityItem<String> {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "last_name")
    private String lastName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "admin_role")
    private Character adminRole;
    @NotNull



    public CurentUser() {
    }

    public CurentUser(String username) {
        this.username = username;
    }

    public CurentUser(String username, String firstName, String lastName, String email, String password, Character adminRole) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.adminRole = adminRole;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Character getAdminRole() {
        return adminRole;
    }

    public void setAdminRole(Character adminRole) {
        this.adminRole = adminRole;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        CurentUser other = (CurentUser) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public String getId() {
        return username;
    }

    public boolean isAdmin() {
        return adminRole == null ? false : adminRole.equals('Y');
    }

}
