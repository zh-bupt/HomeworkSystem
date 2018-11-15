package com.bupt.se.homework.bo;

import com.bupt.se.homework.entity.Admin;

public interface AdminBo extends BasicBo<Admin, String> {
    String login(String id, String password);
}
