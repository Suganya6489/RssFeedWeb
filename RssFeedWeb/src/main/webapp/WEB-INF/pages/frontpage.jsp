<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
<!-- <meta name="viewport" content="width=device-width, initial-scale=0, maximum-scale=0, user-scalable=no" /> -->
<%@page contentType="text/html;charset=UTF-8"%>
<title>frontpage</title>


<script type="text/javascript">
	//This method is used to call feed list page.
	
	function reply_clickEmp(id){
	document.getElementById("loading").style.display = 'inline' ;
		document.frontpageform.feedType.value = id;
		document.frontpageform.method = "GET";
		document.frontpageform.action = "employment.htm";
		document.frontpageform.submit();
	}
	function reply_click(id) {
	document.getElementById("loading").style.display = 'inline' ;
		document.frontpageform.feedType.value = id;
		document.frontpageform.method = "GET";
		document.frontpageform.action = "home.htm";
		document.frontpageform.submit();
	}
	
	function reply_clickTop(id) {
	document.getElementById("loading").style.display = 'inline' ;
		document.frontpageform.feedType.value = id;
		document.frontpageform.method = "GET";
		document.frontpageform.action = "combineFeeds.htm";
		document.frontpageform.submit();
	}

	function reply_videos(id) {
	document.getElementById("loading").style.display = 'inline' ;
		document.frontpageform.feedType.value = id;
		document.frontpageform.method = "GET";
		document.frontpageform.action = "videos.htm";
		document.frontpageform.submit();
	}

	function reply_real(id) {
	document.getElementById("loading").style.display = 'inline' ;
		document.frontpageform.feedType.value = id;
		document.frontpageform.method = "GET";
		document.frontpageform.action = "realestate.htm";
		document.frontpageform.submit();
	}
	
	
	
	function hideLoading(){
 document.getElementById("loading").style.display = 'none' ;
}
</script>

<style type="text/css">

/*loading {
  width: 500px;
  height: 250px;
  top: 40%;
  left: 40%;
 border:2px solid white;
  position: fixed;
  display: block;
  border-radius:20px;
  background-color: black;
  
  
}*/
#loading {
    background-color: black;
    border: 2px solid white;
    border-radius: 20px;
    display: block;
    height: 250px;
    left: 32%;
    position: fixed;
    top: 40%;
    width: 500px;
    z-index: 999;
}


#loading-image {
  position: absolute;
  top: 20%;
  left: 15%;
  width:100px;
  height:100px;
  z-index: 90;
}

body {
	margin: 0px;
	padding: 0px;
	overflow: auto;
	overflow-x:hidden;
	}

table {
	width: 100%;
	height: 100%;
	min-height: 567px;
	padding: 0px;
	border-collapse: collapse;
	background-color: white;
}

table tr td {
	padding-top: 0;
	padding-bottom: 0;
	padding-left: 0;
	padding-right: 0;
	width: 50%;
	position:relative;
	
}

table tr td div.tiles{
	width:100%;
}




img {
	display: block;
	height:500px; 
	width:100%;
	background-size:cover; 
}

body, html	{
	width: 100%;
	overflow-x: hidden!important;
}

</style>
</head>
<body onload="hideLoading();">


	<center>
		<form name="frontpageform" commandName="frontpageform">




			<table>
				<input type="hidden" name="feedType" />
				<tr>

				
				<c:choose>
						<c:when
							test="${sessionScope.top  ne null && !empty sessionScope.top && sessionScope.top ne ''}">
							<td align="center" onclick="reply_click(this.id)" id="top">
								<img src="${sessionScope.top}" />
								<div class="tiles" style="z-index:2;position:absolute;bottom:0;left:0px;background-color: black;color:white;height: 100px;font-weight: bold;border-right: 1px solid white;font-size: 4em;font-family: Arial;letter-spacing: 0.1em;">Top News</div>
							</td>
						</c:when>
						<c:otherwise>
							<td align="center" onclick="reply_clickTop(this.id)" id="top"><img src="images/top.jpg" /><div class="tiles" style="z-index:2;position:absolute;bottom:0;left:0px;background-color: black;color:white;height: 100px;font-weight: bold;border-right: 1px solid white;font-size: 4em;font-family: Arial;letter-spacing: 0.1em;">Top News</div></td>
						</c:otherwise>
					</c:choose>
				
						
					
				
					<c:choose>
						<c:when
							test="${sessionScope.sports ne null && !empty sessionScope.sports && sessionScope.sports ne ''}">
							<td align="center" onclick="reply_click(this.id)" id="sports">
								<img src="${sessionScope.sports}" />
								<div class="tiles" style="z-index:2;position:absolute;bottom:0;color: white;border-left: 1px solid white;background-color:black;height: 100px;font-weight: bold;font-size: 4em;font-family: Arial;letter-spacing: 0.1em;">Sports</div>
							</td>
						</c:when>
						<c:otherwise>
							<td align="center" onclick="reply_click(this.id)" id="sports"><img src="images/sports.jpg" /><div class="tiles" style="z-index:2;position:absolute;bottom:0;color: white;border-left: 1px solid white;background-color:black;height: 100px;font-weight: bold;font-size: 4em;font-family: Arial;letter-spacing: 0.1em;">Sports</div></td>
						</c:otherwise>
					</c:choose>
				</tr>

				<tr>
						
						<!-- <td align="center" onclick='location.href="http://www.tylerpaper.com/weather"' ><img src="images/weather.png" /><div class="tiles" style="z-index:2;position:absolute;bottom:0;left:0px;background-color: black;border-right: 1px solid white;color:white;height: 100px;font-weight: bold;font-size: 4em;font-family: Arial;letter-spacing: 0.1em;">Weather</div></td> -->
						<td align="center" onclick='location.href="http://forecast.weather.gov/MapClick.php?CityName=Tyler&state=TX&site=SHV&textField1=32.3284&textField2=-95.3036&e=0#.VR2hFvnF_ko"' ><img src="images/weather.png" /><div class="tiles" style="z-index:2;position:absolute;bottom:0;left:0px;background-color: black;border-right: 1px solid white;color:white;height: 100px;font-weight: bold;font-size: 4em;font-family: Arial;letter-spacing: 0.1em;">Weather</div></td>
					
				
					<c:choose>
						<c:when
							test="${sessionScope.health  ne null && !empty sessionScope.health && sessionScope.health ne ''}">
							<td align="center" onclick="reply_click(this.id)" id="health">
								<img src="${sessionScope.health}" />
								<div class="tiles" style="z-index:2;position:absolute;bottom:0;background-color: black;color:white;border-left: 1px solid white;height: 100px;font-weight: bold;font-size: 4em;font-family: Arial;letter-spacing: 0.1em;">Health</div>
							</td>
						</c:when>
						<c:otherwise>
							<td align="center" onclick="reply_click(this.id)" id="health"><img src="images/health.jpg" /><div class="tiles" style="z-index:2;position:absolute;bottom:0;background-color: black;color:white;border-left: 1px solid white;height: 100px;font-weight: bold;font-size: 4em;font-family: Arial;letter-spacing: 0.1em;">Health</div></td>
						</c:otherwise>
					</c:choose>
				</tr>

				<tr>
					<c:choose>
						<c:when
							test="${sessionScope.business ne null && !empty sessionScope.business && sessionScope.business ne ''}">
							<td align="center" onclick="reply_click(this.id)" id="business">
								<img src="${sessionScope.business}" />
								<div class="tiles" style="z-index:2;position:absolute;bottom:0;left:0;background-color: black;color:white;border-right: 1px solid white;height: 100px;font-weight: bold;font-size:4em;font-family: Arial;letter-spacing: 0.1em;">Business</div>
							</td>
						</c:when>
						<c:otherwise>
							<td align="center" onclick="reply_click(this.id)" id="business"><img src="images/business.jpg" /><div class="tiles" style="z-index:2;position:absolute;bottom:0;left:0;background-color: black;color:white;border-right: 1px solid white;height: 100px;font-weight: bold;font-size:4em;font-family: Arial;letter-spacing: 0.1em;">Business</div></td>
						</c:otherwise>
					</c:choose>
				

					
						<!--  
							
							<td align="center" onclick="reply_real(this.id)" id="real"><img src="images/real.jpg" />
						<div class="tiles" style="z-index:2;position:absolute;bottom:0;background-color: black;color:white;height: 100px;font-weight: bold;border-left: 1px solid white;font-size: 4em;font-family: Arial;letter-spacing: 0.1em;">Real Estate</div>
							</td>-->
							<td align="center" onclick='location.href="http://m.realtor.com/#results?loc=Tyler%2C+TX&type=single_family%2Ccondo%2Cland"' id="real"><img src="images/real.jpg" />
						<div class="tiles" style="z-index:2;position:absolute;bottom:0;background-color: black;color:white;height: 100px;font-weight: bold;border-left: 1px solid white;font-size: 4em;font-family: Arial;letter-spacing: 0.1em;">Real Estate</div>
							</td>
						
				

				</tr>
				<tr>

						<td align="center" onclick="reply_videos(this.id)" id="videos"><img src="images/videos.jpg" /><div class="tiles" style="z-index:2;position:absolute;bottom:0;left:0;border-right: 1px solid white;background-color: black;color:white;height: 100px;font-weight: bold;font-size: 4em;font-family: Arial;letter-spacing: 0.1em;">Videos</div></td>
					
					<c:choose>
						<c:when
							test="${sessionScope.life  ne null && !empty sessionScope.life && sessionScope.life ne ''}">
							<td align="center" onclick="reply_click(this.id)" id="life">
								<img src="${sessionScope.life}" />
							<div class="tiles" style="z-index:2;position:absolute;bottom:0;background-color: black;color:white;height: 100px;font-weight: bold;border-left: 1px solid white;font-size: 4em;font-family: Arial;letter-spacing: 0.1em;">Life</div>
							</td>
						</c:when>
						<c:otherwise>
							<div class="tiles" style="z-index:2;position:absolute;bottom:0;background-color: black;color:white;height: 100px;font-weight: bold;border-left: 1px solid white;font-size: 4em;font-family: Arial;letter-spacing: 0.1em;">Life</div>
						</c:otherwise>
					</c:choose>
					</tr>
				<tr>
					<c:choose>
						<c:when
							test="${sessionScope.opinion  ne null && !empty sessionScope.opinion && sessionScope.opinion ne ''}">
							<td align="center" onclick="reply_click(this.id)" id="opinion">
								<img src="${sessionScope.opinion}" />
								<div class="tiles" style="z-index:2;position:absolute;bottom:0;background-color:100%;left:0px;background-color: black;color:white;height: 100px;font-weight: bold;border-right: 1px solid white;font-size: 4em;font-family: Arial;letter-spacing: 0.1em;">Opinion</div>
							</td>
						</c:when>
						<c:otherwise>
						<div class="tiles" style="z-index:2;position:absolute;bottom:0;background-color:100%;left:0px;background-color: black;color:white;height: 100px;font-weight: bold;border-right: 1px solid white;font-size: 4em;font-family: Arial;letter-spacing: 0.1em;">Opinion</div>
						</c:otherwise>
					</c:choose>
				
				
					
							<!-- <td align="center" onclick="reply_clickEmp(this.id)" id="employment"><img src="images/employment.png" /><div class="tiles" style="z-index:2;border-left: 1px solid white;position:absolute;bottom:0;background-color: black;color:white;height: 100px;font-weight: bold;font-size: 4em;font-family: Arial;letter-spacing: 0.1em;">Employment</div></td> -->
							<td align="center" onclick='location.href="http://www.tylerjobs.com/"' id="employment"><img src="images/employment.png" /><div class="tiles" style="z-index:2;border-left: 1px solid white;position:absolute;bottom:0;background-color: black;color:white;height: 100px;font-weight: bold;font-size: 4em;font-family: Arial;letter-spacing: 0.1em;">Employment</div></td>
				</tr>
				
				<tr>
					<td colspan="2"><div id="bottombar">
							<img
								style="float: right; width: 180px; height: 70px; margin-right: 20px; padding: 10px;"
								align="right" src="images/poweredby_1.jpg"
								alt="Powered By HubCiti">
						</div></td>
				</tr>

			</table>
			
							<div id="loading" style="background: 1px solid black;">
<img id="loading-image" src="images/ajax-loaders.gif" alt="Loading..." /><span style="color:white;font-size: 3em; position: absolute;font-weight:bolder;top: 30%;letter-spacing:0.2em;
  left: 50%;">Please Wait...</span> 
</div>  
		</form>
	</center>
</body>
</html>