import exceptions.IllegalInputTimeSpanException;
import exceptions.IllegalScaleFactorException;
import exceptions.NegativeTimeSpanException;

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
        if (minutes < 0)
        {
            throw new IllegalInputTimeSpanException("Minutes cannot be negative: " + minutes);
        }
        this.hours = minutes / 60;
        this.minutes = minutes % 60;
    }

    public TimeSpan(int hours, int minutes)
    {
        validateHoursAndMinutes(hours, minutes);
        this.hours = hours;
        this.minutes = minutes;
    }

    public TimeSpan(TimeSpan span)
    {
        if (span == null)
        {
            throw new IllegalInputTimeSpanException("TimeSpan cannot be null");
        }
        this.hours = span.hours;
        this.minutes = span.minutes;
    }

    private void validateHoursAndMinutes(int hours, int minutes)
    {
        if (hours < 0 || minutes < 0 || minutes > 59)
        {
            throw new IllegalInputTimeSpanException(
                    "Invalid time input: hours=" + hours + ", minutes=" + minutes +
                            " (hours must be >= 0, minutes must be in range 0..59)"
            );
        }
    }

    public int getHours()
    {
        return hours;
    }

    public int getMinutes()
    {
        return minutes;
    }

    public void add(int hours, int minutes)
    {
        validateHoursAndMinutes(hours, minutes);
        int total = getTotalMinutes() + hours * 60 + minutes;
        this.hours = total / 60;
        this.minutes = total % 60;
    }

    public void add(int minutes)
    {
        if (minutes < 0)
        {
            throw new IllegalInputTimeSpanException("Minutes to add cannot be negative: " + minutes);
        }
        int total = getTotalMinutes() + minutes;
        this.hours = total / 60;
        this.minutes = total % 60;
    }

    public void add(TimeSpan span)
    {
        if (span == null)
        {
            throw new IllegalInputTimeSpanException("TimeSpan to add cannot be null");
        }
        add(span.hours, span.minutes);
    }

    public double getTotalHours()
    {
        return hours + minutes / 60.0;
    }

    public int getTotalMinutes()
    {
        return hours * 60 + minutes;
    }

    public void subtract(int hours, int minutes)
    {
        validateHoursAndMinutes(hours, minutes);
        int diff = getTotalMinutes() - (hours * 60 + minutes);
        if (diff < 0)
        {
            throw new NegativeTimeSpanException(
                    "Cannot subtract " + hours + "h " + minutes + "m from " + this + ": result would be negative"
            );
        }
        this.hours = diff / 60;
        this.minutes = diff % 60;
    }

    public void subtract(int minutes)
    {
        if (minutes < 0)
        {
            throw new IllegalInputTimeSpanException("Minutes to subtract cannot be negative: " + minutes);
        }
        int diff = getTotalMinutes() - minutes;
        if (diff < 0)
        {
            throw new NegativeTimeSpanException(
                    "Cannot subtract " + minutes + "m from " + this + ": result would be negative"
            );
        }
        this.hours = diff / 60;
        this.minutes = diff % 60;
    }

    public void subtract(TimeSpan span)
    {
        if (span == null)
        {
            throw new IllegalInputTimeSpanException("TimeSpan to subtract cannot be null");
        }
        subtract(span.hours, span.minutes);
    }

    public void scale(int factor)
    {
        if (factor <= 0)
        {
            throw new IllegalScaleFactorException("Scale factor must be greater than 0, got: " + factor);
        }
        int total = getTotalMinutes() * factor;
        this.hours = total / 60;
        this.minutes = total % 60;
    }

    @Override
    public String toString()
    {
        return hours + "h " + minutes + "m";
    }

    public static void main(String[] args)
    {
        TimeSpan span = new TimeSpan(2, 30);
        System.out.println("Initial: " + span);

        span.add(1, 45);
        System.out.println("After add(1, 45): " + span);

        span.scale(2);
        System.out.println("After scale(2): " + span);

        try
        {
            new TimeSpan(1, 75);
        }
        catch (IllegalInputTimeSpanException e)
        {
            System.err.println("Caught IllegalInputTimeSpanException: " + e.getMessage());
        }

        try
        {
            span.subtract(10, 0);
        }
        catch (NegativeTimeSpanException e)
        {
            System.err.println("Caught NegativeTimeSpanException: " + e.getMessage());
        }

        try
        {
            span.scale(0);
        }
        catch (IllegalScaleFactorException e)
        {
            System.err.println("Caught IllegalScaleFactorException: " + e.getMessage());
        }
    }
}