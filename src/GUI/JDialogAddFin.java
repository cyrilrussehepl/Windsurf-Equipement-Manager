package GUI;

import Windsurf.Fin;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JDialogAddFin extends JDialog {
    //Variables
    private boolean submit;
    private JPanel mainPanel;
    private JButton buttonAdd;
    private JPanel panelForm;
    private JComboBox comboBoxYear;
    private JTextField textFieldBrand;
    private JComboBox comboBoxBoxType;
    private JCheckBox antiAlgaeCheckBox;
    private JButton buttonCancel;
    private JSpinner spinnerSize;
    private Fin newFin;

    //Constructor-------------------------------------------------------------------------------------------------------
    public JDialogAddFin()
    {
        super();
        setModal(true);
        setContentPane(mainPanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("New Fin");
        pack();
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screen.width - this.getSize().width)/2,(screen.height - this.getSize().height)/2);

        submit = false;

        //combobox add items
        CommonLayout.addYearItem(comboBoxYear);
        CommonLayout.addBoxTypeItem(comboBoxBoxType);
        spinnerSize.setModel(new SpinnerNumberModel(30, 0, 100, 1));

        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newFin = new Fin(CommonLayout.yearIndexToDate(comboBoxYear.getSelectedIndex()),
                        textFieldBrand.getText());
                newFin.setSize(((Integer)spinnerSize.getValue()).intValue());
                newFin.setBox_type(Fin.BoxType.values()[comboBoxBoxType.getSelectedIndex()]);
                newFin.setAnti_algae(antiAlgaeCheckBox.isSelected());
                submit = true;
                setVisible(false);
            }
        });
    }

    public boolean submited(){
        return submit;
    }

    public Fin getNewFin(){return newFin;}

    //Static Methods----------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        JDialogAddFin dialog = new JDialogAddFin();
        dialog.setVisible(true);
        dialog.dispose();
    }
}
