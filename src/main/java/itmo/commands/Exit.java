package itmo.commands;

import java.util.Scanner;

public class Exit {

    public boolean exit(){
        Scanner commandExit = new Scanner(System.in);
        System.out.println("Do you want end programm without saving itmo.collection?");
        System.out.print("Answer 'yes' or 'no' ");
        String asker = commandExit.nextLine();
        if (asker.contains("yes")){
            System.out.println("Thanks for work. Program was completed");
            return false;
        }
        else {return true;}
    }
}
