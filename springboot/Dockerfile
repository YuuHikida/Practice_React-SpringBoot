FROM openjdk:17-jdk-slim

# Mavenをインストール
RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*

# 作業ディレクトリを設定
WORKDIR /app

# プロジェクトの依存関係を解決するためのステージ
COPY pom.xml /app
COPY src /app/src

# init.sqlファイルをコピー
COPY src/main/resources/init.sql /app/resources/init.sql

# Mavenビルド（テストをスキップ）
RUN mvn  package -DskipTests -X
//test
# 実行コマンド
CMD ["java", "-jar", "target/react_SpringBoot_practice.jar"]
