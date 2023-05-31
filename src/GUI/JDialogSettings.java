package GUI;

import Model.Settings;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class JDialogSettings extends JDialog{
    private JCheckBox checkboxTheme;
    private JButton buttonSave;
    private JButton buttonCancel;
    private JPanel mainPanel;
    private JButton buttonFilename;
    private JLabel labelFilename;
    private boolean submit;
    private boolean darkTheme;
    private String filename;

    public JDialogSettings(Model.Settings settings)
    {
        super();
        setModal(true);
        setContentPane(mainPanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Settings");
        pack();
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screen.width - this.getSize().width)/2,(screen.height - this.getSize().height)/2);
        setSize(new Dimension(400, 250));

        submit = false;
        filename = settings.getProperty("directory");
        labelFilename.setText(filename);

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
//                filename = textFieldSaveFilename.getText();
                darkTheme = checkboxTheme.isSelected();
                submit = true;
                setVisible(false);
            }
        });
        buttonFilename.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Fichiers Texte", "txt");
                fileChooser.setFileFilter(filter);
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));

                int returnValue = fileChooser.showSaveDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    if (!selectedFile.getName().endsWith(".txt"))
                        filename = selectedFile.getAbsolutePath() + ".txt";
                    else
                        filename = selectedFile.getAbsolutePath();
                    labelFilename.setText(filename);
                }
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
        JDialogSettings dialog = new JDialogSettings(new Settings());
        dialog.setVisible(true);
        dialog.dispose();
    }
}
