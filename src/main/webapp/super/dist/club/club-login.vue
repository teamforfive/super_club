<template>

<div>
	   

	<transition  name="fade">
		<div class="Lg" v-show="flag1">
			<div class="Lgp">
				<h2>登录注册</h2>
				<h2>体验大学新生活</h2>
				<p>注册代表您已同意</p>
				<p>《表表使用条款和隐私政策》</p>
			</div>
			<!-- 中部 -->
			<div class="lgm">
				<form class="mui-input-group">
					<div class="mui-input-row">
						<input type="text" class="mui-input-clear" placeholder="请输入手机号">
						<span class="mui-icon mui-icon-clear mui-hidden"></span>
					</div>
				</form>
				<div class="lgbtn">
					<router-link to="/Cclub" slot="left">
					
					<mt-button type="primary" size="large">获取验证码</mt-button>
					
					</router-link>
				</div>
				<div class="Idbtn" @click="topshow"><p>账号密码登录</p></div>
			</div>
		</div>
		
	</transition>

		<transition name="fade">
		<div class="top2" v-show="flag2">
			<div class="Lgp">
				<h2>请输入账号密码</h2>
			</div>
			<div class="topbottom">
			<form >
				<div class="mui-input-row">
					<input id='account' type="text" class="mui-input-clear mui-input" placeholder="请输入账号" v-model="use">
				</div>
				<div class="mui-input-row mui-password">
                <input type="password" class="mui-input-password"  v-model="password">
                <span class="mui-icon mui-icon-eye "></span>
            </div>
			</form>
			<form class="mui-input-group">
				<ul class="mui-table-view mui-table-view-chevron">
					<li class="mui-table-view-cell">
						自动登录
						<div id="autoLogin" class="mui-switch">
							<div class="mui-switch-handle"></div>
						</div>
					</li>
				</ul>
			</form>
			<div class="mui-content-padded">
				<button id='login' type="button" class="mui-btn mui-btn-block mui-btn-primary" @click="login">登录</button>
				<div class="link-area"><a id='reg'>注册账号</a> <span class="spliter">|</span> <a id='forgetPassword'>忘记密码</a><span class="spliter">|</span> <a id='phone' @click="topshow">验证码登录</a>
				</div>
			</div>
			<div class="mui-content-padded oauth-area">
			</div>
		</div>
		</div>
		
		</transition>
		<div class="bottom">
			<button  @click="Flogin">游客登录</button>
			<div class="title"><p>其他登录</p></div>
		<nav class="mui-bar mui-bar-tab">
			
			<a class="mui-tab-item mui-active" href="#tabbar">
				 <ul class="mui-table-view mui-grid-view">
		            <li class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-3">
		               <img src="../../src/images/login/sinaweibo.png">
					</li>
		            <li class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-3">
		                     <img src="../../src/images/login/weixin.png">
					</li>
		            <li class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-3">
		                   <img src="../../src/images/login/qq.png">
					</li>
		        </ul> 
			</a>
		</nav>
			
		</div>
</div>
</template>

<script>
export default {
    name:'',
	data(){
		return{
			flag1:false,
			flag2:true,
			use:'',
			password:'',
		}
	},
	mounted(){

	},
	methods:{
		topshow(){
			this.flag1=!this.flag1;
			this.flag2=!this.flag2;
		},
		login(){
				if(this.use=="123"&&this.password=="123")
				{
					console.log("登录成功");
					this.$router.push({path:'/Home:use',
						name: 'home',
       				 params: {
          						use: this.use,
        					}
					});
				}else{
					alert("登录失败");
				}
		},
		Flogin(){
			this.$router.push({path:'/Home:use',
						name: 'home',
       				 params: {
          						use:-1,
        					}
					});
		}
	}
}
</script>
<style scoped>
	.fade-enter-active, .fade-leave-active {
  		transition: all .5s ease;
		}
	.fade-enter  {
  		opacity: 0;
		transform: translateX(100%);
	
		}
	 .fade-leave-to{
		 	opacity: 0;
		transform: translateX(-100%);
		position: absolute;
	 }
	.Lg, .top2{
		margin-top: 55px;
		    position: absolute;
    width: 100%;
	}
	.topbottom{
		margin: 100px 0 0 15px;
	}
	.Lgp{
		margin-left: 15px;
	}
	.Lgp h2:nth-child(2){
		margin-bottom: 10px;
	}
	.Lgp p{
		display: inline-block;
	}
	.Lgp p:nth-child(4){
		color: #1C8CF9;
	}
	.lgm{
		margin-top: 50px;
	}
	.area {
				margin: 20px auto 0px auto;
			}
			
			.mui-input-group {
				margin-top: 10px;
			}
			
			.mui-input-group:first-child {
				margin-top: 20px;
			}
			
			.mui-input-group label {
				width: 22%;
			}
			
			.mui-input-row label~input,
			.mui-input-row label~select,
			.mui-input-row label~textarea {
				width: 78%;
			}
			
			.mui-checkbox input[type=checkbox],
			.mui-radio input[type=radio] {
				top: 6px;
			}
			
			.mui-content-padded {
				margin-top: 25px;
			}
			
			.mui-btn {
				padding: 10px;
			}
			
			.link-area {
				display: block;
				margin-top: 25px;
				text-align: center;
			}
			
			.spliter {
				color: #bbb;
				padding: 0px 8px;
			}
			
			.oauth-area {
				position: absolute;
				bottom: 20px;
				left: 0px;
				text-align: center;
				width: 100%;
				padding: 0px;
				margin: 0px;
			}
			
			.oauth-area .oauth-btn {
				display: inline-block;
				width: 50px;
				height: 50px;
				background-size: 30px 30px;
				background-position: center center;
				background-repeat: no-repeat;
				margin: 0px 20px;
			
				border: solid 1px #ddd;
				border-radius: 25px;
			}
			
			.oauth-area .oauth-btn:active {
				border: solid 1px #aaa;
			}
			
			.oauth-area .oauth-btn.disabled {
				background-color: #ddd;
			}
		
		.mui-input-group:before {
		height: 0;
		}
		.mui-input-group:after 
		{
			    left: 16px;
		}
		.lgbtn{
			    padding: 64px 123px;
			}
		.mint-button{
			border-radius: 32px;
			    height: 55px;
		}
		.mui-input-group .mui-input-row {
			    height: 50px;
		}
	.bottom .mui-grid-view.mui-grid-9{
		background-color: #fff;
	}
	.bottom li img{
			width: 32px;
			height: 32px;
		}

	.Idbtn {
		text-align: center;
	}
	.Idbtn p{
		color: #5fa4e7;
    font-weight: 600;
    font-size: 17px;
	}
	.bottom .title{
		position: absolute;
		width: 200px;
		border-top:1px solid #858383;
		left: 50%;
		transform: translateX(-50%);
		bottom: 102px;
	}
	.bottom .title p{
	position: absolute;
    top: -10px;
    left: 50%;
    transform: translateX(-50%);
    background: #fff;
    font-size: 15px;
    
    font-weight: bold;
    padding: 0 10px;
	}
	.mui-grid-view.mui-grid-9 .mui-table-view-cell{
		border: 0;
	}
	.bottom .mui-bar{
		box-shadow:none;
			-webkit-box-shadow:none;
	}
	.mui-bar-tab{
		bottom: 33px;
	}
	.mui-table-view:after{
		height: 0;
	}
</style>
