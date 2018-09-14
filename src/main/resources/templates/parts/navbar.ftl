<#include "security.ftl">
<div class="nav-bar">
    <nav class="uk-navbar-container uk-margin color-black" uk-navbar>
        <div class="uk-navbar-center">

            <div class="uk-navbar-center-left">
                <div>
                    <ul class="uk-navbar-nav">
                        <li class="uk-active"><a href="/">Главная</a></li>
                        <li>
                            <a href="/download">Скачать</a>
                        </li>
                    </ul>
                </div>
            </div>
            <a class="uk-navbar-item uk-logo" href="/">Smart Stream Chat</a>
            <div class="uk-navbar-center-right"><div>
                <ul class="uk-navbar-nav">
                    <li><a href="#">Реклама</a></li>
                    <li>
                    <#if !know>
                        <a href="#">Аккаунт</a>
                        <div class="uk-navbar-dropdown">
                            <ul class="uk-nav uk-navbar-dropdown-nav">

                                <li><a href="/login">Вход</a></li>
                                <li><a href="/registration">Регистрация</a></li>

                            </ul>
                        </div>
                    </#if>
                    </li>
                <#if know>
                <li>
                    <a href="#">${user.getUsername()} ${user.getSurname()}</a>
                    <div class="uk-navbar-dropdown">
                        <ul class="uk-nav uk-navbar-dropdown-nav">

                            <li><a href="/account">Личный кабинет</a></li>
                            <li>
                                <form action="/logout" method="post">
                                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                                    <button class="uk-button uk-button-text uk-text-capitalize">Выход</button>
                                </form>
                            </li>

                        </ul>
                    </div>
                </li>
                </#if>
                </ul>
            </div></div>

        </div>
    </nav>
</div>
<div class="nav-bar-fail"></div>