package com.cheyipai.platformservice.thirdparty.controller;

import com.cheyipai.platformservice.thirdparty.service.MenuService;
import com.cheyipai.platformservice.thirdparty.entity.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/16.
 */
@Controller
public class IndexController {

    private static final Logger LOG = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private MenuService menuService;
    @RequestMapping( value={"/","/index"})
    public String index(HttpServletRequest request){
        LOG.info("index -----------------");
        Menu rootMenu = menuService.getRootMenu();

        request.setAttribute("rootMenu",rootMenu);
        System.out.println(rootMenu);
        return "index";
    }
    @ResponseBody
    @RequestMapping("/index/json")
    public Map jsonData(){
        LOG.info("json -----------------");
        Map map = new HashMap<>();
        map.put(1,"zhangs");
        map.put(2,"你好ma");
        return map;
    }
    @RequestMapping("/index/welcome")
    public String welcome(){
        LOG.info("json -----------------");
        Map map = new HashMap<>();
        map.put(1,"zhangs");
        map.put(2,"你好ma");
        return "welcome";
    }
}
