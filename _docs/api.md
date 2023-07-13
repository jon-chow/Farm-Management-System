# API Documentation

## Introduction

Welcome to the API documentation for the Farming Management System. This documentation provides an overview of the
available endpoints, request/response formats, and example usage.

## Base URL

There is currently no domain name associated with the application.

## Authentication

To access the API, you need to include an authentication token in the request headers. The token should be included in
the Authorization header as a Bearer token.

## Endpoints

### **Livestock**

### Get all livestock

* Endpoint: /api/v1/livestock
* Method: GET
* Description: Retrieves a list of all livestock entries.
* Request Parameters: None
* Response:
    * Status Code: 200 (OK)
    * Body:

```json
[
  {
    "tag_id": 1,
    "animal_type": "CHICKEN",
    "age": 2,
    "weight": 1.5,
    "last_fed": "2023-07-09",
    "harvestable": true,
    "last_violated_for_harvested_goods": "2023-07-08"
  },
  ...
]
```

### Get a specific livestock

* Endpoint: /api/v1/livestock/{tagId}
* Method: GET
* Description: Retrieves a specific livestock entry by its tag ID.
* Request Parameters:
    * {tagId} (path parameter): The tag ID of the livestock.
* Response:
    * Status Code: 200 (OK)
    * Body:

```json
 {
  "tag_id": 1,
  "animal_type": "CHICKEN",
  "age": 2,
  "weight": 1.5,
  "last_fed": "2023-07-09",
  "harvestable": true,
  "last_violated_for_harvested_goods": "2023-07-08"
}
```

### Create a new livestock

* Endpoint: /api/v1/livestock
* Method: POST
* Description: Creates a new livestock entry.
* Request Body:

```json
{
  "animal_type": "SHEEP",
  "age": 1,
  "weight": 30.5,
  "last_fed": "2023-07-09",
  "harvestable": false,
  "last_violated_for_harvested_goods": null
}
```

* Response:
    * Status Code: 201 (Created)
    * Body:

```json
{
  "tag_id": 2,
  "animal_type": "SHEEP",
  "age": 1,
  "weight": 30.5,
  "last_fed": "2023-07-09",
  "harvestable": false,
  "last_violated_for_harvested_goods": null
}
```

### Update an existing livestock

* Endpoint: /api/v1/livestock/{tagId}
* Method: PUT
* Description: Updates an existing livestock entry.
* Request Parameters:
  {tagId} (path parameter): The tag ID of the livestock to be updated.
* Request Body:

```json
{
  "animal_type": "COW",
  "age": 3,
  "diet": "WHEAT",
  "weight": 500.0,
  "last_fed": "2023-07-09",
  "harvestable": true,
  "last_violated_for_harvested_goods": null
}
```

* Response:
    * Status Code: 200 (OK)
    * Body:

```json
{
  "tag_id": 1,
  "animal_type": "COW",
  "age": 3,
  "diet": "WHEAT",
  "weight": 500.0,
  "last_fed": "2023-07-09",
  "harvestable": true,
  "last_violated_for_harvested_goods": null
}
```

### Delete a livestock

* Endpoint: /api/v1/livestock/{tagId}
* Method: DELETE
* Description: Deletes a specific livestock entry by its tag ID.
* Request Parameters:
  {tagId} (path parameter): The tag ID of the livestock to be deleted.
* Response:
    * Status Code: 204 (No Content)

### Error Handling

In case of any errors, the API will return appropriate HTTP status codes along with error messages in the response body.

### Conclusion

This concludes the API documentation for the Farming Management System. Please refer to the provided endpoint details
and example requests/responses to integrate and utilize the API effectively.
