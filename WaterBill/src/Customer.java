import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public abstract class Customer {
    final int TIER2_CUTOFF = 13000;
    final double GALLONS = 1000.0;

    private String name;
    private int gallonsUsed;
    //private int customerType; //1 = single family and 2 = duplex
    private double bill;

    static private ArrayList<Customer> allCustomers = new ArrayList<Customer>();

    public Customer() //if you overload a constructor then you have to have the default Also good for testing
    {
        System.out.println("This is a customer");
        this.name = null;
        this.gallonsUsed = 0;
    }

    public Customer(String name, int gallonsUsed)
    {
        System.out.println("THIS IS A CUSTOMER!!");
        setName(name);
        setGallonsUsed(gallonsUsed);
        setCustomerType(customerType);
    }



    //getter - allow classes to get info
    static public ArrayList<Customer> getAllCustomers() {
        return allCustomers;
    }

    public int getGallonsUsed()
    {
        return gallonsUsed;
    }

    public String getName() {
        return name;
    }

    public int getCustomerType() {
        return customerType;
    }

    public double getBill() {return bill;}

    //setter - allows for us to set a value
    public void setGallonsUsed(int gallonsUsed)
    {
        if (gallonsUsed < 0)
        {
            System.out.println("Gallons must be positive");
        }
        else
        {
            this.gallonsUsed = gallonsUsed;
        }
    }

    public void setName(String name) {
        if (name.equals("") || name == null)
        {
            System.out.println("Must have a name");
        }
        else
        {
            this.name = name;
        }
    }

    public void setCustomerType(int customerType) {
        this.customerType = customerType;
    }

    protected void registerCustomer()
    {
        allCustomers.add(this);
    }

    public void customerInput(){
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        try {
            System.out.print("Enter Customer Name: ");
            name = bufferedReader.readLine();

            System.out.print("Enter Customer Type (1: SingleFamily, 2: Duplex): ");
            setCustomerType(Integer.parseInt(bufferedReader.readLine()));

            System.out.print("Enter gallons used: ");
            setGallonsUsed(Integer.parseInt(bufferedReader.readLine()));
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
    }

    public abstract double calculateBill();


    protected double applyDiscount(double calculatedBill)
    {
        return calculatedBill;
    }

    public void generateBill()
    {
        double calculated = calculateBill();
        double finalBill = applyDiscount(calculated);

        this.bill = finalBill;

        registerCustomer();
    }

    public void printBill(){
        System.out.println("The bill is " + bill);

    }

    @Override
    public String toString() {
        return "Name " + getName();
    }

    static public Customer getHighestCustomer()
    {
        for (int i = 0; i < Customer.getAllCustomers().toArray().length; i++)
        {
            System.out.println("yay");
        }

        return null;
    }

}



//day 1
// practice user stories and prioritizing them
// BRUTE FORCE everything in main first before even thinking about classes
// Probably shouldnt go outside of main

//create a new java repository and connect it to git BEFORE CLASS

//day 2
// extend on someone elses code and add class structure
// CLASSES!
// single responsiblilty (SRP)
// getters, setters, tests (the last part just a few)
// a couple more small tasks
// your decision to refactor or not but try with their code
// 2 min survey of the code you got at the end

//day 3 ish
// technical review of code on day 2
// walk through the code with mal for a couple minutes
// if you understand the code it shouldn't be too hard

//all open note no internet


// should get class day 1
// curve ball day 2
// getters and setters
//