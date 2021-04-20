/*
 * @author corinnekinzy CPSC 5000-0 CRN22404 C4-5 L2 2/22/21
 */
package c5l1compare;
import javax.swing.JOptionPane;
/**
 *
 * @author corinnekinzy
 */
public class C5L1Compare {

    public static void main(String[] args) {
        //initializing the Options object
        Options tester = new Options();

        // Utilizes the getInput method to ask for the User's input
        tester.getInput();
        
        /* 
        Uses the getUserSelection() method to get 
        the input from the new tester object. 
        Adds the input for the additional choices
        */
        tester.getNextOptions(tester.getUserSelection());
    }
    
}