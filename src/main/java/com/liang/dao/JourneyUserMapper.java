package com.liang.dao;

import com.liang.model.JourneyUser;

import java.util.List;

public interface JourneyUserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(JourneyUser record);

    int insertSelective(JourneyUser record);

    JourneyUser selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(JourneyUser record);

    int updateByPrimaryKey(JourneyUser record);

    List<JourneyUser> selectByName(String username);

    List<JourneyUser> selectAll();

}