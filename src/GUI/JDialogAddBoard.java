package GUI;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JDialogAddBoard extends JDialog {
    //Variables
    private boolean submit;
    private JPanel mainPanel;
    protected JComboBox comboBoxYear;
    private JTextField textFieldModel;
    private JButton buttonAdd;
    private JLabel Title;
    private JPanel panelForm;
    private JLabel labelYear;
    private JLabel labelModel;
    private JTextField textFieldBrand;
    private JLabel labelBrand;
    private JLabel labelDiscipline;
    private JComboBox comboBoxDiscipline;
    private JLabel labelVolume;
    private JLabel labelWidth;
    private JCheckBox foilCheckBox;
    private JButton buttonCancel;
    private JComboBox comboBoxBoxType;
    private JLabel labelBoxType;
    private JSpinner spinnerVolume;
    private JSpinner spinnerWidth;

    //Constructor-------------------------------------------------------------------------------------------------------
    public JDialogAddBoard()
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

        //comboboxYear add item
        commonLayout.addYearItem(comboBoxYear);
        commonLayout.addDisciplineItem(comboBoxDiscipline);
        commonLayout.addBoxTypeItem(comboBoxBoxType);

        spinnerVolume.setModel(new SpinnerNumberModel(100, 0, 200, 1));
        spinnerWidth.setModel(new SpinnerNumberModel(80, 0, 150, 1));

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
        JDialogAddBoard dialog = new JDialogAddBoard();
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
