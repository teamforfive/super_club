import request from '@/utils/request'

export function getList() {
  return request({
    url: '/api/Bed/GetAll',
    method: 'post',
  })
}
export function addList(data) {
  return request({
    url: '/api/Bed/Add',
    method: 'post',
    data: JSON.stringify(data)
  })
}
export function UdList(data) {
  return request({
    url: '/api/Bed/Update',
    method: 'post',
    data: JSON.stringify(data)
  })
}
