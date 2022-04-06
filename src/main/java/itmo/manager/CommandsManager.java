package itmo.manager;

import itmo.collection.HashTableCollection;
import itmo.commands.Clear;
import itmo.commands.Command;
import itmo.commands.Info;
import itmo.commands.Show;
import itmo.model.Dragon;

public class CommandsManager {

    private final HashTableCollection<Integer, Dragon> collection;

    public CommandsManager(HashTableCollection<Integer, Dragon> collection) {
        this.collection = collection;
    }


    public Command getCommand(String commandLine) throws Exception {
        String[] arrayLine = commandLine.split(" ");
        if(arrayLine.length == 0){
            throw new Exception();

        }
        String command = arrayLine[0];
        switch (command){
            case "clear" :{

                return new Clear(collection);
            }

            case "show" :{

                return new Show(collection);
            }

            case "info" :{

                return new Info(collection);

            }

            case "insert" :{

                if(arrayLine.length < 2){
                    throw new Exception();
                }
                Integer key = Integer.parseInt(arrayLine[1]);
                break;


            }

        }
        return null;

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
