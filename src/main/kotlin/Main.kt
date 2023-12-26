fun main(args: Array<String>) {

    println("Enter Search query:")
    var query = readln()
    while (query == " " || query == ""){
        println("Wrong input")
        query = readln()
    }

    var wikiSearcher = wikiSearcher(query)

    wikiSearcher.send_request()
    wikiSearcher.parse()
    wikiSearcher.print_result()

    wikiSearcher.open_page()

}