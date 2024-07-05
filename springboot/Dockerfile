# ビルドステージ
FROM maven:3.9-eclipse-temurin-21 AS build

# 必要なパッケージをインストール
RUN apt-get update

WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# 実行ステージ
FROM maven:3.9-eclipse-temurin-21

WORKDIR /app
COPY --from=build /app/target/*.jar /app/myapp.jar

ENTRYPOINT ["java", "-jar", "/app/myapp.jar"]


#FROM openjdk:17-jdk-slim
#
## Mavenをインストール
#RUN apt-get update && \
#    apt-get install -y maven && \
#    rm -rf /var/lib/apt/lists/*
#
## 作業ディレクトリを設定
#WORKDIR /app
#
## プロジェクトの依存関係を解決するためのステージ
#COPY pom.xml /app
#COPY src /app/src
#
## init.sqlファイルをコピー
#COPY src/main/resources/init.sql /app/resources/init.sql
#
## Mavenビルド（テストをスキップ）
#RUN mvn  package -DskipTests -X
#//test
## 実行コマンド
#CMD ["java", "-jar", "target/react_SpringBoot_practice.jar"]
