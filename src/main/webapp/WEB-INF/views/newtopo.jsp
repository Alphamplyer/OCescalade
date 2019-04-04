<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="fr">

<head>
    <%@ include file="header.jsp" %>
    <title>OCEscalade - Nouveau Topo</title>
</head>

<body>
<header class="header">
    <div class="l-container">
        <%@ include file="menu.jsp" %>
    </div>
    <div class="cb"></div>
    <div class="header-baseline">
        <h1 class="header-baseline-title">Nouveau Topo</h1>
    </div>
</header>

<section class="section">
    <div class="l-container">

        <form class="new_topo_page_form" action="<c:url value="/addTopo" />" method="post">

            <h2 class="section-title inner-section-title">Informations</h2>

            <label id="bookable_label" for="bookable">Reservable</label><input type="checkbox" id="bookable" name="bookable">

            <label for="title" >Titre</label><input type="text" name="title" id="title">

            <label for="description" >Description</label><textarea name="description" id="description"></textarea>

            <label for="content" >Contenu</label><textarea name="content" id="content"></textarea>

            <input type="submit" id="button" value="Créer">

        </form>

    </div>
</section>

<%@ include file="footer.jsp"%>

</body>

</html>
