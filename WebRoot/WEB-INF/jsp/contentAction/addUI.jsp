<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Add Content</title>
  </head>
  
  <body>
    <s:form action="content_add">
    	TITLE: <s:textfield name="title"></s:textfield>
    	<br />
    	TEXT: <s:textfield name="text"></s:textfield>
    	<br />
    	AUTHOR: <s:select name="userid" list="#userList" listKey="id" listValue="%{username + ' (id: ' + id + ')'}" />
    	<br />
    	<s:submit value="submit"></s:submit>
    </s:form>
  </body>
</html>
