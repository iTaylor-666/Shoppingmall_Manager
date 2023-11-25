package com.ywh.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ywh.bean.Tblgoods;
import com.ywh.mapper.TblgoodsMapper;
import com.ywh.mapper.TbltypeMapper;
import com.ywh.service.TblgoodsService;
import com.ywh.utils.Code;
import com.ywh.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Service
public class TblgoodsServiceImpl implements TblgoodsService {
    @Autowired
    private TblgoodsMapper tblgoodsMapper;
    /*@Autowired
    private TbltypeMapper tbltypeMapper;*/
    @Override
    public Result findGoodsList(Tblgoods tblgoods,int currentPage,int pageSize)
    {
        Result result = null;
        try {
            result = null;
            if(tblgoods.getMinPrice()==null){
                tblgoods.setMinPrice(0);
            }
            if(tblgoods.getMaxPrice()==null){
                tblgoods.setMaxPrice(0);
            }
            PageHelper.startPage(currentPage,pageSize);
            List<Tblgoods> goodsList = tblgoodsMapper.findGoodsList(tblgoods);
            PageInfo<Tblgoods> pageInfo = new PageInfo<>(goodsList);
            result = new Result(pageInfo,"查询商品列表成功",Code.FIND_OK);
        } catch (Exception e) {
            e.printStackTrace();
            result = new Result(null,"查询商品列表异常："+e.getMessage(),Code.FIND_ERR);
        }
        return result;
    }
    // @Override
// public List<String> findBrandsList() {
// return tblgoodsMapper.findBrandsList();
// }
    @Override
    public Result addGoods(MultipartFile mainImg,
                           MultipartFile detailImg0,
                           MultipartFile detailImg1,
                           MultipartFile detailImg2,
                           MultipartFile detailImg3,
                           Tblgoods tblgoods,
                           HttpServletRequest httpServletRequest) {
        Result result = null;
//保存图片到服务器，并且返回图片的相对路径
       /* String mainImage = ImageUtils.saveImage(mainImg, httpServletRequest);
        String image1 = ImageUtils.saveImage(detailImg0, httpServletRequest);
        String image2 = ImageUtils.saveImage(detailImg1, httpServletRequest);
        String image3 = ImageUtils.saveImage(detailImg2, httpServletRequest);
        String image4 = ImageUtils.saveImage(detailImg3, httpServletRequest);*/
//把返回的图片路径设置到对象中
       /* tblgoods.setMainImage(mainImage);
        tblgoods.setImage1(image1);
        tblgoods.setImage2(image2);
        tblgoods.setImage3(image3);
        tblgoods.setImage4(image4);
//判断日期栏位，以防报错
        if("".equals(tblgoods.getDeadDate())){
            tblgoods.setDeadDate(null);
        }
        int i = tblgoodsMapper.addGoods(tblgoods);
        if(i==1){
            result = new Result(i,"添加商品成功",Code.ADD_OK);
        }else{
            result = new Result(i,"添加商品失败",Code.ADD_ERR);
        }*/
        return result;
    }
    @Override
    public Result delGoods(long goodsId) {
        Result result = null;
        int i = tblgoodsMapper.delGoods(goodsId);
        if(i==1){
            result = new Result(i,"删除商品成功",Code.DELETE_OK);
        }else{
            result = new Result(i,"删除商品失败",Code.DELETE_ERR);
        }
        return result;
    }
    @Override
    public Result findGoods(long goodsId) {
        Result result = null;
       /* Tblgoods tblgoods = tblgoodsMapper.findGoods(goodsId);
        if(null != tblgoods){
            List<Long> list = new ArrayList<>();
            long goodsTypeId = tblgoods.getGoodsTypeId();
            list.add(goodsTypeId);
            while(true){
                goodsTypeId = tbltypeMapper.findParentId(goodsTypeId);
                if(goodsTypeId==0){
                    break;
                }
                list.add(goodsTypeId);
            }
            tblgoods.setGoodsTypeIds(list);
            result = new Result(tblgoods,"查找商品成功",Code.DELETE_OK);
        }else{
            result = new Result(null,"查找商品失败",Code.DELETE_ERR);
        }*/
        return result;
    }
    @Override
    public Result updateGoods(MultipartFile mainImg,
                              MultipartFile detailImg0,
                              MultipartFile detailImg1,
                              MultipartFile detailImg2,
                              MultipartFile detailImg3,
                              Tblgoods tblgoods,
                              HttpServletRequest httpServletRequest) {
        Result result = null;
//保存图片到服务器，并返回图片相对路径
        /*String mainImage = ImageUtils.saveImage(mainImg, httpServletRequest);
        String image1 = ImageUtils.saveImage(detailImg0, httpServletRequest);
        String image2 = ImageUtils.saveImage(detailImg1, httpServletRequest);
        String image3 = ImageUtils.saveImage(detailImg2, httpServletRequest);
        String image4 = ImageUtils.saveImage(detailImg3, httpServletRequest);
//把图片路径设置到对象中
        tblgoods.setMainImage(mainImage);
        tblgoods.setImage1(image1);
        tblgoods.setImage2(image2);
        tblgoods.setImage3(image3);
        tblgoods.setImage4(image4);
//处理日期异常问题
        if("".equals(tblgoods.getDeadDate())){
            tblgoods.setDeadDate(null);
        }
        int i = tblgoodsMapper.updateGoods(tblgoods);
        if(i==1){
            result = new Result(i,"修改商品成功",Code.UPDATE_OK);
        }else{
            result = new Result(i,"修改商品失败",Code.UPDATE_ERR);
        }*/
        return result;
    }
}