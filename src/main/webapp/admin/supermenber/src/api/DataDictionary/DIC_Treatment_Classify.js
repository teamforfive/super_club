import request from '@/utils/request'

export function getList() {
  return request({
    url: '/api/TreatmentClassify/GetAll',
    method: 'post',
  })
}
export function addList(data) {
  return request({
    url: '/api/TreatmentClassify/Add',
    method: 'post',
    data: JSON.stringify(data)
  })
}
export function UdList(data) {
  return request({
    url: '/api/TreatmentClassify/Update',
    method: 'post',
    data: JSON.stringify(data)
  })
}
