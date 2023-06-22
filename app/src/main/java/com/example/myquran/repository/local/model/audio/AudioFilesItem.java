package com.example.myquran.repository.local.model.audio;

import com.google.gson.annotations.SerializedName;

public class AudioFilesItem{

	@SerializedName("format")
	private String format;

	@SerializedName("audio_url")
	private String audioUrl;

	@SerializedName("id")
	private int id;

	@SerializedName("chapter_id")
	private int chapterId;

	@SerializedName("file_size")
	private Double fileSize;

	public String getFormat(){
		return format;
	}

	public String getAudioUrl(){
		return audioUrl;
	}

	public int getId(){
		return id;
	}

	public int getChapterId(){
		return chapterId;
	}

	public Double getFileSize(){
		return fileSize;
	}
}