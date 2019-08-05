<!DOCTYPE html>
<html lang="en">
<title>Main Page-Home</title>
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
    <a href="index.jsp" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">Set Voucher Card</a> 
    <a href="DeletePage.jsp" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">Delete Voucher Card</a> 
    <a href="ViewGroupVersion.jsp" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">View Group Card</a>
    <a href="Update.jsp" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">Update Voucher Card</a> 
    <a href="viewrequiredthings.jsp" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">View Voucher Card</a>
  </div>
</nav>

<!-- Top menu on small screens -->
<header class="w3-container w3-top w3-hide-large w3-red w3-xlarge w3-padding">
  <a href="javascript:void(0)" class="w3-button w3-red w3-margin-right" onclick="w3_open()">☰</a>
  <span>Company Name</span>
</header>

<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:340px;margin-right:40px">

<!-- Header -->
  <div class="w3-container" style="margin-top:80px" id="showcase">
      
<div class="container">
<h2 style="padding: 15px">View Voucher Card </h2>
  <form  class="form-horizontal" action="viewrequired" method="post">
    
    <div class="form-group">
      <label class="control-label col-sm-2" >CardGroupSetName:</label>
         <div class="col-sm-10">
      <input type="text" class="form-control" placeholder="cardGroupSetName" name = "cardGroupSetName" >
        </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" >NetworkCode:</label>
         <div class="col-sm-10">
      <input type="text" class="form-control" placeholder="NetworkCode" name = "networkCode">
        </div>
    </div>
       <div class="form-group">
      <label class="control-label col-sm-2" >ModuleCode:</label>
           <div class="col-sm-10">
      <input type="text" class="form-control" placeholder="cardGroupSetName" name = "moduleCode"  >
          </div>
    </div>
      
      <div class="form-group">
      <label class="control-label col-sm-2" >Version:</label>
           <div class="col-sm-10">
      <input type="text" class="form-control" placeholder="cardGroupSetName" name = "lastVersion" >
          </div>
    </div>
     
      
       
       <div class="form-group">
      <label class="control-label col-sm-2" >ServiceType:</label>
           <div class="col-sm-10" style="width: 43%">
      
      <select class="form-control" id="selectCategory" name="serviceType" >
     </select>
          </div>
          </div>
      
       <div class="form-group">
      <label class="control-label col-sm-2" >Sub Service TYpe:</label>
           <div class="col-sm-10" style="width: 43%">
               <select class="form-control" id="subCategory" name="subService">     
     </select>
            
          </div>
          </div>
      
     
      
<center>    <input type="submit" onclick="myFunction()" class="btn btn-default" value="View Voucher Card"></center>
  </form>
      </div>  
      </div>
  </div>
  
<script>
/*function myFunction() {
  alert("Success!");
}
   */ 
     $(document).ready(function(){
        //alert("start");
        //$(document).on("load", "#selectCategory",function(){
      loadDropdown();
       /* SecondDropDown("1");*/
            
 // });
    });
  
    function loadDropdown(){
        //var categoryId = $(this).val();
        //alert("hey");
        $.ajax({
            type: 'GET',
            url: "Categories",
            success: function(response, status, xhr){
                
                //alert("working");
                var  option='<option value="">Select</option>';
                for(var index in response){
                    var obj = response[index]
                    
                    
//                    option = option + "<option value='"+obj.id + "'>"+obj.country + "</option>";
                    option = option + "<option value='"+obj.id + "'>"+obj.country + "</option>";
                /*    option = option + "<option>" +obj.country + "</option>";*/
                }
                $("#selectCategory").html(option);
            },
            error:function(){
                alert("error");
            }

        });
        
        console.log("hello")
    }
    
    /*second drop down*/
    
    $(document).on("change","#selectCategory", function(){
        SecondDropDown();
        
    });
    
    function SecondDropDown(serviceType){
        
        $.ajax({
            type: 'POST',
            data:{
                "fetch" : $("#selectCategory").val()
        
            },
            url: "subCategories",
            success: function(response, status, xhr){
                
              
                
                var  option='<option value="">Select</option>';
                for(var index in response){
                    var obj = response[index]
                    
                     //alert(Object.keys(obj));
                    
                    //console.log(response);
                    
                   /* option = option + "<option value='"+obj.id + "'>"+obj.state + "</option>";*/
                    
                     option = option + "<option>" +obj.state + "</option>";
                    
                    
                }
                $("#subCategory").html(option);
            },
            error:function(){
                alert("error");
            }

        });
        
        //console.log("hello");
        
    }
    

</script>
    
</body>
</html>