package com.ywh.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tbladdress {

  private long addrId;
  private long userId;
  private long regionId;
  private String addr;

}
