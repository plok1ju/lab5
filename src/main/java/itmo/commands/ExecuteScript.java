package itmo.commands;

import itmo.collection.HashTableCollection;
import itmo.io.FileScan;
import itmo.io.Scannable;
import itmo.manager.CommandsManager;
import itmo.model.Dragon;

public class ExecuteScript implements Command{

    private String fileName;
    HashTableCollection<Integer, Dragon> collection;

    public ExecuteScript(String fileName, HashTableCollection<Integer, Dragon> collection) {
        this.fileName = fileName;
        this.collection = collection;
    }

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
