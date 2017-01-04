WebShop microservices

- delivery laber generator service


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