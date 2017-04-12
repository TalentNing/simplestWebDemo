package com.tongkn.dao;

import com.tongkn.entity.UserEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by tongkn on 2017/4/10.
 */
@Repository
public class BasicDao {
    @Autowired
    SessionFactory sessionFactory;

    Logger loger = LogManager.getLogger(BasicDao.class);
    /**
     * save userEntity
     */
    @Transactional
    public int saveUserEntity(UserEntity user){
        sessionFactory.getCurrentSession().save(user);
        return user.getId();
    }

    /**
     * get userEntiry by id
     */
    @Transactional
    public UserEntity getUserEntiryById(int id){
        Criteria c = sessionFactory.getCurrentSession().createCriteria(UserEntity.class);
        c.add(Restrictions.eq("id",id));
        List<UserEntity> userEntities = c.list();
        if(userEntities!=null && userEntities.size()!=0){
            return userEntities.get(0);
        }
        return null;
    }
}
