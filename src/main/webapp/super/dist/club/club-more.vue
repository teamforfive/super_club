<template>
<div>
    <mt-header fixed title="本校热门社团">
        <router-link to="/Home" slot="left">
            <mt-button  icon="back" ></mt-button>
        </router-link>
           <router-link to="/" slot="left">
            <mt-button  class="mui-icon mui-icon-closeempty"></mt-button>
           </router-link>
           
            <mt-button icon="more" slot="right"></mt-button>
    </mt-header>
   <ul class="mui-table-view">
				<li class="mui-table-view-cell mui-media" v-for="item in readm()" :key="item.uuId">
					<a href="javascript:;">
						<img class="mui-media-object mui-pull-left" src="../../src/images/club/01.png">
						<div class="mui-media-body">
							<h1>{{item.clubsName}}</h1>
							<p class='mui-ellipsis'>{{item.type}}</p>
                            <p class='muip2'>简介：{{item.clubProfile}}</p>
						</div>
					</a>
				</li>
                <li class="mui-table-view-cell mui-media">
                    <div class="mui-media-body">
                    <span>没有找自己的社团</span>
                    <span>去<p class="crep">创建社团</p>呗~</span>
                    </div>
                </li>
    </ul>

 
    
</div>

</template>
<script>
export default {
    name:"",
    data(){
        return{

        }
    },
    methods:{
     readm(){
        //  this.styleObject.display="none";
        
            var newlist=[];

            this.$store.state.clublist.some((item,i)=>{
                   console.log(item);
                     newlist.push(item); 
                    
             })
          return  newlist;
      }
},
}
</script>
<style scoped>
.mui-icon-closeempty{
    font-size: 32px;
}
.mui-table-view {
 
    margin-top: 45px;
}
.mui-table-view .mui-media-object.mui-pull-left {
    margin: 10px 10px 10px 0;
}
.mui-table-view .mui-media-object {
    line-height: 60;
    max-width: 60px;
    height: 60px;
    border-radius: 50%;
}
 .mui-media-body
{
        margin-top: 10px;
}
    .mui-media-body h1{
            font-size: 18px;
                color: #505050;
    }
    .mui-media-body p{
        font-size: 12px;
    }
    .muip2{
        overflow: hidden;
        text-overflow:ellipsis;
        white-space: nowrap;
       
        font-size: 14px;
    }
     .mui-media-body span{
         text-align: center;
         display: block;
         color: #716c6c;
         font-size: 14px;
         letter-spacing:5px;
     }
     .mui-media-body  .crep{
         display: inline-block;
         font-size: 15px;
         color: #40ABFC;
     }

</style>


