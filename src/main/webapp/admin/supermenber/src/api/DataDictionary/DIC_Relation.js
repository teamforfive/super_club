import request from '@/utils/request'

export function getList() {
  return request({
    url: '/api/Relation/GetAll',
    method: 'post',
  })
}
export function addList(data) {
  return request({
    url: '/api/Relation/Add',
    method: 'post',
    data: JSON.stringify(data)
  })
}
export function UdList(data) {
  return request({
    url: '/api/Relation/Update',
    method: 'post',
    data: JSON.stringify(data)
  })
}
