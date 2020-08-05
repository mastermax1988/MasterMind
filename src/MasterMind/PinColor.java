package MasterMind;

import java.awt.*;

public enum PinColor
{
    White (Color.white), Yellow (Color.yellow), Red (Color.red), Blue(Color.blue), Green (Color.green), Orange (Color.orange), Pink (Color.pink), Purple (new Color(192,0,255)), Hole(Color.black);
    Color color;
    private PinColor(Color c)
    {
        color = c;
    }
    public Color getColor(PinColor p)
    {
        return  color;
    }
}
