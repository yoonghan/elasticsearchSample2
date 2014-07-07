elasticsearchSample2
====================
Simple program that populates a queue message into a file.
this file is compatible and is able to be pushed into elastic search.

Executed via 
curl -Post 'http://localhost:9200/sample/queue/_bulk' --data-binary @createAFile.json
