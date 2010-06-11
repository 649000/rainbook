<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>List of Friends</title>
    </head>
    <body>

      <h1>Your Friends</h1>

      <g:if test="${friends != null}">

        <table border="1">

          <tr>
            <td>Name</td>
            <td>Email</td>
            <td>Photo</td>
          </tr>

          <g:each var="f" in="${friends}">
            <tr>
              <td>${f.name}</td>
              <td>${f.email}</td>
              <td>${f.photo}</td>
            </tr>
          </g:each>

        </table>

      </g:if>
      <g:else>
        <p>You have no friends!</p>
      </g:else>
    </body>
</html>
