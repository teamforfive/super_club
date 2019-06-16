import request from '@/utils/request'

export function getList() {
  return request({
    url: '/api/Town/GetAll',
    method: 'post',
  })
}
export function addList(data) {
  return request({
    url: '/api/Town/Add',
    method: 'post',
    data: JSON.stringify(data)
  })
}
export function UdList(data) {
  return request({
    url: '/api/Town/Update',
    method: 'post',
    data: JSON.stringify(data)
  })
}
