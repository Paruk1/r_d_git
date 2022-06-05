package Encapsulation;

import java.util.*;

public class Group {

    private Student leaderGroup; // староста группы
    private Student[] groupStudents; //массив студентов в группе
    private Map<String, Boolean> tasks; //одинаковые задачи для всей группы

    public Group(Student leaderGroup, Student[] groupStudents) {
        if (leaderGroup == null) throw new NullPointerException("Нужно выбрать старосту группы!");
        //если старосты нет, то выбрасывается ошибка что нет старосты
        this.leaderGroup = leaderGroup;
        this.groupStudents = groupStudents;
        this.tasks = new HashMap<>(); //при создании группы, создаем коллекцию где изначально 0 задач
    }

    public void changeLeaderGroup() { //поменять старосту
        System.out.println("Сейчас староста группы = " + leaderGroup);
        System.out.println("Выберите id из списка студентов нового старосту группы:");
        for (Student s : groupStudents) {
            System.out.println(s + " ");
        }
        Scanner takeId = new Scanner(System.in);
        int id = takeId.nextInt();

        this.leaderGroup = Arrays.stream(groupStudents).filter(el -> el.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NullPointerException("Нет такого id студента!!!"));

        System.out.println("Новый староста группы: " + leaderGroup);
    }

    public void addStudentToGroup(Student newStudent) { //добавить нового студента
        List<Student> array = new ArrayList<>();

        Collections.addAll(array, groupStudents);

        array.add(newStudent);

        groupStudents = array.toArray(new Student[0]);
        System.out.println("Новый список студентов:");
        for (Student s : groupStudents) {
            System.out.println(s + " ");
        }
    }

    public void renameStudentInGroup(int idStudent, String newName) { //переименовать студента группы
        for (Student s : groupStudents) {
            if (s.getId() == idStudent) s.setName(newName);
        }
        for (Student s : groupStudents) {
            System.out.println(s + " ");
        }
    }

    public void deleteStudentInGroup(int idStudent) { //удалить студента по идентификатору
        List<Student> array = new ArrayList<>();

        Collections.addAll(array, groupStudents);

        array.remove(idStudent - 1);

        groupStudents = array.toArray(new Student[0]);
        System.out.println("Новый список без выбранного студента:");
        for (Student s : groupStudents) {
            System.out.println(s + " ");
        }
    }

    public void addNewTaskForStudents(String nameTask) { //добавить новую задачу для всех студентов группы
        tasks.put(nameTask, false);
        for (Student s : groupStudents) {
            s.setTasks(tasks);
        }
        System.out.println("Новая задача добавлена");
        for (Student s : groupStudents) {
            System.out.println(s + " ");
        }
    }

    public void setTaskDone(int idStudent, String nameTaskToTrue) { //по идентификатору студента и названию задачи, проставить статус true
        for (Student groupStudent : groupStudents) {
            if (groupStudent.getId() == idStudent) {
                for (Map.Entry<String, Boolean> element : groupStudent.getTasks().entrySet()) {
                    if (element.getKey().equals(nameTaskToTrue)) {
                        element.setValue(true);
                    }
                }
            }
        }
        System.out.println("Состояние задачи обновлено");
        for (Student s : groupStudents) {
            System.out.println(s + " ");
        }
    }
}
