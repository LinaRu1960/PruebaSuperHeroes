package cl.eme.superheroes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/*
[X] 1. Crear un proyecto para Kotlin y definir el nombre de la app.
[X] 2. Agregar el permiso de Internet al manifiesto.
              [] HITO 1
[] Implementar base datos
    [] Usar ROOM
    [] Entidad para el personaje
    [] Usar DAO para gestion de datos y guarda la lista de personajes
    [] Creara Repositorio que se encarga de consumir la informacion desde una API

         []  PERSISTENCIA DE DATOS CON ROOM
[] 3. Dependencias :
      [X] Room
      [X] Retrofit
      [X] Coroutines
      [X] Glide
      [X] Debuggins
      [X] DataBinding
      [X] Kotlin

[] 4. Definir la Data Class de nombre SuperHeroCharacter (servira como entidad de la DB)
[] 5. Definir la interfaz Dao para obtener y guardar los personajes.
[] 6. Agregar la clase que extiende de RoomDatabase y que será construida por Room.databaseBuilder
[] 7. Crear la función getDatabase que permita obtener una instancia única de la BD. Una
       forma de hacerlo es usando el patrón Singleton, por ejemplo:

        [] CONSUMO DE API
[] 8. Agregar Retrofit como dependencia. Para convertir JSON una alternativa es utilizar
        Gson agregando la dependencia.
[] 9. Crear la interfaz para consumir la API REST que tiene los superhéroes. El endpoint que
        se va a utilizar es /all.json para obtener la lista completa de superhéroes.
[] 10.Crear la implementación para utilizar Retrofit. La forma recomendada es utilizar un
        factory que devuelve la instancia del servicio a utilizar. Por ejemplo:

        [] REPOSITORY
[] 11.Crear el repositorio (la clase que implementa el patrón Repository ) que permite
        acceder y actualizar los datos. Para esto se debe:
      [] Exponer la información de la DB usando DAO y LiveData.
      [] Una función que permita actualizar la lista de superheroes desde la API

              [] HITO 2
[] Con la información disponible vamos a enlazar la vista usando MVVM para desplegar una lista
   usando RecyclerView. El viewModel utiliza la información expuesta por el repositorio usando
   LiveData para poder notificar al adaptador con la información nueva.

            [] MVVM
[] 1. Crear el ViewModel extendiendo desde AndroidViewModel .
[] 2. El ViewModel accede a la información usando Repository, por lo que debe contener una
      instancia del repositorio.
[] 3. Al inicializarse el ViewModel debe llamar al repositorio para obtener la lista de superhéroes.
[] 4. El ViewModel guarda la lista de superhéroes que recupera desde el repositorio para ser
      consumida por la vista usando LiveData.

            [] VIEW
[] 5. Crear el layout para el ítem de la lista.
[] 6. Adaptar el layout principal agregando el RecyclerView.
[] 7. Crear el adaptador a utilizar en el RecyclerView (Adapter + ViewHolder) y asignarlo al
      RecyclerView.
[] 8. Usando el ViewModel, observar los cambios en la lista de superhéroes y actualizar el
      adaptador con la nueva información

            [] OPCIONALES
[]1. Al hacer click sobre un ítem de la lista desplegar el detalle del superhéroe.
[] 2. Agregar una imagen a cada ítem, modificando la clase SuperheroCharacter para que
        pueda leer de la API y almacenar en la DB las url de las imágenes.

 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}