package ua.opnu;

public class MyOptional<T>
{
    private T value;
    private boolean present;

    public MyOptional()
    {
        this.present = false;
    }

    public MyOptional(T value)
    {
        if (value == null)
        {
            throw new IllegalArgumentException("MyOptional don`t accept null");
        }
        this.value = value;
        this.present = true;
    }

    public boolean isPresent()
    {
        return present;
    }

    public boolean isEmpty()
    {
        return !isPresent();
    }

    public T get() {
        if (!present)
        {
            throw new IllegalStateException("Unknown value");
        }
        return value;
    }

    public T orElse(T defaultValue)
    {
        return present ? value : defaultValue;
    }

    @Override
    public String toString()
    {
        return present ? "MyOptional[value=" + value + "]" : "MyOptional[empty]";
    }
}