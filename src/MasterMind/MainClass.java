package MasterMind;

import java.awt.*;
import javax.swing.*;

public class MainClass
{
    public static void main(String[] args)
    {
        int iSize=4;
        boolean bMulti=true;
        boolean bHole=false;
        Board b = new Board(iSize,bMulti,bHole);
        b.printAllPossibleRows();
        while(!b.bSolved())
        {
            Object[] options = PinColor.values();
            int selelected;
            Row r;
            PinColor[] pc = new PinColor[iSize];
            for(int i=0;i<iSize;i++)
            {
                selelected = JOptionPane.showOptionDialog(null, "Farbe von Pin " + (i + 1) + " wählen", "Farbe wählen", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                pc[i] = (PinColor)options[selelected];
            }
            r = new Row(pc);
            JTextField redText = new JTextField();
            JTextField whiteText = new JTextField();
            Object[] msg = {"Rot", redText, "Weiß", whiteText};
            JOptionPane pane = new JOptionPane(msg, JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_OPTION);
            pane.createDialog(null, "MarkerPins festlegen").setVisible(true);
            int ir=0,iw=0;
            try
            {
                ir=Integer.parseInt(redText.getText());
            }
            catch (Exception e){}
           try
            {
                iw=Integer.parseInt(whiteText.getText());
            }
            catch (Exception e){}
            r.setMarker(new Marker(ir,iw));
            b.addRow(r);
            b.updatePossibleRows();
            b.printAllPossibleRows();
            b.printSuggestion();
        }
    }
}
