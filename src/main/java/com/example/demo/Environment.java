package com.example.demo;

import java.util.LinkedList;
import java.util.List;

import com.example.demo.command.ICommand;
import com.example.demo.ui.ITextField;

public class Environment {
    private List<ICommand> history;
    private int cursor;

    public Environment(){
        this.history = new LinkedList<>();
        this.cursor = -1;
    }

    public void handleKeyPress(ITextField textField, Character character){
        ICommand command = Factory.createAddCharacterCommand(textField, character);
        addCommand(command);
        command.execute();
    }

    public void handleUndo(){
        if(cursor >= 0){
            ICommand command = history.get(cursor);
            command.undo();
            
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
        }else{
            System.out.println("No command to redo");
        }
    }

    private void addCommand(ICommand command){
        if(cursor + 1 < history.size()){
            history = history.subList(0, cursor + 1);
        }

        history.add(command);
        cursor += 1;
    }

    public List<ICommand> getHistory() {
        return history;
    }

    public int getCursor() {
        return cursor;
    }

}
