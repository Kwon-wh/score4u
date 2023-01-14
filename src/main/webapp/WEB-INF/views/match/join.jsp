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

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>

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
                        <form action="/match/join" method="post">
                            <div class="input-group mb-3">
                                <span class="input-group-text">팀이름</span>
                                <input type="text" name="team" class="form-control" placeholder="팀이름을 입력하세요." >
                            </div>
                            <div class="input-group mb-3">
                                <span class="input-group-text">현재 팀 도시</span>
                                <input type="text" name="city" class="form-control" placeholder="도시를 입력하세요." >
                                <span class="input-group-text">동/면/읍</span>
                                <input type="text" name="streetAddr" class="form-control" placeholder="상세주소를 입력하세요." >
                            </div>
                            <div class="input-group mb-3">
                                <span class="input-group-text">원하는 매칭 도시</span>
                                <input type="text" name="matchLocation" class="form-control" placeholder="주소를 입력하세요." >
                            </div>
                            <div class="input-group mb-3">
                                <span class="input-group-text">매치 일자</span>
                                <input type="date" name="matchDate" class="form-control" value=<c:out value="${dto.matchDate}"/> >
                                <span class="input-group-text">매치 시간</span>
                                <input type="time" id="matchStartTime" name="matchTime" class="form-control"/>
                                <input type="time" id="matchEndTime" name="matchTime" class="form-control"/>
                            </div>
                            <div class="my-4">
                                <div class="float-end">
                                    <button type="submit" class="btn btn-primary">신청하기</button>
                                    <button type="reset" class="btn btn-secondary">초기화</button>
                                </div>
                            </div>
                        </form>
                        <script>
                            function func() {
                                $('.matchTime').timepicker({
                                    timeFormat: 'HH:mm',
                                    interval: 30,
                                    minTime: '05:00',
                                    maxTime: '24:00',
                                    defaultTime: '12:00',
                                    dynamic: false,
                                    dropdown: true,
                                    scrollbar: true
                                });
                            }

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
    </div>
</div>
</body>
</html>