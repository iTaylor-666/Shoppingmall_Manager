package com.ywh.service;

import com.ywh.bean.Tblmanager;
import com.ywh.utils.Result;

import javax.servlet.http.HttpSession;

public interface TblmanagerService {
    Result findManager(String managerAcc, String managerPwd, HttpSession session);
}
