
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
    <center><h1>Latihan CRUD Java Web</h1></center>
    <center>
        <a class="tambah" href="UserController?proses=input-user">Tambah</a>
    </center>
        <table style="margin:20px auto;" border="1">
              <tr>
                  <th>No</th>
                  <th>Nama</th>
                  <th>Alamat</th>
                  <th>Action</th>
              </tr>
              <%
                  UserModel km = new UserModel();
                  List<UserModel> data = new ArrayList<UserModel>();
                  String ket = request.getParameter("ket");
                  if (ket == null) {
                      data = km.tampil();
                  } 
                  for (int x = 0; x < data.size(); x++) {
              %>
               <tr>
                  <td><%=x + 1%></td>
                  <td><%=data.get(x).getNama()%></td>
                  <td><%=data.get(x).getAlamat()%></td>
                  <td>
                      <a href="UserController?proses=edit-user&id=<%=data.get(x).getId()%>">Edit</a>
                      <a href="UserController?proses=hapus-user&id=<%=data.get(x).getId()%>">Hapus</a>
                  </td>
              </tr>
              <%}%>
          </table>
              
</body>
</html>
