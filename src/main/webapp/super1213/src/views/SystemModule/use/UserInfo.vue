<template>
  <div class="app-container">
    <div class="demo-input-size">
      <el-input class="inputiner" placeholder="请输入内容" clearable size="mini">
        <i slot="prefix" class="el-input__icon el-icon-search"></i>
      </el-input>
      <el-button type="primary" icon="el-icon-search" class="us_button" @click="checkUser">搜索</el-button>
      <el-button type="primary" icon="el-icon-plus" class="us_button" @click="CreateUser">添加</el-button>

      <el-dialog :title="dialogTitle" :visible.sync="dialogFormVisible">
        <el-form :model="form" ref="UserForm" :rules="rules" style="width: 100%">
          <el-form-item label="用户名" :label-width="formLabelWidth" prop="User_Name">
            <el-input v-model="form.User_Name" v-if="dialogTitle==='添加用户信息'"  autocomplete="off"></el-input>
            <el-input v-model="form.User_Name" v-else :disabled="true" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="身份证号" :label-width="formLabelWidth" prop="Id_No">
            <el-input v-model="form.Id_No" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="姓名" :label-width="formLabelWidth" prop="Ture_Name">
            <el-input v-model="form.Ture_Name" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="性别" :label-width="formLabelWidth">
            <el-select v-model="form.Sex_Code" @change="slectChange" placeholder="请选择">
              <el-option
                v-for="item in this.Sexlist"
                :key="item.Sex_Code"
                :label="item.Sex_Name"
                :value="item.Sex_Code"
              ></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="联系电话" :label-width="formLabelWidth">
            <el-input v-model="form.Tel_No" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="出生日期" :label-width="formLabelWidth">
            <el-date-picker
              SelectionMode="None"
              v-model="form.Birth_Date"
              type="date"
              value-format="yyyy-MM-dd"
              placeholder="选择日期"
            ></el-date-picker>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
           <el-switch
            class="el-row3"
            v-model="form.Is_Enable"
            active-color="#13ce66"
            inactive-color="#ff4949"
          ></el-switch>
          <label v-if="form.Is_Enable===true">已启用</label>
          <label v-else>已禁用</label>
          <el-button @click="dialogFormVisible = false">取 消</el-button>
          <el-button type="primary" @click="dialogTitle==='添加用户信息'?CreateDate():UpdateDate('修改')">提 交</el-button>
        </div>
      </el-dialog>
    </div>
    <el-table
      class="main"
      v-loading="listLoading"
      :data="list"
      show-overflow-tooltip="true"
      element-loading-text="Loading"
      border
    >
      <el-table-column align="center" label="序号" width="95">
        <template slot-scope="scope">{{ scope.$index }}</template>
      </el-table-column>
      <el-table-column label="用户名" width="120">
        <template slot-scope="scope">{{ scope.row.User_Name }}</template>
      </el-table-column>
      <el-table-column label="身份证号" width="120" align="center">
        <template slot-scope="scope">
          <span>{{ scope.row.Id_No }}</span>
        </template>
      </el-table-column>
      <el-table-column label="姓名" width="120" align="center">
        <template slot-scope="scope">{{ scope.row.Ture_Name }}</template>
      </el-table-column>
      <el-table-column class-name="status-col" label="性别" width="70" align="center">
        <template slot-scope="scope">
            <el-tag v-if="scope.row.Sex_Name ==='男'">{{ scope.row.Sex_Name }}</el-tag>
         <el-tag type="danger" v-else-if="scope.row.Sex_Name ==='女'" >{{ scope.row.Sex_Name }}</el-tag>
          <el-tag type="info" v-else>{{ scope.row.Sex_Name }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="联系电话" width="120" align="center">
        <template slot-scope="scope">{{ scope.row.Tel_No }}</template>
      </el-table-column>
      <el-table-column label="出生日期" width="120" align="center" prop="Birth_Date">
        <template slot-scope="scope">{{ scope.row.Birth_Date }}</template>
      </el-table-column>
      <el-table-column label="最后登录时间" width="120" align="center">
        <template slot-scope="scope">{{ scope.row.Last_login_date }}</template>
      </el-table-column>
      <el-table-column class-name="status-col" label="是否可用" width="120" align="center">
        <template slot-scope="scope">
         <el-tag type="success" v-if="scope.row.Is_Enable ===1">已启用</el-tag>
         <el-tag type="danger" v-else >已禁用</el-tag>
        </template>
      </el-table-column>
      <el-table-column class-name="status-col" label="创建者" width="120" align="center">
        <template slot-scope="scope">
          <el-tag :type="scope.row.status | statusFilter">{{ scope.row.Creater }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column align="center" prop="created_at" label="创建者时间" width="120">
        <template slot-scope="scope">
          <i class="el-icon-time"/>
          <span>{{ scope.row.display_time }}</span>
        </template>
      </el-table-column>
      <el-table-column class-name="status-col" label="最后修改者" width="120" align="center">
        <template slot-scope="scope">
          <el-tag :type="scope.row.status | statusFilter">{{ scope.row.Modifier }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column align="center" prop="created_at" label="最后修改时间" width="120">
        <template slot-scope="scope">
          <i class="el-icon-time"/>
          <span>{{ scope.row.Last_Update_Dtime }}</span>
        </template>
      </el-table-column>
      <el-table-column align="center" label="操作" width="320">
        <template slot-scope="{ row }">
          <el-row :gutter="10">
            <el-button class="el-row1" size="mini" type="primary">查看</el-button>
            <el-button size="mini" @click="updateUser(row)" type="success">编辑</el-button>
            <el-button class="el-row2" @click="delect(row)" size="mini" type="danger">删除</el-button>
          </el-row>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      background
      layout="prev, pager, next"
      :page-size = EachPage
      @current-change ="nextPage"
      :total= total>
</el-pagination>
  </div>
</template>

// <script>
// import {
//   getSex,
//   add,
//   update,
//   GetUser,
//   GetUsersList
// } from "@/api/UserManager/UserManager";

// export default {
//   filters: {
//     statusFilter(status) {
//       const statusMap = {
//         published: "success",
//         draft: "gray",
//         deleted: "danger"
//       };
//       return statusMap[status];
//     }
//   },
//   data() {
//     const validateRequire = (rule, value, callback) => {
//       if (value === "") {
//         this.$message({
//           message: rule.field + "为必传项",
//           type: "error"
//         });
//         callback(new Error(rule.field + "为必传项"));
//       } else {
//         callback();
//       }
//     };

//     return {
//       data: "",
//       dialogFormVisible: false,
//       form: {
//         User_Name: "",
//         Id_No: "",
//         Ture_Name: "",
//         Spell: "",
//         Sex_Code: 1,
//         Birth_Date: "",
//         Tel_No: "",
//         Is_Enable: true,
//         Is_Delete: false
//       },
//       formLabelWidth: "120px",
//       list: null,
//       listLoading: true,
//       value: "",
//       dialogTitle: "",
//       Sexlist: null,
//       nama: "gs321",
//       total: 0,
//       EachPage: 2,
//       pageIndex: 1,
//       rules: {
//         User_Name: [
//           { required: true, message: "用户名称必填！", trigger: "blur" }
//         ],
//         Id_No: [{ required: true, message: "身份证必填！", trigger: "blur" }],
//         Ture_Name: [{ required: true, message: "姓名必填！", trigger: "blur" }]
//       }
//     };
//   },
//   created() {
//     this.fetchSexData();
//     this.fetchData();
//   },
//   methods: {
//     //创建用户
//     CreateDate() {
//       this.$refs.UserForm.validate(valid => {
//         if (valid) {
//           this.listLoading = true;
//           add(this.form)
//             .then(response => {
//               this.dialogFormVisible = false;
//               this.listLoading = false;
//               this.fetchData();
//             })
//             .catch(err => {
//               this.listLoading = false;
//               this.$message.error('添加用户失败');
//             });
//         }
//       });
//     },
//     //修改用户
//     UpdateDate(tyep) {
//       console.log(`执行了删除操作1.2` + tyep);
//       this.$refs.UserForm.validate(valid => {
//         if (valid) {
//           this.listLoading = true;
//           update(this.form)
//             .then(response => {
//                console.log(`执行了删除操作2`);
//               if(tyep==="删除"){
//                  this.$message.success(tyep+'用户成功');
//               }
//               this.dialogFormVisible = false;
//               this.listLoading = false;
//               this.fetchData();
//             })
//             .catch(err => {
//                console.log(`执行了删除操作3`);
//               this.listLoading = false;
//               this.$message.error(tyep+'用户失败');
//             });
//         }
//       });
//     },
//     //获取性别字典
//     fetchSexData() {
//       this.listLoading = true;
//       getSex().then(response => {
       
//         this.Sexlist = response.data.Items;
//         this.listLoading = false;
//       });
//     },
//     //获取用户信息
//     fetchUserData(nama) {
//       this.listLoading = true;
//       GetUser(nama).then(response => {
//         console.log(response.data);
//         this.form = response.data;
//         this.listLoading = false;
//       }).catch(err =>{
//          console.log(`执行了删除操作1.3` );
//       });
//     },
//     //刷新下拉选项
//     slectChange() {
//       this.$forceUpdate();
//     },
//     //搜索
//     checkUser() {
//       this.GetUsersList(this.pageIndex);

//     },
//     //获取用户列表分页
//     GetUsersList(val) {
//       this.listLoading = true;
//       console.log(1);
//       GetUsersList("", "", this.EachPage , val).then(response => {
//         console.log(response.data);
//         this.list = response.data.Items;
//         this.total = response.data.TotalCount;
//         this.listLoading = false;
//       });
//     },
//     //添加按钮
//     CreateUser() {
//       this.form ={};
//       this.form.Is_Enable = true;
//       this.form.Is_Delete = false;
//       (this.dialogFormVisible = true), (this.dialogTitle = "添加用户信息");
//     },
//     updateUser(row) {
//         this.form ={};
//         this.form.Is_Delete = false;
//        (this.dialogFormVisible = true), (this.dialogTitle = "修改用户信息");
//         this.fetchUserData(row.User_Name)
     
//     },
//     fetchData(){
//         this.GetUsersList(this.pageIndex);
//     },
//     nextPage(val){
//       this.GetUsersList(val);
//       console.log(`当前页: ${val}`);
//     },
// delect(row){
//     this.$confirm('此操作将删除该用户, 是否继续?', '提示', {
//           confirmButtonText: '确定',
//           cancelButtonText: '取消',
//           type: 'warning'
//         }).then(() => {
//           this.fetchUserData(row.User_Name);
//           console.log(`执行了删除操作1`);
//           this.form.Is_Delete = true;
//           this.UpdateDate("删除");
         
//           this.$message({
//             type: 'success',
//             message: '删除成功!'
//               });
//         }).catch(() => {
//           this.$message({
//             type: 'info',
//             message: '已取消删除'
//           });          
//         });
// }

//   }
// };
// </script>
<style scoped>
.el-input {
  width: 150px;
}
.main {
  width: calc(100% - 500px);
  height: 100%;
  padding: 20px;
}
.el-row {
  margin-bottom: 10px;
}
.el-row1 {
  margin-right: 10px;
}
.us_button {
  margin-left: 10px;
  margin-bottom: 20px;
}
.inputiner {
  width: 200px;
}
</style>
