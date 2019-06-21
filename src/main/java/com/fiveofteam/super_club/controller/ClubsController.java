package com.fiveofteam.super_club.controller;


import com.fiveofteam.super_club.config.NameConfig;
import com.fiveofteam.super_club.pojo.ClubLevel;
import com.fiveofteam.super_club.pojo.Clubs;
import com.fiveofteam.super_club.pojo.LevelGroup;
import com.fiveofteam.super_club.service.ClubsService;
import com.fiveofteam.super_club.tools.CommonStringTool;
import com.fiveofteam.super_club.tools.FallBackMsg;
import com.fiveofteam.super_club.tools.JsonResult;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/clubs")
public class ClubsController {
    @Value("${prop.upload-folder}")
    private String UPLOAD_FOLDER; //logo存放路径
    @Autowired
    private ClubsService clubsService;
    JsonResult jsonResult;

    /**
     * 查询社团列表
     * @return
     */
    @RequestMapping(value = "/selectList" , method = RequestMethod.GET)
    public JsonResult selectClubList(){
        jsonResult = new JsonResult();
        jsonResult.setStatus("400");
        try {
            jsonResult = clubsService.getList();
        }catch (Exception e){
            jsonResult.setStatus("500");
            jsonResult.setMsg(FallBackMsg.ResultFail.getDisplayName() + "，系统错误！");
        }
        return  jsonResult ;
    }

    /**
     * 查询社团列表信息
     * @return
     */
    @RequestMapping(value = "/selectLists" , method = RequestMethod.GET)
    public JsonResult selectClubLists(){
        jsonResult = new JsonResult();
        jsonResult.setStatus("400");
        try {
            jsonResult = clubsService.getClubLists();
        }catch (Exception e){
            jsonResult.setStatus("500");
            jsonResult.setMsg(FallBackMsg.ResultFail.getDisplayName() + "，系统错误！");
        }
        return  jsonResult ;
    }

    /**
     * 查询社团信息
     * @param uuId
     * @return
     */
    @RequestMapping(value = "/selectClubInfo",method = RequestMethod.GET)
    public  JsonResult selectClubInfo(String uuId){
        jsonResult = new JsonResult();
        jsonResult.setStatus("400");
        if ( null == uuId|| "".equals(uuId.trim())){
            jsonResult.setMsg(FallBackMsg.ResultFail.getDisplayName()+ ",社团ID不能为空");
            return jsonResult;
        }
        if (uuId.equals("0")){
            jsonResult.setMsg(FallBackMsg.ResultFail.getDisplayName()+ ",社团ID不能为零");
            return jsonResult;
        }
        try{
            jsonResult  = clubsService.getClubInfo(uuId);
        }catch (Exception e ){
            jsonResult.setStatus("500");
            jsonResult.setMsg(FallBackMsg.ResultFail.getDisplayName() + "，系统错误！");
            return jsonResult;
        }
        return jsonResult;
    }

    /**
     * 创建社团
     * @param clubs
     * @param file
     * @param levelId
     * @param session
     * @return
     */
    @RequestMapping(value = "/addClub" , method = RequestMethod.POST)
    public  JsonResult insertClub(Clubs clubs, MultipartFile file, String levelId, HttpSession session){
        jsonResult = new JsonResult();
        jsonResult.setStatus("400");
        if (null == clubs){
            jsonResult.setMsg(FallBackMsg.UpdateFail.getDisplayName() + "，传递数据不能为空！");
            return jsonResult;
        }
        if ( null == clubs.getClubsName()|| "".equals(clubs.getClubsName().trim())){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName()+ ",社团名称不能为空！");
            return  jsonResult;
        }
        if (clubs.getClubsName().length() >10){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName()+ ",社团名称要求10字以内！");
            return  jsonResult;
        }
        if ( null == clubs.getClubProfile() || "".equals(clubs.getClubProfile().trim())){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName()+ ",社团简介不能为空！");
            return  jsonResult;
        }
        if (clubs.getClubProfile().length() > 100 ){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + ",社团简介要求100字以内！");
            return  jsonResult;
        }
        if ( null == clubs.getClubLocation() || "".equals(clubs.getClubLocation().trim())){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName()+ ",社团地址不能为空！");
            return  jsonResult;
        }
        if (clubs.getClubLocation().length() > 100){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + ",社团地址要求100字以内！");
            return  jsonResult;
        }
        if (null == clubs.getClubTel() || "".equals(clubs.getClubTel().trim())){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + ",社团联系号码不能为空！");
            return jsonResult;
        }
        if (clubs.getClubTel().length() != 11){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + ",社团联系号码格式不正确！");
            return jsonResult;
        }
        if (null == file || "".equals(file)){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "，图片为空，请重新上传！");
            return  jsonResult;
        }
        if (null == levelId || "".equals(levelId.trim())){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "，社团级别不能为空！");
            return jsonResult;
        }

        try{
            jsonResult = clubsService.addClub(clubs,file,levelId);
        }catch (Exception e){
            jsonResult.setStatus("500");
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "系统错误！");
            return  jsonResult;
        }
        return jsonResult;
    }


    /**
     * 更新社团信息
     * @param clubs
     * @param file
     * @param levelId
     * @return
     */
    @RequestMapping(value = "/updateClub",method = RequestMethod.POST)
    public JsonResult updateClub(Clubs clubs, MultipartFile file,String levelId){
        jsonResult = new JsonResult();
        jsonResult.setStatus("400");
        if (null == clubs){
            jsonResult.setMsg(FallBackMsg.UpdateFail.getDisplayName() + "，数据不能为空！");
            return jsonResult;
        }
        if ( null == clubs.getClubsName()|| "".equals(clubs.getClubsName().trim())){
            jsonResult.setMsg(FallBackMsg.UpdateFail.getDisplayName()+ ",社团名称不能为空！");
            return  jsonResult;
        }
        if (clubs.getClubsName().length() >10){
            jsonResult.setMsg(FallBackMsg.UpdateFail.getDisplayName()+ ",社团名称要求10字以内！");
            return  jsonResult;
        }
        if (null == clubs.getClubProfile() ||"".equals(clubs.getClubProfile().trim())){
            jsonResult.setMsg(FallBackMsg.UpdateFail.getDisplayName()+ ",社团简介不能为空！");
            return  jsonResult;
        }
        if (clubs.getClubProfile().length() > 100 ){
            jsonResult.setMsg(FallBackMsg.UpdateFail.getDisplayName() + ",社团简介要求100字以内！");
            return  jsonResult;
        }
        if (null == clubs.getClubLocation()|| "".equals(clubs.getClubLocation().trim())){
            jsonResult.setMsg(FallBackMsg.UpdateFail.getDisplayName()+ ",社团地址不能为空！");
            return  jsonResult;
        }
        if (clubs.getClubLocation().length() > 100){
            jsonResult.setMsg(FallBackMsg.UpdateFail.getDisplayName() + ",社团地址要求100字以内！");
            return  jsonResult;
        }
        if (null == clubs.getClubTel() || "".equals(clubs.getClubTel().trim())){
            jsonResult.setMsg(FallBackMsg.UpdateFail.getDisplayName() + ",社团联系号码不能为空！");
            return jsonResult;
        }
        if (clubs.getClubTel().length() != 11){
            jsonResult.setMsg(FallBackMsg.UpdateFail.getDisplayName() + ",社团联系号码格式不正确！");
            return jsonResult;
        }
        if ( null == levelId || "".equals(levelId.trim())){
            jsonResult.setMsg(FallBackMsg.UpdateFail.getDisplayName() + "，社团级别不能为空！");
            return jsonResult;
        }
        if (null == clubs.getUuId() || "".equals(clubs.getUuId().trim())){
            jsonResult.setMsg(FallBackMsg.UpdateFail.getDisplayName() + "，社团ID不能为空！");
            return  jsonResult;
        }
        try{
                jsonResult = clubsService.updateClub(clubs,file,levelId);
        }catch (Exception e){
            jsonResult.setStatus("500");
            jsonResult.setMsg(FallBackMsg.UpdateFail.getDisplayName() + "系统错误！");
        }
        return  jsonResult;
    }

    /**
     * 删除社团
     * @param clubs
     * @return
     */
    @RequestMapping(value = "/delectClub" , method = RequestMethod.POST)
    public JsonResult delectClub(Clubs clubs){
        jsonResult = new JsonResult();
        jsonResult.setStatus("400");
        if (null == clubs){
            jsonResult.setMsg(FallBackMsg.UpdateFail.getDisplayName() + "，传递数据不能为空！");
            return jsonResult;
        }
        if (null == clubs.getUuId() || "".equals(clubs.getUuId().trim())){
            jsonResult.setMsg(FallBackMsg.UpdateFail.getDisplayName() + "，社团ID不能为空！");
            return  jsonResult;
        }
        int clubsNum = 0;
        try{
            //查询指定社团是否存在
            //删除关联数据
            //删除category_group关联数据
            //删除level_group关联数据

        }catch (Exception e ){
            jsonResult.setMsg(FallBackMsg.SysErrorInfo.getDisplayName());
        }
        return jsonResult;
    }


}
