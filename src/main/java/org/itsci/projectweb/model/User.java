package org.itsci.projectweb.model;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User extends Login {
    private String firstName;
    private String lastName;
    @Column(columnDefinition = "TEXT")
    private String address;// Getter/Setter

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
