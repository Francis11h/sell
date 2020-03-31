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
                                        <th>订单id </th>
                                        <th>姓名</th>
                                        <th>手机号</th>
                                        <th>地址</th>
                                        <th>金额</th>
                                        <th>订单状态</th>
                                        <th>支付状态</th>
                                        <th>创建时间</th>
                                        <th colspan="2">操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <#--   #list  标签    -->
                                    <#-- content 返回的就是一个list -->
                                    <#list orderDTOPage.content as orderDTO>
                                        <tr>
                                            <td>${orderDTO.orderId}</td>
                                            <td>${orderDTO.buyerName}</td>
                                            <td>${orderDTO.buyerPhone}</td>
                                            <td>${orderDTO.buyerAddress}</td>
                                            <td>${orderDTO.orderAmount}</td>
                                            <td>${orderDTO.getOrderStatusEnum().message}</td>
                                            <td>${orderDTO.getPayStatusEnum().message}</td>
                                            <td>${orderDTO.createTime}</td>

                                            <td>
                                                <a href="/sell/seller/order/detail?orderId=${orderDTO.orderId}">详情</a>
                                            </td>

                                        <#-- 如果订单状态已取消就不再显示按钮了 判断下-->
                                            <td>
                                                <#if orderDTO.getOrderStatusEnum().message == "新订单">
                                                    <a href="/sell/seller/order/cancel?orderId=${orderDTO.orderId}">取消</a>
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
                            <li><a href="/sell/seller/order/list?page=${currentPage - 1}&size=${size}">上一页</a></li>
                        </#if>

                            <#-- 1 到 总数 并写入样式-->
                        <#list 1..orderDTOPage.getTotalPages() as index>
                            <#if currentPage == index>
                            <#--如果是当前页 底下对应的要灰掉-->
                                <li class="disabled"><a href="#">${index}</a></li>
                            <#else>
                                <li><a href="/sell/seller/order/list?page=${index}&size=${size}">${index}</a></li>
                            </#if>
                        </#list>
                            <#--下一页   gte大于等于 总数   -->
                        <#if currentPage gte orderDTOPage.getTotalPages()>
                            <li class="disabled"><a href="#">下一页</a></li>
                        <#else>
                            <li><a href="/sell/seller/order/list?page=${currentPage + 1}&size=${size}">下一页</a></li>
                        </#if>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    <#--<script>-->
        <#--var websocket = null;-->
        <#--if ('WebSocket' in window) {-->
            <#--websocket = new WebSocket('ws://');-->
        <#--} else {-->
            <#--alert('该浏览器不支持webSocket');-->
        <#--}-->

        <#--websocket.onopen = function (event) {-->
            <#--console.log('建立连接');-->
        <#--}-->

        <#--websocket.onclose = function (event) {-->
            <#--console.log('连接关闭');-->
        <#--}-->

        <#--websocket.onmessage = function (event) {-->
            <#--console.log('收到消息' + event.data);-->
            <#--//弹窗提醒，播放音乐-->

        <#--}-->
        <#--websocket.onerror = function (event) {-->
            <#--alert('websocket通信发生错误' );-->
        <#--}-->

        <#--//窗口关闭 websocket要关闭-->
        <#--window.onbeforeunload = function () {-->
            <#--websocket.close();-->
        <#--}-->

    <#--</script>-->

    </body>
</html>
























