package MasterMind;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board
{
    private  final int iSize;
    private  List<Row> rows;
    private final boolean bMultiColor, bHole;
    private  List<Row> allPossibleRows;
    public Board(int iSize, boolean bD, boolean bH)
    {
        this.iSize = iSize;
        rows = new ArrayList<>();
        bMultiColor = bD;
        bHole = bH;
        allPossibleRows = generateAllPossibleRows();
    }
    public boolean bSolved()
    {
        return allPossibleRows.size() == 1;
    }
    private ArrayList<Row> generateAllPossibleRows()
    {
        var ret = new ArrayList<Row>();
        for(PinColor c : PinColor.values())
        {
            if (c == PinColor.Hole && !bHole)
                continue;
            var row = new Row(iSize);
            row.setPin(c, 0);
            ret.add(row);
        }
        int iIndex=1;
        while (iIndex<iSize)
        {
            var tmpRow = new ArrayList<Row>();
            for(Row row : ret)
            {
                for(PinColor c : PinColor.values())
                {
                     if (c == PinColor.Hole && !bHole)
                         continue;
                     if(!bMultiColor && row.getColorCount(c)>0)
                         continue;
                    var r = row.Clone();
                    r.setPin(c,iIndex);
                    tmpRow.add(r);
                }
            }
            ret = tmpRow;
            iIndex++;
        }
        return ret;
    }

    public void updatePossibleRows()
    {
        var it = allPossibleRows.iterator();
        while(it.hasNext())
        {
            var r = it.next();
            for(var row : rows)
            {
                var m = row.generateMarker(r);
                var om = row.getMarker();
                if(m.getWhite() != om.getWhite() || m.getRed() != om.getRed())
                    it.remove();
            }
        }
    }
        public void printAllPossibleRows()
        {
            System.out.println("\n\n");
            for(var r : allPossibleRows)
                System.out.println(r.toString());
            System.out.println("Es gibt noch " + allPossibleRows.size() + " Möglichkeiten");
        }
    public void printSuggestion()
    {
        Random rnd = new Random();
        for(int i=0;i<10;i++)
            System.out.println("Vorschlag: " + allPossibleRows.get(rnd.nextInt(allPossibleRows.size())).toString());
    }
    public void addRow(Row r)
    {
        rows.add(r);
    }
    public boolean checkRow(Row row)
    {
        for(Row r : rows)
            r.generateMarker(row);
        return  true;
    }
}
