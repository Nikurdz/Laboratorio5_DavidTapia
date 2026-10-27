# Laboratorio 5.1: Primera Pantalla Declarativa

Validador de credenciales en tiempo real construido con Jetpack Compose para la asignatura Programación Móvil (Semestre VI), Ingeniería en Sistemas de Información, Pontificia Universidad Católica del Ecuador.

## Descripción

La aplicación tiene una sola pantalla, `LoginScreen`, sin archivos de diseño XML ni `findViewById`. Contiene:

- Un `OutlinedTextField` para escribir el nombre de usuario.
- Un mensaje que cambia de texto y de color según la longitud del nombre:
  - Menos de 3 caracteres: "Nombre muy corto (mín. 3)" en rojo.
  - 3 o más caracteres: "Nombre aceptado" en verde.
- Desafío extra: un botón "Continuar" que se habilita solo con 5 o más caracteres.

El estado `username` se define con `remember { mutableStateOf("") }`. Cuando cambia, Compose recompone los elementos que lo leen y la interfaz se actualiza sin llamar a `setText()`.

## Estructura

```
app/src/main/java/com/example/myapplication/
├── MainActivity.kt      # Activity (Edge-to-Edge) y composable LoginScreen
└── ui/theme/            # Color, Type y Theme de la plantilla
```

## Requisitos

- Android Studio con JBR 21
- Android SDK API 36 (emulador sugerido: Pixel 8)
- minSdk 24

## Cómo ejecutarlo

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/Nikurdz/Laboratorio5_DavidTapia.git
   ```
2. Abrir la carpeta en Android Studio y ejecutar **Sync Project with Gradle Files**.
3. Seleccionar un emulador o dispositivo y pulsar **Run**.

También se puede compilar desde la terminal:

```bash
./gradlew assembleDebug
```

## Autores

Alisson Basantes, Gloria Chugsig, Karol Moreno y David Tapia.

Docente: Juan Francisco Chafla Altamirano.
