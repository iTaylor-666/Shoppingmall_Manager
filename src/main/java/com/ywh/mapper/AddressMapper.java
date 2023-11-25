package com.ywh.mapper;

import com.ywh.bean.Tbladdress;
import org.springframework.stereotype.Component;

import java.util.List;


public interface AddressMapper {
    List<Tbladdress> selectAll();
}