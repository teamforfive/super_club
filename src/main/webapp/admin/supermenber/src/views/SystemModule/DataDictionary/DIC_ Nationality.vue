<template>
  <div class="">
    <div class="demo-input-size  searchdiv">
        <el-row>
        <el-col :span="4">
          <el-select v-model="optionValue" placeholder="请选择">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            ></el-option>
          </el-select>
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
       <el-table-column align="center" label="序号" width="95">
          <template slot-scope="scope">{{ scope.$index }}</template>
        </el-table-column>
        <el-table-column label="民族编码" width="95">
          <template slot-scope="scope">{{ scope.row.Nationality_Code }}</template>
        </el-table-column>
        <el-table-column label="民族名称" width="95">
          <template slot-scope="scope">{{ scope.row.Nationality_Name }}</template>
        </el-table-column>
        <el-table-column label="排序码" width="90" align="center">
          <template slot-scope="scope">{{ scope.row.Sort_Id }}</template>
        </el-table-column>
         <el-table-column class-name="status-col" label="是否可用" width="110" align="center">
        <template slot-scope="scope">
            <div v-if="scope.row.Is_Enable">是</div>
            <div v-else>否</div>
        </template>
      </el-table-column>
      <el-table-column class-name="status-col" label="是否可删除" width="110" align="center">
        <template slot-scope="scope">
            <div v-if="scope.row.Is_Delete">是</div>
            <div v-else>否</div>
        </template>
      </el-table-column>
        <el-table-column label="创建人" width="90" align="center">
          <template slot-scope="scope">{{ scope.row.Creater }}</template>
        </el-table-column>
        <el-table-column label="创建时间" width="90" align="center">
          <template slot-scope="scope">{{ scope.row.Create_date }}</template>
        </el-table-column>
        <el-table-column label="最后修改者" width="90" align="center">
          <template slot-scope="scope">{{ scope.row.Modifier }}</template>
        </el-table-column>
        <el-table-column label="最后修改时间" width="90" align="center">
          <template slot-scope="scope">{{ scope.row.Last_Update_Dtime }}</template>
        </el-table-column>
        <el-table-column fixed="right" align="center" label="操作" width="170">
      <template slot-scope="scope">
        <el-button size="mini" @click="handleEdit(scope)">编辑</el-button>
        <el-button size="mini" type="danger" @click="handleDelete(scope)">删除</el-button>
      </template>
    </el-table-column>
    </el-table>
    </div>
      <el-dialog :visible.sync="Eitdialog" :title="dialogType==='yes'?'添加科室信息':'编辑科室信息'" :before-close="closeDialog">
      <el-form label-width="140px" label-position="left" ref="form" :model="form" :rules="rules">
        
        <el-form-item label="民族名称" :label-width="formLabelWidth" prop="Nationality_Name">
          <el-input v-model="form.Nationality_Name"></el-input>
        </el-form-item>
        <el-form-item label="排序码" :label-width="formLabelWidth" prop="Sort_Id">
          <el-input type="Sort_Id" v-model.number="form.Sort_Id"  autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="是否可用" prop="Is_Enable">
            <el-select v-model="Is_Enable" placeholder="请选择" >
            <el-option label="是" value="true"></el-option>
            <el-option label="否" value="false"></el-option>
            </el-select>
        </el-form-item>

        <el-form-item label="是否可删除" prop="Is_Delete">
            <el-select v-model="Is_Delete" placeholder="请选择">
            <el-option label="是" value="true"></el-option>
            <el-option label="否" value="false"></el-option>
            </el-select>
        </el-form-item>
       
        <el-form-item label="创建人" :label-width="formLabelWidth" prop="Creater" >
          <el-input v-model="form.Creater"></el-input>
        </el-form-item>
        <el-form-item label="创建时间" :label-width="formLabelWidth" prop="Create_date">
        <el-input v-model="form.Create_date"></el-input>
        </el-form-item>
        <el-form-item label="最后修改者" :label-width="formLabelWidth" prop="Modifier">
          <el-input v-model="form.Modifier"></el-input>
        </el-form-item>
        <el-form-item label="最后修改时间" :label-width="formLabelWidth" prop="Last_Update_Dtime">
          <el-input v-model="form.Last_Update_Dtime"></el-input>
        </el-form-item>
      </el-form>
      <div style="text-align:right;">
        <el-button type="danger" @click="resetForm('form')">取消</el-button>
        <el-button type="primary" @click="dialogType==='yes'?adddata():UpdateDate()">提交</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { getList, addList,UdList} from '@/api/DataDictionary/DIC_ Nationality'
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
      options: [{
          value: 'Nationality_Name',
          label: '民族名称'
        }, {
          value: 'Nationality_Code',
          label: '民族编码'
        },],
        search:'',
        optionValue:'',
      
        Eitdialog:false,
        form: {
        Nationality_Code:0,
        Nationality_Name: "",
        Sort_Id:0,
        Is_Enable: true,
        Is_Delete: false,
        Creater:'',
        Create_date: "2019-06-04T07:14:16.540Z",
        Modifier:'',
        Last_Update_Dtime: "2019-06-04T07:14:16.540Z"
        },
        formLabelWidth: '120px',
        list: [],
        listLoading: true,
        value:'',
        rules: {
        Nationality_Name: [{ required: true, message: '民族名称必填！', trigger: 'blur' }],
        Sort_Id: [{ required: true, message: '排序码必填！', trigger: 'blur' },{ type: 'number', message: '必须为数字值'}],
        Is_Enable:[{ required: true, message: '必选！', trigger: 'blur' }],
        Is_Delete:[{ required: true, message: '必选！', trigger: 'blur' }],
        Creater:[{ required: true, message: '必填！', trigger: 'blur' }],
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
       this.list = response.data.Items;
        this.listLoading = false;
      })
    },
    resetForm(formName) {
     
      this.Eitdialog=false;
      
      this.$refs[formName].resetFields();
        
      },
      // 点击左上角的×
    closeDialog(){
       this.Eitdialog=false;
      //  关闭表单数据重置
        this.$refs['form'].resetFields();
    },
    adddata(){
      this.dialogFormVisible=false;
      this.listLoading = true;
       
       this.isEnable();
      this.isDelete();
      this.form.Create_date=this.getdateloc();
      addList(this.form).then(response => {
      this.fetchData()
      this.$refs['form'].resetFields();
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
         newlist.Is_Delete=true;
          newlist.Is_Enable=true;
        UdList(newlist).then(response => {
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
    handleEdit(scope) {
      this.dialogType = 'no'
   
      this.Eitdialog = true
      this.checkStrictly = true
         if(scope.row.Is_Enable)
      {
        this.Is_Enable="是"
      }
      else{
        this.Is_Enable="否"
      }

       if(scope.row.Is_Delete)
      {
        this.Is_Delete="是"
      }
      else{
        this.Is_Delete="否"
      }
      this.form=scope.row;
    },
    handleAdd() {
    
      this.form.Nationality_Name='',
      this.form.Sort_Id='';
      this.Is_Enable='';
      this.Is_Delete='';
      this.form.Is_Delete='';
      this.form.Is_Enable='';
      this.form.Creater='';
      this.form.Modifier='';
    
      this.dialogType = 'yes'
      this.Eitdialog = true
      this.checkStrictly = true
      // this.$nextTick(() => {
      //   // const routes = this.generateRoutes(this.role.routes)
      //   // this.$refs.tree.setCheckedNodes(this.generateArr(routes))
      //   // // set checked state of a node not affects its father and child nodes
      //   // this.checkStrictly = false
      //    this.$refs["adduserform"].resetFields();
      // })
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
        var datalist = response.data.Items;
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
          if(this.optionValue=="Nationality_Name")
          {
 					if(item.Nationality_Name.includes(search))
            {
              return item;
            }
          }else if(this.optionValue=="Nationality_Code")
          {
            
            var Snumber=item.Nationality_Code.toString();
               if(Snumber.includes(search))
            {
              return item;
            }
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
    let  newdate=date.toLocaleString('chinese', { hour12: false });
    return newdate;
  },
   isEnable(){
       if( this.Is_Enable=='true'||this.Is_Enable=='是')
      {
        this.form.Is_Enable=true;
      }
      else{
        this.form.Is_Enable=false;
      }
  },
isDelete(){
       if( this.Is_Delete=='true'||this.Is_Delete=='是')
      {
        this.form.Is_Delete=true;
      }
      else{
        this.form.Is_Delete=false;
      }
  }
  }
 
}
</script>
<style scoped>
.el-input{
      padding:0 5px;
}
</style>
