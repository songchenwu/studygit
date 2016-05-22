package com.yc.fav.entity;

public class Favorite {
	private int fid;
	private String flabel;
	private String furl;
	private String ftage;
	private String fdesc;

	public Favorite() {
	}

	public Favorite(String flabel, String furl, String ftage,
			String fdesc) {
		this.flabel = flabel;
		this.furl = furl;
		this.ftage = ftage;
		this.fdesc = fdesc;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getFlabel() {
		return flabel;
	}

	public void setFlabel(String flabel) {
		this.flabel = flabel;
	}

	public String getFurl() {
		return furl;
	}

	public void setFurl(String furl) {
		this.furl = furl;
	}

	public String getFtage() {
		return ftage;
	}

	public void setFtage(String ftage) {
		this.ftage = ftage;
	}

	public String getFdesc() {
		return fdesc;
	}

	public void setFdesc(String fdesc) {
		this.fdesc = fdesc;
	}

	@Override
	public String toString() {
		return "Favorite [fid=" + fid + ", flabel=" + flabel + ", furl=" + furl
				+ ", ftage=" + ftage + ", fdesc=" + fdesc + "]";
	}

}
