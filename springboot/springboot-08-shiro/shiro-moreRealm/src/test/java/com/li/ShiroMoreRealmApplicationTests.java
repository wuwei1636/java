package com.li;

import com.li.pojo.Admin;
import com.li.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShiroMoreRealmApplicationTests {

    @Autowired
    AdminService adminService;

    @Test
    void contextLoads() {
        String adm = "admin";
        Admin admin = adminService.queryAdminByName(adm);
        System.out.println(admin);

    }

}
