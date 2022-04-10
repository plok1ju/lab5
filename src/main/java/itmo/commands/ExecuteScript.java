package itmo.commands;

import itmo.collection.HashTableCollection;
import itmo.io.FileScan;
import itmo.io.Scannable;
import itmo.manager.CommandsManager;
import itmo.manager.FilesHistory;
import itmo.model.Dragon;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

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
        if (!Files.isReadable(Paths.get(fileName))){
            throw new Exception("Невозможно считать файл");
        }
        Scannable scannable = new FileScan(fileName);
        CommandsManager commandsManager = new CommandsManager(collection);
        try{
            if (FilesHistory.getInstance().containsFile(new File(fileName))){
                throw new Exception("Чел ты...\nЧуть рекурсию не вызвал...");
            }
            FilesHistory.getInstance().addHistory(new File(fileName));
            String commandLine = scannable.scanString();
            while (commandLine != null){
                Command command = commandsManager.getCommand(commandLine, scannable, false);
                command.execute();
                commandLine = scannable.scanString();

            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        FilesHistory.getInstance().removeFile(new File(fileName));
    }
}
