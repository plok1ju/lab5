package manager;

import commands.*;
import manager.utility.CollectInfo;

import java.io.File;
import java.util.Hashtable;
import java.util.Scanner;

public class CommandsManager {

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
