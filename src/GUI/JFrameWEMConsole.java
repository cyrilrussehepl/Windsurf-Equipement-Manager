package GUI;

import Controller.Controller;
import GUI.MyTableModels.*;
import Model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class JFrameWEMConsole extends JFrame {
    //Variables---------------------------------------------------------------------------------------------------------
    private JPanel mainPanel;
    private JComboBox comboBoxDataSelection;
    private JPanel panelSelectedItem;
    private JTable tableData;
    private JList listDataSelectedItem;
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
    private int currentComboboxIndex;

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
        subMenuAdd.add(itemMast);
        subMenuAdd.add(itemWishbone);
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
        currentComboboxIndex = 0;

        //table
        Model model = Model.getInstance();
        TableModelBoard tableModelBoard = TableModelBoard.getInstance(model.getBoards());
        TableModelSail tableModelSail = TableModelSail.getInstance(model.getSails());
        TableModelWishbone tableModelWishbone = TableModelWishbone.getInstance(model.getWishboons());
        TableModelMast tableModelMast = TableModelMast.getInstance(model.getMasts());
        TableModelFin tableModelFin = TableModelFin.getInstance(model.getFins());
        //for test
//        for (int i = 0; i < 10; i++)
//            model.addBoard(new Board(2022, "Fanatic", Equipement.Category.PLANCHE, 100, 80, "Falcon"));
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
        c.setTable(tableData);
        comboBoxDataSelection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentComboboxIndex == comboBoxDataSelection.getSelectedIndex())
                    return;
                currentComboboxIndex = comboBoxDataSelection.getSelectedIndex();
                Model.getInstance().setCurrentTable(currentComboboxIndex);
                loadTableData();
                changeImg();
            }
        });
        this.addWindowListener(c);
    }

    private void changeImg() {
        switch (currentComboboxIndex) {
            case 0 -> labelImg.setIcon(new ImageIcon("src/img/Board.png"));
            case 1 -> labelImg.setIcon(new ImageIcon("src/img/Sail.png"));
            case 2 -> labelImg.setIcon(new ImageIcon("src/img/Wishbone.png"));
            case 3 -> labelImg.setIcon(new ImageIcon("src/img/Mast.png"));
            case 4 -> labelImg.setIcon(new ImageIcon("src/img/Fin.png"));
        }
    }

    public void loadTableData() {
        Model model = Model.getInstance();
        switch (currentComboboxIndex) {
            case 0 -> {
                TableModelBoard tableModelBoard = TableModelBoard.getInstance(model.getBoards());
                tableData.setModel(tableModelBoard);
            }
            case 1 -> {
                TableModelSail tableModelSail = TableModelSail.getInstance(model.getSails());
                tableData.setModel(tableModelSail);
            }
            case 2 -> {
                TableModelWishbone tableModelWishbone = TableModelWishbone.getInstance(model.getWishboons());
                tableData.setModel(tableModelWishbone);
            }
            case 3 -> {
                TableModelMast tableModelMast = TableModelMast.getInstance(model.getMasts());
                tableData.setModel(tableModelMast);
            }
            case 4 -> {
                TableModelFin tableModelFin = TableModelFin.getInstance(model.getFins());
                tableData.setModel(tableModelFin);
            }
        }
    }

    //Static Methods----------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        JFrameWEMConsole window = new JFrameWEMConsole();
        Controller controller = Controller.getInstance();
        Model model = Model.getInstance();
        window.setController(controller);
        window.setVisible(true);
    }
}