** PROYECTO DE GESTIÓN DE FRANQUICIAS **

✨ Despliegue de la Aplicación

🔧 Prerrequisitos

Java 21: Asegúrate de tener instalada la versión 21 de Java.

Maven: Herramienta de construcción y gestión de dependencias.

Docker (opcional): Para desplegar la aplicación en un contenedor.

🚀 Construcción y Ejecución

Clonar el Repositorio:

git clone https://github.com/tu_usuario/tu_repositorio.git
cd tu_repositorio

Construir la Aplicación:

mvn clean package

Ejecutar la Aplicación:

Sin Docker:

java -jar target/tu_aplicacion.jar

Con Docker:

docker build -t mi_aplicacion_springboot .
docker run -p 9191:9191 mi_aplicacion_springboot

📚 Endpoints de la API

🏢 Franquicia

Obtener todas las franquicias

URL: /api_franquicia

Método: GET

Descripción: Recupera una lista de todas las franquicias.

Obtener una franquicia por ID

URL: /api_franquicia/{id}

Método: GET

Descripción: Recupera los detalles de una franquicia específica por su ID.

Crear una nueva franquicia

URL: /api_franquicia

Método: POST

Descripción: Crea una nueva franquicia.

Cuerpo de la solicitud:

{
  "nombre": "Nombre de la Franquicia",
  "sucursales": []
}

Actualizar una franquicia existente

URL: /api_franquicia/{id}

Método: PUT

Descripción: Actualiza los detalles de una franquicia existente.

🏬 Sucursal

Obtener todas las sucursales

URL: /api_sucursal

Método: GET

Descripción: Recupera una lista de todas las sucursales.

Obtener una sucursal por ID

URL: /api_sucursal/{id}

Método: GET

Descripción: Recupera los detalles de una sucursal específica por su ID.

Obtener una sucursal por nombre

URL: /api_sucursal/nombre/{nombre}

Método: GET

Descripción: Recupera los detalles de una sucursal específica por su nombre.

Crear una nueva sucursal

URL: /api_sucursal

Método: POST

Descripción: Crea una nueva sucursal.

Cuerpo de la solicitud:

{
  "nombre": "Nombre de la Sucursal",
  "productos": [],
  "franquicia": {
    "id": 1
  }
}

🛒 Producto

Obtener todos los productos

URL: /api_producto

Método: GET

Descripción: Recupera una lista de todos los productos.

Obtener un producto por ID

URL: /api_producto/{id}

Método: GET

Descripción: Recupera los detalles de un producto específico por su ID.

Crear un nuevo producto

URL: /api_producto

Método: POST

Descripción: Crea un nuevo producto.

Cuerpo de la solicitud:

{
  "nombre": "Nombre del Producto",
  "stock": 100,
  "sucursal": {
    "id": 1
  }
}

Actualizar un producto existente

URL: /api_producto/{id}

Método: PUT

Descripción: Actualiza los detalles de un producto existente.

💡 Notas Adicionales

Formato de Datos: Todas las respuestas y solicitudes utilizan el formato JSON.

Manejo de Errores: La API devuelve códigos de estado HTTP adecuados en caso de errores, como 404 Not Found si no se encuentra una entidad.