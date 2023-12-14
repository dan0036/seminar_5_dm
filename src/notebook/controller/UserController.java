package notebook.controller;

import notebook.model.User;
import notebook.model.repository.GBRepository;
import notebook.util.mapper.Prompt;
import notebook.util.mapper.UserValidation;

import java.util.List;
import java.util.Objects;

public class UserController {
    private final GBRepository repository;

    // DI
    public UserController(GBRepository repository) {
        this.repository = repository;
    }

    public void saveUser(User user) {
        repository.create(user);
    }

    public User readUser(Long userId) throws Exception {
        List<User> users = repository.findAll();
        for (User user : users) {
            if (Objects.equals(user.getId(), userId)) {
                return user;
            }
        }

        throw new RuntimeException("User not found");
    }

    public User createUser() {
        UserValidation userValidation = new UserValidation();

        String firstName = Prompt.prompt("Имя: ");
        String lastName = Prompt.prompt("Фамилия: ");
        String phone = Prompt.prompt("Номер телефона: ");
        User user = new User(firstName, lastName, phone);
        if (userValidation.valid(user)){
            return user;
        } else {
            throw new IllegalArgumentException("Введены некорректные данные");
        }
    }

    public void updateUser(String userId, User update) {
        update.setId(Long.parseLong(userId));
        repository.update(Long.parseLong(userId), update);
    }

    public void deleteUser(String userId){
        repository.delete(Long.parseLong(userId));
    }

    public List<User> readAll() {
        return repository.findAll();
    }
}
