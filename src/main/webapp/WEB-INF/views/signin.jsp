<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=1920, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=8">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
    <link rel="icon" href="resources/favicon.ico" />
    <script defer src="https://use.fontawesome.com/releases/v5.6.3/js/all.js" integrity="sha384-EIHISlAOj4zgYieurP0SdoiBYfGJKkgWedPHH4jCzpCXLmzVsw1ouK59MuUtP4a1" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="<c:url value="/resources/css/connection_style.css" />" type="text/css">
    <title>Connexion</title>
</head>
<body>
    <div class="connection_center">
        <h1>Connexion</h1>
        <form action="">
            <p>Email</p>
            <input type="email">
            <p>Mot de passe</p>
            <input type="password">
            <p class="connection_sign_comment">Vous n'avez pas de compte ? <a href="<c:url value="/signup" />">Créer un compte</a></p>
            <input type="button" value="Connexion">
        </form>
    </div>
</body>
</html>
