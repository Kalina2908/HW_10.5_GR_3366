package View;

import java.util.List;
import java.util.Scanner;

import Controller.iGetView;
import Model.Student;

public class ViewEng implements iGetView {

    public void printAllStudent(List<Student> students) {
        System.out.println("-----LIST OF STUDENTS-----");
        for (Student person : students) {
            System.out.println(person);
        }
        System.out.println("-----END OF LIST-----");
    }

    public String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

}
