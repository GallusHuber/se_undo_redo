package com.example.demo.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.example.demo.Environment;
import com.example.demo.command.ICommand;

public class TextEditorUi implements ITextEditorUi {
    private Environment environment;

    private JFrame frame;
    private TextField textField;
    private DefaultListModel<String> historyListModel;

    private TextEditorUi(Environment environment) {
        this.environment = environment;

        this.frame = new JFrame();
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        frame.add(initTextField(), BorderLayout.NORTH);
        frame.add(initHistoryViewer(), BorderLayout.CENTER);
        frame.add(initButtons(), BorderLayout.SOUTH);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static ITextEditorUi create(Environment environment) {
        return new TextEditorUi(environment);
    }

    public ITextField getTextField() {
        return textField;
    }

    private JTextField initTextField() {
        this.textField = new TextField();
        textField.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                TextEditorUi.this.updateHistoryList();
            }

            public void removeUpdate(DocumentEvent e) {
                TextEditorUi.this.updateHistoryList();
            }

            public void insertUpdate(DocumentEvent e) {
                TextEditorUi.this.updateHistoryList();
            }
        });

        return textField;
    }

    private JPanel initButtons() {
        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new BorderLayout());

        JPanel panelABC = new JPanel();
        JButton buttonA = new JButton("A");
        buttonA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                environment.handleKeyPress(TextEditorUi.this.textField, 'A');

            }
        });
        panelABC.add(buttonA);

        JButton buttonB = new JButton("B");
        buttonB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                environment.handleKeyPress(TextEditorUi.this.textField, 'B');

            }
        });
        panelABC.add(buttonB);

        panelButtons.add(panelABC, BorderLayout.NORTH);

        JPanel panelUndoRedo = new JPanel();
        JButton buttonUndo = new JButton("Undo");
        buttonUndo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                environment.handleUndo();

            }
        });
        panelUndoRedo.add(buttonUndo);

        JButton buttonRedo = new JButton("Redo");
        buttonRedo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                environment.handleRedo();

            }
        });
        panelUndoRedo.add(buttonRedo);
        panelButtons.add(panelUndoRedo, BorderLayout.SOUTH);

        return panelButtons;
    }

    @SuppressWarnings("rawtypes")
    private JList initHistoryViewer() {
        this.historyListModel = new DefaultListModel<>();
        JList<String> historyList = new JList<>(historyListModel);

        historyList.setCellRenderer(new DefaultListCellRenderer() {

            @Override
            public Component getListCellRendererComponent(JList list,
                    Object value, int index, boolean isSelected,
                    boolean cellHasFocus) {

                super.getListCellRendererComponent(list, value, index,
                        isSelected, cellHasFocus);

                if (index == environment.getCursor()){
                    setBackground(Color.LIGHT_GRAY);
                }

                return this;
            }
        });
        return historyList;
    }

    private void updateHistoryList(){
        List<ICommand> history = environment.getHistory();

        historyListModel.removeAllElements();

        for(ICommand command : history){
            historyListModel.addElement(command.toString());
        }
    }

}
