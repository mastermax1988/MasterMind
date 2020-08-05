package MasterMind;

import java.util.ArrayList;
import java.util.List;

public class Row
{
    private final int size;
    private Pin[] pins;

    public Row(int size)
    {
        pins = new Pin[size];
        this.size = size;
    }
    public Row(PinColor[] p)
    {
        this(p.length);
        setPins(p);
    }
    public void setPins(PinColor[] p)
    {
        for(int i=0;i<size;i++)
            pins[i] = new Pin(p[i]);
    }
    public int getColorCount(PinColor c)
    {
        int iRet=0;
        for(Pin p : pins)
           if(p.getColor() == c)
               iRet++;
        return iRet;
    }
    public PinColor getPinColor(int i)
    {
        return pins[i].getColor();
    }
    public void uncheckAllPins()
    {
        for(Pin p : pins)
            p.uncheck();
    }
    public boolean getPinChecked(int i)
    {
        return pins[i].getChecked();
    }
    public void setPinChecked(int i)
    {
        pins[i].setChecked();
    }
    public Marker getMarkers(Row r)
    {
        int iRed=0, iWhite=0;
        r.uncheckAllPins();
        uncheckAllPins();
        for(int i=0;i<size;i++)
        {
            if(pins[i].getColor() == r.getPinColor(i))
            {
                iRed++;
                pins[i].setChecked();
                r.setPinChecked(i);
            }
        }
        for(int i=0;i<size;i++)
        {
            if(pins[i].getChecked())
                continue;
            for(int j=0;j<size;j++)
            {
                if(i==j)
                    continue;
                if(r.getPinChecked(j))
                    continue;
                if(pins[i].getChecked())
                    continue;
                if(pins[i].getColor() == r.getPinColor(j))
                {
                    iWhite++;
                    pins[i].setChecked();
                    r.setPinChecked(j);
                }
            }
        }
        return new Marker(iRed,iWhite);
    }
}
