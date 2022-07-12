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

@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	StudentDao studentDao;
	List<Model> list = new ArrayList<Model>();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		studentDao = new StudentDao();
		list = studentDao.selectAll();		
		req.setAttribute("list", list);
		req.getRequestDispatcher("/views/home.jsp").forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		studentDao = new StudentDao();
		
		String name = req.getParameter("ten");
		chuanHoa(name);
		System.out.println(name);
		
		if(name.length() == 0) {
			resp.sendRedirect("home");
		}
		else {
			list = studentDao.selectByName(name);		
			req.setAttribute("list", list);
			req.getRequestDispatcher("/views/home.jsp").forward(req, resp);
		}
	}
	
	public String chuanHoa(String str) {
		
        str = str.trim();
        str = str.replaceAll("\\s+", " ");
        return str;
    }
	
}
