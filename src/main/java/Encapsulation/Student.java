package Encapsulation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Student {

    private int id;
    private String name;
    private String surname;
    private Map<String,Boolean> tasks; //каждый студент будет иметь определенные задачи, String - название задачи, Boolean - статус выполнения этой задачи

    public Student(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return id == student.id && name.equals(student.name) && surname.equals(student.surname) && tasks.equals(student.tasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, tasks);
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Map<String, Boolean> getTasks() {
        return tasks;
    }
    public void setTasks(Map<String, Boolean> tasks) {
        this.tasks = new HashMap<>(tasks);
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", tasks=" + tasks +
                '}';
    }
}
