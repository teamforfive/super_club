<template>
<div>
   <div class="mui-content">
			<div class="mui-content-padded">
				<p>这是图片放大预览示例，点击如下图片体验全屏预览功能</p>
				<p>
					<img src="../../src/images/club/01.png" preview="1" preview-text="描述文字" />
				</p>
				<p>图片全屏后，双击或双指缩放均可对图片进行放大、缩小操作，左右滑动可查看同组(data-preview-group相同的图片为一组)其它图片，点击会关闭预览</p>
				<p>
					<img src="../../src/images/club/01.png" preview="1" preview-text="描述文字" />
				</p>
				<p>第三张图片，纯粹为了占位： </p>
				<p>
					<img src="../../src/images/club/01.png" preview="1" preview-text="描述文字"/>
				</p>
			</div>
		</div>
    
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


	.mui-preview-image.mui-fullscreen {
				position: fixed;
				z-index: 20;
				background-color: #000;
			}
			.mui-preview-header,
			.mui-preview-footer {
				position: absolute;
				width: 100%;
				left: 0;
				z-index: 10;
			}
			.mui-preview-header {
				height: 44px;
				top: 0;
			}
			.mui-preview-footer {
				height: 50px;
				bottom: 0px;
			}
			.mui-preview-header .mui-preview-indicator {
				display: block;
				line-height: 25px;
				color: #fff;
				text-align: center;
				margin: 15px auto 4;
				width: 70px;
				background-color: rgba(0, 0, 0, 0.4);
				border-radius: 12px;
				font-size: 16px;
			}
			.mui-preview-image {
				display: none;
				-webkit-animation-duration: 0.5s;
				animation-duration: 0.5s;
				-webkit-animation-fill-mode: both;
				animation-fill-mode: both;
			}
			.mui-preview-image.mui-preview-in {
				-webkit-animation-name: fadeIn;
				animation-name: fadeIn;
			}
			.mui-preview-image.mui-preview-out {
				background: none;
				-webkit-animation-name: fadeOut;
				animation-name: fadeOut;
			}
			.mui-preview-image.mui-preview-out .mui-preview-header,
			.mui-preview-image.mui-preview-out .mui-preview-footer {
				display: none;
			}
			.mui-zoom-scroller {
				position: absolute;
				display: -webkit-box;
				display: -webkit-flex;
				display: flex;
				-webkit-box-align: center;
				-webkit-align-items: center;
				align-items: center;
				-webkit-box-pack: center;
				-webkit-justify-content: center;
				justify-content: center;
				left: 0;
				right: 0;
				bottom: 0;
				top: 0;
				width: 100%;
				height: 100%;
				margin: 0;
				-webkit-backface-visibility: hidden;
			}
			.mui-zoom {
				-webkit-transform-style: preserve-3d;
				transform-style: preserve-3d;
			}
			.mui-slider .mui-slider-group .mui-slider-item img {
				width: auto;
				height: auto;
				max-width: 100%;
				max-height: 100%;
			}
			.mui-android-4-1 .mui-slider .mui-slider-group .mui-slider-item img {
				width: 100%;
			}
			.mui-android-4-1 .mui-slider.mui-preview-image .mui-slider-group .mui-slider-item {
				display: inline-table;
			}
			.mui-android-4-1 .mui-slider.mui-preview-image .mui-zoom-scroller img {
				display: table-cell;
				vertical-align: middle;
			}
			.mui-preview-loading {
				position: absolute;
				width: 100%;
				height: 100%;
				top: 0;
				left: 0;
				display: none;
			}
			.mui-preview-loading.mui-active {
				display: block;
			}
			.mui-preview-loading .mui-spinner-white {
				position: absolute;
				top: 50%;
				left: 50%;
				margin-left: -25px;
				margin-top: -25px;
				height: 50px;
				width: 50px;
			}
			.mui-preview-image img.mui-transitioning {
				-webkit-transition: -webkit-transform 0.5s ease, opacity 0.5s ease;
				transition: transform 0.5s ease, opacity 0.5s ease;
			}
			@-webkit-keyframes fadeIn {
				0% {
					opacity: 0;
				}
				100% {
					opacity: 1;
				}
			}
			@keyframes fadeIn {
				0% {
					opacity: 0;
				}
				100% {
					opacity: 1;
				}
			}
			@-webkit-keyframes fadeOut {
				0% {
					opacity: 1;
				}
				100% {
					opacity: 0;
				}
			}
			@keyframes fadeOut {
				0% {
					opacity: 1;
				}
				100% {
					opacity: 0;
				}
			}
			p img {
				max-width: 100%;
				height: auto;
			}
</style>


