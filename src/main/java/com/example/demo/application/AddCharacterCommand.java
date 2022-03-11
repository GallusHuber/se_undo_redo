package com.example.demo.application;

import java.util.List;

import com.example.demo.exceptions.WrongArgumentException;
import com.example.demo.ui.ITextEditorUi;

public class AddCharacterCommand extends Command {

    private AddCharacterCommand(ITextEditorUi textEditorUi) {
        super(textEditorUi);
    }

    public static ICommand create(List<Object> arguments) throws WrongArgumentException{
        if(arguments.isEmpty()){
            return new AddCharacterCommand((ITextEditorUi) arguments.get(0));
        } throw new WrongArgumentException();
    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void undo() {
        // TODO Auto-generated method stub
        
    }
    
}
