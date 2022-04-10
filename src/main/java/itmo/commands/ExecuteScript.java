package itmo.commands;

import itmo.collection.HashTableCollection;
import itmo.io.FileScan;
import itmo.io.Scannable;
import itmo.manager.CommandsManager;
import itmo.model.Dragon;
/**
 * Класс отвечает за исполнение команд из файла
 */
public class ExecuteScript implements Command{

    /**
     * Поле fileName
     */
    private String fileName;

    /**
     * Поле collection
     * {@link HashTableCollection}
     */
    HashTableCollection<Integer, Dragon> collection;

    /**
     * Конструктор класса ExecuteScript
     *
     * @param fileName - Поле fileName
     * @param collection - Поле collection
     */
    public ExecuteScript(String fileName, HashTableCollection<Integer, Dragon> collection) {
        this.fileName = fileName;
        this.collection = collection;
    }

    /**
     * Переопределение метода execute
     */
    @Override
    public void execute() throws Exception {
        Scannable scannable = new FileScan(fileName);
        CommandsManager commandsManager = new CommandsManager(collection);
        try{
            String commandLine = scannable.scanString();
            while (commandLine != null){
                Command command = commandsManager.getCommand(commandLine, scannable, false);
                if (!(command instanceof ExecuteScript)){
                    command.execute();
                }
                commandLine = scannable.scanString();

            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
