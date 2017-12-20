#  Hotel
## Goods
Goods REST API  позволяет управлять товарами отеля.
###Public goods REST API:
* GET goods/all - получить список всех товаров ```domain_name/goods/all```
* GET goods/get/id - получить товар по id ```domain_name/goods/all/goods/get/6```
* DELETE goods/delete - удалить товар из базы по id ```domain_name/goods/delete?id=6```
* PUT goods/add - добавить новый товар в базу ```domain_name/goods/add + [body]```  Тело запроса должно содержать объект с новым продуктом
* POST goods/update - обновить информацию по существующему продукту ```domain_name/goods/update``` Тело запроса должно содержать объект с обновлённым продуктом

 ```domain_name``` - полное доменное имя