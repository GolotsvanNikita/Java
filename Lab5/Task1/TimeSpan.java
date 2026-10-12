package Task1;

public class TimeSpan
{
    private int hours;
    private int minutes;

    public TimeSpan()
    {
        this.hours = 0;
        this.minutes = 0;
    }

    public TimeSpan(int minutes)
    {
        if (minutes < 0) throw new IllegalArgumentException("Interval mustn`t be negative");

        this.hours = minutes / 60;
        this.minutes = minutes % 60;
    }

    public TimeSpan(int hours, int minutes)
    {
        if (hours < 0 || minutes < 0) throw new IllegalArgumentException("Interval mustn`t be negative");

        if (minutes > 59) throw new IllegalArgumentException("Minutes range more than 59");

        this.hours = hours;
        this.minutes = minutes;
    }

    public TimeSpan(TimeSpan span)
    {
        if (span.getHours() < 0 || span.getMinutes() < 0) throw new IllegalArgumentException("Interval mustn`t be negative");

        if (span.getMinutes() > 59) throw new IllegalArgumentException("Minutes range more than 59");

        this.hours = span.getHours();
        this.minutes = span.getMinutes();
    }

    public int getHours()
    {
        return this.hours;
    }

    public int getMinutes()
    {
        return this.minutes;
    }

    public void add(int hours, int minutes)
    {
        if (hours < 0 || minutes < 0) throw new IllegalArgumentException("Interval mustn`t be negative");

        if (minutes > 59) throw new IllegalArgumentException("Minutes range more than 59");

        int totalMinutes = this.getTotalMinutes() + (hours * 60 + minutes);
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }

    public void add(int minutes)
    {
        if (minutes < 0) throw new IllegalArgumentException("Interval mustn`t be negative");

        int totalMinutes = this.getTotalMinutes() + minutes;
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }

    public void add(TimeSpan span)
    {
        if (span.getHours() < 0 || span.getMinutes() < 0) throw new IllegalArgumentException("Interval mustn`t be negative");
        if (span.getMinutes() > 59) throw new IllegalArgumentException("Minutes range more than 59");

        int totalMinutes = this.getTotalMinutes() + span.getTotalMinutes();
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }

    public void subtract(int hours, int minutes)
    {
        if (hours < 0 || minutes < 0) throw new IllegalArgumentException("Interval mustn`t be negative");
        if (minutes > 59) throw new IllegalArgumentException("Minutes range more than 59");

        int currentTotal = this.getTotalMinutes();
        int subTotal = hours * 60 + minutes;

        if (currentTotal < subTotal) throw new IllegalArgumentException("Interval mustn`t be negative");

        int newTotal = currentTotal - subTotal;
        this.hours = newTotal / 60;
        this.minutes = newTotal % 60;
    }

    public void subtract(int minutes)
    {
        if (minutes < 0) throw new IllegalArgumentException("Minutes value be negative");

        int currentTotal = this.getTotalMinutes();

        if (currentTotal < minutes) throw new IllegalArgumentException("Interval mustn`t be negative");

        int newTotal = currentTotal - minutes;
        this.hours = newTotal / 60;
        this.minutes = newTotal % 60;
    }

    public void subtract(TimeSpan span)
    {
        if (span.getHours() < 0 || span.getMinutes() < 0) throw new IllegalArgumentException("Interval mustn`t be negative");
        if (span.getMinutes() > 59) throw new IllegalArgumentException("Minutes range more than 59");

        int currentTotal = this.getTotalMinutes();
        int subTotal = span.getTotalMinutes();

        if (currentTotal < subTotal) throw new IllegalArgumentException("Interval mustn`t be negative");

        int newTotal = currentTotal - subTotal;
        this.hours = newTotal / 60;
        this.minutes = newTotal % 60;
    }

    public double getTotalHours()
    {
        return this.hours + (this.minutes / 60.0);
    }

    public int getTotalMinutes()
    {
        return this.hours * 60 + this.minutes;
    }

    public void scale(int factor)
    {
        if (factor <= 0) throw new IllegalArgumentException("Factor must be greater than 0");

        int totalMinutes = this.getTotalMinutes() * factor;
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }
}