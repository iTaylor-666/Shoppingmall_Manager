package com.ywh.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tblorder {

  private long orderId;
  private String orderNo;
  private long userId;
  private long addrId;
  private double money;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp payTime;




}
