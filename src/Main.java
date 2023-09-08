import model.Person;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import Enum.*;

public class Main {
    public static void main(String[] args) {
        List<Person>personList = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        personList.add(new Person(scanner.nextLine(),scanner.nextLine(),scanner.nextLine(),scanner.nextLine()));



    }

}