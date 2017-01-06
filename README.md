WebShop microservices

- delivery laber generator service
- review searcher service

REVIEW SEARCHER SERVICE user manual:

-First the service needs to be launched with a number argument (example:60001). From now on referring to it as port.

-The service server waits for a get request at localhost:port/api/review with a "title" query param as the name of the product. (example: localhost:60001/api/review?title=macbook pro) Whitespaces will be handled.

-The service returns a Json format string, containing 5 Jsons (5 search results) with keys from "0" to "4". Each of this Json has 2 keys, a "text" with value of the search title as String, and a "url" with the value of the search result URL as String.
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

-Have fun!
