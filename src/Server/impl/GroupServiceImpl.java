package Server.impl;

import Datebase.DateBase;
import Server.GroupService;
import model.Group;
import model.Person;
import model.Student;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import Enum.*;


public class GroupServiceImpl implements GroupService {
private DateBase datebase;

    public GroupServiceImpl(DateBase datebase) {
        this.datebase = datebase;
    }

    public DateBase getDateBase() {
        return datebase;
    }

    public void setDateBase(DateBase datebase) {
        this.datebase = datebase;
    }

    @Override
    public void AddNewGroup(Group groups) {
        List<Group>newGroup = new LinkedList<>();
        newGroup.add(groups);

    }

    @Override
    public void GetGroupByName(String nameGroup) {
        System.out.print("Список group");
        Iterator<Group>iterator = getDateBase().getGroups().iterator();
        while (iterator.hasNext()){
            Group group=iterator.next();
            if (group.getName().equals(nameGroup)){
                iterator.remove();
            }
        }
    }

    @Override
    public void  UpdateGroupName(String nameGroup) {
        boolean erkin=false;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i <datebase.getGroups().size() ; i++) {
            if (datebase.getGroups().get(i).getName().equals(nameGroup)) {
                System.out.print("Напишите новое название группы : ");
                String a = scanner.nextLine();
                erkin = true;
                datebase.getGroups().get(i).setName(a);
                System.out.println();
                System.out.println("Успешно добавленно");
            }
        }
    }

    @Override
    public void GetAllGroups() {
        for (int i = 0; i < datebase.getGroups().size(); i++) {
            if (datebase.getGroups().get(i) != null) {
                System.out.println(i);
            } else {
                System.out.println("К сожалению у вас групп , сначало создайте");
            }
        }
    }

    @Override
    public void AddNewStudentToGroup(String nameGroup) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i <datebase.getGroups().size() ; i++) {
            if (datebase.getGroups().get(i).getName().equals(nameGroup)) {
                System.out.print("last name : ");
                String lastName = scanner.nextLine();
                System.out.print("first name : ");
                String firstName = scanner.nextLine();
                String email = scanner.nextLine();
                System.out.print("email : ");
                String password = scanner.nextLine();
                System.out.print("Put name of the gender: ");
                String genderSInput = scanner.next();
                Gender gens = Gender.fromString(genderSInput);
                if (gens != null) {
                    System.out.println(datebase.getStudents().add(
                            new Student(lastName, firstName,email, password,gens)
                    ));
                } else {
                    System.out.println("Invalid gender input.");
                }
            }
            }
        }


    @Override
    public void DeleteGroup(String nameGroup) {
        Iterator<Group> iterator = datebase.getGroups().iterator();
        while (iterator.hasNext()) {
            Group group = iterator.next();
            if (group.getName().equals(nameGroup)) {
                iterator.remove();
            }else {
                System.out.println("К сожалению с"+nameGroup+" таким именем группы нет");
            }
        }
    }

}
