package phone;

//Class Telephone extends Phone interface
public class Telephone implements Phone {

    private String myTelephoneNumber;
    private String modelNumber;
    private String serialNumber;

    public Telephone(String myTelephoneNumber,String modelNumber,String serialNumber){
        this.myTelephoneNumber=myTelephoneNumber;
        this.modelNumber=modelNumber;
        this.serialNumber=serialNumber;
    }

    @Override
    //to call a number
    public void call(){
        System.out.println("calling");
    }

    @Override
    //to see call history
    public void callHistory() {
        System.out.println("Display call history");
    }

    @Override
    //to dial a number
    public void dial() {
        System.out.println("dial");
    }

    @Override
    public void pressButton() {
        System.out.println("press button");
    }

    //to put phone on loud speaker
    public void loudSpeaker() {
        System.out.println("on loud speaker");
    }

    //to exit from loud speaker and put phone on normal speaker
    public void normalSpeaker() {
        System.out.println("normal speaker");
    }

    //to redial last number
    public void redial() {
        System.out.println("redial last number");
    }

}

