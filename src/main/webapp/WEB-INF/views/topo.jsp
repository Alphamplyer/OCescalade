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

        <c:if test="${topo.is_bookable}">
            <c:choose>
                <c:when test="${organizer != null}">
                    <div class="reservation_container">
                        <p class="reservation"><b>Réservé par :</b> <a class="inline_link" href="<c:url value="/user/${organizer.id}" />"><c:out value="${organizer.nickname}" /></a></p>
                        <p class="reservation_bd"><b>Du :</b> <f:formatDate value="${topo.begin_date}" pattern="dd-MM-yyyy" /> à <f:formatDate value="${topo.begin_date}" pattern="hh" /> h <f:formatDate value="${topo.begin_date}" pattern="mm" /></p>
                        <p class="reservation_ed"><b>Au :</b> <f:formatDate value="${topo.end_date}" pattern="dd-MM-yyyy" /> à <f:formatDate value="${topo.end_date}" pattern="hh" /> h <f:formatDate value="${topo.end_date}" pattern="mm" /></p>
                    </div>
                </c:when>
                <c:otherwise>
                    <c:if test="${sessionScope.user_data != null}">
                        <a class="button button-right reservation_button" href="<c:url value="/reservation/${topo.id}" />">Réserver</a>
                    </c:if>
                </c:otherwise>
            </c:choose>
        </c:if>

        <!--
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
        </div> -->

        <h2 class="section-title inner-section-title">Description</h2>

        <p class="topo_description">
            <c:out value="${topo.topo_description}"/>
        </p>

        <p>
            <c:out value="${topo.topo_content}"/>
        </p>

        <c:if test="${sites.size() > 0 || (sessionScope.user_data != null && sessionScope.user_data.id == topo.author_id)}">
            <c:choose>
                <c:when test="${sites.size() > 0}">
                    <h2 class="section-title inner-section-title">Sites</h2>
                    <a class="button button-right button_align_title" href="<c:url value="/newsite/${topo.id}" />">Nouveau Site</a>
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
                                        <a href="<c:url value="/topo/${topo.id}/${site.id}/${sector.id}" />" class="sector-learn-more"><span>></span></a>
                                    </div>
                                </c:forEach>
                                <c:if test="${sessionScope.user_data != null && sessionScope.user_data.id == topo.author_id}">
                                    <a class="button" href="<c:url value="/newsector/${topo.id}/${site.id}" />">Nouveau Secteur</a>
                                </c:if>
                            </div>
                        </article>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <h2 class="section-title inner-section-title">Sites</h2>
                    <a class="button button-right button_align_title" href="<c:url value="/newsite/${topo.id}" />">Nouveau Site</a>
                </c:otherwise>
            </c:choose>
        </c:if>

        <h2 id="com" class="section-title inner-section-title">Commentaires</h2>

        <div class="comment_section">
            <c:choose>
                <c:when test="${sessionScope.user_data == null}">
                    <p>Pour laisser un commentaire vous devez être <a class="inline_link" href="<c:url value="/signin" />">connecté</a>. Si vous n'êtes pas inscrit, vous pouvez le faire <a class="inline_link" href="<c:url value="/signup" />">ici</a></p>
                </c:when>
                <c:otherwise>
                    <form class="comment_section_input" action="<c:url value="/addComment/${topo.id}" />" method="post">
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
</body>

</html>
