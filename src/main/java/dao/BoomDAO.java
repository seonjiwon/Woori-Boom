package dao;

import domain.User;

import java.util.ArrayList;
import java.util.List;

public class BoomDAO {
    private final List<User> list = new ArrayList<>();
    private int nextId = 1;

    public List<User> findAll(){
        list.add(new User(nextId++, "이건희"));
        list.add(new User(nextId++, "선지원"));
        list.add(new User(nextId++, "백민정"));
        return list;
    }

    public User findById(int id) {
        return findAll().stream()
                .filter(p -> p.getUserId() == id)
                .findFirst()
                .orElse(null);
    }

    // 새로운 사용자 등록
    public User addUser(String name) {
        User user = new User(nextId++, name);
        list.add(user);
        return user;
    }

    public boolean deleteById(int id) {
        return list.removeIf(p -> p.getUserId() == id);
    }
}
