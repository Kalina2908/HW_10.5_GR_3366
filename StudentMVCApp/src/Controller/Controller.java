package Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.jws.WebParam.Mode;

import Model.Student;
import Model.Model;
import Model.ModelHashMap;
import View.View;
import View.ViewEng;

public class Controller {

    private List<Student> students; // копия списока из Model
    private iGetView view; // храним ссылки для View
    private iGetModel model; // храним ссылки для Model
    private HashMap<Long, Student> studentsMap;

    /** конструктор */
    public Controller(iGetView view, iGetModel model) {
        this.view = view;
        this.model = model;
        this.students = new ArrayList<Student>();
        this.studentsMap = new HashMap<Long, Student>();
    }

    /** метод получения всех студентов из Model в Controller для MVP модели */
    public void getAllStudent() {
        students = model.getAllStudent();
    }

    /** метод получения Hash Map студентов */
    public void getMapAllStudent(List<Student> students) {
        Map<Long, Student> MapAllStudents = new HashMap<Long, Student>();
        for (Student stud : students) {
            MapAllStudents.put(stud.getStudentID(), stud);
        }
        System.out.println(MapAllStudents);
    }

    /** проверка есть ли студенты в нашей базе */
    public boolean testData() {
        if (students.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    /** получение списка из Model и передача к View */
    public void updateView() {
        // MVP
        getAllStudent(); // получаем данные от Model
        if (testData()) // тестируем
        {
            view.printAllStudent(students); // если верно, то View отдаем данные
        } else {
            System.out.println("Список студентов пуст!");
        }

        // MVC
        // view.printAllStudent(model.getAllStudent()); // из вью передаем в модел
    }

    /** метод проверки наличия нужного ID в списке студентов*/
    public Student testDelete(long IdForDelete) {
        Student x = null;
        for (Student stud : students) {
            if (stud.getStudentID() == IdForDelete) {
                x = stud;
            }
        }
        return x;
    }

    /** метод удаления студента по ID */
    public void deleteStudent(long IdForDelete) {
        getAllStudent();
        int y = 0;

        if (testDelete(IdForDelete) != null) {
            for (Student stud : students) {
                if (stud.getStudentID() == IdForDelete) {
                    y = students.indexOf(stud);
                }
            }
            System.out.println("Вы собираетесь удалить:");
            System.out.println(students.get(y));
            students.remove(y);
            y = 0;
            System.out.println("------- СПИСОК ПОСЛЕ УДАЛЕНИЯ ----------");
            view.printAllStudent(students);

        } else {
            System.out.println("Такого студента нет");
        }
    }


    /** метод получения команд от пользователя */
    public void run() {
        Commands com = Commands.NONE;
        boolean getNewIteration = true;
        while (getNewIteration) {
            String command = view.prompt("Введите команду:");
            com = Commands.valueOf(command.toUpperCase());

            switch (com) {
                case EXIT:
                    getNewIteration = false;
                    System.out.println("Выход из программы!");
                    break;

                case LIST:
                    //getAllStudent();
                    updateView();
                    break;

                case DELETE:
                    System.out.println("Какой ID студента удалить? ");
                    Scanner iScanner = new Scanner(System.in);
                    long IdForDelete = Long.parseLong(iScanner.nextLine());
                    deleteStudent(IdForDelete);
            }

        }
    }

}
