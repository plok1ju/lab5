package manager;

import model.Dragon;

import java.util.Hashtable;
import java.util.Set;
import java.util.TreeMap;

public class CollectionManager {

    public int[] getKeys(Hashtable<Integer, Dragon> collect) {
        TreeMap<Integer, Dragon> sortedMap = new TreeMap<>(collect);
        Set<Integer> badKeys = sortedMap.keySet();
        for(Integer key : sortedMap.keySet()){

        }
        int[] keys = new int[collect.size()];
        int last = -1;
        for (int j = 0; j < collect.size(); j++) {
            for (int i : badKeys) {
                if (last < Integer.parseInt(String.valueOf(i))) {
                    keys[j] = Integer.parseInt(String.valueOf(i));
                    last = keys[j];
                    break;
                }
            }
        }
        return keys;

}
}
