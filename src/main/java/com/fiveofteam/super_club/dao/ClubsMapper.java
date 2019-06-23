package com.fiveofteam.super_club.dao;

import com.fiveofteam.super_club.pojo.Clubs;

import java.util.List;


public interface ClubsMapper {
    int deleteByPrimaryKey(String uuId);

    int insert(Clubs record);

    int insertSelective(Clubs record);

    Clubs selectByPrimaryKey(String uuId);

    int updateByPrimaryKeySelective(Clubs record);

    int updateByPrimaryKey(Clubs record);


    List selectClubInfoById(String uuId);
    /**
     * 查询所有社团列表
     * @return
     */
    List<Clubs> selectClubList();

    /**
     * 查询所有社团信息
     * @return
     */
    List<Clubs> selectClubLists();

    /**
     * 更新社团信息
     * @param clubs
     * @return
     */
    int updateClubInfo(Clubs clubs);

    /**
     * 查询社团Logo路径
     * @param uuId
     * @return
     */
    List<Clubs> selectClubLogoByPrimaryKey(String uuId);

    /**
     * 查询指定社团名称数量
     * @param clubName
     * @return
     */
    int selectClubsByName(String clubName);

    /**
     * 查询指定社团数量
     * @param clubs
     * @return
     */
    int selectClubsByNameAndId(Clubs clubs);

    /**
     * 查询指定社团数量
     * @param clubId
     * @return
     */
    int selectClubsById(String clubId);





}