package com.li.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //生成set和get方法
@AllArgsConstructor // 有参构造
@NoArgsConstructor // 无参构造
public class User {
    private int id;
    private String name;
    private String pwd;
}
