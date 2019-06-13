<template>
	<div>
	
		 <!--<router-link to="/">-->
		<div class="mui-card" @click="gf">
			
				<div class="mui-card-header mui-card-media" style="height:40vw;background-image:url(../../src/images/club/bagua.jpg)" >

				</div>
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
			<!--</router-link>-->
	</div>
</template>

<script>
	export default {
		name:'active',
	  methods:{
		gf(){
			this.$router.push({path:'/contentClub'});
		}
      },
	  }
</script>

<style>
	.mui-card-header.mui-card-media {
	
    padding: 0px;
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
		float: right;
		font-size:0.3125rem;
	   width:20%;
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
