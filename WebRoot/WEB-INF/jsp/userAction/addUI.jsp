<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Add User</title>
  </head>
  
  <body>
    <s:form action="user_add">
    	USERNAME: <s:textfield name="username"></s:textfield>
    	<br />
    	ADDRESS: <s:textfield name="address"></s:textfield>
    	<br />
    	<s:submit value="submit"></s:submit>
    </s:form>
  </body>
</html>
