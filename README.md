Итоговый проект «Система управления личными финансами» (KP)

Главная меню

После запуска программы вы увидите главное меню с тремя опциями:

    Регистрация — Создайте нового пользователя.
    Вход — Авторизуйтесь для доступа к кошельку.
    Выход — Завершите работу приложения.

Используйте ввод чисел (1, 2 или 3), чтобы выбрать пункт меню.
Регистрация пользователя

    Выберите пункт 1. Регистрация.
    Введите уникальное имя пользователя.
    Придумайте и введите пароль.
    Если регистрация успешна, программа выведет сообщение:
    Регистрация успешна.

Авторизация

    Выберите пункт 2. Вход.
    Введите зарегистрированное имя пользователя.
    Введите пароль.
    Если данные введены правильно, появится сообщение:
    Вход выполнен успешно. Добро пожаловать, <ваше_имя_пользователя>!

Меню пользователя

После авторизации доступны следующие опции:

    Добавить доход
    Укажите сумму дохода. Баланс кошелька увеличится на введённую сумму.

    Добавить расход
    Укажите сумму расхода. Если баланс позволяет, сумма будет вычтена.

    Просмотреть баланс кошелька
    Показывает текущий баланс в формате:
    Текущий баланс кошелька: <сумма>.

    Перевести средства
        Укажите имя пользователя-получателя.
        Если получатель найден, программа запросит сумму перевода.
        Укажите сумму для перевода. Если средств достаточно, будет выполнен перевод, и балансы отправителя и получателя обновятся.

    Выйти
    Возвращает в главное меню.

Примечания:

    Пароли пользователей хранятся в формате MD5-хеша для повышения безопасности.
    Вся работа выполняется с использованием интерфейсов и классов, чтобы гарантировать модульность и удобство поддержки кода.
    Все операции кошелька сохраняются в памяти до завершения работы программы.
