import Task1.TimeSpan;
import Task2.*;
import Task3.*;
import javax.swing.*;

class Main
{
    public static void main(String[] args)
    {
        // Task1
//        TimeSpan t1 = new TimeSpan();
//        System.out.println("Empty: " + t1.getHours() + "h " + t1.getMinutes() + "m");
//
//        TimeSpan t2 = new TimeSpan(160);
//        System.out.println("From minutes: " + t2.getHours() + "h " + t2.getMinutes() + "m");
//
//        TimeSpan t3 = new TimeSpan(1, 25);
//        System.out.println("From hours and minutes: " + t3.getHours() + "h " + t3.getMinutes() + "m");
//
//        TimeSpan copy = new TimeSpan(t3);
//        System.out.println("Copy: " + copy.getHours() + "h " + copy.getMinutes() + "m");
//
//        TimeSpan time = new TimeSpan(1, 15);
//
//        time.add(1, 45);
//        System.out.println("Add hours and minutes: " + time.getHours() + "h " + time.getMinutes() + "m");
//
//        time.add(30);
//        System.out.println("Add minutes: " + time.getHours() + "h " + time.getMinutes() + "m");
//
//        time.add(new TimeSpan(1, 40));
//        System.out.println("Add TimeSpan: " + time.getHours() + "h " + time.getMinutes() + "m");
//
//        time.subtract(1, 15);
//        System.out.println("Subtract hours and minutes: " + time.getHours() + "h " + time.getMinutes() + "m");
//
//        time.subtract(55);
//        System.out.println("Subtract minutes: " + time.getHours() + "h " + time.getMinutes() + "m");
//
//        time.subtract(new TimeSpan(1, 30));
//        System.out.println("Subtract TimeSpan: " + time.getHours() + "h " + time.getMinutes() + "m");
//
//        System.out.println("Total hours: " + time.getTotalHours());
//        System.out.println("Total minutes: " + time.getTotalMinutes());
//
//        time.scale(2);
//        System.out.println("Scaled: " + time.getHours() + "h " + time.getMinutes() + "m");

        // Task2
//        Person person = new Person("Samofalov", "Roman", 19);
//        Person student = new Student("Holotsvan", "Nikita", 18, "AI-251", "ID123456");
//        Person lecturer = new Lecturer("John", "Smith", 50, "Computer Science", 25000);
//
//        Person[] people = { person, student, lecturer };
//
//        for (Person p : people)
//        {
//            System.out.println(p.toString());
//        }

        // Task3
//        SwingUtilities.invokeLater(() -> new MainFrame("RoShamBo"));

        // Task4
        SwingUtilities.invokeLater(() -> new Task4.view.DrawFrame("Draw App"));
    }
}