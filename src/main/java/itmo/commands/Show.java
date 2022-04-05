package itmo.commands;

import itmo.model.Dragon;

import java.util.Enumeration;
import java.util.Hashtable;

public class Show {

    public void showCollection(Hashtable<Integer, Dragon> dragons){
        Enumeration hashKeys = dragons.keys();
        while (hashKeys.hasMoreElements()){
            Integer str = (Integer) hashKeys.nextElement();
            Dragon dragon= dragons.get(str);
            System.out.println(dragon.toString());
        }
    }
}
