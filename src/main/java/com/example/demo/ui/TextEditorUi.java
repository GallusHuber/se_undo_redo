package com.example.demo.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import com.example.demo.Environment;

public class TextEditorUi extends JFrame implements ITextEditorUi {
    private Environment environment;
    private TextField textField;

    private TextEditorUi(Environment environment) {
        this.environment = environment;
        
        setSize(400, 400); 
        setLayout(new BorderLayout());

        initTextField();
        initButtons();
       
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static ITextEditorUi create(Environment environment) {
        return new TextEditorUi(environment);
    }

    public ITextField getTextField(){
        return textField;
    }

    private void initTextField(){
        this.textField = new TextField();
        add(this.textField, BorderLayout.NORTH);
    }

    private void initButtons(){
        JPanel panelABC = new JPanel();
        JButton buttonA = new JButton("A");
        buttonA.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                environment.handleKeyPress('A');
                
            }
        });
        panelABC.add(buttonA);

        JButton buttonB = new JButton("B");
        buttonB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                environment.handleKeyPress('B');
                
            }
        });
        panelABC.add(buttonB);

        add(panelABC, BorderLayout.CENTER);

        JPanel panelUndoRedo = new JPanel();
        JButton buttonUndo = new JButton("Undo");
        buttonUndo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                environment.handleUndo();
                
            }
        });
        panelUndoRedo.add(buttonUndo);

        JButton buttonRedo = new JButton("Redo");
        buttonRedo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                environment.handleRedo();
                
            }
        });
        panelUndoRedo.add(buttonRedo);
        add(panelUndoRedo, BorderLayout.SOUTH);
    }
}
