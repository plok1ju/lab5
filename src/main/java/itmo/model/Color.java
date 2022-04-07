package itmo.model;

import java.util.Locale;

public enum Color{
    BLUE,
    YELLOW,
    ORANGE,
    WHITE;


    public static String getValues() {
        Color[] colorsArray = Color.values();
        StringBuilder stringBuilder = new StringBuilder();
        for(Color color : colorsArray){
            stringBuilder.append(color).append(", ");
        }
        return stringBuilder.toString();

    }

    public static Color parse(String stringColor) throws Exception {
        try {
            return valueOf(stringColor.toUpperCase(Locale.ROOT).trim());
        } catch (Exception e){
            throw new Exception("В " + Color.class.getSimpleName() + " нет константы " + stringColor + " :(");
        }
    }
}
