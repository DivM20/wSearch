import java.net.*
import com.google.gson.*
import java.awt.Desktop

class wikiSearcher(var query: String) {

    var request = ""
    var pages:Array<WikiPage> = emptyArray()

    fun send_request(){
        val link = "https://ru.wikipedia.org/w/api.php?action=query&list=search&utf8=&format=json&srsearch=" + '"' + URLEncoder.encode(query,"utf-8") + '"'
        request = URL(link).readText()
    }

    fun parse(){
        var gson = Gson().fromJson(request,JsonObject::class.java).getAsJsonObject("query").get("search")
        pages = Gson().fromJson(gson,pages::class.java)

    }

    fun print_result(){
        var i = 1
        for(page in pages){
            println(i++.toString()+". " + page.title)
            println("Id: " + page.pageId.toString())
        }
    }

    fun open_page(){
        println("Enter page number: ")

        try{
            val n = readln().toInt()
            if(n < 1 || n > pages.size){
                println("Wrong Number")
                open_page()
            }else{
                Desktop.getDesktop().browse(URI("https://ru.wikipedia.org/w/index.php?curid=" + pages[n-1].pageId.toString()))
            }
        } catch (excep:Exception) {
            println(excep.message +", try again")
            open_page()
        }
    }

}