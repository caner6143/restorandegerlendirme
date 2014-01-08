package com.restoran.data;

public class cevaplar {
	private int cevapKod;
	private String cevap;
	
	public cevaplar(){
		
	}
	
	public cevaplar(int cevapKod,String cevap)
	{
		this.cevapKod=cevapKod;
		this.cevap=cevap;
	}
	
	public int getCevapKod (){
		return cevapKod;
	}
	
	public void setCevapKod(int kod){
		this.cevapKod=kod;
	}
	
	public String getCevap(){
		return cevap;
	}
	
	public void setCevap(String cevap){
		this.cevap=cevap;
	}

}
