<template>
  <div class="">
    <div class="demo-input-size">
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
      <el-table-column align="center"   label="序号" width="120" fixed>
        <template slot-scope="scope">
          {{ scope.$index }}
        </template>
      </el-table-column>
      <el-table-column align="center"   label="社团名称" width="120" fixed>
        <template slot-scope="scope">
          {{ scope.row.clubsName}}
        </template>
      </el-table-column>
       <el-table-column align="center"   label="社团级别" width="120" >
        <template slot-scope="scope">
          {{ scope.row.clubCreateId}}
        </template>
      </el-table-column>
       <el-table-column align="center"   label="社团编码" width="120" >
        <template slot-scope="scope">
          {{ scope.row.clubCode }}
        </template>
      </el-table-column>
      <el-table-column align="center"   label="简介" width="120" >
        <template slot-scope="scope">
          {{ scope.row.clubTel }}
        </template>
      </el-table-column>
      <el-table-column align="center"   label="地址" width="120" >
        <template slot-scope="scope">
          {{ scope.row.clubTel }}
        </template>
      </el-table-column>

       <el-table-column align="center"   label="社团联系方式" width="120" >
        <template slot-scope="scope">
          {{ scope.row.clubTel }}
        </template>
      </el-table-column>
      <el-table-column align="center"   label="创始人id" width="120" >
        <template slot-scope="scope">
          {{ scope.row.clubTel }}
        </template>
      </el-table-column>

      <el-table-column align="center"   label="创建id" width="120" >
        <template slot-scope="scope">
          {{ scope.row.clubTel }}
        </template>
      </el-table-column>

      <el-table-column align="center" prop="created_at" label="创建时间" width="120">
        <template slot-scope="scope">
            <span>{{ scope.row.createTime }}</span>
        </template>
      </el-table-column>
     
        <el-table-column fixed="right" align="center" label="操作" width="170">
      <template slot-scope="scope">
        <el-button size="mini" @click="handleEdit(scope)">编辑</el-button>
        <el-button size="mini" type="danger" @click="handleDelete(scope)">删除</el-button>
      </template>
    </el-table-column>
    </el-table>
    </div>
      <el-dialog :visible.sync="Eitdialog" :title="dialogType==='yes'?'添加科室信息':'编辑科室信息'">
      <el-form label-width="140px" label-position="left" ref="form" :model="form" :rules="rules">

        <el-form-item label="社团名称" prop="clubsName">
          <el-input  v-model="form.clubsName" ></el-input>
        </el-form-item>
        
        <el-form-item label="手机号码" prop="clubTel">
          <el-input  v-model="form.clubTel" ></el-input>
        </el-form-item>
        
        <el-form-item label="社团简介" prop="clubProfile">
          <el-input  v-model="form.clubProfile" ></el-input>
        </el-form-item>

        <el-form-item label="社团地址" prop="clubLocation">
          <el-input  v-model="form.clubLocation" ></el-input>
        </el-form-item>

        <el-form-item label="社团级别" prop="region">
          <el-select v-model="form.levelId" placeholder="请选择">
             <el-option
                v-for="item in goption"
                :key="item.value"
                :label="item.label"
                :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>

        <el-upload
          class="avatar-uploader"
          action="http://192.168.1.100:8081/SuperClub/clubs/file/upload"
          :show-file-list="false"
          :on-success="handleAvatarSuccess"
          :before-upload="beforeAvatarUpload">
          <img v-if="imageUrl" :src="imageUrl" class="avatar">
          <i v-else class="el-icon-plus avatar-uploader-icon"></i>
      </el-upload>

      </el-form>  
      <div style="text-align:right;">
        <el-button type="danger" @click="Eitdialog=false">Cancel</el-button>
        <el-button type="primary" @click="dialogType==='yes'?adddata():UpdateDate()">Confirm</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { getList,getGrade,addList,UdList,DelList,addimg} from '@/api/DataDictionary/club'
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
      fits: ['fill', 'contain', 'cover', 'none', 'scale-down'],
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
            clubsName:'',
            clubProfile:"",
            clubLocation:"",
            clubTel:"",
            levelId:"",
            // lgLevelid:'',
            clubLogo:'',
        },
    
      formLabelWidth: '120px',
      list: [],
      listLoading: true,
      value:'',
       rules: {
        County_Name: [{ required: true, message: '市名称必填！', trigger: 'blur' }],
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
       this.list=response.item.data;
        this.listLoading = false
      })
    },

    // 复制到数组读取
    regrade(){
        var _this=this;
        this.goption=[];
        this.grade.some((item,i)=>{
                for(var i in item )
                {
                     var grade={label:item[i].clName,value:item[i].uuId};
                     _this.goption.push(grade);
                }
           })
      },
    // 获取社团级别
    GetGra(){

      this.grade=[];
      this.listLoading = true;
      getGrade().then(response => {

      // console.log(response.item.data);
      this.grade.push(response.item.data);
      this.regrade();
           console.log(this.goption);
      this.listLoading = false;
          }).catch(function (error) {
            console.log(error);
      });
    },
    adddata(){
      this.dialogFormVisible=false;
      this.listLoading = true
      var formData = new window.FormData();
      //  var files = document.getElementById("img").files[0];
      //  console.log(files);
      
   
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
          var newlist =row.uuId;
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
      this.imageUrl=this.form.clubLogo;
    },
    clearform(){

      this.form.clubsName='',
      this.form.clubProfile='';
      this.form.clubLocation='';
      this.form.clubTel='';
    },
    handleAdd() {
    
      this.clearform();
      delete this.form.uuId;
      this.GetGra();
      this.dialogType = 'yes';
      console.log( this.form);
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
          if(this.optionValue=="County_Name")
          {
              if(item.County_Name.includes(search))
              {
                return item;
              }
              }else if(this.optionValue=="County_Code"){
                 var Snumber=item.County_Code.toString();
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
  },
  // 图片加载
  handleAvatarSuccess(res, file) {
        
      this.imageUrl = URL.createObjectURL(file.raw);
      this.form.clubLogo=res.item.clubLogo;
      console.log(this.form.clubLogo);
      
      },
  beforeAvatarUpload(file) {

        const isJPG = file.type === 'image/jpeg';
        const isLt2M = file.size / 1024 / 1024 < 2;

        if (!isJPG) {
          this.$message.error('上传头像图片只能是 JPG 格式!');
        }
        if (!isLt2M) {
          this.$message.error('上传头像图片大小不能超过 2MB!');
        }
        return isJPG && isLt2M;

      }
  // 图片加载结束
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
