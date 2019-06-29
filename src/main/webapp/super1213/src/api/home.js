import request from '@/utils/request'

export function getList() {
  return request({
    url: '/SuperClub/clubs/selectList',
    method: 'get',
  })
}
export function getLists() {
  return request({
    url: '/SuperClub/clubs/selectLists',
    method: 'get',
  })
}
export function getifon(Id) {
  return request({
    url: '/SuperClub/clubs/selectClubInfo',
    method: 'get',
    params:{uuId:Id}
  })
}

export function addList(data1) {
  var text=qs.stringify(data1);
  return request({
    url: '/SuperClub/clubs/insertClub?'+text,
    method: 'post',

  })
}

