package notes;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.context.FacesContext;

import db.ConnecDB;

public class Login {
	
	private String nom, password, info;
	
	public Login(){}
	
	public void connect(){
		if(!nom.isEmpty() && !password.isEmpty()){
			String req = "select * from login where nom='" + this.nom
			+ "' and password='" + this.password + "'";
			ResultSet res = ConnecDB.Interroger_DB(req);
			FacesContext face = FacesContext.getCurrentInstance();
	        try {
				if(res.next()){
					
					try {
						face.getExternalContext().redirect("menu.jsf");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else this.info="password or name is incorrect!!!";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}else{
			this.info = "veuiller remplir votre nom et votre mot de passe.";
		}
	}
	
	public void register(){
		FacesContext face = FacesContext.getCurrentInstance();
		try {
			face.getExternalContext().redirect("register.jsf");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	
}
