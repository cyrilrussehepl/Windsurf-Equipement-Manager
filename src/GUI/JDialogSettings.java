package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JDialogSettings extends JDialog{
    private JTextField textFieldSaveFilename;
    private JCheckBox checkboxTheme;
    private JButton buttonSave;
    private JButton buttonCancel;
    private JPanel mainPanel;
    private boolean submit;
    private boolean darkTheme;
    private String filename;

    public JDialogSettings()
    {
        super();
        setModal(true);
        setContentPane(mainPanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Settings");
        pack();
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screen.width - this.getSize().width)/2,(screen.height - this.getSize().height)/2);

        submit = false;

        //Action listeners
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filename = textFieldSaveFilename.getText();
                darkTheme = checkboxTheme.isSelected();
                submit = true;
                setVisible(false);
            }
        });
    }

    public boolean isDarkTheme() {
        return darkTheme;
    }

    public boolean submited() {
        return submit;
    }

    public String getFilename() {
        return filename;
    }

    //Static Methods----------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        JDialogSettings dialog = new JDialogSettings();
        dialog.setVisible(true);
        dialog.dispose();
    }
}
