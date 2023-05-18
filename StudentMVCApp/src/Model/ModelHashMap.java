package Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Controller.iGetModel;

public class ModelHashMap implements iGetModel {
    private List<Student> students; // список студентов
    private HashMap<Long, Student> studentsMap;

    /** конструктор */
    public ModelHashMap(HashMap<Long, Student> studentsMap) {
        this.studentsMap = studentsMap;
    }

    /** метод получения данных всех студентов */
    public List<Student> getAllStudent() {
        return students;
    }

    /** метод получения Hash Map студентов */
    public HashMap<Long, Student> getMapAllStudent(List<Student> students) {
        Map<Long, Student> MapAllStudents = new HashMap<Long, Student>();
        for (Student stud : students) {
            MapAllStudents.put(stud.getStudentID(), stud);
        }
        return studentsMap;
    }

    /** метод удаления студентов */
    @Override
    public void deleteStudent() {
        this.students = students;

    }

}
