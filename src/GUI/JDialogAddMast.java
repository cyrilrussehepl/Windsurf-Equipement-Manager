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
    private JComboBox comboBoxCurveType;
    private JLabel labelBrand;
    private JLabel labelLength;
    private JLabel labelCurveType;
    private JLabel LabelCarbonPercent;
    private JCheckBox checkBoxRDM;
    private JSpinner spinnerCarbonPercent;
    private JSpinner spinnerLength;

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

        //combobox Setup
        CommonLayout.addYearItem(comboBoxYear);
        CommonLayout.addMastCurveItem(comboBoxCurveType);

        spinnerCarbonPercent.setModel(new SpinnerNumberModel(100, 0, 100, 1));
        spinnerLength.setModel(new SpinnerNumberModel(400, 300, 600, 10));

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
        JDialogAddMast dialog = new JDialogAddMast();
        dialog.setVisible(true);
        dialog.dispose();
    }
}
