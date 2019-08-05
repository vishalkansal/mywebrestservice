        
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