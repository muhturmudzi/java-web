

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="net.tutorialpedia.model.UserModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Latihan Java Web</title>
    </head>
    <body>
        <center><h1>Edit User</h1></center>
        <form action="UserController?data=user&proses=update-user" method="post">
            <table style="margin:20px auto;">
            <%
                String id = request.getParameter("id");
                UserModel km = new UserModel();
                km.setId(id);
                List<UserModel> data = new ArrayList<UserModel>();
                data = km.cariID(); 
                if (data.size() > 0) {

            %>
		<tr>
                    <td>Nama</td>
                    <td><input type="text" name="nama" value="<%=data.get(0).getNama()%>"></td>
		</tr>
		<tr>
                    <td>Alamat</td>
                    <td><input type="text" name="alamat" value="<%=data.get(0).getAlamat()%>"></td>
                    <td><input type="hidden" name="id" value="<%=data.get(0).getId()%>"></td>
		</tr>
		<tr>
                    <td></td>
                    <td><input type="submit" value="Update"></td>
		</tr>
                  <%}%>
            </table>
          
	</form>	
    
    </body>
</html>
