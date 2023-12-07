package jphoto.ui.file;

import javax.swing.JOptionPane;
import javax.swing.JDialog;
import java.awt.Dialog;

public class FileOrFolderNotFoundDialog extends JOptionPane {
    private JDialog frame;

    public FileOrFolderNotFoundDialog(String name) {
        this.setFrame(name);
    }

    private void setFrame(String name) {
        frame = new JDialog();
        frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        this.showMessageDialog(frame, name+" a été supprimé");
        frame.pack();
        frame.setResizable(false);
        frame.setModal(true);
        frame.setAlwaysOnTop(true);
        frame.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        frame.setVisible(true);
    }
}
