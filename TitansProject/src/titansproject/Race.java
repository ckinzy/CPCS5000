package titansproject;
import java.util.Scanner;
/**
 *
 * @author Hannah Phillips
 */

public class Race {
    //initializing instance variables
    private String race;
    private String gender;
    private int age;
    private int height; //inches
    private int weight; // lbs
    private int heightFeet;
    private int heightInches;
    
    //initializing scanners
    Scanner inputGender = new Scanner(System.in);
    Scanner inputRace = new Scanner(System.in);
    
    public Race() {
        //initializing instance variables inside constructor
        this.race=null;
        this.gender=null;
        this.height=height;
        this.weight=weight;
        this.age=age;
    }
    
    //using methods to create setters and getters
    public String getGender() {
        return gender;
    }
    
    public String getRace() {
        return race;
    }
    
     public int getAge() {
        return age;
    }
    
     //creating local variables to initialize min and max for each attribute
     //used Math.random to create a random number based on the min and max set
    public int setAge(int min, int max) {
        age = (int)Math.floor(Math.random()*(max-min+1)+min);
        return age;
    }
    
    public int getHeight() {
        return height;
    }
    
    public int getHeightFeet() {
        return heightFeet;
    }
    
    public int getHeightInches() {
        return heightInches;
    }
    
    //creating local variables to initialize min and max for each attribute
    //used Math.random to create a random number based on the min and max set
    //height is originally set in inches
    //then divided by 12 to get feet
    //the remainder is recorded with the modifier and set to the inches
    public int setHeight(int min, int max) {
        height = (int)Math.floor(Math.random()*(max-min+1)+min);
        heightFeet=(height/12);
        heightInches=(heightFeet%height);  
        return height;
    }
    
    public int getWeight() {
        return weight;
    }
    
    //creating local variables to initialize min and max for each attribute
    //used Math.random to create a random number based on the min and max set
    public int setWeight(int min, int max) {
        weight = (int)Math.floor(Math.random()*(max-min+1)+min);
        return weight;
    }
    
    //methods are created to generate each different race with their defined
    //mins and maxes
    public String generateHuman()
    {
        race = "Human";
        setAge(15,30);
        //if/else stmts are used to identify what parameters to go to based on 
        //gender decision
        if(gender.equals("male")) {
           setHeight(54,89);
           setWeight(90,260);
        }
        else 
            if(gender.equals("female")) {
            setHeight(52,79);
            setWeight(75,200);
            }
        return race;
    }
    
    public String generateElf()
    {
        race = "Elf";
        setAge(80,180);
        if(gender.equals("male")) {
           setHeight(48,58);
           setWeight(70,130);
        }
        else
            if(gender.equals("female")) {
                setHeight(44,64);
                setWeight(65,100); 
            }    
        return race;
    }
    
    public String generateDwarf()
    {
        race = "Dwarf";
        setAge(40,70); 
        if(gender.equals("male")){
           setHeight(48,58);
           setWeight(150,230);
        }
        else
            if(gender.equals("female")) {
                setHeight(44,35);
                setWeight(125,180);
            }    
        
        return race;        
    }
    
    public String generateGnome()
    {
        race = "Gnome";
        setAge(30,60);
        if(gender.equals("male"))
        {
           setHeight(30,41);
           setWeight(40,60);
        }
        else
            if(gender.equals("female")) {
                setHeight(28,39);
                setWeight(35,55);
            }
        return race;         
    }
    
    public String generateHalfling()
    {
        this.race = "Halfling";
        setAge(30,50);
        if(gender.equals("male"))
        {
           setHeight(38,51);
           setWeight(55,80);
        }
        else
            if(gender.equals("female")) {
                setHeight(35,49);
                setWeight(45,70);
            }
        return race;    
    }
    
    //method created to prompt the user to choose gender and race
    public void generateCharacterRace()
    {
        //used a while() loop to ask the user for choice again if they give 
        //the wrong option
        boolean chooseGender=false;
        while(chooseGender==false) 
        {
            System.out.println("\nWhat's your gender? (please enter the number option)");
            System.out.println("1 - male");
            System.out.println("2 - female");
            int choiceGender = inputGender.nextInt();    
            if(choiceGender==1) {
                chooseGender=true;    
                gender="male";
                break;
            }
                if(choiceGender==2) {
                    chooseGender=true;
                    gender="female";
                    break;
                }
            else
                System.out.println("*That is not an option for race. Please select 1 for male or 2 for female.");        
        }
                
        //used a while() loop to ask the user for choice again if they give 
        //the wrong option    
        boolean chooseRace=false;
        while(chooseRace==false){
        System.out.println("\nChoose your race: (please enter the number option)");
        System.out.println("1 - Human");
        System.out.println("2 - Elf"); 
        System.out.println("3 - Dwarf");
        System.out.println("4 - Gnome");
        System.out.println("5 - Halfling");
        int choiceRace = inputRace.nextInt();
        switch (choiceRace)
        {
            case 1: 
                generateHuman();
                chooseRace=true;
                break;
            case 2:
                generateElf();
                chooseRace=true;
                break;
            case 3:
                generateDwarf();
                chooseRace=true;
                break;
            case 4:
                generateGnome();
                chooseRace=true;
                break;
            case 5:
                generateHalfling();
                chooseRace=true;
                break; 
                
        }     
        if (choiceRace>5){
            System.out.println("*That is not an option for race. Please select a number listed.");
        }
        }
        displayRaceAttributes();
    
    }
    
    //display method created to home all the print statements
    //and let the user know how their attributes were generated
    public void displayRaceAttributes()
    {
        System.out.println("***You're race attributes(height/weight/age)***\n   are automatically generated based on your\n          gender and race choice.");
        System.out.println("\nYour gender is " + gender);
        System.out.println("You are a(n) "+race); 
        System.out.println("Your age is "+ age);
        System.out.println("Your height is "+ heightFeet + "ft. "+heightInches+"in.");
        System.out.println("Your weight is "+ weight);
    }
    
}
