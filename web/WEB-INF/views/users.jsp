<%@ page contentType="text/html;charset=UTF-8" %>
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

<%--suppress JSUnusedLocalSymbols --%>
<script>
    var service = 'http://localhost:8080/admin/user';
    var RestPut = function (firstName, lastName, email, registered, login, password, enabled) {
        var JSONObject = {
            'firstName': firstName,
            'lastName': lastName,
            'email': email,
            'registered': registered,
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

    var RestUpdate = function (id, firstName, lastName, email, registered, login, password, enabled) {
        var JSONObject = {
            'id': id,
            'firstName': firstName,
            'lastName': lastName,
            'email': email,
            'registered': registered,
            'login': login,
            'password': password,
            'enabled': enabled,
            'roles': []
        };

        console.log(JSON.stringify(JSONObject));

        $.ajax({
            type: 'POST',
            url: service + '/update',
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

    var RestGetAll = function () {
        $.ajax({
            type: 'GET',
            url: service + '/all',
            contentType: 'application/json;utf-8',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result));
            },
            error: function (jqXHR, testStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR));
            }
        });
    };

    var RestGetById = function (id) {
        $.ajax({
            type: 'GET',
            url: service + '/get/' + id,
            contentType: 'application/json;utf-8',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result));
            },
            error: function (jqXHR, testStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR));
            }
        });
    };

    var RestGetByLogin = function (login) {
        $.ajax({
            type: 'GET',
            url: service + '/get/login/' + login,
            contentType: 'application/json;utf-8',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result));
            },
            error: function (jqXHR, testStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR));
            }
        });
    };

    var RestGetByEmail = function (email) {
        $.ajax({
            type: 'POST',
            url: service + '/get/email',
            contentType: 'application/json;utf-8',
            data: email,
            dataType: 'text',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result));
            },
            error: function (jqXHR, testStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR));
            }
        });
    };

    var RestDelete = function (id) {
        $.ajax({
            type: 'DELETE',
            url: service + '/delete/' + id,
            contentType: 'application/json;utf-8',
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
        <td>Add user</td>
        <td>
            <code>PUT http://localhost:8080/admin/user/add</code>
        </td>
        <td>
            <form>
                <table>
                    <tr>
                        <td><label for="firstName">firstName:</label></td>
                        <td><input type="text" id="firstName" value="first name"></td>
                    </tr>
                    <tr>
                        <td><label for="lastName">lastName:</label></td>
                        <td><input type="text" id="lastName" value="last name"></td>
                    </tr>
                    <tr>
                        <td><label for="email">email:</label></td>
                        <td><input type="text" id="email" value="test@test.com"></td>
                    </tr>
                    <tr>
                        <td><label for="registered">registered:</label></td>
                        <td><input class="form-control" type="date" id="registered" value="2017-12-01"></td>
                    </tr>
                    <tr>
                        <td><label for="login">login:</label></td>
                        <td><input type="text" id="login" value="testUser"></td>
                    </tr>
                    <tr>
                        <td><label for="password">password:</label></td>
                        <td><input type="password" id="password" value="Secret"></td>
                    </tr>
                    <tr>
                        <td><label for="enabled">enabled:</label></td>
                        <td><input type="checkbox" id="enabled"></td>
                    </tr>
                </table>
                <br>
                <button type="button"
                        onclick="RestPut(
                            $('#firstName').val(),
                            $('#lastName').val(),
                            $('#email').val(),
                            $('#registered').val(),
                            $('#login').val(),
                            $('#password').val(),
                            $('#enabled').is(':checked')
                        )">Try
                </button>
            </form>
        </td>
    </tr>
    <tr>
        <td>Get all users</td>
        <td>
            <code>GET http://localhost:8080/admin/user/all</code>
        </td>
        <td>
            <form>
                <button type="button" onclick="RestGetAll()">Try</button>
            </form>
        </td>
    </tr>
    <tr>
        <td>Get user by id</td>
        <td>
            <code>GET http://localhost:8080/admin/user/get/{id}</code>
        </td>
        <td>
            <form>
                <table>
                    <tr>
                        <td><label for="id">id:</label></td>
                        <td><input type="text" id="id" value="1"></td>
                    </tr>
                </table>
                <br>
                <button type="button" onclick="RestGetById($('#id').val())">Try</button>
            </form>
        </td>
    </tr>
    <tr>
        <td>Get user by login</td>
        <td>
            <code>GET http://localhost:8080/admin/user/get/login/{login}</code>
        </td>
        <td>
            <form>
                <table>
                    <tr>
                        <td><label for="getByLogin">login:</label></td>
                        <td><input type="text" id="getByLogin" value="testUser"></td>
                    </tr>
                </table>
                <br>
                <button type="button" onclick="RestGetByLogin($('#getByLogin').val())">Try</button>
            </form>
        </td>
    </tr>
    <tr>
        <td>Get user by email</td>
        <td>
            <code>POST http://localhost:8080/admin/user/get/email</code>
        </td>
        <td>
            <form>
                <table>
                    <tr>
                        <td><label for="getByEmail">email:</label></td>
                        <td><input type="text" id="getByEmail" value="test@test.com"></td>
                    </tr>
                </table>
                <br>
                <button type="button" onclick="RestGetByEmail($('#getByEmail').val())">Try</button>
            </form>
        </td>
    </tr>
    <tr>
        <td>Update user</td>
        <td>
            <code>POST http://localhost:8080/admin/user/update</code>
        </td>
        <td>
            <form>
                <table>
                    <tr>
                        <td><label for="newId">id:</label></td>
                        <td><input type="text" id="newId" value="1"></td>
                    </tr>
                    <tr>
                        <td><label for="newFirstName">firstName:</label></td>
                        <td><input type="text" id="newFirstName" value="first name"></td>
                    </tr>
                    <tr>
                        <td><label for="newLastName">lastName:</label></td>
                        <td><input type="text" id="newLastName" value="last name"></td>
                    </tr>
                    <tr>
                        <td><label for="newEmail">email:</label></td>
                        <td><input type="text" id="newEmail" value="test@test.com"></td>
                    </tr>
                    <tr>
                        <td><label for="newRegistered">registered:</label></td>
                        <td><input class="form-control" type="date" id="newRegistered" value="2017-12-01"></td>
                    </tr>
                    <tr>
                        <td><label for="newLogin">login:</label></td>
                        <td><input type="text" id="newLogin" value="testUser"></td>
                    </tr>
                    <tr>
                        <td><label for="newPassword">password:</label></td>
                        <td><input type="password" id="newPassword" value="Secret"></td>
                    </tr>
                    <tr>
                        <td><label for="newEnabled">enabled:</label></td>
                        <td><input type="checkbox" id="newEnabled"></td>
                    </tr>
                </table>
                <br>
                <button type="button"
                        onclick="RestUpdate(
                            $('#newId').val(),
                            $('#newFirstName').val(),
                            $('#newLastName').val(),
                            $('#newEmail').val(),
                            $('#newRegistered').val(),
                            $('#newLogin').val(),
                            $('#newPassword').val(),
                            $('#newEnabled').is(':checked')
                        )">Try
                </button>
            </form>
        </td>
    </tr>
    <tr>
        <td>Delete user</td>
        <td>
            <code>DELETE http://localhost:8080/admin/user/delete/{id}</code>
        </td>
        <td>
            <form>
                <table>
                    <tr>
                        <td><label for="deleteId">id:</label></td>
                        <td><input type="text" id="deleteId" value="1"></td>
                    </tr>
                </table>
                <br>
                <button type="button" onclick="RestDelete($('#deleteId').val())">Try</button>
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
