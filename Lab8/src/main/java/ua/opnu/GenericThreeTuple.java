package ua.opnu;

public class GenericThreeTuple<T, V, S>
{
    public final GenericTwoTuple<T, V> twoTuple;
    public final S three;

    public GenericThreeTuple(T first, V second, S three)
    {
        this.twoTuple = new GenericTwoTuple<>(first, second);
        this.three = three;
    }

    @Override
    public String toString()
    {
        return "(" + twoTuple.first + ", " + twoTuple.second + ", " + three + ")";
    }
}