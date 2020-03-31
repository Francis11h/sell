<#--ftl(FreeMarker Template Language)是Freemarker模板的文件后缀名-->

<#--  ${} 这个语法 拿属性-->
<html>

    <#include "../common/header.ftl">
    <body>

        <div id="wrapper" class="toggled">
            <#-- 边栏 sidebar -->
            <#--  .. 表示返回上一级目录 我们现在在order里 上一级是 templates | 写完按command点这个文件能点代表路径通 -->
            <#include "../common/nav.ftl">

            <#--主要内容区域-->
            <div id="page-content-wrapper">
                <#--fluid表示流动的意思 样式流动布局 保证 取消按钮 可以出来 -->
                <div class="container-fluid">
                    <div class="row clearfix">
                        <div class="col-md-12 column">
                            <#--表格偏大 我们设置为紧凑 condense-->
                            <table class="table table-bordered table-condensed">
                                <thead>
                                    <tr>
                                        <th>类目id </th>
                                        <th>名称</th>
                                        <th>Type</th>
                                        <th>创建时间</th>
                                        <th>修改时间</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <#--   #list  标签    -->
                                    <#--这里不需要 content-->
                                    <#list categoryList as category>
                                        <tr>
                                            <td>${category.categoryId}</td>
                                            <td>${category.categoryName}</td>
                                            <td>${category.categoryType}</td>
                                            <td>${category.createTime}</td>
                                            <td>${category.updateTime}</td>
                                            <td>
                                                <a href="/sell/seller/category/index?categoryId=${category.categoryId}">修改</a>
                                            </td>
                                        </tr>
                                    </#list>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </body>


</html>
























