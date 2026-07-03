# 簡易書籍租借系統
1. 註冊功能 (Done)
    使用者可以透過註冊功能註冊帳號,以手機號碼進行註冊與登入。
2. 登入驗證功能 (Done)
    使用者必須登入帳號才能借閱書籍。
    系統需實作身份驗證功能,以確保只有登入的使用者可以借閱書籍或還書。
3. 借還書功能 (Done)
    每個使用者可以借閱多本書籍,但每本書籍只能被借閱一次。
    當使用者借閱書籍時,系統會將書籍狀態改為「已借閱」,並在借閱紀錄表中新增一筆借閱紀錄。
    當使用者還書時,系統會將書籍狀態改為「可借閱」,並更新借閱紀錄表中的還書時間。
    為了達到交易完整性的考量,請使用資料庫交易 (Transaction) 來確保在寫入資料庫時的完整性。


## Outline
1. [Introduction](#Introduction)
1. [Start](#Start)
1. [PostgreSQL](#PostgreSQL)
1. [Tech](#Tech)
1. [Dependencies](#Dependencies)


## Introduction
使用 SpringBoot 後端實作MVC，前端使用 Vue.js、TailwindCSS，資料庫使用 PostgreSQL，實作的簡易書籍租借網站以及簡易用戶認證系統。


## Start
``` bash
mvn spring-boot:run
```


## PostgreSQL
拉取 [PostgreSQL Image](https://hub.docker.com/_/postgres) 然後 Run 一個 container
``` bash
# Pull image
docker pull postgres:19beta1-trixie

# Run image
docker run -itd -p 5432:5432 --name some-postgres -e POSTGRES_PASSWORD=mysecretpassword postgres:19beta1-trixie
```


## Tech
1. 使用 Vue.js 做為前端技術。
1. 使用 Spring Boot 搭建相關應用程式。
1. 使用 RESTful API 風格建立後端服務。
1. 使用 Maven 或 Gradle 做為專案建立的工具。
    `本專案使用 Maven`
1. 透過 Stored Procedure 存取資料庫。
    `方法: 撰寫 Stored Procedure file 放置於 src\main\resources\db\sp`
1. 需同時異動多個資料表時,請實作 Transaction,避免資料錯亂。
    `方法: 於租借及歸還時會同時異動 inventory 跟 borrowing record 需要使用 Transaction`
1. 資料庫的 DDL 和 DML 請存放在專案下的\DB 資料夾內提供
    `方法: 撰寫 Migration file 放置於 src\main\resources\db\migration`
1. 需防止 SQL Injection 以及 XSS 攻擊。
    `防止 SQL Injection: 使用 JPA 並且在存入進 DB 前驗證。`
    `防止 XSS : 避免網頁直接執行腳本、盡量以 vue 渲染畫面。`


## Dependencies
```
openjdk version "21.0.4" 2024-07-16 LTS
Apache Maven 3.9.16 (2bdd9fddda4b155ebf8000e807eb73fd829a51d5)
```