<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.project.fundamentals.ENTITY.*" %>
<!DOCTYPE html>
<html lang="en">
<title>Profile View</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins">
<link rel="stylesheet" href="css/index.css">
    
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<body>

<!<nav class="w3-sidebar w3-red w3-collapse w3-top w3-large w3-padding" style="z-index:3;width:300px;font-weight:bold;" id="mySidebar"><br>
  <a href="javascript:void(0)" onclick="w3_close()" class="w3-button w3-hide-large w3-display-topleft" style="width:100%;font-size:22px">Close Menu</a>
  <div class="w3-container">
    <h3 class="w3-padding-64"><b>Comviva</b></h3>
  </div>
  <div class="w3-bar-block">
    <a href="MainPage.jsp" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">Home</a> 
    <a href="index.jsp" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">Set Default Voucher Card</a> 
    <a href="DeletePage.jsp" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">Delete VoucherCard</a> 
    <a href="ViewGroupVersion.jsp" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">View GroupCard</a>
    <a href="Update.jsp" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">Set Voucher Card</a> 
       <a href="viewrequiredthings.jsp" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">View Voucher Card</a>
    
  </div>
</nav>
<!-- Top menu on small screens -->
<header class="w3-container w3-top w3-hide-large w3-red w3-xlarge w3-padding">
  <a href="javascript:void(0)" class="w3-button w3-red w3-margin-right" onclick="w3_open()">?</a>
  <span>Company Name</span>
</header>


<div class="w3-main" style="margin-left:340px;margin-right:40px">
  <!-- Contact -->
  <div class="w3-container" id="contact" style="margin-top:75px">
      <center><h2 style="padding: 15px">View VoucherCard </h2></center>
   <table class="table table-striped">
   <thead>
   <tr>
   <th>cardGroupSetId</th><th>version</th>
   <th>cardGroupId</th><th>startRange</th>
   <th>endRange</th><th>cardName</th>
   <th>voucherType</th><th>voucherSegment</th><th>voucherProductId</th>
   </tr>
   </thead>
   
   <tbody>
   <%
   CardGroupDetails view=(CardGroupDetails) request.getAttribute("Required");
   out.print("<tr>");
   out.print("<td align='center'>");
   out.print(view.getCardGroupSetId());
   out.print("</td>");
   out.print("<td align='center'>");
   out.print(view.getVersion());
   out.print("</td>");
   
   out.print("<td align='center'>");
   out.print(view.getCardGroupId());
   out.print("</td>"); 
   out.print("<td align='center'>");
   out.print(view.getStartRange());
   out.print("</td>");  out.print("<td align='center'>");
   out.print(view.getEndRange());
   out.print("</td>");
   
   out.print("<td align='center'>");
   out.print(view.getCardName());
   out.print("</td>");  out.print("<td align='center'>");
   out.print(view.getVoucherType());
   out.print("</td>");

   
   out.print("<td align='center'>");
   out.print(view.getVoucherSegment());
   out.print("</td>");  out.print("<td align='center'>");
   out.print(view.getVoucherProductId());
   out.print("</td>");
   out.print("</tr>");

   %>
   
   </tbody>
   </table>
<br>
   <br>
   <table class="table table-striped" cellspacing="10" >
   <thead>
   <tr>
   <th>cardGroupSetId</th><th>version</th>
   <th>cardGroupId</th><th>bondleId</th>
   <th>type</th><th>validity</th>
   <th>value</th><th>multFactor</th>
   </tr>
   </thead>
   
   <tbody>
   <%
   CardGroupDetails view1=(CardGroupDetails) request.getAttribute("Required");
   List<CardGroupBonusDetails> view2=view.getBonus();

      
   for(CardGroupBonusDetails v:view2 )
   {
	   out.print("<tr>");
	   out.print("<td align='center'>");
	   out.print(v.getCardGroupSetId());
	   out.print("</td>");
	   out.print("<td align='center'>");
	   out.print(v.getVersion());
	   out.print("</td>");
	   
	   
	   out.print("<td align='center'>");
	   out.print(v.getCardGroupId());
	   out.print("</td>");
	   out.print("<td align='center'>");
	   out.print(v.getBondleId());
	   out.print("</td>");
	   
	   out.print("<td align='center'>");
	   out.print(v.getType());
	   out.print("</td>");
	   out.print("<td align='center'>");
	   out.print(v.getValidity());
	   out.print("</td>");
	   
	   
	   out.print("<td align='center'>");
	   out.print(v.getValue());
	   out.print("</td>");
	   out.print("<td align='center'>");
	   out.print(v.getMultFactor());
	   out.print("</td>");
	   
	   
	   out.print("</tr>");
	   
	   
   }
   
   
   %>
   </tbody>
   </table>









   
   
     
  </div>

<!-- End page content -->
</div>

<!-- W3.CSS Container -->

<script>
// Script to open and close sidebar
function w3_open() {
  document.getElementById("mySidebar").style.display = "block";
  document.getElementById("myOverlay").style.display = "block";
}
 
function w3_close() {
  document.getElementById("mySidebar").style.display = "none";
  document.getElementById("myOverlay").style.display = "none";
}

// Modal Image Gallery
function onClick(element) {
  document.getElementById("img01").src = element.src;
  document.getElementById("modal01").style.display = "block";
  var captionText = document.getElementById("caption");
  captionText.innerHTML = element.alt;
}
</script>

</body>
</html>
