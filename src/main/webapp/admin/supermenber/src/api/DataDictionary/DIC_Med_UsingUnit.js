import request from '@/utils/request'

export function getList() {
  return request({
    url: '/api/MedUsingUnit/GetAll',
    method: 'post',
  })
}
export function addList(data) {
  return request({
    url: '/api/MedUsingUnit/Add',
    method: 'post',
    data: JSON.stringify(data)
  })
}
export function UdList(data) {
  return request({
    url: '/api/MedUsingUnit/Update',
    method: 'post',
    data: JSON.stringify(data)
  })
}
