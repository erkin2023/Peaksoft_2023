package Server.impl;

import Datebase.DateBase;
import Server.StudentService;
import model.Student;

import java.util.IllegalFormatCodePointException;
import java.util.Iterator;
import java.util.Scanner;

public class StudentServiceImpl implements StudentService {
    DateBase dateBase;

    public StudentServiceImpl(DateBase dateBase) {
        this.dateBase = dateBase;
    }

    public DateBase getDateBase() {
        return dateBase;
    }

    public void setDateBase(DateBase dateBase) {
        this.dateBase = dateBase;
    }

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
    public void FindStudentByFirstName(String studentName) {
        for(Student s:dateBase.getStudents()){
            if (s.getLastName().equalsIgnoreCase(studentName)){
                System.out.println(s);
            }else {
                System.out.println("К сожалению студент с именем "+studentName+"не существует");
            }
        }
    }



    @Override
    public void GetAllStudentsLesson(String nameStudent) {
        for(Student ss:dateBase.getStudents()){
            if(ss.getFirstName().equals(nameStudent)){
                System.out.println(dateBase.getLessons());
            }else {
                System.out.println("Студент с таким "+nameStudent+" именем не существует");
            }
        }
    }

    @Override
    public void DeleteStudent(String studentName) {
        Iterator<Student>iterator = dateBase.getStudents().iterator();
        while (iterator.hasNext()){
            Student s = iterator.next();
            if (s.getLastName().equalsIgnoreCase(studentName)){
                iterator.remove();
            }else {
                System.out.println("Студент с таким "+studentName+" именем не существует");
            }
        }
    }

    @Override
    public String toString() {
        return "StudentServiceImpl{" +
                "dateBase=" + dateBase +
                '}';
    }
}
