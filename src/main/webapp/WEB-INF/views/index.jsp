<html lang="fr">

<head>
    <%@ include file="header.jsp" %>
    <title>OCEscalade</title>
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
                    <a href="" class="article-learn-more"><span>></span></a>
                </article>
            </c:forEach>
        </div>

        <div class="index-asides">
            <div class="index-asides-container">
                <p class="index-asides-container-title">Derniers commentaires</p>
                <s:iterator value="commentList">
                    <hr class="index-asides-separator">
                    <aside class="index-aside">
                        <div class="index-aside-content">
                            <a class="index-aside-content-title" href=""><s:property value="topo_title" /></a>
                            <p class="index-aside-content-context">laissé par <a href=""><s:property value="nickname"/></a> le <s:property value="creation_date" /></p>
                            <p class="index-aside-content-description">
                                <s:property value="comment_content" />
                            </p>
                        </div>
                        <a href="" class="index-aside-learn-more">Read-more</a>
                    </aside>
                </s:iterator>
            </div>
        </div>
    </div>
</section>

<footer>
    <div class="l-container">
        <div class="footer-about">
            <p class="title">Informations du site</p>
            <p>Ce site est un <strong>projet scolaire</strong>. Il n'affirme donc rien de concret et par conséquent, nous ne serons tenu responsable d'aucun des accidents liés à la mauvaise utilisation de ce site.</p>
        </div>
        <div class="footer-social-media">
            <p class="title">Suivez-nous !</p>
            <div class="footer-social-item">
                <i class="fab fa-facebook-square"></i><a href="" class="footer-social-facebook">Likez notre page
                Facebook</a>
            </div>
            <div class="footer-social-item">
                <i class="fab fa-twitter-square"></i><a href="" class="footer-social-twitter">Suivez-nous sur Twitter</a>
            </div>
            <div class="footer-social-item">
                <i class="fab fa-pinterest-square"></i><a href="" class="footer-social-pinterest">Suivez-nous sur Pinterest</a>
            </div>
        </div>
        <div class="footer-contact-information">
            <p class="title">Contactez-nous</p>
            <p class="footer-info-adresse"><strong>Email : </strong> contact@ocescalade.fr</p>
        </div>
    </div>
    <div class="copyright"><p>Copyright 2019 - All Rights Reserved</p></div>
</footer>
</body>

</html>
