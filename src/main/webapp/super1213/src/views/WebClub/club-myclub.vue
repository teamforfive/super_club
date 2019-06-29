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
         <img src="../../src/images/club/01.png">
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
                            <i></i>
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
                                        <img src="../../src/images/club/01.png">
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
                    </div>
                    <ul class="mui-table-view" >
                        暂无活动
                    </ul>
					<ul class="mui-table-view">
						<li class="mui-table-view-cell" v-for="item in readclubactiv()" :key="item.uuId">
                            <div class="mui-card" >
                        
                            <div class="mui-card-header mui-card-media" style="height:28vw;background-image:url(../../src/images/club/bagua.jpg)" >

                            </div>
                            <div class="mui-card-content">
                                    <div class="mui-card-content-inner">
                                        <div class="mui-card-content-head">
                                            <div >
                                                <span style="font-size: 20px;font-weight: bold;">{{item.activityTitle}}
                                                </span>
                                                <span class="times">活动时间</span>
                                                <span class="times1">{{item.createTime}}</span>
                                            </div>
                                            <span style="color:#fff;">{{item.activityTitle}}</span>
                                        </div>
                                    
                                    </div>
                                </div>
                            </div>
						</li>
						
					</ul>
  </mt-tab-container-item>
  <mt-tab-container-item id="3">
                         <div class="Mybt">
                      <router-link  to="/Edit"><span class="join-btn" ><p style="color: #000;">新增</p></span></router-link>
                    </div>
                    <div  class="item1-id"><i></i><span>共有n张照片</span></div>
					<!-- 照片九宫格 -->
                        <div class="mui-content item-img">
                            <ul class="mui-table-view mui-grid-view mui-grid-9">
                                <li class="mui-table-view-cell mui-media mui-col-xs-4 ">
                                    <img src="../../src/images/club/01.png" preview="0" preview-text="描述文字"> 
                                </li>
                                <li class="mui-table-view-cell mui-media mui-col-xs-4 ">
                                    <img src="../../src/images/club/01.png" preview="0" preview-text="描述文字"> 
                                </li>
                                <li class="mui-table-view-cell mui-media mui-col-xs-4 ">
                                    <img src="../../src/images/club/01.png" preview="0" preview-text="描述文字"> 
                                </li>
                            </ul> 
		                </div>
  </mt-tab-container-item>
</mt-tab-container>
 <!--  nav end-->
    </div>

</template>
<script>
import active from "./club-active.vue"

export default {
name: 'my',
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
            clublist:{},
            Alist:[],
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
    console.log(this.uid);
    this.getnewsactivty(this.uid);
    this.getnewsinfo1(this.uid);
},
  methods:{
      hide(){
          this.memnum++;
          if( this.memnum==this.member1.length-1)
          {
                 this.styleObject.display="none"
          }
      },
        rembname(){
         console.log(11111);
    //   this.getnewsinfo1(name); 
      this.$router.push({
        name: 'Edit',
        params: {
          id: this.uid,
        }
      })
      },
    getnewsinfo1(Id){
       var _this=this;
this.$ajax.get('http://192.168.1.100:8081//SuperClub/clubs/selectClubInfo',{params:{uuId:Id}}
).then(function (ifon){
  _this.clublist=ifon.data.item.data;
  console.log(ifon.data);
  }).catch(function (error) {
    console.log(error);
  });
      },
getnewsactivty(Id){
       var _this=this;
this.$ajax.get('http://192.168.1.100:8081/SuperClub/activity/selectList',{params:{activityClubId:Id}}
).then(function (ifon){
  _this.Alist=ifon.data.item.data;
    if(ifon.data.status)
  console.log(ifon.data.status);
  }).catch(function (error) {
    console.log(error);
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
      newlist.push(this.clublist); 
        //      this.$store.state.clubID=0;
        //   return  this.$store.state.clublist;
        return newlist;
      },
    readclubactiv(){

          var newlist1=[];
      this.Alist.some((item,i)=>{

            newlist1.push(item);

      })
             
   
        //      this.$store.state.clubID=0;
        //   return  this.$store.state.clublist;
        return newlist1;
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
</style>

