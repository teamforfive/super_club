import request from '@/utils/request'

export function getList() {
  return request({
    url: '/api/RecipesSpec/GetAll',
    method: 'post',
  })
}
export function addList(data) {
  return request({
    url: '/api/RecipesSpec/Add',
    method: 'post',
    data: JSON.stringify(data)
  })
}
export function UdList(data) {
  return request({
    url: '/api/RecipesSpec/Update',
    method: 'post',
    data: JSON.stringify(data)
  })
}
