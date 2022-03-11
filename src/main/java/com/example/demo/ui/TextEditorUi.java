package com.example.demo.ui;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TextEditorUi extends JFrame implements ITextEditorUi {
    private JTextArea textArea;

    private TextEditorUi() {
        initTextArea();
        add(this.textArea);

        setSize(400, 500);
        setVisible(true);
    }

    public static ITextEditorUi create() {
        return new TextEditorUi();
    }

    @Override
    public String getContent() {
        return textArea.getText();

    }

    @Override
    public void setContent(String content) {
        textArea.setText(content);
        
    }

    private void initTextArea(){
        this.textArea = new JTextArea();
        textArea.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void removeUpdate(DocumentEvent e) {
                
            }
    
            @Override
            public void insertUpdate(DocumentEvent e) {
                
            }
    
            @Override
            public void changedUpdate(DocumentEvent arg0) {
    
            }
        });
    }

    
}
