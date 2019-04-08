<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="fr">

<head>
    <%@ include file="header.jsp" %>
    <title>OCEscalade - Réservation</title>
</head>

<body>
<header class="header">
    <div class="l-container">
        <%@ include file="menu.jsp" %>
    </div>
    <div class="cb"></div>
    <div class="header-baseline">
        <h1 class="header-baseline-title">Réservation</h1>
    </div>
</header>

<section class="section">
    <div class="l-container">

        <form class="new_topo_page_form" action="<c:url value="/reserve/${topo_id}" />" method="post">

            <h2 class="section-title inner-section-title">Reserver</h2>

            <label for="begin_date" >Du</label><textarea name="begin_date" id="begin_date"></textarea>

            <label for="end_date">Au</label><input class="text" type="text" name="end_date" id="end_date">

            <c:if test="${er != null}">
                <p class="error_label">La date doit être au format jour/mois/année</p>
            </c:if>

            <input type="submit" id="button" value="Réserver">

        </form>

    </div>
</section>

<%@ include file="footer.jsp"%>

</body>

</html>
