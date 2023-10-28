package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import controller.PrimeNumbers;

public class GUI {

	/**
	 *  What the user will be able to see.
	 */
    public void showGUI() {
        // Creates all variables and objects
        int number = 3000;
        PrimeNumbers primeNumbers = new PrimeNumbers();
        ArrayList<Integer> primesList = primeNumbers.generatePrimeNumbers(number);
        
        JFrame frame = createFrame("Recursive");

        JLabel label = createLabel("All Prime numbers to: " + number);
        frame.add(label, BorderLayout.NORTH);

        JTextArea textArea = createTextArea(primesList);
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Visar ramen
        frame.setVisible(true);
    }

   /**
    * @param title The given title on top of the frame
    * @return Gives back the complete frame 
    */
    private JFrame createFrame(String title) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        return frame;
    }
    
    /**
     * 
     * @param text Input text 
     * @return The new label with text is returned 
     */
    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        return label;
    }

    /**
     * Creates a JTextArea displaying prime numbers separated by commas.
     * 
     * @param primesList The list of prime numbers to display.
     * @return A JTextArea displaying prime numbers or a message if no primes are found.
     */
    private JTextArea createTextArea( ArrayList<Integer> primesList) {
        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);

        if (primesList != null && primesList.size() > 0) {
        	
        	//Creates a string with the prime numbers separated with a ","
            StringBuilder primeText = new StringBuilder();
            for (int i = 0; i < primesList.size(); i++) {
                primeText.append(primesList.get(i));
                if (i < primesList.size() - 1) {
                    primeText.append(", ");
                }
            }
            primeText.append(" Number of primes: " + primesList.size());
            textArea.setText(primeText.toString());
        } else {
            textArea.setText("NO PRIMES TO DISPLAY");
        }
        return textArea;
    }
}
