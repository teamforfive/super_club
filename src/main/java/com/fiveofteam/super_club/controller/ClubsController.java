package com.fiveofteam.super_club.controller;


import com.fiveofteam.super_club.pojo.ClubLevel;
import com.fiveofteam.super_club.pojo.Clubs;
import com.fiveofteam.super_club.pojo.LevelGroup;
import com.fiveofteam.super_club.service.ClubsService;
import com.fiveofteam.super_club.tools.CommonStringTool;
import com.fiveofteam.super_club.tools.FallBackMsg;
import com.fiveofteam.super_club.tools.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    private String UPLOAD_FOLDER;
    @Autowired
    private ClubsService clubsService;
    JsonResult jsonResult = new JsonResult();


    @CrossOrigin//允许跨域，用于前端测试
    @RequestMapping(value = "/clubList" , method = RequestMethod.GET)
    public JsonResult clubList(){
            jsonResult.setItem(null);
            jsonResult = clubsService.clubList();
        return  jsonResult ;
    }

    /**
     * 查询社团信息
     * @param uuId
     * @return
     */
    @CrossOrigin //允许跨域，用于前端测试
    @RequestMapping(value = "/clubInfo",method = RequestMethod.GET)
    public  JsonResult clubInfo(String uuId){
        jsonResult.setItem(null);
        jsonResult.setStatus("400");
        if (uuId == null){
            jsonResult.setMsg(FallBackMsg.ResultFail.getDisplayName()+ ",ID不能为空");
            return jsonResult;
        }
        if (uuId.equals("0")){
            jsonResult.setMsg(FallBackMsg.ResultFail.getDisplayName()+ ",ID不能为零");
            return jsonResult;
        }
        try{
            jsonResult  = clubsService.clubInfo(uuId);
        }catch (Exception e ){
            jsonResult.setStatus("400");
            jsonResult.setMsg(FallBackMsg.ResultFail.getDisplayName() + "，系统错误！");
            return jsonResult;
        }
        return jsonResult;
    }



    @CrossOrigin//允许跨域，用于前端测试
    @RequestMapping(value = "/addClub" , method = RequestMethod.POST)
    public  JsonResult addClub(Clubs clubs, MultipartFile file,String levelId){
        jsonResult.setItem(null);
        jsonResult.setStatus("400");
        if (clubs.getClubsName() == null || clubs.getClubsName().trim() == ""){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName()+ ",社团名称不能为空！");
            return  jsonResult;
        }
        if (clubs.getClubsName().length() >10){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName()+ ",社团名称要求10字以内！");
            return  jsonResult;
        }
        if (clubs.getClubProfile() == null || clubs.getClubProfile() == ""){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName()+ ",社团简介不能为空！");
            return  jsonResult;
        }
        if (clubs.getClubProfile().length() > 100 ){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + ",社团简介要求100字以内！");
            return  jsonResult;
        }
        if (clubs.getClubLocation() == null || clubs.getClubLocation() == ""){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName()+ ",社团地址不能为空！");
            return  jsonResult;
        }
        if (clubs.getClubLocation().length() > 100){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + ",社团地址要求100字以内！");
            return  jsonResult;
        }
        if (clubs.getClubTel() == null || clubs.getClubTel() == ""){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + ",社团联系号码不能为空！");
            return jsonResult;
        }
        if (clubs.getClubTel().length() != 11){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + ",社团联系号码格式不正确！");
            return jsonResult;
        }
        if (file == null || file.isEmpty()){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "，图片为空，请重新上传！");
            return  jsonResult;
        }
        if (levelId == null || levelId == ""){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "，社团级别不能为空！");
            return jsonResult;
        }
        //查询社团名称是否已经存在
        List<Clubs> clublist = clubsService.selectClubName(clubs.getClubsName());
        if (clublist != null && clublist.size() != 0){
            Clubs clubs1 = clublist.get(0);
            //根据返回的UUID判断是否存在
            if (clubs1.getUuId() != null){
                jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "，社团名称已存在！");
                return  jsonResult;
            }
        }
        try{
            byte [] bytes = file.getBytes();
            DateFormat df = new SimpleDateFormat("yyyMMddHHmmssSSS");
            //图片名称 采取时间拼接随机数
            String fileName = df.format(new Date());
            Random r = new Random();
            for (int i = 0 ; i<3; i++){
                fileName += r.nextInt(10);
            }
            Path path = Paths.get(UPLOAD_FOLDER + fileName + file.getOriginalFilename());
            //如果没有files文件夹，则创建
            if (!Files.isWritable(path)){
                Files.createDirectories(Paths.get(UPLOAD_FOLDER));
            }

            //社团编码参考邮编格式，测试先写死
            clubs.setClubCode("100"+ (int)(Math.random() * 100));
            //设置LOGO路径
            clubs.setClubLogo(fileName + file.getOriginalFilename());
            //设置状态
            clubs.setClubStatus(true);
            //设置创建时间
            clubs.setCreateTime(new Timestamp(System.currentTimeMillis()));
            //获取并写入 UuId
            String clubUuId =CommonStringTool.UUID();
            clubs.setUuId(clubUuId);
            //测试先写死 创建者id----------------------
            clubs.setClubCreateId("1");
            //文件写入指定路径
            Files.write(path,bytes);

            //设置LevelGroup的值
             LevelGroup levelGroup = new LevelGroup();
            //设置UUID
            levelGroup.setUuId(CommonStringTool.UUID());
            //设置社团ID
            levelGroup.setLgClubid(clubUuId);
            //设置社团级别ID
            levelGroup.setLgLevelid(levelId);
            //设置创建时间
            levelGroup.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            jsonResult = clubsService.addClub(clubs,levelGroup);

            if (jsonResult.getStatus().equals("400")){
                //将写入文件删除
                File logofile = new File(UPLOAD_FOLDER + fileName + file.getOriginalFilename());
                if (logofile.exists()){
                    //System.out.println("进入文件路径");
                    if (logofile.delete()){
                        System.out.println("文件删除成功！");
                    }else{
                        System.out.println("文件删除失败！");
                    }
                }
            }
            //jsonResult.setStatus("200");
            //jsonResult.setMsg(FallBackMsg.AddOk.getDisplayName() + ",创建社团成功！");
        }catch (Exception e){
            jsonResult.setStatus("400");
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "系统错误！");
            return  jsonResult;
        }
        return jsonResult;
    }


    @CrossOrigin
    @RequestMapping(value = "/updateClub",method = RequestMethod.POST)
    public JsonResult updateClub(Clubs clubs, MultipartFile file,String levelId){
        jsonResult.setItem(null);
        jsonResult.setStatus("400");
        if (clubs.getClubsName() == null || clubs.getClubsName() == ""){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName()+ ",社团名称不能为空！");
            return  jsonResult;
        }
        if (clubs.getClubsName().length() >10){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName()+ ",社团名称要求10字以内！");
            return  jsonResult;
        }
        if (clubs.getClubProfile() == null || clubs.getClubProfile() == ""){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName()+ ",社团简介不能为空！");
            return  jsonResult;
        }
        if (clubs.getClubProfile().length() > 100 ){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + ",社团简介要求100字以内！");
            return  jsonResult;
        }
        if (clubs.getClubLocation() == null || clubs.getClubLocation() == ""){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName()+ ",社团地址不能为空！");
            return  jsonResult;
        }
        if (clubs.getClubLocation().length() > 100){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + ",社团地址要求100字以内！");
            return  jsonResult;
        }
        if (clubs.getClubTel() == null || clubs.getClubTel() == ""){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + ",社团联系号码不能为空！");
            return jsonResult;
        }
        if (clubs.getClubTel().length() != 11){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + ",社团联系号码格式不正确！");
            return jsonResult;
        }
//        if (file == null || file.isEmpty()){
//            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "，图片为空，请重新上传！");
//            return  jsonResult;
//        }
        if (levelId == null || levelId == ""){
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "，社团级别不能为空！");
            return jsonResult;
        }
        //查询社团名称是否已经存在
        List<Clubs> clublist = clubsService.selectClubName(clubs.getClubsName());
        if (clublist != null && clublist.size() != 0){
            Clubs clubs1 = clublist.get(0);
            //判断返回的UUID是否与自身的相同
            if (!clubs1.getUuId().equals(clubs.getUuId())){
                jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + ", 社团名称已存在！");
                return jsonResult;
            }
        }
        try{
            //获取UUID
            String uuId = clubs.getUuId();
            //获取图片文件对应的存储路径
            List<Clubs> clubLogoList = clubsService.selectClubLogo(uuId);
            //存储数据库LOGO旧路径
            String logoPath = "";
            String clubLogo = "";
            if (clubLogoList.size() != 0 && clubLogoList != null){
                Clubs club = clubLogoList.get(0);
                clubLogo = club.getClubLogo();
                //存储LOGO旧路径
                logoPath = UPLOAD_FOLDER + clubLogo;
                //System.out.println("旧的图片路径"+logoPath);
            }
            //更新LevelGroup表的社团级别ID
            LevelGroup levelGroup = new LevelGroup();
            //设置社团ID
            levelGroup.setLgClubid(clubs.getUuId());
            //设置社团级别ID
            levelGroup.setLgLevelid(levelId);

            if (file !=null && !file.isEmpty()){

                byte [] bytes = file.getBytes();
                DateFormat df = new SimpleDateFormat("yyyMMddHHmmssSSS");
                //图片名称 采取时间拼接随机数
                String fileName = df.format(new Date());
                Random r = new Random();
                for (int i = 0 ; i<3; i++){
                    fileName += r.nextInt(10);
                }
                //设置图片文件路径
                Path newPath = Paths.get(UPLOAD_FOLDER + fileName + file.getOriginalFilename());
                //如果没有files文件夹，则创建
                if (!Files.isWritable(newPath)){
                    Files.createDirectories(Paths.get(UPLOAD_FOLDER));
                }
                //设置新LOGO路径
                clubs.setClubLogo(fileName + file.getOriginalFilename());
                //System.out.println("新的图片路径"+UPLOAD_FOLDER+fileName + file.getOriginalFilename());
                //返回serviceImpl结果
                jsonResult = clubsService.updateClub(clubs,levelGroup);

                if (jsonResult.getStatus().equals("200")){
                    //删除对应的图片文件
                    File logofile = new File(logoPath);
                    if (logofile.exists()){
                        //System.out.println("进入文件路径");
                        if (logofile.delete()){
                            //新文件写入指定路径
                            Files.write(newPath,bytes);
                            //System.out.println("图片存储成功");
                            //System.out.println("文件删除成功！");
                        }else{
                            //System.out.println("文件删除失败！");
                        }
                    }
                }
            }else{
                //file为空，则路径不变
                clubs.setClubLogo(clubLogo);
                jsonResult = clubsService.updateClub(clubs,levelGroup);
            }

        }catch (Exception e){
            jsonResult.setStatus("400");
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "系统错误！");
        }
        return  jsonResult;
    }


}
