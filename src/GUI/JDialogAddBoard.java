package GUI;

import Windsurf.Board;
import Windsurf.Equipement;
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

    //local variables for saving inputs
    private int year;
    private String model;
    private String brand;
    private Equipement.Discipline discipline;
    private int volume;
    private int width;
    private Fin.BoxType boxType;
    private Equipement.Category category;
    private Board newBoard;
    //Constructor-------------------------------------------------------------------------------------------------------
    public JDialogAddBoard()
    {
        super();
        setModal(true);
        setContentPane(mainPanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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

        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                year = commonLayout.yearIndexToDate(comboBoxYear.getSelectedIndex());
                model = textFieldModel.getText();
                System.out.println(model);
                brand = textFieldBrand.getText();
                discipline = Equipement.Discipline.values()[comboBoxDiscipline.getSelectedIndex()];
                volume = ((Integer)spinnerVolume.getValue()).intValue();
                width = ((Integer)spinnerWidth.getValue()).intValue();
                boxType = Fin.BoxType.values()[comboBoxBoxType.getSelectedIndex()];
                category = foilCheckBox.isSelected()? Equipement.Category.FOIL: Equipement.Category.PLANCHE;

                newBoard = new Board(year, brand, category, volume, width, model);
                submit = true;
                setVisible(false);
            }
        });
    }

    //Getters and setters
    public boolean submited(){
        return submit;
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

    public Board getNewBoard() {
        return newBoard;
    }
}
