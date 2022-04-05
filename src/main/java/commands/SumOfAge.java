package commands;

import model.Dragon;

import java.util.Enumeration;
import java.util.Hashtable;

public class SumOfAge {

    public void sum(Hashtable<Integer, Dragon> dragons){

        int sum = 0;
        Enumeration hashKeys = dragons.keys();
        while (hashKeys.hasMoreElements()){
            Integer str = (Integer) hashKeys.nextElement();
            Dragon dragon= dragons.get(str);
            sum += dragon.getAge();
        }

        System.out.println("Sum of age is: " + sum);
    }
}
