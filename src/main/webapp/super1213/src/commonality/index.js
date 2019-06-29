exports.install = function (Vue, options) {
    Vue.prototype.closeDialog = function (Eitdialog, formName) {
        Eitdialog=false;
      
        //  关闭表单数据重置
        this.$refs[formName].resetFields()
    };
};