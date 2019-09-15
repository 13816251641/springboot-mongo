package com.lujieni.mongo.service;


import com.lujieni.mongo.entity.ExceptionLog;
import com.mongodb.client.result.DeleteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExceptionLogService {

    @Autowired
    private MongoTemplate mongoTemplate;


    /**
     * 
     * @param value
     */
    public List<ExceptionLog> findByBody(String value){
        Query query = new Query();
        query.addCriteria(Criteria.where("body").is(value));
        List<ExceptionLog> result = mongoTemplate.find(query, ExceptionLog.class);
        return result;
    }
    

    /**
     * 使用insert添加数据
     * @param exceptionLog 实体信息
     * @return 保存后的信息
     */
    public ExceptionLog add(ExceptionLog exceptionLog) {
        return this.mongoTemplate.insert(exceptionLog);
    }

    /**
     * 根据主键进行删除
     * @param openId 主键
     * @return 删除的数量
     */
    public long delete(String openId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(openId));
        DeleteResult remove = this.mongoTemplate.remove(query, ExceptionLog.class);
        return remove.getDeletedCount();
    }

    /**
     * 使用update方式修改数据
     * @param exceptionLog 需要修改的信息
     */
    public void update(ExceptionLog exceptionLog) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(exceptionLog.getOpenId()));
        Update update = new Update();
        update.set("status", exceptionLog.getStatus());
        update.set("body", exceptionLog.getBody());
        this.mongoTemplate.updateFirst(query, update, ExceptionLog.class);
    }

    /**
     * 查询当前集合中所有的文档
     * @return list
     */
    public List<ExceptionLog> findAll() {
        return this.mongoTemplate.findAll(ExceptionLog.class);
    }


}
