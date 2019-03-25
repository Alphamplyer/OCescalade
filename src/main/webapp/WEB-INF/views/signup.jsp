<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=1920, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=8">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
    <link rel="icon" href="resources/favicon.ico" />
    <script defer src="https://use.fontawesome.com/releases/v5.6.3/js/all.js" integrity="sha384-EIHISlAOj4zgYieurP0SdoiBYfGJKkgWedPHH4jCzpCXLmzVsw1ouK59MuUtP4a1" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="<c:url value="/resources/css/connection_style.css" />" type="text/css">
    <title>Inscription</title>
</head>
<body>
<div class="register_center">
    <h1>Inscription</h1>
    <form action="signup_process" method="post">
        <div class="register_two_column">
            <p>Nom</p>
            <p>Prenom</p>
        </div>
        <div class="register_two_column">
            <input type="text" name="lastName">
            <input type="text" name="firstName">
        </div>
        <div class="register_two_column">
            <p>Pseudonyme</p>
            <p>Date de Naissance</p>
        </div>
        <div class="register_two_column">
            <input type="text" name="nickname">
            <input type="text" name="birthdate">
        </div>
        <p>Email</p>
        <input type="email" name="email">
        <div class="register_two_column">
            <p>Mot de passe</p>
            <p>Confirmation du Mot de passe</p>
        </div>
        <div class="register_two_column">
            <input type="password" name="Passwd">
            <input type="password" name="ComfirmPasswd">
        </div>
        <p class="connection_sign_comment">Vous avez déjà un compte ? <a href="<c:url value="/signin" />">Connectez-vous</a> !</p>
        <input type="button" value="S'inscrire">
    </form>
</div>
</body>
</html>
