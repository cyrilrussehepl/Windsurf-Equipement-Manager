package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import javax.swing.*;
import java.awt.event.*;

public class Controller extends WindowAdapter implements ActionListener {
    public final static String QUITTER = "Quitter";
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(QUITTER))
            onQuitter();
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
