package tasks.task3;

import tasks.task3.interfaces.Cellular;
import tasks.task3.interfaces.GPS;

public class Smartphone implements GPS, Cellular
{

    @Override
    public double[] getCoordinates()
    {
        return new double[]{46.4825, 30.7233};
    }

    @Override
    public void makeCall()
    {
        System.out.println("Call process...");
    }

    @Override
    public void receiveCall()
    {
        System.out.println("Incoming call");
    }
}
