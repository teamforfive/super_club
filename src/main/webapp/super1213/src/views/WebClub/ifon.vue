<template>
 
    <div class="page-cell">
    <mt-header fixed title="用户信息"></mt-header>
    <div class="padii">
    <mt-cell  icon="more" class="cell" is-link>
    <img slot="icon" src="@/assets/404_images/404.png" width="50" height="50">
    <span class="padispan1">名称</span>
    <span class="padispan2">账号:</span>
    </mt-cell>

  <router-link to="/mycl">
    <mt-cell class="myclub" title="我的社团" is-link ></mt-cell>
  </router-link>
    <mt-cell class="myclub" title="设置" is-link ></mt-cell>


    <!-- <mt-cell title="标题文字" value="说明文字"></mt-cell>
    <mt-cell title="标题文字" icon="more" value="带 icon"></mt-cell>
    <mt-cell title="标题文字" icon="more">
      <span>icon 是图片</span>
      <img slot="icon" src="../../src/images/club/01.png" width="24" height="24">
    </mt-cell>
    <mt-cell title="标题文字" is-link value="带链接"></mt-cell>
    <mt-cell title="标题文字" is-link>
      <span style="color: green">这里是元素</span>
    </mt-cell>
    <mt-cell title="标题文字">
      <mt-button size="small" type="primary" icon="back">按钮</mt-button>
    </mt-cell>

    <mt-cell title="标题" label="描述信息" is-link></mt-cell>

    <mt-cell title="原生跳转" label="跳转到 https://mint-ui.github.io" is-link to="https://mint-ui.github.io"></mt-cell>
    <mt-cell title="路由跳转" label="跳转到 /#/toast" is-link :to="{ name: 'Toast' }"></mt-cell> -->
    </div>
  </div>
</template>

<script>
export default {
 
};
</script>

<style scoped  lang="less">
 .padii{
   padding-top: 47px;
 }
 .padii img{
   border-radius: 4px;
 }
 .padii .cell{
       min-height: 120px;
 }
 .padii .padispan1{
   position: absolute;
    left: 75px;
    top: 39px;
    color: rgb(8, 8, 8);
    font-size: 16px;
    font-weight:800;
 }   
 .padii .padispan2{
   position: absolute;
    left: 75px;
    top: 68px;
  
 }
 .myclub{
       min-height: 65px;
 }

 .myclub:before{
   content:'';
    background: #e0e0e0;
    height: 10px;
        width: 100%;
    position: absolute;
 }
//  .myclub:after{
//    content:'';
//     background: #e0e0e0;
//     height: 10px;
//     width: 100%;
//     position: absolute;
//     bottom: 0;
//  }
</style>