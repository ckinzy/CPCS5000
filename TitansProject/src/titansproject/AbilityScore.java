package titansproject;


//Import Scanner class
import java.util.Scanner;
//Import Random class to generate random numbers 
import java.util.Random;
//Import ArrayList class
import java.util.ArrayList;
//Import Collections class to sort ArrayList
import java.util.Collections;

/**
 * @author Kyle Ford
 */
public class AbilityScore {
    
    //Instantiate instance variables
    private int strengthScore;
    private int dexterityScore;
    private int constitutionScore;
    private int intelligenceScore;
    private int wisdomScore;
    private int charismaScore;
    private ArrayList<Integer> choiceHolder;
    private ArrayList<Integer> bestOfFive;
    
    public AbilityScore() {
        
        //Initialize instance variables inside constructor
        this.strengthScore = 0;
        this.dexterityScore = 0;
        this.intelligenceScore = 0;
        this.wisdomScore = 0; 
        this.charismaScore = 0;
        choiceHolder = new ArrayList<Integer>();
        bestOfFive = new ArrayList<Integer>();
    }
        
        public void generateAbilityScore()
        {
            int sum = 0;
            Scanner input = new Scanner(System.in);
            
            //Display menu asking the user to select which of the 3 methods are to be used to calculate ability score
            System.out.println("Select method to generate ability scores:");
            System.out.println("1 - Sum of 3 6 sided dice rolls");
            System.out.println("2 - Sum of best 3 of 5 6 sided dice rolls");
            System.out.println("3 - Sum of best 3 of 5 6 sided dice rolls + 1 3 sided dice roll");
            
            //casting user input to an integer
            int choice = input.nextInt();
            
            //User has opted to use method 1. 
            if (choice == 1)
            {
                for (int i=0; i<6; i++)
                {
                    //Create 3 random numbers between 1 and 6 and cast each to type int
                    Random num1 = new Random();
                    int n1 = num1.nextInt(6)+1;
                    Random num2 = new Random();
                    int n2 = num2.nextInt(6)+1;
                    Random num3 = new Random();
                    int n3 = num3.nextInt(6)+1;
                    //set sum = the sum of our 3 randomly generated numbers
                    sum = (n1+n2+n3);
                    //Add the sum value to our choiceHolder ArrayList so user can set ability scores later. 
                    choiceHolder.add(sum);
                }
            }
            
            //User has opted to use method 2
            if (choice == 2)
            {
                for (int i=0; i<6; i++)
                {
                    //create 5 random numbers between 1 and 6 and cast them as type int. 
                    Random num1 = new Random();
                    int n1 = num1.nextInt(6)+1;
                    Random num2 = new Random();
                    int n2 = num1.nextInt(6)+1;
                    Random num3 = new Random();
                    int n3 = num3.nextInt(6)+1;
                    Random num4 = new Random();
                    int n4 = num4.nextInt(6)+1;
                    Random num5 = new Random();
                    int n5 = num5.nextInt(6)+1;
                    //add these 5 randomly generated integers to our bestOfFive ArrayList. We select the 3 largest numbers in this set. 
                    bestOfFive.add(n1);
                    bestOfFive.add(n2);
                    bestOfFive.add(n3);
                    bestOfFive.add(n4);
                    bestOfFive.add(n5);
                    //Use Collections method to sort our ArrayList in descending order
                    Collections.sort(bestOfFive, Collections.reverseOrder());
                    //add the 3 largest integers to our sum variable
                    sum = bestOfFive.get(0)+bestOfFive.get(1)+bestOfFive.get(2);
                    //add the sum value to our choiceHolder ArrayList for user to assign ability scores from. 
                    choiceHolder.add(sum); 
                }
            }
            
            //User has selected method 3. 
            if (choice == 3)
            {
                for (int i=0; i<6; i++)
                {
                    //Create 5 random numbers between 1 and 6 and 1 random number between 1 and 3 and cast them to type int. 
                    Random num1 = new Random();
                    int n1 = num1.nextInt(6)+1;
                    Random num2 = new Random();
                    int n2 = num1.nextInt(6)+1;
                    Random num3 = new Random();
                    int n3 = num3.nextInt(6)+1;
                    Random num4 = new Random();
                    int n4 = num4.nextInt(6)+1;
                    Random num5 = new Random();
                    int n5 = num5.nextInt(6)+1;
                    Random num6 = new Random();
                    int n6 = num6.nextInt(3)+1;
                    //Add our random numbers between 1 and 6 to our bestOfFive ArrayList. 
                    bestOfFive.add(n1);
                    bestOfFive.add(n2);
                    bestOfFive.add(n3);
                    bestOfFive.add(n4);
                    bestOfFive.add(n5);
                    //Sort bestOfFive in descending order so we know where the largest values are. 
                    Collections.sort(bestOfFive, Collections.reverseOrder());
                    //set sum equal to the sum of the 3 largest values in bestOfFive + our random integer 1-3.
                    sum = (bestOfFive.get(0)+bestOfFive.get(1)+bestOfFive.get(2)+n6);
                    //Add this value to our choiceHolder ArrayList for user to assign ability scores from. 
                    choiceHolder.add(sum);
                }
            }
            
            //If statement in case user enters a value that is not 1-3 to display that he has not selected the correct value and to try again. 
            if (choice > 3 || choice < 1)
                System.out.println("That was not one of the choices. Try again and select method 1, 2, or 3");  
        }
        
        public void assignStrengthScore()
        {
            //instantiate boolean value choose to control while loop logic
            boolean choose = false;
            while (choose == false)
            {
                //print out the available scores for user to assign
                System.out.println("\n*Ability scores to assign*");
                for (int i=0; i<choiceHolder.size(); i++)
                {
                    if ((i+1) == choiceHolder.size())
                        System.out.println(choiceHolder.get(i));
                    else
                        System.out.print(choiceHolder.get(i)+" , ");
            }
            
            {
                //ask user to select strength score
                System.out.println("\nSelect strength score");
                Scanner str = new Scanner(System.in);
                int strSelect = str.nextInt();
                //if user input value is an option, assign that value to strengthScore, remove the value from our ArrayList, and exit while loop
                for (int i=0; i<choiceHolder.size(); i++)
                {
                    if (choiceHolder.get(i) == strSelect)
                    {
                        strengthScore = choiceHolder.get(i);
                        choiceHolder.remove(i);
                        choose = true;
                        break;
                    }
                }
                //Indicates user input was not an option and asks user to try again
                if (strengthScore == 0)
                    System.out.println("That was not one of the choices, please try again.");
                
                }
            }
        }
        public void assignDexterityScore()
        {
            //instantiate boolean value choose to control while loop logic
            boolean choose = false;
            while (choose == false)
            {
                //print out available scores for user to assign 
                System.out.println("\nAbility scores to assign");
                for (int i=0; i<choiceHolder.size(); i++)
                {
                    if ((i+1) == choiceHolder.size())
                        System.out.println(choiceHolder.get(i));
                    else
                        System.out.print(choiceHolder.get(i)+" , ");
                }
                //ask the user to select a value for dexterityScore
                System.out.println("\nSelect dexterity score");
                Scanner dex = new Scanner(System.in);
                int dexSelect = dex.nextInt();
                //if input value is an option, assign value to dexterityScore, remove value from list, and exit the while loop
                for (int i=0; i<choiceHolder.size(); i++)
                {
                    if (choiceHolder.get(i) == dexSelect)
                    {
                        dexterityScore = choiceHolder.get(i);
                        choiceHolder.remove(i);
                        choose = true;
                        break;
                    }    
                }
                //indicates user input was not an option and asks user to try again
                if (dexterityScore == 0)
                    System.out.println("That is not an ability score to assign, try again");
            }
        }
        public void assignConstitutionScore()
        {
            //Display remaining ability scores to assign. 
            System.out.println("\nAbility scores to assign");
            for (int i=0; i<choiceHolder.size(); i++)
            {
                if ((i+1) == choiceHolder.size())
                    System.out.println(choiceHolder.get(i));
                else
                    System.out.print(choiceHolder.get(i)+" , ");
            }
            
            //ask user to select a value for constitution score
            System.out.println("\nSelect constitution score");
            Scanner con = new Scanner(System.in);
            int conSelect = con.nextInt();
            int found = 0;
            //If input value is one of the choices remaining, set constitutionScore to that value and remove value from remaining choices. 
            for (int i=0; i<choiceHolder.size(); i++)
            {
                if (choiceHolder.get(i) == conSelect)
                {
                    constitutionScore = choiceHolder.get(i);
                    choiceHolder.remove(i);
                    found++;
                    break;
                }    
            }
            //If statement indicating input value is not a choice and to try again. 
            if (found == 0)
                System.out.println("That is not an ability score to assign, try again");
        }
        
        public void assignIntelligenceScore()
        {
            //instantiate boolean value choose to control while loop logic
            boolean choose = false;
            while (choose == false)
            {
                //print out all available scores for user to assign
                System.out.println("\nAbility scores to assign");
                for (int i=0; i<choiceHolder.size(); i++)
                {
                    if ((i+1) == choiceHolder.size())
                        System.out.println(choiceHolder.get(i));
                    else
                        System.out.print(choiceHolder.get(i)+" , ");
                }
            
                System.out.println("\nSelect intelligence score");
                Scanner inte = new Scanner(System.in);
                int intSelect = inte.nextInt();
                //if input value is an option, assign value to intelligenceScore, remove value from list, and exit while loop
                for (int i=0; i<choiceHolder.size(); i++)
                {
                    if (choiceHolder.get(i) == intSelect)
                    {
                        intelligenceScore = choiceHolder.get(i);
                        choiceHolder.remove(i);
                        choose = true;
                        break;
                    }    
                }
                //indicates user input was not an option and asks user to try again
                if (intelligenceScore == 0)
                    System.out.println("That is not an ability score to assign, try again");
            }
        }
        public void assignWisdomScore()
        {
            //instantiate boolean value choose to control while loop logic
            boolean choose = false;
            while (choose == false)
            {
                //display available scores for user to assign
                System.out.println("\nAbility scores to assign");
                for (int i=0; i<choiceHolder.size(); i++)
                {
                    if ((i+1) == choiceHolder.size())
                        System.out.println(choiceHolder.get(i));
                    else
                        System.out.print(choiceHolder.get(i)+" , ");
                }
            
                System.out.println("\nSelect wisdom score");
                Scanner wis = new Scanner(System.in);
                int wisSelect = wis.nextInt();
                //if user input is an option, assign value to wisdomScore, remove value from list, and exit while loop
                for (int i=0; i<choiceHolder.size(); i++)
                {
                    if (choiceHolder.get(i) == wisSelect)
                    {
                        wisdomScore = choiceHolder.get(i);
                        choiceHolder.remove(i);
                        choose = true;
                        break;
                    }    
                }
                //indicates user input was not an option and asks the user for a new value
                if (wisdomScore == 0)
                    System.out.println("That is not an ability score to assign, try again");
            }
        }
        public void assignCharismaScore()
        {
            //boolean value to control while loop logic
            boolean choose = false;
            while (choose == false)
            {
                //print all available scores for user to assign
                System.out.println("\nAbility scores to assign");
                for (int i=0; i<choiceHolder.size(); i++)
                {
                    if ((i+1) == choiceHolder.size())
                        System.out.println(choiceHolder.get(i));
                    else
                        System.out.print(choiceHolder.get(i)+" , ");
                }
            
                System.out.println("\nSelect charisma score");
                Scanner cha = new Scanner(System.in);
                int chaSelect = cha.nextInt();
                //if user input value is an option, assign value to charismaScore, remove value from list, and exit while loop
                for (int i=0; i<choiceHolder.size(); i++)
                {
                    if (choiceHolder.get(i) == chaSelect)
                    {
                        charismaScore = choiceHolder.get(i);
                        choiceHolder.remove(i);
                        choose = true;
                        break;
                    }    
                }
                //indicates user input was not an option and asks the user to try again
                if (charismaScore == 0)
                    System.out.println("That is not an ability score to assign, try again");
            }
        }
        public void displayAbilityScores()
        {
            //Displays all ability scores using println statements. 
            System.out.println("Strength score: "+strengthScore);
            System.out.println("Dexterity score: "+dexterityScore);
            System.out.println("Constitution score: "+constitutionScore);
            System.out.println("Intelligence score: "+intelligenceScore);
            System.out.println("Wisdom score: "+wisdomScore);
            System.out.println("Charisma score: "+charismaScore);
            
        }
        
        
        // setters and getters for the Ability Score
        public int getStrengthScore() {
            return strengthScore;
        }
        
        public int getDexterityScore() {
            return dexterityScore;
        }
        
        public int getConstitutionScore() {
            return constitutionScore;
        }
        
        public int getIntelligenceScore() {
            return intelligenceScore;
        }
        
        public int getWisdomScore() {
            return wisdomScore;
        }
        
        public int getCharismaScore() {
            return charismaScore;
        }
        
        public void setStrengthScore(int strength) {
            this.strengthScore = strength;
        }
        
        public void setDexterityScore(int dexterity) {
            this.dexterityScore = dexterity;    
        }
        
        public void setConstitutionScore(int constitution) {
            this.constitutionScore = constitution;
        }
        
        public void setIntelligenceScore(int intelligence) {
            this.intelligenceScore = intelligence;
        }
        
        public void setWisdomScore(int wisdom) {
            this.wisdomScore = wisdom;
        }
        
        public void setCharismaScore(int charisma) {
            this.charismaScore = charisma;
        }
        
        
        public void raceScoreUpdate(String race)
        {
            if (race.equals("Elf"))
            {
                dexterityScore = dexterityScore + 2;
                intelligenceScore = intelligenceScore + 2;
                constitutionScore = constitutionScore - 2;
            }
            else
            {   if (race.equals("Dwarf"))
                {
                    strengthScore = strengthScore + 2;
                    constitutionScore = constitutionScore + 2;
                    charismaScore = charismaScore - 2;
                }
                else
                {
                    if (race.equals("Gnome"))
                    {
                        dexterityScore = dexterityScore + 2;
                        constitutionScore = constitutionScore + 2;
                        strengthScore = strengthScore - 2;
                    }
                    else
                    {
                        if(race.equals("Halfling"))
                        {
                            dexterityScore = dexterityScore + 2;
                            wisdomScore = wisdomScore + 2;
                            strengthScore = strengthScore - 2;
                        }
                    }
                }
            }
            System.out.println("As a result of your choice of race, your ability scores have been updated: ");
            displayAbilityScores();
        }
}