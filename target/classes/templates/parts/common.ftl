<#macro page>
<html html>
<head>
    <title>SmartStreamChat - Чат для стрима</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/static/style/main.css">
    <!-- UIkit CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.0.0-rc.10/css/uikit.min.css" />
</head>

<body class="bc">
    <#include "video.ftl">
<div class="uk-panel uk-height-1-1">
    <#include "navbar.ftl">
    <#nested>
</div>
<!-- UIkit JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.0.0-rc.10/js/uikit.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.0.0-rc.10/js/uikit-icons.min.js"></script>
<script src="/static/js/main.js"></script>

</body>

</html>
</#macro>