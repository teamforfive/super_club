const datadic = [
  {
    path: 'Sys_Hospital_Info',
    name: 'Sys_Hospital_Info',
    component: () => import('@/views/SystemModule/DataDictionary/Sys_Hospital_Info'),
    meta: { title: '医疗机构信息', icon: 'table' }
  },
  {
    path: 'DIC_Department',
    name: 'DIC_Department',
    component: () => import('@/views/SystemModule/DataDictionary/DIC_Department'),
    meta: { title: '科室字典', icon: 'tree' }
  },
  {
    path: 'DIC_Diagnosis_Western',
    name: 'DIC_Diagnosis_Western',
    component: () => import('@/views/SystemModule/DataDictionary/DIC_Diagnosis_Western'),
    meta: { title: '西医诊断', icon: 'tree' }
  },
]

export default datadic;