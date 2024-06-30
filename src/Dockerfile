# Mavenの公式イメージを使用
FROM maven:3.8.5-openjdk-17
# 作業ディレクトリの設定
WORKDIR /app
# ソースコードをコンテナにコピー
COPY . /app

# Mavenを使ってビルドする場合
# Mavenのビルドコマンドの修正例
RUN mvn -f ../pom.xml clean package


# コンテナ内でのポート設定
EXPOSE 8080
# アプリケーションの起動
ENTRYPOINT ["java", "-jar", "app.jar"]
