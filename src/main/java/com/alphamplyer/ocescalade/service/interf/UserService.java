package com.alphamplyer.ocescalade.service.interf;

import com.alphamplyer.ocescalade.model.Login;
import com.alphamplyer.ocescalade.model.User;

public interface UserService {

    void register(User user);

    User checkPassword(Login login);

    User getUser(Integer id);
}
