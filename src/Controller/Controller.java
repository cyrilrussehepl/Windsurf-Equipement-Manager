package Controller;

import GUI.*;
import Model.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.*;
import java.io.*;

import static java.lang.Boolean.getBoolean;

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
    private final static String LOAD_CSV = "Load from CSV";
    private final static String DELETE = "Delete";
    private final static String SETTINGS = "Settings";
    private final static String UPDATE = "Update";
    private final static String ADD = "Add";
    private static Controller instance;
    private static String filename;
    private Model model;
    private JFrameWEMConsole mainWindow;
    private static Settings settings;

    //Constructor private for singleton class---------------------------------------------------------------------------
    private Controller(JFrameWEMConsole mainWindow) {
        model = Model.getInstance();
        this.mainWindow = mainWindow;

        if(settings.getProperty("loadOnStartup").equals("true") && !settings.getProperty("directory").equals("") && new File(settings.getProperty("directory")).exists()){
            filename = settings.getProperty("directory");
            model.load(filename);
            this.mainWindow.loadNewData(model.getBoards(), model.getSails(), model.getWishboons(), model.getMasts(), model.getFins());
        }
        else
            filename = "";
    }

    public static Controller getInstance(JFrameWEMConsole mainWindow) {
        if (instance == null) {
            settings = new Settings();
            instance = new Controller(mainWindow);
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
            case LOAD_CSV -> onLoadCSV();
            case DELETE -> onDelete();
            case SETTINGS -> onSettings();
            case UPDATE -> onUpdate();
            case ADD -> onAdd();
        }
    }

    private void onLoadCSV() {
        model.loadCSV();
        mainWindow.loadNewData(model.getBoards(), model.getSails(), model.getWishboons(), model.getMasts(), model.getFins());
    }

    private void onAdd() {
        switch (mainWindow.getCurrentTableEquipmentType()){
            case BOARD -> onNewBoard();
            case SAIL -> onNewSail();
            case WISHBONE -> onNewWishbone();
            case MAST -> onNewMast();
            case FIN -> onNewFin();
        }
    }

    private void onSettings() {
        JDialogSettings dialog = new JDialogSettings(settings);
        dialog.setVisible(true);
        if (dialog.submited()) {
            settings.setProperty("directory", dialog.getFilename());
            settings.setProperty("loadOnStartup", dialog.isLoadOnStartup() ? "true" : "false");
        }
        dialog.dispose();
    }

    private void onDelete() {
        if (mainWindow.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "No selected lines to delete");
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
        if(filename=="")
            filename = settings.getProperty("directory");

        if (filename!=null && new File(filename).exists())
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
            return;
        }
        switch (mainWindow.getCurrentTableEquipmentType()) {
            case BOARD -> {
                JDialogAddBoard dialog = new JDialogAddBoard(model.getBoards().get(mainWindow.getSelectedRow()));
                dialog.setVisible(true);
                if (dialog.submited()) {
                    model.updateBoard(mainWindow.getSelectedRow(), dialog.getNewBoard());
                    mainWindow.refreshTable();
                }
                dialog.dispose();
            }
            case SAIL -> {
                JDialogAddSail dialog = new JDialogAddSail(model.getSails().get(mainWindow.getSelectedRow()));
                dialog.setVisible(true);
                if (dialog.submited()) {
                    model.updateSail(mainWindow.getSelectedRow(), dialog.getNewSail());
                    mainWindow.refreshTable();
                }
                dialog.dispose();
            }
            case WISHBONE -> {
                JDialogAddWishbone dialog = new JDialogAddWishbone(model.getWishboons().get(mainWindow.getSelectedRow()));
                dialog.setVisible(true);
                if (dialog.submited()) {
                    model.updateWishboon(mainWindow.getSelectedRow(), dialog.getNewWishbone());
                    mainWindow.refreshTable();
                }
                dialog.dispose();
            }
            case MAST -> {
                JDialogAddMast dialog = new JDialogAddMast(model.getMasts().get(mainWindow.getSelectedRow()));
                dialog.setVisible(true);
                if (dialog.submited()) {
                    model.updateMast(mainWindow.getSelectedRow(), dialog.getNewMast());
                    mainWindow.refreshTable();
                }
                dialog.dispose();
            }
            case FIN -> {
                JDialogAddFin dialog = new JDialogAddFin(model.getFins().get(mainWindow.getSelectedRow()));
                dialog.setVisible(true);
                if (dialog.submited()) {
                    model.updateFin(mainWindow.getSelectedRow(), dialog.getNewFin());
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
            mainWindow.refreshTable();
        }
        dialog.dispose();
    }

    private void onNewWishbone() {
        JDialogAddWishbone dialog = new JDialogAddWishbone();
        dialog.setVisible(true);
        if (dialog.submited()) {
            model.addWishboon(dialog.getNewWishbone());
            mainWindow.refreshTable();
        }
        dialog.dispose();
    }

    private void onNewMast() {
        JDialogAddMast dialog = new JDialogAddMast();
        dialog.setVisible(true);
        if (dialog.submited()) {
            model.addMast(dialog.getNewMast());
            mainWindow.refreshTable();
        }
        dialog.dispose();
    }

    private void onNewFin() {
        JDialogAddFin dialog = new JDialogAddFin();
        dialog.setVisible(true);
        if (dialog.submited()) {
            model.addFin(dialog.getNewFin());
            mainWindow.refreshTable();
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
