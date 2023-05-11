package GUI.MyTableModels;

import Windsurf.Mast;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class TableModelMast extends AbstractTableModel {
    private ArrayList<Mast> data;
    private static String[] columnNames = new String[]{"Year", "Brand", "Length", "Carbon Percent", "Curve", "Geometry"};

    public TableModelMast(ArrayList<Mast> data) {
        super();
        this.data = data;
    }

    public void updateTable() {
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
        Mast mast = data.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return mast.getyear();
            case 1:
                return mast.getBrand();
            case 2:
                return mast.getLength();
            case 3:
                return mast.getCarbonPercent();
            case 4:
                return mast.getCurve();
            case 5:
                return mast.getGeometry();
            default:
                return null;
        }
    }

    public void setData(ArrayList<Mast> data) {
        this.data = data;
    }
}
