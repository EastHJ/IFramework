package com.cambrain.cambrainframework.core.domain.po.system;

import com.cambrain.cambrainframework.core.domain.emun.EntityEnum;
import com.cambrain.cambrainframework.core.domain.po.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

/**
 * @ProjectName: [cambrianc]
 * @Package: [com.cambrain.cambrianc.core.entity.system]
 * @ClassName: [User]
 * @Description:  用户实体类
 * @Author: [EastHJ]
 * @CreateDate: [2018-08-01 10:05]
 * @UpdateUser: [EastHJ]
 * @UpdateDate: [2018-08-01 10:05]
 * @UpdateRemark: [说明本次修改内容]
 * @Version: [v1.0]
 */
@Entity
@Data
@Table(name = "SYS_USER")
@EqualsAndHashCode(callSuper = false)
public class User extends BaseEntity {
    /**
     * 头像
     */
    @Column(name = "AVATAR", columnDefinition = "VARCHAR(16000) COMMENT '头像'")
    private String avatar;
    /**
     * 账号
     */
    @Column(name = "ACCOUNT", columnDefinition = "VARCHAR(64) COMMENT '账号'")
    private String account;
    /**
     * 密码
     */
    @Column(name = "PASSWORD", columnDefinition = "VARCHAR(64) COMMENT '密码'")
    private String password;
    /**
     * md5密码校验
     */
    @Column(name = "MD5_SALT", columnDefinition = "VARCHAR(64) COMMENT 'MD5加密校验盐'")
    private String salt;
    /**
     * 名字
     */
    @Column(name = "NAME", columnDefinition = "VARCHAR(64) COMMENT '用户名称'")
    private String name;
    /**
     * 生日
     */
    @Column(name = "BIRTHDAY", columnDefinition = "DATE  COMMENT '生日'")
    @Temporal(value = TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    private Date birthday;
    /**
     * 性别（1：男 2：女）
     */
    @Column(name = "SEX_ID", columnDefinition = "VARCHAR(64) COMMENT '性别ID'")
    private String sexId;
    /**
     * 电子邮件
     */
    @Column(name = "EMAIL", columnDefinition = "VARCHAR(64) COMMENT '邮箱'")
    private String email;
    /**
     * 电话
     */
    @Column(name = "MOBILE_PHONE", columnDefinition = "VARCHAR(64) COMMENT '手机'")
    private String mobilePhone;
    /**
     * 角色id
     */
    @Column(name = "ROLE_ID", columnDefinition = "VARCHAR(64) COMMENT '角色ID'")
    private String roleId;
    /**
     * 部门id
     */
    @Column(name = "DEPT_ID", columnDefinition = "VARCHAR(64) COMMENT '部门ID'")
    private String deptId;
    /**
     * 状态(10：启用  20：冻结  30：删除）
     */
    @Column(name = "STATUS", columnDefinition = "INT COMMENT '状态'")
    private Integer status;


    public User(){
        this.setStatus(EntityEnum.STATUS_ENABLE.getCode());
    }

}
