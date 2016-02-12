<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<html>
<body>

  <section class="container">
    <div class="row">
      <c:forEach items="${users}" var="user">
        <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
          <div class="thumbnail">
            <div class="caption">
              <h3>${user.id}</h3>
              <h3>${user.login}</h3>
              <p>${user.password}</p>
              <p>${user.roles}</p>
            </div>
          </div>
        </div>
      </c:forEach>
    </div>
  </section>


</body>
</html>
