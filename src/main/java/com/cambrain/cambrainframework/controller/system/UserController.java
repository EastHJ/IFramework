package com.cambrain.cambrainframework.controller.system;

import com.cambrain.cambrainframework.core.service.system.UserService;
import com.cambrain.cambrainframework.core.utils.HttpResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.cambrain.cambrainframework.core.utils.HttpResultData.SUCCESS;

/**
 * @ProjectName: [cambrainframework]
 * @Package: [com.cambrain.cambrainframework.controller.system]
 * @ClassName: [UserController]
 * @Description:  用户相关控制器
 * @Author: [EastHJ]
 * @CreateDate: [2018-10-27 19:47]
 * @UpdateUser: [EastHJ]
 * @UpdateDate: [2018-10-27 19:47]
 * @UpdateRemark: [说明本次修改内容]
 * @Version: [v1.0]
 */
@RestController
@RequestMapping("/user")
public class UserController {
             @Autowired
              private UserService userService;

             @GetMapping("/list")
             public HttpResultData list(){
                 return  HttpResultData.builder().success(SUCCESS).data(userService.list(null)).build();
             }
}
