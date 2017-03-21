package com.cheyipai.platformservice.thirdparty.service;

import com.cheyipai.platformservice.thirdparty.mapper.ThirdMenuMapper;
import com.cheyipai.platformservice.thirdparty.entity.Menu;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/21.
 */
@Service
public class MenuService {
    @Resource
    private ThirdMenuMapper thirdMenuMapper;

    public Menu getRootMenu(){
        List<Menu> menus = new ArrayList<>();//thirdMenuMapper.getMenus();
        Menu account = new Menu();
        account.setId(22);
        account.setName("授权管理");
        account.setUrl("/account/selectAccount");
        account.setParentId(-1);
        menus.add(0,account);

        Menu vendor = new Menu();
        vendor.setId(1);
        vendor.setName("供应商信息管理");
        vendor.setUrl("/vendor/selectVendor");
        vendor.setParentId(-1);
        menus.add(1,vendor);

        Menu access = new Menu();
        access.setId(2);
        access.setName("外部访问信息");
        access.setUrl("/access/selectAccess");
        access.setParentId(-1);
        menus.add(2,access);
        Menu rootMenu = new Menu();
        rootMenu.setId(Menu.ROOT_FLAG);
        a(rootMenu,menus);
        return rootMenu;
    }

    private void a(Menu parentMenu,List<Menu> allMenus){
        List<Menu> children = getChildren(allMenus,parentMenu.getId());
        if(children!=null){
            parentMenu.setChildren(children);
            for(Menu m : children){
                a(m,allMenus);
            }
        }
    }
    private List<Menu> getChildren(List<Menu> menus , int parentId){
        List<Menu> children = new ArrayList<>();
        for(Menu m : menus){
            if(m.getParentId()==parentId){
                children.add(m);
            }
        }
        if(children.size()==0){
            children = null;
            return null;
        }else
            return children;
    }
}
