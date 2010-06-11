
<%@ page import="app.Friendship" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'friendship.label', default: 'Friendship')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                            <g:sortableColumn property="id" title="${message(code: 'friendship.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="parties" title="${message(code: 'friendship.parties.label', default: 'Parties')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${friendshipInstanceList}" status="i" var="friendshipInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${friendshipInstance.id}">${fieldValue(bean: friendshipInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: friendshipInstance, field: "parties")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${friendshipInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
