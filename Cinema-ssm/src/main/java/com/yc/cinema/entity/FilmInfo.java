package com.yc.cinema.entity;


public class FilmInfo {
    private Integer filmid;

    private String filmname;

    private FilmType type;

    private String actor;

    private String director;

    private Double ticketprice;

    public Integer getFilmid() {
        return filmid;
    }

    public void setFilmid(Integer filmid) {
        this.filmid = filmid;
    }

    public String getFilmname() {
        return filmname;
    }

    public void setFilmname(String filmname) {
        this.filmname = filmname == null ? null : filmname.trim();
    }

   

    public FilmType getType() {
		return type;
	}

	public void setType(FilmType type) {
		this.type = type;
	}

	public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor == null ? null : actor.trim();
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director == null ? null : director.trim();
    }

	public Double getTicketprice() {
		return ticketprice;
	}

	public void setTicketprice(Double ticketprice) {
		this.ticketprice = ticketprice;
	}

	@Override
	public String toString() {
		return "\nFilmInfo [filmid=" + filmid + ", filmname=" + filmname
				+ ", type=" + type + ", actor=" + actor + ", director="
				+ director + ", ticketprice=" + ticketprice + "]";
	}

   
}