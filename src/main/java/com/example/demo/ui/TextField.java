package com.example.demo.ui;

import javax.swing.JTextField;

public class TextField extends JTextField implements ITextField{

    @Override
    public void addCharacter(Character character) {
        setText(new StringBuilder(getText()).append(character).toString());
        
    }

    @Override
    public void removeCharacter() {
        setText(new StringBuilder(getText()).deleteCharAt(getText().length() - 1).toString());
        
    }
}
