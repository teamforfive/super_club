import request from '@/utils/request'

export function getList() {
  return request({
    url: '/api/RecipesType/GetAll',
    method: 'post',
  })
}
export function addList(data) {
  return request({
    url: '/api/RecipesType/Add',
    method: 'post',
    data: JSON.stringify(data)
  })
}
export function UdList(data) {
  return request({
    url: '/api/RecipesType/Update',
    method: 'post',
    data: JSON.stringify(data)
  })
}
