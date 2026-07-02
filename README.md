# 簡易書籍租借系統
1. 註冊功能
    使用者可以透過註冊功能註冊帳號,以手機號碼進行註冊與登入。
2. 登入驗證功能
    使用者必須登入帳號才能借閱書籍。
    系統需實作身份驗證功能,以確保只有登入的使用者可以借閱書籍或還書。
3. 借還書功能
    每個使用者可以借閱多本書籍,但每本書籍只能被借閱一次。
    當使用者借閱書籍時,系統會將書籍狀態改為「已借閱」,並在借閱紀錄表中新增一筆借閱紀錄。
    當使用者還書時,系統會將書籍狀態改為「可借閱」,並更新借閱紀錄表中的還書時間。
    為了達到交易完整性的考量,請使用資料庫交易 (Transaction) 來確保在寫入資料庫時的完整性。


## Outline
1. [Start](#start)
1. [Tech](#Tech)
1. [Dependencies](#Dependencies)


## Start
``` bash
mvn spring-boot:run
```


## Tech
1. 使用 Vue.js 做為前端技術。
1. 使用 Spring Boot 搭建相關應用程式。
1. 使用 RESTful API 風格建立後端服務。
1. 使用 Maven 或 Gradle 做為專案建立的工具。
1. 透過 Stored Procedure 存取資料庫。
1. 需同時異動多個資料表時,請實作 Transaction,避免資料錯亂。
1. 資料庫的 DDL 和 DML 請存放在專案下的\DB 資料夾內提供
1. 需防止 SQL Injection 以及 XSS 攻擊。


## Dependencies
```
openjdk version "21.0.4" 2024-07-16 LTS
Apache Maven 3.9.16 (2bdd9fddda4b155ebf8000e807eb73fd829a51d5)
```