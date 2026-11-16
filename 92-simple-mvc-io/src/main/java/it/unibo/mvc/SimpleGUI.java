package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame("Simple GUI");
    public SimpleGUI() {
    this(new Controller()); // Sostituisci "ControllerImpl" con il nome reale della tua classe Controller
    }
    private SimpleGUI(final Controller controller) {
        final JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        final JTextArea area = new JTextArea();
        final JButton save = new JButton("SAVE");

        mainPanel.add(area, BorderLayout.CENTER);
        mainPanel.add(save, BorderLayout.SOUTH);

        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*
         * Handlers
         */
        save.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent ignored) {
                    
                    try {
                        controller.printOnFile(area.getText()); 
                    } catch (final IOException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "An error occurred", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        );
    }
     private void display() {
        frame.setSize(600, 400);
        frame.setVisible(true);
       
    }
    public void main() {
        final SimpleGUI simpleG = new SimpleGUI(new Controller());
        simpleG.display();
    }
}
