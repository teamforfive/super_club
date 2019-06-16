import request from '@/utils/request'

export function getList() {
  return request({
    url: '/api/Treatment/GetAll',
    method: 'post',
  })
}
export function addList(data) {
  return request({
    url: '/api/Treatment/Add',
    method: 'post',
    data: JSON.stringify(data)
  })
}
export function UdList(data) {
  return request({
    url: '/api/Treatment/Update',
    method: 'post',
    data: JSON.stringify(data)
  })
}
