package com.phamquanghuy.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/excelControl"})
public class ExcelController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(req.getParameter("type") != null) {
			resp.setContentType("application/vnd.ms-excel");
			resp.setHeader("Content-Disposition", "inline; filename=danh_sach_hoc_sin.xls");
		}
	}
	
}
