<%--<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         import="java.util.*"
         pageEncoding="utf-8"
         errorPage="error.jsp"
         isErrorPage="false"
         buffer="8kb"
         session="true"
%>--%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    pageContext.setAttribute("basePath", request.getContextPath()+"/") ;
    pageContext.setAttribute("name",11,1);
%>
<script type="text/javascript" src="${basePath}js/jquery/jquery-1.10.2.min.js"></script>
<link href="${basePath}css/skin1.css" rel="stylesheet" type="text/css" />
