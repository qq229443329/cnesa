<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'user.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <script type="application/javascript" src="script/jquery-3.1.1.min.js"></script>
    <script type="application/javascript" src="script/socketjs/sockjs.min.js"></script>
    <script type="application/javascript" src="script/socketjs/stomp.min.js"></script>
    <script type="application/javascript">
//       (function connect() {
//            var socket = new SockJS("http://esp.esonline.cn:9000" + '/ws');
//            stompClient = Stomp.over(socket);
//            stompClient.connect({}, function (frame) {
//                stompClient.subscribe('/topic/PEK_LQGC/alarmInfo.*', function (data) {
//                    console.log("-----"+data);
//                    var tempMsg = JSON.parse(data.body);
//                    console.log(tempMsg)
//
//                });
//            });
//
//        })();
     function test() {
         $.ajax({
             type: "POST",
             url: "http://localhost:8080/portal/contrastAnalysis/selectContrastData/a9be38fc-54a1-4760-8f58-ce5fcd8a6f95,3404e57d-2168-4ceb-a2ec-96ae459cd17a",
             contentType:"application/json",
             data:JSON.stringify({attrCode: "Pz", timeType: "year", dateTime: "2016", contrastTime: "2017"}),
             success: function(data){
                 console.log(data)
             }
         });

     }

//function test() {
//    $.ajax({
//        type: "post",
//        url: "http://localhost:8080/portal/realTimeData/getRealTimeData",
//        contentType:"application/json",
//        data:JSON.stringify({solekey: "PEK#LQGC#DB600170060000#Ia", dataType: "year"}),
//        //     data:"timeType=day&&dateTime=2017-05-26&&monitorId=e9597fe4-28a1-11e7-93ae-92361f002671",
//        success: function(data){
//            console.log(data)
//        }
//    });
//}

    </script>
</head>
    <body>
        <h2>esonline1111</h2>
        <div><a href="/user/index">多数据源实例1</a> </div>
        <div><a href="/message/index">消息接收、推送</a></div>
        <div><a href="/message/socket">socket</a></div>

        Welcome<br/>
        <input id="text" type="text"/>
        <button onclick="send()">发送消息</button>
        <hr/>
        <button onclick="closeWebSocket()">关闭WebSocket连接</button>
        <hr/>
        <div id="message"></div>
        <%--<script type="text/javascript">--%>
            <%--var websocket = null;--%>
            <%--//判断当前浏览器是否支持WebSocket--%>
            <%--if ('WebSocket' in window) {--%>
                <%--websocket = new WebSocket("ws://localhost:8090/portal/userStatusListen/");--%>
            <%--}--%>
            <%--else {--%>
                <%--alert('当前浏览器 Not support websocket')--%>
            <%--}--%>

            <%--//连接发生错误的回调方法--%>
            <%--websocket.onerror = function () {--%>
                <%--setMessageInnerHTML("WebSocket连接发生错误");--%>
            <%--};--%>

            <%--//连接成功建立的回调方法--%>
            <%--websocket.onopen = function () {--%>
                <%--setMessageInnerHTML("WebSocket连接成功");--%>
            <%--}--%>

            <%--//接收到消息的回调方法--%>
            <%--websocket.onmessage = function (event) {--%>
                <%--setMessageInnerHTML(event.data);--%>
            <%--}--%>

            <%--//连接关闭的回调方法--%>
            <%--websocket.onclose = function () {--%>
                <%--setMessageInnerHTML("WebSocket连接关闭");--%>
            <%--}--%>

            <%--//监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。--%>
            <%--window.onbeforeunload = function () {--%>
                <%--closeWebSocket();--%>
            <%--}--%>

            <%--//将消息显示在网页上--%>
            <%--function setMessageInnerHTML(innerHTML) {--%>
                <%--document.getElementById('message').innerHTML += innerHTML + '<br/>';--%>
            <%--}--%>

            <%--//关闭WebSocket连接--%>
            <%--function closeWebSocket() {--%>
                <%--websocket.close();--%>
            <%--}--%>

            <%--//发送消息--%>
            <%--function send() {--%>
                <%--var message = document.getElementById('text').value;--%>
                <%--websocket.send(message);--%>
            <%--}--%>
        <%--</script>--%>
        <input type="button" value="POST_TEST" onclick="test()"/>
   </body>
</html>