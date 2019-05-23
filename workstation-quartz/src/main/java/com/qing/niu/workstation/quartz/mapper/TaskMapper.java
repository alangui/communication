package com.qing.niu.workstation.quartz.mapper;

import com.qing.niu.workstation.quartz.model.TaskPageQueryDTO;
import com.qing.niu.workstation.quartz.model.TaskQueryDTO;
import com.qing.niu.workstation.quartz.model.TaskResDTO;

import java.util.List;

/**
 * <p>
 * </p>
 *
 * @author huqingniu
 * @version 1.0.0
 * @date 2019/3/11
 */
public interface TaskMapper {

    TaskResDTO selectByTaskName(TaskQueryDTO taskQueryDTO);

    int selectTaskCount(TaskPageQueryDTO taskPageQueryDTO);

    List<TaskResDTO> selectTaskPage(TaskPageQueryDTO taskPageQueryDTO);
}
