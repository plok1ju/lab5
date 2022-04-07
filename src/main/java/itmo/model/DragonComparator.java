package itmo.model;

import java.util.Comparator;
/**
 * Класс отвечающий за сравнение двух драконов
 */
public class DragonComparator implements Comparator<Dragon> {

    /**
     * Переопределение метода compare
     * @return - одинаковые ли два дракона или нет
     */
    @Override
    public int compare(Dragon o1, Dragon o2) {
        return o1.compareTo(o2);
    }
}
