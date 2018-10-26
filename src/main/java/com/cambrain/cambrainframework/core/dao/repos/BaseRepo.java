package com.cambrain.cambrainframework.core.dao.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * @ProjectName: [cambrianc]
 * @Package: [com.cambrain.cambrianc.domain.repos.base]
 * @ClassName: [BaseRepo]
 * @Description: 数据操作基础接口
 * @Author: [EastHJ]
 * @CreateDate: [2018-08-15 22:12]
 * @UpdateUser: [EastHJ]
 * @UpdateDate: [2018-08-15 22:12]
 * @UpdateRemark: [说明本次修改内容]
 * @Version: [v1.0]
 */
@NoRepositoryBean
public interface BaseRepo<T,PK extends Serializable> extends JpaRepository<T,PK>,JpaSpecificationExecutor<T>,Serializable {
}
