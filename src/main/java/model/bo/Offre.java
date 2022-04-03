package model.bo;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "offre")
public class Offre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String titre;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private String description;

	@ManyToOne
	@JoinColumn(name = "fk_user")
	private User createur;

	@ManyToOne
	@JoinColumn(name = "fk_type")
	private TypeOffre type;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "offre", cascade = CascadeType.ALL)
	private Set<Postulations> mesDemandes;

	public Set<Postulations> getMesDemandes() {
		return mesDemandes;
	}

	public void setMesDemandes(Set<Postulations> mesDemandes) {
		this.mesDemandes = mesDemandes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TypeOffre getType() {
		return type;
	}

	public User getCreateur() {
		return createur;
	}

	public void setCreateur(User createur) {
		this.createur = createur;
	}

	public void setType(TypeOffre type) {
		this.type = type;
	}

	public Offre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Offre(String titre, String description) {
		super();
		this.titre = titre;
		this.description = description;
		this.date = new Date();
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Offre [id=" + id + ", titre=" + titre + ", description=" + description + ", createur=" + createur
				+ ", type=" + type + "]";
	}

}
