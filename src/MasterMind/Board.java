package MasterMind;

import java.util.ArrayList;
import java.util.List;

public class Board
{
    private  final int iSize;
    private  List<Row> rows;
    public Board(int iSize)
    {
        this.iSize = iSize;
        rows = new ArrayList<>();
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
