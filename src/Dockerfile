# ベースイメージとして公式のOpenJDKイメージを使用
FROM openjdk:17
# 作業ディレクトリの設定
WORKDIR /app
# JARファイルをコンテナにコピー
COPY ../target/react_SpringBoot_practice-0.0.1-SNAPSHOT.jar app.jar
# コンテナ内でのポート設定
EXPOSE 8080
# アプリケーションの起動
ENTRYPOINT ["java", "-jar", "app.jar"]
