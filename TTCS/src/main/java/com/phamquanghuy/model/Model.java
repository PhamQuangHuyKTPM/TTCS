package com.phamquanghuy.model;

public class Model {
	private int id;
	private String hoten;
	private String ngaysinh;
	private String lop;
	private String truong;
	private double diem1;
	private double diem2;
	private double diem3;
	private double dtb;
	
	public Model() {
		super();
	}
	public Model(int id, String hoten, String ngaysinh, String lop, String truong, double diem1, double diem2,
			double diem3, double dtb) {
		super();
		this.id = id;
		this.hoten = hoten;
		this.ngaysinh = ngaysinh;
		this.lop = lop;
		this.truong = truong;
		this.diem1 = diem1;
		this.diem2 = diem2;
		this.diem3 = diem3;
		this.dtb = dtb;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getLop() {
		return lop;
	}
	public void setLop(String lop) {
		this.lop = lop;
	}
	public String getTruong() {
		return truong;
	}
	public void setTruong(String truong) {
		this.truong = truong;
	}
	public double getDiem1() {
		return diem1;
	}
	public void setDiem1(double diem1) {
		this.diem1 = diem1;
	}
	public double getDiem2() {
		return diem2;
	}
	public void setDiem2(double diem2) {
		this.diem2 = diem2;
	}
	public double getDiem3() {
		return diem3;
	}
	public void setDiem3(double diem3) {
		this.diem3 = diem3;
	}
	public double getDtb() {
		return dtb;
	}
	public void setDtb(double dtb) {
		this.dtb = dtb;
	}
	
	public String getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	@Override
	public String toString() {
		return "Model [id=" + id + ", hoten=" + hoten + ", lop=" + lop + ", truong=" + truong + ", diem1=" + diem1
				+ ", diem2=" + diem2 + ", diem3=" + diem3 + ", dtb=" + dtb + "]";
	}
}
