<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<style type="text/css">
table {
	width: 100%;
	min-height: 200px;
	padding: 0px;
	border-collapse: collapse;
}

html,body {
	margin: 0;
	padding: 0;
}
</style>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".videos").click(function() {
			window.document.location = $(this).attr("href");
		});
	});
</script>


<script type="text/javascript">
	function replyVideos(clicked_id) {
		document.videoform.id.value = clicked_id;
		document.videoform.link.value = document.getElementById('link' + id).innerHTML;
		document.videoform.method = "POST";
		document.videoform.action = "videosdetail.htm";
		document.videoform.submit();

	}

	function reply_click(id) {


		document.newslistform.id.value = id;
		//alert(document.newslistform.id.value);
		document.newslistform.image.value = document.getElementById('image'
				+ id).src;
		document.newslistform.title.value = document.getElementById('title'
				+ id).innerHTML;
		document.newslistform.description.value = document
				.getElementById('desc' + id).innerHTML;
		//document.newslistform.link.value=document.getElementById('link'+id).innerHTML; 

		/* alert(document.newslistform.image.value)
		alert(document.newslistform.title.value);
		alert(document.newslistform.description.value);
		alert(document.newslistform.link.value); */
		document.newslistform.method = "POST";
		document.newslistform.action = "newsdetail.htm";
		document.newslistform.submit();
		/* var eleName = 'desc' + clicked_id;
		var eleLink = 'link' + clicked_id;
		var eleImage='imagee'+ clicked_id;
		var eleTitle='shortTitle'+clicked_id;
		var eleDate='shortDate'+clicked_id;
		
		document.getElementById('longTitle').innerHTML=document.getElementById(eleTitle).innerHTML;
		document.getElementById('longImage').src=document.getElementById(eleImage).src;
		/*  document.getElementById('longDate').innerHTML=document.getElementById(eleDate).innerHTML; */
		/*   if(document
		  		.getElementById(eleName).innerHTML !=null){
		  document.getElementById('spanbox2').innerHTML = document
		.getElementById(eleName).innerHTML;
		  }
		// document.getElementById('link').value = "Read Story";
		//document.getElementById('link').setAttribute("name" ,document.getElementById(eleLink).innerHTML); 
		  document.getElementById('box1').style.display = "none";
		document.getElementById('box2').style.display = "block";
		 */

	}

	function reply_clickemp(id) {

		document.newslistform.id.value = id;
		//alert(document.newslistform.id.value);
		//	document.newslistform.image.value= document.getElementById('image'+id).src;
		//document.newslistform.title.value= document.getElementById('title'+id).innerHTML;
		document.newslistform.description.value = document
				.getElementById('desc' + id).innerHTML;
		document.newslistform.link.value = document.getElementById('link' + id).innerHTML;
		//alert(document.newslistform.link.value);
		/* alert(document.newslistform.image.value)
		alert(document.newslistform.title.value);
		alert(document.newslistform.description.value);
		alert(document.newslistform.link.value); */
		document.newslistform.method = "POST";
		document.newslistform.action = "newsdetail.htm";
		document.newslistform.submit();

	}

	function reply_clickevents(clicked_id) {
		var eleName = 'desc' + clicked_id;
		var eleLink = 'link' + clicked_id;
		document.getElementById('spanbox2').innerHTML = document
				.getElementById(eleName).innerHTML;
		document.getElementById('link').style.display = "block";
		document.getElementById('link').value = "Event Details";
		document.getElementById('link').setAttribute("name",
				document.getElementById(eleLink).innerHTML);
		document.getElementById('box1').style.display = "none";
		document.getElementById('box2').style.display = "block";

	}

	function goback() {
		document.feedTypeForm.goback.method = "GET";
		document.feedTypeForm.goback.action = "frontpage.htm";
		document.feedTypeForm.goback.submit();
	}

	function click_button() {
		document.getElementById('box2').style.display = "none";
		document.getElementById('box1').style.display = "block";
	}

	function testOrientation() {
		document.getElementById('block_land').style.display = (screen.width > screen.height) ? 'block'
				: 'block';
	}
</script>

<style type="text/css">
@media only screen and (min-device-width: 768px) and (max-device-width:
	1024px) and (orientation:portrait) {
	orienCss {
		-webkit-transform: rotate(90deg);
		width: 100%;
		height: 100%;
		overflow: hidden;
		position: absolute;
		top: 0;
		left: 0;
	}
}

#box1 {
	overflow-x: auto;
	overflow-y: auto;
	background-color: white;
	min-width: 75%;
	min-height: 75%;
	height: 100%;
	width: 100%;
}

#box2 {
	overflow-y: auto;
	overflow-x: hidden;
	background-color: white;
	min-width: 75%;
	width: 100%;
	height: 100%;
	min-height: 75%;
	display: none;
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
	margin: 0px;
	padding: 0px;
	overflow: auto;
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

.btn {
	padding: 15px;
	background: #3498db;
	background-image: -webkit-linear-gradient(top, #3498db, #2980b9);
	background-image: -moz-linear-gradient(top, #3498db, #2980b9);
	background-image: -ms-linear-gradient(top, #3498db, #2980b9);
	background-image: -o-linear-gradient(top, #3498db, #2980b9);
	background-image: linear-gradient(to bottom, #3498db, #2980b9);
	-webkit-border-radius: 19;
	-moz-border-radius: 19;
	border-radius: 19px;
	font-family: Arial;
	text-align: center;
	color: #ffffff;
	width: 100%;
	float: right;
	font-size: 40px;
	text-decoration: none;
}

.btn:hover {
	background: #3cb0fd;
	text-decoration: none;
}

.close:hover {
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0.05, #378de5
		), color-stop(1, #79bbff));
	background: -moz-linear-gradient(center top, #378de5 5%, #79bbff 100%);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#378de5',
		endColorstr='#79bbff');
	background-color: #378de5;
}

.close:active {
	position: relative;
	top: 1px;
}

.highLightErr {
	color: #FF0000 !important;
	padding: 30px 30px 30px 30px;
}

#div_link {
	padding: 30px;
}

#longTitle {
	text-align: center;
	font-size: 5em;
	font-weight: bolder;
	font-family: arial;
}

#loading {
	width: 100%;
	height: 100%;
	top: 0px;
	left: 0px;
	position: fixed;
	display: block;
	z-index: 99
}

#loading-image {
	position: absolute;
	top: 40%;
	left: 45%;
	z-index: 100
}
</style>
</head>

<body>


	<%-- 	<div id="box2">

<div style="float: right;margin-right:15px;margin-top: 15px;margin-bottom: 15px;" ><!-- <span class="btn" onclick="click_button()" >x</span><span style="font-size: 1.6em;font-weight: bolder;color:#3498db;cursor:pointer;text-align: center;" onclick="click_button()" >CLOSE</span> --><img src="images/close.png"  onclick="click_button()" alt="Back" width="100px" height="100px;"></div>
<div style="background-color: white;height:150px;"></div>


<div id="longTitle"  ></div>
	
<img id="longImage" style="display:block;margin-left:auto;margin-right:auto;margin-top:20px;margin-bottom:0;min-width: 12em;min-height:12em;width:800px;height:600px;"
							src=""/>
<!-- <div id="longDate" style="display:block;margin-left:auto;margin-right:auto;margin-top:0;margin-bottom:10px;width: 610px;color: gray;font-weight: bolder;font-family:Arial;font-size: 2.2em;"></div> -->
           <div id="spanbox2"></div>
           
           <div style="background-color: white;"></div>
			
			<div id="div_link" style="width: 100%;display:none;height:100px;background-color: white;display: none;">
			<center>
			<INPUT   id="link" TYPE="BUTTON" name="" VALUE="" onclick="window.open(name, 'windowName' ); return false" style="background-color:#00bfff;width: 200px;height:50px;padding: 10px;display: none;" />
			</center>
			
			
			</div>
			
			
	<div style="width: 90%;height: 90%"></div>		
		


		</div> --%>

	<div id="box1">





		<c:choose>

			<c:when
				test="${sessionScope.videosList ne null && !empty sessionScope.videosList}">
				<div style="position: absolute; top: 5%; left: 40%;">
					<a href="javascript:history.back()"><img align="left"
						src="images/previouspageicon.png" style="position: fixed;"
						alt="Back" width="250px" height="180px"></a>
				</div>
				<div style="background-color: white; height: 250px;"></div>
				<form name="videoform" commandName="videoform">
					<input type="hidden" name="id"> <input type="hidden"
						name="link">
				</form>
				<table cellpadding="8px" style="height: 200px; min-height: 200px;">

					<c:forEach var="listValue" items="${sessionScope.videosList}">





						<%-- <tr  style="background-color: gray;color: white;padding: 10px;" id="${listValue.id}"><td colspan="5" style="font-weight: bolder;font-size: 1.2em;font-family: arial;">${entry.key}</td></tr> --%>



						<%-- <c:choose> --%>
						<%-- <c:when test="${listValue.image ne null && !empty listValue.image}"> --%>

						<tr id="${listValue.id}"
							onclick='location.href="${listValue.link}"'
							style="border-bottom: 1px solid gray; cursor: pointer;"
							style="margin:0;padding:0;margin-bottom:4px;">



							<td colspan="3" style="height: 250px; width: 250px;"><img
								id="image${listValue.id}"
								style="height: 200px; display: block; margin: 4px; width: 100%; min-width: 12em; min-height: 12em;"
								src="images/newsfeed_noimage.jpg" /></td>


							<td colspan="2" id="title${listValue.id}"
								style="vertical-align: middle; font-size: 1.8em; padding: 8px; font-family: arial; text-align: justify;">${listValue.title}<br />
							<br /> <c:if
									test="${listValue.shortDesc ne null && !empty listValue.shortDesc }">

									<span
										style="font-size: 0.9em; font-weight: normal; color: gray; display: block;">${listValue.shortDesc}</span>
								</c:if>



							</td>


							<td><img style="float: right;" src="images/arrow.png" /></td>
							<td id="link${listValue.id}" style="display: none;">${listValue.link}</td>
						</tr>

						<!-- <tr style="border-bottom:1px solid gray;" > -->
						<%-- <td colspan="5"  id="link${listValue.id}" style="display: none;">
				<a href="${listValue.link}" id="url${listValue.id}" >
				<!-- <input style="cursor:pointer;text-decoration: none;font-size: 1.6em;font-family: Arial;font-weight: bold;" type="button" value="View Video" size="20"></a> -->
				</td></a> --%>
						<!-- </tr> -->
						<!-- 					onclick="window.open(href, 'windowName' ); return false" -->



						<%-- 	</c:when>
				
				<c:otherwise>
				
					<tr  style="background-color: gray;color: white;padding: 10px;" id="${listValue.id}"><td colspan="5" style="font-weight: bolder;font-size: 1.2em;font-family: arial;">${listValue.date}</td></tr>
				
				<tr id="${listValue.id}" style="margin-bottom:4px;padding:0;"
					onclick="reply_click(this.id)">
					<td colspan="3"  style="height:200px;" ><img id="image${listValue.id}"  style="height: 200px;display:block;margin: 4px; width:100%;min-width: 12em;min-height:12em;"
							src="/images/newsfeed_noimage.jpg"/></td>
				<td colspan="2" id="title${listValue.id}" style="vertical-align:middle;height:100px;font-size: 1.8em;padding:8px;font-family:arial;text-align: justify;">${listValue.title}</td>
				
				<!-- <td ><img style="float:right;" src="images/arrow.png" /></td> -->
				</tr>
				
				<tr style="border-bottom:1px solid gray;"><td   colspan="5"  style="border-bottom: 1px solid gray;" id="link${listValue.id}"><a style="cursor:pointer;text-decoration: none;font-size: 1.6em;font-family: cursive;font-weight: bold;" href="${listValue.link}" id="url${listValue.id}">View Video</a></td><td id="desc${listValue.id}" style="display: none;">${listValue.description}</td></tr>
				
				</c:otherwise>
				</c:choose> --%>

					</c:forEach>


					<!--	onclick="window.open(href, 'windowName' ); return false" -->








				</table>
			</c:when>

















			<c:when
				test="${sessionScope.employmentList ne null && !empty sessionScope.employmentList}">
				<div style="position: absolute; top: 5%; left: 40%;">
					<a href="javascript:history.back()"><img align="left"
						src="images/previouspageicon.png" style="position: fixed;"
						alt="Back" width="250px" height="180px"></a>
				</div>
				<div style="background-color: white; height: 250px;"></div>
				<form name="newslistform" commandName="newslistform">
					<input type="hidden" name="id" /> <input type="hidden"
						name="title" /> <input type="hidden" name="description" /> <input
						type="hidden" name="link" />
				</form>


				<table cellpadding="8px" style="height: 200px; min-height: 200px;">

					<c:forEach var="listValue" items="${sessionScope.employmentList}">


						<tr id="${listValue.id}"
							style="cursor: pointer; margin-bottom: 4px; padding: 0; border-bottom: 1px solid gray;"
							onclick="reply_clickemp(this.id)">
							<td colspan="4" id="title${listValue.id}"
								style="vertical-align: middle; height: 100px; text-align: justify; font-size: 1.8em; padding: 8px; font-family: arial">${listValue.title}</td>

							<td><img style="float: right;" src="images/arrow.png" /></td>
							<td id="desc${listValue.id}" style="display: none;">${listValue.description}</td>
							<td id="link${listValue.id}" style="display: none;">${listValue.link}</td>
						</tr>












					</c:forEach>
				</table>
			</c:when>



			<c:when
				test="${sessionScope.realestateList ne null && !empty sessionScope.realestateList}">
				<div style="position: absolute; top: 5%; left: 40%;">
					<a href="javascript:history.back()"><img align="left"
						src="images/previouspageicon.png" style="position: fixed;"
						alt="Back" width="250px" height="180px"></a>
				</div>
				<div style="background-color: white; height: 250px;"></div>
				<table cellpadding="8px" style="height: 200px; min-height: 200px;">

					<c:forEach var="listValue" items="${sessionScope.realestateList}">


						<tr
							style="margin-bottom: 4px; padding: 0; border-bottom: 1px solid gray;">


							<td colspan="4" id="title"
								style="vertical-align: middle; height: 100px; text-align: justify; font-size: 1.8em; padding: 16px; font-family: arial">${listValue.title}</td>

							<!-- <td ><img style="float:right;" src="images/arrow.png" /></td> -->

						</tr>

						<%-- <tr style="margin-bottom:4px;padding:0;border-bottom:1px solid gray;">
					
					<td colspan="1"  style="color: red;font-weight: bolder;font-size: 1.8em;padding:8px;font-family:arial;" >Start Date :</td>
				<td colspan="1" id="title" style="padding:8px;font-family:arial;color: red;font-weight: bolder;font-size: 1.8em;">${listValue.startDate}</td>
				
				<td colspan="1" id="title" style="padding:8px;font-family:arial;color: red;font-weight: bolder;font-size: 1.8em;">End Date :</td>
				<td colspan="1" id="title" style="padding:8px;font-family:arial;color: red;font-weight: bolder;font-size: 1.8em;">${listValue.endDate}</td>
				
				
				</tr>
				 --%>












					</c:forEach>
				</table>
			</c:when>



































			<c:when
				test="${sessionScope.eventsList ne null && !empty sessionScope.eventsList}">

				<table cellpadding="8px" style="height: 200px; min-height: 200px;">
					<c:forEach var="listValue" items="${sessionScope.eventsList}">


						<tr id="${listValue.id}"
							style="cursor: pointer; margin-bottom: 4px; padding: 0; border-bottom: 1px solid gray;"
							onclick="reply_clickevents(this.id)">
							<td colspan="4" id="title${listValue.id}"
								style="vertical-align: middle; height: 100px; font-size: 1.8em; padding: 8px; font-family: arial; text-align: justify;">${listValue.title}</td>

							<td><img style="float: right;" src="images/arrow.png" /></td>
							<td id="desc${listValue.id}" style="display: none;">${listValue.description}</td>
							<td id="link${listValue.id}" style="display: none;">${listValue.link}</td>
						</tr>














					</c:forEach>
				</table>
			</c:when>





			<c:when
				test="${sessionScope.itemsList ne null && !empty sessionScope.itemsList}">
				<div style="position: absolute; top: 5%; left: 40%;">
					<a href="javascript:history.back()"><img align="left"
						src="images/previouspageicon.png" style="position: fixed;"
						alt="Back" width="250px" height="180px"></a>
				</div>
				<div style="background-color: white; height: 250px;"></div>
				
				<form name="newslistform" commandName="newslistform">
					<input type="hidden" name="id" /> 
					<input type="hidden" name="image" /> 
					<input type="hidden" name="title" /> 
					<input type="hidden" name="description" />
					<input type="hidden" name="shortDesc" />  
					<input type="hidden" name="link" />
			
				
				<table cellpadding="8px" style="height: auto; min-height: auto;">
				
								<!-- for displaying first 12 top news -->
					<c:if test="${sessionScope.topList ne null && !empty sessionScope.topList}">


						<c:forEach var="listValue" items="${sessionScope.topList}">
						
							
							<c:choose>
								<c:when
									test="${listValue.imagePath ne null && !empty listValue.imagePath}">
									<tr id="${listValue.id}" style="cursor: pointer; margin: 0px; padding: 0px; margin-bottom: 4px; border-bottom: 1px solid gray;"
										onclick="reply_click(this.id)">
										<td id="shortDate${listValue.id}" style="display: none;">${entry.displayDate}</td>
										<td style="height: 250px; width: 250px"><img
											id="image${listValue.id}" style="display: block; height: 240px; width: 240px; margin: 4px; min-width: 12em; min-height: 12em;"
											src="${listValue.imagePath}" /></td>
										<td colspan="2"
											style="vertical-align: middle; text-align: justify; font-size: 2.0em; padding: 8px; font-family: arial; font-weight: bolder;"><span
											id="title${listValue.id}">${listValue.title}</span><br />
										<br /> <span style="font-size: 0.9em; font-weight: normal; color: gray; display: block;">${listValue.shortDesc}</span></td>
										<td colspan="1"><img style="float: right;" src="images/arrow.png" /></td>
										<td id="desc${listValue.id}" style="display: none;">${listValue.description}</td>
										<td id="link${listValue.id}" style="display: none;">${listValue.link}</td>

										<%-- <td><img id="imagee${listValue.id}" style="display:none;margin: 4px;min-width: 12em;min-height: 12em; "
							src="${listValue.image}"/></td>
				<td  id="shortTitle${listValue.id}" style="display: none;">${listValue.title}</td>
				<td  id="desc${listValue.id}" style="display: none;">${listValue.description}</td>
				<td id="link${listValue.id}" style="display: none;">${listValue.link}</td> --%>
									</tr>

								</c:when>

								<c:otherwise>
									<tr id="${listValue.id}"
										style="cursor: pointer; margin: 0px; padding: 0px; margin-bottom: 4px; border-bottom: 1px solid gray;"
										onclick="reply_click(this.id)">



										<td id="shortDate${listValue.id}" style="display: none;">${entry.displayDate}</td>



										<td style="height: 250px; width: 250px"><img
											id="image${listValue.id}"
											style="display: block; height: 240px; width: 240px; margin: 4px; min-width: 12em; min-height: 12em;"
											src="images/newsfeed_noimage.jpg" /></td>
										<td colspan="2"
											style="vertical-align: middle; text-align: justify; font-size: 2.0em; padding: 8px; font-family: arial; font-weight: bolder;"><span
											id="title${listValue.id}">${listValue.title}</span><br />
										<br />
										<span
											style="font-size: 0.9em; font-weight: normal; color: gray;">${listValue.shortDesc}</span></td>

										<td colspan="1"><img style="float: right;"
											src="images/arrow.png" /></td>
										<td id="link${listValue.id}" style="display: none;">${listValue.link}</td>
										<%-- <td><img id="imagee${listValue.id}" style="display:none;margin: 4px;min-width: 12em;min-height: 12em;"
							src="images/newsfeed_noimage.jpg"/></td>
				<td  id="shortTitle${listValue.id}" style="display: none;">${listValue.title}</td> --%>
										<td id="desc${listValue.id}" style="display: none;">${listValue.description}</td>
										<%-- <td id="link${listValue.id}" style="display: none;">${listValue.link}</td> --%>
									</tr>

								</c:otherwise>
							</c:choose>
						</c:forEach>
				</c:if>
					
					<!-- for other news group by date -->
				
				
					<c:forEach var="entry" items="${sessionScope.itemsList}">

						<tr style="background-color: gray; color: white; padding: 10px;">
							<td colspan="5"
								style="font-weight: bolder; font-size: 1.8em; font-family: arial;">${entry.displayDate}</td>
						</tr>

						<c:forEach var="listValue" items="${entry.itemLst}">
							<c:choose>
								<c:when
									test="${listValue.imagePath ne null && !empty listValue.imagePath}">
									<tr id="${listValue.id}" style="cursor: pointer; margin: 0px; padding: 0px; margin-bottom: 4px; border-bottom: 1px solid gray;"
										onclick="reply_click(this.id)">
										<td id="shortDate${listValue.id}" style="display: none;">${entry.displayDate}</td>
										<td style="height: 250px; width: 250px"><img
											id="image${listValue.id}" style="display: block; height: 240px; width: 240px; margin: 4px; min-width: 12em; min-height: 12em;"
											src="${listValue.imagePath}" /></td>
										<td colspan="2"
											style="vertical-align: middle; text-align: justify; font-size: 2.0em; padding: 8px; font-family: arial; font-weight: bolder;"><span
											id="title${listValue.id}">${listValue.title}</span><br />
										<br /> <span style="font-size: 0.9em; font-weight: normal; color: gray; display: block;">${listValue.shortDesc}</span></td>
										<td colspan="1"><img style="float: right;" src="images/arrow.png" /></td>
										<td id="desc${listValue.id}" style="display: none;">${listValue.description}</td>
										<td id="link${listValue.id}" style="display: none;">${listValue.link}</td>

										<%-- <td><img id="imagee${listValue.id}" style="display:none;margin: 4px;min-width: 12em;min-height: 12em; "
							src="${listValue.image}"/></td>
				<td  id="shortTitle${listValue.id}" style="display: none;">${listValue.title}</td>
				<td  id="desc${listValue.id}" style="display: none;">${listValue.description}</td>
				<td id="link${listValue.id}" style="display: none;">${listValue.link}</td> --%>
									</tr>

								</c:when>

								<c:otherwise>
									<tr id="${listValue.id}"
										style="cursor: pointer; margin: 0px; padding: 0px; margin-bottom: 4px; border-bottom: 1px solid gray;"
										onclick="reply_click(this.id)">



										<td id="shortDate${listValue.id}" style="display: none;">${entry.displayDate}</td>



										<td style="height: 250px; width: 250px"><img
											id="image${listValue.id}"
											style="display: block; height: 240px; width: 240px; margin: 4px; min-width: 12em; min-height: 12em;"
											src="images/newsfeed_noimage.jpg" /></td>
										<td colspan="2"
											style="vertical-align: middle; text-align: justify; font-size: 2.0em; padding: 8px; font-family: arial; font-weight: bolder;"><span
											id="title${listValue.id}">${listValue.title}</span><br />
										<br />
										<span
											style="font-size: 0.9em; font-weight: normal; color: gray;">${listValue.shortDesc}</span></td>

										<td colspan="1"><img style="float: right;"
											src="images/arrow.png" /></td>
										<td id="link${listValue.id}" style="display: none;">${listValue.link}</td>
										<%-- <td><img id="imagee${listValue.id}" style="display:none;margin: 4px;min-width: 12em;min-height: 12em;"
							src="images/newsfeed_noimage.jpg"/></td>
				<td  id="shortTitle${listValue.id}" style="display: none;">${listValue.title}</td> --%>
										<td id="desc${listValue.id}" style="display: none;">${listValue.description}</td>
										<%-- <td id="link${listValue.id}" style="display: none;">${listValue.link}</td> --%>
									</tr>

								</c:otherwise>
							</c:choose>
						</c:forEach>
					</c:forEach>








					<%--  </c:when>
				
				<c:otherwise>
				
					<c:forEach var="listValue" items="${itemsList['key']}">
				
				
				
				<tr id="${listValue.id}" style="cursor: pointer;margin-bottom:4px;padding:0;border-bottom:1px solid gray;"
					onclick="reply_click(this.id)">
					
					 <td style="height:240px;width:240px;" ><img id="image${listValue.id}" style="display:block;margin: 4px;height:240px;width: 240px;min-width: 12em;min-height: 12em;"
							src="images/newsfeed_noimage.jpg" align="middle"/></td>
				<td colspan="2" id="title${listValue.id}" style="vertical-align:middle;text-align: justify;font-size: 2.0em;padding:8px;font-family: arial;font-weight: bolder;">${listValue.title}<br/><br/><span style="font-size: 0.9em;font-weight: normal;color:gray;">${listValue.shortDesc}</span></td>
				
				<td colspan="1"><img style="float:right;" src="images/arrow.png" /></td>
			    <td><img id="imagee${listValue.id}" style="display:none;margin: 4px;min-width: 12em;min-height: 12em;"
							src="images/newsfeed_noimage.jpg" align="middle"/></td>
				<td  id="shortDate${listValue.id}" style="display: none;">${listValue.date}</td>
				<td  id="shortTitle${listValue.id}" style="display: none;">${listValue.title}</td>
				<td id="desc${listValue.id}" style="display: none;">${listValue.description}</td>
				<td id="link${listValue.id}" style="display: none;">${listValue.link}</td>
				</tr>
				</c:forEach>
				
				</c:otherwise>
				
				
				</c:choose> --%>










					<%-- </c:forEach> --%>


				</table>

			</c:when>


		</c:choose>



		<c:if
			test="${requestScope.feedmessage ne null && !empty requestScope.feedmessage}">
			<span class="highLightErr"><c:out
					value="${requestScope.feedmessage}"></c:out></span>

		</c:if>






		<div id="bottombar">
			<img
				style="float: right; width: 180px; height: 70px; margin-right: 20px; padding: 10px;"
				align="right" src="images/poweredby_1.jpg" alt="Powered By HubCiti">
		</div>
	</div>






	<!-- </div> -->

	<!-- <div onclick="goback()" style="background-color: white;float: right;width:10%;height:10%;margin-right:15px;margin-top: 15px;" ><span id="back" onclick="goback()" style="padding: 15px" >Back</span> -->

	<!-- </div> -->




</body>
</html>
