
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>员工列表</title>

    <%
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>

    <%--web路径
    不以/开始的相对路径,找资源,以当前资源路径为准,经常容易出现问题
    以/开始的相对路径,找资源,以服务器的路径为标准(http://localhost"3306),需要加上项目名

    --%>
    <%--引入jquery--%>
    <script type="text/javascript" src="${APP_PATH}/static/js/jquery-1.7.2.min.js"></script>
    <%--引入样式--%>
    <link href="${APP_PATH}/static/bootstrap-3.4.1-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="${APP_PATH}/static/bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        //1.页面加载完成以后,直接去发送一个ajax请求,到分页数据


        $(function () {
            $.ajax({
                url:"${APP_PATH}/emps",
                data:"pn=1",
                type:"GET",
                success:function (result) {
                    // console.log(result)
                    //1.解析并显示员工数据
                    build_emps_table(result);
                    //2.解析并显示分页信息
                    build_page_info(result);
                    //3.解析显示分页条
                    build_page_nav(result);
                }
            });

        });

        function build_emps_table(result){
            var emps = result.extend.pageInfo.list;
            $.each(emps,function(index,item){
                var empIdTd = $("<td></td>").append(item.empId);
                var empNameTd = $("<td></td>").append(item.empName);
                var genderTd = $("<td></td>").append(item.gender=='M'?"男":"女");
                var emailTd =$("<td></td>").append(item.email);
                var deptNameTd =$("<td></td>").append(item.department.deptName);
                /**
                 *  <button class="btn btn-primary btn-sm">
                 <span class="glyphicon glyphicon-pencil " aria-hidden="true"></span>
                 编辑
                 </button>
                 * @type {jQuery.fn.init|jQuery|HTMLElement}
                 */
                var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm")
                    .append("<span></span>").addClass("glyphicon glyphicon-pencil ").append("编辑");

                var deleteBtn = $("<button></button>").addClass("btn btn-danger btn-sm")
                    .append("<span></span>").addClass("glyphicon glyphicon-trash").append("删除");

                var btnTd = $("<td></td>").append(editBtn).append(" ").append(deleteBtn);
                //append方法执行完成以后还是返回原来的元素
                $("<tr></tr>").append(empIdTd)
                    .append(empNameTd)
                    .append(genderTd)
                    .append(emailTd)
                    .append(deptNameTd)
                    .append(btnTd)
                    .appendTo("#emps_table tbody");
            });
        }
        //2.解析并显示分页信息
        function build_page_info(result){
            $("#page_info_area").append("当前"+ result.extend.pageInfo.pageNum+"页,总,"
                +result.extend.pageInfo.pages + "页,总"+result.extend.pageInfo.total +"条记录"
            )
        }

        //3.解析显示分页条
        function build_page_nav(result){

            alert("ul");
            var ul = $("<ul></ul>").addClass("pagination");

            var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
            var prePageLi= $("<li></li>").append($("<a></a>").append("&laquo;"));

            var nextPageLi=$("<li></li>").append($("<a></a>").append("&raquo;"));
            var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href","#"));

            //添加首页和前一页的提示
            ul.append(firstPageLi).append(prePageLi);

            $.each(result.extend.pageInfo.navigatepageNums, function (index, item) {
                var numLi = $("<li></li>").append($("<a></a>").append(item));
                ul.append(numLi);
            });

            //添加下一页和末页的提示
            ul.append(nextPageLi).append(lastPageLi);

            //把ul加入到nav
            var navEle = $("<nav></nav>").append(ul);
            navEle.appendTo("#page_nav_area");

        }
    </script>
</head>
<body>
<%--搭建页面--%>
<div class="container">
    <%--标题--%>
    <div class="row">
        <div class="col-md-12">
            <h1>SSM-CRUD</h1>
        </div>
    </div>
    <%--按钮--%>
    <div class="row">
        <div class="col-md-4 col-md-offset-8">
            <button class="btn btn-primary">新增</button>
            <button class="btn btn-danger">删除</button>
        </div>
    </div>

    <%--显示表格数据--%>
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover" id="emps_table">
                <thead>
                <tr>
                    <th>#</th>
                    <th>empName</th>
                    <th>gender</th>
                    <th>email</th>
                    <th>deptName</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>

                </tbody>
            </table>
        </div>
    </div>

    <%--显示分页信息--%>
    <div class="row">
        <%--分页文字信息--%>
        <div class="col-md-6" id="page_info_area">


        </div>
        <%--分页条信息--%>
        <div class="col-md-6" id="page_nav_area">

        </div>
    </div>
</div>

</body>
</html>
