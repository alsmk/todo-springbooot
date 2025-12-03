Run this command to start mongo
```bash
docker run -d -p 27017:27017 --name mongodb mongo:latest

```

To create a todo 
```bash
curl -X POST http://localhost:8080/api/todos \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Learn Spring Boot",
    "description": "Complete the todo app tutorial",
    "priority": "HIGH"
  }'
```