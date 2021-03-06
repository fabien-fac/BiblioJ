<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Welcome to Grails</title>
		<style type="text/css" media="screen">
            #status {
                background-color: #eee;
                border: .2em solid #fff;
                margin-left : -19.5em;
                margin-top : 5em;
                padding: 1em;
                width: 16.8em;
                float: left;
                -moz-box-shadow: 0px 0px 1.25em #ccc;
                -webkit-box-shadow: 0px 0px 1.25em #ccc;
                box-shadow: 0px 0px 1.25em #ccc;
                -moz-border-radius: 0.6em;
                -webkit-border-radius: 0.6em;
                border-radius: 0.6em;
            }

			.ie6 #status {
				display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
			}

			#status ul {
				font-size: 0.9em;
				list-style-type: none;
				margin-bottom: 0.6em;
				padding: 0;
			}

			#status li {
				line-height: 1.3;
			}

			#status h1 {
				text-transform: uppercase;
				font-size: 1.1em;
				margin: 0 0 0.3em;
			}

			#page-body {
				margin: 2em 1em 1.25em 18em;
			}

			h2 {
				margin-top: 1em;
				margin-bottom: 0.3em;
				font-size: 1em;
			}

			p {
				line-height: 1.5;
				margin: 0.25em 0;
			}

			#controller-list ul {
				list-style-position: inside;
			}

			#controller-list li {
				line-height: 1.3;
				list-style-position: inside;
				margin: 0.25em 0;
			}

			@media screen and (max-width: 480px) {
				#status {
					display: none;
				}

				#page-body {
					margin: 0 1em 1em;
				}

				#page-body h1 {
					margin-top: 0;
				}
			}
		</style>
	</head>
		<div id="page-body" role="main">
			<h1>Bienvenue sur BiblioJ</h1>
			<p>Ce site vous permettra de consulter l'ensemble des livres de notre bibliothèque ainsi que de réserver
            des ouvrages disponible.
            BiblioJ possède une collection de plus de 1000 livres parmis les plus recherchés en 2012.</p>

			<div id="controller-list" role="navigation">
				<h2>Navigation dans BiblioJ :</h2>
				<ul>
                    <li class="controller"><g:link controller="livre" action="index">Liste des livres</g:link></li>
                    <li class="controller"><g:link controller="auteur" action="index">Liste des auteurs</g:link></li>
				</ul>
			</div>
		</div>
	</body>
</html>
