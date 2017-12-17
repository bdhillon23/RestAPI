package org.dhillon.balwinder.messenger.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
	
	private long id;
	private String message;
	private Date created;
	private String author;
	List<Links> links=new ArrayList<>();
	
	public Message(){
		
	}
	public List<Links> getLinks() {
		return links;
	}

	public void setLinks(List<Links> links) {
		this.links = links;
	}
	
	
	
	public Message(long id,String message,String author){
		this.id=id;
		this.message=message;
		this.author=author;
		this.created=new Date();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void addLink(String Url,String rel){
		Links link=new Links();
		link.setLink(Url);
		link.setRel(rel);
		links.add(link);
	}
	
	
}
