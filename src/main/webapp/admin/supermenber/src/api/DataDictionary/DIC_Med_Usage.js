import request from '@/utils/request'

export function getList() {
  return request({
    url: '/api/MedUsage/GetAll',
    method: 'post',
  })
}
export function addList(data) {
  return request({
    url: '/api/MedUsage/Add',
    method: 'post',
    data: JSON.stringify(data)
  })
}
export function UdList(data) {
  return request({
    url: '/api/MedUsage/Update',
    method: 'post',
    data: JSON.stringify(data)
  })
}
