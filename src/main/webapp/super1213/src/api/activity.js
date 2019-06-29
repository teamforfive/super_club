import request from '@/utils/request'
import qs from 'qs';
export function getAc(Id) {
  return request({
    url: '/SuperClub/activity/selectList',
    method: 'get',
    params:{activityClubId:Id}
  })
}
export function addAc(data1) {
  var text=qs.stringify(data1);
  return request({
    url: '/SuperClub/activity/insertActivity?'+text,
    method: 'post',
  
  })
}

export function getAcgrade(data1) {
 
  return request({
    url: '/SuperClub/activityCategory/selectList',
    method: 'get',
  })
}
export function getAct(Id) {
  return request({
    url: '/SuperClub/activity/selectInfo',
    method: 'get',
    params:{uuId:Id}
  })
}
export function getimg(Id) {
  return request({
    url: '/SuperClub/clubs/file/getLogo',
    method: 'post',
    params:{clubId:Id}
  })
}