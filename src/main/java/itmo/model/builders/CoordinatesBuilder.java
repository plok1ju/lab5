package itmo.model.builders;

import itmo.io.Scannable;
import itmo.model.Coordinates;

public class CoordinatesBuilder {

    private Coordinates coordinates;
    private boolean isConsole;


    public CoordinatesBuilder(boolean isConsole) {
        this.isConsole = isConsole;
    }

    public Coordinates build(Scannable scannable) throws Exception {
        coordinates = new Coordinates();
        this.buildX(scannable);
        this.buildY(scannable);
        return coordinates;

    }

    private void buildX(Scannable scannable) throws Exception {
        if(isConsole){
            try {
                System.out.println("Введите координату х: ");
                Double x = Double.parseDouble(scannable.scanString());
                coordinates.setX(x);
            }
            catch (Exception e){
                System.out.println("Что-то не то с координатой х: " + e.getMessage());
                this.buildX(scannable);
            }
        }
        else {
            Double x = Double.parseDouble(scannable.scanString());
            coordinates.setX(x);

        }
    }

    private void buildY(Scannable scannable) throws Exception {
        if(isConsole){
            try {
                System.out.println("Введите координату y: ");
                int y = Integer.parseInt(scannable.scanString());
                coordinates.setY(y);
            }
            catch (Exception e){
                System.out.println("Что-то не то с координатой y: " + e.getMessage());
                this.buildX(scannable);
            }
        }
        else {
            int y = Integer.parseInt(scannable.scanString());
            coordinates.setY(y);
        }

    }


}
