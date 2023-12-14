package notebook.view;

import notebook.controller.UserController;
import notebook.model.User;
import notebook.util.Commands;
import notebook.util.mapper.Prompt;
import notebook.util.mapper.UserValidation;

import java.util.Scanner;

public class UserView {
    private final UserController userController;

    public UserView(UserController userController) {
        this.userController = userController;
    }

    public void run(){
        Commands com;

        while (true) {
            String command = Prompt.prompt("Введите команду: ");
            com = Commands.valueOf(command);
            if (com == Commands.EXIT) return;
            switch (com) {
                case CREATE:
                    User u = userController.createUser();
                    userController.saveUser(u);
                    break;
                case READ:
                    String id = Prompt.prompt("Идентификатор пользователя: ");
                    try {
                        User user = userController.readUser(Long.parseLong(id));
                        System.out.println(user);
                        System.out.println();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case READ_ALL:
                    System.out.println(userController.readAll());
                    break;
                case UPDATE:
                    String userId = Prompt.prompt("Enter user id: ");
                    userController.updateUser(userId, userController.createUser());
                case DELETE:
                    String id2 = Prompt.prompt("Enter user id: ");
                    userController.deleteUser(id2);

            }
        }
    }

//    private String prompt(String message) {
//        Scanner in = new Scanner(System.in);
//        System.out.print(message);
//        return in.nextLine();
//    }


}
