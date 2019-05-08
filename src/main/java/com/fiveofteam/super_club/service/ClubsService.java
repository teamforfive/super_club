package com.fiveofteam.super_club.service;

import com.fiveofteam.super_club.pojo.ClubLevel;
import com.fiveofteam.super_club.pojo.Clubs;
import com.fiveofteam.super_club.pojo.LevelGroup;
import com.fiveofteam.super_club.tools.JsonResult;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ClubsService {

    /**
     * 查询校内社团名称列表
     * @return
     */
    JsonResult clubList();

    /**
     * 查询校内社团对应信息
     * @param uuId
     * @return
     */
    JsonResult clubInfo(String uuId);

    /**
     * 创建校内社团
     * @param clubs
     * @param levelGroup
     * @return
     */
    @Transactional
    JsonResult addClub(Clubs clubs, LevelGroup levelGroup);

    /**
     * 更新校内社团信息
     * @param clubs
     * @return
     */
    @Transactional
    JsonResult updateClub(Clubs clubs,LevelGroup levelGroup);

    /**
     *获取社团LOGO
     * @param uuId
     * @return
     */
    List selectClubLogo(String uuId);

    /**
     * 查询指定社团名称
     * @param clubsName
     * @return
     */
    List selectClubName(String clubsName);

}
