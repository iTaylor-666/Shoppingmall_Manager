package com.ywh.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tblmanager {

  private long managerId;
  private String managerAcc;
  private String managerPwd;
  private String realName;
  private long status;


}
