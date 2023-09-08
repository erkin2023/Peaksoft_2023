package Server.impl;

import Datebase.DateBase;
import Server.StudentService;
import model.Student;

import java.util.Iterator;
import java.util.Scanner;

public class StudentServiceImpl implements StudentService {
    DateBase dateBase;
    @Override
    public void UpdateStudent(String studentName) {
        Scanner scanner = new Scanner(System.in);
        Iterator<Student>iterator=dateBase.getStudents().iterator();
        while (iterator.hasNext()){
            Student student =iterator.next();
            if (student.getLastName().equalsIgnoreCase(studentName)){
                System.out.println("Напишите новое имя студента ");
                String a =scanner.nextLine();
                student.setLastName(a);
            }else {
                System.out.println("К сожалению стент с "+studentName+"не существует");
            }
        }
    }

    @Override
    public void FindStudentByFirstName() {

    }

    @Override
    public void GetAllStudentsByGroupName() {

    }

    @Override
    public void GetAllStudentsLesson() {

    }

    @Override
    public void DeleteStudent() {

    }
}
