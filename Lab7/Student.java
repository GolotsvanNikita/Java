import java.util.Arrays;

public class Student
{
    private String lastName;
    private double avgMark;

    private String group;
    private int[] marks;

    private String name;

    public Student(String name, String lastName, double avgMark)
    {
        this.name = name;
        this.lastName = lastName;
        this.avgMark = avgMark;
    }

    public Student(String name, String group, int[] marks)
    {
        this.name = name;
        this.group = group;
        this.marks = marks;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public double getAvgMark() { return avgMark; }
    public void setAvgMark(double avgMark) { this.avgMark = avgMark; }

    public String getGroup() { return group; }
    public void setGroup(String group) { this.group = group; }

    public int[] getMarks() { return marks; }
    public void setMarks(int[] marks) { this.marks = marks; }

    @Override
    public String toString()
    {
        if (lastName != null)
        {
            return lastName + " " + name + ", average digit: " + avgMark;
        }
        else
        {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", group='" + group + '\'' +
                    ", marks=" + Arrays.toString(marks) +
                    '}';
        }
    }
}