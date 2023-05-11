package GUI.MyTableModels;

import Windsurf.Sail;
import Windsurf.Wishbone;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class TableModelWishbone extends AbstractTableModel {
    private ArrayList<Wishbone> data;
    private static String[] columnNames = new String[]{"Year", "Brand", "Min", "Max", "Carbon"};

    public TableModelWishbone(ArrayList<Wishbone> data){
        super();
        this.data = data;
    }
    public void updateTable(){
        fireTableDataChanged();
    }
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Wishbone wishbone = data.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return wishbone.getyear();
            case 1:
                return wishbone.getBrand();
            case 2:
                return wishbone.getSizeMin();
            case 3:
                return wishbone.getSizeMax();
            case 4:
                return wishbone.getCarbonPercent();
            default:
                return null;
        }
    }

    public void setData(ArrayList<Wishbone> data){this.data = data;}
}
