/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.31
 * Generated at: 2018-07-21 06:43:14 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class regist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Frameset//EN\" \"http://www.w3c.org/TR/1999/REC-html401-19991224/frameset.dtd\">\r\n");
      out.write("<HTML xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<HEAD>\r\n");
      out.write("<META http-equiv=Content-Type content=\"text/html; charset=utf-8\">\r\n");
      out.write("<STYLE type=text/css>\r\n");
      out.write("BODY {\r\n");
      out.write("\tFONT-SIZE: 12px; COLOR: #ffffff; FONT-FAMILY: 宋体\r\n");
      out.write("}\r\n");
      out.write("TD {\r\n");
      out.write("\tFONT-SIZE: 12px; COLOR: #ffffff; FONT-FAMILY: 宋体\r\n");
      out.write("}\r\n");
      out.write("</STYLE>\r\n");
      out.write("\r\n");
      out.write("<META content=\"MSHTML 6.00.6000.16809\" name=GENERATOR></HEAD>\r\n");
      out.write("<BODY>\r\n");
      out.write("<FORM id=form1 name=form1 action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/user_regist.action\" method=post>\r\n");
      out.write("\r\n");
      out.write("<DIV id=UpdatePanel1>\r\n");
      out.write("<DIV id=div1 \r\n");
      out.write("style=\"LEFT: 0px; POSITION: absolute; TOP: 0px; BACKGROUND-COLOR: #0066ff\"></DIV>\r\n");
      out.write("<DIV id=div2 \r\n");
      out.write("style=\"LEFT: 0px; POSITION: absolute; TOP: 0px; BACKGROUND-COLOR: #0066ff\"></DIV>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<DIV>&nbsp;&nbsp; </DIV>\r\n");
      out.write("<DIV>\r\n");
      out.write("<TABLE cellSpacing=0 cellPadding=0 width=900 align=center border=0>\r\n");
      out.write("  <TBODY>\r\n");
      out.write("  <TR>\r\n");
      out.write("    <TD style=\"HEIGHT: 105px\"><IMG src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/images/login_1.gif\" \r\n");
      out.write("  border=0></TD></TR>\r\n");
      out.write("  <TR>\r\n");
      out.write("    <TD background=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/images/regist_bt.png height=300>\r\n");
      out.write("      <TABLE height=300 cellPadding=0 width=900 border=0>\r\n");
      out.write("        <TBODY>\r\n");
      out.write("        <TR>\r\n");
      out.write("          <TD colSpan=2 height=35></TD></TR>\r\n");
      out.write("        <TR>\r\n");
      out.write("          <TD width=360></TD>\r\n");
      out.write("          <TD>\r\n");
      out.write("            <TABLE cellSpacing=0 cellPadding=2 border=0>\r\n");
      out.write("              <TBODY>\r\n");
      out.write("              <TR>\r\n");
      out.write("                <TD style=\"HEIGHT: 28px\" width=80> 用户账号：</TD>\r\n");
      out.write("                <TD style=\"HEIGHT: 28px\" width=150><INPUT id=txtName \r\n");
      out.write("                  style=\"WIDTH: 130px\" name=\"user_code\"></TD>\r\n");
      out.write("                <TD style=\"HEIGHT: 28px\" width=370><SPAN \r\n");
      out.write("                  id=RequiredFieldValidator3 \r\n");
      out.write("                  style=\"FONT-WEIGHT: bold; VISIBILITY: hidden; COLOR: white\">请输入登录名</SPAN></TD></TR>\r\n");
      out.write("              <TR>\r\n");
      out.write("                <TD style=\"HEIGHT: 28px\">登录密码：</TD>\r\n");
      out.write("                <TD style=\"HEIGHT: 28px\"><INPUT id=txtPwd style=\"WIDTH: 130px\" \r\n");
      out.write("                  type=password name=\"user_password\"></TD>\r\n");
      out.write("                <TD style=\"HEIGHT: 28px\"><SPAN id=RequiredFieldValidator4 \r\n");
      out.write("                  style=\"FONT-WEIGHT: bold; VISIBILITY: hidden; COLOR: white\">请输入密码</SPAN></TD></TR>\r\n");
      out.write("             \r\n");
      out.write("              <TR>\r\n");
      out.write("                <TD style=\"HEIGHT: 28px\" width=80> 用户姓名 ：</TD>\r\n");
      out.write("                <TD style=\"HEIGHT: 28px\" width=150><INPUT id=txtName \r\n");
      out.write("                  style=\"WIDTH: 130px\" name=\"user_name\"></TD>\r\n");
      out.write("                <TD style=\"HEIGHT: 28px\" width=370><SPAN \r\n");
      out.write("                  id=RequiredFieldValidator3 \r\n");
      out.write("                  style=\"FONT-WEIGHT: bold; VISIBILITY: hidden; COLOR: white\">请输入登录名</SPAN></TD>\r\n");
      out.write("              </TR>\r\n");
      out.write("              \r\n");
      out.write("              <TR>\r\n");
      out.write("                <TD style=\"HEIGHT: 28px\">验证码：</TD>\r\n");
      out.write("                <TD style=\"HEIGHT: 28px\"><INPUT id=txtcode \r\n");
      out.write("                  style=\"WIDTH: 130px\" name=txtcode></TD>\r\n");
      out.write("                <TD style=\"HEIGHT: 28px\">&nbsp;</TD></TR>\r\n");
      out.write("              <TR>\r\n");
      out.write("                <TD style=\"HEIGHT: 18px\"></TD>\r\n");
      out.write("                <TD style=\"HEIGHT: 18px\"></TD>\r\n");
      out.write("                <TD style=\"HEIGHT: 18px\"></TD></TR>\r\n");
      out.write("              <TR>\r\n");
      out.write("                <TD></TD>\r\n");
      out.write("                <TD>\r\n");
      out.write("                <INPUT id=btn \r\n");
      out.write("                  style=\"BORDER-TOP-WIDTH: 0px; BORDER-LEFT-WIDTH: 0px; BORDER-BOTTOM-WIDTH: 0px; BORDER-RIGHT-WIDTH: 0px\" \r\n");
      out.write("                  onclick='javascript:WebForm_DoPostBackWithOptions(new WebForm_PostBackOptions(\"btn\", \"\", true, \"\", \"\", false, false))' \r\n");
      out.write("                  type=image src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/images/regist_button.gif\" name=btn> \r\n");
      out.write("              </TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE></TD></TR>\r\n");
      out.write("  <TR>\r\n");
      out.write("    <TD><IMG src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/images/login_3.jpg\" \r\n");
      out.write("border=0></TD></TR></TBODY></TABLE></DIV></DIV>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</FORM></BODY></HTML>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}