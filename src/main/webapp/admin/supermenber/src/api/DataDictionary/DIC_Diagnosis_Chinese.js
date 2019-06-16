import request from '@/utils/request'

export function getList() {
  return request({
    url: '/api/DiagnosisChinese/GetAll',
    method: 'post',
  })
}
export function addList(data) {
  return request({
    url: '/api/DiagnosisChinese/Add',
    method: 'post',
    data: JSON.stringify(data)
  })
}
export function UdList(data) {
  return request({
    url: '/api/DiagnosisChinese/Update',
    method: 'post',
    data: JSON.stringify(data)
  })
}
