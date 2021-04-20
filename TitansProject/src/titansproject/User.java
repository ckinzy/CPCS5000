package titansproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author evadoyle
 */
public class User {
    //instance vars
    private String name;
    private String password;
    private String email;
    
    //constructor
   public User()
   {
    name = null;
    password = null;
    email = null;
   }// closes constructor
   
   //methods
   
   //getters and setters 
   public String getName()
   {
       return name;
   }//closes method getName
   //~~~~~~~~~~~~~~~~~~~~
   public void setName(String newName)
   {
       this.name = newName;
   }
    //~~~~~~~~~~~~~~~~~~~~
    public String getPassword()
   {
       return password;
   }
    //~~~~~~~~~~~~~~~~~~~~
     public void setPassword(String newPword)
   {
       this.password = newPword;
   }
   //~~~~~~~~~~~~~~~~~~~~
      public String getEmail()
   {
       return email;
   }
    //~~~~~~~~~~~~~~~~~~~~
     public void setEmail(String newEmail)
   {
       this.email = newEmail;
   }
     
   //write to file - called in method createUser below - writes name, password, e-mail
    public void writeUserName()
    {
            try {
                 //create my output file  
                    PrintWriter myOut = null;
                    myOut = new PrintWriter(new File("UserInfo.txt"));
                    //myOut.write("This is the UserInfo.txt file\n");
                    myOut.printf("User name: " + name);
                    myOut.println();
                    myOut.printf("Password:  "  + password);
                    myOut.println();
                    myOut.printf("Email: " + email);
                    myOut.close();
                }//close try
            catch (FileNotFoundException err)  
                    {
                        System.out.println("WhoopsUserWriteToFile");
                        err.printStackTrace();
                    }//close catch   
        }// close WriteUserName
    
    //reads the information stored in the writeUserName method; used in the loadUser method.
     public void readFile(String myTxtFile)
    {
      try {
        File inputUser = new File(myTxtFile); // put it in same directory with other files 
        Scanner info = new Scanner(inputUser);
       
        while (info.hasNextLine())
            {
                  name = info.nextLine();
                  password = info.nextLine();
                  email = info.nextLine();
                  
                  //have gotten what I need from the text file for the other methods - don't need anything else here
            } //close while loop
            
        } //close try   
          catch (FileNotFoundException err)  
            {
             System.out.println("WhoopsReadUserFile");
             err.printStackTrace();
            }//close catch  
            
    }// closes readFile method  */
    
    public void createUser() //called in menu option 1 in main class
    {
        System.out.println("Aha!  You want to create a user account, do you?!");
                System.out.println("Well, all right. Let's get started with some basics.");
                System.out.println("\nPlease enter a user name.  One word will do it.");
                User loginName = new User(); 
                Scanner in2 = new Scanner(System.in);
                String userName;
                userName = in2.nextLine();
                //User loginName = new User(); 
                loginName.setName(userName);
                
                System.out.println("\nEnter your password: ");
                String userPword;
                userPword = in2.nextLine();
                loginName.setPassword(userPword);
                
                System.out.println("\nEnter your e-mail: ");
                String userEmail;
                userEmail = in2.nextLine();
                loginName.setEmail(userEmail);
                
                System.out.println("\nEnter your bank account :");
                System.out.println("Just kidding, it doesn't do any good without the routing number.");
                
                //method to write to file - put in User class since needs to happen for each User object 
                loginName.writeUserName();
    }//closes createUser()
     
    public void loadUser() // used in menu option 2 in main class
    {
         System.out.println("We gotta make sure it's you.");
               User comingBack = new User();
               comingBack.readFile("UserInfo.txt");
               System.out.println("According to our records, you are: \n" + comingBack.getName());
               System.out.println("Your password is - ha ha ha we are not crazy " + "- we're not displaying that...");
               System.out.println("Your e-mail address is: \n" + comingBack.getEmail());
    }//closes loadUser()
     
     
     
}// closes class User
