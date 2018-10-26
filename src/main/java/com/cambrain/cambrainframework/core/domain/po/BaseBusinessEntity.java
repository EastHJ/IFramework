package com.cambrain.cambrainframework.core.domain.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * @ProjectName: [cambrianc]
 * @Package: [com.cambrain.cambrianc.core.entity]
 * @ClassName: [BusinessBaseEntity]
 * @Description: 业务实体基础类
 * @Author: [EastHJ]
 * @CreateDate: [2018-07-27 15:16]
 * @UpdateUser: [EastHJ]
 * @UpdateDate: [2018-07-27 15:16]
 * @UpdateRemark: [说明本次修改内容]
 * @Version: [v1.0]
 */
@Getter
@Setter
@ToString
@MappedSuperclass
public abstract class BaseBusinessEntity extends BaseEntity {

    /**
     * 业务时间
     */
    @Column(name = "BUSINESS_DATE", columnDefinition = "DATE  COMMENT '业务发生时间'")
    @Temporal(value = TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    private Date businessDate;

}
