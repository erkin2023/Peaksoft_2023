package model;
import Enum.*;

import java.util.Scanner;

public class Person {
    private static int idd;
    private int id;
    private String lastName;
    private String firstName;
    private String email;
    private String password;
    private Gender gender;

    public Person( String lastName, String firstName, String email, String password) {
        this.id =idd++;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
        getMethod();
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
    public  void getMethod(){
        Scanner scanner= new Scanner(System.in);
        int a =scanner.nextInt();
        switch (a){
            case 1:
                Gender male=Gender.Male;
            case 2:
                Gender Female=Gender.Female;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                '}';
    }
}
