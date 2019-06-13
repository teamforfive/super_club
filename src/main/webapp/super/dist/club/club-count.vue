<template>
<div  class="c-count" >
 
   <mt-header fixed title="超级社团" class="toptile">
    <router-link to="/Home" slot="left">
        <mt-button icon="back"></mt-button>
    </router-link>
    <mt-button icon="more" slot="right"></mt-button>
    </mt-header>
    <div class="m-title"  v-for="item1 in readclubifo()" :key="item1.clubCreateId">
        <div class="m-ifo">
        <img src="../../src/images/club/01.png">
        <h4>{{item1.clubsName}}</h4>
        <p>广西科技大</p>
        <span>社团号:<p class="number-p">{{item1.clubCreateId}}</p></span>
        </div>
        <span class="join-btn"><p>申请加入</p></span>
    </div>
    <!--  nav-->
       <div class="mui-content">
			<div style="padding: 10px 10px;">
				<div id="segmentedControl" class="mui-segmented-control">
					<a class="mui-control-item mui-active" href="#item1">主页</a>
					<a class="mui-control-item" href="#item2">活动</a>
					<a class="mui-control-item" href="#item3">相册</a>
				</div>
			</div>
			<div>
				<div id="item1" class="mui-control-content mui-active">
					<div id="scroll" class="mui-scroll-wrapper wrapper1">
						<div class="mui-scroll scrollitem1">
                            
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
                          
                        <div  class="item1-id"><i></i><span>成员({{membperson}})</span></div>
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
                       
						</div>
		            </div>
		    </div>
				<div id="item2" class="mui-control-content">
					<!-- <ul class="mui-table-view">
                        <li class="mui-table-view-cell">
                            <div class="mui-card">
                            <div class="mui-card-header mui-card-media" style="height:40vw;background-image:url(../../src/images/club/bagua.jpg)"></div>
                            <div class="mui-card-content">
                                <div class="mui-card-content-inner">
                                    <div class="mui-card-content-head">
                                        <div>
                                            <span style="font-size: 20px;font-weight: bold;">活动标题文活动标题文
                                            </span>
                                            <span class="times">2019/05/01</span>
                                        </div>
                                    </div>
                                    <div>
                                    <p  class="content"   style="color:#FFFFFF;font-size:10px;">选择器使用小结:id选择器:一个元素(标签)class选择器:一类元素 元素选择器:一种元素属性选择器:元素选择器的特殊用法使用的时候注意:(了解)若多个样式作用于一个元素的时候
                                    选择器使用小结:id选择器:一个元素(标签)class选择器:一类元素 元素选择器:一种元素属性选择器:元素选择器的特殊用法使用的时候注意:(了解)若多个样式作用于一个元素的时候
                                    选择器使用小结:id选择器:一个元素(标签)class选择器:一类元素 元素选择器:一种元素属性选择器:元素选择器的特殊用法使用的时候注意:(了解)若多个样式作用于一个元素的时候
                                    选择器使用小结:id选择器:一个元素(标签)class选择器:一类元素 元素选择器:一种元素属性选择器:元素选择器的特殊用法使用的时候注意:(了解)若多个样式作用于一个元素的时
                                    </p> 
                                    </div>
                                </div>
                            </div>
                            </div>
                        </li>
                        <li class="mui-table-view-cell">
                            <div class="mui-card">
                            <div class="mui-card-header mui-card-media" style="height:40vw;background-image:url(../../src/images/club/bagua.jpg)"></div>
                            <div class="mui-card-content">
                                <div class="mui-card-content-inner">
                                    <div class="mui-card-content-head">
                                        <div>
                                            <span style="font-size: 20px;font-weight: bold;">活动标题文活动标题文
                                            </span>
                                            <span class="times">2019/05/01</span>
                                        </div>
                                    </div>
                                    <div>
                                    <p  class="content"   style="color:#FFFFFF;font-size:10px;">选择器使用小结:id选择器:一个元素(标签)class选择器:一类元素 元素选择器:一种元素属性选择器:元素选择器的特殊用法使用的时候注意:(了解)若多个样式作用于一个元素的时候
                                    选择器使用小结:id选择器:一个元素(标签)class选择器:一类元素 元素选择器:一种元素属性选择器:元素选择器的特殊用法使用的时候注意:(了解)若多个样式作用于一个元素的时候
                                    选择器使用小结:id选择器:一个元素(标签)class选择器:一类元素 元素选择器:一种元素属性选择器:元素选择器的特殊用法使用的时候注意:(了解)若多个样式作用于一个元素的时候
                                    选择器使用小结:id选择器:一个元素(标签)class选择器:一类元素 元素选择器:一种元素属性选择器:元素选择器的特殊用法使用的时候注意:(了解)若多个样式作用于一个元素的时
                                    </p> 
                                    </div>
                                </div>
                            </div>
                            </div>
                        </li>
					</ul> -->
                                    <ul
                v-infinite-scroll="loadMore"
                infinite-scroll-disabled="loading"
                infinite-scroll-distance="1">
                <li v-for="item in list" >{{ item }}</li>
                </ul>
				</div>
				<div id="item3" class="mui-control-content">
                    <div  class="item1-id"><i></i><span>共有n张照片</span></div>
					<!-- 照片九宫格 -->
                        <div class="mui-content item-img">
                            <ul class="mui-table-view mui-grid-view mui-grid-9">
                                <li class="mui-table-view-cell mui-media mui-col-xs-4 ">
                                    <img src="../../src/images/club/01.png"> 
                                </li>
                                <li class="mui-table-view-cell mui-media mui-col-xs-4 ">
                                    <img src="../../src/images/club/01.png"> 
                                </li>
                                <li class="mui-table-view-cell mui-media mui-col-xs-4 ">
                                    <img src="../../src/images/club/01.png"> 
                                </li>
                            </ul> 
		                </div>
                    <!-- 照片结束 -->
                    
				</div>
			</div>
            </div>
 <!--  nav end-->
    </div>

</template>
<script>
 import qs from 'qs';
export default {
name: 'count',
  data(){
      return {
            memnum:0,
            membperson:0,
            uid:this.$route.params.id,
            list:[],
            loading:false,
            styleObject :{
            display:"",
            
            },
            clublist:{},
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
mounted(){
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
    getnewsinfo1(Id){
            var text=qs.stringify(Id);
            var _this=this;
        this.$ajax.get('http://localhost:8081/SuperClub/clubs/clubInfo',{params:{
            uuId:Id
        }}
        ).then(function (ifon){
            
        _this.clublist=ifon.data.item.data;
        console.log(_this.clublist);
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
      
        //   this.clublist.some((item,i)=>{
        //                 if(item.uid == this.uid)
        //                 { 
                            console.log( this.clublist)
                            newlist.push( this.clublist); 
                            //    return  newlist;
                        // }
                   
                    
            //  })
        //      this.$store.state.clubID=0;
        //   return  this.$store.state.clublist;
        return newlist;
      },
      loadMore() {
     
        this.loading = true;
            setTimeout(() => {
                
                let last = this.list[this.list.length - 1];
                
                      this.$Indicator.close();
                for (let i = 1; i <= 2; i++) {
                this.list.push(last + i);
                }
                
                this.loading = false;
               
            }, 2500);
        } 
      
  }
//   watch: {
//            clubID(){
//                 this.clubid=this.$store.state.clubID;
//            }
//        }

}
</script>
<style scoped>
.toptile{
    z-index: 88;
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
        background-color: rgba(9, 9, 9, 0.5);
        border-radius: 20px;
      
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

