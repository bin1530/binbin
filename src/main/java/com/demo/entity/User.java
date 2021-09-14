package com.demo.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.sun.javafx.beans.IDProperty;
import lombok.Data;
import org.omg.CORBA.IDLType;

import java.math.BigDecimal;
import java.util.Date;


@Data
public class User {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private Integer gender;
    @TableLogic(value = "1",delval = "0")
    private Integer enable;
    @TableField(value = "createtime",fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(value = "updatetime",fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    private Double salary;

//    @Version
//    private Integer version;

    public User() {
    }

    public User(Integer id, String username, String password, Integer gender, Integer enable) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.enable = enable;
    }
}
