package GUI;

import Windsurf.Mast;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JDialogAddMast extends JDialog{
    private boolean submit;
    private JPanel mainPanel;
    private JButton buttonAdd;
    private JButton buttonCancel;
    private JPanel panelForm;
    private JTextField textFieldBrand;
    private JComboBox comboBoxYear;
    private JComboBox comboBoxCurveType;
    private JCheckBox checkBoxRDM;
    private JSpinner spinnerCarbonPercent;
    private JSpinner spinnerLength;
    private Mast newMast;

    public JDialogAddMast(Mast mastToUpdate){
        this();
        textFieldBrand.setText(mastToUpdate.getBrand());
        spinnerLength.setValue(mastToUpdate.getLength());
        spinnerCarbonPercent.setValue(mastToUpdate.getCarbonPercent());
        checkBoxRDM.setSelected(mastToUpdate.getGeometry()== Mast.Geometry.RDM);
    }

    public JDialogAddMast()
    {
        super();
        setModal(true);
        setContentPane(mainPanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("New Mast");
        pack();
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screen.width - this.getSize().width)/2,(screen.height - this.getSize().height)/2);

        //combobox Setup
        CommonLayout.addYearItem(comboBoxYear);
        CommonLayout.addMastCurveItem(comboBoxCurveType);

        spinnerCarbonPercent.setModel(new SpinnerNumberModel(100, 0, 100, 1));
        spinnerLength.setModel(new SpinnerNumberModel(400, 300, 600, 10));

        submit = false;

        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newMast = new Mast(CommonLayout.yearIndexToDate(comboBoxYear.getSelectedIndex()),
                        textFieldBrand.getText());
                newMast.setLength(((Integer) spinnerLength.getValue()).intValue());
                newMast.setCurve(Mast.Curve.values()[comboBoxCurveType.getSelectedIndex()]);
                newMast.setCarbonPercent(((Integer) spinnerCarbonPercent.getValue()).intValue());
                newMast.setGeometry(checkBoxRDM.isSelected()?Mast.Geometry.RDM:Mast.Geometry.SDM);
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

    public Mast getNewMast() {
        return newMast;
    }

    public boolean submited(){
        return submit;
    }
}
