package com.ywh.controller;

import com.ywh.bean.Tblmanager;
import com.ywh.service.TblmanagerService;
import com.ywh.utils.Code;
import com.ywh.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/manager")
public class TblmanagerController {
    @Resource
    private TblmanagerService tblmanagerService;
    @PostMapping("/login")
    public Result login(Tblmanager tblmanager, HttpSession httpSession){
        Result result = tblmanagerService
                .findManager(tblmanager.getManagerAcc(), tblmanager.getManagerPwd(),httpSession);
        return result;
    }


    @GetMapping("/logout")
    public void logout(HttpSession httpSession){
        Tblmanager tblmanager = (Tblmanager) httpSession.getAttribute("manager");
        httpSession.removeAttribute("manager");
    }

}