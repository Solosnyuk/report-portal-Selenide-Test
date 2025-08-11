Feature: Управление фильтрами на странице Launches

  Scenario: Добавление нового фильтра
      Given пользователь авторизован
      When он открывает страницу Launches
      And добавляет новый фильтр с именем "TestFilter2" и текстом "TestText"
      Then фильтр с именем "TestFilter2" должен быть отображён

    Scenario: Удаление существующего фильтра
      Given пользователь авторизован
      And открыта страница Launches
      And добавляет новый фильтр с именем "TestDeletFilter" и текстом "TestDeletFilter"
      When пользователь удаляет этот фильтр
      Then фильтр "TestDeleteFilter" не отображается
