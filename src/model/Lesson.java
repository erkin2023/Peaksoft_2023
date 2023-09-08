package model;

import java.util.Scanner;
import Enum.*;

public class Lesson {
    private static int idd;
    private int id;
    private String lessonName;
    private String lessonDecryption;

    public Lesson( String lessonName, String lessonDecryption) {
        this.id = idd++;
        this.lessonName = lessonName;
        this.lessonDecryption = lessonDecryption;
    }

    public static int getIdd() {
        return idd;
    }

    public static void setIdd(int idd) {
        Lesson.idd = idd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getLessonDecryption() {
        return lessonDecryption;
    }


    public void setLessonDecryption(String lessonDecryption) {
        this.lessonDecryption = lessonDecryption;
    }
    public  void getMethod(){
        Scanner scanner= new Scanner(System.in);
        int a =scanner.nextInt();
        switch (a){
            case 1:
                Gender male= Gender.Male;
            case 2:
                Gender Female= Gender.Female;
        }
    }
}
