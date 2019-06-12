package com.fiveofteam.super_club.service.impl;

import com.fiveofteam.super_club.dao.AuRoleMapper;
import com.fiveofteam.super_club.pojo.AuRole;
import com.fiveofteam.super_club.service.AuRoleService;
import com.fiveofteam.super_club.tools.CommonStringTool;
import com.fiveofteam.super_club.tools.DateTools;
import com.fiveofteam.super_club.tools.FallBackMsg;
import com.fiveofteam.super_club.tools.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuRoleServiceImpl implements AuRoleService {
    @Autowired
    AuRoleMapper auRoleMapper;
    private static final Logger logger = LoggerFactory.getLogger(AuRoleServiceImpl.class);
    JsonResult jsonResult;

    /**
     * 为用户附加角色
     *
     * @param auRole
     */
    @Override
    @Transactional
    public JsonResult patchRole(AuRole auRole) {
        jsonResult = new JsonResult();
        jsonResult.setStatus("400");
        int num;
        try {
            //查询用户是否有该角色
            // auRole.getRoleId();
            // auRole.getAuId();
            // auRole.getClubId();
            num = auRoleMapper.selectByIdAndOragnizeId(auRole);
            if (num > 0) {
                jsonResult.setMsg("角色已经存在！");
                return jsonResult;
            }
            auRole.setUuId(CommonStringTool.UUID());
            auRole.setCreateTime(DateTools.currentTime());
            jsonResult.setMsg("角色添加成功！");
            jsonResult.setStatus("200");
            auRoleMapper.insertSelective(auRole);
        } catch (Exception e) {
            logger.info(e.getMessage());
            jsonResult.setStatus(FallBackMsg.SysErrorInfo.getValue());
            jsonResult.setMsg(FallBackMsg.SysErrorInfo.getDisplayName());
            return jsonResult;
        }
        return jsonResult;
    }

    @Override
    public JsonResult updateRole(AuRole auRole) {
        return jsonResult;
    }
}
