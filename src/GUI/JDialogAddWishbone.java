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
    private JSpinner spinnerMinSize;
    private JSpinner spinnerMaxSize;
    private JSpinner spinnerCarbon;
    private JPanel panelForm;
    private boolean submit;
    private Wishbone newWishbone;

    public JDialogAddWishbone(Wishbone wishboneToUpdate){
        this();
        textFieldBrand.setText(wishboneToUpdate.getBrand());
        spinnerMinSize.setValue(wishboneToUpdate.getSizeMin());
        spinnerMaxSize.setValue(wishboneToUpdate.getSizeMax());
        spinnerCarbon.setValue(wishboneToUpdate.getCarbonPercent());
    }

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
        CommonLayout.addYearItem(comboBoxYear);

        spinnerMinSize.setModel(new SpinnerNumberModel(160, 100, 250, 10));
        spinnerMaxSize.setModel(new SpinnerNumberModel(200, 100, 250, 10));
        spinnerCarbon.setModel(new SpinnerNumberModel(100, 0, 100, 5));

        //Action listeners
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newWishbone = new Wishbone(CommonLayout.yearIndexToDate(comboBoxYear.getSelectedIndex()),
                        textFieldBrand.getText());
                newWishbone.setSizeMin(((Integer)spinnerMinSize.getValue()).intValue());
                newWishbone.setSizeMax(((Integer)spinnerMaxSize.getValue()).intValue());
                newWishbone.setCarbonPercent(((Integer)spinnerCarbon.getValue()).intValue());
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

    public Wishbone getNewWishbone(){return newWishbone;}
    public boolean submited(){return submit;}
}
