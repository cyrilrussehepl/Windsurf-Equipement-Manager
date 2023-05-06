package Controller;

import GUI.JDialogAddBoard;
import GUI.TableModelBoard;
import Model.Model;
import Windsurf.Mast;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import javax.swing.*;
import java.awt.event.*;

public class Controller extends WindowAdapter implements ActionListener {
    //Variables---------------------------------------------------------------------------------------------------------
    public final static String QUIT = "Exit";
    public final static String BOARD = "Board";
    public final static String SAIL = "Sail";
    public final static String WISHBONE = "Wishbone";
    public final static String MAST = "Mast";
    public final static String FIN = "Fin";
    private static Controller instance;
    private Model model;

    //Constructor private for singleton class---------------------------------------------------------------------------
    private Controller() {
        model = Model.getInstance();
    }

    public static Controller getInstance() {
        if (instance == null)
            instance = new Controller();
        return instance;
    }

    //Methods-----------------------------------------------------------------------------------------------------------
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case QUIT:
                quit();
                break;
            case BOARD:
            case SAIL:
            case WISHBONE:
            case MAST:
            case FIN:
                onNewEquipement(command);
                break;
            default:
                break;
        }
    }

    private void onNewEquipement(String command) {
        JDialogAddBoard dialog = new JDialogAddBoard();
        dialog.setVisible(true);
        if (dialog.submited()) {
            switch (command) {
                case BOARD -> {model.addBoard(dialog.getNewBoard());
                    TableModelBoard tableModelBoard = TableModelBoard.getInstance(null);
                    tableModelBoard.updateTable();
                }
//                case SAIL -> model.addSail(dialog.);
//                case WISHBONE -> model.addWishboon();
//                case MAST -> model.addMast();
//                case FIN -> model.addFin();
                default -> throw new IllegalArgumentException("Invalid command for new equipement :" + command);
            }
//            model.saveModel();
        }
        dialog.dispose();
    }

    @Override
    public void windowClosing(WindowEvent e) {
        quit();
    }

    private void quit() {
        int ret = JOptionPane.showConfirmDialog(null, "Do you really want to quit?");
        if (ret == JOptionPane.YES_OPTION)
            System.exit(0);
    }
}
