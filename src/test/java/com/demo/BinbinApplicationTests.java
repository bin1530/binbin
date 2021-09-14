package com.demo;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.entity.User;
import com.demo.mapper.UserMapper;
import com.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

import javax.xml.ws.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class BinbinApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Test
    void query() {
        User byId = userService.getById(1);
        System.out.println(byId);

    }

    @Test
    void select(){
        List<Integer> ids = Arrays.asList(1,2);
        userService.listByIds(ids);
    }

    @Test
    void page(){
        IPage<User> iPage = new Page<>(1,2);
        IPage<User> page = userService.page(iPage);
        List<User> records = page.getRecords();
        System.out.println(records);
        System.out.println(page.getSize());
    }

    @Test
    void ipage(){
        IPage<User> iPage = new Page<>(1,1);
        System.out.println(userMapper.getUserPage(iPage, 1).getRecords());
    }

    @Test
    void list(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.select("username","password");
        userQueryWrapper.eq("username","ee");
        System.out.println(userService.list(userQueryWrapper));
    }

    @Test
    void listTest(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();

        userQueryWrapper.lambda()
                .select(User::getUsername,User::getId,User::getPassword,User::getGender)
                .eq(User::getId,"2");

        System.out.println(userService.list(userQueryWrapper));
    }
    @Test
    void update(){
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.lambda()
                .set(User::getUsername,"嘿嘿")
                .eq(User::getId,"2");
        userService.update(userUpdateWrapper);
    }
    @Test
    void deleteLogic(){
        userService.removeById(3);
    }

    @Test
    void listAll(){
        List<User> list = userService.list();
        System.out.println(list);
    }

    @Test
    void save(){
        User user = new User();
        user.setUsername("彬彬");
        user.setPassword("12652362");
        user.setGender(1);
        user.setEnable(1);
        userService.save(user);
    }
    List<User> user =Arrays.asList(
            new User(6,"wuwu","12383",4,1)
    );

    @Test
    public void test2(){
        user.stream()
        .filter((e)->e.getSalary()<=5000)
                .limit(2)
        .forEach(System.out::println);
    }



}
