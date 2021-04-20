package titansproject;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

/**
 *
 * @author evadoyle
 * Notes for 4/20 - 
 * changed initial user menu to case statements
 * took code from previous if statements and created loadUser and createUser in User class
 * added a "default" method in both switch menus in case user presses anything besides menu options
 * added more patter when the user leaves the system 
 * 
 */
public class TitansProject {

    public static void main(String[] args) throws FileNotFoundException {
        
        
        //Initial user interaction statements
        System.out.println("******  You are about to enter the World of the Underdark Knights ******");
        System.out.println("        Are you ready to create your characters??");
        System.out.println("        To begin, Create or Load User Account!\n");
        System.out.println("Select an item below to get to the character creating options!");
        System.out.println("We don't let just anyone in.");
        System.out.print("\n 1 - Create User Account \n 2 - Load User Account \n 3 - Exit \n");
        
        // initialize character and User
        Character charOne = new Character();
        User loginName = new User();
        
        //Capture user input - 1, 2, 3, 
        Scanner in = new Scanner(System.in);        
        String menuOption;
        menuOption = in.nextLine();
        
        switch (menuOption)   // must either create or load a user to continue to create a character
        {
            case("1"):
            loginName.createUser();
            break;
            
            case("2"):
            loginName.loadUser();
            break;
            
            case("3"):
            System.out.println("Whaa??  Nooooo.  We'll miss you.");
            return;
            
            default:  //catchall if user presses anything besides 1, 2, or 3.
            System.out.println("Hmmm.  Was that one of the choices? Really?");
        }//closes user menu switch
                
//Beginning of Character Menu and its control loop
                
                boolean gameOn = true;
                

                    System.out.println("********************************************************************");
                    System.out.println("Welcome to the Underdark Knights! ");
                    System.out.println("It's time to morph into one of our beings and leave your own body behind");
                    System.out.println("Mwah hah hah hah hah\n");
                    
                while (gameOn = true) {
                    System.out.println("Please select one of the following: ");
                    System.out.println(" 4 - Create Character \n 5 - Display Character");
                    System.out.println(" 6 - Save Character \n 7 - Load Character \n 8 - Exit *sniff* \n"  ); 

                    Scanner in3 = new Scanner(System.in);
                    String charMenu;
                    charMenu = in3.nextLine();


                    switch (charMenu) {
                        case "4":
                        charOne.createCharacter();
                        break;

                        case "5":
                        charOne.displayCharacter();
                        break;

                        case "6":
                            String outputFilePath=null;
                            Scanner charSave = new Scanner(System.in);
                            System.out.println("Please enter a file path to save your Character:" + "\n" +
                                    "example: /Users/corinnekinzy/Desktop/characterout.txt");
                            outputFilePath = charSave.nextLine();
                            PrintWriter charOut = new PrintWriter(outputFilePath);
                            charOne.saveCharacter(charOut);
                        break;

                        case "7":
                        charOne.loadCharacter();
                        break;

                        case "8":
                            System.out.println("Really?  You want to go?  You gotta better things to do? ");
                            System.out.println("Gonna watch some MST3K or something?");
                            System.out.println("Hmp.  Just come back soon.");
                            gameOn = false;
                            return;
                            
                        default: //catch all if user pressses anything except menu options
                            System.out.println("Gotta pick 4, 5, 6, 7, or 8, champ.\n");
                            break;
                            
                    }//closes character menu switch
                }//closes while loop
    }// closes main method
}// closes entire TitansProject class
//THE END