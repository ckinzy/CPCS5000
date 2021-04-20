
package c11l1geometry;
/**
 *
 * @author corinnekinzy CPSC 5000-0 CRN22404 C8-11 L4 3/22/21
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author corinnekinzy
 */
public class Ellipse {
    double radius1;
    double radius2;
    
    Ellipse() {
        //initialize vars to 0
        this.radius1 = 0;
        this.radius2 = 0;   
    }
    
    // Computes the area of a ellipse and stores as type double
    public double computeArea() {
        double area = 0;
        final double PI = 3.141592;
        
        area = PI * radius1 * radius2;
        
        return area;    
    }
    
    public void readFile(String path) {
        
        path = path;
        String inputFile = path + "ellipse.txt";
    
        try 
        {
            // Read from the input file and put in scanner and initialize array 
            FileReader ellipse_specs = new FileReader(inputFile);
            Scanner input_scanner = new Scanner(ellipse_specs);
            double[] input_array = new double[2];

            while (input_scanner.hasNextLine()) {
                
                // fill in the array with the values from the Scanner
                for (int i=0;i<2;i++) {
                    input_array[i] = input_scanner.nextDouble();
                    
//                    For Testing:
//                    System.out.println(input_array[i]);
                }

            }
            
            // stores the values from the array into the instance vars
            this.radius1 = input_array[0];
            this.radius2 = input_array[1];

        }
        // if we can't find the file...
        catch(FileNotFoundException ex) {
            System.out.println("We couldn't find your file! Check the file name and path :)" + ex.getMessage());
        }
        
    }
    
    
}
