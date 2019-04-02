<html lang="fr">

<head>
    <%@ include file="header.jsp" %>
    <title>OCEscalade - Sector</title>
</head>

<body>
<header class="header">
    <div class="l-container">
        <%@ include file="menu.jsp" %>
    </div>
    <div class="cb"></div>
    <div class="header-baseline">
        <h1 class="header-baseline-title"><c:out value="${sector.sector_name}"/></h1>
    </div>
</header>

<section class="section">
    <div class="l-container">
        <h2 class="section-title inner-section-title">Description</h2>

        <p><c:out value="${sector.sector_description}"/></p>

        <h2 class="section-title inner-section-title">Description</h2>

        <c:forEach items="${ways}" var="way">
            <div class="sector_way">
                <h3 class="title"><c:out value="${way.way_name}" /></h3>
                <p class="description"><c:out value="${way.way_description}" /></p>
                <span class="height"><c:out value="${way.height}"</span>
                <span class="quotation"><c:out value="${way.quotation}" /></span>
            </div>
        </c:forEach>
    </div>
</section>

<%@ include file="footer.jsp"%>

<script src="<c:url value="/resources/js/carousel.js" />"></script>

</body>

</html>
