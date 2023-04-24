package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JDialogAddSail extends JDialog {
    private boolean submit;
    private JPanel mainPanel;
    private JButton buttonAdd;
    private JButton buttonCancel;
    private JLabel labelNewSail;
    private JPanel panelForm;
    private JComboBox comboBoxYear;
    private JLabel labelYear;
    private JComboBox comboBoxNbrCamber;
    private JComboBox comboBoxMastCurve;
    private JTextField textFieldWishboneSize;
    private JTextField textFieldMastSize;
    private JTextField textFieldModel;
    private JTextField textFieldArea;
    private JComboBox comboBoxDiscipline;
    private JComboBox comboBoxCategory;
    private JTextField textFieldBrand;
    private JLabel labelBrand;
    private JLabel labelCategory;
    private JLabel labelDiscipline;
    private JLabel labelArea;
    private JLabel labelModel;
    private JLabel labelMastSize;
    private JLabel labelWishboneSize;
    private JLabel labelMastCurve;
    private JLabel labelNbrCamber;


    public JDialogAddSail()
    {
        super();
        setModal(true);
        setContentPane(mainPanel);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("New Sail");
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

    //Static Methods----------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        JDialogAddSail dialog = new JDialogAddSail();
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
