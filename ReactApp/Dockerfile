# ベースイメージとして公式のNode.jsイメージを使用
FROM node:16-alpine as build
# 作業ディレクトリの設定
WORKDIR /react_app
# パッケージファイルをコンテナにコピー
COPY package.json ./
COPY package-lock.json ./
# 依存関係のインストール
RUN npm install
# ソースコードをコンテナにコピー
COPY . .
# Reactアプリのビルド
RUN npm run build

# ベースイメージをNginxに変更
FROM nginx:alpine
# ビルドしたファイルをNginxの公開ディレクトリにコピー
COPY --from=build /react_app/build /usr/share/nginx/html
# Nginxのデフォルト設定を削除（存在する場合のみ）
RUN rm -f /etc/nginx/conf.d/default.conf
# カスタムNginx設定を追加
COPY nginx.conf /etc/nginx/conf.d/

EXPOSE 80
# コンテナを起動
CMD ["nginx", "-g", "daemon off;"]
