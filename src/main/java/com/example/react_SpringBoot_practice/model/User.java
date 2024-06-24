package com.example.react_SpringBoot_practice.model;

import jakarta.persistence.*;
import lombok.Data;
/*
MEMO:
モデルクラス
モデルクラスは、アプリケーションのビジネスロジックを表現するために使用されるクラス
データベースの構造に直接対応する必要はなく、
アプリケーションの内部ロジックやデータの構造を表すために使用されます。
モデルクラスは、Webアプリケーションのフロントエンドから
バックエンドにデータを渡すための
DTO（データ転送オブジェクト）としても使われます
 */
//↓DBとクラスを呼び出すEntity
//@Entity
////MEMO
///*「@Data」
//アノテーションはLomBokのアノテーションで
//Getter,Setter自動生成する*/

@Data
public class User {
    Integer id;
    String name;
    // エンティティにはない追加のフィールドもできやす
}
