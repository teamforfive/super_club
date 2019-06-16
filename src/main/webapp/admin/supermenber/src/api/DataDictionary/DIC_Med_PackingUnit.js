import request from '@/utils/request'

export function getList() {
  return request({
    url: '/api/MedPackingUnit/GetAll',
    method: 'post',
  })
}
export function addList(data) {
  return request({
    url: '/api/MedPackingUnit/Add',
    method: 'post',
    data: JSON.stringify(data)
  })
}
export function UdList(data) {
  return request({
    url: '/api/MedPackingUnit/Update',
    method: 'post',
    data: JSON.stringify(data)
  })
}
