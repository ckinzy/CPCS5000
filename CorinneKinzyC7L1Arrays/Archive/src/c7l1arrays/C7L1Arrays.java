/*
 * @author corinnekinzy CPSC 5000-0 CRN22404 C6-7 L2 3/7/21
 */
package c7l1arrays;
import java.util.Random;
/**
 *
 * @author corinnekinzy
 */
public class C7L1Arrays {


    public static void main(String[] args) {
        
        //New random number generator
        Random numbers = new Random();
        
        // initialize variables for loops
        int index = 0;
        int start = 0;
        int end = 20;
        
        // new empty array for initialization with 20 total elements
        int[] randomNumberList = new int[20];

        
        /*
        Fill the empty array with random numbers and display a title
        */
        System.out.println("20 random numbers");
        
        for (int i=start; i<end; i++)
        {
            //Fill the empty list with random numbers between 0 and 100 inclusive
            randomNumberList[index++] = numbers.nextInt(101);
            
            System.out.print(randomNumberList[i] + " ");
        }

        
        /*
        Find every even value from the array we just generated and display the array long with the title
        */
        System.out.println("\n" + "\n" + "Every even value");
        
        for (int i=start; i<end; i++)
        {
            // if there is no remainder when divided by 2, then it is even and we want it!
            if (randomNumberList[i] % 2 == 0) {
                System.out.print(randomNumberList[i] + " ");
            } 
           
        }
        
        
        /* 
        Find every odd index element from the array and display the array along with the title
        */
        System.out.println("\n" + "\n" + "Every odd index element");
        
        for (int i=start+1; i<end; i++)
        {
            // if there is a remainder when dividing by 2 then we want it here!
            if (i % 2 != 0)
            {
                System.out.print(randomNumberList[i] + " ");
            }
        }
        
        
        /*
        Reverse all of the elements from the array and display them along with a title
        */
        System.out.println("\n" + "\n" + "All elements in reverse order");
        
        for (int i=end-1; i>start-1; i--)
        {
            System.out.print(randomNumberList[i] + " ");
        }
        
        
        /*
        Pull every third element from the array and sum them together with a title!
        */
        System.out.println("\n" + "\n" + "Sum of every third element");
        
        //initialize the sum variable 
        int sum_third_element = 0;
        
        // indexing only for every third element
        for (int i=start+2; i<end; i+=3)
        {
            System.out.print(randomNumberList[i] + " ");
            // add the new value to the previous value
            sum_third_element = sum_third_element + randomNumberList[i];

        }
        System.out.print("= " + sum_third_element + "\n");

    }
    
}
