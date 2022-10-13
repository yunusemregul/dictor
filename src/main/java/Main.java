import dictor.Dictor;

import java.util.Scanner;

public class Main{

    public static void main(String[] args){
        System.out.println("Hello world!");

        Dictor dictor = Dictor.getInstance();
        Scanner input = new Scanner(System.in);

        while(true) {
            String query = input.nextLine();

            dictor.executeQuery(query);
        }
    }
}