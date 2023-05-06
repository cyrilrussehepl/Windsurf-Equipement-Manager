package GUI.MyTableModels;

import Windsurf.Fin;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class TableModelFin extends AbstractTableModel {
    private ArrayList<Fin> data;
    private static TableModelFin instance;
    private static String[] columnNames = new String[]{
            "Year",
            "Brand",
            "Size",
            "Box Type",
            "Anti-algae"
    };

    public static TableModelFin getInstance(ArrayList<Fin> data) {
        if (instance == null) instance = new TableModelFin(data);
        return instance;
    }

    private TableModelFin(ArrayList<Fin> data) {
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
        Fin sail = data.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return sail.getyear();
            case 1:
                return sail.getBrand();
            case 2:
                return sail.getSize();
            case 3:
                return sail.getBox_type();
            case 4:
                return sail.isAnti_algae();
            default:
                return null;
        }
    }

    public void setData(ArrayList<Fin> data) {
        this.data = data;
    }
}
