package com.phamquanghuy.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.phamquanghuy.dao.impl.StudentDao;
import com.phamquanghuy.model.Model;

@WebServlet(urlPatterns = "/addStudent")
public class AddController extends HttpServlet{
	
	
	StudentDao studentDao = new StudentDao();
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/formAdd.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Model hs = new Model();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		String ngaysinh = req.getParameter("ngaysinh");
		String name = req.getParameter("hoten"), school = req.getParameter("school"), lop = req.getParameter("lop");
		String remember = req.getParameter("remember");
		hs.setHoten(name);
		hs.setNgaysinh(ngaysinh);
		hs.setTruong(school);
		hs.setLop(lop);
		Double d1 = Double.parseDouble(req.getParameter("d1")), d2 = Double.parseDouble(req.getParameter("d2")), d3 = Double.parseDouble(req.getParameter("d3"));
		hs.setDiem1(d1);
		hs.setDiem2(d2);
		hs.setDiem3(d3);
		if(name.isEmpty() || school.isEmpty() || lop.isEmpty() || ngaysinh.isEmpty()) {
			req.setAttribute("alert", 1);
			req.getRequestDispatcher("/views/formAdd.jsp").forward(req, resp);
		}
		else {
			studentDao.InsertStudent(hs);
			if(remember.equals("on")) {
				req.setAttribute("alert", 2);
				req.getRequestDispatcher("/views/formAdd.jsp").forward(req, resp);
			}
			else resp.sendRedirect("home");
		}
		
		
		
	}

}
