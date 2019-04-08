<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="fr">

<head>
    <%@ include file="header.jsp" %>
    <title>OCEscalade - Nouveau Secteur</title>
</head>

<body>
<header class="header">
    <div class="l-container">
        <%@ include file="menu.jsp" %>
    </div>
    <div class="cb"></div>
    <div class="header-baseline">
        <h1 class="header-baseline-title">Nouvelle Voie</h1>
    </div>
</header>

<section class="section">
    <div class="l-container">

        <form class="new_topo_page_form" action="<c:url value="/addway/${topo_id}/${site_id}/${sector_id}" />" method="post">

            <h2 class="section-title inner-section-title">Informations</h2>

            <label for="name" >Nom de la voie</label><input class="text" type="text" name="name" id="name">

            <label for="description" >Description</label><textarea name="description" id="description"></textarea>

            <label for="height" >Hauteur de la voie (Sa longueur. Exemple : 67.30)</label><input class="text" type="text" name="height" id="height">

            <label for="quotation">Notation de la voie</label><input class="text" type="text" list="quotation_list" name="quotation" id="quotation">
            <datalist id=quotation_list >
                <c:forEach items="${quotations}" var="quotation">
                    <option> <c:out value="${quotation}" />
                </c:forEach>
            </datalist>

            <input type="submit" id="button" value="Créer">

        </form>

    </div>
</section>

<%@ include file="footer.jsp"%>

</body>

</html>
