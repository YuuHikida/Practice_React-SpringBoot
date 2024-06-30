# Mavenの公式イメージを使用
FROM maven:3.8.5-openjdk-17
# 作業ディレクトリの設定
WORKDIR /app

# ソースコードをコンテナにコピー
COPY . /app

# Mavenを使ってビルドする場合
RUN mvn clean package

# JARファイルをコンテナにコピー
#COPY ../target/react_SpringBoot_practice-0.0.1-SNAPSHOT.jar app.jar

# コンテナ内でのポート設定
EXPOSE 8080
# アプリケーションの起動
ENTRYPOINT ["java", "-jar", "app.jar"]
