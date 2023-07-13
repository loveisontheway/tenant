tenant [![](https://img.shields.io/badge/3.1.1-blue.svg)]()
==============================

This is Spring Boot Project.（多租户设计，JPA自动建库建表）

## Table of Contents
+ [Environment](https://github.com/loveisontheway/tenant#Environment)
+ [Project](https://github.com/loveisontheway/tenant#Project)
+ [Start](https://github.com/loveisontheway/tenant#Start)

## Environment
+ `Java:` 17+
+ `Spring Framework:` 6.0.10+
+ `Tomcat:` 10.0+
+ `Maven:` 3.6.3+
+ `Gradle:` 7.5+
+ `Spring Boot:` 3.1.1
+ `JPA:` 3.1.1
+ `MySQL:` 5.7+
+ `Lombok:` 1.18.28
+ `IntelliJ IDEA Ultimate:` 2021.1.2+

## Project
| name             | description                                                                       |
|:-----------------|:----------------------------------------------------------------------------------|
| tenant-database  | 分数据库（不同租户的数据存储不同的数据库中）                                                            |
| tenant-partition | 分区数据（不同租户的数据存储一张表里，通过列`tenant_id`区分不同租户数据）                                        |
| tenant-schema    | 分结构（不同租户数据存储同一数据库中不同的实例结构`schema`中，`schema`就是数据库对象的集合，这个集合包含了各种对象如：表、视图、存储过程、索引等） |

## Start
```
tenant
├── tenant-database       // 8012
├── tenant-partition      // 8010
├── tenant-schema         // 8011
```
三个项目都可独立运行`main`方法，`http://localhost:8010/person`