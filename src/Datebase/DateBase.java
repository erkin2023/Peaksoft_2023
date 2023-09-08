package Datebase;

import model.Group;
import model.Lesson;
import model.Person;
import model.Student;

import java.util.List;

public class DateBase {
    List<Group>groups;
    List<Student>students;
    List<Person>people;
    List<Lesson>lessons;

    public DateBase(List<Group> groups, List<Student> students, List<Person> people, List<Lesson> lessons) {
        this.groups = groups;
        this.students = students;
        this.people = people;
        this.lessons = lessons;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    @Override
    public String toString() {
        return "DateBase{" +
                "groups=" + groups +
                ", students=" + students +
                ", people=" + people +
                ", lessons=" + lessons +
                '}';
    }
}
