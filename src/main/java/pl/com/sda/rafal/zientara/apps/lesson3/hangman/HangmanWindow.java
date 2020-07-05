package pl.com.sda.rafal.zientara.apps.lesson3.hangman;

import pl.com.sda.rafal.zientara.apps.lesson2.hangman.Hangman;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HangmanWindow {

    private JFrame frame;
    private JLabel guessLabel;
    private JTextField input;
    private JButton button;
    private JLabel hpLabel;
    private JTextArea tries;
    private static final int VIEW_WIDTH = 250;
    private static final int VIEW_HEIGHT = 100;
    private Hangman game = new Hangman();

    public HangmanWindow() {
        frame = new JFrame("Hangman");
        frame.setSize(VIEW_WIDTH, 6 * VIEW_HEIGHT);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        guessLabel = new JLabel("... .. ....");
        guessLabel.setBounds(0, 0, VIEW_WIDTH, VIEW_HEIGHT);
        frame.add(guessLabel);

        input = new JTextField();
        input.setBounds(0, VIEW_HEIGHT, VIEW_WIDTH, VIEW_HEIGHT);
        frame.add(input);

        button = new JButton("OK");
        button.setBounds(0, VIEW_HEIGHT * 2, VIEW_WIDTH, VIEW_HEIGHT);
        button.addActionListener(actionEvent -> handleOkButton());
        frame.add(button);

        hpLabel = new JLabel("HP = 7/7");
        hpLabel.setBounds(0, VIEW_HEIGHT * 3, VIEW_WIDTH, VIEW_HEIGHT);
        frame.add(hpLabel);

        tries = new JTextArea("a b c");
        tries.setBounds(0, VIEW_HEIGHT * 4, VIEW_WIDTH, VIEW_HEIGHT);
        frame.add(tries);

        game.setPuzzle("Ala ma kota");//todo losuj!
        refreshUI();
        frame.setVisible(true);
    }

    private void handleOkButton() {
        String guess = input.getText();
        game.guess(guess);
        input.setText("");
        refreshUI();
    }

    private void refreshUI() {
        refreshPuzzle();
        refreshHp();
//        refreshTires();
    }

    private void refreshPuzzle() {
        String output = game.getOutput();
        guessLabel.setText(output);
    }

    private void refreshHp() {
        int currentHp = game.getHp();
        String output = String.format("HP %d/7", currentHp);
        hpLabel.setText(output);
    }
}
