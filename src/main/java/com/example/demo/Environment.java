package com.example.demo;

import java.util.LinkedList;
import java.util.List;

import com.example.demo.application.ICommand;
import com.example.demo.ui.ITextEditorUi;

public class Environment {
    private List<ICommand> history;
    private int cursor;

    private ITextEditorUi textEditorUi;

    public Environment(){
        this.history = new LinkedList<>();
        this.cursor = -1;
    }

    private void addCommand(ICommand command){
        if(cursor + 1 < history.size()){
            for(int i = cursor + 1; i < history.size(); i += 1){
                ICommand commandRemove = history.remove(i);
                System.out.println("Removing: " + commandRemove.toString());
            }
        }

        history.add(command);
        cursor += 1;
        System.out.println(command.toString());
    }

    public void handleKeyPress(Character character){
        ICommand command = Factory.createAddCharacterCommand(textEditorUi.getTextField(), character);
        command.execute();
        addCommand(command);
    }

    public void handleUndo(){
        if(cursor >= 0){
            ICommand command = history.get(cursor);
            command.undo();
            System.out.println("Undo: " + command.toString());
            
            cursor -= 1;
        }else{
            System.out.println("No command to undo");
        }
    }

    public void handleRedo(){
        if(cursor + 1 < history.size()){
            cursor += 1;
            
            ICommand command = history.get(cursor);
            command.redo();
            System.out.println("Redo: " + command.toString());
        }else{
            System.out.println("No command to redo");
        }
    }

    public void setTextEditorUi(ITextEditorUi textEditorUi){
        this.textEditorUi = textEditorUi;
    }
}
