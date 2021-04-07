
<h1 align="center">Assignment</h1>

## 🚀 Installation
To run the automation project, you should run ```mvn verify``` from the command line or

```shell
mvn clean install
```

## 🔥 Executing the tests
To execute the entire set of tests write on the command promp

```shell
mvn test
```

The test results will be recorded in the `target/site/serenity` directory.

## 📁 File structure

Assignment

```
.idea/
src/
├─ main/
│  ├─ java/
│  │  ├─ controller/
│  │  ├─ EnvironmentController.java
│  │
│  │  ├─ model/
│  │  ├─ User.java
│  │  ├─ Geo.java
│  │  ├─ Company.java
│  │  ├─ Address.java
│  │  ├─ Comments.java
│  │
│  │  ├─ resources/
│  │  │  ├─ requestPayloads/
│  │  │  ├─ validUserData.json
│  │  │  ├─ inValidUserData.json
│  │  │  ├─ updatedWrongUserData.json
│  │  │  ├─ U[datedValidUserData.json
│  │
│  │  ├─ restAPI/
│  │  │  ├─ Endpoints.enum
│  │  │  ├─ MobiquityClient.java
├─ test/
│  ├─ java/
│  │  ├─ stepdefinitions/
│  │  │  ├─ MobStepDef.java
│  │  ├─ steps/
│  │  │  ├─ MobSteps.java
│  │  ├─ CucumberTestSuite.java
│  │
│  ├─ resources/
│  │  ├─ features/
│  │  │  ├─ Mobiquity.feature
.gitattributes
.gitignore
pom.xml
README.md
Mobiquity.iml

```
## 🚚 Roadmap

[Assignment thoughts](https://www.notion.so/Assignment-thoughts-f136790b32d4435a9ffad08a5f883a2d)

[comment]: <> (Todo)
[comment]: <> (##Code Example)
[comment]: <> (##Code style)
[comment]: <> (## Build status)
[comment]: <> (##Features)
[comment]: <> (##API Reference)
[comment]: <> (##Screenshots)