<%--
  Created by IntelliJ IDEA.
  User: kwon-woohee
  Date: 2023/01/09
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
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

    <title>Match List</title>
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
                    <div class="card-header">
                        매치 검색
                    </div>
                    <form action="/match/list" method="get">
                        <input hidden="hidden" name="size" value="${pageRequestDTO.size}">
                        <div class="card-body">
                           <div class="mb-3">
                               <input type="checkbox" name="types" value="t" ${pageRequestDTO.checkType("t")?"checked":""} placeholder="팀이름">팀이름
                               <input type="checkbox" name="types" value="c" ${pageRequestDTO.checkType("c")?"checked":""} placeholder="도시">도시
                               <input type="text" name="keyword" value='<c:out value="${pageRequestDTO.keyword}"/>' class="form-control">
                           </div>
                            <div class="input-group mb-3 matchDateDiv">
                                <input type="date" name="from" class="form-control" value="${pageRequestDTO.from}">
                            </div>
                            <div class="input-group mb-3">
                                <div class="float-end">
                                    <button class="btn btn-primary" type="submit">검색</button>
                                    <button class="btn btn-primary clearBtn" type="reset">초기화</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="card">
                    <div class="card-header">
                        Match List
                    </div>
                    <div class="card-body">
                        <table class="table">
                            <thead>
                            <tr>
                                <th scope="col">팀</th>
                                <th scope="col">도시</th>
                                <th scope="col">상세도시</th>
                                <th scope="col">매칭지역</th>
                                <th scope="col">매칭일자</th>
                                <th scope="col">매칭완료여부</th>
                            </tr>
                            </thead>

                            <tbody>
                            <c:forEach items="${responseDTO.dtoList}" var="dto">
                                <tr style="cursor: pointer" onclick="location.href='/match/read?seq=${dto.seqNo}'">
                                    <td><c:out value="${dto.team}"/></td>
                                    <td><c:out value="${dto.city}"/></td>
                                    <td><c:out value="${dto.streetAddr}"/></td>
                                    <td><c:out value="${dto.matchLocation}"/></td>
                                    <td><c:out value="${dto.matchDate}"/></td>
                                    <td><c:out value="${dto.finished ? '매칭완료':'신청가능'}"/></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <div class="float-end">
                            <ul class="pagination flex-wrap">
                                <c:if test="${responseDTO.prev}">
                                    <li class="page-item">
                                        <a class="page-link data-num=${responseDTO.start -1}">Previous</a>
                                    </li>
                                </c:if>
                                <c:forEach begin="${responseDTO.start}" end="${responseDTO.end}" var="num">
                                    <li class="page-item ${responseDTO.page == num ? "active":""} "> <a class="page-link" data-num="${num}">${num}</a></li>
                                </c:forEach>

                                <c:if test="${responseDTO.next}">
                                    <li class="page-item">
                                        <a class="page-link" data-num="${responseDTO.end + 1}">Next</a>
                                    </li>
                                </c:if>
                            </ul>

                            <script>

                                document.querySelector(".pagination").addEventListener("click", function (e) {
                                    e.preventDefault()
                                    e.stopPropagation()

                                    const target = e.target
                                    if(target.tagName !== 'A' ) {
                                        return
                                    }
                                    const num = target.getAttribute("data-num")

                                    const  formObj = document.querySelector("form")
                                    formObj.innerHTML += `<input type='hidden' name='page' value='\${num}'>`
                                    // self.location = `/match/list?page=\${num}` //백킷을 이용해서 템플릿 처리
                                    formObj.submit();
                                }, false)

                                document.querySelector(".clearBtn").addEventListener("click", function (e) {
                                    e.preventDefault()
                                    e.stopPropagation()

                                    self.location = '/match/list'
                                }, false)
                            </script>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>