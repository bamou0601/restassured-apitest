# RestAssured API Automation Test Project

このプロジェクトは、RestAssured + JUnit5 を使用した  
API自動化テストフレームワークです。

JWT認証・データ駆動テスト・共通基盤設計を含み、  
業務APIの品質保証を目的としています。

---

## 📌 技術スタック

- Java 17+
- RestAssured
- JUnit5
- Lombok
- Maven
- (Optional) Allure Report

---

## 📁 プロジェクト構成

```
src
├── base
│   ├── ApiBaseTest.java        # 共通基盤クラス（BASE_URL管理）
│   ├── ApiTestData.java        # 汎用テストデータDTO
├── model
│   ├── LoginTestData.java      # ログイン専用テストデータ
├── utils
│   ├── ConfigReader.java       # 設定読み込みユーティリティ


---

## 🚀 セットアップ方法

### 1. リポジトリクローン

```bash
git clone https://github.com/bamou0601/restassured-apitest.git
cd restassured-apitest
```

---

### 2. 依存関係インストール

```bash
mvn clean install
```

---

## ▶ テスト実行方法

```bash
mvn test
```

---

## 🔐 テスト概要

### 1. ログインAPIテスト

- 正常ログイン時にToken取得
- Tokenがレスポンスに含まれることを確認

### 2. Token再利用テスト

- 取得したTokenをBearer認証に設定
- `/auth/me` APIを呼び出し
- ユーザー情報の取得を検証

---

## 📊 データ駆動テスト

このプロジェクトでは Data-Driven Testing を採用しています。

### 例

```java
private String name;
private Request request;
private Expected expected;
```

- request：API入力データ
- expected：期待結果

---

## 🧱 設計方針

- テストデータとロジックの分離
- Baseクラスによる共通設定管理
- DTOによる型安全なデータ管理
- Map / POJO併用による柔軟性確保

---

## ⚙️ 今後の拡張予定

- Allureレポート連携
- GitHub Actions CI実行
- テストデータの外部JSON化

---

## 👤 作成者

馬 猛  
作成日: 2026/06/19
