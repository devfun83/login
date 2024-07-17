<h1>Spring Security 커스텀 로그인 기능 구현</h1>

<h2>개발환경</h2>
<table class="table" style="width:400px">
    <thead>
        <tr>
            <th>개발 환경</th>
            <th>버전</th>
        </tr>
    </thead>
    <tbody class="table-border-bottom-0">
        <tr>
            <td>Java</td>
            <td>17</td>
        </tr>
        <tr>
            <td>Spring Boot</td>
            <td>3.2.7</td>
        </tr>
        <tr>
            <td>Spring Security</td>
            <td>6.2.5</td>
        </tr>
        <tr>
            <td>Spring Data JPA</td>
            <td>3.2.7</td>
        </tr>
        <tr>
            <td>Lombok</td>
            <td>1.18.30</td>
        </tr>
        <tr>
            <td>빌드 관리 도구</td>
            <td>Gradle 8.8</td>
        </tr>
        <tr>
            <td>템플릿 엔진</td>
            <td>Mustache</td>
        </tr>
        <tr>
            <td>DB</td>
            <td>MySQL 8.0.36</td>
        </tr>
        <tr>
            <td>개발 도구</td>
            <td>Spring Tool Suite 4.22.1</td>
        </tr>
    </tbody>
</table>
<h2>테이블 생성</h2>
<< MySQL 테이블 >>
<pre><code>CREATE TABLE `members` (
  `ID` int NOT NULL AUTO_INCREMENT COMMENT '고유번호',
  `LOGIN_ID` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '아이디',
  `LOGIN_PWD` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '비밀번호',
  `ROLE` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '권한',
  `NICKNAME` varchar(15) DEFAULT NULL COMMENT '닉네임',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
</code></pre>
<h2>사이트 링크</h2>
<a href="https://devdream.net/board/12" target="_blank">FailureHandler 구현</a><br>
<a href="https://devdream.net/board/11" target="_blank">SuccessHandler 구현</a><br>
<a href="https://devdream.net/board/6" target="_blank">커스텀 로그인 구현</a><br>
<a href="https://devdream.net/board/5" target="_blank">회원가입 구현</a><br>
<a href="https://devdream.net/board/4" target="_blank">프로젝트 생성</a><br>
<br>
<h2>출처</h2>
<a href="https://devdream.net" target="_blank">https://devdream.net</a>
