package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_set_var_value_nobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_set_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>欢迎加入</title>\r\n");
      out.write("        <link media=\"all\" rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/styles/register.css\" />\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("        if (window.ActiveXObject) {\r\n");
      out.write("            var ua = navigator.userAgent.toLowerCase();\r\n");
      out.write("            var ie=ua.match(/msie ([\\d.]+)/)[1]\r\n");
      out.write("            if(ie==6.0)\r\n");
      out.write("                location.href = \"/ie6/\";\r\n");
      out.write("        }\r\n");
      out.write("        </script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div id=\"wrapper\">\r\n");
      out.write("            <div id=\"main\">\r\n");
      out.write("                <div class=\"rlcontainer\">\r\n");
      out.write("                    <div class=\"top\">\r\n");
      out.write("                        <div class=\"big_logo\">\r\n");
      out.write("                            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/selected/\">\r\n");
      out.write("                                <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/images/logo.jpg\"/>\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/register/\" class=\"rl-form\" id=\"sign-in-up-form\" method=\"post\" enable=\"true\">\r\n");
      out.write("                            <div class=\"content\">\r\n");
      out.write("                                <p>\r\n");
      out.write("                                    <b>注册一个新的帐号</b> | 已有帐号？ \r\n");
      out.write("                                    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/login\" class=\"green\">请登录</a>\r\n");
      out.write("                                </p>\r\n");
      out.write("                                <div class=\"row\">\r\n");
      out.write("                                    <label>昵称</label>\r\n");
      out.write("                                   <input name=\"name\" type=\"text\" value=\"\" placeholder=\"昵称\"/><br />\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"row\">\r\n");
      out.write("                                    <label>邮箱（用于登录）</label>\r\n");
      out.write("                                    <input name=\"email\" type=\"text\" value=\"\" placeholder=\"邮箱（用于登录）\"/><br />\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"row\">\r\n");
      out.write("                                    <label>密码（至少 6 位数字或字母）</label>\r\n");
      out.write("                                    <input name=\"plainPassword\" type=\"password\" value=\"\" placeholder=\"密码（至少 6 位数字或字母）\"/><br />\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <input type=\"checkbox\" checked=\"checked\"/>\r\n");
      out.write("                                <span>同意<a href=\"/agreement/\">《使用协议》</a></span>\r\n");
      out.write("                                <input type=\"submit\" value=\"注册\" class=\"btn-v2 ml80\" />\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </form>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div id=\"footer\">\r\n");
      out.write("                <div class=\"footer-container\">\r\n");
      out.write("                    <span>京ICP备11036615号-1 京公网安备11010502019958</span>\r\n");
      out.write("                    <ul class=\"footer-items\">\r\n");
      out.write("                        <li><a href=\"http://itunes.apple.com/cn/app/id477652209?mt=8\" target=\"_blank\" bi=\"download_iphone\">iPhone</a></li>\r\n");
      out.write("                        <li><a href=\"http://itunes.apple.com/cn/app/id450507565?mt=8\" target=\"_blank\" bi=\"download_ipad\">iPad</a></li>\r\n");
      out.write("                        <li><a href=\"http://app.guoku.com/android/latest/guoku.apk\" target=\"_blank\" bi=\"download_android\">Android</a></li>\r\n");
      out.write("                        <li><a href=\"mailto:rujie.liu@qq.com\" alt=\"Keep in touch :)\">邮件反馈</a></li>\r\n");
      out.write("                        <li><a href=\"http://www.weibo.com/guoku\" target=\"_blank\" bi=\"sina\">新浪微博</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/jquery/jquery.min.js\"></script>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/jquery-validation/1.10.0/jquery.validate.min.js\"></script>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/js/main.js\"></script>\r\n");
      out.write("    </body> \r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_set_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_0.setPageContext(_jspx_page_context);
    _jspx_th_c_set_0.setParent(null);
    _jspx_th_c_set_0.setVar("ctx");
    _jspx_th_c_set_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_0 = _jspx_th_c_set_0.doStartTag();
    if (_jspx_th_c_set_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
    return false;
  }
}
