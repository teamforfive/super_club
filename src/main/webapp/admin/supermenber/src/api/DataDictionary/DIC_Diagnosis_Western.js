import request from '@/utils/request'

export function getList() {
  return request({
    url: '/api/DiagnosisWestern/GetAll',
    method: 'post',
  })
}
export function addList(data) {
  return request({
    url: '/api/DiagnosisWestern/Add',
    method: 'post',
    data: JSON.stringify(data)
  })
}
export function UdList(data) {
  return request({
    url: '/api/DiagnosisWestern/Update',
    method: 'post',
    data: JSON.stringify(data)
  })
}
