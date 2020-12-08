package com.noteappreact.model;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="notes")
//@Proxy(lazy=false) 
public class Notes {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	@NotEmpty
	private String userName;  	
	@Size(max = 500, message = "Enter at least 10 Characters...")
	private String notes;
	private LocalDateTime creationTime;
	private LocalDateTime updatedTime;
	@Column(name="deleteFlag")
	private boolean deleteFlag;
	@Column(name="archiveFlag")
	private boolean archiveFlag;
	public Notes() {}
	public Notes(Long id, String userName, String notes, LocalDateTime creationTime, LocalDateTime updatedTime) {
		super();
		this.id = id;
		this.userName = userName;
		this.notes = notes;
		this.creationTime = creationTime;
		this.updatedTime=updatedTime;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public LocalDateTime getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(LocalDateTime creationTime) {
		this.creationTime = creationTime;
	}

	public LocalDateTime getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(LocalDateTime updatedTime) {
		this.updatedTime = updatedTime;
	}
	public boolean isArchiveFlag() {
		return archiveFlag;
	}
	public void setArchiveFlag(boolean archiveFlag) {
		this.archiveFlag = archiveFlag;
	}
}

