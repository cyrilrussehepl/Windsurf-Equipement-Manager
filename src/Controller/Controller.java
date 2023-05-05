package Controller;

import GUI.JDialogAddBoard;
import Model.Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import javax.swing.*;
import java.awt.event.*;

public class Controller extends WindowAdapter implements ActionListener {
    //Variables---------------------------------------------------------------------------------------------------------
    public final static String QUITTER = "Quitter";
    private static Controller instance;
    private Model model;

    //Constructor private for singleton class---------------------------------------------------------------------------
    private Controller(){
        model = Model.getInstance();
    }

    public static Controller getInstance(){
        if(instance == null)
            instance = new Controller();
        return instance;
    }

    //Methods-----------------------------------------------------------------------------------------------------------
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(QUITTER))
            onQuitter();

        if (e.getActionCommand().equals("Board"))
            onNewBoard();
    }

    private void onNewBoard(){
        JDialogAddBoard dialog = new JDialogAddBoard();
        dialog.setVisible(true);

        if(dialog.submited()) {
            model.addBoard(dialog.getNewBoard());
            model.saveModel();
            dialog.dispose();
        }
        else
            dialog.dispose();
    }
    @Override
    public void windowClosing(WindowEvent e) {
        onQuitter();
    }

    private void onQuitter() {
        int ret = JOptionPane.showConfirmDialog(null,"Êtes-vous certain de vouloir quitter ?");
        if (ret == JOptionPane.YES_OPTION)
            System.exit(0);
    }
}
