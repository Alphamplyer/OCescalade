<html lang="fr">

<head>
    <%@ include file="header.jsp" %>
    <title>OCEscalade</title>
</head>

<body>
<header class="header">
    <div class="l-container">
        <%@ include file="menu.jsp" %>
    </div>
    <div class="cb"></div>
    <div class="header-baseline">
        <h1 class="header-baseline-title">Accueil</h1>
    </div>
</header>

<section class="section">
    <div class="l-container">
        <div class="articles">
            <h2 class="section-title">Nouveautés</h2>
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

        <div class="index-asides">
            <div class="index-asides-container">
                <p class="index-asides-container-title">Derniers commentaires</p>
                <c:forEach items="${listComment}" var="comment">
                    <hr class="index-asides-separator">
                    <aside class="index-aside">
                        <div class="index-aside-content">
                            <a class="index-aside-content-title" href="<c:url value="/topo/${comment.topo_id}" />"><c:out value="${comment.topo_title}" /></a>
                            <p class="index-aside-content-context">laissé par <a href=""><c:out value="${comment.user.nickname}"/></a> le <f:formatDate value="${comment.creation_date}" pattern="dd-MM-yyyy" /></p>
                            <p class="index-aside-content-description">
                                <c:out value="${comment.comment_content}" />
                            </p>
                        </div>
                        <a href="<c:url value="/topo/${comment.topo_id}#${comment.id}" />" class="index-aside-learn-more">Read-more</a>
                    </aside>
                </c:forEach>
            </div>
        </div>
    </div>
</section>

<%@ include file="footer.jsp"%>

</body>

</html>
