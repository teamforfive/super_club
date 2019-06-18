import request from '@/utils/request'

export function getList() {
  return request({
    url: '/api/County/GetAll',
    method: 'post',
  })
}
export function addList(data) {
  return request({
    url: '/api/County/Add',
    method: 'post',
    data: JSON.stringify(data)
  })
}
export function UdList(data) {
  return request({
    url: '/api/County/Update',
    method: 'post',
    data: JSON.stringify(data)
  })
}
