Feature: Управление фильтрами на странице Launches

  Scenario: Добавление нового фильтра
    Given пользователь авторизован
    When он открывает страницу Launches
    And добавляет новый фильтр с именем "TestFilter" и текстом "TestText"
    Then фильтр с именем "TestFilter" должен быть отображён
