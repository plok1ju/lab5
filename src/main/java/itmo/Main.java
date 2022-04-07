package itmo;

import itmo.collection.HashTableCollection;
import itmo.commands.Command;
import itmo.io.ConsoleScan;
import itmo.io.Scannable;
import itmo.manager.CommandsManager;
import itmo.manager.file.ReaderXml;
import itmo.model.Dragon;

public class Main {
    private static HashTableCollection<Integer, Dragon> collection = new HashTableCollection<>();
    public static void main(String[] args) throws Exception {
        ReaderXml readerXml = new ReaderXml();
        try{
            collection = readerXml.returnCollect();
        }
        catch (Exception e){

        }
        Scannable scannable = new ConsoleScan();
        CommandsManager commandsManager = new CommandsManager(collection);
        getCommand(commandsManager, scannable);

    }

    private static void getCommand(CommandsManager commandsManager, Scannable scannable){
        try{
            System.out.println("Введите команду: ");
            Command command = commandsManager.getCommand(scannable.scanString(), scannable,true);
            command.execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        getCommand(commandsManager, scannable);
    }
}


