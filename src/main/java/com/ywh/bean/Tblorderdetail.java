package com.ywh.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tblorderdetail {

  private long orderDetailId;
  private long orderId;
  private long goodsId;
  private long goodsNum;



}
