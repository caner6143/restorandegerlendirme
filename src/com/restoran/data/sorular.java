package com.restoran.data;

public class sorular {
	
	private String sorular;
	private int soruKod;
	
	public sorular(){
		
	}
	
	public sorular(int soruKod,String soru){
		this.soruKod=soruKod;
		this.sorular=soru;
	}
	
	public int getSoruKod(){
		return soruKod;
	}
	
	public void setSoruKod(int kod){
		this.soruKod=kod;
	}
	
	public String getSoru(){
		return sorular;
	}
	
	public void SetSoru(String soru){
		this.sorular=soru;
	}

}
