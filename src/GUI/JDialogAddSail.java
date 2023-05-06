package GUI;

import Windsurf.Equipement;
import Windsurf.Mast;
import Windsurf.Sail;

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
    private JLabel labelLuff;
    private JLabel labelBoom;
    private JLabel labelMastCurve;
    private JLabel labelNbrCamber;
    private JSpinner spinnerLuff;
    private JSpinner spinnerBoom;
    private JCheckBox checkBoxFoil;
    private Sail newSail;

    public JDialogAddSail() {
        super();
        setModal(true);
        setContentPane(mainPanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("New Sail");
        pack();
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screen.width - this.getSize().width) / 2, (screen.height - this.getSize().height) / 2);

        submit = false;

        //combobox add items
        CommonLayout.addYearItem(comboBoxYear);
        CommonLayout.addCategoryItem(comboBoxCategory);
        CommonLayout.addDisciplineItem(comboBoxDiscipline);
        CommonLayout.addMastCurveItem(comboBoxMastCurve);
        CommonLayout.addNCamberItem(comboBoxNbrCamber);
        spinnerLuff.setModel(new SpinnerNumberModel(400, 300, 550, 10));
        spinnerBoom.setModel(new SpinnerNumberModel(180, 150, 250, 10));


        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newSail = new Sail(CommonLayout.yearIndexToDate(comboBoxYear.getSelectedIndex()),
                        textFieldBrand.getText(),
                        checkBoxFoil.isSelected() ? Equipement.Category.FOIL : Equipement.Category.PLANCHE,
                        Equipement.Discipline.values()[comboBoxDiscipline.getSelectedIndex()]);
                try {
                    newSail.setArea(Float.parseFloat(textFieldArea.getText()));
                } catch (NumberFormatException ex) {
                    textFieldArea.setBackground(Color.RED);
                    JOptionPane.showMessageDialog(null, "Invalid area parameter!");
                    textFieldArea.setText("");
                    return;
                }
                newSail.setModel(textFieldModel.getText());
                newSail.setLuff(((Integer) spinnerLuff.getValue()).intValue());
                newSail.setBoom(((Integer) spinnerBoom.getValue()).intValue());
                newSail.setMastCurve(Mast.Curve.values()[comboBoxMastCurve.getSelectedIndex()]);
                newSail.setnCamber(comboBoxNbrCamber.getSelectedIndex());

                submit = true;
                setVisible(false);
            }
        });
    }

    //Static Methods----------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        JDialogAddSail dialog = new JDialogAddSail();
        dialog.setVisible(true);
        dialog.dispose();
    }

    public Sail getNewSail() {
        return newSail;
    }

    public boolean submited() {
        return submit;
    }
}
