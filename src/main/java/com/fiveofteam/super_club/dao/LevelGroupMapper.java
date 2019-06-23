package com.fiveofteam.super_club.dao;

import com.fiveofteam.super_club.pojo.LevelGroup;

import java.util.List;

public interface LevelGroupMapper {
    int deleteByPrimaryKey(String uuId);

    int insert(LevelGroup record);

    int insertSelective(LevelGroup record);

    LevelGroup selectByPrimaryKey(String uuId);

    int updateByPrimaryKeySelective(LevelGroup record);

    int updateByPrimaryKey(LevelGroup record);

    /**
     * 更新社团级别ID
     * @param levelGroup
     * @return
     */
    int updateLevelByClubId(LevelGroup levelGroup);

    /**
     * 查询社团级别ID
     * @param clubid
     * @return
     */
    List<LevelGroup> selectByClubid(String clubid);

}