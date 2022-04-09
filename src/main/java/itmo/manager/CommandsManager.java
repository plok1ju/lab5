package itmo.manager;

import itmo.collection.HashTableCollection;
import itmo.commands.*;
import itmo.io.Scannable;
import itmo.model.Color;
import itmo.model.Dragon;
import itmo.model.builders.DragonBuilder;

public class CommandsManager {

    private final HashTableCollection<Integer, Dragon> collection;

    public CommandsManager(HashTableCollection<Integer, Dragon> collection) {
        this.collection = collection;
    }


    public Command getCommand(String commandLine, Scannable scannable, boolean isConsole) throws Exception {
        String[] arrayLine = commandLine.split(" ");
        if (arrayLine.length == 0) {
            throw new Exception("Нет команд");

        }
        String command = arrayLine[0];
        switch (command) {
            case "clear": {

                return new Clear(collection);
            }

            case "show": {

                return new Show(collection);
            }

            case "info": {

                return new Info(collection);

            }

            case "insert": {

                if (arrayLine.length < 2) {
                    throw new Exception("Введены не все поля");
                }
                Integer key = Integer.parseInt(arrayLine[1]);
                Dragon dragon = new DragonBuilder(isConsole).build(scannable);
                return new Insert(collection, key, dragon);
            }

            case "exit": {

                return new Exit();

            }

            case "help": {

                return new Help();
            }

            case "print_descending": {

                return new PrintDescending(collection);
            }

            case "remove_all_by_color": {

                if (arrayLine.length < 2) {
                    throw new Exception("Введены не все поля");
                }
                Color color = Color.parse(arrayLine[1]);
                return new RemoveAllByColor(collection, color);
            }

            case "remove_greater_key": {

                if (arrayLine.length < 2) {
                    throw new Exception("Введены не все поля");
                }
                Integer key = Integer.parseInt(arrayLine[1]);
                return new RemoveGreaterKey(collection, key);
            }

            case "remove_key": {

                if (arrayLine.length < 2) {
                    throw new Exception("Введены не все поля");
                }
                Integer key = Integer.parseInt(arrayLine[1]);
                return new RemoveKey(collection, key);
            }

            case "save": {

                return new Save(collection);
            }

            case "sum_of_age": {
                return new SumOfAge(collection);
            }


            case "remove_lower": {

                DragonBuilder dragonBuilder = new DragonBuilder(isConsole);
                Dragon dragon = dragonBuilder.build(scannable);
                return new RemoveLower(collection, dragon);
            }

            case "replace_if_lower": {

                if (arrayLine.length < 2) {
                    throw new Exception("Введены не все поля");
                }
                DragonBuilder dragonBuilder = new DragonBuilder(isConsole);
                Dragon dragon = dragonBuilder.build(scannable);
                Integer key = Integer.parseInt(arrayLine[1]);
                return new ReplaceIfLowe(collection, key, dragon);
            }

            case "update": {
                if (arrayLine.length < 2) {
                    throw new Exception("Введены не все поля");
                }
                DragonBuilder dragonBuilder = new DragonBuilder(isConsole);
                Dragon dragon = dragonBuilder.build(scannable);
                Long id = Long.parseLong(arrayLine[1]);
                return new UpdateId(collection, id, dragon);

            }
            default: {
                throw new Exception("Такой команды нет :(");
            }

            case "execute_script" :{

                if (arrayLine.length < 2){
                    throw new Exception("Введены не все поля");
                }
                String nameFile = arrayLine[1];
                return new ExecuteScript(nameFile, collection);
            }

        }

    }
}
