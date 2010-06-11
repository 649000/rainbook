<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>List of Friends</title>
    </head>
    <body>

      <h1>${currentUser?.name}'s Friends</h1>

      <h2>${flash.message}</h2>

      <g:if test="${friends != null}">

        <table border="1">

          <tr>
            <td>Name</td>
            <td>Email Address</td>
            <td>Photo</td>
            <td>Remove Friend</td>
          </tr>

          <g:each var="f" in="${friends}">
            <tr>
              <td>${f?.name}</td>
              <td>${f?.email}</td>
              <td>${f?.photo}</td>
              <td><g:link action="delete" id="${f?.id}">X</g:link></td>
            </tr>
          </g:each>

        </table>

      </g:if>
      <g:else>
        <p>You have no friends!</p>
      </g:else>
    </body>
</html>
