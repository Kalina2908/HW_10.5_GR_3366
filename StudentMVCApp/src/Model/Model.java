package Model;

import java.util.List;

import Controller.iGetModel;

/** класс Model с интерфейсом iGetModel */
public class Model implements iGetModel {
    private List<Student> students; // список студентов

    /** конструктор */
    public Model(List<Student> students) {
        this.students = students;
    }

    /** метод получения данных всех студентов */
    public List<Student> getAllStudent() {
        return students;
    }

    /** метод удаления студентов */
    @Override
    public void deleteStudent() {
        this.students = students;
    }

}
