# CocktailApp
Test task for KazanExpress
Link: https://github.com/KazanExpress/android-test-task
Description:
It is necessary to implement a simple application that helps the user find the cocktail of interest to him. This application should work with TheCocktailDb API
https://www.thecocktaildb.com/api.php.
At the initial level of complexity, the main task of the application will be to draw a screen with information about the cocktail. You can use this GET request to get a random cocktail while the app is loading.
https://www.thecocktaildb.com/api/json/v1/1/random.php
Требования:
*У приложения должны быть онбординги, на них можно отобразить любую информацию о приложении;
*При запуске приложения на старте показываем индикатор прогресса на время ожидания ответа с сервера (по желанию можно добавить splash screen до экрана загрузки на свой вкус);
*На странице коктейля должно быть отображено: фото коктейля, название, id, категория, тип коктейля, тип стакана для сервировки;
*Статус бар должен быть прозрачным, а изображение коктейля "лежать" под статус баром;
*Картинки коктейлей нужно подгружать асинхронно (на время загрузки показываьб индикатор прогресса);
*Также дополнительно должен быть раздел "Ингридиенты", который появляется при скролле страницы товара;
*Должна быть кнопка "Добавить в избранное" в виде иконки сердечка. При клике на иконку нужно менять ее состояние (полезная работа не выполняется, просто меняем состояние иконки - например, закрашиваем);
*Через Pull-to-Refresh (Swipe-to-Refresh) отображать новый коктейль (повторно запросить рандомный и отрисовать);
*Нужно уметь обрабатывать ошибки сети. При возникновении ошибки выводить кнопку Retry, при клике на которую приложение пытается загрузить новый коктейль и отобразить его.
