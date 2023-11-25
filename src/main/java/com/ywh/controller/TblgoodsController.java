package com.ywh.controller;

import com.ywh.bean.Tblgoods;
import com.ywh.service.TblgoodsService;
import com.ywh.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/goods")
public class TblgoodsController {
    @Resource
    private TblgoodsService tblgoodsService;

    @GetMapping("/list")
    public Result findGoodsList(Tblgoods tblgoods,Integer currentPage,Integer pageSize){
        return  tblgoodsService.findGoodsList(tblgoods,currentPage,pageSize);
    }
}