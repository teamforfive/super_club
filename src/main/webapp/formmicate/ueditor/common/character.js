var data = {
    "userType": "1"
}

$(getInfoList())

function getInfoList() {
    var path = "role/getRoleList";
    var type = "post";

    commonAjax(null, path, data, type, show)
}

function show(obj, data) {
    var str = "";
    data = data.item.roleList;
    for (var i = 0; i < data.length; i++) {
        console.log(data);
        str += "<tr>   <td class=\"tc\">" +
            "<input name=\"id[]\" value=\"59\" type=\"checkbox\"></td>\n" +
            "                            <td>\n" +
            "                                <input name=\"ids[]\" value=\"59\" type=\"hidden\">\n" +
            "                                <input class=\"common-input sort-input\" name=\"ord[]\" value=\"0\" type=\"text\">\n" +
            "                            </td>\n" +
            "                            <td>" + data[i].uuId + "</td>\n" +
            "                            <td>" + data[i].roleName + "</td>\n" +
            "                            <td>" + data[i].roleComment + "</td>\n" +
            "                            <td>" + data[i].updateTime + "</td>\n" +
            "                            <td>\n" +
            "                                <a class=\"link-update\" href=\"#\">修改</a>\n" +
            "                                <a class=\"link-del\" href=\"#\">删除</a>\n" +
            "                            </td></tr>";
    }
    $(".infoList").empty();
    $(".infoList").replaceWith(str);

}
