package com.ywh.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tblregion {

  private long regionId;
  private String regionName;
  private long parentId;



}
