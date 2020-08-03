import java.util.ArrayList;
import countoccurence.CountOccurence;
import phone.Phone;
import phone.SimpleMobile;
import phone.Telephone;
import singleton.MySingleton;

public class Main {

        public static void main(String[] args)  throws CloneNotSupportedException
        {

            System.out.println("---------");
            System.out.println("Showing use of clone with Singleton classes without violating the property of Singleton:\n");
            MySingleton ob1 = MySingleton.getInstance();
            MySingleton ob2 = (MySingleton) ob1.clone();

            System.out.println(ob1.hashCode());
            System.out.println(ob2.hashCode());

            System.out.println("\n---------");
            System.out.println("Word count:\n");


            ArrayList<String> list = new ArrayList<String>();
            CountOccurence count = new CountOccurence();
            list.add("I");
            list.add("was");
            list.add("happy");
            list.add("because");
            list.add("others");
            list.add("were");
            list.add("happy");

            count.countElementsFromArrayList(list);
            System.out.println("---------");
            String s ="I was happy because others were happy";
            count.countElementsFromString(s);

            System.out.println("---------");

            System.out.println("Phone Methods\n\n");

            Phone phone = new Telephone("234123","PN121","1238880332");
            phone.call();
            phone.callHistory();
            phone.dial();
            System.out.println();

            SimpleMobile mobile = new SimpleMobile("887344123","ES29","JS345550");
            mobile.call();
            mobile.dial();
            mobile.callHistory();
            mobile.addContact();
            mobile.recordCall();
            mobile.declineCall();


        }

}
