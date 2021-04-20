/*
 * @author corinnekinzy CPSC 5000-0 CRN22404 C4-5 L2 2/22/21
 */
package c5l1compare;

import java.util.Scanner;

/**
 *
 * @author corinnekinzy
 */
public class Options {
    //Instance Variables
    private int user_selection;
    private Scanner scan_input = new Scanner(System.in);
    
    //Constructor Method
    public Options(){
        //Only publicly accessible variable
        user_selection = 1;
        
    }
    
    // Requests input from the User through the scanner and stores to user_selection
    public void getInput(){
            
        
        System.out.println("Compare options"+ " \n" +
            "1 - Compare numbers" + " \n" +
            "2 - Compare quotes" + " \n" + 
            "3 - Compare strings" + " \n" +
            "Make your selection :");
        
        //scans for the next integer given and stores it for later
        this.user_selection = scan_input.nextInt();
        
    }

        

    //get the UserSelection for an object
    public int getUserSelection(){
        
        return user_selection;
    
    }
    
    
    // Determines the next options for the user from a given selection    
    public void getNextOptions(int user_selection) {
    //Seperating these options out for flexibility later
    this.user_selection = user_selection;
    
        switch(user_selection) {
            // If they selected option 1, then call the NumbersOption method
            case 1: 
            {
                NumbersOption();
                break;
            }
        
            //If they selectioned option 2, then call the QuotesOption menthod
            case 2: 
            {
                QuotesOption();
                break;
            }
        
            // If they selected option 3, then call the StringsOption method
            case 3: 
            {
                StringsOption();
                break;
            }
                
        }
    }


    
    //What happens if the Numbers Option is selected
   public void NumbersOption() {
        
       // initialize variables
       double numbers_input1 = 0;
       double numbers_input2 = 0;

       
       //Collects the first number from the user and stores as type double
       System.out.println("Please enter your first number: ");
       numbers_input1 = scan_input.nextDouble();

        
        //Collects the second number from the user and stores as type double
        System.out.println("Please enter your second number: ");
        numbers_input2 = scan_input.nextDouble(); 
        

        // if the numbers are equal, let the user know
        if (numbers_input1 == numbers_input2)
            System.out.println(numbers_input1 + " is equal to " + numbers_input2);  

        // if the number1 is greater than number2, let the user know    
        if (numbers_input1 > numbers_input2)
            System.out.println(numbers_input1 + " is greater than " + numbers_input2);
        
        // if the number1 is less than number2, let the user know
        if (numbers_input1 < numbers_input2) 
            System.out.println(numbers_input1 + " is less than " + numbers_input2);
        
        }
   
   
   //What happens if the QuotesOption was selected
   public void QuotesOption() {
       
       //initialize the variables for QuotesOption method
       String quotes_input1 = null;
       String quotes_input2 = null;
       scan_input.nextLine();
       
       //Collects the first quote from the user and stores as type String
       System.out.println("Please enter your first quote: ");
       quotes_input1 = scan_input.nextLine();

        
        //Collects the second quote from the user and stores as type String
        System.out.println("Please enter your second quote: ");
        quotes_input2 = scan_input.nextLine(); 
        
        //Compare the two quotes!
        // If quote 1 and 2 are identical, let the user know
        if (quotes_input1.compareTo(quotes_input2) == 0) 
            System.out.println(quotes_input1 + " \n" + "DOES EQUAL" + " \n" + quotes_input2);
        
        // If they are not equal then let the user know
        else
            System.out.println(quotes_input1 + " \n" + "DOES NOT EQUAL" +" \n" + quotes_input2);
        
   }
   
   
   //What happens if the StringsOption was selected
   public void StringsOption() {
       
       String string_input1 = null;
       String string_input2 = null;
       scan_input.nextLine();

       //Collects the first string from the user and stores as type String
       System.out.println("Please enter your first string: ");
       string_input1 = scan_input.nextLine();
       
       System.out.println("Please enter your second string: ");
       string_input2 = scan_input.nextLine();
           
        // If the strings equal each other, let the user know
        if (string_input1.compareTo(string_input2) == 0) 
            System.out.println(string_input1 + " and " + string_input2 + " are equal.");
        
        // If string1 comes before string2, let the user know
        if (string_input1.compareTo(string_input2) < 0)
            System.out.println(string_input1 + " comes before " + string_input2);
       
        // If string1 comes after string2, let the user know
        if (string_input1.compareTo(string_input2) > 0)
            System.out.println(string_input1 + " comes after " + string_input2);
       
    }
        
        
    }
