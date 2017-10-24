<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>

 <script type="text/javascript">


	function reply_click(clicked_id) {
		var eleName = 'desc' + clicked_id;
		var eleLink = 'link' + clicked_id;
		document.getElementById('spanbox2').innerHTML = document
				.getElementById(eleName).innerHTML;

		document.getElementById('link').href = document.getElementById(eleLink).innerHTML;
	    document.getElementById('box1').style.display = "none";
		document.getElementById('box2').style.display = "block";

	
	}
	
	function reply_clickemp(clicked_id) {
		var eleName = 'desc' + clicked_id;
		var eleLink = 'link' + clicked_id;
		document.getElementById('spanbox2').innerHTML = document
				.getElementById(eleName).innerHTML;
       document.getElementById('link').innerHTML="Click to apply"
		document.getElementById('link').href = document.getElementById(eleLink).innerHTML;
        document.getElementById('box1').style.display = "none";
		document.getElementById('box2').style.display = "block";

		
	}
	
	function reply_clickevents(clicked_id) {
		var eleName = 'desc' + clicked_id;
		var eleLink = 'link' + clicked_id;
		document.getElementById('spanbox2').innerHTML = document
				.getElementById(eleName).innerHTML;
       document.getElementById('link').innerHTML=" Read Event Details.."
		document.getElementById('link').href = document.getElementById(eleLink).innerHTML;
        document.getElementById('box1').style.display = "none";
		document.getElementById('box2').style.display = "block";

		
	}
	
	function click_button() {
		document.getElementById('box2').style.display = "none";
		document.getElementById('box1').style.display = "block";
	}

	
</script>

<style type="text/css">
#box1 {
	overflow: auto;
	background-color: #E0E0E0;
	
	position: absolute;
	width:100%;
	height:100%;
	min-height:100%;
	top: 0;
	left: 0;
}

#box2 {
	overflow: auto;
	background-color: #E0E0E0;
	position: absolute;
	width:100%;
	height:100%;
	min-height:567px;
	top: 0;
	left: 0;
	display: none;
}

/* #content {
    width: 100%;
	height: 100%;
	min-height:567px;
	overflow:auto;
	position: relative;
	
	
}  */

html,body {
	margin:0px;
	padding:0px;
	overflow: auto;
	
	
}

#spanbox2 {
	display: block;
	border: 1px solid gray;
	margin-left: auto;
	margin-right: auto;
	width: 80%;
	height: 700px;
	margin-top: 25px;
	margin-bottom: 10px;
	overflow: scroll;
	padding: 30px;
	font-size: 1.8em;font-weight: bold;font-family: monospace;
}


	.close {
	-moz-box-shadow:inset 0px 1px 0px 0px #bbdaf7;
	-webkit-box-shadow:inset 0px 1px 0px 0px #bbdaf7;
	box-shadow:inset 0px 1px 0px 0px #bbdaf7;
	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #79bbff), color-stop(1, #378de5) );
	background:-moz-linear-gradient( center top, #79bbff 5%, #378de5 100% );
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#79bbff', endColorstr='#378de5');
	background-color:#79bbff;
	-webkit-border-top-left-radius:28px;
	-moz-border-radius-topleft:28px;
	border-top-left-radius:28px;
	-webkit-border-top-right-radius:28px;
	-moz-border-radius-topright:28px;
	border-top-right-radius:28px;
	-webkit-border-bottom-right-radius:28px;
	-moz-border-radius-bottomright:28px;
	border-bottom-right-radius:28px;
	-webkit-border-bottom-left-radius:28px;
	-moz-border-radius-bottomleft:28px;
	border-bottom-left-radius:28px;
	text-indent:0.62px;
	border:1px solid #84bbf3;
	display:inline-block;
	color:#ffffff;
	font-family:Arial;
	font-size:31px;
	font-weight:bold;
	font-style:normal;
	height:50px;
	line-height:50px;
	width:62px;
	text-decoration:none;
	text-align:center;
	text-shadow:1px 1px 0px #528ecc;
}
.close:hover {
	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #378de5), color-stop(1, #79bbff) );
	background:-moz-linear-gradient( center top, #378de5 5%, #79bbff 100% );
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#378de5', endColorstr='#79bbff');
	background-color:#378de5;
}.close:active {
	position:relative;
	top:1px;
}

.highLightErr {
	color: #FF0000 !important;
	padding: 30px 30px 30px 30px;
	
}

#div_link{
padding: 30px; margin-bottom: 10px;
}

#link{
font-family: cursive;font-size: 1.6em;font-weight: bolder;color: blue;
}

</style>
</head>

<body>
	<!-- <div id="content"> -->


		<div id="box2">

           <div class="close" onclick="click_button()" style="float: right;">x</div>

           <div id="spanbox2"></div>
			<hr>
			<div id="div_link">
				<a href="" id="link"
					onclick="window.open(href, 'windowName' ); return false"
					target="_blank">Read Full Story</a>
			</div>
			
		


		</div>

		<div id="box1">
		
		
		<c:choose>
		
		<c:when test="${sessionScope.videosList ne null && !empty sessionScope.videosList}">
		
		
		<c:forEach var="listValue" items="${sessionScope.videosList}">


				 <ul id="${listValue.id}" style="display: table-cell;margin:0;padding:0;width: 100%;list-style-type: none;"
					>
 
               <li id="image${listValue.id}" style=" height: 100px;display:inline-block; width: 120px;vertical-align: middle;" ><img style="height: 100px; width: 100px; margin-left: 8px;margin-right: 2px;margin-top: 2px;margin-bottom: 2px;"
							src="${listValue.image}"/></li>
				<li id="title${listValue.id}" style="display:inline-block;vertical-align:middle;font-size: 1.8em;text-align:center;line-height:100px;margin-left:20px;font-weight: bold;font-family: monospace;">${listValue.title}</li>
				<li id="desc${listValue.id}" style="display: none;">${listValue.description}</li>
				<li id="link${listValue.id}"><a style="cursor:pointer;text-decoration: none;font-size: 1.6em;font-family: cursive;font-weight: bold;" href="${listValue.link}" id="url${listValue.id}"
					onclick="window.open(href, 'windowName' ); return false"
					target="_blank">View Video</a></li>
				</ul>
				
				<hr>
				
					
					
			</c:forEach>
		</c:when>
		
			<c:when test="${sessionScope.employmentList ne null && !empty sessionScope.employmentList}">
		
		
		<c:forEach var="listValue" items="${sessionScope.employmentList}">


				 <ul id="${listValue.id}" style="display:block;cursor: pointer;margin:0;padding:0;width: 100%;list-style-type: none;"
					onclick="reply_clickemp(this.id)">
 
               <li id="title${listValue.id}" style="display: block;font-size: 1.8em;width:100%;padding:35px;margin-left:4px;font-weight: bold;font-family: monospace; ">${listValue.title}</li>
             
				
				
				 <li id="desc${listValue.id}" style="display: none;">${listValue.description}</li> 
				 <li id="link${listValue.id}" style="display: none;">${listValue.link}</li> 
				</ul>
				
				<hr>
				


				
				
				
					
					
			</c:forEach>
		</c:when>
		 
		
		<c:when test="${sessionScope.eventsList ne null && !empty sessionScope.eventsList}">
		
		
		<c:forEach var="listValue" items="${sessionScope.eventsList}">


				 <ul id="${listValue.id}" style="display:block;cursor: pointer;margin:0;padding:0;width: 100%;list-style-type: none;"
					onclick="reply_clickevents(this.id)">
 
               <li id="title${listValue.id}" style="display: block;font-size: 1.8em;width:100%;padding:35px;margin-left:4px;font-weight: bold;font-family: monospace; ">${listValue.title}</li>
             
				
				
				 <li id="desc${listValue.id}" style="display: none;">${listValue.description}</li> 
				 <li id="link${listValue.id}" style="display: none;">${listValue.link}</li> 
				</ul>
				
				<hr>
				


				
				
				
					
					
			</c:forEach>
		</c:when>
		 
		
		
		
		
		<c:when test="${sessionScope.itemsList ne null && !empty sessionScope.itemsList}">
		
		
		
		<c:forEach var="listValue" items="${sessionScope.itemsList}">
 
              <ul id="${listValue.id}" style="display: table-cell;cursor: pointer;margin:0;padding:0;width: 100%;list-style-type: none;"
					onclick="reply_click(this.id)">
 
               <li id="image${listValue.id}" style=" height: 100px;display:inline-block; width: 120px;vertical-align: middle;" ><img style="height: 100px; width: 100px; margin-left: 8px;margin-right: 2px;margin-top: 2px;margin-bottom: 2px;"
							src="${listValue.image}"/></li>
				<li id="title${listValue.id}" style="display:inline-block;vertical-align:middle;font-size: 1.8em;text-align:center;line-height:100px;margin-left:20px;font-weight: bold;font-family: monospace;">${listValue.title}</li>
				<li id="desc${listValue.id}" style="display: none;">${listValue.description}</li>
				<li id="link${listValue.id}" style="display: none;">${listValue.link}</li>
				</ul>

				
				<hr>
				
				
			</c:forEach>
			
		</c:when>
		
		</c:choose>
		
	<c:if
						test="${requestScope.feedmessage ne null && !empty requestScope.feedmessage}">
							<span class="highLightErr"><c:out value="${requestScope.feedmessage}"></c:out></span>
					</c:if>
					
					
			
			​
		</div>



	

<!-- </div> -->


</body>
</html>
