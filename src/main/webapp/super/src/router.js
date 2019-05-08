import VueRouter from 'vue-router'

// 导入对应的路由组件
import Hotclub from '../dist/club/club-count.vue'
import Myclub from '../dist/club/club-myclub.vue'
import Aclub from '../dist/club/club-active.vue'
import ifoclub from '../dist/club/ifon.vue'
import Homeclub from '../dist/club/club-home.vue'
import Mclub from '../dist/club/club-more.vue'
import Cclub from '../dist/club/club-create.vue'
import Login from '../dist/club/club-login.vue'


// 3. 创建路由对象
var router = new VueRouter({
  routes: [ // 配置路由规则
    { path: '/Home',name:'home',component: Homeclub },
    { path: '/Hclub:id',name:"count", component: Hotclub },
    { path: '/Aclub', component: Aclub },
    { path: '/Mclub', component: Mclub },
    { path: '/Cclub', component: Cclub },
    { path: '/Myclub', component: Myclub },
    { path: '/ifoclub', component: ifoclub },
    { path: '/', component: Login },
  ],
  linkActiveClass: 'mui-active' // 覆盖默认的路由高亮的类，默认的类叫做 router-link-active
})

// 把路由对象暴露出去
export default router