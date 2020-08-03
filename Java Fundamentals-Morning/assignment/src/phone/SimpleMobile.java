package phone;

//class for simple mobile phone
//this extends the parent Telephone class
public class SimpleMobile extends Telephone{


    public SimpleMobile(String myTelephoneNumber, String modelNumber, String serialNumber) {
        super(myTelephoneNumber, modelNumber, serialNumber);
    }

    public void dial() {
        System.out.println("mobile dial");
    }

    //to add new contact
    public void addContact() {
        System.out.println("adding contact");
    }

    //to delete contact
    public void deleteContact() {
        System.out.println("delete contact");
    }

    //to edit contact
    public void editContact() {
        System.out.println("edit contact");
    }

    //to search for contact
    public void searchContact() {
        System.out.println("search contact");
    }

    //to record and save the ongoing call
    public void recordCall() {
        System.out.println("record call");
    }

    //to put the call on hold
    public void hold() {
        System.out.println("hold call");
    }

    //to receive incoming call
    public void receiveCall() {
        System.out.println("receive call");
    }

    //to decline incoming call
    public void declineCall() {
        System.out.println("decline call");
    }

}
