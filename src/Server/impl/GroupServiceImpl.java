package Server.impl;

import Datebase.DateBase;
import Server.GroupService;
import model.Group;
import model.Lesson;
import model.Person;
import model.Student;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import Enum.*;
import org.w3c.dom.ls.LSOutput;


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
    public String AddNewGroup(Group groups) {
         datebase.getGroups().add(groups);
        return "new group :\n" + groups;
    }
    public boolean isGroupExists(String groupName) {
        List<Group>groupList=datebase.getGroups();
        // Перебираем список групп, чтобы проверить, существует ли группа с заданным именем.
        for (Group group : groupList) {
            if (group.getName().equalsIgnoreCase(groupName)) {
                return true; // Найдена группа с тем же именем.
            }
        }
        return false; // Группа с таким именем не найдена.
    }


    @Override
    public void GetGroupByName(String nameGroup) {
        System.out.print("Список group");
        for(Group g: datebase.getGroups()){
            if (g.getName().equals(nameGroup)){
                System.out.println(g);
            }else {
                System.out.println("К сожалению такой группы нет ");
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
                System.out.println("Успешно обновлено : "+nameGroup);
            }
        }
    }

    @Override
    public void GetAllGroups() {
        List<Group> groups = datebase.getGroups();
        if (groups.isEmpty()) {
            System.out.println("К сожалению у вас нет групп , сначало создайте");
        } else {
            for (Group b: groups){
                if (b != null) {
                    System.out.println(b);
                }
            }
        }
    }

    @Override
    public void AddNewStudentToGroup(String nameGroup) {
        List<Lesson>lessons = datebase.getLessons();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i <datebase.getGroups().size() ; i++) {
            if (datebase.getGroups().get(i).getName().equals(nameGroup)) {
                System.out.println("filling in student data");
                System.out.print("last name : ");
                String lastName = scanner.nextLine();

                System.out.print("first name : ");
                String firstName = scanner.nextLine();

                System.out.print("email : ");
                String email = scanner.nextLine();
                System.out.println("password");
                String password = scanner.nextLine();
                System.out.println("Напишите ваш пол : ");
                System.out.println("Мужской - Male : ");
                System.out.println("Женский - Female : ");
                String genderSInput = scanner.next();
                Gender gens = Gender.fromString(genderSInput);
                if (gens != null) {
                    System.out.println(datebase.getStudents().add(
                            new Student(lastName, firstName,email, password,gens)
                    ));
                } else {
                    System.out.println("Invalid gender input.");
                }
            }else {
                System.out.println("Такой группы "+nameGroup+" не существует");
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
                System.out.println("Группа с именем : "+ nameGroup + " успешно удален");
            }else {
                System.out.println("К сожалению с "+nameGroup+" таким именем группы нет");
            }
        }
    }

    @Override
    public void GetAllStudentsByGroupName(String nameGroup) {
        for (Group g: datebase.getGroups()){
            if (g.getName().equalsIgnoreCase(nameGroup)){
                System.out.println(g.getStudents());
            }
            else {
                System.out.println("К сожалению с таким :"+nameGroup+"  именем группы нет");
            }
        }
}
}
