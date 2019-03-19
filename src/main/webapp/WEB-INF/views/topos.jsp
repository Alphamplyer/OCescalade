<html lang="fr">

<head>
    <%@ include file="header.jsp" %>
    <title>OCEscalade - Topos</title>
</head>

<body>
<header class="header">
    <div class="l-container">
        <%@ include file="menu.jsp" %>
        <div class="menu-searchbar searchbar">
            <input class="searchbar-txt" type="text" placeholder="Search..">
            <a class="searchbar-bnt" href="">
                <i class="fas fa-search"></i>
            </a>
        </div>
    </div>
    <div class="cb"></div>
    <div class="header-baseline">
        <h1 class="header-baseline-title">Topos</h1>
    </div>
</header>
<section class="section">
    <div class="l-container">
        <h2 class="section-title">Rechercher</h2>
        <div class="section-searchbar searchbar">
            <input class="searchbar-txt" type="text" placeholder="Search..">
            <a class="searchbar-bnt" href="">
                <i class="fas fa-search"></i>
            </a>
        </div>

        <p><c:out value="${number_topo_founded}" /> Topo(s) trouvé(s)</p>

        <div class="articles topo-articles">
            <c:forEach items="${listTopo}" var="listTopo">
                <article class="article">
                    <div class="article-image"></div>
                    <div class="article-content">
                        <h3 class="article-content-title"><a href=""><c:out value="${listTopo.topo_title}" /></a></h3>
                        <p class="article-content-description"><c:out value="${listTopo.topo_description}" /></p>
                        <div class="article-content-like">
                            <span><c:out value="${listTopo.topo_like}" /></span><i class="far fa-eye"></i>
                            <span><c:out value="${listTopo.topo_vues}" /></span><i class="far fa-heart"></i>
                        </div>
                    </div>
                    <a href="" class="article-learn-more"><span>></span></a>
                </article>
            </c:forEach>
        </div>


        <div class="section-page">
            <c:if test="${!exist_prev_page}">
                <a href="" class="section-page-item prev inactive"><span>&lt;&lt;</span></a>
                <a href="" class="section-page-item prev inactive"><span>&lt;</span></a>
            </c:if>
            <c:if test="${exist_prev_page}">
                <a href="topos/1" class="section-page-item start">
                    <span>&lt;&lt;</span>
                </a>
                <a href="topos/${actual_page - 1}" class="section-page-item prev">
                    <span>&lt;</span>
                </a>
            </c:if>
            <a href="" class="section-page-item number"><span><c:out value="${actual_page}" /></span></a>
            <c:if test="${!exist_next_page}">
                <a href="" class="section-page-item next inactive"><span>&gt;</span></a>
                <a href="" class="section-page-item end inactive"><span>&gt;&gt;</span></a>
            </c:if>
            <c:if test="${exist_next_page}">
                <a href="topos/${actual_page + 1}" class="section-page-item next">
                    <span>&gt;</span>
                </a>
                <a href="topos/${max_page}" class="section-page-item end">
                    <span>&gt;&gt;</span>
                </a>
            </c:if>
        </div>
    </div>
</section>

<%@ include file="footer.jsp" %>

</body>

</html>
