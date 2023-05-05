package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JDialogAddWishbone extends JDialog{
    private JPanel panel1;
    private JButton addButton;
    private JComboBox comboBox1;
    private JButton cancelButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private boolean submit;


    public JDialogAddWishbone()
    {
        super();
        setModal(true);
        setContentPane(panel1);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("New Sail");
        pack();
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screen.width - this.getSize().width)/2,(screen.height - this.getSize().height)/2);

        submit = false;
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
