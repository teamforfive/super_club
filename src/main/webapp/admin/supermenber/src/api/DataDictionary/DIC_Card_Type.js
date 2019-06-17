import request from '@/utils/request'

export function getList() {
  return request({
    url: '/api/CardType/GetAll',
    method: 'post',
  })
}
export function addList(data) {
  return request({
    url: '/api/CardType/Add',
    method: 'post',
    data: JSON.stringify(data)
  })
}
export function UdList(data) {
  return request({
    url: '/api/CardType/Update',
    method: 'post',
    data: JSON.stringify(data)
  })
}
