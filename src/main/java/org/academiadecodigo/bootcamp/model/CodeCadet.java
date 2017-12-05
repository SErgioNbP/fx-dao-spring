package org.academiadecodigo.bootcamp.model;

import org.academiadecodigo.bootcamp.utils.Gender;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "codecadet")
public class CodeCadet extends AbstractModel {

    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private User user;

    private Gender gender;
    private String address;
    private String city;
    private String phone;
    private Date birthdate;

    @ManyToOne
    private Bootcamp bootcamp;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return user.getUsername();
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Bootcamp getBootcamp() {
        return bootcamp;
    }

    public void setBootcamp(Bootcamp bootcamp) {
        this.bootcamp = bootcamp;
    }

    public Integer getBootcampId() {
        return bootcamp.getId();
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CodeCadet cadet = (CodeCadet) o;

        if (!user.equals(cadet.user)) return false;
        if (gender != cadet.gender) return false;
        if (bootcamp != null ? !bootcamp.equals(cadet.bootcamp) : cadet.bootcamp != null) return false;
        return birthdate.equals(cadet.birthdate);
    }

    @Override
    public int hashCode() {
        int result = user.hashCode();
        result = 31 * result + gender.hashCode();
        result = 31 * result + birthdate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "CodeCadet{" +
                "user=" + user.getUsername() +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", phone='" + phone + '\'' +
                ", bootcamp=" + (bootcamp == null ? "null" : bootcamp.getId()) +
                ", birthdate=" + birthdate +
                '}' + super.toString();
    }
}


