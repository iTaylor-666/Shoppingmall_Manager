package com.ywh.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tblevaluate {

  private long evaluateId;
  private long userId;
  private long goodsId;
  private String content;
  private java.sql.Timestamp createTime;




}
