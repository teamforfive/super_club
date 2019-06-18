import request from '@/utils/request'

export function getList() {
  return request({
    url: '/api/MedDosageForm/GetAll',
    method: 'post',
  })
}
export function addList(data) {
  return request({
    url: '/api/MedDosageForm/Add',
    method: 'post',
    data: JSON.stringify(data)
  })
}
export function UdList(data) {
  return request({
    url: '/api/MedDosageForm/Update',
    method: 'post',
    data: JSON.stringify(data)
  })
}
