package com.cambrain.cambrainframework.core.domain.emun;

/**
 * @ProjectName: [cambrianc]
 * @Package: [com.cambrain.cambrianc.core.enuminfo]
 * @ClassName: [EntityTagEnum]
 * @Description: 实体相关枚举参数
 * @Author: [EastHJ]
 * @CreateDate: [2018-07-27 15:24]
 * @UpdateUser: [EastHJ]
 * @UpdateDate: [2018-07-27 15:24]
 * @UpdateRemark: [说明本次修改内容]
 * @Version: [v1.0]
 */

public enum EntityEnum {
    /**
     * TAG_NEW 数据新建
     */
    TAG_NEW(999, "新建"),
    /**
     * 数据作废
     */
    TAG_CANCEL(-1, "作废"),
    /**
     * 用户数据状态 启用
     */
    STATUS_ENABLE(10, "启用"),
    /**
     * 用户数据状态 停用
     */
    STATUS_DISABLE(20, "禁用"),
    /**
     * 用户数据状态 删除
     */
    STATUS_DELETE(30, "删除");


    /**
     * 对应括号里面第一个值
     */
    private Integer code;
    /**
     * 对应括号里面第二个值
     */
    private String description;

    /**
     * enum 构造方法,注意这里是 private 私有的修饰符啊
     */
    private EntityEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * 通过code,即 0 或 1 获取对应 enum 对象
     */
    public static EntityEnum getByCode(Integer code) {
        /**要返回的枚举值*/
        EntityEnum showStatus = null;
        for (int i = 0; i < EntityEnum.values().length; i++) {
            showStatus = EntityEnum.values()[i];
            if (code.equals(showStatus.getCode())) {
                break;
            }
        }
        return showStatus;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
