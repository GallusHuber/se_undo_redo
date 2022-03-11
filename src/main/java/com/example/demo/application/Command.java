package com.example.demo.application;

import com.example.demo.Environment;

public abstract class Command implements ICommand{
    protected Environment environment;
    
    public void redo(){
        execute();
    }

}
