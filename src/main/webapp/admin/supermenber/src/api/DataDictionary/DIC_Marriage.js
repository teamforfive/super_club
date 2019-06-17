import request from '@/utils/request'

export function getList() {
  return request({
    url: '/api/Marriage/GetAll',
    method: 'post',
  })
}
export function addList(data) {
  return request({
    url: '/api/Marriage/Add',
    method: 'post',
    data: JSON.stringify(data)
  })
}
export function UdList(data) {
  return request({
    url: '/api/Marriage/Update',
    method: 'post',
    data: JSON.stringify(data)
  })
}
