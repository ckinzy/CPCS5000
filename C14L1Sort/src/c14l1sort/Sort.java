package c14l1sort;

/**
 *
 * @author corinnekinzy CPSC 5000-0 CRN22404 C14 L5 4/14/21
 */
public class Sort {
    // instance variables
    public int[] arrayOriginal;
    public int[] arrayAscending;
    public int[] arrayDescending;
    
    
    Sort(int[] array) {
        // assign the user-given array as "arrayOriginal" and instantiate 2 other arrays
        this.arrayOriginal = array;
        this.arrayAscending = new int[20];
        this.arrayDescending = new int[20];
    }
    
    
    
    // Method to print out a given array 
    public void display(int inputArray[]) {
        
        for (int k=0;k<20;k++) {
            System.out.print(inputArray[k] + " ");
            }
        
        System.out.println();
    }
    
    
    // method to sort the Original Array in ascending order
    public int[] ascending() {
        int element1 = 0;
        int element2 = 0;
        int placeHolder = 0;
        int loopCount = 0;

        
        // makes a copy of the original array as "arrayAscending"
        for (int i=0;i<20;i++) {
            arrayAscending[i] = this.arrayOriginal[i];
        }


        while (loopCount < 20) {
            
            for (int i=0;i<19;i++) {
                element1 = arrayAscending[i];
                element2 = arrayAscending[i+1];

                if (element2 < element1) {
                    placeHolder = element1;
                    arrayAscending[i] = element2;
                    arrayAscending[i+1] = placeHolder;
                }

            }

            loopCount++;
        }
        
        return arrayAscending;
    }

    
    // method to sort the Original Array in descending order
    public int[] descending() {
        int element1 = 0;
        int element2 = 0;
        int placeHolder = 0;
        int loopCount = 0;
        
        // makes a copy of the original array as "arrayDescending"
        for (int i=0;i<20;i++) {
            arrayDescending[i] = this.arrayOriginal[i];
        }
        
        while (loopCount < 20) {
  
            for (int i=19;i>0;i--) {
                element1 = arrayDescending[i];
                element2 = arrayDescending[i-1];

                if (element2 < element1) {
                    placeHolder = element1;
                    arrayDescending[i] = element2;
                    arrayDescending[i-1] = placeHolder;
                }

            }
            
            loopCount++;
        
        }
        
        return arrayDescending;

    }
    
    // method for spitting out either the index of the match or "match not found"
    public void find(int searchValue,int[] searchArray) {
        int foundIndex = 0;
        boolean matchFound = false;
        int i = 0;
        
        while (matchFound = false | i != 19) {
            
            for (i=0;i<19;i++) {
                if (searchArray[i] == searchValue) 
                    foundIndex = i;
                    matchFound = true;
            }
        }
        
        if (matchFound = false)
            System.out.println("Match not found");
        else
            System.out.println("Found match in index [" + foundIndex + "]");

    }
    
}
