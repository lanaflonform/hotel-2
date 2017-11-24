<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 22.11.17
  Time: 6:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>

<script>
    var service = 'http://localhost:8080/client';
    var RestPut = function (name, description) {
        var JSONObject = {
            'family': family,
            'name': name,
            'secondName': secondName,
            'dateOfBirth': dateOfBirth,
            'phone': phone,
            'level': level
        };

        $.ajax({
            type: 'PUT',
            url: service + '/add',
            contentType: 'application/json;utf-8',
            data: JSON.stringify(JSONObject),
            dataType: 'json',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result));
            },
            error: function (jqXHR, testStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR));
            }
        });
    };
</script>
<body>
<h1>Admin menu</h1>
<table class="table">
    <tr>
        <th> Request type</th>
        <th>URL</th>
        <th>Value</th>
    </tr>
    <tr>
        <td>
            Add Cat <code><strong> PUT</strong></code>
        </td>
        <td>
            <code> /client/add</code>
        </td>
        <td>
            <form class="form-inline">
                family: <input type="text" id="putFamily" value="clientFamily">
                name: <input type="text" id="putName" value="clientName">
                secondName: <input type="text" id="putSecondName" value="clientSecondName">
                dateOfBirth: <input type="date" id="putDateOfBirth" value="clientDateOfBirth">
                phone: <input type="text" id="putPhone" value="clientPhone">
                level: <input type="text" id="putLevel" value="clientLevel">
                <button type="button" onclick="RestPut($('#putFamily').val(),$('#putName').val(),$('#putSecondName').val(),$('#putDateOfBirth').val(),$('#putPhone').val(),$('#putLevel').val())">Try</button>
            </form>
        </td>
    </tr>
</table>
<div class="panel panel-default">
    <div class="panel-heading">
        <strong>RESPONSE</strong>
    </div>
    <div class="panel-body" id="response"></div>
</div>
</body>
</html>
