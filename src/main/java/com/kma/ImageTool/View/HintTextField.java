package com.kma.ImageTool.View;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Social Glutton (c) 2014
 * Created by mhontar on 05.07.14.
 */
class HintTextField extends JTextField implements FocusListener {

    private final String hint;
    private boolean showingHint;

    public HintTextField(final String hint) {
        super(hint);
        this.hint = hint;
        this.showingHint = true;
        super.addFocusListener(this);
    }

    @Override
    public void focusGained(FocusEvent e) {
        if(this.getText().isEmpty()) {
            setText("");
            showingHint = false;
        }
    }
    @Override
    public void focusLost(FocusEvent e) {
        if(this.getText().isEmpty()) {
            super.setText(hint);
            showingHint = true;
        }
    }

    @Override
    public void setText(final String text){
        super.setText(text);
        if(!text.isEmpty()){
            showingHint = false;
        }
    }

    @Override
    public String getText() {
        return showingHint ? "" : super.getText();
    }

    public String getHint() {
        return hint;
    }

    public boolean isShowingHint() {
        return showingHint;
    }

    public void setShowingHint(boolean showingHint) {
        this.showingHint = showingHint;
    }


}

