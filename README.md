#### В проекте реализованы 4 UI автотеста и 6 API автотеста (4 позитивных и 2 негативных) для раздела Launches на сайте ReportPortal Demo.
***
### Технологии:
Maven, RestAssured, Selenide, TestNG, Jackson (ObjectMapper), AssertJ
***
### Описание методов классов:

#### Пакет tests.api.pojos:

###### Классы моделей для сериализации/десериализации JSON-данных при работе с API

* CreateLaunchRequest - Модель тела запроса на создание запуска

* CreateLaunchResponse -	Модель ответа от API при создании запуска

* DeleteLaunchResponse -	Ответ при удалении запуска

* GetLaunchResponse -	Ответ при получении информации о запуске

* PutLaunchRequest -	Тело запроса для обновления запуска

#### Пакет tests.api:

###### Классы, реализующие API-логику, конфигурации и тесты.

* BaseApiTest - Подготавливает базовую конфигурацию перед выполнением тестов

* CRUDtest - Тестовый класс

* DELETElaunch - deleteLaunch(String projectName, int launchId) Отправляет DELETE-запрос для удаления

* GETlaunch - getLaunch(String projectName, String launchId) Выполняет GET-запрос на получение информации

* POSTlaunch - createLaunch(String projectName) Выполняет POST-запрос для создания

* PUTlaunch - updateLaunch(String projectName, String launchId, PutLaunchRequest body) Отправляет PUT-запрос для изменения состояния или описания

* RpConfig - Используется для получения endpoint, project name и API token

#### Пакет tests.ui:

* BaseUiTest - Базовый класс для UI-тестов

* LaunchesTest - UI тесты
***
#### ! Укажите API-key в resources/rp.properties !
