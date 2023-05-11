package GUI;

import Windsurf.Board;
import Windsurf.Equipment;
import Windsurf.Fin;

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
    private JPanel panelForm;
    private JTextField textFieldBrand;
    private JComboBox comboBoxDiscipline;
    private JCheckBox foilCheckBox;
    private JButton buttonCancel;
    private JComboBox comboBoxBoxType;
    private JSpinner spinnerVolume;
    private JSpinner spinnerWidth;

    //local variables for saving inputs
    private int year;
    private String model;
    private String brand;
    private Equipment.Discipline discipline;
    private int volume;
    private int width;
    private Fin.BoxType boxType;
    private Equipment.Category category;
    private Board newBoard;

    //Constructor-------------------------------------------------------------------------------------------------------
    public JDialogAddBoard() {
        super();
        setModal(true);
        setContentPane(mainPanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("New Board");
        pack();
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screen.width - this.getSize().width) / 2, (screen.height - this.getSize().height) / 2);

        submit = false;

        //combobox add items
        CommonLayout.addYearItem(comboBoxYear);
        CommonLayout.addDisciplineItem(comboBoxDiscipline);
        CommonLayout.addBoxTypeItem(comboBoxBoxType);

        spinnerVolume.setModel(new SpinnerNumberModel(100, 0, 200, 1));
        spinnerWidth.setModel(new SpinnerNumberModel(80, 0, 150, 1));

        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                year = CommonLayout.yearIndexToDate(comboBoxYear.getSelectedIndex());
                model = textFieldModel.getText();
                brand = textFieldBrand.getText();
                discipline = Equipment.Discipline.values()[comboBoxDiscipline.getSelectedIndex()];
                volume = ((Integer) spinnerVolume.getValue()).intValue();
                width = ((Integer) spinnerWidth.getValue()).intValue();
                boxType = Fin.BoxType.values()[comboBoxBoxType.getSelectedIndex()];
                category = foilCheckBox.isSelected() ? Equipment.Category.FOIL : Equipment.Category.PLANCHE;

                newBoard = new Board(year, brand, category, volume, width, model);
                submit = true;
                setVisible(false);
            }
        });
    }

    //Getters and setters
    public boolean submited() {
        return submit;
    }


    //Static Methods----------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        JDialogAddBoard dialog = new JDialogAddBoard();
        dialog.setVisible(true);
        dialog.dispose();
    }

    public Board getNewBoard() {
        return newBoard;
    }
}
