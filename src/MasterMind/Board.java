package MasterMind;

import java.util.ArrayList;
import java.util.List;

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
        for(var r : ret)
            System.out.println(r);
        return ret;
    }


    public void addRow(Row r)
    {
        rows.add(r);
    }
    public boolean checkRow(Row row)
    {
        for(Row r : rows)
            r.getMarkers(row);
        return  true;
    }
}
