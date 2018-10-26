package com.cambrain.cambrainframework.core.domain.po;


import com.cambrain.cambrainframework.core.domain.emun.EntityEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @ProjectName: [cambrianc]
 * @Package: [com.cambrain.cambrainframework.entity]
 * @ClassName: [BaseEntity]
 * @Description: 实体基础类
 * @Author: [EastHJ]
 * @CreateDate: [2018-07-27 14:52]
 * @UpdateUser: [EastHJ]
 * @UpdateDate: [2018-07-27 14:52]
 * @UpdateRemark: [说明本次修改内容]
 * @Version: [v1.0]
 */
@Getter
@Setter
@ToString
@MappedSuperclass
public abstract class BaseEntity {

    /**
     * 实体ID
     */
    @Id
    @GenericGenerator(name = "jpa-uuid", strategy = "uuid")
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "ID", columnDefinition = "VARCHAR(64) COMMENT '主键'")
    private String id;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME", updatable = false, columnDefinition = "DATETIME NOT NULL  DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'")
    @Temporal(value = TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date createTime;

    /**
     * 创建人
     */
    @Column(name = "CREATE_NAME", columnDefinition = "VARCHAR(20) COMMENT '创建人'")
    private String createName;

    /**
     * 更新时间
     */
    @Column(name = "UPDATE_TIME", columnDefinition = "DATETIME NOT NULL ON UPDATE CURRENT_TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间'")
    @Temporal(value = TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date updateTime;

    /**
     * 更新人
     */
    @Column(name = "UPDATE_NAME", columnDefinition = "VARCHAR(20) COMMENT '更新人'")
    private String updateName;

    /**
     * 作废时间
     */
    @Column(name = "CANCEL_TIME", columnDefinition = "DATETIME  ON UPDATE CURRENT_TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '作废时间'")
    @Temporal(value = TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date cancelTime;

    /**
     * 作废人
     */
    @Column(name = "CANCEL_NAME", columnDefinition = "VARCHAR(20) COMMENT '作废人'")
    private String cancelName;

    /**
     * 记录标识
     */
    @Column(name = "TAG", columnDefinition = "INT(4) DEFAULT 999 COMMENT '标签，-1为删除'")
    private Integer tag;

    /**
     * 实体保存前设置初始值
     */
    @PrePersist
    protected void prePersist() {
        this.setCreateTime(new Date());
        this.setUpdateTime(new Date());
        this.setTag(EntityEnum.TAG_NEW.getCode());

    }

    /**
     * 实体更新前处理更新时间
     */
    @PreUpdate
    protected void preUpdate() {
        this.setUpdateTime(new Date());
    }


}
