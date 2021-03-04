package com.dayanE6.multithreaded;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.*;


public class Multithreaded extends JFrame {

    JPanel masterPanel;
    FormPanel formPanel;
    ButtonPanel buttonPanel;

    public Multithreaded(){

        String[] fieldNames = {"Enter n","Factorial","Sequence"};
        String[] buttonNames = {"Calculate","Exit"};
        masterPanel = new JPanel();

        ArrayList<JPanel> panelsInOrder = new ArrayList<>();
        formPanel = new FormPanel(fieldNames);
        buttonPanel = new ButtonPanel(buttonNames);
        panelsInOrder.add(formPanel);
        panelsInOrder.add(buttonPanel);

        //masterPanel = loadMasterPanel(panelsInOrder);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,1));
        for (JPanel p: panelsInOrder){
            panel.add(p);
        }
        panel.setBorder(new EmptyBorder(10,10,10,10));

        this.add(panel);
        //this.add(masterPanel);
        loadFrame("Multithreaded");
    }

    JPanel loadMasterPanel(ArrayList<JPanel> panelList){

        JPanel panel = new JPanel();
        this.setLayout(new GridLayout(3,1));

        for (JPanel p: panelList){
            panel.add(p);
        }


        //panel.add(panelList.get(0));
        //panel.add(panelList.get(1));
        return panel;
    }

    void loadFrame(String name){

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

        Multithreaded multithreaded = new Multithreaded();

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

        this.setBackground(Color.orange);
        this.setLayout(new GridLayout(1, buttonNames.length));

        for(int i = 0; i < buttonNames.length; i++){
            JButton button = new JButton(buttonNames[i]);
            button.setMargin(new Insets(10,10,10,10));

            buttonsMap.put(buttonNames[i], button);
            this.add(buttonsMap.get(buttonNames[i]));
            System.out.println(buttonNames[i] + " added.");
        }
    }
}