package com.fiveofteam.super_club.service.impl;


import com.fiveofteam.super_club.dao.ClubLevelMapper;
import com.fiveofteam.super_club.dao.ClubsMapper;
import com.fiveofteam.super_club.dao.LevelGroupMapper;
import com.fiveofteam.super_club.pojo.Clubs;
import com.fiveofteam.super_club.pojo.LevelGroup;
import com.fiveofteam.super_club.service.ClubsService;
import com.fiveofteam.super_club.tools.CommonStringTool;
import com.fiveofteam.super_club.tools.FallBackMsg;
import com.fiveofteam.super_club.tools.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ClubsServiceImpl implements ClubsService {
    @Autowired
    private ClubsMapper clubsMapper;
    @Autowired
    private LevelGroupMapper levelGroupMapper;
    @Autowired
    private ClubLevelMapper clubLevelMapper;
    @Value("${prop.upload-folder}")
    private String UPLOAD_FOLDER; //logo存放路径
    JsonResult jsonResult;

    @Override
    public JsonResult getList() {
        jsonResult  = new JsonResult();
            try{
                Map map = new HashMap();
                List clubs = clubsMapper.selectClubList();
                map.put("data",clubs);
                jsonResult.setItem(map);
                jsonResult.setStatus("200");
                jsonResult.setMsg(FallBackMsg.ResultOk.getDisplayName() + "，查询社团列表成功！");
            }catch (Exception e){
                jsonResult.setStatus("400");
                jsonResult.setMsg(FallBackMsg.ResultFail.getDisplayName() + "，查询社团列表失败！");
            }
        return jsonResult;
    }


    @Override
    public JsonResult getClubInfo(String uuId) {
        jsonResult  = new JsonResult();
        try {
            Map map = new HashMap();
            Clubs clubs = clubsMapper.selectByPrimaryKey(uuId);
            map.put("data",clubs);
            jsonResult.setItem(map);
            jsonResult.setStatus("200");
            jsonResult.setMsg(FallBackMsg.ResultOk.getDisplayName() + "，查询社团信息成功！");
        }catch (Exception e ){
            jsonResult.setStatus("400");
            jsonResult.setMsg(FallBackMsg.ResultFail.getDisplayName() + "，查询社团信息失败！");
        }
        return jsonResult;
    }

    @Override
    public JsonResult getClubLists(){
        jsonResult = new JsonResult();
        try {
            Map map = new HashMap();
            List clubslists = clubsMapper.selectClubLists();
            map.put("data",clubslists);
            jsonResult.setItem(map);
            jsonResult.setStatus("200");
            jsonResult.setMsg(FallBackMsg.ResultOk.getDisplayName() + "，查询所有社团信息成功！");
        }catch (Exception e){
            jsonResult.setStatus("400");
            jsonResult.setMsg(FallBackMsg.ResultFail.getDisplayName()  + "，查询所有社团信息失败！");
        }
        return jsonResult;
    }

    @Override
    public JsonResult addClub(Clubs clubs, MultipartFile file, String levelId ) {
        jsonResult  = new JsonResult();
        String fileName = "";
        int clubNameNum = 0;
        try{
            //查询社团名称是否已经存在
            clubNameNum = clubsMapper.selectClubsByName(clubs.getClubsName());
            if (clubNameNum > 0){
                jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName() + "，社团名称已存在！");
                return  jsonResult;
            }
            byte [] bytes = file.getBytes();
            DateFormat df = new SimpleDateFormat("yyyMMddHHmmssSSS");
            //图片名称 采取时间拼接随机数
            fileName = df.format(new Date());
            Random r = new Random();
            for (int i = 0 ; i<3; i++){
                fileName += r.nextInt(10);
            }
            //设置路径变量，生成路径为：本地硬盘路径+随机数+文件上传名称
            Path path = Paths.get(UPLOAD_FOLDER + fileName + file.getOriginalFilename());
            //如果没有files文件夹，则创建
            if (!Files.isWritable(path)){
                Files.createDirectories(Paths.get(UPLOAD_FOLDER));
            }

            //社团编码参考邮编格式，测试先写死
            clubs.setClubCode("1"+ (int)(Math.random() * 10000));
            //设置LOGO路径
            clubs.setClubLogo(fileName + file.getOriginalFilename());
            //设置状态
            clubs.setClubStatus(true);
            //设置创建时间
            clubs.setCreateTime(new Timestamp(System.currentTimeMillis()));
            //获取并写入 UuId
            String clubUuId = CommonStringTool.UUID();
            clubs.setUuId(clubUuId);
            //获取Session中的UUID
            //String CreateId = (String)session.getAttribute("Uuid");
            //测试用写死的-----------------------------------------------------------------
            String CreateId = "1";
            //设置创建者ID
            clubs.setClubCreateId(CreateId);
            //插入clubs表记录
            clubsMapper.insert(clubs);

            LevelGroup levelGroup = new LevelGroup();
            //文件写入指定路径
            Files.write(path,bytes);
            //设置UUID
            levelGroup.setUuId(CommonStringTool.UUID());
            //设置社团ID
            levelGroup.setLgClubid(clubUuId);
            //设置社团级别ID
            levelGroup.setLgLevelid(levelId);
            //设置创建时间
            levelGroup.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            //添加LevelGroup表记录
            levelGroupMapper.insert(levelGroup);

            jsonResult.setStatus("200");
            jsonResult.setMsg(FallBackMsg.AddOk.getDisplayName()+ ",创建社团成功！");
        }catch (Exception e){
            jsonResult.setStatus("400");
            jsonResult.setMsg(FallBackMsg.AddFail.getDisplayName()+ "，创建社团失败！");
            //执行失败，则将写入文件删除
            File logofile = new File(UPLOAD_FOLDER + fileName + file.getOriginalFilename());
            if (logofile.exists()){
                //System.out.println("进入文件路径");
                if (logofile.delete()){
                    System.out.println("文件删除成功");
                }else{
                    System.out.println("文件删除失败");
                }
            }
        }
        return jsonResult;
    }

    @Override
    public JsonResult updateClub(Clubs clubs,MultipartFile file,String levelId) {
        jsonResult  = new JsonResult();
        jsonResult.setStatus("400");
        int clubId = 0;
        int clubNameNum = 0;
        int levelNum = 0;
        Path newPath = null;
        byte[] bytes = null;
        try{
            //查询社团ID是否存在
            clubId = clubsMapper.selectClubsById(clubs.getUuId());
            if (clubId < 1){
                jsonResult.setMsg(FallBackMsg.UpdateFail.getDisplayName() + "，社团不存在！");
                return jsonResult;
            }
            //查询社团名称是否已经存在
            clubNameNum = clubsMapper.selectClubsByNameAndId(clubs);
            if (clubNameNum > 0){
                jsonResult.setMsg(FallBackMsg.UpdateFail.getDisplayName() + "，社团名称已存在！");
                return  jsonResult;
            }
            levelNum = clubLevelMapper.selectClubLevelById(levelId);
            if (levelNum < 1){
                jsonResult.setMsg(FallBackMsg.UpdateFail.getDisplayName() + "，社团级别不存在！");
                return  jsonResult;
            }


            //根据UUID获取图片文件对应的存储路径
            List<Clubs> clubLogoList = clubsMapper.selectClubLogoByPrimaryKey(clubs.getUuId());
            //存储数据库LOGO旧路径
            String logoPath = "";
            String clubLogo = "";
            if (clubLogoList.size() != 0 &&  null != clubLogoList){
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
            //更新LevelGroup表记录
            levelGroupMapper.updateLevelByClubId(levelGroup);

            //file不为空时，设置图片新路径
            if ( null != file && !file.isEmpty()) {
                bytes = file.getBytes();
                DateFormat df = new SimpleDateFormat("yyyMMddHHmmssSSS");
                //图片名称 采取时间拼接随机数
                String fileName = df.format(new Date());
                Random r = new Random();
                for (int i = 0; i < 3; i++) {
                    fileName += r.nextInt(10);
                }
                //设置图片文件路径
                 newPath = Paths.get(UPLOAD_FOLDER + fileName + file.getOriginalFilename());
                //如果没有files文件夹，则创建
                if (!Files.isWritable(newPath)) {
                    Files.createDirectories(Paths.get(UPLOAD_FOLDER));
                }
                //设置新LOGO路径
                clubs.setClubLogo(fileName + file.getOriginalFilename());
                //System.out.println("新的图片路径"+UPLOAD_FOLDER+fileName + file.getOriginalFilename());
            }else{
                //file为空，则路径不变
                clubs.setClubLogo(clubLogo);
            }
                //更新Clubs表记录
                clubsMapper.updateClubInfo(clubs);

                if ( null != file && !file.isEmpty() ){
                    //更新成功则删除对应的图片文件
                    File logofile = new File(logoPath);
                    if (logofile.exists()){
                        //System.out.println("进入文件路径");
                        if (logofile.delete()){
                            //新文件写入指定路径
                            Files.write(newPath,bytes);
                            //System.out.println("文件删除成功！");
                        }else{
                            //System.out.println("文件删除失败！");
                        }
                    }
                }



            jsonResult.setStatus("200");
            jsonResult.setMsg(FallBackMsg.UpdateOk.getDisplayName()+ ",更新社团成功！");

        }catch (Exception e){
            jsonResult.setStatus("400");
            jsonResult.setMsg(FallBackMsg.UpdateFail.getDisplayName()+ "，更新社团失败！");
        }
        return jsonResult;
    }

    @Override
    public JsonResult deleteClub(Clubs clubs) {
        try{

        }catch (Exception e){
            jsonResult.setStatus("400");
            jsonResult.setMsg(FallBackMsg.DeleteFail.getDisplayName()+ "，删除社团失败！");
        }
        return jsonResult;
    }


}
