<template>
	<div>
	
		 <!--<router-link to="/">-->
		<div class="mui-card" @click="gf">
			
				<div class="mui-card-header mui-card-media" style="height:28vw;background-image:url(../../src/images/club/bagua.jpg)" >

				</div>
				<div class="mui-card-content">
						<div class="mui-card-content-inner">
							<div class="mui-card-content-head">
								<div>
									<span style="font-size: 20px;font-weight: bold;">{{id.activityTitle}}
									</span>
									<span class="times">活动时间</span>
									<span class="times1">2019/05/01</span>
								</div>
								<span style="color:#fff;">活动地址</span>
							</div>
						
						</div>
					</div>
				</div>
			<!--</router-link>-->
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
export default {
	props:["id"],
name:'active',
data(){
	return{
		
		from:[],
	}
},
created(){
	console.log("sss"+this.id);
},
methods:{
gf(){
this.$router.push({path:'/contentClub'});
},
 async createclub(){
            this.text=qs.stringify(this.ClubList);
            //  var formData = new FormData();
             var formData = new window.FormData();
             var files = document.getElementById("img").files[0];
             formData.append("file",files);
             console.log(formData);
             var hede={
                 "Context-Type":"application/json",
                   "enctype":"multipart/form-data"
             }
            var urll="http://192.168.1.100:8081/SuperClub/clubs/addClub?"+this.text;
            let data = await getData(urll,hede,formData);
            console.log(data);
            //  console.log("id:"+this.$store.state.clubname);
            // var  car={id: this.$store.state.clubname,clubsName:this.clubname,img:this.imgsrc,type:this.clutype,grade:this.clugrade,text:this.text}
            this.$store.state.clublist.push(this.ClubList);
            // this.addClub(formData);
            },

      },
	  }
</script>

<style>
	.mui-card-header.mui-card-media {
	
    padding: 0px;
}
.mui-card-content-head span{
	font-size: 14px;
	    font-weight: bold;
}
	.mui-card{
		border-top-left-radius:15px;
		border-top-right-radius:15px;
		border-bottom-right-radius:15px;
		border-bottom-left-radius:15px;
		
	}
	.mui-card-content-inner
	{
		    background-color: #00D4FE;
			width: 100%;
			border: 0;
			box-shadow:0px -50px 150px #00D4FE;
	}
	.mui-card-content-head{
		width: 100%;
	}
	.mui-card-content-head div span{
		display: inline-block;
		color:#FFFFFF;
	}
	.times{
	font-size:0.3125rem;
	width:20%;
	position: absolute;
    top: 9px;
    right: 0;
	}
	.times1{
	font-size:0.3125rem;
	width:20%;
	position: absolute;
    top: 26px;
    right: 0;
	}
	.content{
		border:0.2px solid #00D4FE;
         margin:5px auto;
        overflow : hidden;
        text-overflow: ellipsis;
        display: -webkit-box;
        -webkit-line-clamp:2;
        -webkit-box-orient: vertical;
		width:100%;
	}
</style>
