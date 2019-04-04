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
        <h1 class="header-baseline-title">Topos</h1>
    </div>
</header>

<c:if test="${sessionScope.user_data != null}">
    <a class="new_topo_button" href="<c:url value="/newtopo" />">Nouveau Topo</a>
</c:if>

<section class="section">
    <div class="l-container">
        <h2 class="section-title">Rechercher</h2>

        <!-- IF search is global -->
        <c:if test="${global_search_page}">
            <form method="get" action="<c:url value="/global_search" />" class="section-searchbar searchbar">
        </c:if>

        <!-- ELSE -->
        <c:if test="${!global_search_page}">
            <!-- IF is bookable page -->
            <c:if test="${bookable}">
                <form method="get" action="<c:url value="/bookable_topos_search" />" class="section-searchbar searchbar">
            </c:if>

            <!-- ELSE -->
            <c:if test="${!bookable}">
                <form method="get" action="<c:url value="/topos_search" />" class="section-searchbar searchbar">
            </c:if>
        </c:if>

            <input class="searchbar-txt" type="text" placeholder="Search.." name="topo_search" value="${param["topo_search"]}"/>
            <button class="searchbar-bnt" type="submit"/>
                <i class="fas fa-search"></i>
            </button>
        </form>

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
                    <a href="<c:url value="/topo/${listTopo.id}" />" class="article-learn-more"><span>></span></a>
                </article>
            </c:forEach>
        </div>

        <c:if test="${number_topo_founded > 0}">
            <!-- IF search is global -->
            <c:if test="${global_search_page}">
                <div class="section-page">
                    <a href="<c:url value="/global_search/1?topo_search=${search}" />" class="section-page-item start <c:if test="${!exist_prev_page}">inactive</c:if>"><span>&lt;&lt;</span></a>
                    <a href="<c:url value="/global_search/${actual_page - 1}?topo_search=${search}" />" class="section-page-item prev <c:if test="${!exist_prev_page}">inactive</c:if>"><span>&lt;</span></a>

                    <a href="" class="section-page-item number"><span><c:out value="${actual_page}" /></span></a>

                    <a href="<c:url value="/global_search/${actual_page + 1}?topo_search=${search}" />" class="section-page-item next <c:if test="${!exist_next_page}">inactive</c:if>"><span>&gt;</span></a>
                    <a href="<c:url value="/global_search/${max_page}?topo_search=${search}" />" class="section-page-item end <c:if test="${!exist_next_page}">inactive</c:if>"><span>&gt;&gt;</span></a>
                </div>
            </c:if>
            <!-- ELSE -->
            <c:if test="${!global_search_page}">
                <!-- IF is bookable page -->
                <c:if test="${bookable}">
                    <c:if test="${search != null}">
                        <div class="section-page">
                            <a href="<c:url value="/bookable_topos_search/1?topo_search=${search}" />" class="section-page-item start <c:if test="${!exist_prev_page}">inactive</c:if>"><span>&lt;&lt;</span></a>
                            <a href="<c:url value="/bookable_topos_search/${actual_page - 1}?topo_search=${search}" />" class="section-page-item prev <c:if test="${!exist_prev_page}">inactive</c:if>"><span>&lt;</span></a>

                            <a href="" class="section-page-item number"><span><c:out value="${actual_page}" /></span></a>

                            <a href="<c:url value="/bookable_topos_search/${actual_page + 1}?topo_search=${search}" />" class="section-page-item next <c:if test="${!exist_next_page}">inactive</c:if>"><span>&gt;</span></a>
                            <a href="<c:url value="/bookable_topos_search/${max_page}?topo_search=${search}" />" class="section-page-item end <c:if test="${!exist_next_page}">inactive</c:if>"><span>&gt;&gt;</span></a>
                        </div>
                    </c:if>
                    <c:if test="${search == null}">
                        <div class="section-page">
                            <a href="<c:url value="/bookable_topos/1" />" class="section-page-item start <c:if test="${!exist_prev_page}">inactive</c:if>"><span>&lt;&lt;</span></a>
                            <a href="<c:url value="/bookable_topos/${actual_page - 1}" />" class="section-page-item prev <c:if test="${!exist_prev_page}">inactive</c:if>"><span>&lt;</span></a>

                            <a href="" class="section-page-item number"><span><c:out value="${actual_page}" /></span></a>

                            <a href="<c:url value="/bookable_topos/${actual_page + 1}" />" class="section-page-item next <c:if test="${!exist_next_page}">inactive</c:if>"><span>&gt;</span></a>
                            <a href="<c:url value="/bookable_topos/${max_page}" />" class="section-page-item end <c:if test="${!exist_next_page}">inactive</c:if>"><span>&gt;&gt;</span></a>
                        </div>
                    </c:if>
                </c:if>

                <!-- ELSE -->
                <c:if test="${!bookable}">
                    <c:if test="${search != null}">
                        <div class="section-page">
                            <a href="<c:url value="/topos_search/1?topo_search=${search}" />" class="section-page-item start <c:if test="${!exist_prev_page}">inactive</c:if>"><span>&lt;&lt;</span></a>
                            <a href="<c:url value="/topos_search/${actual_page - 1}?topo_search=${search}" />" class="section-page-item prev <c:if test="${!exist_prev_page}">inactive</c:if>"><span>&lt;</span></a>

                            <a href="" class="section-page-item number"><span><c:out value="${actual_page}" /></span></a>

                            <a href="<c:url value="/topos_search/${actual_page + 1}?topo_search=${search}" />" class="section-page-item next <c:if test="${!exist_next_page}">inactive</c:if>"><span>&gt;</span></a>
                            <a href="<c:url value="/topos_search/${max_page}?topo_search=${search}" />" class="section-page-item end <c:if test="${!exist_next_page}">inactive</c:if>"><span>&gt;&gt;</span></a>
                        </div>
                    </c:if>
                    <c:if test="${search == null}">
                        <div class="section-page">
                            <a href="<c:url value="/topos/1" />" class="section-page-item start <c:if test="${!exist_prev_page}">inactive</c:if>"><span>&lt;&lt;</span></a>
                            <a href="<c:url value="/topos/${actual_page - 1}" />" class="section-page-item prev <c:if test="${!exist_prev_page}">inactive</c:if>"><span>&lt;</span></a>

                            <a href="" class="section-page-item number"><span><c:out value="${actual_page}" /></span></a>

                            <a href="<c:url value="/topos/${actual_page + 1}" />" class="section-page-item next <c:if test="${!exist_next_page}">inactive</c:if>"><span>&gt;</span></a>
                            <a href="<c:url value="/topos/${max_page}" />" class="section-page-item end <c:if test="${!exist_next_page}">inactive</c:if>"><span>&gt;&gt;</span></a>
                        </div>
                    </c:if>
                </c:if>
            </c:if>
        </c:if>
    </div>
</section>

<%@ include file="footer.jsp" %>

</body>

</html>
