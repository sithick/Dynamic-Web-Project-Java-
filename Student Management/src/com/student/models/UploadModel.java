package com.student.models;

public class UploadModel {
	private Integer fileId;
	private String fileName;
	private String filePath;
	private String fileType;
	private Integer registeruserId;
	
	public UploadModel(String fileName, String filePath, String fileType, Integer registeruserId) {
		this.fileName = fileName;
		this.filePath = filePath;
		this.fileType = fileType;
		this.registeruserId = registeruserId;
	}
	public UploadModel(Integer fileId, String fileName, String filePath, String fileType, Integer registeruserId) {
		super();
		this.fileId = fileId;
		this.fileName = fileName;
		this.filePath = filePath;
		this.fileType = fileType;
		this.registeruserId = registeruserId;
	}
	public UploadModel() {
		// TODO Auto-generated constructor stub
	}
	public Integer getFileId() {
		return fileId;
	}
	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public Integer getRegisteruserId() {
		return registeruserId;
	}
	public void setRegisteruserId(Integer registeruserId) {
		this.registeruserId = registeruserId;
	}
	@Override
	public String toString() {
		return String.format("UploadModel [fileId=%s, fileName=%s, filePath=%s, fileType=%s, registeruserId=%s]",
				fileId, fileName, filePath, fileType, registeruserId);
	}
	
	
}
