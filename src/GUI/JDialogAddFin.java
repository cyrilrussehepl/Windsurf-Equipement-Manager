package GUI;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JDialogAddFin extends JDialog {
    //Variables
    private boolean submit;
    private JPanel mainPanel;
    private JLabel labelNewFin;
    private JButton buttonAdd;
    private JPanel panelForm;
    private JComboBox comboBoxYear;
    private JLabel labelYear;
    private JLabel labelBrand;
    private JTextField textFieldBrand;
    private JLabel label;
    private JTextField textFieldSize;
    private JLabel labelBoxType;
    private JComboBox comboBoxBoxType;
    private JCheckBox antiAlgaeCheckBox;
    private JButton buttonCancel;

    //Constructor-------------------------------------------------------------------------------------------------------
    public JDialogAddFin()
    {
        super();
        setModal(true);
        setContentPane(mainPanel);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("New Fin");
        pack();
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screen.width - this.getSize().width)/2,(screen.height - this.getSize().height)/2);

        submit = false;
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                submit = true;
                setVisible(false);
            }
        });
    }

    public boolean submited(){
        return submit;
    }

    //Static Methods----------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        JDialogAddFin dialog = new JDialogAddFin();
        dialog.setVisible(true);
        dialog.dispose();
    }
}
