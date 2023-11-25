package com.ywh.mapper;

import com.ywh.bean.Tblgoods;

import java.util.List;

public interface TblgoodsMapper {
        List<Tblgoods> findGoodsList(Tblgoods tblgoods);
        // List<String> findBrandsList();
        int addGoods(Tblgoods tblgoods);
        int delGoods(long goodsId);
        Tblgoods findGoods(long goodsId);
        int updateGoods(Tblgoods tblgoods);
}
