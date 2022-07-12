package com.phamquanghuy.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.phamquanghuy.dao.impl.StudentDao;
import com.phamquanghuy.model.Model;

@WebServlet(urlPatterns = {"/qldiem"})
public class QLDiemController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	List<Model> list;
	StudentDao studentDao = new StudentDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
        
		String lop = req.getParameter("lop");
		
		if(req.getParameter("action") != null) {
			if(req.getParameter("action").equals("delete")) {
				String id = req.getParameter("id");
				studentDao.deleteStudent(id);
				System.out.println("Xoá xong r");
			}
			if(req.getParameter("action").equals("FormUpdate")) {
				Model model = new Model();
				String id = req.getParameter("id");
				model = studentDao.selectById(id);
				req.setAttribute("ModelUpdate", model);
				req.getRequestDispatcher("/views/formUpdate.jsp").forward(req, resp);
			}
			
			if(req.getParameter("action").equals("handlerUpdateinfo")) {
				Model model = new Model();
				int id = Integer.parseInt(req.getParameter("id")); String hoten = req.getParameter("hoten"); String truong = req.getParameter("truong");
				String ngaysinh = req.getParameter("ngaysinh");
				model.setId(id);
				model.setNgaysinh(ngaysinh);
				model.setHoten(hoten);
				model.setTruong(truong);
				
				if(hoten.length() == 0 || truong.length() == 0 || ngaysinh.length()==0) {
					req.setAttribute("ModelUpdate", studentDao.selectById(req.getParameter("id")));
					req.getRequestDispatcher("/views/formUpdate.jsp").forward(req, resp);
				}
				else studentDao.updateById(model);
			}
			
		}
		
		list = studentDao.selectByClass(lop);		
		System.out.println(lop + " qli diem");
		
		req.setAttribute("nameClass", lop);
		req.setAttribute("listDiem", list);
		req.getRequestDispatcher("/views/home/qldiem.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		String action = req.getParameter("action");
		if(req.getParameter("action").equals("handlerUpdateinfo")) {
			Model model = new Model();
			model.setLop(req.getParameter("lop"));
			model.setId(Integer.parseInt(req.getParameter("id")));
			model.setHoten(req.getParameter("hoten"));
			model.setTruong(req.getParameter("truong"));
			if(req.getParameter("hoten").length()==0 || req.getParameter("truong").length()==0) {
				resp.sendRedirect("qldiem?action=FormUpdate&id="+req.getParameter("id"));
			}
			else {
				studentDao.updateById(model);
			}
		}
	}
}
