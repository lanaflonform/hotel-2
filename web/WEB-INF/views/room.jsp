<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
</head>

<script>
    var service = 'http://localhost:8080/room';
    var RestPut = function (number, description, type) {
        var JSONObject = {
            'number': number,
            'description': description,
            'type': type
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

    var RestGet = function (url) {

        $.ajax({
            type: 'GET',
            url: service + '/' + url,
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

    var RestDeleteById = function (id) {

        $.ajax({
            type: 'DELETE',
            url: service + '/delete?id=' + id,
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

    var RestPostUpdate = function (id, number, description, type) {
        var JSONObject = {
            'id': id,
            'number': number,
            'description': description,
            'type': type
        };

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
</script>

<body>
<h1>Admin menu</h1>

<table class="table">
    <tr>
        <th>Request type</th>
        <th>URL</th>
        <th>Value</th>
    </tr>
    <tr>
        <td>
            Add Room <code><strong>PUT</strong></code>
        </td>
        <td>
            <code>/room/add</code>
        </td>
        <td>
            <form class="form-inline">
                number: <input type="text" id="putNumber" value="roomNumber">
                description: <input type="text" id="putDescription" value="roomDescription">
                type: <input type="text" id="putType" value="roomType">
                <button type="button" onclick="RestPut($('#putNumber').val(), $('#putDescription').val(), $('#putType').val())">Try</button>
            </form>
        </td>
    </tr>
    <tr>
        <td>
            Get All Rooms <code><strong>GET</strong></code>
        </td>
        <td>
            <code>/room/all</code>
        </td>
        <td>
            <form class="form-inline">
                URL: <input type="text" id="getUrl" value="all">
                <button type="button" onclick="RestGet($('#getUrl').val())">Try</button>
            </form>
        </td>
    </tr>
    <tr>
        <td>
            Get Room By Id<code><strong>GET</strong></code>
        </td>
        <td>
            <code>/room/get/{id}</code>
        </td>
        <td>
            <form class="form-inline">
                Id: <input type="text" id="getId" value="1">
                <button type="button" onclick="RestGet('get/' + $('#getId').val())">Try</button>
            </form>
        </td>
    </tr>
    <tr>
        <td>
            Delete Room By Id <code><strong>DELETE</strong></code>
        </td>
        <td>
            <code>/room/delete?id={id}</code>
        </td>
        <td>
            <form class="form-inline">
                Id: <input type="text" id="deleteId" value="1">
                <button type="button" class="btn btn-danger" onclick="RestDeleteById($('#deleteId').val())">Try</button>
            </form>
        </td>
    </tr>
    <tr>
        <td>
            Update Room By Id <code><strong>POST</strong></code>
        </td>
        <td>
            <code>/room/update</code>
        </td>
        <td>
            <form class="form-inline">
                id: <input type="text" id="updateId" value="1">
                number: <input type="text" id="updateNumber" value="updateNumber">
                description: <input type="text" id="updateDescription" value="newRoomDescription">
                type: <input type="text" id="updateType" value="newRoomType">
                <button type="button" onclick="RestPostUpdate($('#updateId').val(),$('#updateNumber').val(), $('#updateDescription').val(), $('#updateType').val())">Try</button>
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
