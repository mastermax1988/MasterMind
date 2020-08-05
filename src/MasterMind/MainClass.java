package MasterMind;

import java.awt.*;

public class MainClass
{
    public static void main(String[] args)
    {
        Board b = new Board(4);
        b.addRow(new Row(new PinColor[]{PinColor.Blue, PinColor.White, PinColor.White, PinColor.Orange}));
        b.checkRow(new Row(new PinColor[]{PinColor.White, PinColor.White, PinColor.Red, PinColor.White}));
    }
}
