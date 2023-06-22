package com.example.myquran.repository.local.model;

import com.google.gson.annotations.SerializedName;

public class AyatItem {

	@SerializedName("number")
	private int number;

	@SerializedName("hizbQuarter")
	private int hizbQuarter;

	@SerializedName("ruku")
	private int ruku;

	@SerializedName("manzil")
	private int manzil;

	@SerializedName("text")
	private String text;

	@SerializedName("page")
	private int page;

	@SerializedName("sajda")
	private boolean sajda;

	@SerializedName("numberInSurah")
	private int numberInSurah;

	@SerializedName("juz")
	private int juz;

	public int getNumber(){
		return number;
	}

	public int getHizbQuarter(){
		return hizbQuarter;
	}

	public int getRuku(){
		return ruku;
	}

	public int getManzil(){
		return manzil;
	}

	public String getText(){
		return text;
	}

	public int getPage(){
		return page;
	}

	public boolean isSajda(){
		return sajda;
	}

	public int getNumberInSurah(){
		return numberInSurah;
	}

	public int getJuz(){
		return juz;
	}
}