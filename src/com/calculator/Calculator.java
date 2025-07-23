package com.calculator;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class Calculator implements ActionListener {

    JLabel displayLable;
    JButton sevenButton, acButton, persentageButton, backButton, divButton;
    JButton eightButton, nineButton, multButton, fiveButton, fourButton;
    JButton sixButton, subButton, oneButton, twoButton, threeButton, addButton;
    JButton twozeroButton, zeroButton, dotButton, equalButton;

    boolean isOperatorClicked = false;
    String oldValue, operator;

    public Calculator() {
        JFrame jf = new JFrame("Calculator");
        jf.setLayout(null);
        jf.setSize(450, 700);
        jf.setLocationRelativeTo(null); // Centers the window
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        displayLable = new JLabel();
        displayLable.setBounds(30, 40, 380, 50);
        displayLable.setBackground(Color.DARK_GRAY);
        displayLable.setOpaque(true);
        displayLable.setHorizontalAlignment(SwingConstants.RIGHT);
        displayLable.setForeground(Color.WHITE);
        jf.add(displayLable);

        acButton = new JButton("AC");
        acButton.setBounds(30, 120, 80, 80);
        acButton.addActionListener(this);
        jf.add(acButton);

        persentageButton = new JButton("%");
        persentageButton.setBounds(130, 120, 80, 80);
        persentageButton.addActionListener(this);
        jf.add(persentageButton);

        backButton = new JButton("Back");
        backButton.setBounds(230, 120, 80, 80);
        backButton.addActionListener(this);
        jf.add(backButton);

        divButton = new JButton("/");
        divButton.setBounds(330, 120, 80, 80);
        divButton.addActionListener(this);
        jf.add(divButton);

        sevenButton = new JButton("7");
        sevenButton.setBounds(30, 220, 80, 80);
        sevenButton.addActionListener(this);
        jf.add(sevenButton);

        eightButton = new JButton("8");
        eightButton.setBounds(130, 220, 80, 80);
        eightButton.addActionListener(this);
        jf.add(eightButton);

        nineButton = new JButton("9");
        nineButton.setBounds(230, 220, 80, 80);
        nineButton.addActionListener(this);
        jf.add(nineButton);

        multButton = new JButton("X");
        multButton.setBounds(330, 220, 80, 80);
        multButton.addActionListener(this);
        jf.add(multButton);

        fourButton = new JButton("4");
        fourButton.setBounds(30, 320, 80, 80);
        fourButton.addActionListener(this);
        jf.add(fourButton);

        fiveButton = new JButton("5");
        fiveButton.setBounds(130, 320, 80, 80);
        fiveButton.addActionListener(this);
        jf.add(fiveButton);

        sixButton = new JButton("6");
        sixButton.setBounds(230, 320, 80, 80);
        sixButton.addActionListener(this);
        jf.add(sixButton);

        subButton = new JButton("-");
        subButton.setBounds(330, 320, 80, 80);
        subButton.addActionListener(this);
        jf.add(subButton);

        oneButton = new JButton("1");
        oneButton.setBounds(30, 420, 80, 80);
        oneButton.addActionListener(this);
        jf.add(oneButton);

        twoButton = new JButton("2");
        twoButton.setBounds(130, 420, 80, 80);
        twoButton.addActionListener(this);
        jf.add(twoButton);

        threeButton = new JButton("3");
        threeButton.setBounds(230, 420, 80, 80);
        threeButton.addActionListener(this);
        jf.add(threeButton);

        addButton = new JButton("+");
        addButton.setBounds(330, 420, 80, 80);
        addButton.addActionListener(this);
        jf.add(addButton);

        twozeroButton = new JButton("00");
        twozeroButton.setBounds(30, 520, 80, 80);
        twozeroButton.addActionListener(this);
        jf.add(twozeroButton);

        zeroButton = new JButton("0");
        zeroButton.setBounds(130, 520, 80, 80);
        zeroButton.addActionListener(this);
        jf.add(zeroButton);

        dotButton = new JButton(".");
        dotButton.setBounds(230, 520, 80, 80);
        dotButton.addActionListener(this);
        jf.add(dotButton);

        equalButton = new JButton("=");
        equalButton.setBounds(330, 520, 80, 80);
        equalButton.addActionListener(this);
        jf.add(equalButton);

        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == acButton) {
            displayLable.setText("");
            oldValue = "";
            operator = "";
            isOperatorClicked = false;
        } else if (source == backButton) {
            String text = displayLable.getText();
            if (!text.isEmpty()) {
                displayLable.setText(text.substring(0, text.length() - 1));
            }
        } else if (source == persentageButton) {
            try {
                float value = Float.parseFloat(displayLable.getText());
                displayLable.setText((value / 100) + "");
            } catch (Exception ignored) {}
        } else if (source == equalButton) {
            try {
                float newValue = Float.parseFloat(displayLable.getText());
                float oldVal = Float.parseFloat(oldValue);
                float result = switch (operator) {
                    case "+" -> oldVal + newValue;
                    case "-" -> oldVal - newValue;
                    case "X" -> oldVal * newValue;
                    case "/" -> newValue != 0 ? oldVal / newValue : 0;
                    default -> newValue;
                };
                displayLable.setText(result + "");
                isOperatorClicked = false;
            } catch (Exception ignored) {}
        } else if (source == addButton || source == subButton || source == multButton || source == divButton) {
            isOperatorClicked = true;
            oldValue = displayLable.getText();
            operator = ((JButton) source).getText();
        } else {
            String buttonText = ((JButton) source).getText();
            if (isOperatorClicked) {
                displayLable.setText(buttonText);
                isOperatorClicked = false;
            } else {
                displayLable.setText(displayLable.getText() + buttonText);
            }
        }
    }
}