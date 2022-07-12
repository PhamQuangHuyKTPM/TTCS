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

@WebServlet(urlPatterns = {"/qltt"})
public class QLTTController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	List<Model> list;
	StudentDao studentDao = new StudentDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String lop = req.getParameter("lop");
		
		String action = req.getParameter("action");
		if(action != null) {
			if(action.equals("FormUpdate")) {
				String id = req.getParameter("id");
				Model model = new Model();
				model = studentDao.selectById(id);
				req.setAttribute("ModelUpdate", model);
				req.getRequestDispatcher("/views/formUpdateDiem.jsp").forward(req, resp);
			}
			
			if(action.equals("delete")) {
				String id  = req.getParameter("id");
				studentDao.deleteStudent(id);
				
			}
			
			if(action.equals("handlerUpdateinfo")) {
				int id = Integer.parseInt(req.getParameter("id"));
				double d1 = Double.parseDouble(req.getParameter("d1"));
				double d2 = Double.parseDouble(req.getParameter("d2"));
				double d3 = Double.parseDouble(req.getParameter("d3"));
				Model model = new Model();
				model.setId(id);
				model.setDiem1(d1); model.setDiem2(d2); model.setDiem3(d3);
				if(req.getParameter("d1").length()==0 || req.getParameter("d2").length()==0 || req.getParameter("d3").length()==0) {
					req.setAttribute("ModelUpdate", req.getParameter("id"));
					req.getRequestDispatcher("/views/formUpdateDiem.jsp").forward(req, resp);
				}
				else {
					studentDao.updateDiemById(model);
				}
				
			}
		}
		
		list = studentDao.selectByClass(lop);
		req.setAttribute("listTT", list);
		req.setAttribute("nameClass", lop);
		req.getRequestDispatcher("/views/home/qltt.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
