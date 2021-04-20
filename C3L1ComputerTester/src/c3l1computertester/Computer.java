package c3l1computertester;

/**
 *
 * @author corinnekinzy CPSC 5000-0 CRN22404 C1-3 L1 2/8/21
 */
public class Computer {
    // Instance Variable area: (These are kind of like the defaults, always private, anywhere in the computer class, global var in comp class)
    private String serial;
    private double size;
    private String file;
    
    // The Constructor Method: Literally setting up an instance. 
    public Computer(String serial) {
        /* ^^^ String serial is a local variable
        "this" refers to the instance variable, not the local variable. 
           This sets the instance variable default to a user given input for the entire class 
        */
        this.serial = serial; 
        size = 500.0; 
        file = null;
    }
    
    // Read Methods, available methods for later usage
    public String getSerial()
    {
        return serial;
    }
    
    public double getSize()
    {
        return size;
    }
    
    public String getFile()
    {
        return file;
    }
    
    
    // Action Methods, option to add in the other variables    
    public void addFile(String fileName, double size) {
        
        setFile(fileName);
        setSize(this.size - size);
        
    }
    
    // setting the instance variable, size, to a given size
    private void setSize(double size) {
        this.size = size; 
    }        
    
    // setting the instance variable, file, to a given file
    private void setFile(String fileName)
    {
        file = fileName;
    }
    
    /*
    The display output returns the following when no size or file is provided:
        Serial Number = 2YRAE1M 
        Size = 500.0 GB 
        File = null
    */
    public void display()
    {
        String serial_text = 
                "Serial Number = " + getSerial() + " \n"+
                "Size = " + getSize() + " GB" + " \n"+
                "File = " + file + "\n";
        
        System.out.println(serial_text);
    }
            
}
    