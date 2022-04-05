package itmo.commands;

import itmo.model.Dragon;

import java.util.Hashtable;

public class Clear {

    public void removeCollect(Hashtable<Integer, Dragon> dragons){
        dragons.clear();
        System.out.println("Collection is clear");

    }
}
