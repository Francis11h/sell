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
                    <#--加一个地址 采取post方式的提交-->
                    <form role="form" method="post" action="/sell/seller/category/save">
                        <div class="form-group">
                            <label>名称</label>
                            <input name="categoryName" type="text" class="form-control" value="${(category.categoryName)!''}"/>
                        </div>

                        <div class="form-group">
                            <label>Type</label>
                            <input name="categoryType" type="number" class="form-control" value="${(category.categoryType)!''}"/>
                        </div>

                        <input hidden type="text" name="categoryId" value="${(category.categoryId)!''}">
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>


</html>
























