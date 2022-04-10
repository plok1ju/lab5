package itmo.manager;

import itmo.commands.*;

import java.util.HashMap;
//TODO не используется, можно удалить?
public class CommandMatcher {
    private final HashMap<String, Class<? extends Command>> dictionary = new HashMap<>();

    public CommandMatcher() {
        dictionary.put("clear", Clear.class); // берем класс команды
        dictionary.put("show", Show.class);
        dictionary.put("info", Info.class);
        dictionary.put("insert", Insert.class);
    }


}
