# WebShop microservices by LAMAgroup

## delivery label generator service



This service service gets a json with name, delivery address and 
order id of orders, creates a downloadable pdf file with well 
formatted labels with the given datas and gives back the url of the 
downloadable pdf.


#### Usage:
ajax example:

```javascript
$("#test").click(function() {
    	$.ajax({
        url: "http://localhost:60000/api/create-label",
        data: {orders: "[{name: name, city: city, address: address2, id:id}, 
        {name: name2, city: city2, address: address2, id: id2}]"},
        success: function(resp){
          console.log(resp);
        }
    });
```


## review searcher service

This service  gets a json with name, delivery address and order id of orders, creates a downloadable pdf file with well formatted labels with the given datas and gives back the url of the downloadable pdf.



created by [LAMAgroup](https://github.com/CodecoolBP20161/from-python-to-java-microservices-lama) 
/[CodeCool](https://codecool.com)/