package model;

import java.util.List;

public class Group {
    private static int idd;
    private int id;
    private String name;
    private String decryption;
    private List<Student> students;
    private List<Lesson> lessons;

    public Group( String name, String decryption, List<Student> students, List<Lesson> lessons) {
        this.id =idd++;
        this.name = name;
        this.decryption = decryption;
        this.students = students;
        this.lessons = lessons;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDecryption() {
        return decryption;
    }

    public void setDecryption(String decryption) {
        this.decryption = decryption;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", decryption='" + decryption + '\'' +
                ", students=" + students +
                ", lessons=" + lessons +
                '}';
    }
}
