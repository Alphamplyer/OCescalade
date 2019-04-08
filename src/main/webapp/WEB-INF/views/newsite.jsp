<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="fr">

<head>
    <%@ include file="header.jsp" %>
    <title>OCEscalade - Nouveau Site</title>
</head>

<body>
<header class="header">
    <div class="l-container">
        <%@ include file="menu.jsp" %>
    </div>
    <div class="cb"></div>
    <div class="header-baseline">
        <h1 class="header-baseline-title">Nouveau Site</h1>
    </div>
</header>

<section class="section">
    <div class="l-container">

        <form class="new_topo_page_form" action="<c:url value="/addSite/${topo_id}" />" method="post">

            <h2 class="section-title inner-section-title">Informations</h2>

            <label for="name" >Nom du Site</label><input class="text" type="text" name="name" id="name">

            <label for="description" >Description</label><textarea name="description" id="description"></textarea>

            <label for="elevation" >Hauteur du site (Altitude Géographique en mètre, ex : 21.5)</label><input class="text" type="text" name="elevation" id="elevation">

            <label for="rock_type">Type de roche</label><input class="text" type="text" list="rock_type_list" name="rock_type" id="rock_type">
            <datalist id=rock_type_list >
                <c:forEach items="${rock_types}" var="rt">
                    <option> <c:out value="${rt}" />
                </c:forEach>
            </datalist>

            <input type="submit" id="button" value="Créer">

        </form>

    </div>
</section>

<%@ include file="footer.jsp"%>

</body>

</html>
