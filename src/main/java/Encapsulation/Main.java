package Encapsulation;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Andriy","Parail"));
        students.add(new Student(2,"Sasha","Pozenko"));
        students.add(new Student(3,"Igor","Voronov"));
        students.add(new Student(4,"Valentin","Smirenko"));
        students.add(new Student(5,"Masha","Zhmih"));
        students.add(new Student(6,"Ira","Krisa"));

        Group group = new Group(students.get(1),students);

        group.changeLeaderGroup();

        group.addStudentToGroup(students.get(5));

        group.renameStudentInGroup(1,"Paruk");

        group.deleteStudentInGroup(6);

        group.addNewTaskForStudents("новая таска");
        group.addNewTaskForStudents("новая таска2");
        group.addNewTaskForStudents("новая таска3");
        group.addNewTaskForStudents("новая таска4");
        group.addNewTaskForStudents("новая таска5");


        group.setTaskDone(1,"новая таска4");
    }
}
