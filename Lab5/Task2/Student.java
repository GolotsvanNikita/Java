package Task2;

public class Student extends Person
{
    private String group;
    private String ticketNumber;

    public Student(String lastName, String firstName, int age, String group, String ticketNumber)
    {
        super(lastName, firstName, age);
        this.group = group;
        this.ticketNumber = ticketNumber;
    }

    public String getGroup()
    {
        return group;
    }

    public void setGroup(String group)
    {
        this.group = group;
    }

    public String getTicketNumber()
    {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber)
    {
        this.ticketNumber = ticketNumber;
    }

    @Override
    public String toString()
    {
        return "Student of group " + group + ", " + getLastName() + " " + getFirstName() + ", age: " + getAge() +
                ". Student ticket number: " + ticketNumber;
    }
}