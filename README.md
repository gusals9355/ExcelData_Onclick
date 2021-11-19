# Oneclick

공공데이터 업무를 클릭 한번으로 자동화 해놓은 프로그램입니다.

## 역할

1. 샘플데이터 추출&삽입
2. 기존 항목명 정제

## 사용법

(처음 사용 시)Jar파일이 실행안되는 경우 java 설치
https://www.java.com/ko/download/

파일명 : 항목명표준화 등록요청 양식
1. 파일명변경 x
2. 양식 파일경로 : C:\Users\user\Downloads

※ 수동으로 해야하는 경우
1. 기존 항목명에 ,(콤마)가 있는경우 (4주공아파트, 405동 ~~ 이런 경우)
2. 기존 항목명이 해당 파일데이터 컬럼명과 매핑이 안되있는 경우 (파일데이터 오류인 경우임)

## 동작원리
1. F컬럼에 해당하는 URL주소의 csv파일을 E컬럼 파일데이터명으로 모두 다운받음
2. 다운 받은 csv파일에서 G컬럼의 항목명을 찾아 공백이 아니고 Null이 아닐때 까지 5개의 데이터를 저장
3. 1개의 데이터라도 없을 시 N/A를 저장
4. 표준화 양식의 샘플데이터에 삽입
5. G컬럼의 항목명의 특수문자를 모두 제외(정제) 후 H, I컬럼에 삽입

<hr>

2021-11-17 / URL주소를 통한 csv파일 인코딩이 대부분 ANSI지만, UTF-8(BOM)파일 형식에 따른 인코딩 설정 방법 수정.
