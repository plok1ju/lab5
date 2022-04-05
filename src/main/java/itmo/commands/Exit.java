package itmo.commands;

public class Exit implements Command{

    public Exit(){}

    @Override
    public void execute(){
        System.exit(0);
    }
}
