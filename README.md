WebShop microservices

- delivery laber generator service
- review searcher service


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