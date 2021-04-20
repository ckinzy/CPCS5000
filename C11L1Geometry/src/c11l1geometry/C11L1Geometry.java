
package c11l1geometry;
/**
 *
 * @author corinnekinzy CPSC 5000-0 CRN22404 C8-11 L4 3/22/21
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author corinnekinzy
 */
public class C11L1Geometry {

    public static void main(String[] args) throws FileNotFoundException {
        
        // tests for the Triangle and Ellipse Classes!
        Triangle testTri = new Triangle();
        
        testTri.base = 5;
        testTri.height = 6;
        testTri.hypotenuse = 7;
        
        
        
        System.out.println(testTri.computePerimeter());
        
        Ellipse testEll = new Ellipse();

        
//      INPUT YOUR PATH HERE!! (No USB port so going to desktop!)
        String path = "/Users/corinnekinzy/Desktop/";
        
        String output_file = path + "geometry.txt";
        PrintWriter geo_out = new PrintWriter(output_file);
        
        // allows User to input the path to their file:
        testTri.readFile(path);
        testEll.readFile(path);
        
        // shows the final output in output pane and tests all the methods!
        System.out.printf("File - geometry.txt:");
        System.out.printf("\n" + "Triangle's perimeter = " + "%2.2f",testTri.computePerimeter());        
        System.out.printf("\n" + "Triangle's area = " + "%2.2f",testTri.computeArea());
        System.out.printf("\n" + "Ellipse's area = " + "%2.2f",testEll.computeArea());
        System.out.println();
                
        // writes final output to geometry.txt file!
        geo_out.printf("File - geometry.txt:");
        geo_out.printf("\n" + "Triangle's perimeter = " + "%2.2f",testTri.computePerimeter());        
        geo_out.printf("\n" + "Triangle's area = " + "%2.2f",testTri.computeArea());
        geo_out.printf("\n" + "Ellipse's area = " + "%2.2f",testEll.computeArea());
        geo_out.close();
        
    }
    
}
