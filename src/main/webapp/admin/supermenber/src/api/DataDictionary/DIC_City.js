import request from '@/utils/request'

export function getList() {
  return request({
    url: '/api/City/GetAll',
    method: 'post',
  })
}
export function addList(data) {
  return request({
    url: '/api/City/Add',
    method: 'post',
    data: JSON.stringify(data)
  })
}
export function UdList(data) {
  return request({
    url: '/api/City/Update',
    method: 'post',
    data: JSON.stringify(data)
  })
}
