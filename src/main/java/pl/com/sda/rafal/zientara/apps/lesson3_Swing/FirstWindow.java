package pl.com.sda.rafal.zientara.apps.lesson3_Swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FirstWindow {
    private JFrame frame;
    private JTextField input1;
    private JButton button;
    private ConfirmListener listener;   //może jakiś obiekt mnie (w sensie tę klasę) nasłuchiwać, niekoniecznie musi ale może

    public FirstWindow() {
        frame = new JFrame("First Window");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame.setSize(200, 250);
        frame.setBounds(0, 0, 200, 250);//pierwsze parametry to ustawenie współrzędnych okna
        frame.setLayout(null);
        //za pomocą setBounds

        input1 = new JTextField("input1");
        input1.setBounds(50, 50, 100, 50);
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
        frame.add(input1);

        button = new JButton("Połącz!");
        button.setBounds(50, 150, 100, 50);
        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.onInputConfirmed(input1.getText());        //to jet moment który będzie nasłuchiwany przez słuchacza
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
