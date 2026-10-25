package tasks.task2;

import tasks.task2.interfaces.Movable;

public class Point implements Movable
{
    private double x;
    private double y;

    @Override
    public void setX(double x)
    {
        this.x = x;
    }

    @Override
    public void setY(double y)
    {
        this.y = y;
    }

    @Override
    public double getX()
    {
        return x;
    }

    @Override
    public double getY()
    {
        return y;
    }

    @Override
    public void moveTo(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
}
