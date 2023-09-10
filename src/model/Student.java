package model;

import java.util.Scanner;
import Enum.*;

public class Student {
    private static int idd=1;
    private int id;
    private String lastName;
    private String firstName;
    private String email;
    private String password;
    private Gender gender;

    public Student(String lastName, String firstName, String email, String password, Gender gens) {
        this.id =idd++;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
        this.gender=gens;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person\n" +
                "\tId: " + id + "\n" +
                "\tLastName: '" + lastName + "'\n" +
                "\tFirstName: '" + firstName + "'\n" +
                "\tEmail: '" + email + "'\n" +
                "\tPassword: '" + password + "'\n" +
                "\tGender: " + gender + "\n";
    }
}