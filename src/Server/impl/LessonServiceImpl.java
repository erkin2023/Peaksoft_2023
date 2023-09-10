package Server.impl;

import Datebase.DateBase;
import Server.LessonService;
import model.Group;
import model.Lesson;

import java.util.Iterator;
import java.util.Scanner;

public class LessonServiceImpl implements LessonService {
    private  DateBase datebase;

    public LessonServiceImpl(DateBase dateBase) {
        this.datebase = dateBase;
    }
    public LessonServiceImpl(){

    }

    public DateBase getDatebase() {
        return datebase;
    }

    public void setDatebase(DateBase datebase) {
        this.datebase = datebase;
    }

    @Override
    public void GetLessonByName(String nameLesson) {
        for (Lesson l:datebase.getLessons()){
            if(l.getLessonName().equalsIgnoreCase(nameLesson)){
                System.out.println(l);
            }else {
                System.out.println("Урок с таким "+nameLesson+" именем не существует");
            }
        }
    }

    @Override
    public void GetAllLessonByGroupName(String groupName) {
        for (Group l:datebase.getGroups()){
            if (l.getName().equalsIgnoreCase(groupName)){
                for (Lesson i:datebase.getLessons()){
                    System.out.println("Lesson\n" +
                            "\tId: " + i.getId() + "\n" +
                            "\tLessonName: '" + i.getLessonName()+ "'\n" +
                            "\tLessonDecryption: '" + i.getLessonDecryption());
                }
            }else {
                System.out.println("Гру "+groupName+" именем не существует");

            }
        }
    }

    @Override
    public void DeleteLesson(String lessonName) {
        Iterator<Lesson>iterator=datebase.getLessons().iterator();
        while (iterator.hasNext()){
            Lesson lesson = iterator.next();
            if (lesson.getLessonName().equalsIgnoreCase(lessonName)){
                iterator.remove();
                System.out.println("Урок с названием " +lessonName+" успешно удален ");
            }else {
                System.out.println("Урок с таким "+lessonName+" именем не существует");
            }
        }
    }

    @Override
    public void AddNewLessonToGroup(String nameGroup) {
            Scanner scanner = new Scanner(System.in);
            Iterator<Group> iterator = datebase.getGroups().iterator();
            while (iterator.hasNext()){
                Group group = iterator.next();
                if (group.getName().equalsIgnoreCase(nameGroup)){
                    System.out.println("Напишите название предмета ");
                    String lesson = scanner.nextLine();
                    System.out.println("Опишите урок ");
                    String decryption = scanner.nextLine();
                    System.out.println(group.getLessons().add(new Lesson(lesson, decryption)));

                }else {
                    System.out.println("К сожалению с"+nameGroup+" таким именем группы нет");
                }
            }
        }


}
