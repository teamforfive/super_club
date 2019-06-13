<template>
    <div class="c-home">
         <mt-header class="head-top" fixed title="超级社团"></mt-header>
               <!-- 顶部下 -->
        <mt-swipe :show-indicators="false" class="club-swipe">
                <mt-swipe-item><img class="img" src="../../src/images/club/01.png"></mt-swipe-item>
                <mt-swipe-item><img  class="img" src="../../src/images/club/01.png"></mt-swipe-item>
        </mt-swipe>
    <mt-search class="club-seach " cancel-text="" placeholder="请输入4-16位社团号搜索" v-bind:class="{ 'fixed-top': isflexdtotp}"></mt-search>
        <div class="LHotclub ">
            <mt-header class="con-hec ">
                <mt-button disabled slot="left">本校热门社团</mt-button>
                <mt-button disabled slot="right" ><router-link  to="/Mclub"><span>更多</span><i class="mui-icon mui-icon-arrowright"></i> </router-link></mt-button>
            </mt-header>
        </div>
        <div class="LHotlist mui-content">
            <ul class="mui-table-view mui-grid-view mui-grid-9">
                 <li @click="rembname(item.uuId)" class="mui-table-view-cell  mui-media mui-col-xs-3" v-for="item in readm()" :key="item.uuId">
                     <router-link  to="/Hclub">
                    <img src="../../src/images/club/01.png">
                    <p>{{item.clubsName}}</p>
                      </router-link>
                </li>
                
                <li  class="mui-table-view-cell  mui-media mui-col-xs-3" @click="isLogin">
                    <router-link  to="/Cclub">
                    <i class="mui-icon mui-icon-plusempty c-club"></i>
                    <p class="g-p">创建社团</p>
                    </router-link>
                </li>
            </ul>
        </div>

        <div class="WHotclub">
            <mt-header class="con-hec">
                <mt-button disabled slot="left">全国热门社团</mt-button>
                <mt-button disabled slot="right" ><span>更多</span><i class="mui-icon mui-icon-arrowright"></i></mt-button>
                <mt-button></mt-button>
            </mt-header>
        </div>
        <div class="WHotlist mui-content">
             <ul class="mui-table-view mui-grid-view mui-grid-9">
                <li class="mui-table-view-cell  mui-media  mui-col-sm-3  mui-col-xs-3">
                    <router-link  to="/Hclub">
                    <img src="../../src/images/club/01.png">
                    <p>技术社团实打实撒</p>
                    </router-link>
                </li>
                 <li class="mui-table-view-cell  mui-media mui-col-sm-3  mui-col-xs-3 tt">
                     <router-link  to="/Hclub">
                    <img src="../../src/images/club/01.png">
                    <p>技术社团</p>
                      </router-link>
                </li>
                 <li class="mui-table-view-cell  mui-media mui-col-sm-3 mui-col-xs-3">
                      <router-link  to="/Hclub">
                    <img src="../../src/images/club/01.png">
                    <p>技术社团</p>
                     </router-link>
                </li>

            </ul>
        </div>

        <div class="WHotclub">
            <mt-header class="con-hec">
                <mt-button disabled slot="left">热门赞助活动</mt-button>
                <mt-button disabled slot="right"><router-link  to="/Aclub"><span>更多</span><i class="mui-icon mui-icon-arrowright"></i></router-link></mt-button>
            </mt-header>
        </div>
        <!-- 底部开始 -->  
        <div class="footswip">
        	<mt-swipe :auto="0">
                <mt-swipe-item>
                    	<img src="../../src/images/club/01.png">
							<p class="mui-slider-title">静静看这世界</p>
                </mt-swipe-item>
                <mt-swipe-item>2</mt-swipe-item>
                <mt-swipe-item>3</mt-swipe-item>
            </mt-swipe>
        </div>
        <!-- 底部结束 -->  
    <router-link  to="/ifoclub"> 
    <font class="boottomf">我的社团</font>
     </router-link>
</div>
</template>
<style lang="less" scoped>
.LHotclub  .mint-header .mint-button,.WHotclub .mint-header .mint-button{
    color: #080808;
    font-size: 14px;
    font-weight: bolder;
}
.head-top{
    z-index: 9999;
}
.club-swipe{
    height: 180px;
    }
    .img{
        width: 100%;
        height: 100%;
    }
 .topac .mui-slider {
    height: 198px;
}
     .mui-slider-title {
    bottom: 32px;

    opacity: 0.5;

}
.search-he{
    height: 40px;
}
.fixed-top{
    position: fixed;
    top: 46px;
    left: 0;
    width: 100%;
    z-index: 99999;
}
.con-hec span,.con-hec i{
        color: #3a3a3a;
         font-size: 13px;
}
.mui-grid-view.mui-grid-9{
    background-color: #fff;
      border-top:0; 
}
.mui-grid-view.mui-grid-9 .mui-table-view-cell {
         border-right: 0;
         border-bottom: 0;
}


.LHotlist li,.WHotlist li{
    margin: 0;
    padding: 11px 15px;
    height: 100%;
    vertical-align: top;
    }
    .LHotlist img,.WHotlist img{
        width: 60px;
        height: 60px;
        border-radius: 50%;
    }
    .LHotlist p,.WHotlist p{
      
        color: black;
        font-size: 12px;
        margin-left: 8px;
        word-wrap:break-word !important; 
        word-break:normal; 
    }
.LHotlist .mui-table-view-cell .c-club{
   font-weight: bolder; 
    font-size: 54px;
    text-shadow: 2px 0px #63CF46;
    border:2px solid #63CF46;
    border-radius: 50%;
    margin-top:4px;
    margin-bottom: 5px;
    width: 60px;
    height: 60px;
}
.c-club{
    color: #63CF46;
    
}
.g-p{
    color: #63CF46 !important;
}
.footswip{
      height: 205px;
}
.footswip  .mui-slider-title{
        bottom: 0px;
}
 .footswip img{
    width: 100%;
    height: 100%;
 }  
 .boottomf{
     position: fixed;
     color: #fff;
     bottom:0;
     left: 0; 
 }
</style>
<script>
import comment from "./ifon.vue";
export default {
   
name:'home',

data(){
    return{
        Sclubist:[],
        newifon:{},
        isflexdtotp:false,
        scrolled:0,
        use:this.$route.params.use,
        img:'',
    }
},
mounted(){
    this.getnewsinfo();
  window.addEventListener('scroll', this.handleScroll)
},
methods:{
    // 判断是否登录了
 
    isLogin(){
       if(this.use==-1){
           this.$router.push({path:'/'});
       }
    },
   getnewsinfo(){
       
       var _this=this;
this.$ajax.get('http://192.168.1.100:8081/SuperClub/clubs/clubList')
  .then(function (ifon){
      console.log(ifon.data);
 _this.$store.state.clublist=ifon.data.item.data;
 console.log( _this.$store.state.clublist);
  }).catch(function (error) {
    console.log(error);
  });
      },
     readm(){
        //  this.styleObject.display="none";
          var newlist=[];
        //   var onlist=[];
           this.$store.state.clublist.some((item,i)=>{
               if(i<3){
                 newlist.push(item); 
               }
           })
          return newlist;
            },
      rembname(name1){
          console.log(name1);
    //   this.getnewsinfo1(name); 
      this.$router.push({
        name: 'count',
        params: {
          id: name1,
        }
      })
      },
    //   监听屏幕滚动
handleScroll () {
    var scrollTop = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop
    if(scrollTop>136)
    {
        this.isflexdtotp=true;
    }
    else if(scrollTop<118)
    {
       this.isflexdtotp=false;
    }
  }
},





}

</script>
