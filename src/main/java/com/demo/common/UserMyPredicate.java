package com.demo.common;

import com.demo.entity.User;

public class UserMyPredicate implements MyPredicate<User> {
    @Override
    public boolean test(User user) {
        return false;
    }
}
