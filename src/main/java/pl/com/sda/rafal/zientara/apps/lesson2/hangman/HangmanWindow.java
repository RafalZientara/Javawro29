package pl.com.sda.rafal.zientara.apps.lesson2.hangman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Set;

public class HangmanWindow {

    private static final int VIEW_WIDTH = 250;
    private static final int VIEW_HEIGHT = 100;

    private JFrame frame;
    private JLabel guessLabel;
    private JTextField input;
    private JButton button;
    private JLabel hpLabel;
    private JTextArea tries;
    private Hangman game = new Hangman();

    public HangmanWindow() {
        frame = new JFrame("Hangman");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(VIEW_WIDTH + 50, VIEW_HEIGHT * 5 + 25);

        guessLabel = new JLabel("... .. ....");
        guessLabel.setBounds(25, 0, VIEW_WIDTH, VIEW_HEIGHT);
        guessLabel.setFont(new Font("Serif", Font.PLAIN, 24));
        frame.add(guessLabel);

        input = new JTextField("");
        input.setBounds(25, VIEW_HEIGHT, VIEW_WIDTH, VIEW_HEIGHT);
        input.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    handleOkButton();
                }
            }
        });
        frame.add(input);

        button = new JButton("OK");
        button.setBounds(25, VIEW_HEIGHT * 2, VIEW_WIDTH, VIEW_HEIGHT);
        button.addActionListener(e -> handleOkButton());
        frame.add(button);

        hpLabel = new JLabel("HP 7/7");
        hpLabel.setBounds(25, VIEW_HEIGHT * 3, VIEW_WIDTH, VIEW_HEIGHT);
        frame.add(hpLabel);

        tries = new JTextArea("Użyte litery");
        tries.setBounds(25, VIEW_HEIGHT * 4, VIEW_WIDTH, VIEW_HEIGHT);
        frame.add(tries);

//        game.setPuzzle("Ala ma kota");
        game.setPuzzle(Resources.getRandomPuzzle());

        refreshUI();

        frame.setVisible(true);
    }

    private void handleOkButton() {
        if (game.isGameOver()) {
            resetGame();
        } else {
            String guess = input.getText();
            game.guess(guess);
            input.setText("");
        }
        refreshUI();
    }

    private void resetGame() {
        game.setPuzzle(Resources.getRandomPuzzle());
    }

    private void refreshUI() {
        refreshPuzzle();
        refreshHP();
        refreshTries();
        refreshButton();
    }

    private void refreshButton() {
        if (game.isGameOver()) {
            button.setText(("Reset"));
        } else {
            button.setText("OK");
        }
    }

    private void refreshPuzzle() {
        guessLabel.setText(game.getOutput());
    }

    private void refreshTries() {
        Set<String> tries = game.getTries();
        StringBuilder builder = new StringBuilder();
        for (String s : tries) {
            builder.append(s).append(" ");
        }
        String output = builder.toString();
        this.tries.setText(output);
    }

    private void refreshHP() {
        int currentHp = game.getHp();
        String output = String.format("HP %d/7", currentHp);
        hpLabel.setText(output);
    }
}
