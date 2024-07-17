<h1>Spring Security OAuth2 구글, 네이버 로그인 구현하기</h1>

<h2>개발환경</h2>
<table class="table" style="width:450px">
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
            <td>Spring Security OAuth2 Client</td>
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
   `USERID` varchar(65) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '아이디',
   `USERNAME` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '이름',
   `EMAIL` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '이메일 주소',
   `ROLE` varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '권한',
   `PROVIDER` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '공급자',
   `PROVIDER_ID` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '공급자 고유 ID',
   PRIMARY KEY (`ID`)
 ) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
</code></pre>

<a href="https://devdream.net/board/16" target="_blank">구글, 네이버 OAuth2 로그인 구현</a><br>
<a href="https://devdream.net/board/15" target="_blank">프로젝트 생성</a><br>
<a href="https://devdream.net/board/14" target="_blank">네이버 로그인 신청</a><br>
<a href="https://devdream.net/board/13" target="_blank">구글 로그인 신청</a><br>
  
<h2>출처</h2>
<a href="https://devdream.net" target="_blank">https://devdream.net</a>



