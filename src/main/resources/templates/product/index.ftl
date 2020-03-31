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
                    <form role="form" method="post" action="/sell/seller/product/save">
                        <div class="form-group">
                            <label>名称</label>
                            <#--新建和修改两用的 所以要是传进来了个 productId 要显示名字 所以设置个 value-->
                            <#--对象的默认值为空 加个括号要-->
                            <input name="productName" type="text" class="form-control" value="${(productInfo.productId)!''}"/>
                        </div>

                        <div class="form-group">
                            <label>价格</label>
                            <input name="productPrice" type="text" class="form-control" value="${(productInfo.productPrice)!''}"/>
                        </div>

                        <div class="form-group">
                            <label>库存</label>
                            <input name="productStock" type="number" class="form-control" value="${(productInfo.productStock)!''}"/>
                        </div>

                        <div class="form-group">
                            <label>描述</label>
                            <input name="productDescription" type="text" class="form-control" value="${(productInfo.productDescription)!''}"/>
                        </div>

                        <div class="form-group">
                            <label>图片</label>
                            <#--把图片展示出来-->
                            <img height="100" width="100" src="${(productInfo.productIcon)!''}" alt="">
                            <input name="productIcon" type="text" class="form-control" value="${(productInfo.productIcon)!''}"/>
                        </div>

                        <div class="form-group">
                            <label>类目</label>
                            <#--要从DB里面拿出来-->
                            <select name="categoryType" class="form-control">
                                <#--循环遍历数据库中类目-->
                                <#list categoryList as category>
                                    <#--前端的表单语法 提交到后端提交的是他的value值-->
                                    <option value="${category.categoryType}"
                                            <#--如果 类目存在 用 ？？ 表示 ，  并且和DB中一样 选中 这一串判断只为了加 selected这一个关键字 -->
                                            <#if (productInfo.categoryType) ?? && productInfo.categoryType == category.categoryType>
                                                selected
                                            </#if>
                                            >
                                        ${category.categoryName}
                                    </option>
                                </#list>
                            </select>
                        </div>

                        <#--加一个隐藏字段 因为传肯定要传 productId 来更新 但是不需要显示-->
                        <input hidden type="text" name="productId" value="${(productInfo.productId)!''}">


                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>


</html>
























