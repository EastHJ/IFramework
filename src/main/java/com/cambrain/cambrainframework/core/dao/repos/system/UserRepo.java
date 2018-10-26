package com.cambrain.cambrainframework.core.dao.repos.system;

import com.cambrain.cambrainframework.core.dao.repos.BaseRepo;
import com.cambrain.cambrainframework.core.domain.po.system.User;
import org.springframework.stereotype.Repository;

/**
 * @ProjectName: [IFramework]
 * @Package: [com.cambrain.cambrainframework.core.dao.repos.system]
 * @ClassName: [UserRepo]
 * @Description: 用户数据操作仓库
 * @Author: [EastHJ]
 * @CreateDate: [2018-10-26 15:23]
 * @UpdateUser: [EastHJ]
 * @UpdateDate: [2018-10-26 15:23]
 * @UpdateRemark: [说明本次修改内容]
 * @Version: [v1.0]
 */
@Repository
public interface UserRepo extends BaseRepo<User,String> {
}
