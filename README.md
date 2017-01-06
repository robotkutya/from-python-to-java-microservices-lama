# WebShop microservices by LAMAgroup

- delivery laber generator service
- review searcher service

**********
DELIVERY LABEL GENERATOR
**********

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


**********
REVIEW SEARCHER
**********
 - Overview

This microservice will search Google for product reviews.
It requires a call with a search term ("TERM") and will search for
("TERM review"). It uses the standard Google UI and parses the
html for the first 5 results. It returns a JSON object as a String
that contains these results.


 - Usage

1) Start the service: ReviewFinderService
   The port should be given as an argument.

2) Make an API request on the "/api/review" route
   The search term should be a query parameter for "title",
   e.g."/api/review/review?title=iphone" to search for
   iphone reviews

3) The return JSON string has the following key-value pairs:
   {id : JSON}
   id: a number starting from 0, but it is a String

   JSON:
   This JSON has the following key-value pairs:
   {text: description, url: URL}
   text: text is always the String "text"
   description: the description of the URL from the Google search result
   url: text is always the String "url"
   link: the URL of the Google search result

   Example:
   {
      "0":{
         "text":"MacBook Pro review (2016): A step forward and a step back",
         "url":"https://www.engadget.com/2016/11/14/macbook-pro-review-2016/"
      },
      "1":{
         "text":"Review: Apple MacBook Pro With Touch Bar | WIRED",
         "url":"https://www.wired.com/2016/11/review-apple-macbook-pro-touch-bar/"
      },
      "2":{
         "text":"Apple MacBook Pro with Touch Bar review: Second-screen dream ...",
         "url":"https://www.cnet.com/products/apple-macbook-pro-with-touch-bar-13-inch-2016/review/"
      },
      "3":{
         "text":"New MacBook Pro 2016 review | MacBook Pro with Touch Bar ...",
         "url":"http://www.macworld.co.uk/review/mac-laptops/new-macbook-pro-2016-review-touch-bar-update-3648587/"
      },
      "4":{
         "text":"MacBook Pro with Touch Bar review: a touch of the future - The Verge",
         "url":"http://www.theverge.com/2016/11/14/13616404/apple-macbook-pro-touch-bar-review-2016-13-inch-15-inch-laptop"
      }
   }