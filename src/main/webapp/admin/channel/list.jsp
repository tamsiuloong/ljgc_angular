<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
    <base href="/ljgc/">
    <meta charset="utf-8" />
    <title>Metronic | Dashboard</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1" name="viewport" />
    <meta content="" name="description" />
    <meta content="" name="author" />

    <jsp:include page="../include/common_css.html"/>
    <jsp:include page="../include/common_js.html"/>


</head>
<!-- END HEAD -->


</head>
<!-- END HEAD -->

<body class="page-header-fixed page-sidebar-closed-hide-logo page-content-white" ng-app="myApp" ng-controller="channelCtrl">
<!-- BEGIN HEADER-->
<jsp:include page="../include/common_head.jsp"/>

<!-- END HEADER -->
<!-- BEGIN HEADER & CONTENT DIVIDER -->
<div class="clearfix"> </div>
<!-- END HEADER & CONTENT DIVIDER -->
<!-- BEGIN CONTAINER -->
<div class="page-container">
    <!-- BEGIN SIDEBAR-->
    <!-- BEGIN SIDEBAR-->
    <jsp:include page="../include/common_sidebar.jsp"/>
    <!-- END SIDEBAR -->
    <!-- BEGIN CONTENT -->
    <div class="page-content-wrapper">
        <!-- BEGIN CONTENT BODY -->
        <div class="page-content">
            <!-- BEGIN PAGE HEADER-->
            <!-- BEGIN THEME PANEL -->
            <jsp:include page="../include/common_theme.html"/>
            <!-- END THEME PANEL -->

            <!-- BEGIN PAGE BAR -->
            <div class="page-bar" >
                <ul class="page-breadcrumb">
                    <li>
                        <a href="index.jsp">首页</a>
                        <i class="fa fa-circle"></i>
                    </li>
                    <li>
                        <span>栏目管理</span>
                    </li>
                </ul>
                <div class="page-toolbar">
                    <div id="dashboard-report-range" class="pull-right tooltips btn btn-sm" data-container="body" data-placement="bottom" data-original-title="Change dashboard date range">
                        <i class="icon-calendar"></i>&nbsp;
                        <span class="thin uppercase hidden-xs"></span>&nbsp;
                        <i class="fa fa-angle-down"></i>
                    </div>
                </div>
            </div>
            <!-- END PAGE BAR -->

            <!-- BEGIN PAGE TITLE-->
            <h3 class="page-title">查看栏目
                <small>编辑栏目信息</small>
            </h3>
            <!-- END PAGE TITLE-->
            <!-- END PAGE HEADER-->
            <div class="clearfix"></div>
            <!-- BEGIN DASHBOARD STATS 1-->
            <div class="row">
                <div class="col-md-3">
                    <div class="input-group input-group-lg">
                        <input type="text" name="keyWord" class="form-control" ng-model="keyWord" placeholder="输入关键字..">
                                                    <span class="input-group-btn">
                                                        <button class="btn green" type="button" ng-click="search()">搜索</button>
                                                    </span>
                    </div>
                </div>
                <div class="col-md-9">
                    <div class="input-group input-group-lg">
                        <a href="#addModal" role="button" class="btn btn-outline btn-circle btn-sm purple"  data-toggle="modal">
                            <i class="fa fa-edit"></i> 新增 </a>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <!-- BEGIN SAMPLE TABLE PORTLET-->
                    <div class="portlet">
                        <div class="portlet-title">
                            <div class="caption">
                            </div>
                            <div class="tools">
                                <a href="javascript:;" class="collapse" data-original-title="" title=""> </a>
                                <a href="#portlet-config" data-toggle="modal" class="config" data-original-title="" title=""> </a>
                                <a href="javascript:;" class="reload" data-original-title="" title=""> </a>
                                <a href="javascript:;" class="remove" data-original-title="" title=""> </a>
                            </div>
                        </div>


                        <div class="portlet-body" >
                            <div class="table-scrollable">
                                <table class="table table-striped table-bordered table-advance table-hover">
                                    <thead>
                                    <tr>
                                        <th>
                                            <i class="fa fa-briefcase"></i> 栏目编号 </th>
                                        <th class="hidden-xs">
                                            <i class="fa fa-user"></i> 栏目名字 </th>
                                        <th><i class="fa fa-shopping-cart"></i> 操作 </th> </th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr ng-repeat="channel in list">
                                        <td class="highlight">
                                            <div class="success"></div>
                                            <a href="javascript:;"> {{channel.id}} </a>
                                        </td>
                                        <td class="hidden-xs"> {{channel.name}}</td>

                                        <td>
                                            <a href="#editModal" role="button" class="btn btn-outline btn-circle btn-sm purple" ng-click="edit(channel)" data-toggle="modal">
                                                <i class="fa fa-edit"></i> Edit </a>

                                            <a href="javascript:;" class="btn btn-outline btn-circle dark btn-sm black" ng-click="delete(channel.id)">
                                                <i class="fa fa-trash-o"></i> Delete </a>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- END SAMPLE TABLE PORTLET-->
            </div>



            <div class="row">
                <div class="col-md-12">
                    <div class="btn-group">

                        <a ng-click="goPage(1)"  type="button" class="btn btn-default">第一页</a>
                        <a ng-click="goPage(data.prePage)" type="button" class="btn btn-default">上一页</a>

                        <a ng-click="goPage(data.nextPage)" type="button" class="btn btn-default">下一页</a>
                        <a ng-click="goPage(data.totalPage)" type="button" class="btn btn-default">最后一页</a>
                        <%--ng-options="x for x in data.pageNums"--%>
                        <select class="form-control input-xsmall" ng-model="i"   ng-init="i='1'"  ng-change="goPage(i)">
                            <%--<option value="" class="" selected="selected">1</option>--%>
                            <option ng-repeat="i in data.pageNums"  value="{{i}}">{{i}}</option>
                        </select>
                    </div>
                </div>
            </div>

            <!-- END DASHBOARD STATS 1-->

        </div>
        <!-- END CONTENT BODY -->
    </div>
    <!-- END CONTENT -->
    <!-- BEGIN QUICK SIDEBAR -->
    <jsp:include page="../include/common_quick_sidebar.jsp"/>
    <!-- END QUICK SIDEBAR -->
</div>
<!-- END CONTAINER -->
<!-- BEGIN FOOTER -->

<jsp:include page="../include/common_footer.html"/>
<jsp:include page="../include/common_resouces.html"/>
<script src="http://cdn.static.runoob.com/libs/angular.js/1.4.6/angular.min.js"></script>


<!-- END FOOTER -->
<!-- END THEME LAYOUT SCRIPTS -->


<!-- 添加 Modal -->
<div id="addModal" class="modal fade" tabindex="-2" role="dialog" aria-labelledby="myModalLabel1" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                <h4 class="modal-title">新增栏目</h4>
            </div>
            <div class="modal-body">
                <form role="form" class="form-horizontal">
                    <div class="form-body">
                        <div class="form-group">
                            <label class="col-md-4 control-label">栏目名字</label>
                            <div class="col-md-8">
                                <div class="input-icon right">
                                    <i class="fa fa-info-circle tooltips" data-original-title="Email address" data-container="body"></i>
                                    <input type="text" ng-model="name" class="form-control"> <input type="hidden" ng-model="id" > </div>
                            </div>
                        </div>
                        <div class="form-group has-success">
                            <label class="col-md-4 control-label">栏目描述</label>
                            <div class="col-md-8">
                                <div class="input-icon right">
                                    <i class="fa fa-check tooltips" data-original-title="You look OK!" data-container="body"></i>
                                    <input type="text"ng-model="description" class="form-control"> </div>
                            </div>
                        </div>

                    </div>
                    <div class="form-actions">
                        <div class="row">
                            <div class="col-md-offset-4 col-md-8">
                                <button type="submit" class="btn blue" ng-click="add()">新增</button>
                                <button type="button" class="btn default" data-dismiss="modal" aria-hidden="true">取消</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <%--<div class="modal-footer">--%>
            <%--<button class="btn default" data-dismiss="modal" aria-hidden="true">Close</button>--%>
            <%--<button class="btn yellow">Save</button>--%>
            <%--</div>--%>
        </div>
    </div>

</div>
<!-- 编辑 Modal -->
<div id="editModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel1" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                <h4 class="modal-title">编辑栏目</h4>
            </div>
            <div class="modal-body">
                <form role="form" class="form-horizontal">
                    <div class="form-body">
                        <div class="form-group">
                            <label class="col-md-4 control-label">栏目名字</label>
                            <div class="col-md-8">
                                <div class="input-icon right">
                                    <i class="fa fa-info-circle tooltips" data-original-title="Email address" data-container="body"></i>
                                    <input type="text" ng-model="name" class="form-control"> <input type="hidden" ng-model="id" > </div>
                            </div>
                        </div>
                        <div class="form-group has-success">
                            <label class="col-md-4 control-label">栏目描述</label>
                            <div class="col-md-8">
                                <div class="input-icon right">
                                    <i class="fa fa-check tooltips" data-original-title="You look OK!" data-container="body"></i>
                                    <input type="text"ng-model="description" class="form-control"> </div>
                            </div>
                        </div>

                    </div>
                    <div class="form-actions">
                        <div class="row">
                            <div class="col-md-offset-4 col-md-8">
                                <button type="submit" class="btn blue" ng-click="update()">保存</button>
                                <button type="button" class="btn default" data-dismiss="modal" aria-hidden="true">取消</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <%--<div class="modal-footer">--%>
            <%--<button class="btn default" data-dismiss="modal" aria-hidden="true">Close</button>--%>
            <%--<button class="btn yellow">Save</button>--%>
            <%--</div>--%>
        </div>
    </div>
</div>
<script src="js/channel.js" type="text/javascript"></script>
</body>

</html>