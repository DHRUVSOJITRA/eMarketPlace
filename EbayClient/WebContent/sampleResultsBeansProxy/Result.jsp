<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleResultsBeansProxyid" scope="session" class="connection.ResultsBeansProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleResultsBeansProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleResultsBeansProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleResultsBeansProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        connection.ResultsBeans getResultsBeans10mtemp = sampleResultsBeansProxyid.getResultsBeans();
if(getResultsBeans10mtemp == null){
%>
<%=getResultsBeans10mtemp %>
<%
}else{
        if(getResultsBeans10mtemp!= null){
        String tempreturnp11 = getResultsBeans10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        java.lang.Object[] getcategories13mtemp = sampleResultsBeansProxyid.getcategories();
if(getcategories13mtemp == null){
%>
<%=getcategories13mtemp %>
<%
}else{
        String tempreturnp14 = null;
        if(getcategories13mtemp != null){
        java.util.List listreturnp14= java.util.Arrays.asList(getcategories13mtemp);
        tempreturnp14 = listreturnp14.toString();
        }
        %>
        <%=tempreturnp14%>
        <%
}
break;
case 16:
        gotMethod = true;
        String name_1id=  request.getParameter("name19");
            java.lang.String name_1idTemp = null;
        if(!name_1id.equals("")){
         name_1idTemp  = name_1id;
        }
        sampleResultsBeansProxyid.setcategories(name_1idTemp);
break;
}
} catch (Exception e) { 
%>
exception: <%= e %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>