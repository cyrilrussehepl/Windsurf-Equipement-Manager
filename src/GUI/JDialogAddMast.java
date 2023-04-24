package GUI;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JDialogAddMast extends JDialog{
    private boolean submit;
    private JPanel mainPanel;
    private JButton buttonAdd;
    private JButton buttonCancel;
    private JLabel labelTitle;
    private JPanel panelForm;
    private JLabel labelYear;
    private JTextField textFieldBrand;
    private JComboBox comboBoxYear;
    private JTextField textFieldCarbonPercent;
    private JComboBox comboBoxCurveType;
    private JTextField textFieldSize;
    private JLabel labelBrand;
    private JLabel labelSize;
    private JLabel labelCurveType;
    private JLabel LabelCarbonPercent;

    public JDialogAddMast()
    {
        super();
        setModal(true);
        setContentPane(mainPanel);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("New Board");
        pack();
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screen.width - this.getSize().width)/2,(screen.height - this.getSize().height)/2);

        submit = false;
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*try
                {
                    a = Double.parseDouble(textFieldA.getText());
                }
                catch(NumberFormatException ex)
                {
                    textFieldA.setBackground(Color.ORANGE);
                    JOptionPane.showMessageDialog(null,"Paramètre a invalide !","Erreur !!!",JOptionPane.ERROR_MESSAGE);
                    textFieldA.setBackground(Color.WHITE);
                    textFieldA.setText("");
                    return;
                }
                try
                {
                    b = Double.parseDouble(textFieldB.getText());
                }
                catch(NumberFormatException ex)
                {
                    textFieldB.setBackground(Color.ORANGE);
                    JOptionPane.showMessageDialog(null,"Paramètre b invalide !","Erreur !!!",JOptionPane.ERROR_MESSAGE);
                    textFieldB.setBackground(Color.WHITE);
                    textFieldB.setText("");
                    return;
                }
                try
                {
                    c = Double.parseDouble(textFieldC.getText());
                }
                catch(NumberFormatException ex)
                {
                    textFieldC.setBackground(Color.ORANGE);
                    JOptionPane.showMessageDialog(null,"Paramètre c invalide !","Erreur !!!",JOptionPane.ERROR_MESSAGE);
                    textFieldC.setBackground(Color.WHITE);
                    textFieldC.setText("");
                    return;
                }*/
                submit = true;
                setVisible(false);
            }
        });
    }

    //Static Methods----------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        JDialogAddMast dialog = new JDialogAddMast();
        dialog.setVisible(true);
        /*if (dialog.isOk())
        {
            System.out.println("a = " + dialog.getA());
            System.out.println("b = " + dialog.getB());
            System.out.println("c = " + dialog.getC());
        }*/
        dialog.dispose();
    }
}
