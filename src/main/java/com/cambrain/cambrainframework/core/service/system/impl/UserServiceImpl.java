package com.cambrain.cambrainframework.core.service.system.impl;

import com.cambrain.cambrainframework.core.dao.repos.system.UserRepo;
import com.cambrain.cambrainframework.core.domain.emun.EntityEnum;
import com.cambrain.cambrainframework.core.domain.po.system.User;
import com.cambrain.cambrainframework.core.service.system.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: [IFramework]
 * @Package: [com.cambrain.cambrainframework.core.service.system.impl]
 * @ClassName: [UserServiceImpl]
 * @Description:  用户业务逻辑实现类
 * @Author: [EastHJ]
 * @CreateDate: [2018-10-26 15:46]
 * @UpdateUser: [EastHJ]
 * @UpdateDate: [2018-10-26 15:46]
 * @UpdateRemark: [说明本次修改内容]
 * @Version: [v1.0]
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public List<User> list(User e) {
        List<User> users =   userRepo.findAll();
        return  users;
    }

    @Override
    public User cancle(String id) {
      User user =   userRepo.findById(id).get();
        if(null != user)
        {
            user.setTag(EntityEnum.TAG_CANCEL.getCode());
            userRepo.save(user);
        }
        return user;
    }

    @Override
    public User delete(String id) {
        User user =   userRepo.findById(id).get();
        if(null != user)
        {
            user.setStatus(EntityEnum.STATUS_DELETE.getCode());
            userRepo.save(user);
        }
        return user;
    }


    @Override
    public User modify(User entity) {

        userRepo.save(entity);
        User user = userRepo.findById(entity.getId()).get();

        return user;
    }



    @Override
    public User findById(String id) {
        User user = userRepo.findById(id).get();
        return user;
    }
}
