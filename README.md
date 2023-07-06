# Getting Started

```http request
###
POST http://localhost:8080/api/books
Content-Type: application/json

{
  "title": "Effective Java",
  "author": "Joshua J. Bloch"
}

###
PATCH http://localhost:8080/api/books
Content-Type: application/json

{
  "id": 1,
  "title": "Effective Java: Programming Language Guide"
}

###
GET http://localhost:8080/api/v1/books-history/revisions/1

###
GET http://localhost:8080/api/v1/books-history/creator/1
```

