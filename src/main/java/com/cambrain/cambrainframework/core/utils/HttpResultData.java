package com.cambrain.cambrainframework.core.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @ProjectName: [cambrianc]
 * @Package: [com.cambrain.cambrianc.domain.entity.common]
 * @ClassName: [HttpResultData]
 * @Description: 请求返回实体类
 * @Author: [EastHJ]
 * @CreateDate: [2018-08-21 20:51]
 * @UpdateUser: [EastHJ]
 * @UpdateDate: [2018-08-21 20:51]
 * @UpdateRemark: [说明本次修改内容]
 * @Version: [v1.0]
 */

@Data
@Builder
@AllArgsConstructor
public class HttpResultData<T> {

    public static final boolean SUCCESS = true;
    public static final boolean FAIL = false;

    //状态
    @Builder.Default
    protected boolean success = true;
    //数据
    protected T data;
    /**
     * 相关信息
     */
    private String message;

    public HttpResultData(T data) {
        this.setData(data);
    }
    public HttpResultData(String message) {
        this.setMessage(message);
    }


}
