package com.yc.cinema.entity;

import java.io.Serializable;

public class FilmBean implements Serializable{
	
	private static final long serialVersionUID = -3599431521998130260L;
		private int filmid;
	    private String filmname;
	    private String typeid;
	    private String actor;
	    private String director;
	    private Double minprice;
	    private Double maxprice;
	    private Double ticketprice;
	    
		public FilmBean() {
		}
		

		public FilmBean(String filmname, String typeid,
				String actor, String director, Double ticketprice) {
			this.filmname = filmname;
			this.typeid = typeid;
			this.actor = actor;
			this.director = director;
			this.ticketprice = ticketprice;
		}

		public int getFilmid() {
			return filmid;
		}


		public void setFilmid(int filmid) {
			this.filmid = filmid;
		}


		public String getFilmname() {
			return filmname;
		}
		public void setFilmname(String filmname) {
			this.filmname = filmname;
		}
		public String getTypeid() {
			return typeid;
		}
		public void setTypeid(String typeid) {
			this.typeid = typeid;
		}
		public String getActor() {
			return actor;
		}
		public void setActor(String actor) {
			this.actor = actor;
		}
		public String getDirector() {
			return director;
		}
		public void setDirector(String director) {
			this.director = director;
		}
		public Double getMinprice() {
			return minprice;
		}
		public void setMinprice(Double minprice) {
			this.minprice = minprice;
		}
		public Double getMaxprice() {
			return maxprice;
		}
		public void setMaxprice(Double maxprice) {
			this.maxprice = maxprice;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		public Double getTicketprice() {
			return ticketprice;
		}

		public void setTicketprice(Double ticketprice) {
			this.ticketprice = ticketprice;
		}

		@Override
		public String toString() {
			return "FilmBean [filmid=" + filmid + ", filmname=" + filmname
					+ ", typeid=" + typeid + ", actor=" + actor + ", director="
					+ director + ", ticketprice=" + ticketprice + "]";
		}
  
	    
}
