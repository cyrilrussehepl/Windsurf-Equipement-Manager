package GUI;

import Windsurf.Wishbone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JDialogAddWishbone extends JDialog{
    private JPanel mainPanel;
    private JButton buttonAdd;
    private JComboBox comboBoxYear;
    private JButton buttonCancel;
    private JTextField textFieldBrand;
    private JLabel labelBrand;
    private JLabel labelMinSize;
    private JLabel labelMaxSize;
    private JSpinner spinnerMinSize;
    private JSpinner spinnerMaxSize;
    private JLabel labelYear;
    private JLabel labelTitle;
    private JPanel panelForm;
    private boolean submit;
    private Wishbone wishbone;

    public JDialogAddWishbone()
    {
        super();
        setModal(true);
        setContentPane(mainPanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("New Wishbone");
        pack();
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screen.width - this.getSize().width)/2,(screen.height - this.getSize().height)/2);

        submit = false;

        //combobox add items
        commonLayout.addYearItem(comboBoxYear);

        spinnerMinSize.setModel(new SpinnerNumberModel(160, 100, 250, 10));
        spinnerMaxSize.setModel(new SpinnerNumberModel(200, 100, 250, 10));

        //Action listeners
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        /*buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                submit = true;
                setVisible(false);
            }
        });*/
    }

    //Static Methods----------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        JDialogAddSail dialog = new JDialogAddSail();
        dialog.setVisible(true);
        dialog.dispose();
    }
}
