package com.example.demo.application;

import com.example.demo.ui.ITextField;

public class AddCharacterCommand extends Command {

    private ITextField textField;
    private Character character;

    private AddCharacterCommand(ITextField textField, Character character) {
        this.textField = textField;
        this.character = character;
    }

    public static ICommand create(ITextField textField, Character character) {
        ICommand command =  new AddCharacterCommand(textField, character);
        return command;
    }

    @Override
    public void execute() {
        textField.addCharacter(character);
    }

    @Override
    public void undo() {
        textField.removeCharacter();

    }

    @Override
    public String toString() {
        return "AddCharacterCommand [character=" + character + "]";
    }
    
}
