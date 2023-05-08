package com.example.tesrserver.model.user;

import com.example.tesrserver.entity.UserEntity;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String city;
    private String address;

    public User() {
    }

    public User(Long id, String firstName, String lastName, String email, String phoneNumber, String city, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.address = address;
    }

        public static User toModel(UserEntity userEntity){
        User model = new User();
        model.setId(userEntity.getId());
        model.setFirstName(userEntity.getFirstName());
        model.setLastName(userEntity.getLastName());
        model.setEmail(userEntity.getEmail());
        model.setPhoneNumber(userEntity.getPhoneNumber());
        model.setCity(userEntity.getCity());
        model.setAddress(userEntity.getAddress());
        return model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User entity = (User) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.firstName, entity.firstName) &&
                Objects.equals(this.lastName, entity.lastName) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.phoneNumber, entity.phoneNumber) &&
                Objects.equals(this.city, entity.city) &&
                Objects.equals(this.address, entity.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, phoneNumber, city, address);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "firstName = " + firstName + ", " +
                "lastName = " + lastName + ", " +
                "email = " + email + ", " +
                "phoneNumber = " + phoneNumber + ", " +
                "city = " + city + ", " +
                "address = " + address + ")";
    }
}
