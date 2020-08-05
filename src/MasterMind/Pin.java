package MasterMind;

public class Pin
{
    private final PinColor pinColor;
    private boolean checked;
    public Pin(PinColor c)
    {
        pinColor = c;
        checked = false;
    }
    public void setChecked()
    {
        checked = true;
    }
    public void uncheck()
    {
        checked = false;
    }
    public  boolean getChecked()
    {
        return checked;
    }
    public PinColor getColor()
    {
        return pinColor;
    }
}
