import com.google.gson.annotations.SerializedName


data class WikiPage (
    val ns: Int,
    val title: String,
    @SerializedName("pageid")
    val pageId: Int,
    val size: Int,
    val wordCount: Int,
    val snippet: String,
    val timestamp: String
)