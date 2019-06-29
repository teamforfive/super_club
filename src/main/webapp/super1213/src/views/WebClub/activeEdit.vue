<template>
  <div class="Cclub">
    <mt-header fixed title="发布活动">
      <a @click="prev" slot="left">
        <mt-button icon="back"></mt-button>
      </a>
      <a @click="prev" slot="left">
        <mt-button class="mui-icon mui-icon-closeempty"></mt-button>
      </a>

      <mt-button icon="more" slot="right"></mt-button>
    </mt-header>

  
    <div class="C-file">
      <mt-field  label="活动标题" placeholder="请输入活动标题" type="text" v-model="form.activityTitle"></mt-field>
      <mt-field  label="活动官方" placeholder="请输入活动地址" type="text" v-model="form.organizerName"></mt-field>
       <mt-field  label="活动地址" placeholder="请输入活动地址" type="text" v-model="form.activityPlace"></mt-field>
      <mt-field  label="活动内容" placeholder="请输入活动内容" type="text" v-model="form.activityContent"></mt-field>
        <div class="block">
                    <span style="font-size:16px; padding:0 10px;">活动开始时间</span>
                    <el-date-picker
                      v-model="activityStartTime"
                      type="datetime"
                      placeholder="选择日期时间">
                    </el-date-picker>
          </div> 
          <div class="block">
                    <span style="font-size:16px; padding:0 10px;">活动结束时间</span>
                    <el-date-picker
                      v-model="activityEndTime"
                      type="datetime"
                      placeholder="选择日期时间">
                    </el-date-picker>
          </div> 
  
    </div>

    <el-select v-model="form.activityCateId" clearable placeholder="请选择">
    <el-option
      v-for="item in goption"
      :key="item.value"
      :label="item.label"
      :value="item.value">
    </el-option>
  </el-select>

    <el-upload
          class="avatar-uploader"
          action="http://192.168.1.100:8081/SuperClub/clubs/file/upload"
          :show-file-list="false"
          :on-success="handleAvatarSuccess"
          :before-upload="beforeAvatarUpload">
          <el-row>
           <el-col :span="6"><span style="position: relative;top: 34px;left: 10px;">LOGO</span></el-col>
          <el-col :span="8" :offset="6"> <img v-if="imageUrl" :src="imageUrl" class="avatar">
          <i v-else class="el-icon-plus avatar-uploader-icon"></i>
          </el-col>
          </el-row>
    </el-upload>


    <div class="Cbt">
      <mt-button type="primary" size="large" @click="addA">发布</mt-button>
    </div>
  
    <mt-popup v-model="popupVisible1" popup-transition="popup-fade">
      <mt-radio align="right" v-model="clugradevalue" :options="goption"></mt-radio>
    </mt-popup>
  </div>
</template>
<script>


async function getData(url, header,data1) {
    let { data } = await axios({
        method: 'POST',
        headers: header,
        url,
        data:data1,
    })
    return data;
};
import { getAcgrade,addAc,getAc} from '@/api/activity'
export default {
    name:'Edit',
     data() {
            return {
                // clublist:[
                //     {name:'奔驰',img:'../../src/images/club/img.png'},
 		        //     {name:'大奔驰',img:'../../src/images/club/img.png'}
                // ],
              value1:"",
              show: false,
              mode: 'during',
              show1: false,
              mode1: 'during',
              clugradevalue:"",
                img:'',
                id:0,
                 uid:this.$route.params.id,
                imgsrc:"../../src/images/club/img.png",
         
                pickerValue:'',

                activityStartTime:"",    
                activityEndTime:"",
                goption:[],
                imageUrl:"",
                clutype: "",
                clutypevalue:"",
                popupVisible1: false,
                popupVisible2: false,
                form:{
                    activityClubId:'',
                    activityTitle:"",
                    activityStartTime:"",    
                    activityEndTime:"",
                    activityPlace:"",
                    activityContent:"",
                    organizerName:"",
                    activityCateId:"",  
                }
            }
        },

created(){
           this.GetGra();
           
        },
methods: {
       regrade(){
        var _this=this;
        this.grade.some((item,i)=>{
                for(var i in item )
                {
                     var grade={label:item[i].acName,value:item[i].uuId};
                     _this.goption.push(grade);
                }
           })
      },
      time(time){
      var d = new Date(time);  
      var datetime=d.getFullYear() + '/' + (d.getMonth() + 1) + '/' + d.getDate() + ' ' + d.getHours() + ':' + d.getMinutes() + ':' + d.getSeconds();
      return datetime;
      },
 // 获取社团级别
    GetGra(){

      this.grade=[];
      this.listLoading = true;
      getAcgrade().then(response => {

      console.log(response);
      this.grade.push(response.item.data);
      this.regrade();
           console.log(this.goption);
      this.listLoading = false;
          }).catch(function (error) {
            console.log(error);
      });
    },
    addA(){
      this.listLoading = true;
      console.log(this.form);
      this.form.activityClubId=this.uid;
      this.form.activityStartTime=this.time(this.activityStartTime).toString();
      this.form.activityEndTime=this.time(this.activityEndTime).toString();
        console.log(this.form);
      addAc(this.form).then(response => {
      console.log(response);
      this.listLoading = false;
          }).catch(function (error) {
         
      });
    },
            prev(){
              this.$router.go(-1);
              },

              openPicker() {
                console.log("11");
        this.$refs.picker.open();
      },
             ShouPup1() {
                this.popupVisible1 = true
            },
            ShouPup2() {
                this.popupVisible2 = true
            },
            tirggerFile(event){
               
                    var files = document.getElementById("img").files[0];
                    this.img=this.getObjectURL(files);
                    console.log(this.img);
                     },
            getObjectURL (file) {
                                let url = null;
                                if (window.createObjectURL!=undefined) { // basic
                                    url = window.createObjectURL(file) ;
                                }else if (window.webkitURL!=undefined) { // webkit or chrome
                                    url = window.webkitURL.createObjectURL(file) ;
                                }else if (window.URL!=undefined) { // mozilla(firefox)
                                    url = window.URL.createObjectURL(file) ;
                                }
                                return url ;
                                },
      
    
      
   
// 图片加载
  handleAvatarSuccess(res, file) {
        
      this.imageUrl = URL.createObjectURL(file.raw);
      this.form.clubLogo=res.item.clubLogo;
      console.log(this.form.clubLogo);
      
      },
  beforeAvatarUpload(file) {

        const isJPG = file.type === 'image/jpeg';
        const isLt2M = file.size / 1024 / 1024 < 2;

        if (!isJPG) {
          this.$message.error('上传头像图片只能是 JPG 格式!');
        }
        if (!isLt2M) {
          this.$message.error('上传头像图片大小不能超过 2MB!');
        }
        return isJPG && isLt2M;

      }
  

},
         watch: {
            clugradevalue(){
                this.form.activityCateId=this.clugradevalue;
             },
            clutypevalue(){
                this.clutype=this.clutypevalue;
            },
            img(){
                this.form.activity_photo =this.img;
            },
        },

}
</script>
<style scoped>
.timedata{
  height: 60px;
}
.C-file{
  padding-top: 49px;
  background: #ffffff;
}
.mui-table-view-cell:after {
  left: 0px;
}
.mui-table-view-cell span {
  display: inline-block;
}
.mui-icon-closeempty {
  font-size: 32px;
}
.con-hec {
  margin-top: 49px;
  background-color: #f3f6f8;
  color: #191616;
}
.con-hec h1 {
  font-size: 20px;
}

.mui-table-view-cell span p {
  font-size: 16px;
  color: #1e0202;
  padding-right: 30px;
}
.mui-table-view-cell span .cxp {
  color: #c1c1c1;
  font-weight: normal;
  display: inline-block;
}
.mui-table-view-cell {
  padding: 13.5px 10px;
}
.Crifo .mint-cell-wrapper {
  align-items: unset;
}
.Crifo {
  margin-top: 10px;
}
.mui-navigate-right {
  vertical-align: middle;
}
.mui-table-view-cell img {
  display: inline-block;
  width: 60px;
  height: 60px;
  border-radius: 50%;
}
.mui-table-view-cell .Cclufile a {
  border: none;
  color: #c1c1c1;
  font-size: 14px;
  font-weight: bold;
}
.mui-table-view-cell .mui-navigate-right form {
  display: inline-block;
}

.c-LOGO {
  margin-top: 22px;
}
.Cbt {
  margin: 20px 10px;
}
.mui-navigate-right input {
  border: none;
  color: #4d4343;
  font-size: 16px;
  font-weight: bold;
}
.mui-navigate-right input::-webkit-input-placeholder {
  color: #c1c1c1;
}

.mui-navigate-right input::-moz-input-placeholder {
  color: #c1c1c1;
}
.mui-navigate-right input::-ms-input-placeholder {
  color: #c1c1c1;
}
.mui-table-view-cell .Cclufile input {
  position: absolute;
  font-size: 100px;
  right: 0;
  top: 0;
  opacity: 0;
}

.avatar-uploader{
    background: #ffff;
    
}
.avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 50%;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 90px;
    height: 90px;
    line-height: 90px;
    text-align: center;
  }
  .avatar {
    width: 90px;
    height: 90px;
    display: block;
    border-radius: 50%;
  }



</style>


