package notebook.util.mapper;

import java.util.Scanner;

public class Prompt {

    public static String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
