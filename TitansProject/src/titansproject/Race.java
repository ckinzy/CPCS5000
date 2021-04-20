package titansproject;
import java.util.Scanner;
/**
 *
 * @author Hannah Phillips
 */

public class Race{
    private String race;
    private String gender;
    private int age;
    private int height; //inches
    private int weight; // lbs
    private int heightFeet; //I have to have these as global to put them in print statements
    private int heightInches;
    
    Scanner input = new Scanner(System.in);
    
    public Race(){
        this.race=null;
        this.gender=null;
        this.height=height;
        this.weight=weight;
        this.age=age;
    }
    
    public String getGender()
    {
        return gender;
    }
    
    public String getRace() {
        return race;
    }
    
     public int getAge() {
        return age;
    }
    
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
    
    public int setHeight(int min, int max) {
        height = (int)Math.floor(Math.random()*(max-min+1)+min);
        heightFeet=(height/12);
        heightInches=(heightFeet%height);  
        return height;
    }
    
    public int getWeight() {
        return weight;
    }
    
    public int setWeight(int min, int max) {
        weight = (int)Math.floor(Math.random()*(max-min+1)+min);
        return weight;
    }
    
    public String generateHuman()
    {
        race = "Human";
        setAge(15,30);
        if(gender.compareTo("male") == 0)
        {
           setHeight(54,89);
           setWeight(90,260);
        }
        else 
        {
            setHeight(52,79);
            setWeight(75,200);
            }
        return race;
    }
    
    public String generateElf()
    {
        race = "Elf";
        setAge(80,180);
        if(gender.compareTo("male") == 0)
        {
           setHeight(48,58);
           setWeight(70,130);
        }
        else
           setHeight(44,64);
           setWeight(65,100); 
        return race;
    }
    
    public String generateDwarf()
    {
        race = "Dwarf";
        System.out.println("You are a(n) "+race);
        setAge(40,70); 
        if(gender.compareTo("male") == 0)
        {
           setHeight(48,58);
           setWeight(150,230);
        }
        else
           setHeight(44,35);
           setWeight(125,180);
        
        return race;        
    }
    
    public String generateGnome()
    {
        race = "Gnome";
        setAge(30,60);
        System.out.println("gender is" + gender);
        if(gender.compareTo("male") == 0)
        {
           setHeight(30,41);
           setWeight(40,60);
        }
        else
           setHeight(28,39);
           setWeight(35,55);
        return race;         
    }
    
    public String generateHalfling()
    {
        this.race = "Halfling";
        setAge(30,50);
        if(gender.compareTo("male") == 0)
        {
           setHeight(38,51);
           setWeight(55,80);
        }
        else
           setHeight(35,49);
           setWeight(45,70);
        return race;    
    }
    
    public void generateCharacterRace()
    {
        System.out.println("\nWhat's your gender?");
        System.out.println("male or female?");
        this.gender = input.next();
                
        
        System.out.println("\nChoose your race: (please enter the number option)");
        System.out.println("1 - Human");
        System.out.println("2 - Elf");
        System.out.println("3 - Dwarf");
        System.out.println("4 - Gnome");
        System.out.println("5 - Halfling");
        int choice = input.nextInt();              
        
        switch (choice)
        {
            case 1: 
                generateHuman();
                break;
            case 2:
                generateElf();
                break;
            case 3:
                generateDwarf();
                break;
            case 4:
                generateGnome();
                break;
            case 5:
                generateHalfling();
                break;
            
        }        
    }
    
}

