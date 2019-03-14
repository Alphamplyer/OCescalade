<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
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
        <div class="section-searchbar">
            <form action="topos" class="searchbar">
                <textfield name="searchQuery" class="searchbar-txt"  placeholder="Search.." />
                <submit class="searchbar-bnt" value="Rechercher" />
            </form>
        </div>

        <div class="articles topo-articles">
            <iterator value="topos">
                <article class="article">
                    <div class="article-image"></div>
                    <div class="article-content">
                        <h3 class="article-content-title"><a href=""><property value="topo_title" /></a></h3>
                        <p class="article-content-description"><property value="topo_description" /></p>
                        <div class="article-content-like">
                            <span><property value="topo_like" /></span><i class="far fa-eye"></i>
                            <span><property value="topo_vues" /></span><i class="far fa-heart"></i>
                        </div>
                    </div>
                    <a href="" class="article-learn-more"><span>></span></a>
                </article>
            </iterator>
        </div>

        <if test="maxpage>0">

            <set var="prevpage" value="actualpage"/>
            <set var="prevpage" value="%{#prevpage-1}"/>

            <set var="nextpage" value="actualpage"/>
            <set var="nextpage" value="%{#nextpage+1}"/>


            <div class="section-page">
                <if test="actualpage==1">
                    <a href="" class="section-page-item prev inactive"><span>&lt;&lt;</span></a>
                    <a href="" class="section-page-item prev inactive"><span>&lt;</span></a>
                </if>
                <else>
                    <a action="topos" class="section-page-item start">
                        <span>&lt;&lt;</span>
                        <param name="actualpage" value="1" />
                    </a>
                    <a action="topos" class="section-page-item prev">
                        <span>&lt;</span>
                        <param name="actualpage" value="prevpage" />
                    </a>
                </else>
                <a href="" class="section-page-item number"><span><property value="actualpage" /></span></a>
                <if test="actualpage>=maxpage">
                    <a href="" class="section-page-item next inactive"><span>&gt;</span></a>
                    <a href="" class="section-page-item end inactive"><span>&gt;&gt;</span></a>
                </if>
                <else>
                    <a action="topos" class="section-page-item next">
                        <span>&gt;</span>
                        <param name="actualpage" value="nextpage" />
                    </a>
                    <a action="topos" class="section-page-item end">
                        <span>&gt;&gt;</span>
                        <param name="actualpage" value="maxpage" />
                    </a>
                </else>
            </div>
        </if>
        <else>
            <p>Aucun résultat !</p>
        </else>
    </div>
</section>

<%@ include file="footer.jsp" %>

</body>

</html>
