<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show Vote</title>
</head>
<body>

	<s:iterator value="#request.voteResultList" var="voteResult">
		<tr>
			<td><div>${voteResult.vote.voteID }</div></td>
			<td><div>${voteResult.vote.voteName }</div></td>
			<s:subset source="#voteResult.votesOptions" var="subvoteOptions"></s:subset>
			<s:iterator value="#attr.subvoteOptions" var="option">
				<td><div>${option.voteOptionName }</div></td>
			</s:iterator>
			<td><div><span><img src="images/010.png" height="10" width="10"/></span><span>[</span><a href="deleteVote.action?voteID=${voteResult.vote.voteID }" >delete</a><span class="STYLE1">]</span></div></td>
		</tr>
	</s:iterator>
	
</body>
</html>