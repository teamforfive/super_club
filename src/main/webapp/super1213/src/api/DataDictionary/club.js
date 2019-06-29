import request from '@/utils/request'
import qs from 'qs';
export function getList() {
  return request({
    url: '/SuperClub/clubs/selectLists',
    method: 'get',
  })
}
export function addList(data1) {
  var text=qs.stringify(data1);
  return request({
    url: '/SuperClub/clubs/insertClub?'+text,
 
    
    method: 'post',

    headers: {'Content-Type': "multipart/form-data"},

    // params: {
    //    data1
    // },
    
  })
}
export function UdList(data1) {
  var text=qs.stringify(data1);
  return request({
    url: '/SuperClub/clubs/updateClub?'+text,
    method: 'post',
  })
}
export function DelList(data1) {
  var text=qs.stringify(data1);
  return request({
    url: '/SuperClub/clubLevel/deleteLevel?'+text,
    method: 'post',
  })
}
export function getGrade() {
  return request({
    url: '/SuperClub/clubLevel/selectList',
    method: 'get',

  })
}
export function getmyGrade() {
  return request({
    url: '/SuperClub/clubLevel/selectList',
    method: 'get',

  })
}
 
 