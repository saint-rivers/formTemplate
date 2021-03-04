package com.dayanE6.multithreaded;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.*;


public class Multithreaded extends JFrame {

    public JPanel masterPanel;
    public Multithreaded(String name){

        String[] fieldNames = {"Enter n","Factorial","Sequence"};
        String[] buttonNames = {"Calculate","Exit"};

        ArrayList<JPanel> panelsInOrder = new ArrayList<>();
        panelsInOrder.add(new FormPanel(fieldNames));
        panelsInOrder.add(new ButtonPanel(buttonNames));

        masterPanel = new JPanel();
        masterPanel = loadMasterPanel(panelsInOrder);
        this.add(masterPanel);
        initializeFrame(name);
    }

    JPanel loadMasterPanel(ArrayList<JPanel> panelList){

        masterPanel.setLayout(new GridLayout(2,1));
        masterPanel.setBorder(new EmptyBorder(10,10,10,10));
        for (JPanel p: panelList){
            masterPanel.add(p);
        }
        return masterPanel;
    }

    void initializeFrame(String name){

        this.setTitle(name);
        this.setSize(400,300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        int n = 5;
        Counters.FactorialCounter factorial = new Counters.FactorialCounter(n);
        Counters.SumOfSequence sequence = new Counters.SumOfSequence(n);

        Multithreaded multithreaded = new Multithreaded("default name");

        new Thread(factorial).start();
        new Thread(sequence).start();
    }
}

class FormPanel extends JPanel{

    public Map<String, JTextField> fieldNameDictionary = new HashMap<>();

    public FormPanel(String[] textFieldNames){

        this.setLayout(new GridLayout(textFieldNames.length, 2, 5, 5));
        addLabelsAndFields(textFieldNames);
        this.setBorder(new EmptyBorder(10,10,10,10));
    }

    void addLabelsAndFields(String[] textFieldNames){
        for(int i = 0; i < textFieldNames.length; i++){

            fieldNameDictionary.put(textFieldNames[i], new JTextField()); // add name and text field to map
            this.add(new JLabel(textFieldNames[i])); // add name as label to form
            this.add(fieldNameDictionary.get(textFieldNames[i])); // add text field to form
        }
    }
}

class ButtonPanel extends JPanel{

    public Map<String, JButton> buttonsMap = new HashMap<>();

    public ButtonPanel(String[] buttonNames){

        this.setLayout(new GridLayout(1, buttonNames.length,20,20));
        this.setBorder(new EmptyBorder(30,10,30,10));

        for(int i = 0; i < buttonNames.length; i++){
            JButton button = new JButton(buttonNames[i]);
            buttonsMap.put(buttonNames[i], button);
            this.add(buttonsMap.get(buttonNames[i]));
            System.out.println(buttonNames[i] + " added.");
        }
    }
}