<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vote Page</title>
</head>
<body>
	<s:iterator value="#request.voteResults" var="result">
		<p class="style2">${result.vote.voteName }</p>
		<form action="doVote" method="post">
			<p class="style2">
				<s:iterator value="#result.votesOptions" var="voteOption">
					<input type="radio" name="voteOptionID" value="${voteOption.voteOptionID }"/>${voteOption.voteOptionName }<br />
				</s:iterator>
				<input type="radio" name="voteOptionID" value="0" />other<br />
				<input type="text" name="otherOption"/>
				<input type="hidden" name="voteID" value="${result.vote.voteID }"/>
				<input type="hidden" name="channelID" value="${result.vote.channelID }"/>
				<a href="voteResult?voteID=${result.vote.voteID }">view the vote result</a>
			</p>
			<p>
				<input type="submit" value="Submit"/>
				<input type="reset" value="Reset"/>
			</p>
		</form>
	</s:iterator>
	<s:if test="#request.voteResults.size==0">
		No Context in this page!
	</s:if>

</body>
</html>