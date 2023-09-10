import Datebase.DateBase;
import Server.LessonService;
import Server.impl.GroupServiceImpl;
import Server.impl.LessonServiceImpl;
import Server.impl.StudentServiceImpl;
import model.Group;
import model.Lesson;
import model.Person;

import java.security.spec.RSAOtherPrimeInfo;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Enum.*;
import model.Student;
import org.w3c.dom.ls.LSOutput;

public class Main {
    public static void main(String[] args) {
        // list person
        List<Person> personList = new LinkedList<>();
        personList.add(new Person("admin", "erkin", "@erkin", "2023"));
        // list group
        List<Group> groupList = new LinkedList<>();
        //list lesson
        List<Lesson> lessonList = new LinkedList<>();
        //list lesson
        List<Student> studentList = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        DateBase dateBase = new DateBase(groupList, studentList, personList, lessonList);
        GroupServiceImpl groupService = new GroupServiceImpl(dateBase);
        LessonServiceImpl lessonService = new LessonServiceImpl(dateBase);
        StudentServiceImpl studentService = new StudentServiceImpl(dateBase);



        try {
            // Get the current local time
            LocalTime currentTime = LocalTime.now();

            // Define time ranges for greetings
            LocalTime morningStart = LocalTime.of(5, 0); // 5:00 AM
            LocalTime afternoonStart = LocalTime.of(12, 0); // 12:00 PM
            LocalTime eveningStart = LocalTime.of(17, 0); // 5:00 PM

            if (currentTime.isAfter(morningStart) && currentTime.isBefore(afternoonStart)) {
                System.out.println("Good morning!");
            } else if (currentTime.isAfter(afternoonStart) && currentTime.isBefore(eveningStart)) {
                System.out.println("Good afternoon!");
            } else {
                System.out.println("Good evening!");
            }

            System.out.println("local time in Bishkek " + currentTime);
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }

        System.out.println(
                "1 -> Вход по логину \n" +
                "2 -> Пройти регистрацию \n");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера ввода
        switch (choice) {

            case 1:
                System.out.println("Напишите свой логин:");
                String login = scanner.nextLine();
                System.out.println("Напишите свой пароль:");
                String password1 = scanner.nextLine();
                boolean loggedIn = false;


                for (Person p : dateBase.getPeople()) {
                    if (p.getLastName().equals(login) && p.getPassword().equals(password1)) {
                        System.out.println("Добро пожаловать!");
                        loggedIn = true;
                        break;
                    }
                }

                if (!loggedIn) {
                    System.out.println("Пользователь с таким логином и паролем не найден.");
                }else {
                    while (true) {

                        System.out.println("1  -> Add new group               \n" +
                                "2  -> Get Group By Name           \n" +
                                "3  -> Update group name           \n" +
                                "4  -> Get all groups \n" +
                                "5  -> Add new student to group      \n" +
                                "6  -> Update student                \n" +
                                "7  -> Find student by first name     \n" +
                                "8  -> Get all students by group name \n" +
                                "9  -> Get All Students Lesson       \n" +
                                "10 -> Delete student                \n" +
                                "11 -> Add New Lesson To Group     \n" +
                                "12 -> GetLessonByName\n" +
                                "13 -> GetAll Lesson By Group Name\n" +
                                "14 -> Delete lesson\n" +
                                "15 -> Delete Group");
                        int a = scanner.nextInt();
                        scanner.nextLine(); // Очистка буфера ввода
                        switch (a) {
                            case 1:
                                System.out.println("1 -> Add new group\nWrite the name of the group:");
                                String name = scanner.nextLine();
                                System.out.println("The description of the group:");
                                String description = scanner.nextLine();

                                if (!name.isEmpty() && groupService.isGroupExists(name)) {
                                    System.out.println("A group with this name already exists.");
                                } else {
                                    Group newGroup = new Group(name, description, studentList, lessonList);
                                    System.out.println(groupService.AddNewGroup(newGroup));
                                    System.out.println("Group added successfully.");
                                }
                                break;
                            case 2:
                                System.out.println("2  -> Get Group By Name \n"+"Write the name of the group to search for :");
                                String groupName = scanner.nextLine();
                                groupService.GetGroupByName(groupName);
                                break;
                            case 3:
                                System.out.println("3  -> Update Group Name\n" + "Write the name of the group to update");
                                String groupName1 = scanner.nextLine();
                                groupService.UpdateGroupName(groupName1);
                                break;
                            case 4:
                                System.out.println("4  -> Get All Groups");
                                groupService.GetAllGroups();
                                break;
                            case 5:
                                System.out.println("5  -> Add New Student To Group\n" +
                                        "Write the name of the group to add a new student");
                                groupName = scanner.nextLine();
                                groupService.AddNewStudentToGroup(groupName);
                                break;

                            case 6:
                                System.out.println("6  -> Update Student\n" +
                                        "Write the name of the group");
                                groupName = scanner.nextLine();
                                scanner.nextLine();
                                groupService.UpdateGroupName(groupName);
                                break;
                            case 7:
                                System.out.println("7  -> Find Student By First Name\n" +
                                        "Write the first name student");
                                String studentName = scanner.nextLine();
                                studentService.FindStudentByFirstName(studentName);
                                break;
                            case 8:
                                System.out.println("8  -> Get All Students By Group Name\n" + "Write the  name group");
                                groupName = scanner.nextLine();
                                groupService.GetAllStudentsByGroupName(groupName);
                                break;
                            case 9:
                                System.out.println("9  -> Get All Students Lesson\n" + "Write the  name student");
                                studentName = scanner.nextLine();
                                studentService.GetAllStudentsLesson(studentName);
                                break;
                            case 10:
                                System.out.println("10 -> Delete Student\n" + "Write the name student for delete ");
                                studentName = scanner.nextLine();
                                studentService.DeleteStudent(studentName);
                                break;
                            case 11:
                                System.out.println("11 -> Add New Lesson To Group\n" + "Write the name group for add lesson");
                                groupName = scanner.nextLine();
                                lessonService.AddNewLessonToGroup(groupName);
                                break;
                            case 12:
                                System.out.println("12 -> Get Lesson By Name \n" + "Write the name Lesson for get");
                                String nameLesson = scanner.nextLine();
                                lessonService.GetLessonByName(nameLesson);
                                break;
                            case 13:
                                System.out.println("13 -> GetAll Lesson By Group Name\n" + "Write the name group for lesson");
                                groupName = scanner.nextLine();
                                lessonService.GetAllLessonByGroupName(groupName);
                                break;
                            case 14:
                                System.out.println("14 -> Delete Lesson\n" + "Write the name lesson for delete");
                                nameLesson = scanner.nextLine();
                                lessonService.DeleteLesson(nameLesson);
                                break;
                            case 15:
                                System.out.println("15 -> Delete Group\n" + "Write the name group for delete ");
                                groupName = scanner.nextLine();
                                groupService.DeleteGroup(groupName);
                                break;
                        }
                    }
                }
                break;

            case 2:
                System.out.println("Напишите свое имя ");
                String name1 = scanner.nextLine();
                System.out.println("ФИО");
                String firstName = scanner.nextLine();
                System.out.println("email");
                String email = scanner.nextLine();

// Проверка формата электронной почты
                Pattern emailPattern = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)*(\\.[a-zA-Z]{2,})$");
                Matcher emailMatcher = emailPattern.matcher(email);
                if (emailMatcher.matches()) {
                    System.out.println("Email валидный");
                } else {
                    System.out.println("Email невалидный");
                    return; // Если email невалидный, прекращаем выполнение
                }

                System.out.println("Придумайте свой пароль\n1 Пароль должен содержать как минимум 8 символов, \n" +
                        "  включая как минимум одну заглавную букву, " +
                        "одну строчную букву, " +
                        "одну цифру и один специальный символ");
                String password = scanner.nextLine();

// Проверка пароля на соответствие стандартам безопасности
                Pattern passwordPattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
                Matcher passwordMatcher = passwordPattern.matcher(password);
                if (passwordMatcher.matches()) {
                    System.out.println("Пароль валидный");
                } else {
                    System.out.println("Пароль невалидный");
                    return; // Если пароль невалидный, прекращаем выполнение
                }

                System.out.println("Напишите ваш пол : ");
                System.out.println("Мужской - Male : ");
                System.out.println("Женский - Female : ");
                String genderSInput = scanner.next();
                Gender gens = Gender.fromString(genderSInput);
                if (gens != null) {
                    System.out.println(dateBase.getStudents().add(
                            new Student(name1, firstName, email, password, gens)
                    ));
                }
         while (true) {

                        System.out.println("1  -> Add new group               \n" +
                                "2  -> Get Group By Name           \n" +
                                "3  -> Update group name           \n" +
                                "4  -> Get all groups \n" +
                                "5  -> Add new student to group      \n" +
                                "6  -> Update student                \n" +
                                "7  -> Find student by first name     \n" +
                                "8  -> Get all students by group name \n" +
                                "9  -> Get All Students Lesson       \n" +
                                "10 -> Delete student                \n" +
                                "11 -> Add New Lesson To Group     \n" +
                                "12 -> Get Lesson By Name\n" +
                                "13 -> GetAll Lesson By Group Name\n" +
                                "14 -> Delete lesson\n" +
                                "15 -> Delete Group");
                        int a = scanner.nextInt();
                        scanner.nextLine(); // Очистка буфера ввода
                        switch (a) {
                            case 1:
                                System.out.println("1 -> Add new group\nWrite the name of the group:");
                                String name = scanner.nextLine();
                                System.out.println("The description of the group:");
                                String description = scanner.nextLine();

                                if (!name.isEmpty() && groupService.isGroupExists(name)) {
                                    System.out.println("A group with this name already exists.");
                                } else {
                                    Group newGroup = new Group(name, description, studentList, lessonList);
                                    System.out.println(groupService.AddNewGroup(newGroup));
                                    System.out.println("Group added successfully.");
                                }
                                break;
                            case 2:
                                System.out.println("2  -> Get Group By Name \n" + "Write the name of the group to search for :");
                                String groupName = scanner.nextLine();
                                groupService.GetGroupByName(groupName);
                                break;
                            case 3:
                                System.out.println("3  -> Update Group Name\n" + "Write the name of the group to update");
                                String groupName1 = scanner.nextLine();
                                groupService.UpdateGroupName(groupName1);
                                break;
                            case 4:
                                System.out.println("4  -> Get All Groups");
                                groupService.GetAllGroups();
                                break;
                            case 5:
                                System.out.println("5  -> Add New Student To Group\n" +
                                        "Write the name of the group to add a new student");
                                groupName = scanner.nextLine();
                                groupService.AddNewStudentToGroup(groupName);
                                break;

                            case 6:
                                System.out.println("6  -> Update Student\n" +
                                        "Write the name of the group");
                                groupName = scanner.nextLine();
                                scanner.nextLine();
                                groupService.UpdateGroupName(groupName);
                                break;
                            case 7:
                                System.out.println("7  -> Find Student By First Name\n" +
                                        "Write the first name student");
                                String studentName = scanner.nextLine();
                                studentService.FindStudentByFirstName(studentName);
                                break;
                            case 8:
                                System.out.println("8  -> Get All Students By Group Name\n" + "Write the  name group");
                                groupName = scanner.nextLine();
                                groupService.GetAllStudentsByGroupName(groupName);
                                break;
                            case 9:
                                System.out.println("9  -> Get All Students Lesson\n" + "Write the  name student");
                                studentName = scanner.nextLine();
                                studentService.GetAllStudentsLesson(studentName);
                                break;
                            case 10:
                                System.out.println("10 -> Delete Student\n" + "Write the name student for delete ");
                                studentName = scanner.nextLine();
                                studentService.DeleteStudent(studentName);
                                break;
                            case 11:
                                System.out.println("11 -> Add New Lesson To Group\n" + "Write the name group for add lesson");
                                groupName = scanner.nextLine();
                                lessonService.AddNewLessonToGroup(groupName);
                                break;
                            case 12:
                                System.out.println("12 -> Get Lesson By Name \n" + "Write the name Lesson for get");
                                String nameLesson = scanner.nextLine();
                                lessonService.GetLessonByName(nameLesson);
                                break;
                            case 13:
                                System.out.println("13 -> GetAll Lesson By Group Name\n" + "Write the name group for lesson");
                                groupName = scanner.nextLine();
                                lessonService.GetAllLessonByGroupName(groupName);
                                break;
                            case 14:
                                System.out.println("14 -> Delete Lesson\n" + "Write the name lesson for delete");
                                nameLesson = scanner.nextLine();
                                lessonService.DeleteLesson(nameLesson);
                                break;
                            case 15:
                                System.out.println("15 -> Delete Group\n" + "Write the name group for delete ");
                                groupName = scanner.nextLine();
                                groupService.DeleteGroup(groupName);
                                break;
                        }
                    }
                }
        }
    }


