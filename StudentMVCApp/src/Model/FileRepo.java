package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import Controller.iGetModel;

/** Работа с файлами класс с интерфесом iGetModel */
public class FileRepo implements iGetModel {
    private String fileName; // название
    private List<Student> students; // список со студентами

    /** конструктор */
    public FileRepo(String fileName) {
        this.fileName = fileName;
        this.students = new ArrayList<>();

        try (FileWriter fw = new FileWriter(fileName, true)) { // проверка доступа к файлу
            fw.flush(); // закроет и передаст данные
        } catch (Exception e) {
            System.out.println(e.getMessage()); // будет выведен тип ошибки
        }
    }

    /** заполения студентами хранилища */
    public void addStudent(Student student) {
        this.students.add(student);
    }

    /** метод удаления студента из репозитория */
    public void deleteStudentRep(Student student) {
        this.students.remove(student);
    }

    /** метод чтения всех студентов */
    public void readAllStudentsFromFile() {
        try {
            File file = new File(fileName); // создаем объект - файл
            FileReader fr = new FileReader(file); // просим разрешения к подключению
            BufferedReader reader = new BufferedReader(fr); // для считывания информации
            String line = reader.readLine();
            while (line != null) { // построчно
                String[] param = line.split(" ");
                Student pers = new Student(param[0], param[1], Integer.parseInt(param[2]), Long.parseLong(param[3]));
                students.add(pers);
                line = reader.readLine(); // считываем следующую строчку
            }

        } catch (Exception e) {
            System.out.println(e.getMessage()); // вывод тип ошибки
        }
    }

    /** метод сохранения списка студентов в файле */
    public void saveAllStudentToFile() {
        try (FileWriter fw = new FileWriter(fileName, true)) {
            for (Student pers : students) {
                fw.write(pers.getFirstName() + " " + pers.getSecondName() + " " + pers.getAge() + " "
                        + pers.getStudentID());
                fw.append('\n'); // перевод строки на следующую строчку
            }
            fw.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /** метод из интерфейса */
    @Override
    public List<Student> getAllStudent() {
        readAllStudentsFromFile();
        return students;
    }

    /** метод удаления студентов */
    @Override
    public void deleteStudent() {
        this.students = students;
    }

}
