package com.example.react_SpringBoot_practice.entity;

import lombok.Data;

/*
エンティティクラス
エンティティクラスは、
データベーステーブルの構造を表すために使用されるクラスです。
通常、ORM（オブジェクトリレーショナルマッピング）フレームワークと一緒に使用され、
データベースのレコードと直接対応します。エンティティクラスは、
データベーステーブルの各列をフィールドとして持ち、
主キーや外部キーなどのデータベースの制約も含まれることが多いです。
*/

@Data
public class UserEntity {
      int id;
      String name;
}
