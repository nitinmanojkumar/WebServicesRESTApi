package org.Myweb.showroom.model;

public class Link {

	private String link,rel;

	public Link(String link, String rel) {
		super();
		this.link = link;
		this.rel = rel;
	}

	public Link() {
		super();
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}
	
	
	
}
