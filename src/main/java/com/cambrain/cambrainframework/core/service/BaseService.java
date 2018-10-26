package com.cambrain.cambrainframework.core.service;

import java.util.List;

/**
 * @ProjectName: [cambrianc]
 * @Package: [com.cambrain.cambrianc.service.system]
 * @ClassName: [BaseService]
 * @Description: Service基础接口
 * @Author: [EastHJ]
 * @CreateDate: [2018-08-21 23:49]
 * @UpdateUser: [EastHJ]
 * @UpdateDate: [2018-08-21 23:49]
 * @UpdateRemark: [说明本次修改内容]
 * @Version: [v1.0]
 */

public interface BaseService<T> {

    /**
     * 列表查询
     * @param  e  被查询实体类
     * @return
     */
    List<T> list(T e);


    /**
     * 作废记录
     * @param id
     * @return
     */
    T cancle(String id);


    /**
     * 删除记录
     * @param id
     * @return
     */
    T delete(String id);


    /**
     * 新增修改记录
     * @param entity
     * @return
     */
    T modify(T  entity);

    /**
     * 根据Id获取记录
     * @param id
     * @return
     */
    T findById(String id);
}
