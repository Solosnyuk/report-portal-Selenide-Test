#### В проекте реализованы 4 UI автотеста и 6 API автотеста (4 позитивных и 2 негативных) для раздела Launches на сайте ReportPortal Demo.
#### Позже был добавлен один BDD автотест на Cucumber
***
### Технологии:
Maven, RestAssured, Selenide, TestNG, Jackson (ObjectMapper), AssertJ, Cucumber
***
## Описание методов классов:
#### Пакет api.pojos:
Классы моделей для сериализации/десериализации JSON-данных при работе с API
* DeleteLaunch - Модель запроса на удаление запуска

* GetLaunch - Модель ответа при получении информации о запуске

* PostLaunch - Модель тела запроса на создание запуска

* PutLaunch - Модель тела запроса для обновления запуска

* RpConfig - Конфигурация: endpoint, project name и API token

#### Пакет api:
Классы, реализующие API логику, конфигурации и тесты
* BaseApiTest - Подготавливает базовую конфигурацию перед выполнением API тестов

* CRUDtest - Класс с тестами на создание, чтение, обновление и удаление

#### Пакет ui.page:
Классы, описывающие страницы и элементы UI
* LaunchesPage - Страница запусков

* LaunchesPageLocators - Локаторы элементов страницы запусков

* LoginPage - Страница авторизации

#### Пакет utils:
* GenerateName - Генератор уникальных имён для тестов

#### Пакет test.stepdefs:
Классы шагов для Cucumber сценариев
* Hooks - Выполняет действия до и после сценариев

* LaunchesSteps - Реализация шагов для сценариев запусков

#### Пакет test.tests.api:
* BaseApiTest - Базовая настройка для API тестов

* CrudTest - Тесты CRUD операций

#### Пакет test.tests.runner:
* CucumberTestRunner - Класс запуска Cucumber-сценариев с использованием TestNG

#### Пакет test.tests.ui:
* BaseUiTest - Базовый класс для UI тестов

* LaunchesTest - UI тесты для проверки запусков

#### Пакет resources.features.launches:
* launches.feature - Gherkin сценарии для тестирования запусков

#### Пакет resources:
* log4j2.xml - Конфигурация логирования

* testng.xml - Конфигурация запуска тестов через TestNG
***
#### ! Укажите API-key в resources/rp.properties !
