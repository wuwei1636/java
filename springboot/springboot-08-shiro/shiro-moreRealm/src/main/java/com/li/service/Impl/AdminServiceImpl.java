package com.li.service.Impl;

import com.li.mapper.AdminMapper;
import com.li.pojo.Admin;
import com.li.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin queryAdminByName(String name) {
        return adminMapper.queryAdminByName(name);
    }
}
