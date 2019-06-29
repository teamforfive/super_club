<template>
  <div class="app-container">
    <div >
      <el-row>
        <el-col :span="8"><h1>公告栏</h1></el-col>
      </el-row>
    </div>
      <div>未发布公告</div>
   
  </div>
</template>

<script>
import { getList} from "@/api/DataDictionary/club"

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
      list: null,
      listLoading: true
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
<style>
.head-search{
  top :20px
}
</style>

