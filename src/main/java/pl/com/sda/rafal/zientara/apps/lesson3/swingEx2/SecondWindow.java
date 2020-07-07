package pl.com.sda.rafal.zientara.apps.lesson3.swingEx2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SecondWindow implements FirstWindow.ConfirmListener {
    private JFrame frame;
    private JTextField input2;
    private JTextArea textSum;
    private String input;

    public SecondWindow() {
        this.frame = new JFrame("Second Window");
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setSize(200, 250);
        this.frame.setLayout(null);

        this.input2 = new JTextField("Input 2");
        this.input2.setBounds(50, 50, 100, 50);
        this.input2.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                textSum.setText(input + input2.getText());
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        this.frame.add(input2);

        this.textSum = new JTextArea("in1 + in2");
        this.textSum.setBounds(50, 150, 100, 50);
        this.frame.add(textSum);

        this.frame.setVisible(true);
    }

    @Override
    public void onInputConfirmed(String input) {
        this.textSum.setText(input + this.input2.getText());
    }
}
