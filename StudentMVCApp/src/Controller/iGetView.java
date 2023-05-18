package Controller;

import java.util.List;
import Model.Student;

public interface iGetView {
    void printAllStudent(List<Student> students); // прототип метода, который показывает данные со студентами
    String prompt(String message); // прототип метода получения команд от пользователя
}
