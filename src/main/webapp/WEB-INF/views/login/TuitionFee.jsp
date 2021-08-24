<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to e-School Learning at VU</title>
<style type="text/css">
/* Layout */
		body {
			min-width: 630px;
		}

		#container {
			padding-left: 200px;
			padding-right: 190px;
		}
		
		#container .column {
			position: relative;
			float: left;
		}
		
        #container .row {
			position: relative;
			float: right;
		}
		#center {
			padding: 10px 20px;
			width: 100%;
		}
		
		#left {
			width: 180px;
			padding: 0 10px;
			right: 240px;
			margin-left: -100%;
		}
		#myLeft2 {
			
			background-color: #DCDCDC;
			
		}
		#myLeft {
			
			curser: pointer;
			font-size: 16px;
			margin-left: -73%;
		}
#right {
			width: 130px;
			padding: 0 10px;
			margin-right: -100%;
		}
		
		#footer {
			clear: both;
		}
		
		/* IE hack */
		* html #left {
			left: 150px;
		}

		/* Make the columns the same height as each other */
		#container {
			overflow: hidden;
		}

		#container .column {
			padding-bottom: 1001em;
			margin-bottom: -1000em;
		}

		/* Fix for the footer */
		* html body {
			overflow: hidden;
		}
		
		* html #footer-wrapper {
			float: left;
			position: relative;
			width: 100%;
			padding-bottom: 10010px;
			margin-bottom: -10000px;
			background: #fff;
		}
		/* Aesthetics */
		body {
			margin: 0;
			padding: 0;
			font-family:Sans-serif;
			line-height: 1.5em;
		}
		
		p {
			color: #555;
		}

		nav ul {
			list-style-type: none;
			margin: 0;
			padding: 0;
		}
		
		#center {
			background: #fff;
		}

		#container .column {
			padding-top: 1em;
		}
		
        #header-image-menu{
            top: 10px;
            position: relative;
        }
 
        #header-image-menu img{
            width: 100%;
            margin: none;
            padding: none;
        }
 
        #image-text{
            position: absolute;
            top: 20%;
            left: 55%;
            font-family: 'Roboto';
            color: #000;
            transform: translate(-30%, -30%);
            text-align: center;
        }
	</style>
</head>
<body>
	<header id="header">
		
	
<!-- Image menu in Header to contain an Image and
		a sample text over that image -->
	<div id="header-image-menu">
		<img src="https://www.vu.edu.pk/images/home/Sliders/banner3.jpg">
		<h2 id = "image-text">
			Virtual University Project e-School
		</h2>
	</div>
</header>
<div  align="center">
<h1>Tuition Fee Details </h1>
<form action="<%= request.getContextPath()%>/EnrhServlet" method="post">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table id="myLeft2" border="1" style="width: 80%">
    <tr>
   		<th>Grades</th>
   		<th>Fee</th>
   		<th>MiscFee</th>
   		<th>TuitionFeeRemark</th>
   		<th>PayDueDate</th>
   		
   	</tr>
   	<c:forEach items="${requestScope.fees}" var="fee">
	    <tr>
		    <td><c:out value="${fee.grades}"></c:out></td>
		    <td><c:out value="${fee.fee}"></c:out></td>
		    <td><c:out value="${fee.miscFee}"></c:out></td>
		    <td><c:out value="${fee.tuitionFeeRemark}"></c:out></td>
		    <td><c:out value="${fee.payDueDate}"></c:out></td>
		    
	    </tr>
   
   </c:forEach>
</table>
   	
		<spacer type="horizontal" width="100" height="100"><></spacer>
   
	</form>
</div>
</body>
</html>
