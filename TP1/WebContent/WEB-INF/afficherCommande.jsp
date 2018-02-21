<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>affichage de la commande</title>
</head>
<body>
	<p>
	${ message }
	</p>
	
	<p>
	Client : <br>
	Nom : ${ commande.client.nom } <br>
	Prenom : ${ commande.client.prenom } <br>
	Adresse de Livraison : ${ commande.client.adresseLivraison } <br>
	Numéro de téléphone : ${ commande.client.numTel } <br>
	Email : ${ commande.client.email } <br>

	</p>
	
	<p>
	Commande : <br>
	Date : ${ commande.date } <br>
	Montant : ${ commande.montant } <br>
	Mode de paiement : ${ commande.modePaiement } <br>
	Statut de paiement : ${ commande.statutPaiement } <br>
	Mode de Livraison : ${ commande.modeLivraison } <br>
	Statut de Livraison : ${ commande.statutLivraison } <br>
	</p>
</body>
</html>