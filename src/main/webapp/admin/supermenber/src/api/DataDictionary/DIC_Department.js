import request from '@/utils/request'

export function getList() {
  return request({
    url: '/api/DepartClass/GetAll',
    method: 'post',
  })
}
export function addList(data) {
  return request({
    url: '/api/DepartClass/Add',
    method: 'post',
    data: JSON.stringify(data)
  })
}
export function UdList(data) {
  return request({
    url: '/api/DepartClass/Update',
    method: 'post',
    data: JSON.stringify(data)
  })
}
