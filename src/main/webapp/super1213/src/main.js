import Vue from 'vue'

import 'normalize.css/normalize.css' // A modern alternative to CSS resets

import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import locale from 'element-ui/lib/locale/lang/en' // lang i18n

import '@/styles/index.scss' // global css

import '@/styles/MUI/css/mui.css' 
import '@/styles/style.css'
import '@/styles/skin.css' 
import '@/styles/club.css' 
import App from './App'
import store from './store'
import router from './router'
import base from './commonality/index'
import '@/icons' // icon
import '@/permission' // permission control

/**
 * This project originally used easy-mock to simulate data,
 * but its official service is very unstable,
 * and you can build your own service if you need it.
 * So here I use Mock.js for local emulation,
 * it will intercept your request, so you won't see the request in the network.
 * If you remove `../mock` it will automatically request easy-mock data.
 */
import '../mock' // simulation data
import { Cell, Button,Header,Swipe,SwipeItem,Search,Field, Popup,Picker,Radio,InfiniteScroll,Indicator,Loadmore, DatetimePicker,Navbar, TabItem,TabContainer, TabContainerItem } from 'mint-ui';
 import Calendar from 'vue-mobile-calendar'
 Vue.use(Calendar);
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
Vue.component(DatetimePicker.name, DatetimePicker);
Vue.component(Navbar.name, Navbar);
Vue.component(TabItem.name, TabItem);
Vue.component(TabContainer.name, TabContainer);
Vue.component(TabContainerItem.name, TabContainerItem);
Vue.component(Cell.name, Cell);
import VueLazyload from 'vue-lazyload'

Vue.use(VueLazyload)
import preview from 'vue-photo-preview'
Vue.use(preview)
Vue.use(ElementUI, { locale })
Vue.use(base)
Vue.config.productionTip = false

new Vue({
  el: '#app',
  router,
  store,
  render: h => h(App)
})
