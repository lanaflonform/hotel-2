<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
</head>

<style>
    td {
        padding: 3px;
    }
</style>

<script>
    var service = 'http://localhost:8080/admin/user';
    var RestPut = function (firstname, lastname, email, birthday, login, password, enabled) {
        var JSONObject = {
            'firstName': firstname,
            'lastName': lastname,
            'email': email,
            'birthday': birthday,
            'login': login,
            'password': password,
            'enabled': enabled,
            'roles': []
        };

        console.log(JSON.stringify(JSONObject));

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
<h1>Users</h1>

<table class="table">
    <tr>
        <th>Request type</th>
        <th>URL</th>
        <th>Value</th>
    </tr>
    <tr>
        <td>
            Add User <code><strong>PUT</strong></code>
        </td>
        <td>
            <code>/add</code>
        </td>
        <td>
            <form>
                <table>
                    <tr>
                        <td>firstName:</td>
                        <td><input type="text" id="firstname" value="first name"></td>
                    </tr>
                    <tr>
                        <td>lastName:</td>
                        <td><input type="text" id="lastname" value="last name"></td>
                    </tr>
                    <tr>
                        <td>email:</td>
                        <td><input type="text" id="email" value="test@test.com"></td>
                    </tr>
                    <tr>
                        <td>birthday:</td>
                        <td><input class="form-control" type="date" id="birthday" value="2017-12-01"></td>
                    </tr>
                    <tr>
                        <td>login:</td>
                        <td><input type="text" id="login" value="testUser"></td>
                    </tr>
                    <tr>
                        <td>password:</td>
                        <td><input type="password" id="password" value="Secret"></td>
                    </tr>
                    <tr>
                        <td>enabled:</td>
                        <td><input type="checkbox" id="enabled"></td>
                    </tr>
                </table>
                <br>
                <button type="button"
                        onclick="RestPut(
                            $('#firstname').val(),
                            $('#lastname').val(),
                            $('#email').val(),
                            $('#birthday').val(),
                            $('#login').val(),
                            $('#password').val(),
                            $('#enabled').is(':checked')
                        )">Try
                </button>
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