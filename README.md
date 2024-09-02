# task-chat-api

### 빌드
```sh
./gradlew build
```
### 실행
```sh
./gradlew bootRun
```

## 테스트 데이터 초기화방법
프로젝트 실행시 src/main/resources/seeding/init.sql 파일을 참조하여 테스트 데이터 초기화 부탁드립니다<br/>

## 문서화
문서화는 Swagger 사용하여 구현 했습니다.<br/>
사용법은 https://swagger.io/ 참조 부탁드립니다.

## Swagger 접속 URL
> http://localhost:8092/swagger-ui/

## 기타추가정보
도커 기능을 확하고 싶으신 경우 아래 절차를 통해 확인하실 수 있습니다<br/>
도커에는 데이터베이스 및 카프카 컨테이너를 초기화시키는 코드가 들어있습니다<br/>

####  도커 컨테이너 실행 순서
> 1. 로컬 PC에서 토커 어플리케이션 실행
> 2. 터미널에서 src/main/resources/ 폴더로 이동
> 3. docker compose up -d 명령어 실행
> 4. docker ps -a 명령어로 컨테이너가 실행중인지 확인

## 시퀀스 다이어그램
![Diagram](assets/diagram.svg)