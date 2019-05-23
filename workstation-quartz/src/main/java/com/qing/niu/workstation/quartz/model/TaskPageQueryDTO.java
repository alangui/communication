package com.qing.niu.workstation.quartz.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.sf.oval.constraint.Min;
import net.sf.oval.constraint.NotNull;
import net.sf.oval.constraint.Range;

/**
 * <p>
 * </p>
 *
 * @author huqingniu
 * @version 1.0.0
 * @date 2019/3/11
 */
@Setter
@Getter
@ToString(callSuper = true)
public class TaskPageQueryDTO extends TaskQueryDTO{
    private static final long serialVersionUID = 9073499891936103527L;

    @NotNull(message = "起始页不能为空")
    @Min(value = 0,message = "起始页必须为自然数")
    private Integer startRow;

    @NotNull(message = "页码不能为空")
    @Range(min = 1,max = 1000,message = "页码大小在1-1000之间")
    private Integer pageCount;
}
