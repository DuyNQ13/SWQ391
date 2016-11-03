<%-- 
    Document   : _Layout
    Created on : Nov 3, 2016, 6:10:42 AM
    Author     : Phong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <!--CSS-->
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/myTestCss.css" rel="stylesheet" type="text/css"/>
        <!--JS-->
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/jquery-3.1.1.js" type="text/javascript"></script>
        
        <title>Virtual MP3</title>
    </head>
    <body>
        <c:set var="url" value="${requestScope.contentUrl}"></c:set>
        <div class="container-fluid height300 simpleBG text-center">
            <h1>Head</h1>
        </div>
        
        
        <div>
            <!--MAIN CONTENT HERE-->
            <jsp:include page="${url}"></jsp:include>
        </div>
    </body>
</html>
