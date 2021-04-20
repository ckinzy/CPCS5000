package c3l1computertester;

/**
 *
 * @author corinnekinzy CPSC 5000-0 CRN22404 C1-3 L1 2/8/21
 */
public class C3L1ComputerTester {
    
    public static void main(String[] args) 
    {
        // testing variables
        String fileName = "explorer.exe";
        double size = 37.5;
        
        // instantiates the Computer class and passes a given serial number
        Computer default_computer = new Computer("2YRAE1M");

        // calls the Display method to show the default_computer object
        default_computer.display();
        
        // calls the addFile method with a given fileName and size
        default_computer.addFile(fileName, size);
        
        // displays the default_computer but with the new file and size
        default_computer.display();
    
    }
}