package com.example.myquran.repository.local.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Surah {

	@SerializedName("number")
	private int number;

	@SerializedName("englishName")
	private String englishName;

	@SerializedName("numberOfAyahs")
	private int numberOfAyahs;

	@SerializedName("revelationType")
	private String revelationType;

	@SerializedName("name")
	private String name;

	@SerializedName("edition")
	private Edition edition;

	@SerializedName("ayahs")
	private List<AyatItem> ayahs;

	@SerializedName("englishNameTranslation")
	private String englishNameTranslation;

	public int getNumber(){
		return number;
	}

	public String getEnglishName(){
		return englishName;
	}

	public int getNumberOfAyahs(){
		return numberOfAyahs;
	}

	public String getRevelationType(){
		return revelationType;
	}

	public String getName(){
		return name;
	}

	public Edition getEdition(){
		return edition;
	}

	public List<AyatItem> getAyahs(){
		return ayahs;
	}

	public String getEnglishNameTranslation(){
		return englishNameTranslation;
	}
}