<html>
<body>
    <h2>Jersey RESTful Web Application!</h2>
    <p><a href="webapi/myresource">Jersey resource</a>
    <p>Visit <a href="http://jersey.java.net">Project Jersey website</a>
    for more information on Jersey!
    
    <form method="post" action="webapi/artikel">
      <label for="artikelid">ArtikelID:</label><br>
	  <input type="text" id="artikelid" name="artikelid"><br>
	  <label for="bezeichnung">Bezeichnung:</label><br>
	  <input type="text" id="bezeichnung" name="bezeichnung"><br>
	  <label for="lagerbestand">Lagerbestand:</label><br>
	  <input type="text" id="lagerbestand" name="lagerbestand"><br>
	  <label for="preis">Preis:</label><br>
	  <input type="text" id="preis" name="preis"><br><br>
	  <input type="submit" value="Submit">
    </form>
</body>
</html>
