package com.ywh.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tbltype {

  private long goodsTypeId;
  private String typeName;
  private long parentId;
  private long status;



}
