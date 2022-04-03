package model.bo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name = "demandes")
public class Postulations {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	private String cv;
	private String lm;
	
	@ManyToOne
    @JoinColumn(name = "fk_user")
	private User demandeur;
	
	@ManyToOne
    @JoinColumn(name = "fk_offre")
	private Offre offre;
	
	
	public Postulations(String cv, String lm) {
		super();
		this.cv = cv;
		this.lm = lm;
		this.date = new Date();
	}


	public User getDemandeur() {
		return demandeur;
	}


	public void setDemandeur(User demandeur) {
		this.demandeur = demandeur;
	}


	public Offre getOffre() {
		return offre;
	}


	public void setOffre(Offre offre) {
		this.offre = offre;
	}


	public Postulations() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getCv() {
		return cv;
	}


	public void setCv(String cv) {
		this.cv = cv;
	}


	public String getLm() {
		return lm;
	}


	public void setLm(String lm) {
		this.lm = lm;
	}
	
	
	
	
	

	
}
