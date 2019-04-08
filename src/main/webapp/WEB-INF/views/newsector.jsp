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
        <h1 class="header-baseline-title">Nouveau Secteur</h1>
    </div>
</header>

<section class="section">
    <div class="l-container">

        <form class="new_topo_page_form" action="<c:url value="/addSector/${topo_id}/${site_id}" />" method="post">

            <h2 class="section-title inner-section-title">Informations</h2>

            <label for="name" >Nom du Secteur</label><input class="text" type="text" name="name" id="name">

            <label for="description" >Description</label><textarea name="description" id="description"></textarea>

            <label for="orientation">Orientation du Secteur</label><input class="text" type="text" list="orientation_list" name="orientation" id="orientation">
            <datalist id=orientation_list >
                <c:forEach items="${orientations}" var="ortt">
                <option> <c:out value="${ortt}" />
                    </c:forEach>
            </datalist>

            <input type="submit" id="button" value="Créer">

        </form>

    </div>
</section>

<%@ include file="footer.jsp"%>

</body>

</html>
