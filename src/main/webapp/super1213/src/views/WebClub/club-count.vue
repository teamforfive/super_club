<template>
<div  class="c-count paddbotoom" >
 
   <mt-header fixed title="超级社团">
    <router-link to="/Home" slot="left">
        <mt-button icon="back">返回</mt-button>
    </router-link>
    <mt-button icon="more" slot="right"></mt-button>
    </mt-header>
      
    <div class="m-title"  v-for="item1 in readclubifo()" :key="item1.clubCreateId">
        
        <div class="m-ifo">
        <!-- <img :src="item1.img"> -->
         <img :src="'http://127.0.0.1:8081/SuperClub/image/'+item1.clubLogo">
        <h4>{{item1.clubsName}}</h4>
           
        <p>广西科技大</p>
        <span>社团号:<p class="number-p">{{item1.clubCreateId}}</p></span>
        </div>
        <span class="join-btn"><p>申请加入</p></span>
    </div>
    <!--  nav-->
<mt-navbar v-model="selected">
  <mt-tab-item id="1">主页</mt-tab-item>
  <mt-tab-item id="2">活动 </mt-tab-item>
  <mt-tab-item id="3">相册</mt-tab-item>
</mt-navbar>

<!-- tab-container -->
<mt-tab-container v-model="selected">
  <mt-tab-container-item id="1">
					
                            
							<div class="item1-id"><i></i><span>社团资料</span></div>

                            <div class="item1-ifo">
                            <div class="item1-ifo1" >
                                <p>社团类型</p>
                                <p>社团级别</p>
                                <p>社团简介</p>
                            </div>

                            <div class="item1-ifo2"  v-for="item1 in readclubifo()" :key="item1.clubCreateId">
                                <p>{{item1.type}}</p>
                                <p>{{item1.grade}}</p>
                                <p>{{item1.clubProfile}}</p>
                            </div>
                        </div>
                          
                        <div  class="item1-id">
                           
                        <span>成员({{membperson}})</span>
                         <span class="join-btn" ><p style="color: #000;">邀请加入</p></span>
                        </div>
                        <!-- 成员列表 -->
                        <div class="member1" v-for="item in readm()" :key="item.id">
                            <div class="LHotclub">{{item.id}}</div>
                            <div class="LHotlist">
                                <ul >
                                    <li v-for="listitem in item.memberlist" :key="listitem.id">
                                        <router-link  to="/Hclub">
                                        <img src="@/assets/404_images/404.png">
                                        <p>{{listitem.name}}</p>
                                        <p>{{listitem.job}}</p>
                                        </router-link>
                                    </li>
                                    <!-- <li>
                                        <img src="../../src/images/club/01.png">
                                        <p>技术社团</p>
                                        <p>技术部长</p>
                                    </li>
                                    <li>
                                        <img src="../../src/images/club/01.png">
                                        <p>技术社团</p>
                                        <p>技术部长</p>
                                    </li> -->
                                </ul>
                            </div>
                        </div>
                        <div @click="hide" class="more-m" :style="styleObject" >点击查看更多成员</div>
                        <!-- 成员列表结束 -->
                     
                            <!-- <div class="member1">
                            <div class="LHotclub">xxx部</div>
                            <div class="LHotlist">
                                <ul>
                                    <li>
                                        <router-link  to="/Hclub">
                                        <img src="../../src/images/club/01.png">
                                        <p>技术社</p>
                                        <p>技术部长</p>
                                        </router-link>
                                    </li>
                                    <li>
                                        <img src="../../src/images/club/01.png">
                                        <p>技术社团</p>
                                        <p>技术部长</p>
                                    </li>
                                    <li>
                                        <img src="../../src/images/club/01.png">
                                        <p>技术社团</p>
                                        <p>技术部长</p>
                                    </li>
                                </ul>
                            </div>
                            </div> -->
	
  </mt-tab-container-item>
  <mt-tab-container-item id="2">
        <div class="Mybt">
                    <!-- <mt-button type="primary" size="normal" plain></mt-button>  -->
                     <span class="join-btn" @click="rembname"><p style="color: #000;">发布</p></span>
                      <span class="join-btn" @click="rembname" style="padding-top:20px;" ><p style="color: #000;">活动管理</p></span>
                    </div>
                   <div v-for="item in readclubactiv()" :key="item.uuId">
					<ul class="mui-table-view"  v-if="item.length==0"><li>暂无活动</li></ul>
                    <ul v-else>
                        <li class="mui-table-view-cell" >
                              <span class="mui-gauang mui-icon mui-icon-compose" ></span>
                              <span class="mui-gauang1">活动时间</span>
                            
                            <div class="tag-group">
                                  <textarea rows="3" cols="20" style="    color: rgb(45, 35, 35);
    position: absolute;
    left: -256px;
    top: 25px;
    width: 267px;
    height: 73px;
    outline: none;
    border: 0;
    background: rgba(255, 253, 253, 0.1);
">111</textarea>
                            <el-tag
                            closable
                            :disable-transitions="false"
                            :size="'mini'"
                            :type="'danger'"
                            @close="Delac(item.activityTitle)"
                           >
                            </el-tag>
                            </div>
                            <div class="mui-card" >
                        
                            <div class="mui-card-header mui-card-media" style="height:28vw;background-image:url(../../assets/404_images/404.png)" >

                            </div>
                            <div class="mui-card-content">
                                    <div class="mui-card-content-inner">
                                       
                                        <div class="mui-card-content-head">
                                            <div >
                                                <span >开始时间</span>
                                                <span >{{item.createTime}}</span>
                                            </div>
                            
                                        </div>
                                    
                                    </div>
                                </div>
                            </div>
						</li></ul>
                    </div>
  </mt-tab-container-item>
  <mt-tab-container-item id="3">
                         <div class="Mybt">
                      <router-link  to="/Edit"><span class="join-btn" ><p style="color: #000;">新增</p></span></router-link>
                    </div>
                    <div  class="item1-id"><i></i><span>共有n张照片</span></div>
					<!-- 照片九宫格 -->
                        <div class="mui-content item-img" >
                            <ul class="mui-table-view mui-grid-view mui-grid-9" v-for="item1 in readclubimg()" :key="item1.logoName">
                                <li class="mui-table-view-cell mui-media mui-col-xs-4 ">
                                    <img :src="'http://127.0.0.1:8081/SuperClub/image/'+item1.logoName" preview="0" preview-text="描述文字">
                                </li>
                                <!-- <li class="mui-table-view-cell mui-media mui-col-xs-4 ">
                                    <img src="@/assets/404_images/404.png" preview="0" preview-text="描述文字"> 
                                </li>
                                <li class="mui-table-view-cell mui-media mui-col-xs-4 ">
                                    <img src="@/assets/404_images/404.png" preview="0" preview-text="描述文字"> 
                                </li> -->
                            </ul> 
		                </div>
  </mt-tab-container-item>
</mt-tab-container>
 <!--  nav end-->
    </div>

</template>
<script>
import active from "./club-active.vue"
import { getifon} from '@/api/home'
import { getAc,getAct,getimg} from '@/api/activity'
export default {
name: 'count',
components:{active},
  data(){
      return {
            memnum:0,
            selected:"1",
            membperson:0,
            uid:this.$route.params.id,
            name:this.$route.params.name,
            styleObject :{
            display:""
            },
            form:[],
            Alist:[],
             Aliimg:[],
            clubid:0,
            member1:[ 
                {
                    id:"ddd部",
                    memberlist:[
                    {id:1,name:'1',job:"社长"},
                    {id:2,name:'2',job:"社长"}
                    ]
                },
                 {
                    id:"ooo部",
                    memberlist:[
                    {id:1,name:'3',job:"p社长"},
                    {id:2,name:'4',job:"p社长"}
                    ]
                } ,

                  {
                    id:"ii",
                    memberlist:[
                    {id:1,name:'5',job:"pi社长"},
                    {id:2,name:'6',job:"p社长"},
                    {id:3,name:'dd',job:"p社长"}
                    ]
                } ,
            ]  
      }
  },
created(){
    this.getnewsinfo1();
    this.getnewsactivty();
    this.reimg();
},
  methods:{
      hide(){
          this.memnum++;
          if( this.memnum==this.member1.length-1)
          {
                 this.styleObject.display="none"
          }
      },
    //   删除活动
    Delac(item){
        console.log(item);
        var index=this.Alist.findIndex(item=>{
 				if(item.activityTitle==item)
 				{
 					return 	true;
 				}
 			})
 			this.Alist.splice(index,1)
    },
    rembname(){
    //   this.getnewsinfo1(name); 
    console.log(this.uid);
      this.$router.push({
        name: 'Edit',
        params: {
          id: this.uid,
        }
      })
      },
    getnewsinfo1(){
        this.listLoading = true;
       getifon(this.uid).then(response => {

       this.form=response.item.data;
       console.log("form");
       console.log(this.form);
        this.listLoading = false;
      })
      },
getnewsactivty(){
      this.listLoading = true;
      getAc(this.uid).then(response => {
       this.Alist=response.item.data;
         console.log(this.Alist);
        this.listLoading = false
      });
      getAct(this.uid).then(response => {
          console.log("fydfd");
         console.log(response.item.data);
        this.listLoading = false
      });
      },
      readm(){
       
          var newlist=[];
          var num=0;
            this.member1.some((item,i)=>{
                num +=item.memberlist.length;
                if(i<=this.memnum)
                {
                newlist.push(item); 
                }
                    
             })
             this.membperson=num;
          return  newlist;
      },
      readclubifo(){

          var newlist=[];
       this.form.some((item,i)=>{
                     newlist.push(item)  
             })
        //      this.$store.state.clubID=0;
        //   return  this.$store.state.clublist;
        return newlist;
      },
    readclubactiv(){

          var newlist1=[];
      this.Alist.some((item,i)=>{
            item.createTime=this.time(item.createTime);
            newlist1.push(item);

      })
              console.log("oo");
    console.log(newlist1);
        //      this.$store.state.clubID=0;
        //   return  this.$store.state.clublist;
        return newlist1;
      }, 
        readclubimg(){

          var newlist1=[];
    //   this.Aliimg.some((item,i)=>{
            // item.createTime=this.time(item.createTime);
            
            newlist1.push( this.Aliimg);

    //   })
              console.log("999");
    console.log(newlist1);
        //      this.$store.state.clubID=0;
        //   return  this.$store.state.clublist;
        return newlist1;
      }, 
    time(time){
      var d = new Date(time);  
      var datetime=d.getFullYear() + '/' + (d.getMonth() + 1) + '/' + d.getDate() + ' ' + d.getHours() + ':' + d.getMinutes() + ':' + d.getSeconds();
      return datetime;
      },
      reimg(){
          this.listLoading = true;
           this.Aliimg.logoName='';
            getimg(this.uid).then(response => {
          console.log(response.item);
         this.Aliimg=response.item;
        this.listLoading = false
      });
      },
      
  },
  watch: {
           selected(){
                this.selected=this.selected;
           }
       }

}
</script>
<style scoped>
.mui-gauang{
      position: absolute;
    top: 22px;
    left: 37px;
    z-index: 999;
}
.mui-gauang1{
         position: absolute;
    top: 25px;
    left: 151px;
    z-index: 999;
}
.mui-table-view:before{
    height: 0;
}
.Mybt {
  margin: 15px 10px;
  height: 25px;
}
.mui-collapse i{
    position: absolute;
    width: 100%;
    height: 100%;
}
.c-count{
        padding-top: 46px;
        
}
.mui-grid-view.mui-grid-9{
    background-color: #fff;
}
    .m-title{
        height: 180px;
        position:relative;
        text-align: center;
        background-color: cornflowerblue;
    }
    .m-title,.m-title p{
        color: aliceblue !important;
    }
    .m-title p{
        margin-bottom: 0;
    }
    .m-title img{
        height: 60px;
        width: 60px;
        border-radius: 50%;
        margin-top: 10px;
    }
    .m-title .m-ifo{
        position: absolute;
        left: 50%;
        transform: translateX(-50%);
    }
    .m-title h4{
        padding: 10px 0;
    }
    .number-p{
        display: inline-block;
    }
    .join-btn{
        position: absolute;
        right: 10px;
        top: 8px;
        width: 100px;
        height: 30px;
        background-color: rgba(0, 0, 0, 0.5);
        border-radius: 20px;
      
    }
    .item1-id .join-btn{
          background-color: rgba(171, 166, 166, 0.5);
    }
    .mui-control-content .Mybt .join-btn, .Mybt .join-btn{
        text-align: center;
           background-color: rgba(171, 166, 166, 0.5);
    }
     .join-btn p{
        line-height: 30px;
     }
    .wrapper1{
       position: unset;
    }
     .mui-control-content{
         
         height: 100%;
     }
     .mui-scroll{
         font-size: 14px;
     }
     .scrollitem1 div{
         background-color: #fff;
     }
    .item1-id{
    display: block;
    position: relative;
    height: 50px;
    font-size: 18px;
    line-height: 50px;
    margin:10px 0 2px 0;

     }
     .item1-id i{
        display: inline-block;
        width: 5px;
        height: 30px;
        background-color:#007AFF;
        position:absolute;
        top: 10px;
        left: 0;
    }
    .item1-id span{
        padding-left: 20px;
    }
    .mui-content {
        background-color: #fff;
    }
    .item1-ifo1,.item1-ifo2{
        display:inline-block;
         padding-left: 20px;
         
    }
    .item1-ifo1 p,.item1-ifo2 p{
        font-size: 16px;
        color: #8B8B8B;
    }
    .item1-ifo{
        padding: 10px 0;
          margin-bottom: 5px;
    }
    #scroll .LHotclub{
        background-color: #F0F5F9;
        height: 24px;
        line-height: 24px;
        color: #7594AA;
        font-size: 16px;
        padding-left: 15px;
    }
    .LHotlist ul{
           overflow: hidden;
        height: 100%;
    }
    .LHotlist li{
        height: 100%;
        list-style: none;
        float: left;
        width: 80px;
        border-radius: 50%;
        margin: 20px 0 0 20px;
        text-align: center;
    }
    .LHotlist img{
        width: 100%;
        height: 80px;
        border-radius: 50%;
    }
    .LHotlist p{
        color: black;
        font-size: 16px;
        margin-left: 8px;
    }
    .more-m{
         height: 20px;
        text-align: center;
        color: #7594AA;
    }
    
    .item-img img{
        width: 100%;
        height: 100%;
    }
    .tag-group{
         position: absolute;
    top: 21px;
    /* left: 0; */
    right: 28px;
    z-index: 99999;
    }
</style>

