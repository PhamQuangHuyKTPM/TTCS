package com.phamquanghuy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.phamquanghuy.dao.IStudentDAO;
import com.phamquanghuy.model.Model;

public class StudentDao extends AbstractModel implements IStudentDAO{

	@Override
	public List<Model> selectAll() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<Model> list = new ArrayList<Model>();
		String sql = "select * from hocsinh";

		try {
			con = getConnnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Model hs = new Model();
				hs.setId(rs.getInt("id"));
				hs.setHoten(rs.getString("hoten"));
				hs.setNgaysinh(rs.getString("ngaysinh"));
				hs.setLop(rs.getString("lop"));
				hs.setTruong(rs.getString("truong"));
				hs.setDiem1(rs.getDouble("diem1"));
				hs.setDiem2(rs.getDouble("diem2"));
				hs.setDiem3(rs.getDouble("diem3"));
				hs.setDtb(rs.getDouble("dtb"));
				list.add(hs);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<Model> selectByName(String name) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<Model> list = new ArrayList<Model>();
		String sql = "select * from hocsinh where hoten = ?";
		
		try {
			con = getConnnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while(rs.next()) {
				Model hs = new Model();
				hs.setId(rs.getInt("id"));
				hs.setHoten(rs.getString("hoten"));
				hs.setNgaysinh(rs.getString("ngaysinh"));
				hs.setLop(rs.getString("lop"));
				hs.setTruong(rs.getString("truong"));
				hs.setDiem1(rs.getDouble("diem1"));
				hs.setDiem2(rs.getDouble("diem2"));
				hs.setDiem3(rs.getDouble("diem3"));
				hs.setDtb(rs.getDouble("dtb"));
				list.add(hs);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	
	}


	@Override
	public List<Model> selectByClass(String name) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<Model> list = new ArrayList<Model>();
		String sql = "select * from hocsinh where lop = ? ";
		
		try {
			con = getConnnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while(rs.next()) {
				Model hs = new Model();
				hs.setId(rs.getInt("id"));
				hs.setHoten(rs.getString("hoten"));
				hs.setNgaysinh(rs.getString("ngaysinh"));
				hs.setLop(rs.getString("lop"));
				hs.setTruong(rs.getString("truong"));
				hs.setDiem1(rs.getDouble("diem1"));
				hs.setDiem2(rs.getDouble("diem2"));
				hs.setDiem3(rs.getDouble("diem3"));
				hs.setDtb(rs.getDouble("dtb"));
				list.add(hs);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<Model> selectByNameAndClass(String name, String nameClass) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<Model> list = new ArrayList<Model>();
		String sql = "select * from hocsinh where hoten = ? and lop = ? ";
		
		try {
			con = getConnnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, nameClass);
			rs = ps.executeQuery();
			while(rs.next()) {
				Model hs = new Model();
				hs.setId(rs.getInt("id"));
				hs.setHoten(rs.getString("hoten"));
				hs.setNgaysinh(rs.getString("ngaysinh"));
				hs.setLop(rs.getString("lop"));
				hs.setTruong(rs.getString("truong"));
				hs.setDiem1(rs.getDouble("diem1"));
				hs.setDiem2(rs.getDouble("diem2"));
				hs.setDiem3(rs.getDouble("diem3"));
				hs.setDtb(rs.getDouble("dtb"));
				list.add(hs);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void InsertStudent(Model student) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "insert into hocsinh(hoten,ngaysinh, truong, lop, diem1, diem2, diem3, dtb) values(?,?,?,?,?,?,?,?)";
		
		try {
			con = getConnnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, student.getHoten());
			ps.setString(2, student.getNgaysinh());
			ps.setString(3, student.getTruong());
			ps.setString(4, student.getLop());
			ps.setDouble(5, student.getDiem1());
			ps.setDouble(6, student.getDiem2());
			ps.setDouble(7, student.getDiem3());
			
			double dtb = (student.getDiem1() + student.getDiem2() + student.getDiem3()) /3;
			dtb = ((double) Math.round(dtb * 10) / 10);
			student.setDtb(dtb);
			
			ps.setDouble(8, student.getDtb());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Sai");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteStudent(String id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "delete from hocsinh where id = ?";
		
		try {
			con = getConnnection();
			ps = con.prepareStatement(sql);
			ps.setString(1,  id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Model selectById(String id) {
		Connection con;
		PreparedStatement ps;
		ResultSet rs;
		
		String sql = "select * from hocsinh where id = ?";
		Model hs = new Model();
		try {
			con = getConnnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				
				hs.setId(rs.getInt("id"));
				hs.setHoten(rs.getString("hoten"));
				hs.setNgaysinh(rs.getString("ngaysinh"));
				hs.setLop(rs.getString("lop"));
				hs.setTruong(rs.getString("truong"));
				hs.setDiem1(rs.getDouble("diem1"));
				hs.setDiem2(rs.getDouble("diem2"));
				hs.setDiem3(rs.getDouble("diem3"));
				hs.setDtb(rs.getDouble("dtb"));
				return hs;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hs;
	}

	@Override
	public Model updateById(Model m) {
		Connection con ;
		PreparedStatement ps;
		
		String sql = "update hocsinh set hoten = ?, ngaysinh = ? , truong = ?  where id = ?";
		
		try {
			con = getConnnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, m.getHoten());
			ps.setString(2, m.getNgaysinh());
			ps.setString(3, m.getTruong());
			ps.setInt(4, m.getId());
			ps.executeUpdate();
			return m;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Model updateDiemById(Model m) {
		Connection con;
		PreparedStatement ps;
		
		String sql = "update hocsinh set diem1 = ?, diem2 = ?, diem3 = ?, dtb = ? where id = ?";
		
		try {
			con = getConnnection();
			ps = con.prepareStatement(sql);
			ps.setDouble(1, m.getDiem1());
			ps.setDouble(2, m.getDiem2());
			ps.setDouble(3, m.getDiem3());
			
			double dtb = (m.getDiem1() + m.getDiem2() + m.getDiem3()) / 3;
			dtb = ((double) Math.round(dtb * 10) / 10);
			m.setDtb(dtb);
			
			ps.setDouble(4, m.getDtb());
			ps.setInt(5,m.getId());
			ps.executeUpdate();
			return m;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
