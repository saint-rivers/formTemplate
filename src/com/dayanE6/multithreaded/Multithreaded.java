package com.dayanE6.multithreaded;

/*
1. find the factorial of n
2. find the sum of 1 to n
 */

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


public class Multithreaded extends JFrame {

    MasterPanel panel;

    public Multithreaded(){

        panel = new MasterPanel();

        panel.setLayout(new GridLayout(5,2));
        this.setTitle("Multithreaded");
        this.setSize(400,300);

        this.add(panel);
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

class MasterPanel extends JPanel{

    private final JTextField inputTxt = new JTextField();
    private final JTextField factorialTxt = new JTextField();
    private final JTextField sequenceTxt = new JTextField();
    private final JButton calculateBtn = new JButton("Calculate");

    MasterPanel(){

        factorialTxt.setEditable(false);
        sequenceTxt.setEditable(false);

        this.add(new JLabel("Enter n: "));
        this.add(inputTxt);
        this.add(new JLabel("Factorial: "));
        this.add(factorialTxt);
        this.add(new JLabel("Sum of sequence: "));
        this.add(sequenceTxt);

        this.add(calculateBtn);
        this.setBorder(new EmptyBorder(10,10,10,10));
    }
}