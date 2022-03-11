package com.example.demo.application;

public interface ICommand {
    void execute();
    void undo();
    void redo();
}
