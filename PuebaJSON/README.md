# Ejercicio de JSON con IntelliJ y Java

Este proyecto es una práctica para trabajar con archivos JSON en Java utilizando **IntelliJ IDEA** y el sistema de construcción **Maven**. El objetivo es aprender a leer, escribir, validar y manipular datos JSON como objetos en Java.

## Contenido del Proyecto

### Archivos Principales
1. **`pom.xml`**:
    - Archivo de configuración de Maven para incluir la dependencia de la librería JSON.

2. **`datosUsuario.json`**:
    - Archivo JSON que contiene información de ejemplo sobre una persona ficticia llamada **Yennefer**.

3. **`MiLectorJson.java`**:
    - Clase Java principal para leer y procesar el archivo JSON.

### JSON de Ejemplo
```json
{
  "nombre": "Yennefer",
  "apellido": "of Vengerberg",
  "edad": 28,
  "ciudad": "Madrid",
  "educación": {
    "universidad": "Universidad Francisco de Vitoria",
    "carrera": "Ingeniería Informática",
    "añoGraduación": 2017
  },
  "trabajos": [
    {
      "empresa": "TechCorp",
      "puesto": "Desarrolladora Junior",
      "añoInicio": 2017,
      "añoFin": 2019
    },
    {
      "empresa": "DevSolutions",
      "puesto": "Desarrolladora Senior",
      "añoInicio": 2019,
      "añoFin": "Actualidad"
    }
  ],
  "habilidades": ["Java", "Python", "SQL", "React"]
}
