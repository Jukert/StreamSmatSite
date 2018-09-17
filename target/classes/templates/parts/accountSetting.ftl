
<div class="account-panel">

    <div class="avatar-block">
        <div class="uk-inline-clip uk-transition-toggle" tabindex="0">
            <img src="/static/images/man.svg" alt="">
            <div class="uk-transition-slide-bottom uk-position-bottom uk-overlay uk-overlay-default trans">
                <div class="uk-h4 uk-margin-remove uk-text-center">
                    <form action="/account" method="post" enctype="multipart/form-data">
                        <input type="hidden" name="_csrf" value="${_csrf.token}" />
                        <span uk-icon="upload"><input class="uk-button uk-button-text uk-text-capitalize"  value="Загрузить" onclick="document.getElementById('inputLoad').click();"  type="file" >
                        <button class="uk-button uk-button-text uk-text-capitalize" id="inputLoad" style="display: none"/>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div class="text-initial uk-text-uppercase">${userSettings.getName()} ${userSettings.getSurname()}</div>

    <div class="information-block">
        <div>
            <ul class="uk-flex-left" uk-tab>
                <li class="uk-active"><a href="#">Профиль</a></li>
                <li><a href="#">Изменить</a></li>
                <li><a href="#">Купить привелегии</a></li>
            </ul>
            <ul class="uk-switcher uk-margin">
                <li class="inf-labels">
                    <div class="information-detailed">
                        <table class="uk-table uk-table-responsive uk-table-divider">
                            <tbody>
                            <tr>
                                <td>Логин</td>
                                <td>${userSettings.getUsername()}</td>
                            </tr>
                            <tr>
                                <td>Имя</td>
                                <td>${userSettings.getName()}</td>
                            </tr>

                            <tr>
                                <td>Фамилия</td>
                                <td>${userSettings.getSurname()}</td>
                            </tr>
                            <tr>
                                <td>Почта</td>
                                <td><#if userSettings.getEmail()?? > ${userSettings.getEmail()} <#else> - </#if></td>
                            </tr>
                            <tr>
                                <td>Телефон</td>
                                <td><#if userSettings.getNumber()?? > ${userSettings.getNumber()} <#else> - </#if></td>
                            </tr>
                            <tr>
                                <td>О себе</td>
                                <td><#if userSettings.getMyself()?? > ${userSettings.getMyself()} <#else> Пока информации о себе нету... </#if></td>
                            </tr>

                            </tbody>
                        </table>
                    </div>
                </li>
                <li><div class="information-detailed">
                    <form action="/account/change" method="post">
                        <input type="hidden" name="_csrf" value="${_csrf.token}" />
                        <input type="hidden" name="userId" value="${userSettings.getId()}" />
                        <table class="uk-table uk-table-responsive uk-table-divider">
                            <tbody>
                            <tr>
                                <td>Логин</td>
                                <td><input class="uk-input changed-user-settings" id="form-stacked-text" type="text" name="username" value="${userSettings.getUsername()}" placeholder="Логин"></td>
                            </tr>
                            <tr>
                                <td>Имя</td>
                                <td><input class="uk-input changed-user-settings" id="form-stacked-text" type="text" name="name" value="${userSettings.getName()}" placeholder="Имя"></td>
                            </tr>
                            <tr>
                                <td>Фамилия</td>
                                <td><input class="uk-input changed-user-settings" id="form-stacked-text" type="text" name="surname" value="${userSettings.getSurname()}" placeholder="Логин"></td>
                            </tr>
                            <tr>
                                <td>Почта</td>
                                <td><input class="uk-input changed-user-settings" id="form-stacked-text" type="text" name="email" value="<#if userSettings.getEmail()?? >${userSettings.getEmail()}<#else> - </#if>" placeholder="Логин"></td>
                            </tr>
                            <tr>
                                <td>Телефон</td>
                                <td><input class="uk-input changed-user-settings" id="form-stacked-text" type="text" name="number" value="<#if userSettings.getNumber()?? >${userSettings.getNumber()}<#else> - </#if>" placeholder="Логин"></td>
                            </tr>
                            <tr>
                                <td>О себе</td>
                                <td><textarea class="changed-user-settings uk-textarea" name="myself" id="" rows="5"><#if userSettings.getMyself()?? >${userSettings.getMyself()}<#else> Пока информации о себе нету... </#if></textarea></td>
                            </tr>
                            </tbody>
                        </table>
                        <button class="uk-button uk-button-danger uk-align-center uk-margin-large-bottom uk-width-1-2">Сохранить</button>
                    </form>
                </div>
                </li>
                <li>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur, sed do eiusmod.</li>
            </ul>
        </div>




    </div>

</div>
