package itmo.manager;

import itmo.collection.HashTableCollection;
import itmo.commands.*;
import itmo.io.Scannable;
import itmo.model.Color;
import itmo.model.Dragon;
import itmo.model.builders.DragonBuilder;
/**
 * Этот класс определяет команду
 */
public class CommandsManager {

    /**
     * Поле collection
     * {@link HashTableCollection}
     */
    private final HashTableCollection<Integer, Dragon> collection;

    /**
     * Конструктор класса CommandsManager
     *
     * @param collection - значение поля collection
     */
    public CommandsManager(HashTableCollection<Integer, Dragon> collection) {
        this.collection = collection;
    }

    /**
     * Метод определяющий команду
     *
     * @param commandLine - значение поля commandLine
     * @param scannable - значение поля scannable
     * @param isConsole - значение поля isConsole
     * @return - введенная команда
     */
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

            case "update_id": {
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
//    public void run(CollectInfo collectInfo, File file) {
//        boolean flag = true;
//        while (flag) {
//            Scanner scanner = new Scanner(System.in);
//            System.out.print("Input a command: ");
//            String command = scanner.nextLine();
//            CollectionManager cm = new CollectionManager();
//            switch (command) {
//                case "exit": {
//                    Exit exit = new Exit();
//                    flag = exit.exit();
//                    break;
//                }
//                case "sum of age": {
//                    SumOfAge comm = new SumOfAge();
//                    comm.sum(collectInfo.getCollection());
//                    break;
//                }
//                case "show": {
//                    Show show = new Show();
//                    show.showCollection(collectInfo.getCollection());
//                    break;
//
//                }
//                case "update id": {
//                    UpdateId updateId = new UpdateId();
//                    updateId.updateElement(collectInfo.getCollection())
//                    ;
//                    break;
//                }
//                case "print descending": {
//
//                    break;
//                }
//                case "clear": {
//                    Clear clear = new Clear();
//                    clear.removeCollect(collectInfo.getCollection());
//                    break;
//                }
//                case "save": {
//                    Save save = new Save();
//                    save.saveCollect(collectInfo.getCollection(), file);
//                    break;
//                }
//                case "help": {
//                    Help help = new Help();
//                    if (help.create()) {
//                        help.getVocabulary();
//                    }
//                    break;
//                }
//                case "info": {
//                    Info info = new Info();
//                    info.infoAboutCollection(collectInfo.getCollection());
//                    break;
//                }
//            }
//
//        }
//    }
}
