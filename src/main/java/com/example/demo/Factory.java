package com.example.demo;

import com.example.demo.command.AddCharacterCommand;
import com.example.demo.command.ICommand;
import com.example.demo.ui.ITextEditorUi;
import com.example.demo.ui.ITextField;
import com.example.demo.ui.TextEditorUi;

public class Factory {
    private static Environment environment;

    public static Environment createEnvironment(){
        if (environment == null){
            environment = new Environment();
        }

        return environment;
    }

    public static ITextEditorUi createTextEditorUi(Environment environment) {
        return TextEditorUi.create(environment);
    }

    public static ICommand createAddCharacterCommand(ITextField textField, Character character) {
        return AddCharacterCommand.create(textField, character);
    }
}
