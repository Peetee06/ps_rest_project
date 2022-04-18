<!doctype html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1 class="d-inline-flex p-2">Artikel eines Outdoor Onlineshops</h1>
		<p>
			<a class="btn btn-primary" href="webapi/artikel" role="button">Zeige alle Artikel</a>
		<form method="post" action="webapi/artikel">
			<div class="form-group row">
				<label for="artikelid" class="col-sm-1 col-form-label">ArtikelID</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="artikelid" name="artikelid"
						placeholder="ArtikelID">
				</div>
				<div class="col-sm-3">
				<small id="artikelIDHelpInline" class="col-sm-10 text-muted">
					Muss eine natürliche Zahl sein.
				</small>
				</div>
			</div>
			<div class="form-group row">
				<label for="bezeichnung" class="col-sm-1 col-form-label">Bezeichnung</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="bezeichnung" name="bezeichnung"
						placeholder="Bezeichnung">
				</div>
				<div class="col-sm-3">
				<small id="bezeichnungHelpInline" class="col-sm-10 text-muted">
					Bezeichnung des Artikels.
				</small>
				</div>
			</div>
			<div class="form-group row">
				<label for="lagerbestand" class="col-sm-1 col-form-label">Lagerbestand</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="lagerbestand" name="lagerbestand"
						placeholder="Lagerbestand">
				</div>
				<div class="col-sm-3">
				<small id="lagerbestandHelpInline" class="col-sm-10 text-muted">
					Der aktuelle Lagerbestand des Artikels.
				</small>
				</div>
			</div>
			<div class="form-group row">
				<label for="preis" class="col-sm-1 col-form-label">Preis</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="preis" name="preis"
						placeholder="Preis">
				</div>
				<div class="col-sm-3">
				<small id="preisHelpInline" class="col-sm-10 text-muted">
					Dezimalstellen mit Punkt separiert.
				</small>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-10">
					<button type="submit" class="btn btn-primary">Senden</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
