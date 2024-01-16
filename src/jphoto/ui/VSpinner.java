package jphoto.ui;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;

public abstract class VSpinner extends JSpinner implements ChangeListener {
    public VSpinner(SpinnerModel model) {
        super(model);
        this.addChangeListener(this);
    }

    public abstract void stateChanged(ChangeEvent e);
}
