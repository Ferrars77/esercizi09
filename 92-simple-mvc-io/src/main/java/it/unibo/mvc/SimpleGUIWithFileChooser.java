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
import javax.swing.JPanel;
import javax.swing.JTextArea;
/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final JFrame frame = new JFrame("Simple GUI");
    public SimpleGUIWithFileChooser() {
    this(new Controller()); // Sostituisci "ControllerImpl" con il nome reale della tua classe Controller
    }
    private SimpleGUIWithFileChooser(final Controller controller) {
        final JPanel mainPanel = new JPanel();
        final JPanel secondPanel = new JPanel();
        secondPanel.setLayout(new BorderLayout());
        mainPanel.setLayout(new BorderLayout());

        final JTextArea area = new JTextArea();
        final JButton save = new JButton("SAVE");

        final JTextField box= new JTextField();
        box.setEditable(false);
        box.setText(controller.getPath(controller.getCurrentFile()));
        
        final JButton browse = new JButton("BROWSE");

        mainPanel.add(area, BorderLayout.CENTER);
        mainPanel.add(save, BorderLayout.SOUTH);
        mainPanel.add(secondPanel, BorderLayout.NORTH);

        secondPanel.add(box, BorderLayout.CENTER);
        secondPanel.add(browse, BorderLayout.LINE_END);


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

        browse.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent ignored) {
                        JFileChooser chooser = new JFileChooser();
                        final int res = chooser.showSaveDialog(browse);
                        switch(res) {
                            case JFileChooser.APPROVE_OPTION: 
                                File fileChoosen = chooser.getSelectedFile();
                                controller.setCurrentFile(fileChoosen);
                                box.setText(fileChoosen.getPath());
                                break;

                            case JFileChooser.CANCEL_OPTION:
                                break;

                            default:
                                JOptionPane.showMessageDialog(frame, res, "Error!", JOptionPane.ERROR_MESSAGE);
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
        final SimpleGUIWithFileChooser simpleG = new SimpleGUIWithFileChooser(new Controller());
        simpleG.display();
    }
}
