package com.sdzee.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdzee.beans.Client;
import com.sdzee.beans.Commande;

public class CreationCommande extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		Client client = new Client();
		client.setAdresseLivraison(req.getParameter("adresseClient").trim());
		client.setEmail(req.getParameter("emailClient"));
		client.setNom(req.getParameter("nomClient").trim());
		client.setPrenom(req.getParameter("prenomClient").trim());
		client.setNumTel(req.getParameter("telephoneClient").trim());

		Commande commande = new Commande();
		String montantString = req.getParameter("montantCommande").trim();
		commande.setModePaiement(req.getParameter("modePaiementCommande").trim());
		commande.setStatutPaiement(req.getParameter("statutPaiementCommande"));
		commande.setModeLivraison(req.getParameter("modeLivraisonCommande").trim());
		commande.setStatutLivraison(req.getParameter("statutLivraisonCommande"));

		
		DateFormat dateFromat = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
		Date date = Calendar.getInstance().getTime();
		String dateString = dateFromat.format(date);

		commande.setDate(dateString);
		commande.setClient(client);

		//montantString to double
		double montant;
		try {
			montant = Double.parseDouble(montantString);
		} catch (NumberFormatException e) {
			montant = -1;
		}
		
		commande.setMontant(montant);

		
		String message = "";
		
		if(!commande.isCorrect())
			message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires.<br> <a href=\"creerCommande.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'une commande.";
		else
			message = "Commande créée avec succès !";
		

		req.setAttribute("message", message);
		req.setAttribute("commande", commande);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/afficherCommande.jsp").forward(req, resp);
	}
}
