package MasterMind;

public class Row
{
    private final int size;
    Pin[] pins;

    public Row(int size)
    {
        pins = new Pin[size];
        this.size = size;
    }
    public void setPins(PinColor[] p)
    {
        for(int i=0;i<size;i++)
            pins[i] = new Pin(p[i]);
    }
    public Marker getMarkers(Row r)
    {
        return null;
    }
}
