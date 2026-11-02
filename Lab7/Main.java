import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main
{

    public static void main(String[] args)
    {
        // Task 1
        Predicate<Integer> isPrime = n ->
        {
            if (n <= 1) return false;
            for (int i = 2; i <= Math.sqrt(n); i++)
            {
                if (n % i == 0) return false;
            }
            return true;
        };
        System.out.println("Is 7 prime? " + isPrime.test(7));
        System.out.println("Is 10 prime? " + isPrime.test(10));


        // Task 2
        Student[] students =
        {
                new Student("Maxim Olehov", "AI-101", new int[]{85, 90, 95}),
                new Student("Over Smith", "AI-101", new int[]{100, 55, 75}),
                new Student("Bob Martin", "AI-102", new int[]{45, 50, 60}),
                new Student("Alice Cooper", "AI-102", new int[]{70, 80, 90})
        };

        Predicate<Student> hasNoDebts = student ->
        {
            for (int mark : student.getMarks())
            {
                if (mark < 60) return false;
            }
            return true;
        };

        List<Student> goodStudents = filterStudents(students, hasNoDebts);
        System.out.println("Students without debts:");
        goodStudents.forEach(System.out::println);


        // Task 3
        Predicate<Student> fromGroupAI101 = student -> student.getGroup().equals("AI-101");

        List<Student> filteredByTwoConditions = filterWithTwoConditions(students, hasNoDebts, fromGroupAI101);
        System.out.println("Good students from AI-101:");
        filteredByTwoConditions.forEach(System.out::println);


        // Task 4
        Consumer<Student> printLastAndFirstName = student ->
        {
            String[] nameParts = student.getName().split(" ");
            if (nameParts.length >= 2)
            {
                System.out.println(nameParts[1].toUpperCase() + " " + nameParts[0].toUpperCase());
            }
            else
            {
                System.out.println(student.getName().toUpperCase());
            }
        };

        System.out.println("Formatted student names:");
        Arrays.asList(students).forEach(printLastAndFirstName);


        // Task 5
        Integer[] numbersForTask5 = {1, -5, 10, -20, 33, 42};
        Predicate<Integer> isPositive = n -> n > 0;
        Consumer<Integer> printSquare = n -> System.out.println("Square of " + n + " is " + (n * n));

        System.out.println("Processing only positive numbers:");
        processIf(numbersForTask5, isPositive, printSquare);


        // Task 6
        Function<Integer, Integer> powerOfTwo = n -> (int) Math.pow(2, n);

        int[] numbersForTask6 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("Powers of 2:");
        for (int num : numbersForTask6)
        {
            System.out.println("2^" + num + " = " + powerOfTwo.apply(num));
        }


        // Task 7
        Function<Integer, String> numberToWord = n ->
        {
            String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
            if (n >= 0 && n <= 9) return words[n];
            return "unknown";
        };

        int[] numbersForTask7 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.print("Stringified array: ");
        stringify(numbersForTask7, numberToWord);
    }

    // Helper method for Task 2
    public static List<Student> filterStudents(Student[] array, Predicate<Student> condition)
    {
        List<Student> result = new ArrayList<>();
        for (Student item : array)
        {
            if (condition.test(item))
            {
                result.add(item);
            }
        }
        return result;
    }

    // Helper method for Task 3
    public static <T> List<T> filterWithTwoConditions(T[] array, Predicate<T> condition1, Predicate<T> condition2)
    {
        List<T> result = new ArrayList<>();
        for (T item : array)
        {
            if (condition1.test(item) && condition2.test(item))
            {
                result.add(item);
            }
        }
        return result;
    }

    // Helper method for Task 5
    public static <T> void processIf(T[] array, Predicate<T> condition, Consumer<T> action)
    {
        for (T item : array)
        {
            if (condition.test(item))
            {
                action.accept(item);
            }
        }
    }

    // Helper method for Task 7
    public static void stringify(int[] array, Function<Integer, String> transformer)
    {
        for (int i = 0; i < array.length; i++)
        {
            System.out.print(transformer.apply(array[i]));
            if (i < array.length - 1)
            {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}