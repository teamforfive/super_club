<template>
  <div class="Cclub">
    <mt-header fixed title="注册用户">
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
          <h1>填写用户信息</h1>
        </mt-button>
      </mt-header>
    </div>
    <div class="C-file">
      <mt-field label="用户名" placeholder="请输入用户名" type="text" v-model="ClubList.userName"></mt-field>
      <mt-field label="用户密码" placeholder="请输入密码" type="text" v-model="ClubList.userPassword"></mt-field>
      <mt-field label="真实姓名" placeholder="请输入姓名" type="text" v-model="ClubList.userRealName"></mt-field>
      <mt-field label="性别" placeholder="请输入性别" type="text" v-model="ClubList.userSex"></mt-field>
      <mt-field label="手机号码" placeholder="请输入数字" type="text" v-model="ClubList.userTelephone"></mt-field>
      <mt-field label="QQ号码" placeholder="请输入数字" type="text" v-model="ClubList.userQq"></mt-field>
      
    </div>
    <div class="c-LOGO">
      <ul class="mui-table-view">
        <li class="mui-table-view-cell">
          <span>
            <p>用户头像</p>
          </span>
          <span>
            <span class="Cclufile">
              <img class="cxp" :src="this.img" align="absmiddle">
              <a class="mui-navigate-right">
                请选择图片
                <form id="imgfile" enctype="multipart/form-data" name="file" method="post">
                  <input id="img" type="file" @change="tirggerFile($event)">
                </form>
              </a>
            </span>
          </span>
        </li>
      </ul>
    </div>
    <div class="Cbt">
      <mt-button type="primary" size="large" @click="createclub">注册</mt-button>
    </div>

   
  </div>
</template>
<script>
  import qs from 'qs';
import axios from 'axios'

async function addifon(url, header,data1) {
    let { data } = await axios({
        method: 'POST',
        headers: header,
        url,
        data:JSON.stringify(data1),
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
                imgsrc:"../../src/images/club/img.png",
                text:'',
                grade:[],
                goption:[
                        // {
                        //     label:"校级组织",
                        //     value:"校级组织"
                        // },
                        // {
                        //     label:"院级组织",
                        //     value:"院级组织"
                        // },
                        // {
                        //     label:"兴趣社团",
                        //     value:"兴趣社团"
                        // },
                        ],
                popupVisible1: false,
                popupVisible2: false,
                ClubList:{
                      userName:"",

                      userPassword:"",


                      userRealName:"",

                      userSex:"",

                      userSattus:"",
                      userTelephone:"",
                      userQq:"",
                      userType:true,

                }
            }
        },

        created(){
           
        },
        methods: {
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
         async createclub(){
            console.log(this.ClubList)
              this.text=JSON.stringify(this.ClubList);
            //  var formData = new FormData();
             var formData = new window.FormData();
             var files = document.getElementById("img").files[0];
             formData.append("file",files);
             console.log(formData);
             var hede={
                 "Content-Type":"application/json",
                
             }
             var urll="http://192.168.1.100:8081/SuperClub/user/signUp";
             let data = await addifon(urll,hede,this.ClubList);
                
              console.log(data);
            //  console.log("id:"+this.$store.state.clubname);
            // var  car={id: this.$store.state.clubname,clubsName:this.clubname,img:this.imgsrc,type:this.clutype,grade:this.clugrade,text:this.text}
        
            // this.$store.state.clublist.push(this.ClubList);
        
            // this.addClub(formData);
            this.$router.push({path:'/'})
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
    addisfon(){
       var _this=this;
this.$ajax.get('http://192.168.1.100:8081/SuperClub/user/signUp')
  .then(function (ifon){
    _this.grade.push(ifon.data.item.data);
    // console.log(_this.grade);
    _this.regrade();
  }).catch(function (error) {
    console.log(error);
  });
      },
},
         watch: {
            clugradevalue(){
                this.clugrade=this.clugradevalue;
             },
            clutypevalue(){
                this.clutype=this.clutypevalue;
            },
            img(){
                this.ClubList.file =this.img;
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
  padding: 13.5px 24px;
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
</style>


