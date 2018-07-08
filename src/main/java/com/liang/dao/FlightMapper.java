package com.liang.dao;

import com.liang.model.Flight;

import java.util.List;

public interface FlightMapper {
    int deleteByPrimaryKey(String flightnum);

    int insert(Flight record);

    int insertSelective(Flight record);

    Flight selectByPrimaryKey(String flightnum);

    int updateByPrimaryKeySelective(Flight record);

    int updateByPrimaryKey(Flight record);

    List<Flight> selectAll();
}