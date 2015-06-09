<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Modify User</title>
  </head>
  
  <body>
    <s:form action="user_edit">
    	<s:hidden name="id"></s:hidden>
    	username: <s:textfield name="username"></s:textfield>
    	<br />
    	address: <s:textfield name="address"></s:textfield>
    	<br />
    	<s:submit value="submit"></s:submit>
    </s:form>
  </body>
</html>
