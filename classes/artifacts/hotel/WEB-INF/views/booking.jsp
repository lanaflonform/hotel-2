<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
</head>

<script>
    var service = 'http://localhost:8080/booking';
    var RestPut = function (name, room, startDate, endDate) {
        var JSONObject = {
            'name': name,
            'room': room,
            'startDate': startDate,
            'endDate': endDate
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
<h1>Booking menu</h1>

<table class="table">
    <tr>
        <th>Request type</th>
        <th>URL</th>
        <th>Value</th>
    </tr>
    <tr>
        <td>
            Add Booking <code><strong>PUT</strong></code>
        </td>
        <td>
            <code>/booking/add</code>
        </td>
        <td>
            <form class="form-inline">
                name: <input type="text" id="putName" value="bookingName">
                room: <input type="text" id="putRoom" value="bookingRoom">
                startDate: <input class="form-control" type="date" value="2017-11-19" id="putStartDate">
                endDate: <input class="form-control" type="date" value="2017-11-19" id="putEndDate">
                <button type="button" onclick="RestPut($('#putName').val(),
                        $('#putRoom').val(),$('#putStartDate').val(),$('#putEndDate').val())">Try</button>
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
