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

        <h2 class="section-title inner-section-title">Sites</h2>

        <c:forEach items="${sites}" var="site">
            <article class="article_site">
                <div class="article_site_header">
                    <h3 class="article_site_header_title"><c:out value="${site.site_name}" /></h3>
                    <p class="article_site_header_description"><c:out value="${site.site_description}" /></p>
                    <span class="article_site_header_rocktype">Type de roche : <c:out value="${site.rock_type}" /></span>
                    <span class="article_site_header_elevation" >Altitude du site : <c:out value="${site.site_elevation}" /></span>
                </div>
                <div class="article_site_body">
                    <c:forEach items="${site.sectors}" var="sector">
                        <div class="sector">
                            <h4 class="sector_name"><c:out value="${sector.sector_name}" /></h4>
                            <p class="sector_description"><c:out value="${sector.sector_description}" /></p>
                            <span class="sector_orientation">Orientation : <c:out value="${sector.orientation}" /></span>
                            <a href="<c:url value="/sector/${sector.id}" />" class="sector-learn-more"><span>></span></a>
                        </div>
                    </c:forEach>
                </div>
            </article>
        </c:forEach>

        <h2 class="section-title inner-section-title">Commentaires</h2>

        <div class="comment_section">
            <c:choose>
                <c:when test="${sessionScope.user_data == null}">
                    <p>Pour laisser un commentaire vous devez être <a href="<c:url value="/signin" />">connecté</a>. Si vous n'êtes pas inscrit, vous pouvez le faire <a href="<c:url value="/signup" />">ici</a></p>
                </c:when>
                <c:otherwise>
                    <form class="comment_section_input" action="/addComment">
                        <textarea type="text" name="content" placeholder="Toi aussi laisse ton avis ..."></textarea>
                        <input type="submit">
                    </form>
                </c:otherwise>
            </c:choose>
        </div>

        <c:forEach items="${comments}" var="comment">
            <div id="${comment.id}" class="topo_comment">
                <a href="<c:url value="/user/${comment.user.id}" />" class="comment_username"><c:out value="${comment.user.nickname}" /></a>
                <p class="comment_date">Le <f:formatDate value="${comment.creation_date}" pattern="dd-MM-yyyy" /> à <f:formatDate value="${comment.creation_date}" pattern="hh" /> h <f:formatDate value="${comment.creation_date}" pattern="mm" /></p>
                <p class="comment_content"><c:out value="${comment.comment_content}" /></p>
                <c:if test="${comment.edited}">
                    <p class="comment_edited">(Edited)</p>
                </c:if>
                <c:forEach items="${comment.reply_comments}" var="reply_comment">
                    <div class="topo_comment topo_reply_comment">
                        <a href="<c:url value="/user/${reply_comment.user.id}" />" class="comment_username"><c:out value="${reply_comment.user.nickname}" /></a>
                        <p class="comment_date">Le <f:formatDate value="${reply_comment.creation_date}" pattern="dd-MM-yyyy" /> à <f:formatDate value="${reply_comment.creation_date}" pattern="hh" /> h <f:formatDate value="${reply_comment.creation_date}" pattern="mm" /></p>
                        <p class="comment_content"><c:out value="${reply_comment.comment_content}" /></p>
                        <c:if test="${reply_comment.edited}">
                            <p class="comment_edited">(Edited)</p>
                        </c:if>
                    </div>
                </c:forEach>
            </div>
        </c:forEach>
    </div>
</section>

<%@ include file="footer.jsp"%>

<script src="<c:url value="/resources/js/carousel.js" />"></script>

</body>

</html>
