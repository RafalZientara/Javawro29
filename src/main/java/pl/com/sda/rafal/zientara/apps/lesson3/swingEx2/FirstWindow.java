package pl.com.sda.rafal.zientara.apps.lesson3.swingEx2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FirstWindow {
    private JFrame frame;
    private JTextField input1;
    private JButton button;
    private ConfirmListener listener;

    public FirstWindow() {
        this.frame = new JFrame("First Window");
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setSize(200, 250);
        this.frame.setLayout(null);

        this.input1 = new JTextField("Input 1");
        this.input1.setBounds(50,50,100,50);
        input1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                listener.onInputConfirmed(input1.getText());
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        this.frame.add(input1);

        this.button = new JButton("Concat");
        this.button.setBounds(50,150,100,50);
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                listener.onInputConfirmed(input1.getText());
            }
        });
        this.frame.add(button);

        this.frame.setVisible(true);
    }

    public void setListener(ConfirmListener listener) {
        this.listener = listener;
    }

    public interface ConfirmListener{
        void onInputConfirmed(String input);
    }
}
