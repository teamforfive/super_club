<template>
  <div class="app-container">
    <div class="demo-input-size">
      <el-select v-model="value" placeholder="请选择">
    <el-option
      v-for="item in options"
      :key="item.value"
      :label="item.label"
      :value="item.value">
    </el-option>
  </el-select>
   <el-input class="inputiner"
    placeholder="请输入内容"
    v-model="input4" clearable size="mini">
    <i slot="prefix" class="el-input__icon el-icon-search"></i>
  </el-input>
  <el-button type="primary" icon="el-icon-search">搜索</el-button>
  <el-button type="primary" icon="">添加</el-button>
    </div>
     
    <el-table
      v-loading="listLoading"
      :data="list"
      element-loading-text="Loading"
      border
      fit
      highlight-current-row>
      <el-table-column align="center" label="国籍编码" width="95">
        <template slot-scope="scope">
          {{ scope.$index }}
        </template>
      </el-table-column>
      <el-table-column label="国籍名称" width="95">
        <template slot-scope="scope">
          {{ scope.row.title }}
        </template>
      </el-table-column>
      <el-table-column label="拼音码" width="90" align="center">
        <template slot-scope="scope">
          <span>{{ scope.row.author }}</span>
        </template>
      </el-table-column>
      <el-table-column label="五笔码" width="90" align="center">
        <template slot-scope="scope">
          {{ scope.row.pageviews }}
        </template>
      </el-table-column>
      <el-table-column class-name="status-col" label="是否可用" width="90" align="center">
        <template slot-scope="scope">
          <el-tag :type="scope.row.status | statusFilter">{{ scope.row.status }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column class-name="status-col" label="创建者" width="90" align="center">
        <template slot-scope="scope">
          <el-tag :type="scope.row.status | statusFilter">{{ scope.row.status }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column align="center" prop="created_at" label="创建者时间" width="120">
        <template slot-scope="scope">
          <i class="el-icon-time"/>
          <span>{{ scope.row.display_time }}</span>
        </template>
      </el-table-column>
      <el-table-column class-name="status-col" label="最后修改者" width="80" align="center">
        <template slot-scope="scope">
          <el-tag :type="scope.row.status | statusFilter">{{ scope.row.status }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column align="center" prop="created_at" label="最后修改时间" width="120">
        <template slot-scope="scope">
          <i class="el-icon-time"/>
          <span>{{ scope.row.display_time }}</span>
        </template>
      </el-table-column>
        <el-table-column  align="center" label="操作" width="170">
      <template slot-scope="scope">
        <el-button
          size="mini"
          >编辑</el-button>
        <el-button
          size="mini"
          type="danger"
          >删除</el-button>
      </template>
    </el-table-column>
    </el-table>
  </div>
</template>

<script>
import { getList } from '@/api/table'

export default {
  filters: {
    statusFilter(status) {
      const statusMap = {
        published: 'success',
        draft: 'gray',
        deleted: 'danger'
      }
      return statusMap[status]
    }
  },
  data() {
    return {
      options: [{
          value: '选项1',
          label: '国籍编码'
        }, {
          value: '选项2',
          label: '国籍名称'
        }, {
          value: '选项3',
          label: '拼音码'
        }, {
          value: '选项4',
          label: '五笔码'
        }, {
          value: '选项5',
          label: '创建者'
        }],
      list: null,
      listLoading: true,
      value:'',
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      this.listLoading = true
      getList(this.listQuery).then(response => {
        this.list = response.data.items
        this.listLoading = false
      })
    }
  }
}
</script>
<style scoped>
.el-input{
  width: 150px;
}
</style>
