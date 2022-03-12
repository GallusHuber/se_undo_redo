package com.example.demo.command;

public interface ICommand {
    void execute();
    void undo();
    void redo();
}
