# Web Framework para Servicios REST y Archivos Estáticos

## 1. Descripción del Proyecto

Este proyecto tiene como objetivo transformar un servidor web básico en un **framework completo** para el desarrollo de aplicaciones web con soporte para servicios REST y archivos estáticos. El framework permitirá definir servicios REST utilizando funciones lambda, gestionar valores de consulta en solicitudes y especificar la ubicación de archivos estáticos.

## 2. Características Principales

### 2.1. Método GET para Servicios REST

Se implementa un método `get()` para definir servicios REST con funciones lambda.

#### Ejemplo de Uso:
```java
get("/hello", (req, res) -> "hello world!");
```

### 2.2. Extracción de Valores de Consulta

Se desarrolla un mecanismo para obtener parámetros de consulta en las solicitudes.

#### Ejemplo de Uso:
```java
get("/hello", (req, res) -> "hello " + req.getValues("name"));
```

### 2.3. Especificación de Ubicación de Archivos Estáticos

Se introduce un método `staticfiles()` para definir la carpeta de archivos estáticos (que en este caso se encontraria dentro de la carpeta de resources/webroot).

#### Ejemplo de Uso:
```java
staticfiles("/webroot");
```

El framework buscará archivos estáticos en `src/main/resources/webroot`.

## 3. Instalación

### 3.1. Prerrequisitos

Para ejecutar este proyecto, necesitas tener instalado:
- **Java JDK 11** o superior
- **Apache Maven**
- **Un IDE de Java** (IntelliJ IDEA, Eclipse o VS Code con soporte para Java)

### 3.2. Clonar el Repositorio

```sh
git clone https://github.com/usuario/framework-web.git
cd framework-web
```

### 3.3. Compilación y Ejecución con Maven

```sh
mvn clean compile exec:java
```

## 4. Ejecución del Servidor

Para iniciar el servidor, ejecuta:

```sh
java -cp target/classes com.mycompany.webproyect.HTTPServer
```

El servidor estará disponible en `http://localhost:35000`.

## 5. Ejemplo de Uso

### 5.1. Definir Servicios REST y Archivos Estáticos

```java
public static void main(String[] args) {
    staticfiles("/webroot");
    get("/hello", (req, resp) -> "Hello " + req.getValues("name"));
    get("/pi", (req, resp) -> String.valueOf(Math.PI));
}
```

### 5.2. Solicitudes Disponibles

- `http://localhost:8080/app/hello?name=Pedro` devuelve `Hello World`
- `http://localhost:8080/app/pi` devuelve el valor de `PI`
- `http://localhost:8080/webroot/index.html` devuelve un archivo estático

## 6. Arquitectura del Framework

El framework está diseñado para manejar solicitudes HTTP y mapear rutas a funciones lambda.

### 6.1. Componentes Principales

#### 1. `HTTPServer.java`
- Maneja las conexiones y el enrutamiento de solicitudes REST.

#### 2. `WebProyect.java`
- Procesa la solicitud y extrae los valores de consulta.

#### 4. `FileController.java`
- Gestiona la entrega de archivos estáticos.

## 7. Pruebas Realizadas

### 7.1. Prueba de Acceso a Servicios REST

#### **Caso:** Solicitud a `/hello?name=Pedro`
- **Esperado:** `Hello World`
- **Resultado:** ✅ Correcto

![image](https://github.com/user-attachments/assets/33a9d45e-a110-43c5-b422-d09319f9fa37)

### 7.2. Prueba de Archivos Estáticos

#### **Caso:** Solicitar `index.html`
- **Esperado:** Contenido del archivo
- **Resultado:** ✅ Correcto

![image](https://github.com/user-attachments/assets/c6f474d9-ab7b-48dd-9c41-c81b0f1e15ae)

### 7.3. Prueba de Error 404

#### **Caso:** Solicitar un archivo inexistente
- **Esperado:** `Error 404 - No encontrado`
- **Resultado:** ✅ Correcto

![image](https://github.com/user-attachments/assets/b14f247b-3f71-4877-aba9-cbde4e0d7223)

## 8. Conclusión

El framework desarrollado permite la creación de aplicaciones web simples y escalables con soporte para servicios REST y archivos estáticos. Proporciona un mecanismo intuitivo para definir rutas y manejar peticiones HTTP de manera eficiente.
