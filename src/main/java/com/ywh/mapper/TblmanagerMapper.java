package com.ywh.mapper;

import com.ywh.bean.Tblmanager;
import org.apache.ibatis.annotations.Param;

public interface TblmanagerMapper {
    Tblmanager findManager(@Param("managerAcc") String managerAcc, @Param("managerPwd") String managerPwd);
}
