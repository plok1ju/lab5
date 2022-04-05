package commands;

import java.util.HashMap;
import java.util.Map;

public class Help {
    private HashMap<String, String> vocabulary = new HashMap<>(); // создание словаря

    public boolean create(){ // наполнение словаря

        vocabulary.put("clear", "Clean collection");
        vocabulary.put("execute script", "Read file and do commands from file");
        vocabulary.put("exit", "End program (without saving collection in file)");
        vocabulary.put("info", "Print information about collection");
        vocabulary.put("insert {key}", "Add new element by key");
        vocabulary.put("print descending", "Print element of collection in descending order");
        vocabulary.put("remove all by color", "Delete elements with certain value of color");
        vocabulary.put("remove lower", "Delete all elements, if they less than enter element");
        vocabulary.put("help", "Command help output");
        vocabulary.put("remove greater key", "Delete all elements, if them key bigger than enter key");
        vocabulary.put("remove key", "Delete element by key");
        vocabulary.put("replace if lowe","replace value by key, if the new value less then older");
        vocabulary.put("save", "Save collection in file");
        vocabulary.put("Show", "Show all elements in collection");
        vocabulary.put("update id", "Change element fields by the ID");
        return true;

    }

    public void getVocabulary() {
        for(Map.Entry<String, String> entry: this.vocabulary.entrySet())
            System.out.println(entry.getKey() + " - " + entry.getValue());

    }

    public void setVocabulary(HashMap<String, String> vocabulary) {
        this.vocabulary = vocabulary;
    }
}
