<#macro login>
<div class="form__login">
    <div class="uk-text-large uk-margin-small-bottom">Авторизация</div>
    <form action="/login" method="post">
        <div class="uk-margin">
            <div class="uk-inline">
                <span class="uk-form-icon" uk-icon="icon: user"></span>
                <input class="uk-input" type="text" name="username" placeholder="Логин">
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div class="uk-margin">
            <div class="uk-inline">
                <span class="uk-form-icon uk-form-icon-flip" uk-icon="icon: lock"></span>
                <input class="uk-input" type="password" name="password" placeholder="Пароль">
            </div>
        </div>

        <button class="uk-button uk-button-danger uk-align-center">Войти</button>
    </form>
</div>
</#macro>


<#macro registration>
<div class="form__login ">
    <div class="uk-text-large uk-margin-small-bottom">Авторизация</div>
    <form action="/registration" method="post">
        <div class="uk-margin">
            <div class="uk-inline">
                <span class="uk-form-icon" uk-icon="icon: user"></span>
                <input class="uk-input" type="text" name="username" required>
            </div>
        </div>

        <input type="hidden" name="_csrf" value="${_csrf.token}" />

        <div class="uk-margin">
            <div class="uk-inline">
                <span class="uk-form-icon uk-form-icon-flip" uk-icon="icon: lock"></span>
                <input class="uk-input" type="password" name="password" placeholder="Пароль" required>
            </div>
        </div>

        <div class="uk-margin">
            <div class="uk-inline">
                <span class="uk-form-icon"  uk-icon="icon: pencil"></span>
                <input class="uk-input" type="text" name="name" placeholder="Имя" required>
            </div>
        </div>

        <div class="uk-margin">
            <div class="uk-inline">
                <span class="uk-form-icon"  uk-icon="icon: pencil"></span>
                <input class="uk-input" type="text" name="surname" placeholder="Фамилия" required>
            </div>
        </div>

        <div class="uk-margin">
            <div class="uk-inline">
                <span class="uk-form-icon"  uk-icon="icon: mail"></span>
                <input class="uk-input" type="email" name="email" placeholder="some@some.com" required>
            </div>
        </div>

        <div class="uk-margin">
            <div class="uk-inline">
                <span class="uk-form-icon"  uk-icon="icon: receiver"></span>
                <input class="uk-input" type="tel" name="number" placeholder="Номер телефона">
            </div>
        </div>

        <button class="uk-button uk-button-danger uk-align-center">Войти</button>
    </form>
</div>
</#macro>