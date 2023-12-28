# Proyecto de Consulta de Precios en Comercio Electrónico

Este proyecto implementa un servicio en SpringBoot que ofrece un endpoint REST para consultar precios en la base de datos de comercio electrónico de la compañía. La información se extrae de la tabla `PRICES`, que refleja el precio final (PVP) y la tarifa que se aplica a un producto de una cadena en un rango de fechas determinado.

## Cómo Ejecutar el Proyecto

1. Clona este repositorio: `git clone https://github.com/barbaat/bcnc-inditex.git`.
2. Abre el proyecto en tu IDE favorito.
3. Ejecuta `mvn clean install` para isntalar todas las despendencias y compilar la aplicación.
3. Ejecuta la aplicación SpringBoot con Maven: `mvn spring-boot:run`.
4. Accede al endpoint REST para realizar consultas de precios.

## Ejemplos de Test

Se han desarrollado tests para el endpoint REST que validan las siguientes peticiones al servicio con los datos del ejemplo:

- **Test 1:** Petición a las 10:00 del día 14 para el producto 35455 y la cadena 1 (ZARA).
- **Test 2:** Petición a las 16:00 del día 14 para el producto 35455 y la cadena 1 (ZARA).
- **Test 3:** Petición a las 21:00 del día 14 para el producto 35455 y la cadena 1 (ZARA).
- **Test 4:** Petición a las 10:00 del día 15 para el producto 35455 y la cadena 1 (ZARA).
- **Test 5:** Petición a las 21:00 del día 16 para el producto 35455 y la cadena 1 (ZARA).

## PriceControllerTests

Esta clase contiene pruebas unitarias para la clase PriceController. Incluye una prueba para el método `getPriceValue`, que prueba la solicitud GET al endpoint `/price/get-price`.

### Configuración

- Declaraciones de Autowired y MockBean para PriceController, PriceService, ProductService y BrandService.
- Objetos Price y un método de configuración para datos de prueba.
- Método de utilidad para crear objetos Price.

### Cómo Ejecutar

Ejecute las pruebas utilizando su marco de pruebas preferido.

## PricesServicesTests

Esta clase contiene pruebas unitarias para la clase PriceService. Incluye una prueba para el método `getPriceByDatesAndProductAndBrand`.

### Configuración

- Declaraciones de Mock e InjectMocks para PriceRepository y PriceService.

### Cómo Ejecutar

Ejecute las pruebas utilizando su marco de pruebas preferido.

## Tabla PRICES

La tabla PRICES contiene los siguientes campos relevantes:

- `BRAND_ID`: Clave foránea de la cadena del grupo (1 = ZARA).
- `START_DATE`, `END_DATE`: Rango de fechas en el que aplica el precio tarifa indicado.
- `PRICE_LIST`: Identificador de la tarifa de precios aplicable.
- `PRODUCT_ID`: Identificador del código de producto.
- `PRIORITY`: Desambiguador de aplicación de precios. Si dos tarifas coinciden en un rango de fechas, se aplica la de mayor prioridad (mayor valor numérico).
- `PRICE`: Precio final de venta.
- `CURR`: ISO de la moneda.

## Endpoint REST

El servicio expone un endpoint REST para consultar precios con los siguientes parámetros de entrada:

- `applicationDate`: Fecha de aplicación.
- `productId`: Identificador de producto.
- `brandId`: Identificador de cadena.

Los datos de salida incluyen:

- `productId`: Identificador de producto.
- `brandId`: Identificador de cadena.
- `priceList`: Tarifa a aplicar.
- `start_date`, `end_date`: Fechas de aplicación.
- `finalPrice`: Precio final a aplicar.

## Base de Datos en Memoria (H2)

Se utiliza una base de datos en memoria de tipo H2, inicializada con los datos del ejemplo. Se ha elegido el tipo de dato que se considera adecuado para cada campo.



