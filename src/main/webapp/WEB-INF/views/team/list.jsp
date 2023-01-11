<%--
  Created by IntelliJ IDEA.
  User: kwon-woohee
  Date: 2023/01/06
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Join Matching</title>
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <a class="navbar-brand" href="/match/list">SCORE4U</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="/match/join">매치등록</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/team/join">팀등록</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="row content">
            <div class="col">
                <div class="card">
                    <div class="card-body">
                            <div class="input-group mb-3">
                                <span class="input-group-text">팀이름</span>
                                <input type="text" name="team" class="form-control" value='<c:out value="${dto.teamName}"/>' readOnly/>
                            </div>
                            <div class="input-group mb-3">
                                <span class="input-group-text">현재 팀 도시</span>
                                <input type="text" name="city" class="form-control" value='<c:out value="${dto.city}"/>' readOnly/>
                            </div>
                            <div class="input-group mb-3">
                                <span class="input-group-text">동/면/읍</span>
                                <input type="text" name="streetAddr" class="form-control" value='<c:out value="${dto.streetAddr}"/>' readOnly/>
                            </div>
                            <div class="input-group mb-3">
                                <span class="input-group-text">매치 횟수</span>
                                <input type="text" name="streetAddr" class="form-control" value='<c:out value="${dto.matchingNum}"/>' readOnly/>
                            </div>
                        <script>
                            const serverValidResult={}
                            <c:forEach items="${errors}" var="error">
                            serverValidResult['${error.getField()}'] = '${error.defaultMessage}'
                            </c:forEach>
                            console.log(serverValidResult)
                        </script>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>