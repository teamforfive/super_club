function getInfoList() {
    var data = {
        'userName': $("#userName").val(),
        'userPassword': $("#passWord").val(),
        'userType': false
    }

    var path = "user/signIn";
    var type = "post";

    commonAjax(null, path, data, type, show)
}

function show(obj, data) {
    location.href = "index.html"
}
