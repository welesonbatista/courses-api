# Courses API

This is a simple REST API for managing courses. Below you will find the available endpoints, expected parameters, and example request/response bodies.

## API Endpoints

### Create Course

**POST** `/courses/`

**Body:**

```json
{
  "name": "Java Basics",
  "category": "Programming",
  "teacher": "John Doe",
  "active": true
}
```

**Response:**

```json
{
  "id": "<uuid>",
  "name": "Java Basics",
  "category": "Programming",
  "teacher": "John Doe",
  "active": true,
  "created_at": "2024-01-01T12:00:00",
  "updated_at": "2024-01-01T12:00:00"
}
```

---

### List Courses

**GET** `/courses/`

**Query Parameters (optional):**

- `name` (string): Filter by course name
- `category` (string): Filter by category

**Response:**
Array of course objects (see Create Course response)

---

### Update Course

**PUT** `/courses/?id=<uuid>`

**Body:**

```json
{
  "name": "Advanced Java",
  "category": "Programming",
  "teacher": "Jane Smith"
}
```

**Response:**
Returns the updated course data (same as request body)

---

### Delete Course

**DELETE** `/courses/?id=<uuid>`

**Response:**
String message: `"Course deleted successfully"` or error message

---

### Patch Course Active Status

**PATCH** `/courses/?id=<uuid>&active=<true|false>`

**Response:**
String message: `"Course Active status updated successfully"` or error message

---

## Error Response Example

When a request fails due to validation or business rules, the API returns:

```json
{
  "message": "Error description",
  "field": "fieldName or null"
}
```

## Technologies

- Java
- Spring Boot

## Status

This project is a work in progress. More features and documentation will be added soon.

## Getting Started

To run or contribute, clone the repository and follow the setup instructions (coming soon).

---

Feel free to contribute or open issues as development progresses!
