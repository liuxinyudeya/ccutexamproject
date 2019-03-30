<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<meta charset="utf-8">
	<title>添加学院</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="../../layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="../../css/public.css" media="all" />
</head>
<body class="childrenBody">
<form class="layui-form" style="width:80%;">
	<div class="layui-form-item layui-row layui-col-xs12">
		<label class="layui-form-label">选择年级</label>
		<div class="layui-input-block">
			<select name="grade" class="grade" lay-filter="grade">
				<option value="2015">2015级</option>
				<option value="2016">2016级</option>
				<option value="2017">2017级</option>
				<option value="2018">2018级</option>
			</select>
		</div>
	</div>

	<div class="layui-form-item layui-row layui-col-xs12">
		<label class="layui-form-label">学院名</label>
		<div class="layui-input-block">
			<input type="text" class="layui-input academyName" lay-verify="required" placeholder="请输入学院名">
		</div>
	</div>

	<div class="layui-form-item layui-row layui-col-xs12">
		<label class="layui-form-label">学院编号</label>
		<div class="layui-input-block">
			<input type="text" class="layui-input academyCode" lay-verify="required" placeholder="请输入学院编号">
		</div>
	</div>

	<div class="layui-form-item layui-row layui-col-xs12">
		<label class="layui-form-label">是否禁用</label>
		<div class="layui-input-block">
			<select name="isdelete" class="isdelete" lay-filter="isdelete">
				<option value="0">启用</option>
				<option value="1">禁用</option>

			</select>
		</div>
	</div>



	<div class="layui-form-item layui-row layui-col-xs12">
		<label class="layui-form-label">描述</label>
		<div class="layui-input-block">
			<textarea placeholder="学院备注(非必填...)" class="layui-textarea description"></textarea>
		</div>
	</div>
	<div class="layui-form-item layui-row layui-col-xs12">
		<div class="layui-input-block">
			<button class="layui-btn layui-btn-sm" lay-submit="" lay-filter="addUser">添加</button>
			<button type="reset" class="layui-btn layui-btn-sm layui-btn-primary">取消</button>
		</div>
	</div>
</form>
<script type="text/javascript" src="../../layui/layui.js"></script>
<script type="text/javascript" src="academyAdd.js"></script>
<script type="text/javascript" src="../../js/rootpath.js"></script>
</body>
</html>