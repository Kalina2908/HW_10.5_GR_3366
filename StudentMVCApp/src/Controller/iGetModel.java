package Controller;

import java.util.List;
import Model.Student;

public interface iGetModel {
    public List<Student> getAllStudent(); // прототип метода получения всех студентов
    public void deleteStudent(); // прототип метода удаления студента по ID
}
