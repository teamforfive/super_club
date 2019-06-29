<template>
  <div class="Cclub">
    <mt-header fixed title="创建社团">
      <router-link to="/Home" slot="left">
        <mt-button icon="back"></mt-button>
      </router-link>
      <router-link to="/Home" slot="left">
        <mt-button class="mui-icon mui-icon-closeempty"></mt-button>
      </router-link>

      <mt-button icon="more" slot="right"></mt-button>
    </mt-header>
    <div class="LHotclub">
      <mt-header class="con-hec">
        <mt-button disabled slot="left">
          <h1>填写社团资料</h1>
        </mt-button>
      </mt-header>
    </div>
    <div class="C-file">
      <mt-field label="社团名称" placeholder="请输入数字" type="text" v-model="form.clubsName"></mt-field>
      <mt-field label="手机号码" placeholder="请输入数字" type="text" v-model="form.clubTel"></mt-field>
      <mt-field label="社团地址" placeholder="请输入数字" type="text" v-model="form.clubLocation"></mt-field>
      <ul class="mui-table-view">
        <li class="mui-table-view-cell">
          <span>
            <p>社团类型</p>
          </span>
          <span>
            <a class="mui-navigate-right" @click="ShouPup1">
              <input v-model="clutype" placeholder="请输入社团类型">
            </a>
          </span>
        </li>
        <li class="mui-table-view-cell">
          <span>
            <p>社团级别</p>
          </span>
          <span>
            <a class="mui-navigate-right" @click="ShouPup2">
              <input v-model="form.levelId" placeholder="请输入社团级别">
            </a>
          </span>
        </li>
      </ul>
    </div>
    <div class="Crifo">
      <mt-field
        label="社团简介"
        placeholder="请输入社团简介"
        type="textarea"
        rows="10"
        v-model="form.clubProfile"
      ></mt-field>
    </div>

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
      <mt-button type="primary" size="large" @click="adddata">创建社团</mt-button>
    </div>

    <mt-popup v-model="popupVisible1" popup-transition="popup-fade">
      <mt-radio align="right" v-model="clutypevalue" :options="toption"></mt-radio>
    </mt-popup>

    <mt-popup v-model="popupVisible2" popup-transition="popup-fade">
      <mt-radio align="right" v-model="clugradevalue" :options="goption"></mt-radio>
    </mt-popup>
  </div>
</template>
<script>
import { getList,getGrade,addList,UdList,addimg} from '@/api/DataDictionary/club'
async function getData(url, header,data1) {
    let { data } = await axios({
        method: 'POST',
        headers: header,
        url,
        data:data1,
    })
    return data;
};

export default {
    name:'',
     data() {
            return {
                // clublist:[
                //     {name:'奔驰',img:'../../src/images/club/img.png'},
 		        //     {name:'大奔驰',img:'../../src/images/club/img.png'}
                // ],
                clutype: "",
                clutypevalue:"",
                clugrade:"",
                clugradevalue:"",
                img:'',
                id:0,

                imageUrl: '',
            
                imgsrc:"../../src/images/club/img.png",
                text:'',
                text1:'',
                form:{
                        clubsName:'',
                        clubProfile:"",
                        clubLocation:"",
                        clubTel:"",
                        levelId:"",
                        // lgLevelid:'',
                        clubLogo:'',
                    },
                grade:[],
                goption:[
                        
                        ],
                 toption:[
                        {
                            label:"学术类",
                            value:"学术类"
                        },
                        {
                            label:"实践类",
                            value:"实践类"
                        },
                        {
                            label:"体育类",
                            value:"体育类"
                        },
                         {
                            label:"艺术类",
                            value:"艺术类"
                        },
                         {
                            label:"团学组织",
                            value:"团学组织"
                        },
                         {
                            label:"其他",
                            value:"其他"
                        },
                        ],        
                popupVisible1: false,
                popupVisible2: false,
                
            }
        },

        created(){
           this.GetGra();
           
        },
        methods: {
             ShouPup1() {
                this.popupVisible1 = true
            },
            ShouPup2() {
                this.popupVisible2 = true
            },

    regrade(){
        var _this=this;
        this.grade.some((item,i)=>{
                for(var i in item )
                {
                     var grade={label:item[i].clName,value:item[i].clName};
                     _this.goption.push(grade);
                }
           })
      },
 // 获取社团级别
    GetGra(){

      this.grade=[];
      this.listLoading = true;
      getGrade().then(response => {

      // console.log(response.item.data);
      this.grade.push(response.item.data);
      this.regrade();
           console.log(this.goption);
      this.listLoading = false;
          }).catch(function (error) {
            console.log(error);
      });
    },
    adddata(){
      this.dialogFormVisible=false;
      this.listLoading = true
      var formData = new window.FormData();
      //  var files = document.getElementById("img").files[0];
      //  console.log(files);
      
   
    addList(this.form).then(response => {
        console.log(response);
  
      this.listLoading = false;
         this.Eitdialog=false;
      }, response => {
            console.log(response);
         
         });
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
                this.form.levelId=this.clugradevalue;
             },
            clutypevalue(){
                this.clutype=this.clutypevalue;
            },
           
        },

}
</script>
<style scoped>
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
  font-size: 18px;
  color: #1e0202;
  font-weight: 600;
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


