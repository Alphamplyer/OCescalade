<a href="<c:url value="/index" />" class="header-logo">OCEscalade</a>
<nav class="menu">
    <a class="menu-item" href="<c:url value="/topos" />">Topos</a>
    <span>//</span><a class="menu-item" href="<c:url value="/bookable_topos" />">Topos réservable</a>
    <span>//</span><a class="menu-item" href="<c:url value="/about" />">A Propos</a>
    <c:choose>
        <c:when test="${sessionScope.user_data == null}">
            <span>//</span><a class="menu-item" href="<c:url value="/signin" />">Connexion</a>
        </c:when>
        <c:otherwise>
            <span>//</span><a class="menu-item" href="<c:url value="/signout" />">Déconnexion</a>
        </c:otherwise>
    </c:choose>
</nav>
<form method="get" action="<c:url value="/global_search" />" class="menu-searchbar searchbar">
    <input class="searchbar-txt" type="text" placeholder="Search.." name="topo_search">
    <button class="searchbar-bnt" type="submit"/>
    <i class="fas fa-search"></i>
    </button>
</form>
