package com.qing.niu.workstation.dal;

import com.qing.niu.workstation.dal.dao.TableProjectADO;
import com.qing.niu.workstation.dal.dao.TableProjectAMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * <p>
 * </p>
 *
 * @Author Alan_gui
 * @Date 2021/1/14
 * @ProjectName IntelliJ IDEA
 * @Package com.qing.niu.workstation.dal
 * @Version 1.0.0
 */
public class MybatisDemo {

    @Test
    public void test1() {
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("spring.xml");
        //  单例 还是多例?
        //  应用生命周期是一样的
        //  跨线程 用的
        TableProjectAMapper mapper = context.getBean(TableProjectAMapper.class);
        System.out.println(mapper.selectById(12));
    }

    @Test
    public void test2(){
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("spring.xml");
        //  单例 还是多例?
        //  应用生命周期是一样的
        //  跨线程 用的
        TableProjectAMapper mapper = context.getBean(TableProjectAMapper.class);
        TableProjectADO ado = new TableProjectADO();
        ado.setName("A");
        ado.setWxid("12345");
        ado.setCreateTime(new Date());
        System.out.println(mapper.insert(ado));
        System.out.println(ado.getId());
    }
}
