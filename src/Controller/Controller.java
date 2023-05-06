package Controller;

import GUI.*;
import GUI.MyTableModels.*;
import Model.Model;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.*;
import java.io.*;

public class Controller extends WindowAdapter implements ActionListener {
    //Variables---------------------------------------------------------------------------------------------------------
    private final static String QUIT = "Exit";
    private final static String BOARD = "Board";
    private final static String SAIL = "Sail";
    private final static String WISHBONE = "Wishbone";
    private final static String MAST = "Mast";
    private final static String FIN = "Fin";
    private final static String SAVE = "Save";
    private final static String SAVE_AS = "Save As";
    private final static String LOAD = "Load";
    private static Controller instance;
    private static String filename;
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
            case QUIT -> quit();
            case BOARD -> onNewBoard(command);
            case SAIL -> onNewSail(command);
            case WISHBONE -> onNewWishbone(command);
            case MAST-> onNewMast(command);
            case FIN-> onNewFin(command);
            case SAVE -> onSave();
            case SAVE_AS -> onSaveAs();
            case LOAD -> onLoad();
        }

    }

    private void onLoad() {
        int ret = JOptionPane.showConfirmDialog(null, "Do you really want to load data from file? Unsaved changes will be discarded");
        if (ret != JOptionPane.YES_OPTION)
            return;

        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Fichiers Texte", "txt");
        fileChooser.setFileFilter(filter);
        fileChooser.setCurrentDirectory(new File("B:\\1-Etudes\\HEPL\\Java\\Projet-WEM\\"));

        int returnValue = fileChooser.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            if (!selectedFile.exists()) {
                JOptionPane.showMessageDialog(null, "Chosen file doesn't exist");
                return;
            }
            model.load(selectedFile.getAbsolutePath());
            TableModelBoard tableModelBoard = TableModelBoard.getInstance(null);
            tableModelBoard.setData(model.getBoards());
            TableModelSail tableModelSail = TableModelSail.getInstance(null);
            tableModelSail.setData(model.getSails());
            TableModelWishbone tableModelWishbone = TableModelWishbone.getInstance(null);
            tableModelWishbone.setData(model.getWishboons());
            TableModelMast tableModelMast = TableModelMast.getInstance(null);
            tableModelMast.setData(model.getMasts());
            TableModelFin tableModelFin = TableModelFin.getInstance(null);
            tableModelFin.setData(model.getFins());
            tableModelBoard.updateTable();
            tableModelSail.updateTable();
            tableModelWishbone.updateTable();
            tableModelMast.updateTable();
            tableModelFin.updateTable();
        }
    }

    private void onSave() {
        if (filename != null)
            model.save(filename);
        else
            onSaveAs();
    }

    private void onSaveAs() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Fichiers Texte", "txt");
        fileChooser.setFileFilter(filter);
        fileChooser.setCurrentDirectory(new File("B:\\1-Etudes\\HEPL\\Java\\Projet-WEM\\"));

        int returnValue = fileChooser.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            if (!selectedFile.getName().endsWith(".txt"))
                filename = selectedFile.getAbsolutePath() + ".txt";
            else
                filename = selectedFile.getAbsolutePath();
            model.save(filename);
        }
    }

    private void onNewBoard(String command) {
        JDialogAddBoard dialog = new JDialogAddBoard();
        dialog.setVisible(true);
        if (dialog.submited()) {
            model.addBoard(dialog.getNewBoard());
            TableModelBoard tableModelBoard = TableModelBoard.getInstance(null);
            tableModelBoard.updateTable();
        }
        dialog.dispose();
    }

    private void onNewSail(String command) {
        JDialogAddSail dialog = new JDialogAddSail();
        dialog.setVisible(true);
        if (dialog.submited()) {
            model.addSail(dialog.getNewSail());
            TableModelSail tableModelSail = TableModelSail.getInstance(null);
            tableModelSail.updateTable();
        }
        dialog.dispose();
    }

    private void onNewWishbone(String command) {
        JDialogAddWishbone dialog = new JDialogAddWishbone();
        dialog.setVisible(true);
        if (dialog.submited()) {
            model.addWishboon(dialog.getNewWishbone());
            TableModelWishbone tableModelWishbone = TableModelWishbone.getInstance(null);
            tableModelWishbone.updateTable();
        }
        dialog.dispose();
    }

    private void onNewMast(String command) {
        JDialogAddMast dialog = new JDialogAddMast();
        dialog.setVisible(true);
        if (dialog.submited()) {
            model.addMast(dialog.getNewMast());
            TableModelMast tableModelMast = TableModelMast.getInstance(null);
            tableModelMast.updateTable();
        }
        dialog.dispose();
    }

    private void onNewFin(String command) {
        JDialogAddFin dialog = new JDialogAddFin();
        dialog.setVisible(true);
        if (dialog.submited()) {
            model.addFin(dialog.getNewFin());
            TableModelFin tableModelFin = TableModelFin.getInstance(null);
            tableModelFin.updateTable();
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
