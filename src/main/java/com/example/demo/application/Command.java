package com.example.demo.application;

import com.example.demo.ui.ITextEditorUi;

public abstract class Command implements ICommand{
    protected ITextEditorUi textEditorUi;

    protected Command(ITextEditorUi textEditorUi){
        this.textEditorUi = textEditorUi;
    }

    public void redo(){
        execute();
    }

}
