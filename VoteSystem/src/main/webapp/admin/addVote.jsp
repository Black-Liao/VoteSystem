<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Vote</title>

<script type="text/javascript" language="javascript">
	var i = 4;
	function addVoteOption(){
		
		var votep = document.getElementById("voteOptionList");
		var inputText = document.createTextNode("选项" + (i++) + "名称：");
		votep.appendChild(inputText);
		var inputp = document.createElement("input");
		inputp.type = "text";
		inputp.name = "voteOption";
		votep.appendChild(inputp);
		var brP = document.createElement("br");
		votep.appendChild(brP);
		
		
	}
</script>

</head>
<body>

	<form action="addVoteAction" method="post" name="addForm">
		选择投票频道 <select name="channel">
			<option value="1">NBA</option>
			<option value="2">CBA</option>
			<option value="3">足球世界杯</option>
			<option value="4">中超</option>
			<option value="5">英超</option>
			<option value="6">F1</option>
		</select><br />
		
		请输入投票名称：<input type="text" name="voteName" /><br />
		<div id="voteOptionList">
			选项1名称<input type="text" name="voteOption"> <br />
			选项2名称<input type="text" name="voteOption"> <br />
			选项3名称<input type="text" name="voteOption"> <br />
<!-- 			选项4名称<input type="text" name="voteOption"> <br /> -->
		</div>
		
		<input type="button" value="新增投票选项" onclick="addVoteOption()">
		<input type="submit" value="发布" />
		<input type="reset" value="重置" />
		
	</form>

</body>
</html>