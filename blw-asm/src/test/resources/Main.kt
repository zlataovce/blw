import com.sun.net.httpserver.HttpExchange
import com.sun.net.httpserver.HttpServer
import com.sun.net.httpserver.spi.HttpServerProvider
import java.io.InputStream
import java.io.OutputStream
import java.net.InetSocketAddress

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        print("Missing port")
        return
    }
    val portInput = args[0]
    try {
        val port = portInput.toInt()
        spinUp(port)?.apply {
            createContext("/example") {
                val stream: InputStream = it.getRequestBody()
                val content: ByteArray = stream.readAllBytes()
                if (content.size <= 4) {
                    reply(405, "Not big enough", it)
                } else {
                    val prefix: String = content.toString(Charsets.ISO_8859_1).dropLast(content.size - 4)
                    reply(200, "Prefix=$prefix", it)
                }
            }
        }
    } catch (e: NumberFormatException) {
        print("Invalid port: '$portInput'")
    }
}

private fun reply(code: Int, msg: String, it: HttpExchange) {
    it.sendResponseHeaders(code, msg.length.toLong())
    val os: OutputStream = it.getResponseBody()
    os.write(msg.toByteArray())
    os.close()
}

private fun spinUp(port: Int): HttpServer? {
    val addr = InetSocketAddress(port)
    val server = HttpServerProvider.provider().createHttpServer(addr, 0)
    server.executor = null
    return server
}
