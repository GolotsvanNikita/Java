package tasks.task4;

public class Car implements Comparable
{
    private int price;
    private int year;
    private int horsePower;

    public Car(int price, int year, int horsePower)
    {
        this.price = price;
        this.year = year;
        this.horsePower = horsePower;
    }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public int getHorsePower() { return horsePower; }
    public void setHorsePower(int horsePower) { this.horsePower = horsePower; }

    @Override
    public int compareTo(Object obj)
    {
        Car other = (Car) obj;

        int priceDiff = other.price - this.price;
        if (priceDiff != 0) return priceDiff;

        int yearDiff = this.year - other.year;
        if (yearDiff != 0) return yearDiff;

        return this.horsePower - other.horsePower;
    }
}
