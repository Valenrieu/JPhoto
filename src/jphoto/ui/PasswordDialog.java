package jphoto.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

public class PasswordDialog {
    private JPanel panel = new JPanel();
    private JLabel text = new JLabel("Mot de passe :");
    private JPasswordField passwordField = new JPasswordField(15);
    private static final String[] options = new String[] {"Valider", "Annuler"};

    public PasswordDialog() {
        panel.add(text);
        panel.add(passwordField);
    }

    public String getPassword() {
        int option = JOptionPane.showOptionDialog(null, panel, "Choix du mot de passe",
                     JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                     null, options, options[0]);

        if(option==0) {
            return String.valueOf(passwordField.getPassword());
        }

        return null;
    }
}
