package titansproject;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.PrintWriter;

/**
 *
 * @author corinnekinzy
 */
public class Character {
    private String name;
    private String gender;
    private String alignment;
    private String race;
    private int height;
    private int weight;
    private int age;
    Race raceObject;
    AbilityScore ability_score;
    
    Character() {
        
        //initialize vars
        name = null;
        gender = null;
        alignment = null;
        height = 0;
        weight = 0;
        age = 0;
        race = null;
        raceObject = new Race();
        ability_score = new AbilityScore();

    }
    
    /*
    -- displayCharacter() + other Character-Specific  -- 
    This method displays all of the characteristics of the final Character! Those
    characteristics being the contents of a Character Object. :)
     */
    public void displayCharacter() {
        System.out.println("\n" + "Here is your Character!");
        System.out.println("Character Name: " + name);
        System.out.println("Character Alignment: " + alignment);
        System.out.println("Character Race: " + race);
        System.out.println("Character Age: " + age);
        System.out.println("Character Height: " +
                raceObject.getHeightFeet() + "ft" + " " +
                raceObject.getHeightInches() + "in");
        System.out.println("Character Weight: " + weight + "lbs");
        System.out.println("Character Gender: " + gender);
        System.out.println("\n" + "Character Final Ability Scores:");
        ability_score.displayAbilityScores();

    }
    
    // generates a new Character
    public void createCharacter() {
        setCharName();
        setAlignment();
        generateAbilityScore();
        setRace();
    }
    
    // loads a character from a given file, will prompt the user for the file
    public void loadCharacter() {
        
        String inputFilePath=null;
        Scanner charLoad = new Scanner(System.in);
        System.out.println("Please enter a file path to your Character:" + "\n" +
                "example: /Users/corinnekinzy/Desktop/character.txt");
        inputFilePath = charLoad.nextLine();
        
        try 
        {
            // Read from the input file and put in scanner and initialize array 
            FileReader character_specs = new FileReader(inputFilePath);
            Scanner input_scanner = new Scanner(character_specs);
            String[] input_array = new String[13];

            while (input_scanner.hasNextLine()) {
                // fill in the array with the values from the Scanner
                for (int i=0;i<13;i++) {
                    input_array[i] = input_scanner.nextLine();
                }

            }

            // stores the values from the array into the instance vars
            this.name = input_array[0].substring(16);
            
            this.alignment = input_array[1].substring(21);
            
            int strength = Integer.parseInt(input_array[2].substring(16));
            ability_score.setStrengthScore(strength);
            
            int constitution = Integer.parseInt(input_array[3].substring(20));
            ability_score.setConstitutionScore(constitution);
            
            int intelligence = Integer.parseInt(input_array[4].substring(20));
            ability_score.setIntelligenceScore(intelligence); 
            
            int wisdom = Integer.parseInt(input_array[5].substring(14));
            ability_score.setWisdomScore(wisdom);
            
            int charisma = Integer.parseInt(input_array[6].substring(16));
            ability_score.setCharismaScore(charisma);
            
            int dexterity = Integer.parseInt(input_array[7].substring(17));
            ability_score.setDexterityScore(dexterity);
            
            this.race = input_array[8].substring(16);
            
            this.age = Integer.parseInt(input_array[9].substring(15));
            
            this.height = Integer.parseInt(input_array[10].substring(18));
            
            this.weight = Integer.parseInt(input_array[11].substring(18));
            
            this.gender = input_array[12].substring(18);


        }
        // if we can't find the file...
        catch(FileNotFoundException ex) {
            System.out.println("We couldn't find your file! Check the file name and path :)" + ex.getMessage());
        }
        
    }
    
    //writes a character to a file
    public void saveCharacter(PrintWriter charOut) {

        charOut.println("Character Name: " + name);
        charOut.println("Character Alignment: " + alignment);
        charOut.println("Strength Score: " + ability_score.getStrengthScore());
        charOut.println("Constitution Score: " + ability_score.getConstitutionScore());
        charOut.println("Intelligence Score: " + ability_score.getIntelligenceScore());
        charOut.println("Wisdom Score: " + ability_score.getWisdomScore());
        charOut.println("Charisma Score: " + ability_score.getCharismaScore());
        charOut.println("Dexterity Score: " + ability_score.getDexterityScore());
        charOut.println("Character Race: " + race);
        charOut.println("Character Age: " + age);
        charOut.println("Character Height: " + height);
        charOut.println("Character Weight: " + weight);
        charOut.println("Character Gender: " + gender);        
        charOut.close();
    }
    

    private void setCharName() {
        Scanner charInput = new Scanner(System.in);
        System.out.println("Please enter a name for your Character:");
        
        this.name = charInput.nextLine();
        
    }
    
    
    public String getAlignment() {
        
        if (alignment == null)
            System.out.println("Please utilize the setAlignment method");

        return alignment;
    }
    
    // allows user to choose which alignment
    private void setAlignment() {
        Scanner alignmentInput = new Scanner(System.in);
        int alignChoice = 0;
        
        System.out.println("Please choose your character's alignment from the list:" + 
                "\n" + "1 - Lawful Good" + 
                "\n" + "2 - Lawful Evil" +
                "\n" + "3 - Neutral Good" +
                "\n" + "4 - Neutral Evil" +
                "\n" + "5 - Chaotic Good" +
                "\n" + "6 - Chaotic Evil" + "\n");
        
        alignChoice = alignmentInput.nextInt();
        
        switch (alignChoice) {
            case 1:
                this.alignment = "Lawful Good";
                break;
            case 2: 
                this.alignment = "Lawful Evil";
                break;
            case 3:
                this.alignment = "Neutral Good";
            case 4:
                this.alignment = "Neutral Evil";
            case 5:
                this.alignment = "Chaotic Good";
                break;
            case 6:
                this.alignment = "Chaotic Evil";
                break;
                
        }

    }
  
    
    /*
    -- generateAbilityScore() -- 
    This method takes user-input for how to generate ability scores for a Character
    then allows the user to select from a list of scores that were generated to
    determine which values should be assigned to which scores. This method is 
    dependant upon the AbilityScore Class.
     */
    public void generateAbilityScore() {
        
        ability_score.generateAbilityScore();
        ability_score.assignCharismaScore();
        ability_score.assignConstitutionScore();
        ability_score.assignDexterityScore();
        ability_score.assignIntelligenceScore();
        ability_score.assignStrengthScore();
        ability_score.assignWisdomScore();
        ability_score.displayAbilityScores();
        System.out.println("\n" + 
                "These Ability Scores will be modified after choosing the race" +
                "\n");
        
    }
    
    
    /*
    -- setRace() + other Race-Specific Methods -- 
    Below are the methods that are dependant upon the Race Class. the setRace() 
    method in particular utilizses the generateCharacterRace() from the Race Class
    in order to create the Race for our Character. The getters below are also used
    to grab variables needed to define our final Character. There is one additional 
    method in the setRace() method that is dependant upone the AbilityScore Class.
     */
    public void setRace() {
        raceObject.generateCharacterRace();
        setRaceVar();
        setGender();
        setHeight();
        setWeight();
        setAge();
        
        if (race != null)
            ability_score.raceScoreUpdate(race);
        else
            System.out.println("Race has not been set!");
    }
    
    public String setGender() {
        this.gender = raceObject.getGender();
        return gender;
    }
    
    public void setRaceVar() {
        this.race = raceObject.getRace();
    }
        
    public int setHeight() {
        // all in inches
        this.height = raceObject.getHeight();
        
        return height;
    }
    
    
    public int setWeight() {
        this.weight = raceObject.getWeight();
        
        return weight;
    }
    
    public int setAge() {
        this.age = raceObject.getAge();
        
        return age;
    }
    
    
}
