package org.apache.jsp.WEB_002dINF.views.product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class detail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_shiro_guest;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_shiro_user;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_shiro_principal_property_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_fmt_formatDate_value_pattern_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_shiro_guest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_shiro_user = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_shiro_principal_property_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_fmt_formatDate_value_pattern_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_set_var_value_nobody.release();
    _jspx_tagPool_shiro_guest.release();
    _jspx_tagPool_shiro_user.release();
    _jspx_tagPool_shiro_principal_property_nobody.release();
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_fmt_formatDate_value_pattern_nobody.release();
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
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_set_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</title>\r\n");
      out.write("<link media=\"all\" rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/styles/detail.css\" />\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tif (window.ActiveXObject) {\r\n");
      out.write("\t\tvar ua = navigator.userAgent.toLowerCase();\r\n");
      out.write("\t\tvar ie = ua.match(/msie ([\\d.]+)/)[1]\r\n");
      out.write("\t\tif (ie == 6.0)\r\n");
      out.write("\t\t\tlocation.href = \"/ie6/\";\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"wrapper\">\r\n");
      out.write("\t\t<div id=\"main\">\r\n");
      out.write("\t\t\t<div class=\"detail-body\">\r\n");
      out.write("\t\t\t\t<div class=\"main-left\" id=\"main-left\">\r\n");
      out.write("\t\t\t\t\t<h1>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h1>\r\n");
      out.write("\t\t\t\t\t<div class=\"with-border upper\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"entity\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"image\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.order_link}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" target=\"_blank\" bi=\"image_taobao\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"img-mask\"></div> <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.picture }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      if (_jspx_meth_shiro_guest_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      if (_jspx_meth_shiro_user_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"notes\">\r\n");
      out.write("\t\t\t\t\t\t\t<div id=\"display-area\">\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div id=\"new\">\r\n");
      out.write("\t\t\t\t\t\t");
      if (_jspx_meth_shiro_guest_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");
      if (_jspx_meth_shiro_user_2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"main-right\" id=\"main-right\">\r\n");
      out.write("\t\t\t\t\t");
      if (_jspx_meth_shiro_guest_2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"siderbar with-border\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"aside\">\r\n");
      out.write("\t\t\t\t\t\t\t<a class=\"btn-v2 price\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.order_link}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" target=_blank bi=\"btn_taobao\"> 详情 <span>￥");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.price}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t<h3>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.favorite_num }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("人喜爱</h3>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"small-avatar-container\">\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      if (_jspx_meth_c_forEach_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"aside\">\r\n");
      out.write("\t\t\t\t\t\t\t<p class=\"into-time\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/u/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.user.id }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/likes/\" target=_blank> <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.user.head }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" width=\"25\" height=\"25\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t</a> <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/u/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.user.id }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/likes/\" target=_blank>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.user.name }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</a> 添加于 ");
      if (_jspx_meth_fmt_formatDate_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"aside\">\r\n");
      out.write("\t\t\t\t\t\t\t<p class=\"into-time sider-weibo-share\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<a>分享到微博</a>\r\n");
      out.write("\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"aside mobile-download\">\r\n");
      out.write("\t\t\t\t\t\t\t<h3>下载客户端</h3>\r\n");
      out.write("\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"http://itunes.apple.com/cn/app/id477652209?mt=8\" target=\"_blank\" bi=\"download_iphone\">iPhone</a> / <a href=\"http://itunes.apple.com/cn/app/id450507565?mt=8\" target=\"_blank\" bi=\"download_ipad\">iPad</a> / <a href=\"http://app.guoku.com/android/latest/guoku.apk\" target=\"_blank\" bi=\"download_andriod\">Android</a>\r\n");
      out.write("\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"clear\"></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/jquery/jquery.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/jquery-validation/1.10.0/jquery.validate.min.js\"></script>\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\tfunction likeProduct(a,b) {\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/product/like/\"+a+\"/\"+b,\r\n");
      out.write("\t\t\t\ttype: \"POST\", \r\n");
      out.write("\t\t\t\tsuccess:function(result){\r\n");
      out.write("\t\t\t\t\tif(result) {\r\n");
      out.write("\t\t\t\t\t\tvar id = \"#\"+a;\r\n");
      out.write("\t\t\t\t\t\tvar num = $(id).html();\r\n");
      out.write("\t\t\t\t\t\t$(id).html(num*1 + 1);\r\n");
      out.write("\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\talert(\"喜爱失败\");\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t/*添加评论*/\r\n");
      out.write("\t\tfunction cle() {\r\n");
      out.write("\t\t\tvar con = $(\"#content\");\r\n");
      out.write("\t\t\tvar def = con.attr(\"defaultValue\");\r\n");
      out.write("\t\t\tif($.trim(con.val()) == def) {\r\n");
      out.write("\t\t\t\tcon.val(\"\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\"#new-note-form\").submit(function(){\r\n");
      out.write("\t\t\tvar content = $.trim($(\"#content\").val());\r\n");
      out.write("\t\t\tvar pid = ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(";\r\n");
      out.write("\t\t\tvar uid = $(\"#uid\").html();\r\n");
      out.write("\t\t\tif(content == \"\" || content.length < 10 || content == $(\"#content\").attr(\"defaultValue\")) {\r\n");
      out.write("\t\t\t\t$(\".note-prompt\").html(\"最少输入10字评价!\");\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\tif(content.indexOf(\"#\") >= 0) {\r\n");
      out.write("\t\t\t\t\tvar tag = content.substring(content.indexOf(\"#\") + 1,content.indexOf(\" \"));\r\n");
      out.write("\t\t\t\t\tif(tag != \"\") {\r\n");
      out.write("\t\t\t\t\t\tif(tag == \"#\") {\r\n");
      out.write("\t\t\t\t\t\t\ttag = content.substring(content.indexOf(\"#\") + 1, content.length);\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\t\t\turl : \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/entity/addtag/\",\r\n");
      out.write("\t\t\t\t\t\t\ttype : \"POST\",\r\n");
      out.write("\t\t\t\t\t\t\tdata : {\r\n");
      out.write("\t\t\t\t\t\t\t\ttag : tag,\r\n");
      out.write("\t\t\t\t\t\t\t\tuid : uid,\r\n");
      out.write("\t\t\t\t\t\t\t\tpid : pid\r\n");
      out.write("\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\tsuccess : function(result){\r\n");
      out.write("\t\t\t\t\t\t\t\t//完成时\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t//添加标签\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t/*添加评论*/\r\n");
      out.write("\t\t$(document).ready(function(){\r\n");
      out.write("\t\t\tvar array = $(\".with-tag\");\r\n");
      out.write("\t\t\tfor ( var i = 0; i < array.length; i++) {\r\n");
      out.write("\t\t\t\tvar str = array.eq(i).html(\r\n");
      out.write("\t\t\t\t\t\tarray.eq(i).html().replace(/\\<br[!>]*\\>/g, \"\\n\")).text();\r\n");
      out.write("\t\t\t\tif (str == undefined)\r\n");
      out.write("\t\t\t\t\tcontinue;\r\n");
      out.write("\t\t\t\tvar ereg = /[#＃][0-9a-zA-Z\\u4e00-\\u9fff\\u3040-\\u30FF\\u30A0-\\u30FF]+/g;\r\n");
      out.write("\t\t\t\tvar cut = str.match(ereg);\r\n");
      out.write("\t\t\t\tif (cut == null) {\r\n");
      out.write("\t\t\t\t\tarray.eq(i).html(str.replace(/\\n/g, \"<br>\"));\r\n");
      out.write("\t\t\t\t\tcontinue;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tfor ( var j in cut) {\r\n");
      out.write("\t\t\t\t\tstr = str.replace(cut[j], \"<a class='tag' href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/entity/tag/\"\r\n");
      out.write("\t\t\t\t\t\t\t+ encodeURI(cut[j].replace(/[#＃]/, \"\")) + \"' >\" + cut[j]\r\n");
      out.write("\t\t\t\t\t\t\t+ \"</a>&nbsp;\")\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tarray.eq(i).html(str.replace(/\\n/g, \"<br>\"))\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
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

  private boolean _jspx_meth_shiro_guest_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:guest
    org.apache.shiro.web.tags.GuestTag _jspx_th_shiro_guest_0 = (org.apache.shiro.web.tags.GuestTag) _jspx_tagPool_shiro_guest.get(org.apache.shiro.web.tags.GuestTag.class);
    _jspx_th_shiro_guest_0.setPageContext(_jspx_page_context);
    _jspx_th_shiro_guest_0.setParent(null);
    int _jspx_eval_shiro_guest_0 = _jspx_th_shiro_guest_0.doStartTag();
    if (_jspx_eval_shiro_guest_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t<div class=\"like need-login\">\r\n");
        out.write("\t\t\t\t\t\t\t\t\t<span></span>喜爱&nbsp;<em>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.favorite_num}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</em>\r\n");
        out.write("\t\t\t\t\t\t\t\t</div>\r\n");
        out.write("\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_shiro_guest_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_guest_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_shiro_guest.reuse(_jspx_th_shiro_guest_0);
      return true;
    }
    _jspx_tagPool_shiro_guest.reuse(_jspx_th_shiro_guest_0);
    return false;
  }

  private boolean _jspx_meth_shiro_user_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:user
    org.apache.shiro.web.tags.UserTag _jspx_th_shiro_user_0 = (org.apache.shiro.web.tags.UserTag) _jspx_tagPool_shiro_user.get(org.apache.shiro.web.tags.UserTag.class);
    _jspx_th_shiro_user_0.setPageContext(_jspx_page_context);
    _jspx_th_shiro_user_0.setParent(null);
    int _jspx_eval_shiro_user_0 = _jspx_th_shiro_user_0.doStartTag();
    if (_jspx_eval_shiro_user_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t<div class=\"like\" onclick=\"likeProduct('");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("','");
        if (_jspx_meth_shiro_principal_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_shiro_user_0, _jspx_page_context))
          return true;
        out.write("');\">\r\n");
        out.write("\t\t\t\t\t\t\t\t\t<span></span>喜爱&nbsp;<em id=\"fnum\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.favorite_num}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</em>\r\n");
        out.write("\t\t\t\t\t\t\t\t</div>\r\n");
        out.write("\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_shiro_user_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_user_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_shiro_user.reuse(_jspx_th_shiro_user_0);
      return true;
    }
    _jspx_tagPool_shiro_user.reuse(_jspx_th_shiro_user_0);
    return false;
  }

  private boolean _jspx_meth_shiro_principal_0(javax.servlet.jsp.tagext.JspTag _jspx_th_shiro_user_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:principal
    org.apache.shiro.web.tags.PrincipalTag _jspx_th_shiro_principal_0 = (org.apache.shiro.web.tags.PrincipalTag) _jspx_tagPool_shiro_principal_property_nobody.get(org.apache.shiro.web.tags.PrincipalTag.class);
    _jspx_th_shiro_principal_0.setPageContext(_jspx_page_context);
    _jspx_th_shiro_principal_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_shiro_user_0);
    _jspx_th_shiro_principal_0.setProperty("id");
    int _jspx_eval_shiro_principal_0 = _jspx_th_shiro_principal_0.doStartTag();
    if (_jspx_th_shiro_principal_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_shiro_principal_property_nobody.reuse(_jspx_th_shiro_principal_0);
      return true;
    }
    _jspx_tagPool_shiro_principal_property_nobody.reuse(_jspx_th_shiro_principal_0);
    return false;
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${comments }", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("comment");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<div class=\"note\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"avatar\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<a href=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx }", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("/u/");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${comment.user.id }", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("/likes/\" target=_blank> <img src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${comment.user.head}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" width=\"50\" height=\"50\" />\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t</a>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<a class=\"name c333\" href=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx }", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("/u/");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${comment.user.id }", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("/likes/\" target=_blank> ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${comment.user.name }", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(" </a> <span class=\"desc\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${comment.user.bio }", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</span>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<p class=\"with-tag\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${comment.content}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</p>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"link-row\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"approve-btn left need-login\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<span></span><em></em>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<span class=\"splite-icon left\"></span>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"disapprove-btn left need-login\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<span></span><em></em>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<span class=\"splite-icon left\"></span>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"comment-btn left  need-login\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<span></span><em></em>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"note-time right\">");
          if (_jspx_meth_fmt_formatDate_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<a class=\"right note-weibo-share\" href=\"javascript:void(0);\">分享</a>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"clear\"></div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"comments\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"arrow-grey\"></div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"container\"></div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t");
          if (_jspx_meth_shiro_user_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_fmt_formatDate_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatDate
    org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag _jspx_th_fmt_formatDate_0 = (org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag) _jspx_tagPool_fmt_formatDate_value_pattern_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag.class);
    _jspx_th_fmt_formatDate_0.setPageContext(_jspx_page_context);
    _jspx_th_fmt_formatDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_fmt_formatDate_0.setValue((java.util.Date) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${comment.create_time}", java.util.Date.class, (PageContext)_jspx_page_context, null));
    _jspx_th_fmt_formatDate_0.setPattern("yyyy-MM-dd hh:mm:ss");
    int _jspx_eval_fmt_formatDate_0 = _jspx_th_fmt_formatDate_0.doStartTag();
    if (_jspx_th_fmt_formatDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_formatDate_value_pattern_nobody.reuse(_jspx_th_fmt_formatDate_0);
      return true;
    }
    _jspx_tagPool_fmt_formatDate_value_pattern_nobody.reuse(_jspx_th_fmt_formatDate_0);
    return false;
  }

  private boolean _jspx_meth_shiro_user_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:user
    org.apache.shiro.web.tags.UserTag _jspx_th_shiro_user_1 = (org.apache.shiro.web.tags.UserTag) _jspx_tagPool_shiro_user.get(org.apache.shiro.web.tags.UserTag.class);
    _jspx_th_shiro_user_1.setPageContext(_jspx_page_context);
    _jspx_th_shiro_user_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    int _jspx_eval_shiro_user_1 = _jspx_th_shiro_user_1.doStartTag();
    if (_jspx_eval_shiro_user_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"new-comment\">\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<form action=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx }", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("/entity/note/comment/create/\" class=\"new-comment-form\" method=\"post\" onsubmit=\"return false;\">\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input name=\"entity_note_id\" type=\"hidden\" value=\"147684\" /> <input name=\"comment\" type=\"text\" class=\"content\" value=\"写下你的评论…\" defaultValue=\"写下你的评论…\" autocomplete=\"off\" /> <input type=\"submit\" class=\"btn-v1 disable right\" value=\"评论\" /> <a href=\"javascript:void(0);\" class=\"right new-comment-cancel\">取消</a>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</form>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"clear\"></div>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_shiro_user_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_user_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_shiro_user.reuse(_jspx_th_shiro_user_1);
      return true;
    }
    _jspx_tagPool_shiro_user.reuse(_jspx_th_shiro_user_1);
    return false;
  }

  private boolean _jspx_meth_shiro_guest_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:guest
    org.apache.shiro.web.tags.GuestTag _jspx_th_shiro_guest_1 = (org.apache.shiro.web.tags.GuestTag) _jspx_tagPool_shiro_guest.get(org.apache.shiro.web.tags.GuestTag.class);
    _jspx_th_shiro_guest_1.setPageContext(_jspx_page_context);
    _jspx_th_shiro_guest_1.setParent(null);
    int _jspx_eval_shiro_guest_1 = _jspx_th_shiro_guest_1.doStartTag();
    if (_jspx_eval_shiro_guest_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t<div class=\"note new-note with-border\">\r\n");
        out.write("\t\t\t\t\t\t\t\t<div class=\"note-register\">\r\n");
        out.write("\t\t\t\t\t\t\t\t\t收藏、点评、分享心爱好物 <a href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx }", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("/register\" class=\"btn-v2 w4\">现在注册</a> <span class=\"right\"> 已有帐号， <a href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx }", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("/login\" class=\"green\">从这里登录</a>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t</span>\r\n");
        out.write("\t\t\t\t\t\t\t\t</div>\r\n");
        out.write("\t\t\t\t\t\t\t</div>\r\n");
        out.write("\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_shiro_guest_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_guest_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_shiro_guest.reuse(_jspx_th_shiro_guest_1);
      return true;
    }
    _jspx_tagPool_shiro_guest.reuse(_jspx_th_shiro_guest_1);
    return false;
  }

  private boolean _jspx_meth_shiro_user_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:user
    org.apache.shiro.web.tags.UserTag _jspx_th_shiro_user_2 = (org.apache.shiro.web.tags.UserTag) _jspx_tagPool_shiro_user.get(org.apache.shiro.web.tags.UserTag.class);
    _jspx_th_shiro_user_2.setPageContext(_jspx_page_context);
    _jspx_th_shiro_user_2.setParent(null);
    int _jspx_eval_shiro_user_2 = _jspx_th_shiro_user_2.doStartTag();
    if (_jspx_eval_shiro_user_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t<div class=\"note new-note with-border\">\r\n");
        out.write("\t\t\t\t\t\t\t\t<div class=\"avatar\">\r\n");
        out.write("\t\t\t\t\t\t\t\t\t<a href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx }", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("/u/");
        if (_jspx_meth_shiro_principal_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_shiro_user_2, _jspx_page_context))
          return true;
        out.write("/likes\"> <img src=\"");
        if (_jspx_meth_shiro_principal_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_shiro_user_2, _jspx_page_context))
          return true;
        out.write("\" width=\"50\" height=\"50\" />\r\n");
        out.write("\t\t\t\t\t\t\t\t\t</a>\r\n");
        out.write("\t\t\t\t\t\t\t\t</div>\r\n");
        out.write("\t\t\t\t\t\t\t\t<div hidden=\"true\" id=\"uid\">");
        if (_jspx_meth_shiro_principal_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_shiro_user_2, _jspx_page_context))
          return true;
        out.write("</div>\r\n");
        out.write("\t\t\t\t\t\t\t\t<a class=\"name c333\" href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx }", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("/u/");
        if (_jspx_meth_shiro_principal_4((javax.servlet.jsp.tagext.JspTag) _jspx_th_shiro_user_2, _jspx_page_context))
          return true;
        out.write("/\">");
        if (_jspx_meth_shiro_principal_5((javax.servlet.jsp.tagext.JspTag) _jspx_th_shiro_user_2, _jspx_page_context))
          return true;
        out.write("</a> <span class=\"desc\">");
        if (_jspx_meth_shiro_principal_6((javax.servlet.jsp.tagext.JspTag) _jspx_th_shiro_user_2, _jspx_page_context))
          return true;
        out.write("</span>\r\n");
        out.write("\t\t\t\t\t\t\t\t<form action=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx }", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("/entity/note/create/\" method=\"post\" id=\"new-note-form\">\r\n");
        out.write("\t\t\t\t\t\t\t\t\t<textarea id=\"content\" name=\"content\" class=\"tag-ac\" defaultValue=\"写点评  #贴标签\" onfocus=\"cle();\">写点评  #贴标签</textarea>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t<div class=\"note-prompt\">\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"arrow-fcfcfc\"></div>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t说说你的评价？欢迎真实、有用、有趣的商品点评。\r\n");
        out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
        out.write("\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"productId\" value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.id }", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\" /> <input class=\"btn-v2 right\" type=\"submit\" value=\"点评\" />\r\n");
        out.write("\t\t\t\t\t\t\t\t</form>\r\n");
        out.write("\t\t\t\t\t\t\t\t<div class=\"clear\"></div>\r\n");
        out.write("\t\t\t\t\t\t\t</div>\r\n");
        out.write("\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_shiro_user_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_user_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_shiro_user.reuse(_jspx_th_shiro_user_2);
      return true;
    }
    _jspx_tagPool_shiro_user.reuse(_jspx_th_shiro_user_2);
    return false;
  }

  private boolean _jspx_meth_shiro_principal_1(javax.servlet.jsp.tagext.JspTag _jspx_th_shiro_user_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:principal
    org.apache.shiro.web.tags.PrincipalTag _jspx_th_shiro_principal_1 = (org.apache.shiro.web.tags.PrincipalTag) _jspx_tagPool_shiro_principal_property_nobody.get(org.apache.shiro.web.tags.PrincipalTag.class);
    _jspx_th_shiro_principal_1.setPageContext(_jspx_page_context);
    _jspx_th_shiro_principal_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_shiro_user_2);
    _jspx_th_shiro_principal_1.setProperty("id");
    int _jspx_eval_shiro_principal_1 = _jspx_th_shiro_principal_1.doStartTag();
    if (_jspx_th_shiro_principal_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_shiro_principal_property_nobody.reuse(_jspx_th_shiro_principal_1);
      return true;
    }
    _jspx_tagPool_shiro_principal_property_nobody.reuse(_jspx_th_shiro_principal_1);
    return false;
  }

  private boolean _jspx_meth_shiro_principal_2(javax.servlet.jsp.tagext.JspTag _jspx_th_shiro_user_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:principal
    org.apache.shiro.web.tags.PrincipalTag _jspx_th_shiro_principal_2 = (org.apache.shiro.web.tags.PrincipalTag) _jspx_tagPool_shiro_principal_property_nobody.get(org.apache.shiro.web.tags.PrincipalTag.class);
    _jspx_th_shiro_principal_2.setPageContext(_jspx_page_context);
    _jspx_th_shiro_principal_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_shiro_user_2);
    _jspx_th_shiro_principal_2.setProperty("head");
    int _jspx_eval_shiro_principal_2 = _jspx_th_shiro_principal_2.doStartTag();
    if (_jspx_th_shiro_principal_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_shiro_principal_property_nobody.reuse(_jspx_th_shiro_principal_2);
      return true;
    }
    _jspx_tagPool_shiro_principal_property_nobody.reuse(_jspx_th_shiro_principal_2);
    return false;
  }

  private boolean _jspx_meth_shiro_principal_3(javax.servlet.jsp.tagext.JspTag _jspx_th_shiro_user_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:principal
    org.apache.shiro.web.tags.PrincipalTag _jspx_th_shiro_principal_3 = (org.apache.shiro.web.tags.PrincipalTag) _jspx_tagPool_shiro_principal_property_nobody.get(org.apache.shiro.web.tags.PrincipalTag.class);
    _jspx_th_shiro_principal_3.setPageContext(_jspx_page_context);
    _jspx_th_shiro_principal_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_shiro_user_2);
    _jspx_th_shiro_principal_3.setProperty("id");
    int _jspx_eval_shiro_principal_3 = _jspx_th_shiro_principal_3.doStartTag();
    if (_jspx_th_shiro_principal_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_shiro_principal_property_nobody.reuse(_jspx_th_shiro_principal_3);
      return true;
    }
    _jspx_tagPool_shiro_principal_property_nobody.reuse(_jspx_th_shiro_principal_3);
    return false;
  }

  private boolean _jspx_meth_shiro_principal_4(javax.servlet.jsp.tagext.JspTag _jspx_th_shiro_user_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:principal
    org.apache.shiro.web.tags.PrincipalTag _jspx_th_shiro_principal_4 = (org.apache.shiro.web.tags.PrincipalTag) _jspx_tagPool_shiro_principal_property_nobody.get(org.apache.shiro.web.tags.PrincipalTag.class);
    _jspx_th_shiro_principal_4.setPageContext(_jspx_page_context);
    _jspx_th_shiro_principal_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_shiro_user_2);
    _jspx_th_shiro_principal_4.setProperty("id");
    int _jspx_eval_shiro_principal_4 = _jspx_th_shiro_principal_4.doStartTag();
    if (_jspx_th_shiro_principal_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_shiro_principal_property_nobody.reuse(_jspx_th_shiro_principal_4);
      return true;
    }
    _jspx_tagPool_shiro_principal_property_nobody.reuse(_jspx_th_shiro_principal_4);
    return false;
  }

  private boolean _jspx_meth_shiro_principal_5(javax.servlet.jsp.tagext.JspTag _jspx_th_shiro_user_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:principal
    org.apache.shiro.web.tags.PrincipalTag _jspx_th_shiro_principal_5 = (org.apache.shiro.web.tags.PrincipalTag) _jspx_tagPool_shiro_principal_property_nobody.get(org.apache.shiro.web.tags.PrincipalTag.class);
    _jspx_th_shiro_principal_5.setPageContext(_jspx_page_context);
    _jspx_th_shiro_principal_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_shiro_user_2);
    _jspx_th_shiro_principal_5.setProperty("name");
    int _jspx_eval_shiro_principal_5 = _jspx_th_shiro_principal_5.doStartTag();
    if (_jspx_th_shiro_principal_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_shiro_principal_property_nobody.reuse(_jspx_th_shiro_principal_5);
      return true;
    }
    _jspx_tagPool_shiro_principal_property_nobody.reuse(_jspx_th_shiro_principal_5);
    return false;
  }

  private boolean _jspx_meth_shiro_principal_6(javax.servlet.jsp.tagext.JspTag _jspx_th_shiro_user_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:principal
    org.apache.shiro.web.tags.PrincipalTag _jspx_th_shiro_principal_6 = (org.apache.shiro.web.tags.PrincipalTag) _jspx_tagPool_shiro_principal_property_nobody.get(org.apache.shiro.web.tags.PrincipalTag.class);
    _jspx_th_shiro_principal_6.setPageContext(_jspx_page_context);
    _jspx_th_shiro_principal_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_shiro_user_2);
    _jspx_th_shiro_principal_6.setProperty("bio");
    int _jspx_eval_shiro_principal_6 = _jspx_th_shiro_principal_6.doStartTag();
    if (_jspx_th_shiro_principal_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_shiro_principal_property_nobody.reuse(_jspx_th_shiro_principal_6);
      return true;
    }
    _jspx_tagPool_shiro_principal_property_nobody.reuse(_jspx_th_shiro_principal_6);
    return false;
  }

  private boolean _jspx_meth_shiro_guest_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:guest
    org.apache.shiro.web.tags.GuestTag _jspx_th_shiro_guest_2 = (org.apache.shiro.web.tags.GuestTag) _jspx_tagPool_shiro_guest.get(org.apache.shiro.web.tags.GuestTag.class);
    _jspx_th_shiro_guest_2.setPageContext(_jspx_page_context);
    _jspx_th_shiro_guest_2.setParent(null);
    int _jspx_eval_shiro_guest_2 = _jspx_th_shiro_guest_2.doStartTag();
    if (_jspx_eval_shiro_guest_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t<div class=\"sider-login with-border\">\r\n");
        out.write("\t\t\t\t\t\t\t<p>尽收世上好物！</p>\r\n");
        out.write("\t\t\t\t\t\t\t<p class=\"sider-login-bottom\">\r\n");
        out.write("\t\t\t\t\t\t\t\t<a class=\"btn-v2\" href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("/register\">注册帐号</a>已有帐号，<a class=\"green\" href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("/login\">从这里登录</a>\r\n");
        out.write("\t\t\t\t\t\t\t</p>\r\n");
        out.write("\t\t\t\t\t\t</div>\r\n");
        out.write("\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_shiro_guest_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_guest_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_shiro_guest.reuse(_jspx_th_shiro_guest_2);
      return true;
    }
    _jspx_tagPool_shiro_guest.reuse(_jspx_th_shiro_guest_2);
    return false;
  }

  private boolean _jspx_meth_c_forEach_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent(null);
    _jspx_th_c_forEach_1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${likedUsers}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_1.setVar("user");
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<a href=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx }", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("/u/");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("/likes/\" target=\"_blank\"> <img src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.head}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" width=\"25\" height=\"25\" />\r\n");
          out.write("\t\t\t\t\t\t\t\t\t</a>\r\n");
          out.write("\t\t\t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_forEach_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_1.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_1);
    }
    return false;
  }

  private boolean _jspx_meth_fmt_formatDate_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatDate
    org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag _jspx_th_fmt_formatDate_1 = (org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag) _jspx_tagPool_fmt_formatDate_value_pattern_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag.class);
    _jspx_th_fmt_formatDate_1.setPageContext(_jspx_page_context);
    _jspx_th_fmt_formatDate_1.setParent(null);
    _jspx_th_fmt_formatDate_1.setValue((java.util.Date) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${product.create_time}", java.util.Date.class, (PageContext)_jspx_page_context, null));
    _jspx_th_fmt_formatDate_1.setPattern("yyyy-MM-dd hh:mm:ss");
    int _jspx_eval_fmt_formatDate_1 = _jspx_th_fmt_formatDate_1.doStartTag();
    if (_jspx_th_fmt_formatDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_formatDate_value_pattern_nobody.reuse(_jspx_th_fmt_formatDate_1);
      return true;
    }
    _jspx_tagPool_fmt_formatDate_value_pattern_nobody.reuse(_jspx_th_fmt_formatDate_1);
    return false;
  }
}
