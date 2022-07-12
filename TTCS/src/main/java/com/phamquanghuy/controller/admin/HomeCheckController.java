package com.phamquanghuy.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.phamquanghuy.dao.impl.StudentDao;
import com.phamquanghuy.model.Model;

@WebServlet(urlPatterns = "/homecheck")
public class HomeCheckController  extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	StudentDao studentDao;
	List<Model> list = new ArrayList<Model>();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		studentDao = new StudentDao();
		String name= req.getParameter("ten");
		String lop = req.getParameter("lop");
		
		list = studentDao.selectByNameAndClass(name, lop);
		req.setAttribute("lhoa", list);
		req.setAttribute("NameClass", lop);
		req.getRequestDispatcher("/views/home/check.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		studentDao = new StudentDao();
		
		String monhoc = req.getParameter("monhoc");
		System.out.println(monhoc);
		if(monhoc.length()==0) {
			list = studentDao.selectAll();		
			req.setAttribute("list", list);
			req.getRequestDispatcher("/views/home.jsp").forward(req, resp);
		}
		list = studentDao.selectByClass(monhoc);
		req.setAttribute("lhoa", list);
		req.setAttribute("NameClass", monhoc);
		req.getRequestDispatcher("/views/home/check.jsp").forward(req, resp);
	}
}
