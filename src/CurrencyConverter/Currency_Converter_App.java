package CurrencyConverter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Currency_Converter_App extends JFrame implements ActionListener {

    private JTextField amountField;
    private JComboBox<String> fromCurrency;
    private JComboBox<String> toCurrency;
    private JLabel resultLabel;

    private JButton convertButton;
    private JButton clearButton;

    public Currency_Converter_App() {

        // Your GUI code here
        setTitle("Global Currency Converter");
        setSize(550, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        getContentPane().setBackground(new Color(30, 41, 59));

        JLabel title = new JLabel("GLOBAL CURRENCY CONVERTER");
        title.setBounds(40, 20, 500, 35);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(Color.WHITE);
        add(title);

        JLabel amountLabel = new JLabel("Enter Amount:");
        amountLabel.setBounds(50, 90, 150, 25);
        amountLabel.setForeground(Color.WHITE);
        amountLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(amountLabel);

        amountField = new JTextField();
        amountField.setBounds(200, 90, 200, 30);
        amountField.setFont(new Font("Arial", Font.PLAIN, 16));
        add(amountField);

        JLabel fromLabel = new JLabel("From:");
        fromLabel.setBounds(50, 150, 100, 25);
        fromLabel.setForeground(Color.WHITE);
        fromLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(fromLabel);

        JLabel toLabel = new JLabel("To:");
        toLabel.setBounds(280, 150, 100, 25);
        toLabel.setForeground(Color.WHITE);
        toLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(toLabel);

        String[] currencies = {
        	    "INR",
        	    "USD",
        	    "EUR",
        	    "GBP",
        	    "JPY",
        	    "CNY",
        	    "RUB",
        	    "PKR",
        	    "NPR",
        	    "BDT",
        	    "LKR",
        	    "BTN",
        	    "AFN",
        	    "KRW",
        	    "AED",
        	    "SAR",
        	    "QAR",
        	    "KWD",
        	    "OMR",
        	    "BHD",
        	    "AUD",
        	    "CAD",
        	    "SGD",
        	    "MYR",
        	    "THB",
        	    "ZAR",
        	    "CHF",
        	    "TRY",
        	    "NZD",
        	    "HKD"
        	};

        fromCurrency = new JComboBox<>(currencies);
        fromCurrency.setBounds(100, 145, 120, 35);
        add(fromCurrency);

        toCurrency = new JComboBox<>(currencies);
        toCurrency.setBounds(320, 145, 120, 35);
        add(toCurrency);

        convertButton = new JButton("Convert");
        convertButton.setBounds(90, 220, 140, 45);
        convertButton.setBackground(new Color(34, 197, 94));
        convertButton.setForeground(Color.WHITE);
        convertButton.setFont(new Font("Arial", Font.BOLD, 16));
        convertButton.addActionListener(this);
        add(convertButton);

        clearButton = new JButton("Clear");
        clearButton.setBounds(280, 220, 140, 45);
        clearButton.setBackground(new Color(239, 68, 68));
        clearButton.setForeground(Color.WHITE);
        clearButton.setFont(new Font("Arial", Font.BOLD, 16));
        clearButton.addActionListener(this);
        add(clearButton);

        resultLabel = new JLabel("Converted Amount: ");
        resultLabel.setBounds(50, 300, 450, 30);
        resultLabel.setForeground(new Color(250, 204, 21));
        resultLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(resultLabel);

        JLabel footer = new JLabel("Developed by Vansh Agrawal");
        footer.setBounds(180, 340, 200, 20);
        footer.setForeground(Color.LIGHT_GRAY);
        add(footer);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == clearButton) {
            amountField.setText("");
            resultLabel.setText("Converted Amount: ");
            return;
        }

        try {

            double amount = Double.parseDouble(amountField.getText());

            String from = fromCurrency.getSelectedItem().toString();
            String to = toCurrency.getSelectedItem().toString();

            double result = convert(amount, from, to);

            resultLabel.setText(
            	    amount + " " + from +
            	    " = " +
            	    String.format("%.2f", result) +
            	    " " + to
            	);

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid number!",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private double convert(double amount, String from, String to) {

        if (from.equals(to))
            return amount;

        double inr = amount;

        // Convert FROM currency to INR
        switch (from) {
            case "USD": inr = amount * 83; break;
            case "EUR": inr = amount * 90; break;
            case "GBP": inr = amount * 105; break;
            case "JPY": inr = amount * 0.57; break;
            case "AUD": inr = amount * 55; break;
            case "CAD": inr = amount * 61; break;
            case "CNY": inr = amount * 11.5; break;
            case "RUB": inr = amount * 0.90; break;
            case "PKR": inr = amount * 0.30; break;
            case "NPR": inr = amount * 0.63; break;
            case "BDT": inr = amount * 0.76; break;
            case "LKR": inr = amount * 0.28; break;
            case "BTN": inr = amount * 1.00; break;
            case "AFN": inr = amount * 1.15; break;
            case "KRW": inr = amount * 0.062; break;
            case "AED": inr = amount * 22.6; break;
            case "SAR": inr = amount * 22.1; break;
            case "QAR": inr = amount * 22.8; break;
            case "KWD": inr = amount * 270; break;
            case "OMR": inr = amount * 215; break;
            case "BHD": inr = amount * 220; break;
            case "SGD": inr = amount * 62; break;
            case "MYR": inr = amount * 18; break;
            case "THB": inr = amount * 2.4; break;
            case "ZAR": inr = amount * 4.5; break;
            case "CHF": inr = amount * 95; break;
            case "TRY": inr = amount * 2.5; break;
            case "NZD": inr = amount * 50; break;
            case "HKD": inr = amount * 10.6; break;
        }

        // Convert INR to TARGET currency
        switch (to) {
            case "USD": return inr / 83;
            case "EUR": return inr / 90;
            case "GBP": return inr / 105;
            case "JPY": return inr / 0.57;
            case "AUD": return inr / 55;
            case "CAD": return inr / 61;
            case "CNY": return inr / 11.5;
            case "RUB": return inr / 0.90;
            case "PKR": return inr / 0.30;
            case "NPR": return inr / 0.63;
            case "BDT": return inr / 0.76;
            case "LKR": return inr / 0.28;
            case "BTN": return inr;
            case "AFN": return inr / 1.15;
            case "KRW": return inr / 0.062;
            case "AED": return inr / 22.6;
            case "SAR": return inr / 22.1;
            case "QAR": return inr / 22.8;
            case "KWD": return inr / 270;
            case "OMR": return inr / 215;
            case "BHD": return inr / 220;
            case "SGD": return inr / 62;
            case "MYR": return inr / 18;
            case "THB": return inr / 2.4;
            case "ZAR": return inr / 4.5;
            case "CHF": return inr / 95;
            case "TRY": return inr / 2.5;
            case "NZD": return inr / 50;
            case "HKD": return inr / 10.6;
            default: return inr; // INR
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new Currency_Converter_App();
        });
    }
}