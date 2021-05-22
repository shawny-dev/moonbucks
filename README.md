# MoonBucks

> Coffee shop service in Spring & Kotlin.

## 개발 환경

### 필요 사항

- JDK 11
- docker, docker-compose

### 환경 설정(dockerize)

MySQL, Redis, RabbitMQ

### 테스트

```bash
# 테스트만 실행
./gradlew :testReport

# 테스트 실행 후 결과 레포트 생성
./gradlew :testReport
firefox ./build/reports/allTest/result/index.html

# 테스트 실행 후 코드 커버리지 레포트 생성
./gradlew :jacocoReport
firefox ./build/reports/allTest/jacoco/index.html
```

### 로컬에서 서비스 실행

```bash
./gradlew bootRun
```

## 배포

### 빌드

```bash
./gradew build
```

### 실행

운영 환경에서 필요한 jar 파일을 다운로드 합니다. 로컬에서 실행할 때에는 필요하지 않습니다.

```bash
./gradlew :prepareNewRelic
```

아래 환경변수를 설정합니다.

- `SPRING_PROFILES_ACTIVE` (기본값 : `development`)

다음 명령어로 서버를 실행합니다.

```bash
java -jar build/libs/api.jar
```
