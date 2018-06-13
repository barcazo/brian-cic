# EOH - CIC Spring Boot RESTful Web Service


This is a Spring Boot Maven app showing how to build a simple RESTful Web Service connected with H2 database and basic validation.

| HTTP method | CRUD | URI |Description |
| --- | --- | --- | --- |
| POST | Create | `/cic/entity` | Create a new entity |
| POST | Create | `/cic/{entityId}/cic` | Create a cic to the entity |
| GET | Read | `/cic/entity` | Return a list of entities with cics |
| GET | Read | `/cic/{entityId}` | Return a specific entity with cics |
| PUT | Update/Replace | `/cic/{entityId}` | Update entity |
| PUT | Update/Replace | `cic/{entityId}/cic/{cicId}` | Update cic of the entity |
| DELETE | Delete | `cic/{entityId}` | Remove entity |
| DELETE | Delete | `cic/{entityId}/cic/{cicId}` | Remove entity cic |

## Pre-requisites

- Java SE Development Kit 8
- Maven 3.0+
- H2 In-Memory Database _(can work with any other relational database)_

## Getting Started

Import the Maven project straight to your Java IDE:
- Intellij IDEA

_(OPTIONAL) To work with other RDBMS you need to configure the project 'application.properties' file match to your database URL, username, password and add a required Maven dependency._

# License
Copyright 2018 BrianC

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.# barca
