import request from '@/utils/request'
import qs from 'qs';
export function getList() {
  return request({
    url: '/SuperClub/clubLevel/selectList',
    method: 'get',
  })
}
export function addList(data1) {
  var text=qs.stringify(data1);
  return request({
    url: '/SuperClub/clubLevel/addLevel?'+text,
    method: 'post',
    // params: {
    //    data1
    // },
    
  })
}
export function UdList(data1) {
  var text=qs.stringify(data1);
  return request({
    url: '/SuperClub/clubLevel/updateLevel?'+text,
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

 