import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

val coroutineScope = CoroutineScope(Dispatchers.Default)

suspend fun getRandom(): Int{
    println("Начало работы корутины async")
    delay(1000)
    println("Конец работы корутины async")
    return Random.nextInt(1000)
}

fun main() = runBlocking {
    println("Начало работы main")
    val result = async {
        getRandom()
    }
    launch {
        println("Начало работы корутины launch 1")
        delay(500)
        println("Конец работы корутины launch 1")
    }
    coroutineScope.launch {
        println("Начало работы корутины launch 2")
        delay(700)
        println("Конец работы корутины launch 2")
    }
    delay(100)
    println(result.await())
    println("Конец работы main")
}