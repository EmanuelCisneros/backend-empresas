
🏢 Backend Empresas - Spring Boot + MongoDB

 Tech : 

- Java 17
- Spring Boot 3
- MongoDB (Spring Data)
- Maven
- Lombok
- JUnit 5 + Mockito
- Postman (para pruebas manuales)
- IntelliJ IDEA


 Endpoints: 

| Método | Endpoint                                  | Descripción                                           |
|--------|-------------------------------------------|-------------------------------------------------------|
| GET    | /empresas/con-transferencias              | Empresas que realizaron transferencias el último mes |
| GET    | /empresas/adheridas-ultimo-mes            | Empresas adheridas el último mes                     |
| POST   | /empresas                                 | Crear nueva empresa                                  |
| POST   | /empresas/transferencias                  | Crear nueva transferencia para una empresa           |

📮 Ejemplos de requests

Crear empresa (POST /empresas)

{
"nombre": "Empresa Test S.A.",
"cuit": "30-12345678-9",
"fechaAlta": "2025-03-01"
}

Crear transferencia (POST /empresas/transferencias)
{
"importe": 2500.75,
"empresaId": "ID_EMPRESA_AQUI",
"cuentaDebito": "1234567890",
"cuentaCredito": "0987654321",
"fecha": "2025-03-10"
}

3. Levantar el proyecto :

./mvnw spring-boot:run


Gracias Leer! :)