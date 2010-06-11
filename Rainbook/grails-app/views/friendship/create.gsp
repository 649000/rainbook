<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Find a Friend</title>
    </head>

    <body>
      <div style="font-weight:bold">${flash.message}</div>
        <table border="1">
          <tr>
            <g:sortableColumn property="name" title="Name" />
            <g:sortableColumn property="email" title="Email" />
            <td>Photo</td>
            <td>Add As Friend</td>
          </tr>
          <g:each in="${profiles}" var="p">
            <g:if test="${p?.id != id}">
              <tr>
                <td>${p?.name}</td>
                <td>${p?.email}</td>
                <td>${p?.photo}</td>
                <td>+</td>
              </tr>
            </g:if>
          </g:each>
        </table>
        <g:paginate total="${app.Profile.count() - 1}" />
        <div style="padding:5px;font-weight:bold">
      </div>
    </body>
    
</html>
