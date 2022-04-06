package itmo.model.builders;

import itmo.io.Scannable;
import itmo.model.Dragon;

import java.util.Date;

public class DragonBuilder {

    private Dragon dragon;
    private boolean isConsole;

    public DragonBuilder(boolean isConsole) {
        this.isConsole = isConsole;
        dragon = new Dragon();
    }

    public Dragon build(Scannable scannable) throws Exception {
        this.buildName(scannable);
        this.buildCoordinates(scannable);
        this.setCreationDate();

        return this.dragon;

    }

    private void buildName(Scannable scannable) throws Exception {
        if(isConsole){
            try {
                System.out.println("Введите имя: ");
                String nameDragon = scannable.scanString();
                dragon.setName(nameDragon);

            }
            catch (Exception e){
                System.out.println("Что-то пошло не так: " + e.getMessage());
                this.buildName(scannable);
            }
        }
        else {
            String nameDragon = scannable.scanString();
            dragon.setName(nameDragon);
        }
    }

    private void buildCoordinates(Scannable scannable) throws Exception {
        CoordinatesBuilder coordinatesBuilder = new CoordinatesBuilder(isConsole);
        dragon.setCoordinates(coordinatesBuilder.build(scannable));

    }

    private void setCreationDate(){
        Date date = new Date();
        dragon.setCreationDate(date);

    }



}
