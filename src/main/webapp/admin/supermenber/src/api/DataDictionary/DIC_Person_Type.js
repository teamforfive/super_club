import request from '@/utils/request'

export function getList() {
  return request({
    url: '/api/PersonType/GetAll',
    method: 'post',
  })
}
export function addList(data) {
  return request({
    url: '/api/PersonType/Add',
    method: 'post',
    data: JSON.stringify(data)
  })
}
export function UdList(data) {
  return request({
    url: '/api/PersonType/Update',
    method: 'post',
    data: JSON.stringify(data)
  })
}
