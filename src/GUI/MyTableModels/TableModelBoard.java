package GUI.MyTableModels;

import Windsurf.Board;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class TableModelBoard extends AbstractTableModel {
    private ArrayList<Board> data;
    public static String[] columnNames = new String[]{
            "Year",
            "Brand",
            "Model",
            "Volume",
            "Width",
            "Category"
    };

    public TableModelBoard(ArrayList<Board> data) {
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
        Board board = data.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return board.getyear();
            case 1:
                return board.getBrand();
            case 2:
                return board.getModel();
            case 3:
                return board.getVolume();
            case 4:
                return board.getWidth();
            case 5:
                return board.getCategory();
            default:
                return null;
        }
    }

    public void setData(ArrayList<Board> data) {
        this.data = data;
    }
}
