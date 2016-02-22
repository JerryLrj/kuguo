<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <title>欢迎加入</title>
        <link media="all" rel="stylesheet" type="text/css" href="${ctx}/static/styles/register.css" />
        <script type="text/javascript">
        if (window.ActiveXObject) {
            var ua = navigator.userAgent.toLowerCase();
            var ie=ua.match(/msie ([\d.]+)/)[1]
            if(ie==6.0)
                location.href = "/ie6/";
        }
        </script>
    </head>
    <body>
        <div id="wrapper">
            <div id="main">
                <div class="rlcontainer">
                    <div class="top">
                        <div class="big_logo">
                            <a href="${ctx }/selected/">
                                <img src="${ctx}/static/images/logo.jpg"/>
                            </a>
                        </div>
                        <form action="${ctx}/register/" class="rl-form" id="sign-in-up-form" method="post" enable="true">
                            <div class="content">
                                <p>
                                    <b>注册一个新的帐号</b> | 已有帐号？ 
                                    <a href="${ctx}/login" class="green">请登录</a>
                                </p>
                                <div class="row">
                                    <label>昵称</label>
                                   <input name="name" type="text" value="" placeholder="昵称"/><br />
                                </div>
                                <div class="row">
                                    <label>邮箱（用于登录）</label>
                                    <input name="email" type="text" value="" placeholder="邮箱（用于登录）"/><br />
                                </div>
                                <div class="row">
                                    <label>密码（至少 6 位数字或字母）</label>
                                    <input name="plainPassword" type="password" value="" placeholder="密码（至少 6 位数字或字母）"/><br />
                                </div>
                                <input type="checkbox" checked="checked"/>
                                <span>同意<a href="/agreement/">《使用协议》</a></span>
                                <input type="submit" value="注册" class="btn-v2 ml80" />
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div id="footer">
                <div class="footer-container">
                    <span>京ICP备11036615号-1 京公网安备11010502019958</span>
                    <ul class="footer-items">
                        <li><a href="http://itunes.apple.com/cn/app/id477652209?mt=8" target="_blank" bi="download_iphone">iPhone</a></li>
                        <li><a href="http://itunes.apple.com/cn/app/id450507565?mt=8" target="_blank" bi="download_ipad">iPad</a></li>
                        <li><a href="http://app.guoku.com/android/latest/guoku.apk" target="_blank" bi="download_android">Android</a></li>
                        <li><a href="mailto:rujie.liu@qq.com" alt="Keep in touch :)">邮件反馈</a></li>
                        <li><a href="http://www.weibo.com/guoku" target="_blank" bi="sina">新浪微博</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <script type="text/javascript" src="${ctx}/static/jquery/jquery.min.js"></script>
        <script type="text/javascript" src="${ctx}/static/jquery-validation/1.10.0/jquery.validate.min.js"></script>
        <script type="text/javascript" src="${ctx}/static/js/main.js"></script>
    </body> 
</html>
