package com.example.demo.command;

import com.example.demo.Environment;

public abstract class Command implements ICommand{
    protected Environment environment;
    
    public void redo(){
        execute();
    }

}
