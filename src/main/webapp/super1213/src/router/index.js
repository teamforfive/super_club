import Vue from 'vue'
import Router from 'vue-router'

// in development-env not use lazy-loading, because lazy-loading too many pages will cause webpack hot update too slow. so only in production use lazy-loading;
// detail: https://panjiachen.github.io/vue-element-admin-site/#/lazy-loading

Vue.use(Router)

/* Layout */
import Layout from '../views/layout/Layout'


/**
* hidden: true                   if `hidden:true` will not show in the sidebar(default is false)
* alwaysShow: true               if set true, will always show the root menu, whatever its child routes length
*                                if not set alwaysShow, only more than one route under the children
*                                it will becomes nested mode, otherwise not show the root menu
* redirect: noredirect           if `redirect:noredirect` will no redirect in the breadcrumb
* name:'router-name'             the name is used by <keep-alive> (must set!!!)
* meta : {
    title: 'title'               the name show in subMenu and breadcrumb (recommend set)
    icon: 'svg-name'             the icon show in the sidebar
    breadcrumb: false            if false, the item will hidden in breadcrumb(default is true)
  }
**/
export const constantRouterMap = [
  { path: '/login', component: () => import('@/views/login/index'), hidden: true },
  { path: '/404', component: () => import('@/views/404'), hidden: true },
  {path:'/WebClubApp', redirect: '/Home', component: () => import('@/views/WebClub/clubapp'), hidden: true, 
    children: [{
      path: '/Home',
      name:"Home",
      component: () => import('@/views/WebClub/club-home'),
      },
      {
        path: '/ifoclub',
        component: () => import('@/views/WebClub/ifon'),
      },
      {
        path: '/explam1',
        component: () => import('@/views/WebClub/explam2'),
      },
      {
        path: '/explam',
        component: () => import('@/views/WebClub/explam2'),
      },
            ],
            linkActiveClass: 'mui-active' // 覆盖默认的路由高亮的类，默认的类叫做 router-link-active

  },
  
  {path:'/Mclub', component: () => import('@/views/WebClub/club-more'), hidden: true },
  {path:'/Hclub:id', name:"count",component: () => import('@/views/WebClub/club-count'), hidden: true },
  {path:'/Edit:id', name:"Edit",component: () => import('@/views/WebClub/activeEdit'), hidden: true },
  {path:'/Cclub', name:"Cclub",component: () => import('@/views/WebClub/club-create'), hidden: true },
  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    name: 'Dashboard',
    hidden: true,
    children: [{
      path: 'dashboard',
      component: () => import('@/views/dashboard/index')
    }]
  },
  // 系统管理开始
  {
    path: '/SystemModule',
    component: Layout,
    redirect: '/SystemModule/DataDictionary',
    name: 'sysmanager',
    meta: { title: '系统管理', icon: 'si-glyph-gear' },
    children: [
     
      {
        path: 'index2',
        name: 'index2',
        component: () => import('@/views/SystemModule/index2'),
        meta: { title: '社团管理', icon: 'example' },
        children: [
          {
            path: 'clubLevel',
            name: 'clubLevel',
            component: () => import('@/views/SystemModule/DataDictionary/clubLevel'),
            meta: { title: '社团级别字典', icon: 'table' }
          },
          {
            path: 'club',
            name: 'Tree',
            component: () => import('@/views/SystemModule/DataDictionary/club'),
            meta: { title: '社团管理', icon: 'tree' }
          }

        ],
      },
      
      {
        path: 'external-link',
        component: Layout,
        children: [
          {
            path: '/',
            meta: { title: '日志', icon: 'link' }
          }
        ]
      },
    ]
  },
  // 系统管理结束
  { path: '*', redirect: '/404', hidden: true }
]

export default new Router({
  // mode: 'history', //后端支持可开
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRouterMap
})
