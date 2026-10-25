import tasks.task1.Animal;
import tasks.task1.Cat;
import tasks.task1.Dog;
import tasks.task2.Point;
import tasks.task3.Smartphone;
import tasks.task4.Car;
import tasks.task5.view.DrawFrame;

import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        // Task 1
        Animal myDog = new Dog("Rex");
        Animal myCat = new Cat("Murzik");

        System.out.println(myDog.getName() + " say: " + myDog.makeSound());
        System.out.println(myCat.getName() + " say: " + myCat.makeSound());

        // Task 2
        Point point = new Point();
        point.setX(10.5);
        point.setY(20.0);
        System.out.println("X=" + point.getX() + ", Y=" + point.getY());
        point.moveTo(5.0, 15.5);
        System.out.println("Point move: X=" + point.getX() + ", Y=" + point.getY());

        // Task 3
        Smartphone phone = new Smartphone();
        double[] coords = phone.getCoordinates();
        System.out.println("coordinates GPS: " + coords[0] + ", " + coords[1]);
        phone.makeCall();
        phone.receiveCall();

        // Task 4
        Car car1 = new Car(15000, 2016, 120);
        Car car2 = new Car(15000, 2018, 110);
        Car car3 = new Car(20000, 2020, 150);

        int result1 = car1.compareTo(car3);
        if (result1 > 0) System.out.println("car1 > car3");

        int result2 = car1.compareTo(car2);
        if (result2 < 0) System.out.println("car2 > car1");

        // Task 5
        SwingUtilities.invokeLater(() -> new DrawFrame("Draw App"));

        // Task 6 starting in Launcher
    }
}
