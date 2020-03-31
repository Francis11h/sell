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
                                        <th>商品id </th>
                                        <th>名称</th>
                                        <th>图片</th>
                                        <th>单价</th>
                                        <th>库存</th>
                                        <th>描述</th>
                                        <th>类目</th>
                                        <th>创建时间</th>
                                        <th>修改时间</th>
                                        <th colspan="2">操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <#--   #list  标签    -->
                                    <#-- content 返回的就是一个list -->
                                    <#list productInfoPage.content as productInfo>
                                        <tr>
                                            <td>${productInfo.productId}</td>
                                            <td>${productInfo.productName}</td>
                                            <#--图片的标签 跳转 并设置宽高-->
                                            <td><img height="100" width="100" src="${productInfo.productIcon}" alt=""></td>
                                            <td>${productInfo.productPrice}</td>
                                            <td>${productInfo.productStock}</td>
                                            <td>${productInfo.productDescription}</td>
                                            <td>${productInfo.categoryType}</td>
                                            <td>${productInfo.createTime}</td>
                                            <td>${productInfo.updateTime}</td>

                                            <td>
                                                <a href="/sell/seller/product/index?productId=${productInfo.productId}">修改</a>
                                            </td>

                                            <td>
                                                <#if productInfo.getProductStatusEnum().message == "在架">
                                                    <a href="/sell/seller/product/off_sale?productId=${productInfo.productId}">下架</a>
                                                <#else>
                                                    <a href="/sell/seller/product/on_sale?productId=${productInfo.productId}">上架</a>
                                                </#if>
                                            </td>
                                        </tr>
                                    </#list>
                                </tbody>
                            </table>
                        </div>

                        <#--分页-->
                        <div class="col-md-12 column">
                            <ul class="pagination pull-right">
                            <#--上一页   lte小于等于 总数-->
                        <#if currentPage lte 1>
                            <li class="disabled"><a href="#">上一页</a></li>
                        <#else>
                            <li><a href="/sell/seller/product/list?page=${currentPage - 1}&size=${size}">上一页</a></li>
                        </#if>

                            <#-- 1 到 总数 并写入样式-->
                        <#list 1..productInfoPage.getTotalPages() as index>
                            <#if currentPage == index>
                            <#--如果是当前页 底下对应的要灰掉-->
                                <li class="disabled"><a href="#">${index}</a></li>
                            <#else>
                                <li><a href="/sell/seller/product/list?page=${index}&size=${size}">${index}</a></li>
                            </#if>
                        </#list>
                            <#--下一页   gte大于等于 总数   -->
                        <#if currentPage gte productInfoPage.getTotalPages()>
                            <li class="disabled"><a href="#">下一页</a></li>
                        <#else>
                            <li><a href="/sell/seller/product/list?page=${currentPage + 1}&size=${size}">下一页</a></li>
                        </#if>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </body>


</html>
























