# Lifrary 
> 전국민 독서량 증진과 도서관 방문율을 향상시키는 전국 도서관 통합 관리 시스템

## 개발환경
- Language : java, javascript(jquery), HTML, CSS
- DB : mariaDB
- DB관리툴 : HeidiSQL 10.1.0,
- 협업툴 : GitHub
- 프레임워크 : STS 4.2.1, springframework 4.2.1,
spring-webmvc 4.3.9,Maven, mybatis 4.0.0,
mybatis-spring-boot 2.1.1, bootstrap
API : jackson.core 2.9.8, spring-jdbc 5.1.7,
mariadb-java-client-2.4.1, thymeleaf-2.3.0,
maven-compiler-plugin 2.1.5

----------------------------------------------------------------------------------------------------------------------------------------
## 1. 프로젝트 동기

한 구인구직 전문 사이트의 설문에 따르면, 전체 응답자 중 약 90%는 독서가 사회생활에 도움이 된다고 느낌에도 불구하고 충분한 독서를 하지않는다고한다. 또한, 지난해 문화체육관광부가 발표한 통계에 따르면 우리나라 성인 중 40%의 연간 독서량은 0권이다. 
이러한 문제점을 해결하기 위하여, 이용자들에게 접근성이 좋은 도서관사이트의 구현을 목표로 한다. 

도서관 사이트의 이용률을 높이기 위해 '나만의 북 다이어리(북 캘린더, 독후감)'로 자신만의 독서 히스토리를 총정리하는 '나만의 공간'을 제공할 것이다. 또, 독서 목표량 설정을 가능하게 하여, 설정한 목표량 달성 시 상을 제공함으로써 독서 성취감을 향상시켜 이용자의 독서율을 높이는것을 목표으로 한다.

관리자 측면에서는 많은 도서관수에 비해 사서의 수는 턱없이 부족하다는 문제점이있다. 예를 들어 서울 지역 공공 도서관 사서 중 비정규직은 3분의 1에 달하는 것으로 나타났다.
해당 프로젝트에서 구현한 관리자 사이트는 도서정보 반입과 도서관에 따른 청구기호 생성 등 간편한 도서 등록 시스템으로 빠른 작업이 가능 하며, 전국 도서관 통계 자료 및 편한 프로그램/공공시설 관리 제공을 목표로한다.

----------------------------------------------------------------------------------------------------------------------------------------
## 2. 프로젝트 목적
1. 개인 독서 공간 제공과 목표량 및 포인트 제도를 도입하여 지속적인 독서량 증진과 도서관 방문을 늘리게 한다.
2. 도서관리 단순화와 일괄된 도서관페이지 관리 시스템으로 효율적이고 통일된 관리를 제공한다.
3. 전국 도서관간의 데이터를 공유하여 다양한 통계와 자료를 제공한다.

----------------------------------------------------------------------------------------------------------------------------------------
## 3. 프로젝트 기대효과
1. 나만의 독서공간을 마련하여 독서 상황을 기록할 수 있으며, 포인트 제도를 도입하여 도서관사이트를 지속적으로 이용하게 할 수 있다
2. 도서정보 반입과 도서관에 따른 청구기호 생성 등 간편한 도서 등록 시스템으로 빠른 작업이 가능하며, 적은 인원으로도 도서관리를 할 수 있다.
3. 다양한 문화행사, 강좌 제공 및 편리한 공공시설 예약시스템으로 이용자들이 증가하는것을 기대할 수 있다.

----------------------------------------------------------------------------------------------------------------------------------------
## 4. 프로젝트 기능
1. 로그인/로그아웃 관리
- 도서관 페이지 - 회원 로그인 기능
- 도서관 관리자 페이지 - 사서/관리자 로그인 기능
2. 회원관리(회원관리, 등급, 권한)
- 도서관 페이지 - 회원 정보 수정/탈퇴
- 도서관 관리자 페이지 - 회원정보 (수정, 삭제), 등급/권한(등록,수정,삭제), 등급/권한이력리스트
3. 사서관리(사서관리, 사서이용자관리)
- 도서관 관리자 페이지 - 사서-사서정보 (수정,삭제) , 관리자 - 사서권한 (등록,수정,삭제)
4. 포인트관리
-도서관 페이지-포인트 이력, 포인트 사용
-도서관 관리자 페이지- 포인트 설정(등록, 수정, 삭제), 포인트 이력
5. 도서관리(수서, 소장도서)
- 도서관 페이지 - 도서조회
- 도서관 관리자 페이지 - 도서반입, 도서관리(추가,수정,삭제), 장서점검
6. 대출/예약/반납 관리
- 도서관 페이지 - 도서예약
- 도서관 관리자 페이지 -대출,예약,반납 기록관리, 포인트부여
7. 공공시설 관리
- 도서관 페이지 - 시설예약,연장
- 도서관 관리자 페이지 -시설관리(추가,수정,삭제), 이용자 이용관리
8. 독서기록 관리
- 도서관 페이지 - 독후감, 독서기록, 서재
9. 관내 행사 관리
- 도서관 페이지 - 행사 참여신청,행사 참여 확인/취소처리
- 도서관 관리자 페이지 - 행사 등록/수정, 행사 참여자 리스트 확인
10. 공공시설 예약 관리
- 도서관 페이지 - 공공시설 예약, 취소, 예약 확인
- 도서관 관리자 페이지 - 공공시설 등록, 수정, 삭제,사용중인 회원 리스트 확인
11. 게시판
- 도서관 페이지 - 문의하기 등록
- 도서관 관리자 페이지 - 문의답변, 공지사항, 추천도서 등록

----------------------------------------------------------------------------------------------------------------------------------------
## 5. ERD
<img src="https://user-images.githubusercontent.com/58412523/72580609-07c04800-3920-11ea-8e72-00edc87ba2bc.png" width="90%"></img>
