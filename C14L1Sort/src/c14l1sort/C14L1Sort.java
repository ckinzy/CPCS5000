package c14l1sort;

/**
 *
 * @author corinnekinzy CPSC 5000-0 CRN22404 C14 L5 4/14/21
 */
public class C14L1Sort {

    public static void main(String[] args) {
        
        // Array given in the assignment
        int[] test = {51, 63, 48, 98, 75, 63, 92, 30, 32, 32, 36, 89, 4, 76, 73, 90, 64, 99, 36, 96};
        // Search Value given in the assignment
        int searchValue = 90;
        // New Sort object with the given array as input
        Sort tester = new Sort(test);
        
        // calls on the tester object and utilizes the ascending and descending methods
        tester.ascending();
        tester.descending();
        
        // utilize the display method to show the original array
        System.out.println("Original array");
        tester.display(tester.arrayOriginal);
        System.out.println();
        
        // utilize the display method to show the ascending array
        System.out.println("Array in ascending order");
        tester.display(tester.arrayAscending);
        System.out.println();
        
        // utilize the display method to show the descending array
        System.out.println("Array in descending order");
        tester.display(tester.arrayDescending);
        System.out.println();
        
        // given a search value and array, find the index of the value       
        System.out.println("Find " + searchValue);
        tester.find(searchValue, tester.arrayDescending);
            
           
    }
    
}
