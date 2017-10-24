<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<script type="text/javascript">
	function goBack() {
    window.history.go(-2)
}
</script>
<style type="text/css">
table {
	width: 100%;
	min-height: 200px;
	padding: 0px;
	border-collapse: collapse;
}

#link {
	background: #3498db;
	background-image: -webkit-linear-gradient(top, #3498db, #2980b9);
	background-image: -moz-linear-gradient(top, #3498db, #2980b9);
	background-image: -ms-linear-gradient(top, #3498db, #2980b9);
	background-image: -o-linear-gradient(top, #3498db, #2980b9);
	background-image: linear-gradient(to bottom, #3498db, #2980b9);
	-webkit-border-radius: 28;
	-moz-border-radius: 28;
	border-radius: 28px;
	-webkit-box-shadow: 0px 1px 3px #315fd4;
	-moz-box-shadow: 0px 1px 3px #315fd4;
	box-shadow: 0px 1px 3px #315fd4;
	font-family: Arial;
	color: #ffffff;
	font-size: 20px;
	padding: 10px 20px 10px 20px;
	text-decoration: none;
}

#link:hover {
	background: #3cb0fd;
	text-decoration: none;
}

html,body {
	margin: 0;
	padding: 0;
}

table {
	width: 100%;
	min-height: 200px;
	padding: 0px;
	border-collapse: collapse;
}

#spanbox2 {
	width: auto;
	height: auto;
	min-width: 75%;
	min-height: 75%;
	text-align: justify;
	padding: 40px;
	font-size: 2.4em;
	font-weight: normal;
	font-family: arial;
	letter-spacing: normal;
	line-height: 128%;
}

html,body {
	margin: 0;
	padding: 0;
}

#box2 {
	overflow-y: auto;
	overflow-x: hidden;
	background-color: white;
	min-width: 65%;
	width: 100%;
	height: 75%;
	min-height: 75%;
	display: block;
}

#longTitle {
	text-align: center;
	font-size: 5em;
	font-weight: bolder;
	font-family: arial;
}
</style>
</head>

<body>



	<div style="position: absolute; top: 5%; left: 40%;">
		<a href="javascript:history.back()" ><img align="left"
			src="images/previouspageicon.png" style="position: fixed;" alt="Back"
			width="250px" height="180px"></a>
	</div>


	<div style="background-color: white; height: 250px;"></div>

	<div id="box2">

		<c:if
			test="${requestScope.image ne null && !empty requestScope.image}">
			<div id="longTitle">${requestScope.title}</div>
		</c:if>

		<c:if
			test="${requestScope.image ne null && !empty requestScope.image}">
			<img id="longImage"
				style="display: block; margin-left: auto; margin-right: auto; margin-top: 20px; margin-bottom: 0; min-width: 12em; min-height: 12em; width: 800px; height: 600px;"
				src="${requestScope.image}" />
		</c:if>

		<!-- <div id="longDate" style="display:block;margin-left:auto;margin-right:auto;margin-top:0;margin-bottom:10px;width: 610px;color: gray;font-weight: bolder;font-family:Arial;font-size: 2.2em;"></div> -->

		<c:if test="${requestScope.description ne null && !empty requestScope.description}">
			<div id="spanbox2">${requestScope.description}</div>
		</c:if>

		<c:if test="${requestScope.shortDesc ne null && !empty requestScope.shortDesc}">
			<div id="spanbox2">${requestScope.shortDesc}</div>
		</c:if>
		
		<div style="background-color: white;"></div>
		<c:choose>
			<c:when
				test="${requestScope.link ne null && !empty requestScope.link }">
				<div id="div_link"
					style="width: 100%; display: block; height: 100px; background-color: white;">
					<center>

						<a href="${requestScope.link}"><INPUT id="link" TYPE="BUTTON"
							name="" VALUE="Apply Now"
							style="background-color: #00bfff; width: 200px; height: 50px; padding: 10px; display: block;" /></a>
					</center>


				</div>
			</c:when>
			<c:otherwise>
				<div id="div_link"
					style="width: 100%; display: none; height: 100px; background-color: white;">
					<center>

						<a style="text-decoration: none;" href="${requestScope.link}"><INPUT
							id="link" TYPE="BUTTON" name="" VALUE="Apply Now"
							style="background-color: #00bfff; width: 200px; height: 50px; padding: 10px; display: block;" /></a>
					</center>


				</div>
			</c:otherwise>
		</c:choose>


		<div style="width: 90%; height: 90%"></div>




	</div>
	<div style="background-color: white; height: 150px;"></div>

	<div id="bottombar">
		<img
			style="float: right; width: 180px; height: 70px; margin-right: 20px; padding: 10px;"
			align="right" src="images/poweredby_1.jpg" alt="Powered By HubCiti">
	</div>

</body>
</html>