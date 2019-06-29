// var data = JSON.stringify({
//     'invitationContent': invitationContent,
//     'invitationTitle': invitationTitle,
//     'invitationAccess': invitationAccess,
//     'createTime': createTime,
// })

function getInfoList() {
    var path = "invitation/getList";
    var type = "post";

    commonAjax(null, path, null, type, show)
}

function show(obj, data) {
    var str = "";
    data = data.item.item;
    for (var i = 0; i < data.length; i++) {
        console.log(data);
        str += "<tr>\n" +
            "                            <td class=\"tc\"><input name=\"id[]\" value=\"58\" type=\"checkbox\"></td>\n" +
            "                            <td>\n" +
            "                                <input name=\"ids[]\" value=\"58\" type=\"hidden\">\n" +
            "                                <input class=\"common-input sort-input\" name=\"ord[]\" value=\"0\" type=\"text\">\n" +
            "                            </td>\n" +
            "                            <td>58</td>\n" +
            "                            <td title=\"\"><a class='InvitationTitle' target=\"_blank\" href=\"#\" title=\"\">"+data[i].invitationTitle+"</a> …\n" +
            "                            </td>\n" +
            "                            <td>0</td>\n" +
            "                            <td class='accase'> "+data[i].invitationAccess+"</td>\n" +
            "                            <td class='authorName'>" + data[i].invitationAuthorId + "</td>\n" +
            "                            <td class='time'>"+ data[i].updateTime+"</td>\n" +
            "                            <td></td>\n" +
            "                            <td>\n" +
            "                                <a class=\"link-update\" href=\"#\">修改</a>\n" +
            "                                <a class=\"link-del\" href=\"#\" class=\"del\">删除</a>\n" +
            "                            </td>\n" +
            "                        </tr>";
    }
    $(".infoList").empty();
    $(".infoList").replaceWith(str);

}
