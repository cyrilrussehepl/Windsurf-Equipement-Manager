package GUI;

import Controller.Controller;
import Model.Model;
import Windsurf.Board;
import Windsurf.Equipement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

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
    private JMenu menuHelp;
    private JMenu subMenuAdd;
    private JMenuItem itemBoard;
    private JMenuItem itemSail;
    private JMenuItem itemWishbone;
    private JMenuItem itemFin;
    private JMenuItem itemHelp;
    private JMenuItem itemAbout;
    private JMenuItem itemExit;
    private ImageIcon imageIconTest = new ImageIcon("../../img/isonic_73.png");

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
        subMenuAdd = new JMenu("Add");
        subMenuAdd.add(itemBoard);
        subMenuAdd.add(itemSail);
        subMenuAdd.add(itemWishbone);
        subMenuAdd.add(itemFin);
        itemExit = new JMenuItem("Exit");

        menuNew.add(subMenuAdd);
        menuNew.addSeparator();
        menuNew.add(itemExit);
        //menuHelp
        menuHelp = new JMenu("Help");
        itemHelp = new JMenuItem("Help");
        itemAbout = new JMenuItem("About");

        menuHelp.add(itemHelp);
        menuHelp.addSeparator();
        menuHelp.add(itemAbout);
        //Add menus to menuBar
        menuBar.add(menuNew);
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


        //Affichage img test
       /* imageIconTest = new ImageIcon(getClass().getResource("isonic_73.png"));
        labelImg = new JLabel(imageIconTest);
        panelSelectedItem.add(labelImg);*/

        //window size definition and init window position
        setSize(800,600);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screen.width - this.getSize().width)/2,(screen.height - this.getSize().height)/2);
    }

    //Methods-----------------------------------------------------------------------------------------------------------
    public void setController(Controller c){
        this.addWindowListener(c);
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