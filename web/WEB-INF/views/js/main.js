var header = new Vue({
  el:'.header',
  data:{
    nameHote:function () {
      var service = 'http://localhost:8080/info';
      var RestPut = function (name, description) {
        var JSONObject = {
          'nameHotel': nameHotel,
        };
        $.ajax({
          type: 'GET',
          url: service + '/get',
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
      }
      return d
    },
    infoHotel: function () {

    }
  }

})
