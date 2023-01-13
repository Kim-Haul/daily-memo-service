## Initial Settings (Spring Boot)

```java
// default
$ Artifact: 프로젝트명
$ Type: Gradle
$ Language: Java
$ Packaging: Jar
$ Java Version: 8
$ SDK: 1.8 Oracle OpenJDK version 1.8.0_202

// build.gradle - dependencies
$ Spring Web
$ MySQL Driver
$ H2 Database
$ Spring Data JPA
$ Lombok
```

```java
// JPA
// List<Memo> findAllByOrderByModifiedAtDesc(); 에서 수정 일자가 24시 전인 것들만 다시 필터링.
List<Memo> findAllByModifiedAtBetweenOrderByModifiedAtDesc(LocalDateTime start, LocalDateTime end);
```
