<%@ include file="/includes/header.jsp" %>

<script language="JavaScript">
	function fermer() {

	}
</script>

<body>
	<p align="center"></p>
	<p align="center">
		<font face="Arial" size="4"><u>Médiathèque de POLYTECH </u></font>
	</p>
	<p align="center">
		<font color="#004080" face="Arial" size="4">Gestion de
			l'exposition 2016</font>
	</p>
	<p align="left">
		<font color="#004080" face="Arial"><u>Sélectionnez la
				fonctionnalité voulue:</u></font>
	</p>
	<ul>
		<li><a href="Controleur?action=ajouterAdherent"><font
				face="Arial">Ajout Adhérent</font></a></li>
		<li><a href="Controleur?action=listerAdherent"><font
				face="Arial">Lister les adhérents</font></a><font face="Arial"> </font></li>
		<li><a href="Controleur?action=listerOeuvres"><font
				face="Arial">Lister les oeuvres</font></a><font face="Arial"> </font></li>
	</ul>

<%@ include file="/includes/footer.jsp" %>