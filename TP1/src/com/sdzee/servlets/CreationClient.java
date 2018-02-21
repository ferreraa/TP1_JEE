package com.sdzee.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdzee.beans.Client;

public class CreationClient extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			

		Client client = new Client();
		client.setAdresseLivraison(req.getParameter("adresseClient").trim());
		client.setEmail(req.getParameter("emailClient"));
		client.setNom(req.getParameter("nomClient").trim());
		client.setPrenom(req.getParameter("prenomClient").trim());
		client.setNumTel(req.getParameter("telephoneClient").trim());
		
		
		String message; //message displayed to the client, indicating whether there's a problem or not
		if(!client.isCorrect())
			message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires.<br> <a href=\"creerClient.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'un client.";
		else
			message = "Client créé avec succès !";
		
		
		
		req.setAttribute("message", message);
		req.setAttribute("client", client);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/afficherClient.jsp").forward(req, resp);
	}
}
