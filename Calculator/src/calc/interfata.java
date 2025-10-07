package calc;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class interfata extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField field1;
    private JTextField field2;
    private StringBuilder expresie = new StringBuilder();
    private calc calc = new calc();

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new interfata().setVisible(true));
    }

    public interfata() {

        setTitle("Calculator Simplu");
        setBounds(100, 100, 400, 300);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(5, 5));
        setContentPane(contentPane);

 
        JPanel displayPanel = new JPanel(new GridLayout(2, 1));
        field1 = new JTextField();
        field2 = new JTextField();
        field1.setEditable(false);
        field2.setEditable(false);
        displayPanel.add(field1);
        displayPanel.add(field2);
        contentPane.add(displayPanel, BorderLayout.NORTH);

  
        JPanel panel = new JPanel(new GridLayout(5, 4, 5, 5));
        contentPane.add(panel, BorderLayout.CENTER);


        JButton btnC = new JButton("C");
        JButton btnDiv = new JButton("\\");
        JButton btnMul = new JButton("x");
        JButton btnDel = new JButton("del");

        JButton btn7 = new JButton("7");
        JButton btn8 = new JButton("8");
        JButton btn9 = new JButton("9");
        JButton btnMinus = new JButton("-");

        JButton btn4 = new JButton("4");
        JButton btn5 = new JButton("5");
        JButton btn6 = new JButton("6");
        JButton btnPlus = new JButton("+");

        JButton btn1 = new JButton("1");
        JButton btn2 = new JButton("2");
        JButton btn3 = new JButton("3");
        JButton btnEq = new JButton("=");

        JButton btn0 = new JButton("0");


        panel.add(btnC); panel.add(btnDiv); panel.add(btnMul); panel.add(btnDel);
        panel.add(btn7); panel.add(btn8); panel.add(btn9); panel.add(btnMinus);
        panel.add(btn4); panel.add(btn5); panel.add(btn6); panel.add(btnPlus);
        panel.add(btn1); panel.add(btn2); panel.add(btn3); panel.add(btnEq);
        panel.add(btn0);


        ActionListener inputListener = e -> {
            JButton b = (JButton) e.getSource();
            expresie.append(b.getText());
            field1.setText(expresie.toString());
        };


        btn0.addActionListener(inputListener);
        btn1.addActionListener(inputListener);
        btn2.addActionListener(inputListener);
        btn3.addActionListener(inputListener);
        btn4.addActionListener(inputListener);
        btn5.addActionListener(inputListener);
        btn6.addActionListener(inputListener);
        btn7.addActionListener(inputListener);
        btn8.addActionListener(inputListener);
        btn9.addActionListener(inputListener);


        btnPlus.addActionListener(inputListener);
        btnMinus.addActionListener(inputListener);
        btnMul.addActionListener(inputListener);
        btnDiv.addActionListener(inputListener);


        btnC.addActionListener(e -> {
            expresie.setLength(0);
            field1.setText("");
            field2.setText("");
        });


        btnDel.addActionListener(e -> {
            if (expresie.length() > 0)
                expresie.deleteCharAt(expresie.length() - 1);
            field1.setText(expresie.toString());
        });


        btnEq.addActionListener(e -> field2.setText(evalueazaExpresie()));
    }


    private String evalueazaExpresie() {
        String expr = expresie.toString();
        double result=0;
        int opPos = -1;
        char op = 0;
        for (char c : expr.toCharArray()) {
            if (c == '+' || c == '-' || c == 'x' || c == '\\') {
                op = c;
                opPos = expr.indexOf(c);
                break;
            }
        }

        try {
            double a = Double.parseDouble(expr.substring(0, opPos));
            double b = Double.parseDouble(expr.substring(opPos + 1));
            if (op == '+') {
            	result = calc.add(a,b);
            	
            }
            if (op == '-') {
            	result = calc.sub(a,b);
            	
            }
            else if (op == '\\') {
            	result = calc.div(a,b);
            	
            }
            else if (op == 'x') {
            	result = calc.mul(a,b);
            	
            }
           
            return String.valueOf(result);
        } catch (Exception e) {
            return "Eroare";
        }
    }
}
