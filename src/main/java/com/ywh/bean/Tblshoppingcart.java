package com.ywh.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tblshoppingcart {

  private long cartId;
  private long userId;
  private long goodsId;
  private long goodsNum;



}
