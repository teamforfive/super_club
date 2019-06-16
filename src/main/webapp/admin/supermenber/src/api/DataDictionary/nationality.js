import request from '@/utils/request'

export function getList() {
  return request({
    url: '/api/Nationality/GetAll',
    method: 'post',
  })
}
export function add(data) {
  return request({
    url: '/api/Nationality/Add',
    method: 'post',
    data:JSON.stringify(data)
  })
}

export function update(data) {
    return request({
      url: '/api/Nationality/Update',
      method: 'post',
      data:JSON.stringify(data)
    })
}