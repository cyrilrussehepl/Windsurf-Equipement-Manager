package GUI;

import Controller.Controller;
import GUI.MyTableModels.*;
import Model.Model;
import Windsurf.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class JFrameWEMConsole extends JFrame {
    //Variables---------------------------------------------------------------------------------------------------------
    private JPanel mainPanel;
    private JComboBox comboBoxDataSelection;
    private JPanel panelSelectedItem;
    private JTable tableData;
    private JLabel labelImg;
    private JScrollPane scrollPaneTableDataContainer;
    private JButton buttonDelete;
    private JButton buttonUpdate;
    private JMenuBar menuBar;
    private JMenu menuNew;
    private JMenu subMenuAdd;
    private JMenu menuSettings;
    private JMenuItem itemBoard;
    private JMenuItem itemSail;
    private JMenuItem itemWishbone;
    private JMenuItem itemFin;
    private JMenuItem itemMast;
    private JMenuItem itemHelp;
    private JMenuItem itemAbout;
    private JMenuItem itemExit;
    private JMenuItem itemSave;
    private JMenuItem itemSaveAs;
    private JMenuItem itemLoad;
    private JMenuItem itemSettings;
    private TableType currentTableEquipmentType;
    private TableModelBoard tableModelBoard;
    private TableModelSail tableModelSail;
    private TableModelWishbone tableModelWishbone;
    private TableModelMast tableModelMast;
    private TableModelFin tableModelFin;

    public enum TableType{
        BOARD,
        SAIL,
        WISHBONE,
        MAST,
        FIN
    }

    //Constructor-------------------------------------------------------------------------------------------------------
    public JFrameWEMConsole() {
        //Init window properties
        super();
        setContentPane(mainPanel);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("Windsurf Equipement Manager");

        //Init menuBar
        menuBar = new JMenuBar();
        //menuNew
        menuNew = new JMenu("New");
        itemBoard = new JMenuItem("Board");
        itemSail = new JMenuItem("Sail");
        itemWishbone = new JMenuItem("Wishbone");
        itemFin = new JMenuItem("Fin");
        itemMast = new JMenuItem("Mast");
        subMenuAdd = new JMenu("Add");
        subMenuAdd.add(itemBoard);
        subMenuAdd.add(itemSail);
        subMenuAdd.add(itemWishbone);
        subMenuAdd.add(itemMast);
        subMenuAdd.add(itemFin);
        itemSave = new JMenuItem("Save");
        itemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        itemSaveAs = new JMenuItem("Save As");
        itemLoad = new JMenuItem("Load");
        itemLoad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        itemExit = new JMenuItem("Exit");
        itemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));

        menuNew.add(subMenuAdd);
        menuNew.addSeparator();
        menuNew.add(itemSave);
        menuNew.add(itemSaveAs);
        menuNew.add(itemLoad);
        menuNew.addSeparator();
        menuNew.add(itemExit);
        //menuSettings
        menuSettings = new JMenu("Settings");
        itemSettings = new JMenuItem("Settings");
        //menuHelp
        itemHelp = new JMenuItem("Help");
        itemAbout = new JMenuItem("About");

        menuSettings.add(itemSettings);
        menuSettings.addSeparator();
        menuSettings.add(itemHelp);
        menuSettings.add(itemAbout);
        //Add menus to menuBar
        menuBar.add(menuNew);
        menuBar.add(menuSettings);
        this.setJMenuBar(menuBar);

        //ComboBoxSelection
        comboBoxDataSelection.addItem("Boards");
        comboBoxDataSelection.addItem("Sails");
        comboBoxDataSelection.addItem("Wishbones");
        comboBoxDataSelection.addItem("Masts");
        comboBoxDataSelection.addItem("Fins");
        currentTableEquipmentType = TableType.BOARD;

        //table
        Model model = Model.getInstance();
        tableModelBoard = new TableModelBoard(model.getBoards());
        tableModelSail = new TableModelSail(model.getSails());
        tableModelWishbone = new TableModelWishbone(model.getWishboons());
        tableModelMast = new TableModelMast(model.getMasts());
        tableModelFin = new TableModelFin(model.getFins());
        tableData.setModel(tableModelBoard);

        //window size definition and init window position
        setSize(800, 600);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screen.width - this.getSize().width) / 2, (screen.height - this.getSize().height) / 2);
    }

    //Methods-----------------------------------------------------------------------------------------------------------
    public void setController(Controller c) {
        itemBoard.addActionListener(c);
        itemSail.addActionListener(c);
        itemWishbone.addActionListener(c);
        itemMast.addActionListener(c);
        itemFin.addActionListener(c);
        itemLoad.addActionListener(c);
        itemSave.addActionListener(c);
        itemSaveAs.addActionListener(c);
        itemExit.addActionListener(c);
        itemSettings.addActionListener(c);
        itemHelp.addActionListener(c);
        itemAbout.addActionListener(c);
        buttonUpdate.addActionListener(c);
        buttonDelete.addActionListener(c);
        comboBoxDataSelection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentTableEquipmentType == TableType.values()[comboBoxDataSelection.getSelectedIndex()])
                    return;
                currentTableEquipmentType = TableType.values()[comboBoxDataSelection.getSelectedIndex()];
                updateTableData();
                changeImg();
            }
        });
        this.addWindowListener(c);
    }

    private void changeImg() {
        switch (currentTableEquipmentType) {
            case BOARD -> labelImg.setIcon(new ImageIcon(getClass().getResource("/img/Board.png")));
            case SAIL -> labelImg.setIcon(new ImageIcon(getClass().getResource("/img/Sail.png")));
            case WISHBONE -> labelImg.setIcon(new ImageIcon(getClass().getResource("/img/Wishbone.png")));
            case MAST -> labelImg.setIcon(new ImageIcon(getClass().getResource("/img/Mast.png")));
            case FIN -> labelImg.setIcon(new ImageIcon(getClass().getResource("/img/Fin.png")));
        }
    }

    public void updateTableData() {
        switch (currentTableEquipmentType) {
            case BOARD -> tableData.setModel(tableModelBoard);
            case SAIL -> tableData.setModel(tableModelSail);
            case WISHBONE -> tableData.setModel(tableModelWishbone);
            case MAST -> tableData.setModel(tableModelMast);
            case FIN -> tableData.setModel(tableModelFin);
        }
    }

    public void refreshTable() {
        switch (currentTableEquipmentType){
            case BOARD -> tableModelBoard.updateTable();
            case SAIL -> tableModelSail.updateTable();
            case WISHBONE -> tableModelWishbone.updateTable();
            case MAST -> tableModelMast.updateTable();
            case FIN -> tableModelFin.updateTable();
        }
    }

    public void loadNewData(ArrayList<Board> boards, ArrayList<Sail> sails, ArrayList<Wishbone> wishbones, ArrayList<Mast> masts, ArrayList<Fin> fins){
        tableModelBoard.setData(boards);
        tableModelSail.setData(sails);
        tableModelWishbone.setData(wishbones);
        tableModelMast.setData(masts);
        tableModelFin.setData(fins);
        refreshTable();
    }

    //Static Methods----------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        JFrameWEMConsole window = new JFrameWEMConsole();
        Controller controller = Controller.getInstance(window);
        Model model = Model.getInstance();
        window.setController(controller);
        window.setVisible(true);
    }

    //Getters
    public TableType getCurrentTableEquipmentType(){
        return currentTableEquipmentType;
    }

    public int getSelectedRow(){
        return tableData.getSelectedRow();
    }

}