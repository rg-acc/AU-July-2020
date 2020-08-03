package countoccurence;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

//class to count occurences of words
public class CountOccurence {

    //method to count occurences of words in an ArrayList of String input
    //uses HashMap to store the corresponding count
    public void countElementsFromArrayList(ArrayList<String> list)
    {

        Map<String, Integer> hashMap = new HashMap<String, Integer>();

        for (String ele : list) {
            Integer count = hashMap.get(ele);
            if(count == null)
                hashMap.put(ele,1);
            else
                hashMap.put(ele,count+1);
        }

        System.out.println("Word count:\n");
        for (Map.Entry<String, Integer> ele : hashMap.entrySet()) {
            System.out.println(ele.getKey() + " : " + ele.getValue());
        }
    }

    //method to count occurences of words in a String
    public void countElementsFromString(String s)
    {
        List<String> myList = new ArrayList<String>(Arrays.asList(s.split("[ ,.]")));
        countElementsFromArrayList(new ArrayList<String>(myList));
    }


}


