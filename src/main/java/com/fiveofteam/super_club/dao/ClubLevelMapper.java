package com.fiveofteam.super_club.dao;

import com.fiveofteam.super_club.pojo.ClubLevel;

import java.util.List;

public interface ClubLevelMapper {
    int deleteByPrimaryKey(String uuId);

    int insert(ClubLevel record);

    int insertSelective(ClubLevel record);

    ClubLevel selectByPrimaryKey(String uuId);

    int updateByPrimaryKeySelective(ClubLevel record);

    int updateByPrimaryKey(ClubLevel record);

    /**
     * 查询社团级别列表
     * @return
     */
    List<ClubLevel> selectClubLevelList();

    /**
     * 查询指定社团级别数量
     * @param clName
     * @return
     */
    int selectClubLevelByName(String clName);

    /**
     * 查询指定社团级别数量
     * @param clubLevel
     * @return
     */
    int selectClubLevelByNameAndId(ClubLevel clubLevel);

    /**
     * 查询指定社团级别数量
     * @param uuId
     * @return
     */
    int selectClubLevelById(String uuId);

    /**
     * 删除指定社团级别
     * @param uuId
     * @return
     */
    int deleteClubLevelById(String uuId);


}