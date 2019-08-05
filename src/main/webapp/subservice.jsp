<%@page import="java.sql.*"%>
<body>
    
           <div class="form-group">
            <label class="control-label col-sm-2" >ServiceType:</label>
                <div class="col-sm-10" id="state">
                <select class ="form-control" name="state" >
                    <option>Select SubService</option>
                    <%
                
                    int country_id = request.getParameter("country_id");
                    system.out.print(country_id);
                     Class.forName("com.mysql.jdbc.Driver").newInstance(); 
                   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test12e","root","root"); 
                  Statement stmt = con.createStatement(); 
                  ResultSet rs = stmt.executeQuery("Select * from states where country_id"+ country_id+"");
                  while(rs.next()){
            %>
                  <option value="<%=rs.getString("id")%>"><%=rs.getString("state")%></option> 
            <%
                  }
            %>
                       
                </select>
                </div>
               
            </div>
    
    
    
</body>
    