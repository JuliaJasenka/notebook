package edu.examples.java_classes.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import edu.examples.java_classes.util.GenerateId;

public class Note {

	private int id;
	private String title;
	private String content;
	private Date date;

	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
    {simpleDateFormat.applyPattern("yyyy-MM-dd");}
	
	public Note() {
		this.id = GenerateId.nextId();
	}

	public Note(String title, String content, Date date) {
		this.id = GenerateId.nextId();
		this.title = title;
		this.content = content;
		this.date = date;
	}

	public Note(String title, String content) {
		this.id = GenerateId.nextId();
		this.title = title;
		this.content = content;
		this.date = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getData() {
		return date;
	}

	public void setData(Date date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(content, date, id, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Note other = (Note) obj;
		return Objects.equals(content, other.content) && Objects.equals(date, other.date) && id == other.id
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Note [id=" + id + ", title=" + title + ", content=" + content + ", data=" + (date==null?null : simpleDateFormat.format(date)) + "]";
	}

}
