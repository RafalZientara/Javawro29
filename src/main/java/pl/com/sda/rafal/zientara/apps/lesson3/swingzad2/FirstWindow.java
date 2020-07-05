package pl.com.sda.rafal.zientara.apps.lesson3.swingzad2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FirstWindow {
    private final JFrame frame;
    private final JTextField input1;
    private final JButton button;
    private ConfirmListener listener;

    public FirstWindow() {
        frame = new JFrame("Pierwsze Okno");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(200, 250);
        frame.setLayout(null);//teraz mozna ustawiac widoki
        //za pomoca setBounds

        input1 = new JTextField("input1");
        input1.setBounds(50, 50, 100, 50);
        input1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
                System.out.println(keyEvent);
                listener.onInputConfirmed(input1.getText());
            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {

            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {

            }
        });
        frame.add(input1);

        button = new JButton("Połącz");
        button.setBounds(50, 150, 100, 50);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //todo
                listener.onInputConfirmed(input1.getText());
            }
        });
        frame.add(button);

        frame.setVisible(true);
    }

    public void setListener(ConfirmListener listener) {
        this.listener = listener;
    }

    public interface ConfirmListener {
        void onInputConfirmed(String input);
    }

}
