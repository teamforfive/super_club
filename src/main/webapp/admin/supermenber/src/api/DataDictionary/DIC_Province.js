import request from '@/utils/request'

export function getList() {
  return request({
    url: '/api/Province/GetAll',
    method: 'post',
  })
}
export function addList(data) {
  return request({
    url: '/api/Province/Add',
    method: 'post',
    data: JSON.stringify(data)
  })
}
export function UdList(data) {
  return request({
    url: '/api/Province/Update',
    method: 'post',
    data: JSON.stringify(data)
  })
}
