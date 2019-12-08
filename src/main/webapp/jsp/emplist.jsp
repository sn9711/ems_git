<%--
  Created by IntelliJ IDEA.
  User: sn
  Date: 2019/12/8
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta content="ie=edge">
    <title>emp</title>
    <!--引入jqgrid的bootstrap css-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jqgrid/css/trirand/ui.jqgrid-bootstrap.css">
    <!--引入jquery核心js-->
    <script src="${pageContext.request.contextPath}/jqgrid/js/jquery-3.4.1.min.js"></script>
    <!--引入jqgrid核心js-->
    <script src="${pageContext.request.contextPath}/jqgrid/js/trirand/jquery.jqGrid.min.js"></script>
    <!--引入jqgrid国际化js-->
    <script src="${pageContext.request.contextPath}/jqgrid/js/trirand/i18n/grid.locale-cn.js"></script>
    <!--引入bootstrap组件js-->
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
    <!--引入bootstrap css-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">

    <script>
        $(function () {
            $("#eList").jqGrid({
                url: "${pageContext.request.contextPath}/emp/showAll",
                datatype: "json",
                mtype: "post",
                height: 450,
                colNames: ['ID', '名字', '工资', '年龄', '生日'],
                colModel: [
                    {name: 'id', hidden: true},
                    {name: 'name', align: "center", editable: true, editrules: {required: true}},
                    {name: 'salary', align: "center", editable: true, editrules: {required: true}},
                    {name: 'age', align: "center", editable: true, editrules: {required: true}},
                    {name: 'bir', align: "center", editable: true, edittype: "date", editrules: {required: true}},
                ],
                rowNum: 10,
                rowList: [10, 20],
                pager: '#pager',
                viewrecords: true,
                styleUI: "Bootstrap",
                autowidth: true,
                multiselect: false,
                caption: "员工列表",//表格标题
                editurl: "${pageContext.request.contextPath}/emp/edit",

            }).navGrid(
                "#pager",
                    /*主表格编辑框*/
                {edit: true, add: true, del: true, search: false, refresh: true},
                {
                    closeAfterEdit: true,
                    beforeShowForm: function (frm) {
                        frm.find("#age").attr("disabled", true);
                        frm.find("#bir").attr("disabled", true);
                    },
                },
                {closeAfterAdd: true,},
                {closeAfterDel: true,}
            )
        });
    </script>

</head>
<body>
<table id="eList"></table>

<div id="pager" style="height: 50px;"></div>
</body>
</html>
