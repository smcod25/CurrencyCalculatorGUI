

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class currencyco {
    public static void main(String[] args) {
        currencyConvertor();
    }

    private static void currencyConvertor() {
        JFrame frame = new JFrame("Currency Convertor");
        JLabel rsLabel = new JLabel("Enter amount in Rs: ");
        JLabel usdLabel = new JLabel("Enter amount in USD: ");
        JTextField rsField = new JTextField();
        JTextField usdField = new JTextField();
        JButton button = new JButton("Convert");
        JLabel result = new JLabel();

        rsLabel.setBounds(30, 30, 150, 40);
        usdLabel.setBounds(30, 80, 150, 40);
        rsField.setBounds(180, 30, 50, 40);
        usdField.setBounds(180, 80, 50, 40);
        button.setBounds(30, 130, 100, 40);
        result.setBounds(140, 130, 250, 40);
        frame.add(result);
        frame.add(button);
        frame.add(rsLabel);
        frame.add(usdLabel);
        frame.add(rsField);
        frame.add(usdField);
        frame.setLayout(null);
        frame.setSize(500, 250);
        frame.setVisible(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String rupees,dollar;
                rupees= rsField.getText();
                dollar=usdField.getText();

                //case 1 when user input in rs and usd is empty
                if(!rupees.isEmpty() && dollar.isEmpty())
                {
                    float rs = Float.parseFloat(rsField.getText());
                    float inrToUsd = (float) (rs/83.73);
                    result.setText("INR to usd :"+ String.valueOf(inrToUsd));
                }
                else if (rsField.getText().isEmpty()
                        && !usdField.getText().isEmpty()) {
                    float usd = Float.parseFloat(usdField.getText());
                    float usdToInr = (float) (usd* 83.73);
                    result.setText("Usd to Inr :" + usdToInr);
                }
                else if (rsField.getText().isEmpty()
                        && usdField.getText().isEmpty()) {
                    result.setText("Enter atleast one amount to convert :" );
                }
                else {
                    float rs = Float.parseFloat(rsField.getText());
                    float inrToUsd = (float) (rs/83.73);
                    float usd = Float.parseFloat(usdField.getText());
                    float usdToInr = (float) (usd* 83.73);
                    result.setText("In usd :"+ String.valueOf(inrToUsd) +
                            "In INR"+ usdToInr
                    );
                }

                //case 2 when user input in usd
//                float usdToInr = (float) (usd* 83.73);
//                result.setText("Usd to Inr :" + usdToInr);
            }
        });
    }
}
