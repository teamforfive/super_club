import Vue from 'vue'
import Router from 'vue-router'

// in development-env not use lazy-loading, because lazy-loading too many pages will cause webpack hot update too slow. so only in production use lazy-loading;
// detail: https://panjiachen.github.io/vue-element-admin-site/#/lazy-loading

Vue.use(Router)

/* Layout */
import Layout from '../views/layout/Layout'
import datadic from './DataDictionary/datadictionary'

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
      // {
      //   path:"sysmanager",
      //   component: () => import('@/views/sysmanager/index')
      // },
      // {
      //   path: 'index',
      //   name: '用户管理',
      //   component: () => import('@/views/SystemModule/index'),
      //   meta: { title: '用户管理', icon: 'example' },
      //   children: [

      //     {
      //       path: 'use',
      //       name: 'Table',
      //       component: () => import('@/views/SystemModule/use/UserInfo'),
      //       meta: { title: '用户信息', icon: 'table' }
      //     },
      //     {
      //       path: 'Character',
      //       name: 'Tree',
      //       component: () => import('@/views/SystemModule/use/Character'),
      //       meta: { title: '角色信息', icon: 'tree' }
      //     },
      //     {
      //       path: 'Features',
      //       name: 'Tree',
      //       component: () => import('@/views/SystemModule/use/Features'),
      //       meta: { title: '功能模块', icon: 'tree' }
      //     },

      //   ],
      // },
      {
        path: 'index2',
        name: '系统管理i',
        component: () => import('@/views/SystemModule/index2'),
        meta: { title: '系统管理', icon: 'example' },
        children: datadic,
      },
      {
        path: 'external-link',
        component: Layout,
        children: [
          {
            path: '/',
            meta: { title: '系统配置', icon: 'link' }
          }
        ]
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
