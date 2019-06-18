import request from '@/utils/request'

export function getList() {
  return request({
    url: '/api/Rh/GetAll',
    method: 'post',
  })
}
export function addList(data) {
  return request({
    url: '/api/Rh/Add',
    method: 'post',
    data: JSON.stringify(data)
  })
}
export function UdList(data) {
  return request({
    url: '/api/Rh/Update',
    method: 'post',
    data: JSON.stringify(data)
  })
}
