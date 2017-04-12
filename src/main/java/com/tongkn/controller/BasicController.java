package com.tongkn.controller;

import com.tongkn.dao.BasicDao;
import com.tongkn.entity.UserEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by tongkn on 2017/4/10.
 */
@Controller
public class BasicController {
    @Autowired
    BasicDao basicDao;

    Logger LOG = LogManager.getLogger(BasicController.class);

    @RequestMapping(value = "/basic")
    @ResponseBody
    public String basic(HttpServletRequest request){
        LOG.info("trying to save user");
        LOG.error("trying to save user,error");
        return "hello";
    }

    @ResponseBody
    @RequestMapping(value = "/saveuser")
    public String saveUser(HttpServletRequest request){
        UserEntity user = new UserEntity();
        user.setUsername(request.getParameter("name"));
        user.setPassword(request.getParameter("password"));
        int id = basicDao.saveUserEntity(user);
        return "id:"+id;
    }

    @ResponseBody
    @RequestMapping(value = "getuser")
    public String getUser(HttpServletRequest request){
        int id = Integer.valueOf(request.getParameter("id"));
        UserEntity user = basicDao.getUserEntiryById(id);
        return "name:"+user.getUsername()+" password:"+user.getPassword();
    }

}
