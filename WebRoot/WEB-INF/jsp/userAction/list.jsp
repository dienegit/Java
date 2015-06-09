<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>User List</title>
<style type="text/css">
table {
	border-collapse: collapse;
}

table,td,th {
	border: 1px solid black;
}
</style>
</head>

<body>
	<table border="1">
		<tr>
			<th>USER ID</th>
			<th>USERNAME</th>
			<th>ADDRESS</th>
			<th>OPERATIONS</th>
		</tr>
		<s:iterator value="#userList">
			<tr>
				<td>${id}&nbsp;</td>
				<td>${username}&nbsp;</td>
				<td>${address}&nbsp;</td>
				<td><s:a action="user_delete?id=%{id}"
						onclick="return confirm('are you sure to delete this user?')">delete</s:a>
					<s:a action="user_editUI?id=%{id}">modify</s:a></td>
			</tr>
		</s:iterator>
	</table>

	<s:a action="user_addUI">add user</s:a>
	<br /><br />
	<s:a href="javascript:history.back()">back to homepage</s:a>
</body>
</html>