package ua.opnu;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;

public class Main
{

    public static void main(String[] args)
    {
        // Task 1
        MyOptional<String> middleName = new MyOptional<>();
        System.out.println(middleName);
        System.out.println("isPresent: " + middleName.isPresent());
        System.out.println("orElse: " + middleName.orElse("none"));

        MyOptional<String> username = new MyOptional<>("admin");
        System.out.println(username);
        System.out.println("isPresent: " + username.isPresent());
        System.out.println("get(): " + username.get());
        System.out.println("orElse: " + username.orElse("guest"));

        try
        {
            String test = middleName.get();
            System.out.println("unexpected: " + test);
        }
        catch (IllegalStateException ex)
        {
            System.out.println("Exception: " + ex.getMessage());
        }

        try
        {
            MyOptional<String> broken = new MyOptional<>(null);
            System.out.println("unexpected: " + broken);
        }
        catch (IllegalArgumentException ex)
        {
            System.out.println("correct didn`t permin null: " + ex.getMessage());
        }

        // Task 2
        BookData[] books =
        {
                new BookData("Clean Code", "Robert Martin", 10, 45.0),
                new BookData("Effective Java", "Joshua Bloch", 20, 96.0),
                new BookData("Algorithms", "Robert Sedgewick", 10, 45.0),
                new BookData("Java Concurrency", "Brian Goetz", 5, 20.0)
        };
        Arrays.sort(books);
        for (BookData book : books)
        {
            System.out.println(book);
        }

        // Task 3
        Printer myPrinter = new Printer();
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);

        // Task 4
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8};
        Integer[] evenNumbers = filter(numbers, n -> n % 2 == 0);
        System.out.println("Even numbers: " + Arrays.toString(evenNumbers));

        String[] words = {"Java", "C++", "Generics", "Go", "Optional"};
        String[] longWords = filter(words, s -> s.length() > 3);
        System.out.println("Words longer than 3 chars: " + Arrays.toString(longWords));

        // Task 5
        System.out.println("Contains 'Java': " + contains(words, "Java"));
        System.out.println("Contains 'Python': " + contains(words, "Python"));
        System.out.println("Contains 5: " + contains(numbers, 5));

        // Task 6
        GenericTwoTuple<String, Integer> userScore = new GenericTwoTuple<>("PlayerOne", 1500);
        System.out.println("TwoTuple: " + userScore);
        System.out.println("First: " + userScore.first + ", Second: " + userScore.second);

        GenericThreeTuple<String, Double, Boolean> productInfo =
                new GenericThreeTuple<>("Laptop", 1299.99, true);
        System.out.println("ThreeTuple: " + productInfo);
        System.out.println("Name: " + productInfo.twoTuple.first
                + ", Price: " + productInfo.twoTuple.second
                + ", In stock: " + productInfo.three);
    }

    // Method for Task 4
    @SuppressWarnings("unchecked")
    public static <T> T[] filter(T[] input, Predicate<T> p)
    {
        T[] result = (T[]) new Object[input.length];

        int counter = 0;
        for (T item : input)
        {
            if (p.test(item))
            {
                result[counter] = item;
                counter++;
            }
        }

        return Arrays.copyOfRange(result, 0, counter, (Class<? extends T[]>) input.getClass());
    }

    // Method for Task 5
    public static <T extends Comparable<T>, V extends T> boolean contains(T[] array, V element)
    {
        for (T item : array)
        {
            if (Objects.equals(item, element))
            {
                return true;
            }
        }
        return false;
    }
}