<html>
    <#include "../common/header.ftl">

    <body>
        <div id="wrapper" class="toggled">
            <#-- 边栏 sidebar -->
            <#--  .. 表示返回上一级目录 我们现在在order里 上一级是 templates | 写完按command点这个文件能点代表路径通 -->
            <#include "../common/nav.ftl">

            <#--主要内容区域-->
            <div id="page-content-wrapper">
                <div class="container-fluid">
                    <div class="row clearfix">
                        <#--订单主表数据-->
                        <div class="col-md-6 column">
                            <table class="table table-bordered table-condensed">
                                <thead>
                                    <tr>
                                        <th>订单id </th>
                                        <th>订单总金额</th>
                                        <th>订单状态</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>${orderDTO.orderId} </td>
                                        <td>${orderDTO.orderAmount}</td>
                                        <td>${orderDTO.getOrderStatusEnum().message}</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <#--订单详情表数据-->
                        <div class="col-md-12 column">
                            <table class="table table-bordered">
                                <thead>
                                    <tr>
                                        <th>商品id </th>
                                        <th>商品名称</th>
                                        <th>价格</th>
                                        <th>数量</th>
                                        <th>总额</th>
                                    </tr>
                                </thead>

                                <tbody>
                                    <#list orderDTO.orderDetailList as orderdDetail>
                                        <tr>
                                            <td>${orderdDetail.productId}</td>
                                            <td>${orderdDetail.productName}</td>
                                            <td>${orderdDetail.productPrice}</td>
                                            <td>${orderdDetail.productQuantity}</td>
                                            <td>${orderdDetail.productPrice * orderdDetail.productQuantity}</td>
                                        </tr>
                                    </#list>

                                </tbody>
                            </table>
                        </div>

                        <div class="col-md-12 column">
                            <#if orderDTO.getOrderStatusEnum().message == "新订单">
                                <a href="/sell/seller/order/finish?orderId=${orderDTO.orderId}" type="button" class="btn btn-default btn-primary">完结订单</a>
                                <a href="/sell/seller/order/cancel?orderId=${orderDTO.orderId}" type="button" class="btn btn-default btn-danger">取消订单</a>
                            </#if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>

    <script>
        setTimeout('location.href="${url}"', 3000);
    </script>


</html>














