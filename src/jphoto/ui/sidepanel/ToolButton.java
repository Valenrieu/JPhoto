package jphoto.ui.sidepanel;

import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

import jphoto.MainPanel;
import jphoto.ui.VButton;

public abstract class ToolButton extends VButton {
    protected boolean isPressed = false;
    protected MainPanel mainPanel;

    ToolButton(ImageIcon icon, MainPanel mainPanel) {
        super(icon);
        this.mainPanel = mainPanel;
    }

    public boolean isPressed() {
        return isPressed;
    }

    public void actionPerformed(ActionEvent e) {
        isPressed = !isPressed;

        // On enleve les autre boutons presses

        if(isPressed) {
            for(ToolButton button : mainPanel.getSidePanel().getButtons()) {
                if(button.isPressed && button!=this) {
                    button.isPressed = false;
                }
            }
        }
    }
}
