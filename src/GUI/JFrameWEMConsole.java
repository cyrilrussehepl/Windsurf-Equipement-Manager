package GUI;

import Controller.Controller;
import Model.Model;
import Windsurf.Board;
import Windsurf.Equipement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class JFrameWEMConsole extends JFrame {
    //Variables---------------------------------------------------------------------------------------------------------
    private JPanel mainPanel;
    private JComboBox comboBoxDataSelection;
    private JPanel panelSelectedItem;
    private JTable tableData;
    private JList listDataSelectedItem;
    private JLabel labelImg;
    private JScrollPane scrollPaneTableDataContainer;
    private JMenuBar menuBar;
    private JMenu menuNew;
    private JMenu menuSettings;
    private JMenu menuHelp;
    private JMenu subMenuAdd;
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

    //Constructor-------------------------------------------------------------------------------------------------------
    public JFrameWEMConsole()
    {
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
        itemSettings = new JMenuItem("Settings");
        menuSettings = new JMenu("Settings");

        menuSettings.add(itemSettings);
        //menuHelp
        menuHelp = new JMenu("Help");
        itemHelp = new JMenuItem("Help");
        itemAbout = new JMenuItem("About");

        menuHelp.add(itemHelp);
        menuHelp.addSeparator();
        menuHelp.add(itemAbout);
        //Add menus to menuBar
        menuBar.add(menuNew);
        menuBar.add(menuSettings);
        menuBar.add(menuHelp);
        this.setJMenuBar(menuBar);

        //ComboBoxSelection
        comboBoxDataSelection.addItem("Boards");
        comboBoxDataSelection.addItem("Sails");
        comboBoxDataSelection.addItem("Wishbones");
        comboBoxDataSelection.addItem("Fins");

        //table
        DefaultTableModel model = new DefaultTableModel();

        Board testBoard = new Board(2020, "Starboard", Equipement.Category.PLANCHE, 110, 80, "Futura");

        Object[][] dataBoardTest = {{2022, "Starboard", "Isonic", 117, 70, Equipement.Category.PLANCHE},
                {2022, "Starboard", "Isonic", 117, 70, Equipement.Category.PLANCHE},
                {2022, "Starboard", "Isonic", 117, 70, Equipement.Category.PLANCHE},
                {2022, "Starboard", "Isonic", 117, 70, Equipement.Category.PLANCHE},
                {2022, "Starboard", "Isonic", 117, 70, Equipement.Category.PLANCHE},
                {2022, "Starboard", "Isonic", 117, 70, Equipement.Category.PLANCHE},
                {2022, "Starboard", "Isonic", 117, 70, Equipement.Category.PLANCHE},
                {2022, "Starboard", "Isonic", 117, 70, Equipement.Category.PLANCHE},
                {2022, "Starboard", "Isonic", 117, 70, Equipement.Category.PLANCHE},
                {2022, "Starboard", "Isonic", 117, 70, Equipement.Category.PLANCHE},
                {2022, "Starboard", "Isonic", 117, 70, Equipement.Category.PLANCHE},
                {2022, "Starboard", "Isonic", 117, 70, Equipement.Category.PLANCHE},
                {2022, "Starboard", "Isonic", 117, 70, Equipement.Category.PLANCHE},
                {2022, "Starboard", "Isonic", 117, 70, Equipement.Category.PLANCHE},
                testBoard.toObject()
        };
        model.setDataVector(dataBoardTest, GUIData.columnBoard);
        tableData.setModel(model);

        //window size definition and init window position
        setSize(800,600);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screen.width - this.getSize().width)/2,(screen.height - this.getSize().height)/2);
    }

    //Methods-----------------------------------------------------------------------------------------------------------
    public void setController(Controller c){
        itemBoard.addActionListener(c);
        itemSail.addActionListener(c);
        itemWishbone.addActionListener(c);
        itemMast.addActionListener(c);
        itemFin.addActionListener(c);
        itemExit.addActionListener(c);
        this.addWindowListener(c);
    }

    //Static Methods----------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        JFrameWEMConsole window = new JFrameWEMConsole();
        Controller controller = Controller.getInstance();
        Model model = Model.getInstance();
//        model.saveModel();

        window.setController(controller);
        window.setVisible(true);
    }
}