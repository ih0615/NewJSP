<%@ page language="java" contentType="text/plain; charset=UTF-8"%>

<%
	boolean isTrue = (boolean) request.getAttribute("isTrue");
%>



<%
	if (isTrue) {
%>
{ "isTrue" : "true"}
<%
	} else {
%>
{ "isTrue" : "false"}
<%
	}
%>




