package generator;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

public class UserForm {
    private JTextField loginField;
    private JLabel label1;
    private JButton buttontoStartGenerate;
    private JTextField urlField;
    private JLabel label2;
    private JPanel mainPanel;
    private JTextField outputPassword;
    private JLabel label3;
    private JTextField passLenghtField;
    private JButton bufferPassword;
    private JButton pathChangerButton;
    private JTextField pathOutputField;
    private String pathToSave = "";

    public JPanel getMainPanel(){return mainPanel;}

        public UserForm(){
        buttontoStartGenerate.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                        PasswordGenerator passwordGenerator = new PasswordGenerator();
                        int lenght = Integer.parseInt(passLenghtField.getText());
                        String outputPass = passwordGenerator.generate(lenght);
                        outputPassword.setText(outputPass);
                        passwordGenerator.saveToCsv(urlField.getText(),loginField
                                .getText(),outputPass,pathOutputField.getText());
            }
        });
        bufferPassword.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                StringSelection stringSelection = new StringSelection(outputPassword.getText());
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, null);
                JOptionPane.showMessageDialog(null, "Текст скопирован в буфер обмена.");
            }
        });
        pathChangerButton.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Выберите путь для сохранения");
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    pathToSave = selectedFile.getAbsolutePath();
                    pathOutputField.setText(pathToSave);
                }

            }
        });
        }
}
