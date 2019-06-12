// 入口文件
// import Vue from '../node_modules/vue/dist/vue.js'

import Vue from 'vue'
import store from './store'
// import VueResource from 'vue-resource'
// Vue.use(VueResource);
// 1.1 导入路由的包
import VueRouter from 'vue-router'
// 1.2 安装路由
Vue.use(VueRouter)
import axios from 'axios'
import VueAxios from 'vue-axios'
 

Vue.prototype.$ajax=axios

import 'mint-ui/lib/style.css'

// // 2.1 导入 vue-resources
// import VueResource from 'vue-resource'
// // 2.2 安装 vue-resource
// Vue.use(VueResource)
import { Button,Header,Swipe,SwipeItem,Search,Field, Popup,Picker,Radio,InfiniteScroll,Indicator,Loadmore} from 'mint-ui';

Vue.component(Button.name, Button);
Vue.component(Header.name, Header);
Vue.component(Swipe.name, Swipe);
Vue.component(SwipeItem.name, SwipeItem);
Vue.component(Search.name, Search);
Vue.component(Field.name, Field);
Vue.component(Popup.name, Popup);
Vue.component(Picker.name, Picker);
Vue.component(Radio.name, Radio);
Vue.use(InfiniteScroll);
Vue.use(Loadmore);
Vue.prototype.$Indicator=Indicator
import './lib/MUI/css/mui.css'
import './lib/MUI/js/mui.min.js'

import './css/club.css'
// 1.3 导入自己的 router.js 路由模块
import router from './router'
import club from './club.vue'
var vm = new Vue({
  el: '#app',
  render: c => c(club),
  router,
  store,
})