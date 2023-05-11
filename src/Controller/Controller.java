package Controller;

import GUI.*;
import GUI.MyTableModels.*;
import Model.*;

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
    private final static String DELETE = "Delete";
    private final static String SETTINGS = "Settings";
    private final static String UPDATE = "Update";
    private static Controller instance;
    private static String filename;
    private Model model;
    private JFrameWEMConsole mainWindow;
    private static Settings settings;

    //Constructor private for singleton class---------------------------------------------------------------------------
    private Controller(JFrameWEMConsole mainWindow) {
        model = Model.getInstance();
        this.mainWindow = mainWindow;
    }

    public static Controller getInstance(JFrameWEMConsole mainWindow) {
        if (instance == null) {
            instance = new Controller(mainWindow);
            settings = new Settings();
        }
        return instance;
    }

    //Methods-----------------------------------------------------------------------------------------------------------
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case QUIT -> quit();
            case BOARD -> onNewBoard();
            case SAIL -> onNewSail();
            case WISHBONE -> onNewWishbone();
            case MAST -> onNewMast();
            case FIN -> onNewFin();
            case SAVE -> onSave();
            case SAVE_AS -> onSaveAs();
            case LOAD -> onLoad();
            case DELETE -> onDelete();
            case SETTINGS -> onSettings();
            case UPDATE -> onUpdate();
        }
    }

    private void onSettings() {
        JDialogSettings dialog = new JDialogSettings();
        dialog.setVisible(true);
        if (dialog.submited()) {
            settings.setProperty("directory", dialog.getFilename());
            settings.setProperty("theme", dialog.isDarkTheme() ? "dark" : "light");
        }
        dialog.dispose();
    }

    private void onDelete() {
        if (mainWindow.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Aucune ligne sélectionnée!");
            return;
        }
        switch (mainWindow.getCurrentTableEquipmentType()) {
            case BOARD -> model.removeBoard(mainWindow.getSelectedRow());
            case SAIL -> model.removeSail(mainWindow.getSelectedRow());
            case WISHBONE -> model.removeWishboon(mainWindow.getSelectedRow());
            case MAST -> model.removeMast(mainWindow.getSelectedRow());
            case FIN -> model.removeFin(mainWindow.getSelectedRow());
        }
        mainWindow.refreshTable();
    }

    private void onLoad() {
        int ret = JOptionPane.showConfirmDialog(null, "Do you really want to load data from file? Unsaved changes will be discarded");
        if (ret != JOptionPane.YES_OPTION)
            return;

        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Fichiers Texte", "txt");
        fileChooser.setFileFilter(filter);
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));

        int returnValue = fileChooser.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            if (!selectedFile.exists()) {
                JOptionPane.showMessageDialog(null, "Chosen file doesn't exist");
                return;
            }
            model.load(selectedFile.getAbsolutePath());
            mainWindow.loadNewData(model.getBoards(), model.getSails(), model.getWishboons(), model.getMasts(), model.getFins());
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
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));

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

    private void onUpdate() {
        if (mainWindow.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "No selected line to update");
        }
        switch (mainWindow.getCurrentTableEquipmentType()) {
            case BOARD -> {
                JDialogAddBoard dialog = new JDialogAddBoard();
                dialog.setVisible(true);
                if (dialog.submited()) {
                    model.updateBoard(mainWindow.getSelectedRow(), dialog.getNewBoard());
                    mainWindow.refreshTable();
                }
                dialog.dispose();
            }
        }
    }

    private void onNewBoard() {
        JDialogAddBoard dialog = new JDialogAddBoard();
        dialog.setVisible(true);
        if (dialog.submited()) {
            model.addBoard(dialog.getNewBoard());
            mainWindow.refreshTable();
        }
        dialog.dispose();
    }

    private void onNewSail() {
        JDialogAddSail dialog = new JDialogAddSail();
        dialog.setVisible(true);
        if (dialog.submited()) {
            model.addSail(dialog.getNewSail());
            mainWindow.updateTableData();
        }
        dialog.dispose();
    }

    private void onNewWishbone() {
        JDialogAddWishbone dialog = new JDialogAddWishbone();
        dialog.setVisible(true);
        if (dialog.submited()) {
            model.addWishboon(dialog.getNewWishbone());
            mainWindow.updateTableData();
        }
        dialog.dispose();
    }

    private void onNewMast() {
        JDialogAddMast dialog = new JDialogAddMast();
        dialog.setVisible(true);
        if (dialog.submited()) {
            model.addMast(dialog.getNewMast());
            mainWindow.updateTableData();
        }
        dialog.dispose();
    }

    private void onNewFin() {
        JDialogAddFin dialog = new JDialogAddFin();
        dialog.setVisible(true);
        if (dialog.submited()) {
            model.addFin(dialog.getNewFin());
            mainWindow.updateTableData();
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
