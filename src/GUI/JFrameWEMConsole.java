package GUI;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;

public class JFrameWEMConsole extends JFrame {
    //Variables---------------------------------------------------------------------------------------------------------
    private JPanel mainPanel;
    private JButton buttonQuit;

    //Constructor-------------------------------------------------------------------------------------------------------
    public JFrameWEMConsole()
    {
        //Init window properties
        super();
        setContentPane(mainPanel);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("Windsurf Equipement Manager");

        //Define window size and init window position
        setSize(500,300);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screen.width - this.getSize().width)/2,(screen.height - this.getSize().height)/2);
    }

    //Methods-----------------------------------------------------------------------------------------------------------
    public void setController(Controller c){
        buttonQuit.addActionListener(c);
        this.addWindowListener(c);
    }
}
