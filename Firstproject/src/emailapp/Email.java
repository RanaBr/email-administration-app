package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String Department;
    private int mailboxCapacity =500;
    private String alternateEmail;
    private int defaultPasswordLength= 10;
    private String email;
    private String companySuffix="Esprit.com";

    //constructor for the first and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("EMAIL CREATED: "+ this.firstName +" "+this.lastName);

        //asking for Department return department
        this.Department=setDepartment();
        System.out.println("Department: "+this.Department);

        //call e method that returns a random password
        this.password=randomPassword(defaultPasswordLength);
        System.out.println("Your password is: "+this.password);
        //combine to generate email
        email= firstName.toLowerCase()+"."+ lastName.toLowerCase()+"@"+Department+"."+ companySuffix;

        System.out.println("Your email is :"+ email);
    }


    //Ask for the department
    private String setDepartment() {
        System.out.println("DEPARTMENT CODES:  \n1 for Sales \n2 for Development \n3 for Accounting \n0 for none \n Enter Department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if( depChoice== 1 ){return "Sales";}
        else if(depChoice==2){return "development";}
        else if (depChoice==3){return "Accounting";}
        else {return "";}
    }

    //generate random password
    private  String randomPassword(int length){
         String passwordSet ="ABCDEFGHIJKLMNOPQRQTUVWXYZ1234567890!$%@#";
        char[] password= new char[length];
        for (int i  =0; i <length ; i++){
            int rand =(int) (Math.random() * passwordSet.length());
            password[i]= passwordSet.charAt(rand);

        }
        return new String(password);
    }
    //set the mailbox capacity
    private void setMailboxCapacity(int capacity){
        this.mailboxCapacity= capacity;
    }

    //set the alternate Email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    //change password
    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;}

    public String getAlternateEmail() {
        return alternateEmail;}

    public String getPassword() {
        return password;}

    @Override
    public String toString() {
        return "Email{" +
                "Display name ='" + firstName + " "+
                 lastName + '\'' +
                ", mailboxCapacity=" + mailboxCapacity +"mb "+
                ", email='" + email + '\'' +
                '}';
    }
}

