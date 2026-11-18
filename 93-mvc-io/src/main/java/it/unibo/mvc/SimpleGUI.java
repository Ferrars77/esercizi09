package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JTextArea;
/**
 * A very simple program using a graphical interface.
 *
 */
public final class SimpleGUI {
    private final JFrame frame = new JFrame("Simple GUI");
    private final Controller controller = new SimpleController();
    public SimpleGUI() {
        final JPanel mainPanel = new JPanel();
        final JPanel southPanel = new JPanel(new FlowLayout());
        mainPanel.setLayout(new BorderLayout());
        

        final JTextField field = new JTextField();
        field.setBackground(Color.lightGray);
        final JTextArea area = new JTextArea();
        final JButton printBut = new JButton("Print");
        final JButton historyBut = new JButton("Show history");
       
        mainPanel.add(field, BorderLayout.NORTH);
        mainPanel.add(area, BorderLayout.CENTER);
        southPanel.add(printBut, BorderLayout.SOUTH);
        southPanel.add(historyBut, BorderLayout.SOUTH);
        mainPanel.add(southPanel, BorderLayout.SOUTH);

        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*
         * Handlers
         */
        printBut.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent ignored) {
                    controller.setNextStringToPrint(field.getText());
                    controller.printCurrentString();
                }
            }
        );

        historyBut.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent ignored) {
                    for(String text: controller.getStringsHistory()) {
                        area.append(" " + text + "\n");
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
        final SimpleGUI simpleG = new SimpleGUI();
        simpleG.display();
    }
}
