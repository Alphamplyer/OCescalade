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
    <form method="post" action="<c:url value="/signup_process" />">
        <div class="register_two_column">
            <p>Nom</p>
            <p>Prenom</p>
        </div>
        <div class="register_two_column">
            <input class="<c:if test="${valid_lastName != null && !valid_lastName || failed != null && failed}">failed</c:if>" type="text" name="lastName" value="${lastName}">
            <input class="<c:if test="${valid_firstName != null && !valid_firstName || failed != null && failed}">failed</c:if>" type="text" name="firstName" value="${firstName}">
        </div>
        <div class="register_two_column">
            <p>Pseudonyme</p>
            <p>Date de Naissance</p>
        </div>
        <div class="register_two_column">
            <input class="<c:if test="${valid_nickname != null && !valid_nickname || failed != null && failed}">failed</c:if>" type="text" name="nickname" value="${nickname}">
            <input class="<c:if test="${valid_birthdate != null && !valid_birthdate || failed != null && failed}">failed</c:if>" type="text" name="birthdate" value="${birthdate}">
        </div>
        <p>Email</p>
        <input class="<c:if test="${valid_email != null && !valid_email || failed != null && !valid_nickname}">failed</c:if>" type="email" name="email" value="${email}">
        <div class="register_two_column">
            <p>Mot de passe</p>
            <p>Confirmation du Mot de passe</p>
        </div>
        <div class="register_two_column">
            <input class="<c:if test="${valid_passwd != null && !valid_passwd || failed != null && failed}">failed</c:if>" type="password" name="Passwd">
            <input class="<c:if test="${valid_passwd != null && !valid_passwd || failed != null && failed}">failed</c:if>" type="password" name="ComfirmPasswd">
        </div>
        <p class="connection_sign_comment">Vous avez déjà un compte ? <a href="<c:url value="/signin" />">Connectez-vous</a> !</p>
        <input type="submit" value="S'inscrire">
    </form>
</div>
</body>
</html>
