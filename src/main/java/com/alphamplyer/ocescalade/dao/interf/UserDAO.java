package com.alphamplyer.ocescalade.dao.interf;

import com.alphamplyer.ocescalade.model.User;

public interface UserDAO {

    User getUserByNickname(String name);

    void registerUser(User user);
}
