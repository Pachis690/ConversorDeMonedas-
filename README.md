# 💱 Conversor de Monedas en Java

### 👨‍💻 Autor: [Tu nombre aquí]  
### 🎓 Proyecto estudiantil en Java  
### 🗓️ Fecha: Mayo 2025

---

## ✅ Descripción del proyecto

Este programa es un **Conversor de monedas** hecho en Java que permite convertir entre:

- 🇺🇸 Dólar estadounidense (USD)  
- 🇲🇽 Peso mexicano (MXN)  
- 🇧🇷 Real brasileño (BRL)

Utiliza una API externa llamada **ExchangeRate-API** para obtener los valores de cambio actualizados.

---

## ⚙️ ¿Cómo funciona?

1. El usuario ingresa la moneda que **tiene** (por ejemplo, "USD").
2. Indica cuánto dinero tiene disponible.
3. Elige la moneda a la que desea convertir.
4. Ingresa cuánto desea cambiar.
5. El sistema muestra cuánto recibirá según la tasa actual.

---

## 📦 Tecnologías utilizadas

- **Java (JDK 8 o superior)**
- **Gson** (para procesar JSON)
- **ExchangeRate-API**: https://app.exchangerate-api.com/

---

## 📁 Estructura del proyecto
ConversorMonedas/
│
├── lib/
│ └── gson-2.8.9.jar # Librería externa
│
├── src/
│ ├── ConversorMonedas.java # Programa principal
│ └── TasaCambio.java # Clase para manejar la respuesta de la API


---

## ▶️ Cómo compilar y ejecutar

1. Asegúrate de tener Java instalado.
2. Descarga la librería `gson-2.8.9.jar` y colócala en la carpeta `lib/`.

### Compilar:

```bash
Compilar
javac -cp "lib/gson-2.8.9.jar" -d out src/*.java
Ejecutar:
java -cp "lib/gson-2.8.9.jar;out" ConversorMonedas
