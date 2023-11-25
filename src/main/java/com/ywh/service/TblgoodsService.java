package com.ywh.service;

import com.ywh.bean.Tblgoods;
import com.ywh.utils.Result;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface TblgoodsService {
    Result findGoodsList(Tblgoods tblgoods, int currentPage, int pageSize);
    // List<String> findBrandsList();
    Result addGoods(MultipartFile mainImg,
                    MultipartFile detailImg0,
                    MultipartFile detailImg1,
                    MultipartFile detailImg2,
                    MultipartFile detailImg3,
                    Tblgoods tblgoods,
                    HttpServletRequest httpServletRequest);
    Result delGoods(long goodsId);
    Result findGoods(long goodsId);
    Result updateGoods(MultipartFile mainImg,
                       MultipartFile detailImg0,
                       MultipartFile detailImg1,
                       MultipartFile detailImg2,
                       MultipartFile detailImg3,
                       Tblgoods tblgoods,
                       HttpServletRequest httpServletRequest);
}
