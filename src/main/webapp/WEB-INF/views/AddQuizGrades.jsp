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
		
		#right {
			width: 130px;
			padding: 0 10px;
			margin-right: -100%;
		}
		
		#footer {
		    position: relative;
		    margin-top: -180;
		    height: 80px;
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
		
		nav ul a {
			color: darkgreen;
			text-decoration: none;
		}

		#header, #footer {
			font-size: large;
			padding: 0.3em;
			background: #BCCE98;
		}

		#left {
			background: #DAE9BC;
		}
		
		#right {
			background: #F7FDEB;
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
            left: 50%;
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
    <spacer type="horizontal" width="100" height="100">.</spacer>

	<div id="container">
		<h1>Add Quiz Result</h1>
		<spacer type="horizontal" width="100" height="100"></spacer>
		<form action="<%= request.getContextPath()%>/AddQuizResultController" method="post">
		    <spacer type="horizontal" width="100" height="200">.</spacer>
		    
			<table style="width: 80%">
				<tr>
    				<td>Student Id</td>
    				<td><input type="text" name="studentId"/></td>
				</tr>
				<tr>
    				<td>Class/Grade</td>
    				<td><input type="text" name="grade"/></td>
				</tr>
				<tr>
    				<td>Parent NIC</td>
    				<td><input type="text" name="pnic"/></td>
				</tr>
				<tr>
    				<td>Letter Grade</td>
    				<td ALIGN="center">
						<select name="grade" align="left">
							<option value="Pass">Pass</option>
							<option value="Fail">Fail</option>
							<option value="A+">A+</option>
							<option value="A">A</option>
							<option value="A-">-A</option>
							<option value="B+">B+</option>
							<option value="B">B</option>
							<option value="B-">B-</option>
							<option value="C+">C+</option>
							<option value="C">C</option>
							<option value="C-">C-</option>
							<option value="D">D</option>
							<option value="I">I</option>
							<option value="W">W</option>
						</select>
					</td>
				</tr>
				<tr>
    				<td>Subject</td>
    				<td ALIGN="center">
						<select name="subject" align="left">
							<option value="English">English</option>
							<option value="Urdu">Urdu</option>
							<option value="Math">Maths</option>
							<option value="Science">Science</option>
							<option value="Religion">Religion</option>
							<option value="pEd">PEd</option>
							<option value="Geography">Geography</option>
							<option value="SocialStudies">Social Studies</option>
						</select>
					</td>
				</tr>
				<tr>
    				<td>Exam Type</td>
    				<td ALIGN="center">
						<select name="extype" align="left">
							<option value="SemesterI">SemesterI</option>
							<option value="SemesterII">SemesterII</option>
							<option value="SemesterIII">SemesterIII</option>
							<option value="SemesterIV">SemesterIV</option>
							<option value="midterm">Mid Term</option>
							<option value="Final">Final</option>
							<option value="Quiz">Quiz</option>
						</select>
				</tr>
				<tr>
    				<td>Exam Date (MM/DD/YYYY)</td>
    				<td><input type="text" name="exdate"/></td>
				</tr>
				
	   		</table>
	   		
			<input type="submit" value="Submit">
       </form>

	</div>
    
	<div id="footer-wrapper">
		<footer id="footer"><p style="font-style: italic;font-size:11px;">Equal Opportunity Institution:eSchool is an affirmative action/equal opportunity employer.</p></footer>
	</div>

</body>

</html>