package com.lujieni.mongo;

import com.lujieni.mongo.entity.ExceptionLog;
import com.lujieni.mongo.service.ExceptionLogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMongoApplicationTests {

    @Autowired
    private ExceptionLogService exceptionLogService;


    /**
     * 根据body字段的值进行搜索
     */
    @Test
    public void findByBody(){
        List<ExceptionLog> result = exceptionLogService.findByBody("服务不可用");
        System.out.println(result);
    }


    /**
     * 插入一条数据
     */
    @Test
    public void insertOne() {
        ExceptionLog exceptionLog = new ExceptionLog();
        exceptionLog.setStatus(400);
        exceptionLog.setBody("传递参数错误");
        ExceptionLog entity = this.exceptionLogService.add(exceptionLog);
        System.out.println("------------------------------------------------------------");
        System.out.println("添加数据结果：" + entity);
    }

    /**
     * 根据id修改数据
     */
    @Test
    public void updateOneById() {
        //修改数据
        ExceptionLog entity = new ExceptionLog();
        entity.setOpenId("5d7cf57220ad4b1de4abca41");
        entity.setStatus(500);
        entity.setBody("服务不可用");
        this.exceptionLogService.update(entity);
    }

    /**
     * 得到所有数据
     */
    @Test
    public void findAll(){
        //查询数据
        List<ExceptionLog> all = exceptionLogService.findAll();
        System.out.println("------------------------------------------------------------");
        System.out.println("所有结果：" + all);
    }

    /**
     * 根据主键删除数据
     */
    @Test
    public void deleteById(){
        long delete = this.exceptionLogService.delete("5d7cf57220ad4b1de4abca41");
        System.out.println("------------------------------------------------------------");
        System.out.println("删除条数：" + delete);
    }









}
