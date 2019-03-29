<html lang="fr">

<head>
    <%@ include file="header.jsp" %>
    <title>OCEscalade - Topos</title>
</head>

<body>
<header class="header">
    <div class="l-container">
        <%@ include file="menu.jsp" %>
    </div>
    <div class="cb"></div>
    <div class="header-baseline">
        <h1 class="header-baseline-title"><c:out value="${topo.topo_title}"/></h1>
    </div>
</header>

<section class="section">
    <div class="l-container">

        <div id="carousel1">
            <div class="item">
                <div class="item-image">
                    <img src="<c:url value="/resources/images/header/background.jpg"/>" alt="">
                </div>
            </div>
            <div class="item">
                <div class="item-image">
                    <img src="<c:url value="/resources/images/connection/background.jpg"/>" alt="">
                </div>
            </div>
            <div class="item">
                <div class="item-image">
                    <img src="<c:url value="/resources/images/header/background.jpg"/>" alt="">
                </div>
            </div>
            <div class="item">
                <div class="item-image">
                    <img src="<c:url value="/resources/images/connection/background.jpg"/>" alt="">
                </div>
            </div>
            <div class="item">
                <div class="item-image">
                    <img src="<c:url value="/resources/images/header/background.jpg"/>" alt="">
                </div>
            </div>
        </div>

        <h2 class="section-title inner-section-title">Description</h2>

        <p class="topo_description">
            <c:out value="${topo.topo_description}"/>
        </p>

        <p>
            <c:out value="${topo.topo_content}"/>
        </p>
    </div>
</section>

<%@ include file="footer.jsp"%>

<script src="<c:url value="/resources/js/carousel.js" />"></script>

</body>

</html>
