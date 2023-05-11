package com.Iynew.service;

import com.Iynew.po.User; public interface UserService {
public User getUserByIdByPass(User user); public int getUserById(String userId); public int saveUser(User user);
}