import java.util.ArrayList;
import java.util.List;

import Controller.Controller;
import Controller.iGetModel;
import Controller.iGetView;
import Model.FileRepo;
import Model.Model;
import Model.ModelHashMap;
import Model.Student;
import View.View;
import View.ViewEng;

public class App {
  public static void main(String[] args) throws Exception {

    // создаем список и добавляем студентов
    List<Student> students = new ArrayList<Student>();
    Student s1 = new Student("Сергей", "Иванов", 21, (long) 101);
    Student s2 = new Student("Андрей", "Сидоров", 22, (long) 111);
    Student s3 = new Student("Иван", "Петров", 22, (long) 121);
    Student s4 = new Student("Игорь", "Иванов", 23, (long) 301);
    Student s5 = new Student("Даша", "Цветкова", 25, (long) 171);
    Student s6 = new Student("Лена", "Незабудкина", 23, (long) 104);
    students.add(s1);
    students.add(s2);
    students.add(s3);
    students.add(s4);
    students.add(s5);
    students.add(s6);

    // для MVC
    //Model model = new Model(students);// положили студентов в Model
    //View view = new View();
    //Controller control = new Controller(view, model); // передаем данные view и model
    //control.updateView();// вызываем метод

    FileRepo fileRepo = new FileRepo("StudentDb.txt"); // создаем файл
    // заполняем студентами
    //for(Student pers :students){
    //fileRepo.addStudent(pers);
    //}
    //fileRepo.saveAllStudentToFile();

    iGetModel model = new Model(students);
    iGetModel modelFileRepo = fileRepo;
    iGetView view = new ViewEng();

    Controller control = new Controller(view, modelFileRepo);

    System.out.println("Для задания 2: ");
    control.getMapAllStudent(students);

    control.run();
    control.updateView();

  }
}
