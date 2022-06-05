package Encapsulation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Student[] students = {
                new Student(1,"Andriy","Parail"),
                new Student(2,"Sasha","Pozenko"),
                new Student(3,"Igor","Voronov"),
                new Student(4,"Valentin","Smirenko"),
                new Student(5,"Masha","Zhmih"),
                new Student(6,"Ira","Krisa")
        };

        Group group = new Group(students[0],students);

        group.changeLeaderGroup();

        group.addStudentToGroup(students[5]);

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
