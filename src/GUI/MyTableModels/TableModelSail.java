package GUI.MyTableModels;

import Windsurf.Sail;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class TableModelSail extends AbstractTableModel {
    private ArrayList<Sail> data;
    private static String[] columnNames = new String[]{"Year", "Brand", "Model", "Area", "Category"};

    public TableModelSail(ArrayList<Sail> data) {
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
        Sail sail = data.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return sail.getyear();
            case 1:
                return sail.getBrand();
            case 2:
                return sail.getModel();
            case 3:
                return sail.getArea();
            case 4:
                return sail.getCategory();
            default:
                return null;
        }
    }

    public void setData(ArrayList<Sail> data) {
        this.data = data;
    }
}
