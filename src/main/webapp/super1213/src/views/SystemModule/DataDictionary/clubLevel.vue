<template>
  <div class="">
    <div class="demo-input-size">
      <el-row>
        <el-col :span="4">
         
        </el-col>
        <el-col :span="8">
          <el-input placeholder="请输入内容" v-model="search" clearable>
            <i slot="prefix" class="el-input__icon el-icon-search"></i>
          </el-input>
        </el-col>
        <el-col :span="8" class="searchbtn">
          <el-button type="primary" icon="el-icon-search" @click="searchData()">搜索</el-button>
          <el-button type="primary" @click="handleAdd()">添加</el-button>
        </el-col>
      </el-row>
  </div> 
 <div>
    <el-table
      :data="list"
      border 
      style="width: 100%"
       max-height="550" >
      <el-table-column align="center"   label="序号" width="120" fixed>
        <template slot-scope="scope">
          {{ scope.$index }}
        </template>
      </el-table-column>
      <el-table-column align="center"   label="社团级别" width="120" >
        <template slot-scope="scope">
          {{ scope.row.clName}}
        </template>
      </el-table-column>
      
       
     
        <el-table-column fixed="right" align="center" label="操作">
      <template slot-scope="scope">
        <el-button size="mini" @click="handleEdit(scope)">编辑</el-button>
        <el-button size="mini" type="danger" @click="handleDelete(scope)">删除</el-button>
      </template>
    </el-table-column>
    </el-table>
    </div>
      <el-dialog :visible.sync="Eitdialog" :title="dialogType==='yes'?'添加科室信息':'编辑科室信息'">
      <el-form label-width="140px" label-position="left" ref="form" :model="form" :rules="rules">

        <el-form-item label="社团名称" prop="clName">
          <el-input  v-model="form.clName" ></el-input>
        </el-form-item>
      

      </el-form>
      <div style="text-align:right;">
        <el-button type="danger" @click="Eitdialog=false">关闭</el-button>
        <el-button type="primary" @click="dialogType==='yes'?adddata():UpdateDate()">确定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { getList,UdList,DelList,addList} from '@/api/DataDictionary/clubLevel'
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
      data:'',
      Is_Enable:"",
      Is_Delete:"",
      dialogType: 'yes',

      imageUrl: '',

      grade:[],
      goption:[],

      options: [{
          value: 'clubsName',
          label: '社团名称'
        }, {
          value: 'City_Code',
          label: '社团编码'
        },],
        search:'',
        fd1:'',
        optionValue:'',
        Eitdialog:false,
        form:{
           clName:'',
           uuId:'',
        },
    
        formLabelWidth: '120px',
      list: [],
      listLoading: true,
      value:'',
       rules: {
        County_Name: [{ required: true, message: '市名称必填！', trigger: 'blur' }],
      }
    }
  },
  created() {
    this.fetchData();
  },
  methods: {
    fetchData() {
      this.listLoading = true;
      getList().then(response => {
        console.log(response);
       this.list=response.item.data;
        this.listLoading = false
      })
    },
   
    adddata(){
      this.dialogFormVisible=false;
      this.listLoading = true
     
      addList(this.form).then(response => {
        console.log(response);
      
      this.fetchData()
      this.listLoading = false;
         this.Eitdialog=false;
      }, response => {
            console.log(response);
         
         });
    },
    handleDelete({ $index, row }) {
      var _this=this;
      this.$confirm('你确定要删除吗?', '警告', {
        confirmButtonText: '确定',
        cancelButtonText: '关闭',
        type: 'warning'
      }).then(async() => {
         var newlist =row;
            this.listLoading = true;
        DelList(newlist).then(response => {
      console.log(response);
      this.listLoading = false;
      });
      _this.list.splice($index, 1)
          this.$message({
            type: 'success',
            message: '删除成功!'
          })
        })
        .catch(err => { console.error(err) })
    },
    Uddata(){
      this.dialogFormVisible=false;
      this.listLoading = true;
      UdList(this.form).then(response =>{
          console.log(response);
      this.listLoading = false;
      });
    },

    handleEdit(scope) {
     
      this.dialogType = 'no';
     
      this.Eitdialog = true;
      this.checkStrictly = true;
      //    if(scope.row.Is_Enable)
      // {
      //   this.Is_Enable="是"
      // }
      // else{
      //   this.Is_Enable="否"
      // }

      //  if(scope.row.Is_Delete)
      // {
      //   this.Is_Delete="是"
      // }
      // else{
      //   this.Is_Delete="否"
      // }
      this.form=scope.row;
      console.log(this.form);
    },
    clearform(){

      this.form.clName='',
      this.form.uuId='';
    },
    handleAdd() {
    
    
      this.clearform();

     
      this.dialogType = 'yes';
        console.log( this.form.uuId);
      console.log("add");
      this.Eitdialog = true;
      this.checkStrictly = true;

    },
    UpdateDate(){
      this.isEnable();
      this.isDelete();

      var newlist=this.form;

      UdList(newlist).then(response =>{
     console.log(response);
      });
      this.Eitdialog=false;
    },
  searchData() {
    var _this=this;
      var search = this.search;
      this.listLoading = true;
      getList().then(response => {
        var datalist = response.item.data;
        if (search) {
          // this.list = datalist.filter(rowdate => {
          //   return Object.keys(rowdate).some(key => {
          //     return (
          //       String(rowdate[key])
          //         .toLowerCase()
          //         .indexOf(search) > -1
          //     );
          //   });
          // });
          var newlist=datalist.filter(item=>{
        
              if(item.clName.includes(search))
              {
                return item;
              }
              
         })
         this.list= newlist;
        } else {
          this.list = datalist;
        }
        this.listLoading = false;
      });
      this.listLoading = false;
  },
   getdateloc(){
    let  date=new Date();
    let  newdate=date.toLocaleString('chinese', { hour12: false});
    return newdate;
  },
 
  }
 
}
</script>
<style scoped>
.el-input{
      padding:0 5px;
}
.avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }
  .avatar {
    width: 178px;
    height: 178px;
    display: block;
  }
</style>
