/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tutorialpedia.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.tutorialpedia.model.UserModel;


public class UserController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String proses=request.getParameter("proses");
        String action=request.getParameter("action");
        if (proses.equals("input-user")){
            response.sendRedirect("tambah_user.jsp");
            return;
        }else if(proses.equals("edit-user")){
            response.sendRedirect("edit_user.jsp?id="+request.getParameter("id"));
            return;
        }else if(proses.equals("hapus-user")){
            UserModel hm=new UserModel();
            hm.setId(request.getParameter("id"));
            hm.hapus();
            response.sendRedirect("");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String data = request.getParameter("data");
        String proses = request.getParameter("proses");
        
        if (data != null){
            if(data.equals("user")){
                UserModel um=new UserModel();
                um.setId(request.getParameter("id"));
                um.setNama(request.getParameter("nama"));
                um.setAlamat(request.getParameter("alamat"));
                if (proses.equals("input-user")){
                    um.simpan();
                }else if (proses.equals("update-user")){
                    um.update();
                } else if(proses.equals("hapus-user")){
                    um.hapus();
                }
                response.sendRedirect("");
            }
        }
    }

}
