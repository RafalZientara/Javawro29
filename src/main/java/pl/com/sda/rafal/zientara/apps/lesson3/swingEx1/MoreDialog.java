package pl.com.sda.rafal.zientara.apps.lesson3.swingEx1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MoreDialog {
    private int counter = 0;

    public MoreDialog() {
        JFrame frame = new JFrame("Click!");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(200, 250);
        frame.setLayout(null);

        JLabel number = new JLabel("0");
        number.setBounds(50,50,100,50);
        frame.add(number);

        JButton increment = new JButton("Increment");
        increment.setBounds(50,150,100,50);
        increment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                counter++;
                number.setText(String.valueOf(counter));
            }
        });
        frame.add(increment);

        frame.setVisible(true);
    }
}
