package com.ywh.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tblgoods {

  private long goodsId;
  private long goodsTypeId;
  private String goodsNo;
  private String goodsName;
  private String goodsBrand;
  private double goodsPrice;
  private String goodsUnits;
  private double goodsDiscount;
  private double repertoryNum;
  private long status;
  private java.sql.Date createDate;
  private java.sql.Date deadDate;
  private String mainImage;
  private String image1;
  private String image2;
  private String image3;
  private String image4;

  //查询参数
  private Integer minPrice;
  private Integer maxPrice;


}
