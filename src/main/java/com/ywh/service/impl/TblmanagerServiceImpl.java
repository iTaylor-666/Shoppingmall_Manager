package com.ywh.service.impl;

import com.ywh.bean.Tblmanager;
import com.ywh.mapper.TblmanagerMapper;
import com.ywh.service.TblmanagerService;
import com.ywh.utils.Code;
import com.ywh.utils.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Service
public class TblmanagerServiceImpl implements TblmanagerService {

    @Resource
    private TblmanagerMapper tblmanagerMapper;

    @Override
    public Result findManager(String managerAcc, String managerPwd,HttpSession session) {
        Tblmanager tblmanager = null;

        tblmanager = tblmanagerMapper.findManager(managerAcc,managerPwd);
        try{
            if (tblmanager != null){
                session.setAttribute("manager",tblmanager);
                return new Result(tblmanager,"登录成功",Code.FIND_OK);
            }else {
                return new Result(null,"登录失败",Code.FIND_ERR);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new Result(null,"登录异常：" + e.getMessage(),Code.FIND_ERR);
        }
    }
}