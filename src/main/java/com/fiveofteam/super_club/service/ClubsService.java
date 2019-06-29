package com.fiveofteam.super_club.service;

import com.fiveofteam.super_club.pojo.ClubLevel;
import com.fiveofteam.super_club.pojo.Clubs;
import com.fiveofteam.super_club.pojo.LevelGroup;
import com.fiveofteam.super_club.tools.JsonResult;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ClubsService {

    /**
     * 查询社团名称列表
     * @return
     */
    JsonResult getList();

    /**
     * 查询社团对应信息
     * @param uuId
     * @return
     */
    @Transactional
    JsonResult getClubInfo(String uuId);

    /**
     * 查询所有社团信息
     * @return
     */
    @Transactional
    JsonResult getClubLists();

    /**
     * 创建社团
     * @param clubs
     * @param levelId
     * @return
     */
    @Transactional
    JsonResult addClub(Clubs clubs,String clubLogo, String levelId);

    /**
     * 更新社团信息
     * @param clubs
     * @param clubLogo
     * @param levelId
     * @return
     */
    @Transactional
    JsonResult updateClub(Clubs clubs, String clubLogo,String levelId);

    /**
     * 删除社团
     * @param clubs
     * @return
     */
    @Transactional
    JsonResult deleteClub(Clubs clubs);

    JsonResult uploadFile(MultipartFile file,String logo);
    JsonResult getLogo(String clubId);

}
