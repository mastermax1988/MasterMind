package MasterMind;

public class Marker
{
    private final int iRed, iWhite;
    public Marker(int iRed, int iWhite)
    {
        this.iRed = iRed;
        this.iWhite = iWhite;
    }
    public int getRed()
    {
        return  iRed;
    }
    public int getWhite()
    {
        return  iWhite;
    }
    public int[] getMarkers()
    {
        return new int[]{iRed, iWhite};
    }
}
