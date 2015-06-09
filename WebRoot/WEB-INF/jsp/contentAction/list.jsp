<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Content List</title>
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
			<th>CONTENT ID</th>
			<th>TITLE</th>
			<th>TEXT</th>
			<th>AUTHOR</th>
			<th>OPERATIONS</th>
		</tr>
		<s:iterator value="#contentList">
			<tr>
				<td>${id}&nbsp;</td>
				<td>${title}&nbsp;</td>
				<td>${text}&nbsp;</td>
				<td>${author.username} (id: ${author.id})&nbsp;</td>
				<td><s:a action="content_delete?id=%{id}"
						onclick="return confirm('are you sure to delete this content?')">delete</s:a>
					<s:a action="content_editUI?id=%{id}">modify</s:a>
				</td>
			</tr>
		</s:iterator>
	</table>

	<s:a action="content_addUI">add content</s:a>
	<br /><br />
	<s:a href="javascript:history.back()">back to homepage</s:a>
</body>
</html>