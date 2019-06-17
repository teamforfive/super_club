<template style="width: 100%;">
  <div class="app-container">
    <div class="searchdiv">
      <el-row>
        <el-col :span="4">
          <el-select v-model="value" placeholder="请选择">
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
          <el-button type="primary" @click="handleCreate()">添加</el-button>
        </el-col>
      </el-row>
    </div>

    <div class="grid-content bg-purple-dark showdata">
      <el-table
        v-loading="listLoading"
        :data="list"
        element-loading-text="Loading"
        border
        fit
        style="width: 100%;"
        highlight-current-row
      >
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
        <el-table-column label="是否可用" width="90" align="center">
          <template slot-scope="scope">{{ scope.row.Is_Enable }}</template>
        </el-table-column>
        <el-table-column label="是否删除" width="90" align="center">
          <template slot-scope="scope">{{ scope.row.Is_Delete }}</template>
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
        <el-table-column align="center" label="操作" width="110">
          <template slot-scope="{ row }">
            <el-button size="mini" v-on:click="EditDate(row)">编辑</el-button>
            <el-button size="mini" type="danger" @click="DeleteDate(row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>

    <el-dialog :title="dialogStatus" :visible.sync="dialogFormVisible">
      <el-form ref="form" :model="form" :rules="rules">
        <el-form-item
          label="民族编码"
          :label-width="formLabelWidth"
          :hidden="dialogStatus==='添加民族字典信息'?true:false"
        >
          <el-input v-model="form.Nationality_Code" :readonly="readonly"></el-input>
        </el-form-item>
        <el-form-item label="民族名称" :label-width="formLabelWidth" prop="Nationality_Name">
          <el-input v-model="form.Nationality_Name"></el-input>
        </el-form-item>
        <el-form-item label="排序码" :label-width="formLabelWidth" prop="Sort_Id">
          <el-input v-model="form.Sort_Id"></el-input>
        </el-form-item>
        <el-form-item label="是否可用" :label-width="formLabelWidth" prop="Is_Enable">
          <el-input v-model="form.Is_Enable"></el-input>
        </el-form-item>
         <el-form-item label="是否删除" :label-width="formLabelWidth" prop="Is_Delete">
          <el-input v-model="form.Is_Delete"></el-input>
        </el-form-item>
        <el-form-item label="创建人" :label-width="formLabelWidth" prop="Creater">
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
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="dialogStatus==='添加民族字典信息'?CreateDate():UpdateDate()">提 交</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { getList, add, update } from "@/api/DataDictionary/DIC_ Nationality";

export default {
  filters: {
    statusFilter(status) {
      const statusMap = {
        published: "success",
        draft: "gray",
        deleted: "danger"
      };
      return statusMap[status];
    }
  },
  data() {
     const validateRequire = (rule, value, callback) => {
      if (value === '') {
        this.$message({
          message: rule.field + '为必传项',
          type: 'error'
        })
        callback(new Error(rule.field + '为必传项'))
      } else {
        callback()
      }
    }
    return {
      data: "",
      options: [
        {
          value: "选项1",
          label: "拼音码"
        },
        {
          value: "选项2",
          label: "五笔码"
        }
      ],
      dialogFormVisible: false,
      form: {
        Nationality_Code: "",
        Nationality_Name: "",
        Sort_Id: "",
        Is_Enable: true,
        Is_Delete: false,
        Creater:'',
        Create_date: "2019-06-04T07:14:16.540Z",
        Modifier:'',
        Last_Update_Dtime: "2019-06-04T07:14:16.540Z"
      },
      formLabelWidth: "120px",
      list: null,
      listLoading: true,
      value:"",
      search: "",
      dialogStatus: "",
      readonly: false,
      textMap: {
        update: "编辑民族字典信息",
        create: "添加民族字典信息"
      },
      rules: {
        Nationality_Name: [{ required: true, message: '民族名称必填！', trigger: 'blur' }],
        Sort_Id: [{ required: true, message: '排序码必填！', trigger: 'blur' }],
      }
    };
  },

  created() {
    this.fetchData();
  },
  methods: {
    fetchData() {
      this.listLoading = true;
      console.log(1);
      getList().then(response => {
        console.log(response.data);
        this.list = response.data.Items;
        this.listLoading = false;
      });
    },
    handleCreate() {
      this.form.Nationality_Code='0',
      this.form.Nationality_Name='',
      this.form.Sort_Id ='',
      this.dialogFormVisible = true;
      this.dialogStatus = "添加民族字典信息";
      this.readonly = false;
    },
    CreateDate() {
      this.$refs.form.validate(valid => {
        if (valid) {
          this.listLoading = true;
          add(this.form).then(response => {
            this.dialogFormVisible = false;
            this.listLoading = false;
            this.fetchData();
          });
          this.listLoading = false;
         }
     });
    },
    EditDate(row) {
      this.form = row;
      this.dialogFormVisible = true;
      this.readonly = true;
      this.dialogStatus = "编辑民族字典信息";
    },
    UpdateDate() {
      this.listLoading = true;
      update(this.form).then(response => {
        this.listLoading = false;
        this.dialogFormVisible = false;
        this.fetchData();
      });
      this.listLoading = false;
    },
    DeleteDate(row) {
      this.$confirm(
        "确认删除 《编码：" +
          row.Nationality_Code +
          " 名称：" +
          row.Nationality_Name +
          " 》吗？"
      )
        .then(_ => {
          var defrom = {
            Nationality_Code: row.Nationality_Code,
            Nationality_Name: row.Nationality_Name,
            Is_Delete: true
          };
          update(defrom).then(response => {
            this.fetchData();
          });
        })
        .catch(_ => {});
    },
    searchData() {
      var search = this.search;
      this.listLoading = true;
      getList().then(response => {
        var datalist = response.data.Items;
        if (search) {
          this.list = datalist.filter(rowdate => {
            return Object.keys(rowdate).some(key => {
              return (
                String(rowdate[key])
                  .toLowerCase()
                  .indexOf(search) > -1
              );
            });
          });
        } else {
          this.list = datalist;
        }
        this.listLoading = false;
      });
      this.listLoading = false;
    }
  }
};
</script>
<style scoped>
.el-input {
  margin: 0px 5px 0px 0px;
}
.searchdiv {
  margin: 0px 0px 5px 0px;
}
.searchbtn {
  margin-left: 5px;
}
.showdata {
  width: 100%;
}
</style>
