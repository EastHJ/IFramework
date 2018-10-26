package com.cambrain.cambrainframework.system;

import com.cambrain.cambrainframework.core.domain.po.system.User;
import com.cambrain.cambrainframework.core.service.system.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * @ProjectName: [IFramework]
 * @Package: [com.cambrain.cambrainframework.system]
 * @ClassName: [UserServiceTest]
 * @Description:  TODO  填写功能描述
 * @Author: [EastHJ]
 * @CreateDate: [2018-10-26 21:59]
 * @UpdateUser: [EastHJ]
 * @UpdateDate: [2018-10-26 21:59]
 * @UpdateRemark: [说明本次修改内容]
 * @Version: [v1.0]
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    @Transactional
    @Rollback
    public  void createUserTest(){
        User user = new User();
        user.setAccount("UserTestOne");
        user.setBirthday(new Date());
        user.setEmail("1234567@126.com");
        user.setName("小明");
        user.setMobilePhone("18689999999");
        user.setPassword("123456789999");
        user.setSalt("145869656");
        userService.modify(user);
        System.out.println(user.toString());
    }

   @Test
    public void findUserTest(){
        List<User> userList = userService.list(null);
        System.out.println(userList);
        userList.forEach(u->{
            System.out.println(u.toString());
        });
    }

}
