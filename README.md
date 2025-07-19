Requisitos previos en otro computador

Instalar Git
  https://git-scm.com/downloads

Instalar Docker Desktop
  https://www.docker.com/products/docker-desktop/
Asegúrate de que Docker esté corriendo.

Ingresar al repositorio mio
https://github.com/Loping08/microservicios-proyecto

PASO A PASO desde PowerShell
1. Clonar el repositorio
   - Ingresar a PowerShell desde windows
   - ubicarse en la raiz por ejemplo PS C:\Users\juli\Documents>
   - ejecutar la siguiente linea de comando para clonar el proyecto: git clone https://github.com/Loping08/microservicios-proyecto
   - verificar la clonacion en la raiz ejemplo: C:\Users\julia\Documents\microservicios-proyecto
   - ejecutar cd microservicios-proyecto ejmeplo: PS C:\Users\julia\Documents> cd microservicios-proyecto
   - estando alli
     
3. Verifica que existe un docker-compose.yml
   -dir
   -ejemplo: PS C:\Users\julia\Documents\microservicios-proyecto> dir
     Mode                 LastWriteTime         Length Name
----                 -------------         ------ ----
d-----     18/07/2025  09:33 p. m.                microservicio-eureka
d-----     18/07/2025  09:33 p. m.                microservicio-gateway
d-----     18/07/2025  09:33 p. m.                microservicio-inventarios
d-----     18/07/2025  09:33 p. m.                microservicio-productos
d-----     18/07/2025  09:33 p. m.                mysql-init
d-----     18/07/2025  09:33 p. m.                README
-a----     18/07/2025  09:33 p. m.            227 .project
-a----     18/07/2025  09:33 p. m.           2193 docker-compose.yml
   - (Si ves el archivo docker-compose.yml, todo está bien)
     
4. Levantar los servicios con Docker Compose
   -docker-compose up --build
   -ejemplo: PS C:\Users\julia\Documents\microservicios-proyecto> docker-compose up --build

5. Esperar a que se levanten los Docker compose
   - debe salir algo como esto:
[+] Running 11/11
 ✔ eureka                                              Built                                                       0.0s
 ✔ productos                                           Built                                                       0.0s
 ✔ inventarios                                         Built                                                       0.0s
 ✔ gateway                                             Built                                                       0.0s
 ✔ Network microservicios-proyecto_red-microservicios  Cre...                                                      0.0s
 ✔ Volume "microservicios-proyecto_mysql-data"         Created                                                     0.0s
 ✔ Container eureka-server                             Created                                                     0.1s
 ✔ Container mysql-db                                  Created                                                     0.1s
 ✔ Container api-gateway                               Created                                                     0.1s
 ✔ Container ms-productos                              Created                                                     0.1s
 ✔ Container ms-inventarios                            Created                                                     0.1s
Attaching to api-gateway, eureka-server, ms-inventarios, ms-productos, mysql-db

   6. comensar a ejecutar desde Postman o el navegador los EndPoints
      - Nota: vease el documento Prueba Técnica Backend

EndPoints:
MICROSERVICIO PRODUCTOS
- Consutar productos(GET)
  http://localhost:8090/Swagger/OpenAPI/productos/
  
- Consultar productos por id(GET)
  http://localhost:8090/Swagger/OpenAPI/productos/1
  http://localhost:8090/Swagger/OpenAPI/productos/2
  http://localhost:8090/Swagger/OpenAPI/productos/3
  http://localhost:8090/Swagger/OpenAPI/productos/4
  
- Editar producto por id (PUT)
  http://localhost:8090/Swagger/OpenAPI/productos/1
  
  ejemplo en json
{
    "nombre": "MOUSE ZOWIE EC3",
    "precio": 880000

}
MICROSERVICIO INVENTARIOS
- Consultar cantidad(GET)
  http://localhost:8090/Swagger/OpenAPI/inventarios/producto/1
- Actualizar cantidad por id de producto(PUT)
  http://localhost:8090/Swagger/OpenAPI/inventarios/producto/1?nuevaCantidad=70

  nota: producto/id modificar id por el numero del producto y la variable nuevaCantidad=x, x por el numero de cantidad que quiere modificar

  NOTA: LO PUEDE HACER DESDE POSTMAN O DESDE EL NAVEGADOR
  RECOMENDACION: DESDE POSTMAN PUEDE EJECUTAR MEJOR LOS PUT con el body/raw formato en JSON aplica para editar de producto pero para actualizar la cantidad no es necesirio note que puede hacerlo enviando la variable nuevaCantidad=x
        
