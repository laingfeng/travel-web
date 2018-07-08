package com.liang.dao;

import com.liang.model.Reservation;
import java.util.List;

public interface ReservationMapper {
    int deleteByPrimaryKey(Integer reservatid);

    int insert(Reservation record);

    int insertSelective(Reservation record);

    Reservation selectByPrimaryKey(Integer reservatid);

    int updateByPrimaryKeySelective(Reservation record);

    int updateByPrimaryKey(Reservation record);

    List<Reservation> selectByUserId(Integer userid);
}