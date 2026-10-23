# 🏃 CarreraHilosSwing

Aplicación de escritorio desarrollada en **Java Swing** que simula una carrera atlética utilizando **hilos concurrentes**. Cada corredor participa en su propio hilo de ejecución, recibe un tiempo aleatorio y aparece en la clasificación conforme finaliza la carrera.

El proyecto fue creado como parte de la asignatura **Tópicos Avanzados de Programación**, con enfoque en el uso de hilos, sincronización y componentes gráficos en Java.

![Java](https://img.shields.io/badge/Java-17-orange?logo=openjdk&logoColor=white)
![Swing](https://img.shields.io/badge/GUI-Java%20Swing-blue)
![Substance](https://img.shields.io/badge/Look%20%26%20Feel-Substance%204.3-purple)
![Estado](https://img.shields.io/badge/Estado-funcional-success)

## 📋 Tabla de contenidos

- [Descripción](#-descripción)
- [Características](#-características)
- [Tecnologías utilizadas](#-tecnologías-utilizadas)
- [Estructura del proyecto](#-estructura-del-proyecto)
- [Requisitos](#-requisitos)
- [Instalación](#-instalación)
- [Ejecución](#-ejecución)
- [Cómo utilizar la aplicación](#-cómo-utilizar-la-aplicación)
- [Funcionamiento técnico](#-funcionamiento-técnico)
- [Consideraciones](#-consideraciones)
- [Posibles mejoras](#-posibles-mejoras)
- [Autor](#-autor)

## 🎯 Descripción

**CarreraHilosSwing** es una interfaz gráfica que permite registrar hasta cinco corredores y ejecutar una carrera simulada. Al iniciar la competencia, cada participante se ejecuta de forma independiente mediante un hilo.

El tiempo de cada corredor se genera aleatoriamente al momento de registrarlo. Cuando un hilo termina su ejecución, el corredor se agrega automáticamente a la clasificación según su orden de llegada.

La aplicación permite observar de forma práctica conceptos como:

- Creación y ejecución de hilos.
- Ejecución concurrente de tareas.
- Coordinación segura de un contador compartido.
- Actualización de componentes Swing desde hilos secundarios.
- Control de estados de una interfaz gráfica.
- Reinicio y cancelación de una simulación.

## ✨ Características

- Registro de un máximo de **5 corredores**.
- Validación de nombres con formato de una sola palabra iniciada en mayúscula, por ejemplo: `Luffy`.
- Prevención de nombres duplicados.
- Asignación automática de un tiempo aleatorio entre **0 y 30 segundos**.
- Ejecución concurrente de cada corredor mediante un hilo independiente.
- Clasificación automática por orden de llegada.
- Interfaz gráfica construida con Java Swing.
- Apariencia visual basada en **Substance Office Blue 2007**.
- Botones para iniciar, reiniciar y terminar la carrera.
- Cancelación de los corredores activos al reiniciar la simulación.

## 🛠️ Tecnologías utilizadas

| Tecnología | Uso |
|---|---|
| **Java 17** | Lenguaje y plataforma de ejecución. |
| **Java Swing** | Construcción de la interfaz gráfica de escritorio. |
| **Java Threads** | Ejecución concurrente de los corredores. |
| **`Runnable`** | Definición de la tarea ejecutada por cada hilo. |
| **`AtomicInteger`** | Control seguro del orden de llegada compartido entre hilos. |
| **Substance 4.3** | Tema visual personalizado para la aplicación. |
| **IntelliJ IDEA** | Entorno de desarrollo utilizado para organizar y ejecutar el proyecto. |

La dependencia `substance-4.3.jar` se encuentra incluida localmente en el directorio `CarreraAtletica/lib`.

## 📁 Estructura del proyecto

```text
CarreraHilosSwing/
├── CarreraAtletica/
│   ├── lib/
│   │   └── substance-4.3.jar
│   ├── src/
│   │   └── main/
│   │       └── java/
│   │           └── com/
│   │               └── si3ri/
│   │                   ├── IniciarCarrera.java
│   │                   └── interfaces/
│   │                       ├── AthleticRaceInterface.java
│   │                       ├── Runner.java
│   │                       └── ThreadRunner.java
│   ├── .idea/
│   └── Carrera.iml
├── .gitignore.txt
├── CarreraHilosSwing.iml
└── README.md
```

### Clases principales

- **`IniciarCarrera`**: punto de entrada de la aplicación. Configura el tema visual Substance e inicia la ventana principal.
- **`AthleticRaceInterface`**: administra la ventana, los controles, el registro de corredores y las acciones de la carrera.
- **`Runner`**: representa a un corredor, incluyendo su nombre, tiempo asignado y estado de ejecución.
- **`ThreadRunner`**: implementa `Runnable` y controla la ejecución concurrente de cada corredor.

## 💻 Requisitos

Antes de instalar el proyecto, asegúrate de contar con:

- **JDK 17** o una versión compatible.
- **IntelliJ IDEA** — recomendado para abrir el proyecto, aunque también puede ejecutarse desde la terminal.
- Sistema operativo con soporte para aplicaciones Java de escritorio.
- La dependencia `substance-4.3.jar`, incluida en el repositorio.

Comprueba la instalación de Java con:

```bash
java -version
javac -version
```

Ambos comandos deberían mostrar una versión 17 o superior.

## 📥 Instalación

### Opción 1: Clonar el repositorio

```bash
git clone https://github.com/MarioSi3ri/CarreraHilosSwing.git
cd CarreraHilosSwing
```

### Opción 2: Descargar el proyecto

1. Accede al repositorio en GitHub.
2. Selecciona **Code → Download ZIP**.
3. Descomprime el archivo en una ubicación local.
4. Abre la carpeta `CarreraHilosSwing`.

## ▶️ Ejecución con IntelliJ IDEA

1. Abre **IntelliJ IDEA**.
2. Selecciona **Open** y elige la carpeta raíz del proyecto.
3. Verifica que el SDK configurado sea **JDK 17**.
4. Comprueba que la biblioteca `substance-4.3.jar` esté disponible en:

   ```text
   CarreraAtletica/lib/substance-4.3.jar
   ```

5. Abre el archivo `IniciarCarrera.java`.
6. Ejecuta el método `main` mediante el botón **Run**.

La clase principal completamente cualificada es:

```text
main.java.com.si3ri.IniciarCarrera
```

## 🧰 Ejecución desde la terminal

Desde la raíz del repositorio, crea un directorio para los archivos compilados:

```bash
mkdir -p CarreraAtletica/out
```

### Linux o macOS

```bash
javac -cp "CarreraAtletica/lib/substance-4.3.jar" \
      -d CarreraAtletica/out \
      $(find CarreraAtletica/src -name "*.java")

java -cp "CarreraAtletica/out:CarreraAtletica/lib/substance-4.3.jar" \
     main.java.com.si3ri.IniciarCarrera
```

### Windows PowerShell

```powershell
New-Item -ItemType Directory -Force CarreraAtletica/out

$archivos = Get-ChildItem -Recurse CarreraAtletica/src -Filter *.java
javac -cp "CarreraAtletica/lib/substance-4.3.jar" -d CarreraAtletica/out $archivos.FullName

java -cp "CarreraAtletica/out;CarreraAtletica/lib/substance-4.3.jar" main.java.com.si3ri.IniciarCarrera
```

> **Nota:** En Windows, el separador del classpath es `;`. En Linux y macOS es `:`.

## 🕹️ Cómo utilizar la aplicación

1. **Registrar corredores**
   - Escribe un nombre válido en el campo de texto.
   - Utiliza el formato de una sola palabra con la primera letra en mayúscula, por ejemplo: `Ana`, `Luffy` o `Carlos`.
   - Presiona **Registrar**.
   - Repite el proceso hasta registrar cinco corredores.

2. **Iniciar la carrera**
   - Cuando haya cinco corredores registrados, presiona **Iniciar**.
   - La aplicación deshabilitará el registro mientras la carrera esté en curso.
   - Cada corredor comenzará a ejecutarse en un hilo independiente.

3. **Consultar los resultados**
   - Los corredores aparecerán en el área de resultados conforme terminen.
   - La clasificación mostrará la posición, el nombre y el tiempo de cada corredor.

4. **Reiniciar la carrera**
   - Presiona **Reiniciar** para detener los hilos activos y limpiar los datos.
   - Después podrás registrar un nuevo grupo de corredores.

5. **Terminar la aplicación**
   - Presiona **Terminar** para cerrar la ventana y finalizar el programa.

## ⚙️ Funcionamiento técnico

Cada corredor se instancia con un tiempo aleatorio entre 0 y 30 segundos. Al iniciar la carrera, la aplicación crea un objeto `ThreadRunner` para cada corredor y lo ejecuta mediante un nuevo hilo:

```java
new Thread(new ThreadRunner(runners[i], cajaResultados)).start();
```

`ThreadRunner` simula el avance del corredor mediante pausas periódicas. Cuando el corredor termina, obtiene una posición usando un `AtomicInteger`:

```java
int ordenLlegada = contadorPosiciones.getAndIncrement();
```

La actualización del área de resultados se programa en el hilo de eventos de Swing utilizando `SwingUtilities.invokeLater`, evitando modificar directamente la interfaz desde un hilo secundario.

## ⚠️ Consideraciones

- La carrera requiere exactamente **cinco corredores** para poder iniciar.
- Los nombres deben cumplir el patrón configurado por la aplicación: una sola palabra, comenzando con mayúscula.
- El tiempo de cada corredor es aleatorio, por lo que el resultado cambia en cada ejecución.
- La dependencia visual Substance se carga desde el archivo local `substance-4.3.jar`.
- Si la biblioteca no está disponible o no se incluye en el classpath, la aplicación no podrá cargar correctamente el tema visual.
- El proyecto utiliza archivos de configuración de IntelliJ IDEA, aunque también puede compilarse desde la terminal.

## 🚀 Posibles mejoras

Algunas ideas para ampliar el proyecto son:

- Permitir configurar el número de corredores desde la interfaz.
- Mostrar una barra de progreso individual para cada corredor.
- Añadir una pista visual o animación para representar la carrera.
- Incorporar pausas y reanudación de la competencia.
- Utilizar `ExecutorService` en lugar de crear hilos manualmente.
- Evitar bloqueos de la interfaz durante el reinicio.
- Agregar pruebas automatizadas para la validación de nombres y la lógica de clasificación.
- Incorporar un sistema de puntuaciones o historial de carreras.
- Migrar la dependencia Substance a un sistema de gestión como Maven o Gradle.

## 👤 Autor

Desarrollado por **MarioSi3ri** como proyecto académico para la asignatura **Tópicos Avanzados de Programación** de la **UVEG**.

- GitHub: [@MarioSi3ri](https://github.com/MarioSi3ri)
- Repositorio: [CarreraHilosSwing](https://github.com/MarioSi3ri/CarreraHilosSwing)

## 📄 Licencia

Este repositorio no declara actualmente una licencia de código abierto. Si deseas reutilizar, modificar o distribuir el proyecto, consulta primero con el autor.

---

<p align="center">
  Hecho con ☕ y Java Swing
</p>
