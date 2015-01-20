<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleServicesProxyid" scope="session" class="connection.ServicesProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleServicesProxyid.setEndpoint(request.getParameter("endpoint"));
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
        java.lang.String getEndpoint2mtemp = sampleServicesProxyid.getEndpoint();
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
        sampleServicesProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        connection.Services getServices10mtemp = sampleServicesProxyid.getServices();
if(getServices10mtemp == null){
%>
<%=getServices10mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
</TABLE>
<%
}
break;
case 15:
        gotMethod = true;
        String emailid_1id=  request.getParameter("emailid18");
            java.lang.String emailid_1idTemp = null;
        if(!emailid_1id.equals("")){
         emailid_1idTemp  = emailid_1id;
        }
        String productname_2id=  request.getParameter("productname20");
            java.lang.String productname_2idTemp = null;
        if(!productname_2id.equals("")){
         productname_2idTemp  = productname_2id;
        }
        java.lang.String addtocart15mtemp = sampleServicesProxyid.addtocart(emailid_1idTemp,productname_2idTemp);
if(addtocart15mtemp == null){
%>
<%=addtocart15mtemp %>
<%
}else{
        String tempResultreturnp16 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(addtocart15mtemp));
        %>
        <%= tempResultreturnp16 %>
        <%
}
break;
case 22:
        gotMethod = true;
        String emailid_3id=  request.getParameter("emailid25");
            java.lang.String emailid_3idTemp = null;
        if(!emailid_3id.equals("")){
         emailid_3idTemp  = emailid_3id;
        }
        int getuserid22mtemp = sampleServicesProxyid.getuserid(emailid_3idTemp);
        String tempResultreturnp23 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getuserid22mtemp));
        %>
        <%= tempResultreturnp23 %>
        <%
break;
case 27:
        gotMethod = true;
        String emailid_4id=  request.getParameter("emailid30");
            java.lang.String emailid_4idTemp = null;
        if(!emailid_4id.equals("")){
         emailid_4idTemp  = emailid_4id;
        }
        java.lang.String getname27mtemp = sampleServicesProxyid.getname(emailid_4idTemp);
if(getname27mtemp == null){
%>
<%=getname27mtemp %>
<%
}else{
        String tempResultreturnp28 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getname27mtemp));
        %>
        <%= tempResultreturnp28 %>
        <%
}
break;
case 32:
        gotMethod = true;
        String userid_5id=  request.getParameter("userid35");
        int userid_5idTemp  = Integer.parseInt(userid_5id);
        int getcartid32mtemp = sampleServicesProxyid.getcartid(userid_5idTemp);
        String tempResultreturnp33 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getcartid32mtemp));
        %>
        <%= tempResultreturnp33 %>
        <%
break;
case 37:
        gotMethod = true;
        String emailid_6id=  request.getParameter("emailid40");
            java.lang.String emailid_6idTemp = null;
        if(!emailid_6id.equals("")){
         emailid_6idTemp  = emailid_6id;
        }
        java.lang.String rendercart37mtemp = sampleServicesProxyid.rendercart(emailid_6idTemp);
if(rendercart37mtemp == null){
%>
<%=rendercart37mtemp %>
<%
}else{
        String tempResultreturnp38 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(rendercart37mtemp));
        %>
        <%= tempResultreturnp38 %>
        <%
}
break;
case 42:
        gotMethod = true;
        String productname_7id=  request.getParameter("productname45");
            java.lang.String productname_7idTemp = null;
        if(!productname_7id.equals("")){
         productname_7idTemp  = productname_7id;
        }
        int getproductid42mtemp = sampleServicesProxyid.getproductid(productname_7idTemp);
        String tempResultreturnp43 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getproductid42mtemp));
        %>
        <%= tempResultreturnp43 %>
        <%
break;
case 47:
        gotMethod = true;
        String firstname_8id=  request.getParameter("firstname50");
            java.lang.String firstname_8idTemp = null;
        if(!firstname_8id.equals("")){
         firstname_8idTemp  = firstname_8id;
        }
        String lastname_9id=  request.getParameter("lastname52");
            java.lang.String lastname_9idTemp = null;
        if(!lastname_9id.equals("")){
         lastname_9idTemp  = lastname_9id;
        }
        String emailid_10id=  request.getParameter("emailid54");
            java.lang.String emailid_10idTemp = null;
        if(!emailid_10id.equals("")){
         emailid_10idTemp  = emailid_10id;
        }
        String password_11id=  request.getParameter("password56");
            java.lang.String password_11idTemp = null;
        if(!password_11id.equals("")){
         password_11idTemp  = password_11id;
        }
        java.lang.String signup47mtemp = sampleServicesProxyid.signup(firstname_8idTemp,lastname_9idTemp,emailid_10idTemp,password_11idTemp);
if(signup47mtemp == null){
%>
<%=signup47mtemp %>
<%
}else{
        String tempResultreturnp48 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(signup47mtemp));
        %>
        <%= tempResultreturnp48 %>
        <%
}
break;
case 58:
        gotMethod = true;
        String name_12id=  request.getParameter("name61");
            java.lang.String name_12idTemp = null;
        if(!name_12id.equals("")){
         name_12idTemp  = name_12id;
        }
        String pass_13id=  request.getParameter("pass63");
            java.lang.String pass_13idTemp = null;
        if(!pass_13id.equals("")){
         pass_13idTemp  = pass_13id;
        }
        java.lang.String signin58mtemp = sampleServicesProxyid.signin(name_12idTemp,pass_13idTemp);
if(signin58mtemp == null){
%>
<%=signin58mtemp %>
<%
}else{
        String tempResultreturnp59 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(signin58mtemp));
        %>
        <%= tempResultreturnp59 %>
        <%
}
break;
case 65:
        gotMethod = true;
        String emailid_14id=  request.getParameter("emailid68");
            java.lang.String emailid_14idTemp = null;
        if(!emailid_14id.equals("")){
         emailid_14idTemp  = emailid_14id;
        }
        java.lang.String pastpurchases65mtemp = sampleServicesProxyid.pastpurchases(emailid_14idTemp);
if(pastpurchases65mtemp == null){
%>
<%=pastpurchases65mtemp %>
<%
}else{
        String tempResultreturnp66 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(pastpurchases65mtemp));
        %>
        <%= tempResultreturnp66 %>
        <%
}
break;
case 70:
        gotMethod = true;
        String emailid_15id=  request.getParameter("emailid73");
            java.lang.String emailid_15idTemp = null;
        if(!emailid_15id.equals("")){
         emailid_15idTemp  = emailid_15id;
        }
        java.lang.String settime70mtemp = sampleServicesProxyid.settime(emailid_15idTemp);
if(settime70mtemp == null){
%>
<%=settime70mtemp %>
<%
}else{
        String tempResultreturnp71 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(settime70mtemp));
        %>
        <%= tempResultreturnp71 %>
        <%
}
break;
case 75:
        gotMethod = true;
        String emailid_16id=  request.getParameter("emailid78");
            java.lang.String emailid_16idTemp = null;
        if(!emailid_16id.equals("")){
         emailid_16idTemp  = emailid_16id;
        }
        String category_17id=  request.getParameter("category80");
            java.lang.String category_17idTemp = null;
        if(!category_17id.equals("")){
         category_17idTemp  = category_17id;
        }
        String itemname_18id=  request.getParameter("itemname82");
            java.lang.String itemname_18idTemp = null;
        if(!itemname_18id.equals("")){
         itemname_18idTemp  = itemname_18id;
        }
        String itemdiscription_19id=  request.getParameter("itemdiscription84");
            java.lang.String itemdiscription_19idTemp = null;
        if(!itemdiscription_19id.equals("")){
         itemdiscription_19idTemp  = itemdiscription_19id;
        }
        String itemprice_20id=  request.getParameter("itemprice86");
            java.lang.String itemprice_20idTemp = null;
        if(!itemprice_20id.equals("")){
         itemprice_20idTemp  = itemprice_20id;
        }
        String itemquantity_21id=  request.getParameter("itemquantity88");
            java.lang.String itemquantity_21idTemp = null;
        if(!itemquantity_21id.equals("")){
         itemquantity_21idTemp  = itemquantity_21id;
        }
        String sname_22id=  request.getParameter("sname90");
            java.lang.String sname_22idTemp = null;
        if(!sname_22id.equals("")){
         sname_22idTemp  = sname_22id;
        }
        String saddress_23id=  request.getParameter("saddress92");
            java.lang.String saddress_23idTemp = null;
        if(!saddress_23id.equals("")){
         saddress_23idTemp  = saddress_23id;
        }
        String semailid_24id=  request.getParameter("semailid94");
            java.lang.String semailid_24idTemp = null;
        if(!semailid_24id.equals("")){
         semailid_24idTemp  = semailid_24id;
        }
        java.lang.String addproduct75mtemp = sampleServicesProxyid.addproduct(emailid_16idTemp,category_17idTemp,itemname_18idTemp,itemdiscription_19idTemp,itemprice_20idTemp,itemquantity_21idTemp,sname_22idTemp,saddress_23idTemp,semailid_24idTemp);
if(addproduct75mtemp == null){
%>
<%=addproduct75mtemp %>
<%
}else{
        String tempResultreturnp76 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(addproduct75mtemp));
        %>
        <%= tempResultreturnp76 %>
        <%
}
break;
case 96:
        gotMethod = true;
        String categoryname_25id=  request.getParameter("categoryname99");
            java.lang.String categoryname_25idTemp = null;
        if(!categoryname_25id.equals("")){
         categoryname_25idTemp  = categoryname_25id;
        }
        java.lang.String addcategory96mtemp = sampleServicesProxyid.addcategory(categoryname_25idTemp);
if(addcategory96mtemp == null){
%>
<%=addcategory96mtemp %>
<%
}else{
        String tempResultreturnp97 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(addcategory96mtemp));
        %>
        <%= tempResultreturnp97 %>
        <%
}
break;
case 101:
        gotMethod = true;
        String productname_26id=  request.getParameter("productname104");
            java.lang.String productname_26idTemp = null;
        if(!productname_26id.equals("")){
         productname_26idTemp  = productname_26id;
        }
        java.lang.String deleteproduct101mtemp = sampleServicesProxyid.deleteproduct(productname_26idTemp);
if(deleteproduct101mtemp == null){
%>
<%=deleteproduct101mtemp %>
<%
}else{
        String tempResultreturnp102 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(deleteproduct101mtemp));
        %>
        <%= tempResultreturnp102 %>
        <%
}
break;
case 106:
        gotMethod = true;
        String emailid_27id=  request.getParameter("emailid109");
            java.lang.String emailid_27idTemp = null;
        if(!emailid_27id.equals("")){
         emailid_27idTemp  = emailid_27id;
        }
        java.lang.String pastsoldouts106mtemp = sampleServicesProxyid.pastsoldouts(emailid_27idTemp);
if(pastsoldouts106mtemp == null){
%>
<%=pastsoldouts106mtemp %>
<%
}else{
        String tempResultreturnp107 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(pastsoldouts106mtemp));
        %>
        <%= tempResultreturnp107 %>
        <%
}
break;
case 111:
        gotMethod = true;
        String emailid_28id=  request.getParameter("emailid114");
            java.lang.String emailid_28idTemp = null;
        if(!emailid_28id.equals("")){
         emailid_28idTemp  = emailid_28id;
        }
        java.lang.String checkout111mtemp = sampleServicesProxyid.checkout(emailid_28idTemp);
if(checkout111mtemp == null){
%>
<%=checkout111mtemp %>
<%
}else{
        String tempResultreturnp112 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(checkout111mtemp));
        %>
        <%= tempResultreturnp112 %>
        <%
}
break;
case 116:
        gotMethod = true;
        String emailid_29id=  request.getParameter("emailid119");
            java.lang.String emailid_29idTemp = null;
        if(!emailid_29id.equals("")){
         emailid_29idTemp  = emailid_29id;
        }
        String productname_30id=  request.getParameter("productname121");
            java.lang.String productname_30idTemp = null;
        if(!productname_30id.equals("")){
         productname_30idTemp  = productname_30id;
        }
        java.lang.String deleteFromCart116mtemp = sampleServicesProxyid.deleteFromCart(emailid_29idTemp,productname_30idTemp);
if(deleteFromCart116mtemp == null){
%>
<%=deleteFromCart116mtemp %>
<%
}else{
        String tempResultreturnp117 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(deleteFromCart116mtemp));
        %>
        <%= tempResultreturnp117 %>
        <%
}
break;
case 123:
        gotMethod = true;
        String categoryname_31id=  request.getParameter("categoryname126");
            java.lang.String categoryname_31idTemp = null;
        if(!categoryname_31id.equals("")){
         categoryname_31idTemp  = categoryname_31id;
        }
        int getcategorytid123mtemp = sampleServicesProxyid.getcategorytid(categoryname_31idTemp);
        String tempResultreturnp124 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getcategorytid123mtemp));
        %>
        <%= tempResultreturnp124 %>
        <%
break;
case 128:
        gotMethod = true;
        String emailid_32id=  request.getParameter("emailid131");
            java.lang.String emailid_32idTemp = null;
        if(!emailid_32id.equals("")){
         emailid_32idTemp  = emailid_32id;
        }
        java.lang.String lasttimeloggedin128mtemp = sampleServicesProxyid.lasttimeloggedin(emailid_32idTemp);
if(lasttimeloggedin128mtemp == null){
%>
<%=lasttimeloggedin128mtemp %>
<%
}else{
        String tempResultreturnp129 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(lasttimeloggedin128mtemp));
        %>
        <%= tempResultreturnp129 %>
        <%
}
break;
case 133:
        gotMethod = true;
        java.lang.String rendercategory133mtemp = sampleServicesProxyid.rendercategory();
if(rendercategory133mtemp == null){
%>
<%=rendercategory133mtemp %>
<%
}else{
        String tempResultreturnp134 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(rendercategory133mtemp));
        %>
        <%= tempResultreturnp134 %>
        <%
}
break;
case 136:
        gotMethod = true;
        String catname_33id=  request.getParameter("catname139");
            java.lang.String catname_33idTemp = null;
        if(!catname_33id.equals("")){
         catname_33idTemp  = catname_33id;
        }
        java.lang.String renderproducts136mtemp = sampleServicesProxyid.renderproducts(catname_33idTemp);
if(renderproducts136mtemp == null){
%>
<%=renderproducts136mtemp %>
<%
}else{
        String tempResultreturnp137 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(renderproducts136mtemp));
        %>
        <%= tempResultreturnp137 %>
        <%
}
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