import request from '@/utils/request'

export function getList() {
  return request({
    url: '/api/Operation/GetAll',
    method: 'post',
  })
}
export function addList(data) {
  return request({
    url: '/api/Operation/Add',
    method: 'post',
    data: JSON.stringify(data)
  })
}
export function UdList(data) {
  return request({
    url: '/api/Operation/Update',
    method: 'post',
    data: JSON.stringify(data)
  })
}
