package com.yc.vote.entity;

import java.io.Serializable;

public class Option implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 4861699911990863489L;
	private int voId;
    private String voOption;
    private int voOrder;
    private int vsId;
    
    
    public Option() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Option( String voOption, int voOrder, int vsId) {
		this.voOption = voOption;
		this.voOrder = voOrder;
		this.vsId = vsId;
	}


	public int getVsId() {
		return vsId;
	}

	public void setVsId(int vsId) {
		this.vsId = vsId;
	}

	public int getVoId() {
		return voId;
	}

	public void setVoId(int voId) {
		this.voId = voId;
	}

	public String getVoOption() {
		return voOption;
	}

	public void setVoOption(String voOption) {
		this.voOption = voOption;
	}


	public int getVoOrder() {
		return voOrder;
	}

	public void setVoOrder(int voOrder) {
		this.voOrder = voOrder;
	}

	@Override
	public String toString() {
		return "\nOption [voId=" + voId + ", voOption=" + voOption + ", voOrder="
				+ voOrder + "]";
	}

	
}