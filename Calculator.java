package com.company;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator implements ActionListener {


    private JFrame window;
    private JPanel mainPanel, inputPanel, outputPanel, buttonPanel;
    private JButton jbtnAdd, jbtnSubtract, jbtnMultiply, jbtnRealDivide,jbtnMemory, jbtnReset, jbtnExit;
    private JLabel jlblOut, jlblNum1Caption, jlblNum2Caption;
    private JTextField jtxtNum1, jtxtNum2;


    public Calculator() {

        window = new JFrame("Калькулятор");


        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        window.setResizable(false);


        mainPanel = new JPanel(new BorderLayout());
        inputPanel = new JPanel();
        outputPanel = new JPanel();
        buttonPanel = new JPanel();


        inputPanel.setLayout(new GridLayout(1, 4)); //1 строка и 4 столбца
        outputPanel.setLayout(new GridLayout(1, 1));    //1 строка и 1 столбец
        buttonPanel.setLayout(new GridLayout(2, 4, 5, 5)); //1 строка и 4 столбца; расстояние между компонентами будет равно 5 (чтобы кнопки не слипались)


        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(outputPanel, BorderLayout.SOUTH);


        window.getContentPane().add(mainPanel);


        addButtonsAndTextFields();


        window.pack();
        window.setLocationRelativeTo(null);


        window.setVisible(true);
    }


    private void addButtonsAndTextFields() {


        jbtnAdd = new JButton("Сложить");
        jbtnSubtract = new JButton("Вычесть");
        jbtnMultiply = new JButton("Умножить");
        jbtnRealDivide = new JButton("Деление");
        jbtnMemory = new JButton("M+");
        jbtnReset = new JButton("Сброс");
        jbtnExit = new JButton("Выход");


        jlblOut = new JLabel(" ", JLabel.CENTER);
        jlblNum1Caption = new JLabel("Число 1:       ", JLabel.RIGHT);
        jlblNum2Caption = new JLabel("Число 2:       ", JLabel.RIGHT);


        jtxtNum1 = new JTextField();
        jtxtNum2 = new JTextField();


        jbtnAdd.addActionListener(this);
        jbtnSubtract.addActionListener(this);
        jbtnMultiply.addActionListener(this);
        jbtnRealDivide.addActionListener(this);
        jbtnMemory.addActionListener(this);
        jbtnReset.addActionListener(this);
        jbtnExit.addActionListener(this);


        buttonPanel.add(jbtnAdd);
        buttonPanel.add(jbtnSubtract);
        buttonPanel.add(jbtnMultiply);
        buttonPanel.add(jbtnRealDivide);
        buttonPanel.add(jbtnMemory);
        buttonPanel.add(jbtnReset);
        buttonPanel.add(jbtnExit);


        inputPanel.add(jlblNum1Caption);
        inputPanel.add(jtxtNum1);
        inputPanel.add(jlblNum2Caption);
        inputPanel.add(jtxtNum2);


        outputPanel.add(jlblOut);
    }


    @Override
    public void actionPerformed(ActionEvent event) {

        
        if (event.getSource() == jbtnAdd) {
            add();
        } else if (event.getSource() == jbtnSubtract) {
            subtract();
        } else if (event.getSource() == jbtnMultiply) {
            multiply();
        }else if (event.getSource() == jbtnRealDivide) {
            realDivide();
        }else if (event.getSource() == jbtnMemory) {
            memory();
        } else if (event.getSource() == jbtnReset) {
            reset();
        } else if (event.getSource() == jbtnExit) {
            exit();
        }
    }


    private void exit() {

        int reponse = JOptionPane.showConfirmDialog(null, "Вы действительно хотите закрыть приложение?", "Подтверждение",
                JOptionPane.YES_NO_OPTION);


        if (reponse == JOptionPane.YES_OPTION) {


            window.dispose();
            System.exit(0);
        }

    }


    private void add() {

        int num1, num2, result;


        if ((isValidInput(jtxtNum1, "Число 1")) && (isValidInput(jtxtNum2, "Число 2"))) {

            num1 = Integer.parseInt(jtxtNum1.getText());
            num2 = Integer.parseInt(jtxtNum2.getText());


            result = num1 + num2;


            displayData(num1, num2, "+", result);
        }
    }


    private void subtract() {
        int num1, num2, result;


        if ((isValidInput(jtxtNum1, "Число 1")) && (isValidInput(jtxtNum2, "Число 2"))) {

            num1 = Integer.parseInt(jtxtNum1.getText());
            num2 = Integer.parseInt(jtxtNum2.getText());


            result = num1 - num2;


            displayData(num1, num2, "-", result);
        }
    }


    private void multiply() {
        int num1, num2, result;


        if ((isValidInput(jtxtNum1, "Число 1")) && (isValidInput(jtxtNum2, "Число 2"))) {

            num1 = Integer.parseInt(jtxtNum1.getText());
            num2 = Integer.parseInt(jtxtNum2.getText());


            result = num1 * num2;


            displayData(num1, num2, "*", result);
        }
    }





    private void realDivide() {

        int num1, num2;
        double result;


        if ((isValidInput(jtxtNum1, "Число 1")) && (isValidInput(jtxtNum2, "Число 2"))) {

            num1 = Integer.parseInt(jtxtNum1.getText());
            num2 = Integer.parseInt(jtxtNum2.getText());


            result = (double) num1 / (double) num2;


            displayData(num1, num2, "/", result);
        }
    }


    private void memory() {
        int num1, num2,memory=0, result, result1;

        if ((isValidInput(jtxtNum1, "Число 1")) && (isValidInput(jtxtNum2, "Число 2"))) {

            num1 = Integer.parseInt(jtxtNum1.getText());
            num2 = Integer.parseInt(jtxtNum2.getText());


            result1 = num1 + num2;
            memory = memory + result1;
            result = memory + result1;

            displayData(memory, result1, "+", result);
        }
    }


    private void displayData(int num1, int num2, String op, int result) {


        String s = String.format("%d %s %d = %d", num1, op, num2, result);

        jlblOut.setText(s);

    }


    private void displayData(int num1, int num2, String op, double result) {


        String s = String.format("%d %s %d = %.2f", num1, op, num2, result);

        jlblOut.setText(s);

    }


    private void reset() {
        jlblOut.setText(" ");
        jtxtNum1.setText("");
        jtxtNum2.setText("");
        jtxtNum1.requestFocus();

    }


    private boolean isValidInput(JTextField jtxt, String description) {


        if (jtxt.getText().trim().length() > 0) {

            try {

                int num = Integer.parseInt(jtxt.getText());


                return true;

            } catch (NumberFormatException e) {


                JOptionPane.showMessageDialog(window, "Вы должны ввести целое число!", "Ошибка", JOptionPane.WARNING_MESSAGE);


                jtxt.requestFocus();
                jtxt.selectAll();


                return false;
            }

        } else {


            JOptionPane.showMessageDialog(window, "Введите число " + description, "Ошибка", JOptionPane.WARNING_MESSAGE);


            jtxt.requestFocus();
            jtxt.selectAll();


            return false;
        }
    }

    private static void setGUI() {

        Calculator gui = new Calculator();
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                setGUI();
            }
        });
    }
}