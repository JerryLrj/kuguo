package org.apache.jsp.WEB_002dINF.views.product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class new_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>添加商品</title>\r\n");
      out.write("<link media=\"all\" rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/styles/add.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"main\">\r\n");
      out.write("\t\t<div class=\"main-left\" id=\"main-left\">\r\n");
      out.write("\t\t\t<h1>添加商品入库</h1>\r\n");
      out.write("\t\t\t<div class=\"entity with-border\" style=\"min-height: 278px;\">\r\n");
      out.write("\t\t\t\t<form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/entity/taobao/info\" method=\"post\" id=\"new-entity-form\" _lpchecked=\"1\">\r\n");
      out.write("\t\t\t\t\t<label>选择货真价实，有用、有趣、有价值的好商品</label> <br> <input type=\"text\" id=\"new-entity-url\" name=\"url\" value=\"粘贴商品链接到这里\" defaultvalue=\"粘贴商品链接到这里\" style=\"color: rgb(187, 187, 187);\"> <input type=\"button\" onclick=\"validateurl();\" name=\"btn\" class=\"btn-v1\" value=\"载入\">\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"main-right\" id=\"main-right\">\r\n");
      out.write("\t\t\t<div class=\"siderbar with-border\">\r\n");
      out.write("\t\t\t\t<div class=\"aside\">\r\n");
      out.write("\t\t\t\t\t<h3>全是好商品</h3>\r\n");
      out.write("\t\t\t\t\t<p class=\"c999\">如果，一件商品，</p>\r\n");
      out.write("\t\t\t\t\t<p class=\"c999\">你愿意让家人使用或与朋友分享，也许这就应该是件不错的东西。</p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"aside\">\r\n");
      out.write("\t\t\t\t\t<h3>创建人信息</h3>\r\n");
      out.write("\t\t\t\t\t<p class=\"c999\">作为第一个把商品推荐到的人，你将被永久记录在商品页。</p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"aside mobile-download\">\r\n");
      out.write("\t\t\t\t\t<h3>下载客户端</h3>\r\n");
      out.write("\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"http://itunes.apple.com/cn/app/id477652209?mt=8\" target=\"_blank\" bi=\"download_iphone\">iPhone</a> / <a href=\"http://itunes.apple.com/cn/app/id450507565?mt=8\" target=\"_blank\" bi=\"download_ipad\">iPad</a> / <a href=\"http://app.guoku.com/android/latest/guoku.apk\" target=\"_blank\" bi=\"download_android\">Android</a>\r\n");
      out.write("\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"clear\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/jquery/jquery.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/jquery-validation/1.10.0/jquery.validate.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/js/main.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\tfunction validateurl() {\r\n");
      out.write("\t\t\tvar url = $(\"#new-entity-url\").val();\r\n");
      out.write("\t\t\tvar strreg = \"[taobao|tmail]\";\r\n");
      out.write("\t\t\tvar reg = new RegExp(strreg);\r\n");
      out.write("\t\t\tif(reg.test(url)) {\r\n");
      out.write("\t\t\t\t$(\"#new-entity-form\").submit();\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\talert(\"请输入正确的url\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction cle() {\r\n");
      out.write("\t\t\tvar con = $(\"#content\");\r\n");
      out.write("\t\t\tvar def = con.attr(\"defaultValue\");\r\n");
      out.write("\t\t\tif($.trim(con.val()) == def) {\r\n");
      out.write("\t\t\t\tcon.val(\"\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
