package de.noltetrost.ps_rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class DatabaseHandler {

	Statement statement;
	Connection con;

	public Artikel[] leseEinenArtikel(int artikelID)
			throws SQLException { 
		ResultSet ergebnis;
		ergebnis = this.statement.executeQuery(
				"SELECT * FROM artikel WHERE artikelid = " + artikelID);
		Vector<Artikel> artikel_vector = new Vector<Artikel>();
		while(ergebnis.next()) {
			artikel_vector.add( 
					new Artikel(
							Integer.parseInt(ergebnis.getString(1)),
							ergebnis.getString(2),
							Integer.parseInt(ergebnis.getString(3)),
							Double.parseDouble(ergebnis.getString(4))));
		}
		ergebnis.close();
		Artikel[] artikel_array = artikel_vector.toArray(new Artikel[0]);
		return artikel_array;
	}

	public Artikel[] leseAlleArtikel()
			throws SQLException { 
		ResultSet ergebnis;
		ergebnis = this.statement.executeQuery(
				"SELECT * FROM artikel");
		Vector<Artikel> artikel = new Vector<Artikel>();
		while(ergebnis.next()) {
			artikel.add( 
					new Artikel(
							Integer.parseInt(ergebnis.getString(1)),
							ergebnis.getString(2),
							Integer.parseInt(ergebnis.getString(3)),
							Double.parseDouble(ergebnis.getString(4))));
		}
		ergebnis.close();
		return artikel.toArray(new Artikel[artikel.size()]);
	}

	public void fuegeArtikelEin(Artikel artikel)
			throws SQLException {
		String insertArtikelStatement = "INSERT INTO artikel "
				+ "(artikelid, bezeichnung, lagerbestand, preis) "
				+ "VALUES(" 
				+ artikel.getArtikelID() + ", '" 
				+ artikel.getBezeichnung() + "', " 
				+ artikel.getLagerbestand() + ", "
				+ artikel.getPreis() + ")";
		System.out.println(insertArtikelStatement);
		this.statement.executeUpdate(insertArtikelStatement);
	}

	public void connectDb()
			throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		this.con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/outdoorshop?"
						+ "zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC",		     
						"Student", null); 
		this.statement = this.con.createStatement();
	}

	public void closeDb()
			throws SQLException {
		this.con.close();
	}

}
