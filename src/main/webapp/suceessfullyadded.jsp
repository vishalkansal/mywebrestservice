<!DOCTYPE html>
<html lang="en">
<title>Pretups</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins">
<link rel="stylesheet" href="css/index.css">
    
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<body>

<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-red w3-collapse w3-top w3-large w3-padding" style="z-index:3;width:300px;font-weight:bold;" id="mySidebar"><br>
  <a href="javascript:void(0)" onclick="w3_close()" class="w3-button w3-hide-large w3-display-topleft" style="width:100%;font-size:22px">Close Menu</a>
  <div class="w3-container">
    <h3 class="w3-padding-64"><b>Comviva</b></h3>
  </div>
  <div class="w3-bar-block">
    <a href="MainPage.jsp" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">Home</a> 
    <a href="index.jsp" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">Set VoucherCard</a> 
    <a href="DeletePage.jsp" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">Delete VoucherCard</a> 
    <a href="ViewGroupVersion.jsp" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">View GroupCard</a>
    <a href="Update.jsp" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">Update VoucherCard</a> 
    <a href="viewrequiredthings.jsp" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">View VOucher Card</a>
  </div>
</nav>

<!-- Top menu on small screens -->
<header class="w3-container w3-top w3-hide-large w3-red w3-xlarge w3-padding">
  <a href="javascript:void(0)" class="w3-button w3-red w3-margin-right" onclick="w3_open()">?</a>
  <span>Comviva Pretups</span>
</header>

<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:340px;margin-right:40px">

<!-- Header -->
  <div class="w3-container" style="margin-top:80px" id="showcase">
    <h1 class="w3-jumbo"><b>Card Voucher Management</b></h1>
    <h1 class="w3-xxxlarge w3-text-red"><b>PreTups</b></h1>
    <hr style="width:50px;border:5px solid red" class="w3-round">
  </div>
  
 
        
  

<script>
// Script to open and close sidebar
alert("operation successful");
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
