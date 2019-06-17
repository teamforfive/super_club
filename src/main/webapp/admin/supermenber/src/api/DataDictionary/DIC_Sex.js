import request from '@/utils/request'

export function getList() {
  return request({
    url: '/api/Sex/GetAll',
    method: 'post',
  })
}
export function addList(data) {
  return request({
    url: '/api/Sex/Add',
    method: 'post',
    data: JSON.stringify(data)
  })
}
export function UdList(data) {
  return request({
    url: '/api/Sex/Update',
    method: 'post',
    data: JSON.stringify(data)
  })
}
