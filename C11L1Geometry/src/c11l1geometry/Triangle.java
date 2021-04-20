
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
public class Triangle {
    double base;
    double height;
    double hypotenuse;
    
    Triangle() {
        // initialize vars to 0
        base = 0;
        height = 0;
        hypotenuse = 0;
    }
    
    // Computes the perimeter of a triangle and stores as type double
    public double computePerimeter() {
          
        double perimeter = 0;
        
        perimeter = base + height + hypotenuse;
        
          
        return perimeter;
        
    }
    
    // Computes the area of a triangle and stores as type double
    public double computeArea() {
        
        double area = 0;
        
        area = (base*height) * 0.5;
        
        return area;
        
    }
    
    public void readFile(String path) {
        
        path = path;
        String inputFile = path + "triangle.txt";
    
        try 
        {
            // Read from the input file and add to scanner and initialize array
            FileReader triangle_specs = new FileReader(inputFile);
            Scanner input_scanner = new Scanner(triangle_specs);
            double[] input_array = new double[3];

            while (input_scanner.hasNextLine()) {

                // fill in the array with the values from the Scanner
                for (int i=0;i<3;i++) {
                    input_array[i] = input_scanner.nextDouble();
                    
//                   FOR TESTING:
//                   System.out.println(input_array[i]);
                }

            }
            
            // stores the values from the array into the instance vars
            this.base = input_array[0];
            this.height = input_array[1];
            this.hypotenuse = input_array[2];

        }
        // if we can't find the file...
        catch(FileNotFoundException ex) {
            System.out.println("We couldn't find your file! Check the file name and path :)" + ex.getMessage());
        }
        
    }
        
        
}
