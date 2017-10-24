
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

body{
height: 100%;
margin:0;
padding:0;
text-align:center;
background-color: #E0E0E0;
}

.highLightErr {
	color: #000000 !important;
	font-size:1.9em;
	font-family:monospace;
	font-weight:bold;
	text-align: center;
    position:absolute;
    top:50%;
    left:30%;
    
    text-align:left;
    width:900px;
   
	
	
}

#errorContent{
background-color: #E0E0E0;
  
	

	width:100%;
	height:100%;
	
	
	
	
}

</style>
</head>
<body>
<div id="errorContent">
   <c:if
			test="${requestScope.noregfound ne null && !empty requestScope.noregfound}">
			
		<div class="highLightErr"><c:out value="${requestScope.noregfound}"></c:out></div>
		
		
		<!-- <a href = "javascript:history.back()"><img id="goback"  style="margin-right:15px;" src="images/back.png" alt="Back" width="150px" height="150px; "></a> -->
   </c:if>
   
   
  

</div>
      
</body>
</html>
</body>
</html>