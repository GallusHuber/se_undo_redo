package com.example.demo;

import java.util.List;

import com.example.demo.application.AddCharacterCommand;
import com.example.demo.application.ICommand;
import com.example.demo.exceptions.WrongArgumentException;
import com.example.demo.ui.ITextEditorUi;
import com.example.demo.ui.TextEditorUi;

public class Factory {
    
    public static ITextEditorUi getTextEditorUi(){
        return TextEditorUi.create();
    }

    public static ICommand createCommand(String command, List<Object> arguments) throws WrongArgumentException{
        switch(command){
            case "addCharacter": 
                return AddCharacterCommand.create(arguments);
        }

        return null;
    }
}
